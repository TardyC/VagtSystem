package dev.crnyy.vagtsystem;

import dev.crnyy.vagtsystem.commands.VagtCommand;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.signs.HealSign;
import dev.crnyy.vagtsystem.plugins.vagtbuffs.VagtBuffs;
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
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.CVagtEnchantItems;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.CVagtEnchantItemsListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.CVagtEnchantListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.CVagtShopListener;
import dev.crnyy.vagtsystem.plugins.vagtlevel.TestCommand;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevel;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelCommand;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelQuests;
import dev.crnyy.vagtsystem.plugins.vagtmenu.VagtMenuListener;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMine;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMineCommand;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtOntime;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtOntimeCommand;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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

        Messages messages = new Messages(message);

        this.getServer().getPluginManager().registerEvents(new SignManager(), this);
        this.getCommand("vagt").setExecutor(new VagtCommand(config));

        //VagtGearShop og EnchantShop
        this.getServer().getPluginManager().registerEvents(new CVagtShopListener(this, new Messages(message)), this);
        this.getServer().getPluginManager().registerEvents(new CVagtEnchantListener(), this);
        this.getServer().getPluginManager().registerEvents(new CVagtEnchantItemsListener(new ArmorManager(), config, new CVagtEnchantItems()), this);

        //VagtChat
        this.getServer().getPluginManager().registerEvents(new VagtChat(messages), this);
        this.getCommand("vagtchat").setExecutor(new VagtChatCommand());

        //VagtLevel
        this.getServer().getPluginManager().registerEvents(new VagtLevel(manager, new VagtLevelQuests()), this);
        this.getCommand("vagtlevel").setExecutor(new VagtLevelCommand(manager));
        this.getCommand("irons").setExecutor(new TestCommand(new VagtLevelQuests()));

        //VagtMine
        this.getCommand("spassermine").setExecutor(new VagtMineCommand(new VagtMine(), config));

        //VagtCoins
        this.getCommand("vagtcoins").setExecutor(new VagtCoinsCommand(manager, new VagtCoinsMenu()));

        //VagtOntime
        VagtOntime ontime = new VagtOntime(this);
        this.getCommand("ontime").setExecutor(new VagtOntimeCommand(this, ontime));
        this.getServer().getPluginManager().registerEvents(ontime, this);

        //Repair
        this.getServer().getPluginManager().registerEvents(new Repair(config, message, new Messages(message)), this);

        //VagtBuffs
        this.getServer().getPluginManager().registerEvents(new VagtBuffs(config, message), this);

        //Signs
        this.getServer().getPluginManager().registerEvents(new HealSign(config, message), this);



        //Files
        loadDataFile();
    }

    @Override
    public void onDisable() {

        saveDataFile();
        config.saveConfig();
    }

    private boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
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
