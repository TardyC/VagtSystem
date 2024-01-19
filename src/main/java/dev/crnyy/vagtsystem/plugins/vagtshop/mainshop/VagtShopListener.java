package dev.crnyy.vagtsystem.plugins.vagtshop.mainshop;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.vagtmenu.VagtMenu;
import dev.crnyy.vagtsystem.plugins.vagtshop.pvshop.menu.PvShop;
import dev.crnyy.vagtsystem.plugins.vagtshop.warp.warpmenu.MainWarp;
import dev.crnyy.vagtsystem.utils.Messages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class VagtShopListener implements Listener {
    private Config config;
    private Message message;
    private Messages messages;
    private Main main;
    public VagtShopListener(Config config, Message message, Messages messages, Main main) {
        this.config = config;
        this.message = message;
        this.messages = messages;
        this.main = main;
    }
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
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
        if (topInventory.getName().equals("§6§lVAGT§f§l SHOP")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l SHOP")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                VagtMenu menu = new VagtMenu();
                menu.openInventory(player);
            }
            if (e.getSlot() == 19) {
                MainWarp menu = new MainWarp(config, new Messages(message), message);
                menu.openInventory(player);
            }
            if (e.getSlot() == 21) {
                PvShop menu = new PvShop(config, new Messages(message), message);
                menu.openInventory(player);
            }
        }
    }
}
