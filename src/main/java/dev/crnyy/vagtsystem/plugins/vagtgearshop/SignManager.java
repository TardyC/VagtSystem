package dev.crnyy.vagtsystem.plugins.vagtgearshop;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.a.AVagtShopMenu;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.b.BVagtShopMenu;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.c.CVagtShopMenu;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.a.AVagtEnchantMenu;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.b.BVagtEnchantMenu;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignManager implements Listener {
    private final Message message;
    private final Config config;

    public SignManager(Message message, Config config) {
        this.message = message;
        this.config = config;
    }

    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        Player player = e.getPlayer();
        Sign sign = (Sign) e.getBlock().getState();
        String firstLine = e.getLine(0);
        if (firstLine.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("enchantsign.signtext.text")))) {
            e.setLine(0, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("enchantsign.text.1st")));
            e.setLine(1, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("enchantsign.text.2nd")));
            e.setLine(2, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("enchantsign.text.3nd")));
            e.setLine(3, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("enchantsign.text.4nd")));
        } else if (firstLine.equalsIgnoreCase(message.getMessages().getString("shopsign.signtext.text"))) {
            e.setLine(0, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("shopsign.text.1st")));
            e.setLine(1, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("shopsign.text.2nd")));
            e.setLine(2, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("shopsign.text.3nd")));
            e.setLine(3, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("shopsign.text.4nd")));
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block clickedBlock = event.getClickedBlock();
        CVagtShopMenu cMenu = new CVagtShopMenu(config);
        CVagtEnchantMenu enchantMenu = new CVagtEnchantMenu();
        BVagtEnchantMenu benchantMenu = new BVagtEnchantMenu();
        AVagtEnchantMenu aenchantMenu = new AVagtEnchantMenu();

        BVagtShopMenu bMenu = new BVagtShopMenu(config);

        AVagtShopMenu aMenu = new AVagtShopMenu(config);

        if (clickedBlock != null && clickedBlock.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) clickedBlock.getState();
            if (sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("shopsign.text.1st")))) {
                if (sign.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("shopsign.text.2nd")))) {
                    if (sign.getLine(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("shopsign.text.3nd")))) {
                        if (sign.getLine(3).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("shopsign.text.4nd")))) {
                            if (player.getWorld().getName().equalsIgnoreCase(config.getConfig().getString("Worlds.C"))) {
                                cMenu.openInventory(player);
                            } else if (player.getWorld().getName().equalsIgnoreCase(config.getConfig().getString("Worlds.B"))) {
                                bMenu.openInventory(player);
                            } else if (player.getWorld().getName().equalsIgnoreCase(config.getConfig().getString("Worlds.A"))) {
                                aMenu.openInventory(player);
                            }
                        }
                    }
                }
            } if (sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("enchantsign.text.1st")))) {
                if (sign.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("enchantsign.text.2nd")))) {
                    if (sign.getLine(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("enchantsign.text.3nd")))) {
                        if (sign.getLine(3).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("enchantsign.text.4nd")))) {
                            if (player.getWorld().getName().equalsIgnoreCase(config.getConfig().getString("Worlds.C"))) {
                                enchantMenu.openInventory(player);
                            } else if (player.getWorld().getName().equalsIgnoreCase(config.getConfig().getString("Worlds.B"))) {
                                benchantMenu.openInventory(player);
                            } else if (player.getWorld().getName().equalsIgnoreCase(config.getConfig().getString("Worlds.A"))) {
                                aenchantMenu.openInventory(player);
                            }
                        }
                    }
                }
            }

        }
    }
}
