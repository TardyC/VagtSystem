package dev.crnyy.vagtsystem;

import dev.crnyy.vagtsystem.commands.VagtCommand;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.signs.HealSign;
import dev.crnyy.vagtsystem.plugins.vagtbuffs.VagtBuffs;
import dev.crnyy.vagtsystem.plugins.vagtcoins.VagtCoinsListener;
import dev.crnyy.vagtsystem.plugins.vagtcoins.VagtCoinsMenu;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.SignManager;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Data;
import dev.crnyy.vagtsystem.placeholders.PlaceholderAPI;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.plugins.repair.Repair;
import dev.crnyy.vagtsystem.plugins.vagtchat.VagtChat;
import dev.crnyy.vagtsystem.plugins.vagtchat.VagtChatCommand;
import dev.crnyy.vagtsystem.plugins.vagtcoins.VagtCoinsCommand;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.a.AVagtShopListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.b.BVagtShopListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.a.AVagtEnchantItemsListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.a.AVagtEnchantListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.b.BVagtEnchantItems;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.b.BVagtEnchantItemsListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.b.BVagtEnchantListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantItems;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantItemsListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.c.CVagtShopListener;
import dev.crnyy.vagtsystem.plugins.vagtkiste.VagtKiste;
import dev.crnyy.vagtsystem.plugins.vagtkiste.VagtKisteCommand;
import dev.crnyy.vagtsystem.plugins.vagtkiste.VagtKisteStatus;
import dev.crnyy.vagtsystem.plugins.vagtlevel.*;
import dev.crnyy.vagtsystem.plugins.vagtmenu.VagtMenuListener;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMine;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMineCommand;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtOntime;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtOntimeCommand;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtOntimeListener;
import dev.crnyy.vagtsystem.plugins.vagtpay.VagtPayListener;
import dev.crnyy.vagtsystem.plugins.vagtwarps.SignManagerWarp;
import dev.crnyy.vagtsystem.plugins.vagtwarps.VagtWarpMenuListener;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Economy economy;
    private Config config;
    private Message message;


    @Override
    public void onEnable() {
        PlayerManager manager = new PlayerManager();
        if (!setupEconomy() ) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new PlaceholderAPI(this, manager).register();
        }

        this.config = new Config(this);
        this.message = new Message(this);

        listeners();
        commands();

        loadDataFile();
    }

    @Override
    public void onDisable() {

        saveDataFile();
        config.saveConfig();
        message.saveConfig();
    }


    private boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    private void listeners() {
        PlayerManager manager = new PlayerManager();
        Messages messages = new Messages(message);
        this.config = config;
        this.message = message;

        //Vagt
        this.getServer().getPluginManager().registerEvents(new SignManager(message, config), this);
        this.getServer().getPluginManager().registerEvents(new VagtMenuListener(), this);

        //VagtGearShop og EnchantShop
        this.getServer().getPluginManager().registerEvents(new CVagtShopListener(this, new Messages(message), config), this);
        this.getServer().getPluginManager().registerEvents(new CVagtEnchantListener(), this);
        this.getServer().getPluginManager().registerEvents(new CVagtEnchantItemsListener(new ArmorManager(), config, messages, new CVagtEnchantItems()), this);
        this.getServer().getPluginManager().registerEvents(new BVagtEnchantListener(), this);
        this.getServer().getPluginManager().registerEvents(new BVagtEnchantItemsListener(new ArmorManager(), config, messages, new CVagtEnchantItems()), this);
        this.getServer().getPluginManager().registerEvents(new BVagtShopListener(this, new Messages(message), config), this);


        this.getServer().getPluginManager().registerEvents(new AVagtShopListener(this, new Messages(message), config), this);
        this.getServer().getPluginManager().registerEvents(new AVagtEnchantItemsListener(new ArmorManager(), config, messages, new CVagtEnchantItems()), this);
        this.getServer().getPluginManager().registerEvents(new AVagtEnchantListener(), this);

        //VagtChat
        this.getServer().getPluginManager().registerEvents(new VagtChat(messages), this);

        //VagtLevel
        this.getServer().getPluginManager().registerEvents(new VagtLevel(manager, new VagtLevelQuests()), this);
        this.getServer().getPluginManager().registerEvents(new VagtLevelListener(), this);

        //VagtOntime
        this.getServer().getPluginManager().registerEvents(new VagtOntime(this), this);
        this.getServer().getPluginManager().registerEvents(new VagtOntimeListener(), this);

        //Repair
        this.getServer().getPluginManager().registerEvents(new Repair(config, message, new Messages(message)), this);

        //VagtBuffs
        this.getServer().getPluginManager().registerEvents(new VagtBuffs(config, message), this);

        //Signs
        this.getServer().getPluginManager().registerEvents(new HealSign(config, message), this);

        //VagtKiste
        this.getServer().getPluginManager().registerEvents(new VagtKiste(config, message), this);
        this.getServer().getPluginManager().registerEvents(new VagtKisteStatus(config, message), this);

        //Vagt Warps
        this.getServer().getPluginManager().registerEvents(new VagtWarpMenuListener(),this);
        this.getServer().getPluginManager().registerEvents(new SignManagerWarp(message), this);

        //Vagt Løn
        this.getServer().getPluginManager().registerEvents(new VagtPayListener(), this);

        //Vagt Coins
        this.getServer().getPluginManager().registerEvents(new VagtCoinsListener(), this);
    }

    private void commands() {
        PlayerManager manager = new PlayerManager();
        Messages messages = new Messages(message);

        //Vagt
        this.getCommand("vagt").setExecutor(new VagtCommand(config, message));

        //VagtChat
        this.getCommand("vagtchat").setExecutor(new VagtChatCommand());

        //VagtLevel
        this.getCommand("vagtlevel").setExecutor(new VagtLevelCommand(manager));
        this.getCommand("irons").setExecutor(new TestCommand(new VagtLevelQuests()));

        //VagtMine
        this.getCommand("spassermine").setExecutor(new VagtMineCommand(new VagtMine(), config));

        //VagtCoins
        this.getCommand("vagtcoins").setExecutor(new VagtCoinsCommand(manager, new VagtCoinsMenu()));

        //VagtOntime
        VagtOntime ontime = new VagtOntime(this);
        this.getCommand("ontime").setExecutor(new VagtOntimeCommand(this, ontime));

        //VagtKiste
        this.getCommand("vagtkiste").setExecutor(new VagtKisteCommand());
    }

    public static Economy getEconomy() {

        return economy;
    }

    public void loadDataFile() {
        Data.setup();
    }

    public void saveDataFile() {
        Data.save();
    }

}
