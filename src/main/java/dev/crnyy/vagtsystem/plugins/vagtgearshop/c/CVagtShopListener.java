package dev.crnyy.vagtsystem.plugins.vagtgearshop.c;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.chat.Chat;
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
import org.bukkit.inventory.ItemStack;

public class CVagtShopListener implements Listener {

    private Main plugin;
    private Messages messages;
    private Config config;
    public CVagtShopListener(Main plugin, Messages messages, Config config) {
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
        if (topInventory.getName().equals("Vagt Shop")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("Vagt Shop")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            switch (e.getCurrentItem().getType()) {
                case GOLD_HELMET:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lHJELM")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.C.helmet");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.cHelmetMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.cHelmet(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("hjelm", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Hjelm", price)));
                            }
                        }
                    }
                    break;
                case IRON_CHESTPLATE:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lBRYSTPLADE")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.C.chestplate");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.cChestplateMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.cChestplate(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("brystplade", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Brystplade", price)));
                            }
                        }
                    }
                    break;
                case IRON_LEGGINGS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lBUKSER")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.C.legs");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.cLeggingsMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.cLeggings(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("Bukser", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Bukser", price)));
                            }
                        }
                    }
                    break;
                case IRON_BOOTS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSKO")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.C.boots");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.cBootsMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.cBoots(player));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("Sko", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("Sko", price)));
                            }
                        }
                    }
                    break;
                case IRON_SWORD:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSVÆRD")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.C.sword");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.cSwordMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.cSword(player));
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
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lBUE")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.C.bow");
                            if (balance >= price) {
                                am.player = player.getName();
                                am.cBowMap.put(player.getUniqueId(), 0);
                                player.getInventory().addItem(am.cBow(player));
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
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lPIND")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.C.stick");
                            if (balance >= price) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cStick(player, "C"));
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
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lMAD")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.C.food");
                            if (balance >= price) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cFood(player, "C"));
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
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lPILE")) {
                            e.setCancelled(true);
                            int price = config.getConfig().getInt("Vagtshop.C.arrow");
                            if (balance >= price) {
                                am.player = player.getName();
                                player.getInventory().addItem(am.cArrows(player, "C"));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopBuyedItem("16x Arrow", price)));
                                economy.withdrawPlayer(player, price);
                            } else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtshopNoMoney("16x Arrow", price)));
                            }
                        }
                    }
                    break;
            }
        }
    }

}
