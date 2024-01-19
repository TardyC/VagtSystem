package dev.crnyy.vagtsystem.plugins.vagtshop.warp.warplistener;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.vagtshop.warp.warpmenu.AWarpShop;
import dev.crnyy.vagtsystem.plugins.vagtshop.warp.warpmenu.BWarpShop;
import dev.crnyy.vagtsystem.plugins.vagtshop.warp.warpmenu.CWarpShop;
import dev.crnyy.vagtsystem.plugins.vagtshop.mainshop.VagtShopMenu;
import dev.crnyy.vagtsystem.utils.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class MainWarpListener implements Listener {
    private Config config;
    private Message message;
    private Messages messages;

    public MainWarpListener(Config config, Message message, Messages messages) {
        this.config = config;
        this.message = message;
        this.messages = messages;
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
        if (topInventory.getName().equals("§6§lVAGT§f§l WARPSHOP")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARPSHOP")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                VagtShopMenu menu = new VagtShopMenu(config, new Messages(message), message);
                menu.openInventory(player);
            }
            if (e.getSlot() == 19) {
                CWarpShop menu = new CWarpShop(config, new Messages(message), message);
                menu.openInventory(player);
            }
            if (e.getSlot() == 22) {
                if (player.hasPermission("BVagt")) {
                    BWarpShop menu = new BWarpShop(config, new Messages(message), message);
                    menu.openInventory(player);

                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lVAGT&f&l SYSTEM &7Du har ikke &4&nAdgang"));
                }
            }
            if (e.getSlot() == 25) {
                if (player.hasPermission("AVagt")) {
                    AWarpShop menu = new AWarpShop(config, new Messages(message), message);
                    menu.openInventory(player);

                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lVAGT&f&l SYSTEM &7Du har ikke &4&nAdgang"));
                }
            }
        }
    }
}

