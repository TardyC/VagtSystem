package dev.crnyy.vagtsystem.plugins.vagtgearshop.a;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class AVagtShopListener implements Listener {

    private Main plugin;
    private Messages messages;
    private Config config;
    public AVagtShopListener(Main plugin, Messages messages, Config config) {
        this.plugin = plugin;
        this.messages = messages;
        this.config = config;
    }

    private Economy economy = Main.economy;

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final double balance = economy.getBalance(player);
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
        if (topInventory.getName().equals("Vagt Shop A")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("Vagt Shop A")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            switch (e.getCurrentItem().getType()) {
                case GOLD_HELMET:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lHJELM")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.A.helmet");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.aHelmetMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aHelmet(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("hjelm", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(messages.vagtshopNoMoney("hjelm", price));
                            }
                        }
                    }
                    break;
                case DIAMOND_CHESTPLATE:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBRYSTPLADE")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.A.chestplate");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.aChestplateMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aChestplate(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("Brystplade", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Brystplade", price)));
                            }
                        }
                    }
                    break;
                case DIAMOND_LEGGINGS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBUKSER")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.A.legs");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.aLeggingsMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aLeggings(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("Bukser", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Bukser", price)));
                            }
                        }
                    }
                    break;
                case DIAMOND_BOOTS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSKO")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.A.boots");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.aBootsMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aBoots(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("Sko", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Sko", price)));
                            }
                        }
                    }
                    break;
                case DIAMOND_SWORD:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSVÆRD")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.A.sword");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.aSwordMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aSword(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("Sværd", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Sværd", price)));
                            }
                        }
                    }
                    break;
                case BOW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBUE")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.A.bow");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.aBowMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.aBow(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("Bue", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Bue", price)));
                            }
                        }
                    }
                    break;
                case STICK:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lPIND")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.A.stick");
                            if (balance >= price) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cStick(player, "A"));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("Stick", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Stick", price)));
                            }
                        }
                    }
                    break;
                case GRILLED_PORK:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lMAD")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.A.food");
                            if (balance >= price) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cFood(player, "A"));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("16x Mad", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("16x Mad", price)));
                            }
                        }
                    }
                    break;
                case ARROW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lPILE")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.A.arrow");
                            if (balance >= price) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cArrows(player, "A"));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("16x Pile", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("16x Pile", price)));
                            }
                        }
                    }
                    break;
            }
        }
    }

}
