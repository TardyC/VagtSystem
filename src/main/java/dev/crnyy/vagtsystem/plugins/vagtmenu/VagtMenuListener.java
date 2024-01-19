package dev.crnyy.vagtsystem.plugins.vagtmenu;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.plugins.vagtcoins.VagtCoinsMenu;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelMenu;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelQuests;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtMenuOntime;
import dev.crnyy.vagtsystem.plugins.vagtpay.VagtPayMenu;
import dev.crnyy.vagtsystem.plugins.vagtshop.mainshop.VagtShopMenu;
import dev.crnyy.vagtsystem.plugins.vagtwarps.StartVagtMenu;
import dev.crnyy.vagtsystem.utils.Messages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class VagtMenuListener implements Listener {
    private Config config;
    private Messages messages;
    private Message message;
    public VagtMenuListener(Config config, Messages messages, Message message) {
        this.config = config;
        this.messages = messages;
        this.message = message;

    }
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final ArmorManager am = new ArmorManager();
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
        if (view == null) {
            return;
        }
        if (player == null) {
            return;
        }
        if (e.getClickedInventory() == null) {
            return;
        }
        if (topInventory == null) {
            return;
        }
        if (topInventory.getName().equals("§6§lVAGT §f§lMENU§7 - Hovedemenu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT §f§lMENU§7 - Hovedemenu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);

            }
            if (e.getSlot() == 22) {
                StartVagtMenu menu = new StartVagtMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 20) {
                VagtPayMenu vmenu = new VagtPayMenu();
                vmenu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 25) {
                VagtCoinsMenu menu = new VagtCoinsMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 19) {
                VagtLevelMenu menu = new VagtLevelMenu(new PlayerManager(), new VagtLevelQuests());
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 21) {
                VagtMenuOntime menu = new VagtMenuOntime();
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 24) {
                VagtShopMenu menu = new VagtShopMenu(config, new Messages(message), message);
                menu.openInventory(player);
                e.setCancelled(true);
            }

        }
    }

}
