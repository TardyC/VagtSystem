package dev.crnyy.vagtsystem.plugins.vagtshop.pvshop.listener;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.vagtshop.mainshop.VagtShopMenu;
import dev.crnyy.vagtsystem.plugins.vagtshop.pvshop.menu.PvShop;
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

public class PvShopListener  implements Listener {

    private Config config;
    private Message message;
    private Messages messages;
    private Main main;

    public PvShopListener(Config config, Message message, Messages messages, Main main) {
        this.config = config;
        this.message = message;
        this.messages = messages;
        this.main = main;
    }

    private Economy economy = Main.economy;

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final double balance = economy.getBalance(player);
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
        PvShop pvmenu = new PvShop(config, new Messages(message), message);
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
        if (topInventory.getName().equals("§6§lVAGT§f§l PVSHOP")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l PVSHOP")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 54) {
                VagtShopMenu menu = new VagtShopMenu(config, new Messages(message), message);
                menu.openInventory(player);
            }
            if (e.getSlot() == 19) {
                int price = config.getConfig().getInt("VagtPvShop.pv1");
                if (player.hasPermission("playervaults.amount.1")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 2", price)));
                } else {
                    if (!player.hasPermission("playervaults.amount.1") || player.hasPermission("playervaults.amount.2") || player.hasPermission("playervaults.amount.3") || player.hasPermission("playervaults.amount.4") || player.hasPermission("playervaults.amount.5") || player.hasPermission("playervaults.amount.6") || player.hasPermission("playervaults.amount.7") || player.hasPermission("playervaults.amount.8") || player.hasPermission("playervaults.amount.9") || player.hasPermission("playervaults.amount.10") || player.hasPermission("playervaults.amount.11")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.1");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 1", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 1", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 1", price)));
                    }
                }
            }
            if (e.getSlot() == 21) {
                int price = config.getConfig().getInt("VagtPvShop.pv2");
                if (player.hasPermission("playervaults.amount.2")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 2", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.1")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.2");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 2", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 2", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 2", price)));
                    }
                }
            }
            if (e.getSlot() == 23) {
                int price = config.getConfig().getInt("VagtPvShop.pv3");
                if (player.hasPermission("playervaults.amount.3")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 3", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.2")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.3");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 3", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 3", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 3", price)));
                    }
                }
            }
            if (e.getSlot() == 25) {
                int price = config.getConfig().getInt("VagtPvShop.pv4");
                if (player.hasPermission("playervaults.amount.4")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 4", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.3")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.4");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 4", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 4", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 4", price)));
                    }
                }
            }
            if (e.getSlot() == 29) {
                int price = config.getConfig().getInt("VagtPvShop.pv5");
                if (player.hasPermission("playervaults.amount.5")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 4", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.4")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.5");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 5", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 5", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 5", price)));
                    }
                }
            }
            if (e.getSlot() == 31) {
                int price = config.getConfig().getInt("VagtPvShop.pv6");
                if (player.hasPermission("playervaults.amount.6")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 6", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.5")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.6");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 6", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 6", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 6", price)));
                    }
                }
            }
            if (e.getSlot() == 33) {
                int price = config.getConfig().getInt("VagtPvShop.pv7");
                if (player.hasPermission("playervaults.amount.7")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 7", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.6")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.7");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 7", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 7", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 7", price)));
                    }
                }
            }
            if (e.getSlot() == 37) {
                int price = config.getConfig().getInt("VagtPvShop.pv8");
                if (player.hasPermission("playervaults.amount.8")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 8", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.7")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.8");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 8", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 8", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 8", price)));
                    }
                }
            }
            if (e.getSlot() == 39) {
                int price = config.getConfig().getInt("VagtPvShop.pv9");
                if (player.hasPermission("playervaults.amount.9")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 8", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.8")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.9");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 9", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 9", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 9", price)));
                    }
                }
            }
            if (e.getSlot() == 41) {
                int price = config.getConfig().getInt("VagtPvShop.pv10");
                if (player.hasPermission("playervaults.amount.10")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 10", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.9")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.10");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 10", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 10", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 10", price)));
                    }
                }
            }
            if (e.getSlot() == 43) {
                int price = config.getConfig().getInt("VagtPvShop.pv11");
                if (player.hasPermission("playervaults.amount.11")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvAlreadyown("PV 11", price)));
                } else {
                    if (player.hasPermission("playervaults.amount.10")) {
                        if (balance >= price) {
                            economy.withdrawPlayer(player, price);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set playervaults.amount.11");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvBuyed("PV 11", price)));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    pvmenu.openInventory(player);
                                }
                            }, 2 * 20L);
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNoMoney("PV 11", price)));
                        }
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.VagtPvNotInOrder("PV 11", price)));
                    }
                }
            }
        }
    }
}
