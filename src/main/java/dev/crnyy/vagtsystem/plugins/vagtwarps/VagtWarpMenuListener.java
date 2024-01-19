package dev.crnyy.vagtsystem.plugins.vagtwarps;

import com.earth2me.essentials.commands.WarpNotFoundException;
import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.plugins.vagtmenu.VagtMenu;
import dev.crnyy.vagtsystem.utils.Messages;
import net.ess3.api.InvalidWorldException;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;


import com.earth2me.essentials.Essentials;


public class VagtWarpMenuListener implements Listener {

    private Main main;
    private Config config;
    private Messages messages;
    public VagtWarpMenuListener(Main main, Config config, Messages messages) {
        this.main = main;
        this.config = config;
        this.messages = messages;

    }
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        Essentials essentials = (Essentials) main.getServer().getPluginManager().getPlugin("Essentials");
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
        if (topInventory.getName().equals("§6§lVAGT§f§l WARP§7 - Hovede Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARP§7 - Hovede Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 19) {
                CVagtWarpMenu menu = new CVagtWarpMenu(config);
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 22) {
                BVagtWarpMenu menu = new BVagtWarpMenu(config);
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 25) {
                AVagtWarpMenu menu = new AVagtWarpMenu(config);
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                VagtMenu menu = new VagtMenu();
                menu.openInventory(player);
            }
        }


        //CVagtWarp
        if (topInventory.getName().equals("§6§lVAGT§f§l WARP§7 - §cC§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARP§7 - §cC§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                StartVagtMenu menu = new StartVagtMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 20) {
                try {
                    if (player.hasPermission("vagt")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.C.VagtWarp1")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.C.VagtWarp1"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.C.VagtWarp1"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.C.VagtWarp1") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 21) {
                try {
                    if (player.hasPermission("CVagtWarp2")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.C.VagtWarp2")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.C.VagtWarp2"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.C.VagtWarp2"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.C.VagtWarp2") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 22) {
                try {
                    if (player.hasPermission("CVagtWarp3")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.C.VagtWarp3")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.C.VagtWarp3"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.C.VagtWarp3"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.C.VagtWarp3") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 23) {
                try {
                    if (player.hasPermission("CVagtWarp4")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.C.VagtWarp4")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.C.VagtWarp4"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.C.VagtWarp4"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.C.VagtWarp4") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 24) {
                try {
                    if (player.hasPermission("CVagtWarp5")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.C.VagtWarp5")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.C.VagtWarp5"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.C.VagtWarp5"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.C.VagtWarp5") + " Eksitere ikke i din Warps.yml");
                }
            }
        }

        //BVagtWarp
        if (topInventory.getName().equals("§6§lVAGT§f§l WARP§7 - §bB§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARP§7 - §bB§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                StartVagtMenu menu = new StartVagtMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 20) {
                try {
                    if (player.hasPermission("bvagt")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.B.VagtWarp1")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.B.VagtWarp1"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.B.VagtWarp1"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.B.VagtWarp1") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 21) {
                try {
                    if (player.hasPermission("BVagtWarp2")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.C.VagtWarp2")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.C.VagtWarp2"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.C.VagtWarp2"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.B.VagtWarp2") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 22) {
                try {
                    if (player.hasPermission("BVagtWarp3")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.B.VagtWarp3")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.B.VagtWarp3"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.B.VagtWarp3"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.B.VagtWarp3") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 23) {
                try {
                    if (player.hasPermission("BVagtWarp4")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.B.VagtWarp4")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.B.VagtWarp4"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.B.VagtWarp4"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.B.VagtWarp4") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 24) {
                try {
                    if (player.hasPermission("BVagtWarp5")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.B.VagtWarp5")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.B.VagtWarp5"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.B.VagtWarp5"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.B.VagtWarp5") + " Eksitere ikke i din Warps.yml");
                }
            }
        }
        //AVagtWarp
        if (topInventory.getName().equals("§6§lVAGT§f§l WARP§7 - §aA§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARP§7 - §aA§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                StartVagtMenu menu = new StartVagtMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 20) {
                try {
                    if (player.hasPermission("avagt")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.A.VagtWarp1")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.A.VagtWarp1"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.A.VagtWarp1"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.A.VagtWarp1") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 21) {
                try {
                    if (player.hasPermission("AVagtWarp2")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.A.VagtWarp2")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.A.VagtWarp2"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.A.VagtWarp2"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.A.VagtWarp2") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 22) {
                try {
                    if (player.hasPermission("AVagtWarp3")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.A.VagtWarp3")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.A.VagtWarp3"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.A.VagtWarp3"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.A.VagtWarp3") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 23) {
                try {
                    if (player.hasPermission("AVagtWarp4")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.A.VagtWarp4")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.A.VagtWarp4"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.A.VagtWarp4"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.A.VagtWarp4") + " Eksitere ikke i din Warps.yml");
                }
            }
            if (e.getSlot() == 24) {
                try {
                    if (player.hasPermission("AVagtWarp5")) {
                        player.teleport(essentials.getWarps().getWarp(config.getConfig().getString("VagtWarp.A.VagtWarp5")).getBlock().getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpGoto(config.getConfig().getString("VagtWarp.A.VagtWarp5"))));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.vagtWarpnotbuyed(config.getConfig().getString("VagtWarp.A.VagtWarp5"))));
                    }
                } catch (WarpNotFoundException | InvalidWorldException ex) {
                    ex.printStackTrace();
                    System.out.println(config.getConfig().getString("VagtWarp.A.VagtWarp5") + " Eksitere ikke i din Warps.yml");
                }
            }
        }
    }
}
