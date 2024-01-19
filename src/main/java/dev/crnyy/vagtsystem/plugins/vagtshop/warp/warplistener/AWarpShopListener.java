package dev.crnyy.vagtsystem.plugins.vagtshop.warp.warplistener;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.vagtshop.warp.warpmenu.MainWarp;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class AWarpShopListener  implements Listener {
    private Config config;
    private Message message;
    private Messages messages;

    public AWarpShopListener(Config config, Message message, Messages messages) {
        this.config = config;
        this.message = message;
        this.messages = messages;
    }
    private Economy economy = Main.economy;
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final double balance = economy.getBalance(player);
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
        if (topInventory.getName().equals("§6§lVAGT§f§l WARPSHOP - §A§lA")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARPSHOP - §A§lA")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                MainWarp menu = new MainWarp(config, new Messages(message), message);
                menu.openInventory(player);
            }
            if (e.getSlot() == 19) {
                int price = config.getConfig().getInt("VagtWarpShop.A.VagtWarp2");
                if (!player.hasPermission("AVagtWarp2")) {
                    if (balance >= price) {
                        economy.withdrawPlayer(player, price);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set AVagtWarp2");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtWarpBuyed(config.getConfig().getString("VagtWarp.A.VagtWarp2"), price)));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtWarpNoMoney(config.getConfig().getString("VagtWarp.A.VagtWarp2"), price)));
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lVAGT &f&lSYSTEM &7Du har allerede købt denne"));
                }
            }
            if (e.getSlot() == 21) {
                int price = config.getConfig().getInt("VagtWarpShop.A.VagtWarp3");
                if (!player.hasPermission("AVagtWarp3")) {
                    if (balance >= price) {
                        economy.withdrawPlayer(player, price);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set AVagtWarp3");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtWarpBuyed(config.getConfig().getString("VagtWarp.A.VagtWarp3"), price)));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtWarpNoMoney(config.getConfig().getString("VagtWarp.A.VagtWarp3"), price)));
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lVAGT &f&lSYSTEM &7Du har allerede købt denne"));
                }
            }
            if (e.getSlot() == 23) {
                int price = config.getConfig().getInt("VagtWarpShop.A.VagtWarp4");
                if (!player.hasPermission("AVagtWarp4")) {
                    if (balance >= price) {
                        economy.withdrawPlayer(player, price);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set AVagtWarp4");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtWarpBuyed(config.getConfig().getString("VagtWarp.A.VagtWarp4"), price)));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtWarpNoMoney(config.getConfig().getString("VagtWarp.A.VagtWarp4"), price)));
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lVAGT &f&lSYSTEM &7Du har allerede købt denne"));
                }
            }
            if (e.getSlot() == 25) {
                int price = config.getConfig().getInt("VagtWarpShop.A.VagtWarp5");
                if (!player.hasPermission("AVagtWarp5")) {
                    if (balance >= price) {
                        economy.withdrawPlayer(player, price);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set AVagtWarp5");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtWarpBuyed(config.getConfig().getString("VagtWarp.A.VagtWarp5"), price)));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtWarpNoMoney(config.getConfig().getString("VagtWarp.A.VagtWarp5"), price)));
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lVAGT &f&lSYSTEM &7Du har allerede købt denne"));
                }
            }
        }
    }
}

