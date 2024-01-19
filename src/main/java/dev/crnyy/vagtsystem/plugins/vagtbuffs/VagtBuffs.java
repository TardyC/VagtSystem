package dev.crnyy.vagtsystem.plugins.vagtbuffs;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VagtBuffs implements Listener {
    private final Config config;
    private final Message message;

    public VagtBuffs(Config config, Message message) {
        this.config = config;
        this.message = message;
    }

    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        Player player = e.getPlayer();
        Sign sign = (Sign) e.getBlock().getState();
        String firstLine = e.getLine(0);
        if (firstLine.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("buffsign.signtext.text")))) {
            e.setLine(0, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("buffsign.text.1st")));
            e.setLine(1, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("buffsign.text.2nd")));
            e.setLine(2, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("buffsign.text.3nd")));
            e.setLine(3, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("buffsign.text.4nd")));
        }
    }

    @EventHandler
    public void onBuffclick(PlayerInteractEvent e) {
        String configWorld = config.getConfig().getString("Worlds.C", "world");
        String bWorld = config.getConfig().getString("Worlds.B");
        String aWorld = config.getConfig().getString("Worlds.A");

        Player player = e.getPlayer();
        String getWorld = player.getWorld().getName();
        Block block = e.getClickedBlock();
        World world = e.getPlayer().getWorld();
        if (block != null && block.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) block.getState();
            if (sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("buffsign.text.1st")))) {
                if (sign.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("buffsign.text.2nd")))) {
                    if (sign.getLine(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("buffsign.text.3nd")))) {
                        if (sign.getLine(3).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("buffsign.text.4nd")))) {
                            if (player.hasPermission("vagt")) {
                                if (player.getWorld().getName().equalsIgnoreCase(aWorld)) {
                                    player.removePotionEffect(PotionEffectType.ABSORPTION);
                                    player.removePotionEffect(PotionEffectType.SPEED);
                                    player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 10000, config.getConfig().getInt("Vagtbuffs.A.Absorption")));
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, config.getConfig().getInt("Vagtbuffs.A.Speed")));
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, config.getConfig().getInt("Vagtbuffs.A.Strength")));
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtsign.buffs")));
                                } else if (player.getWorld().getName().equalsIgnoreCase(bWorld)) {
                                    player.removePotionEffect(PotionEffectType.ABSORPTION);
                                    player.removePotionEffect(PotionEffectType.SPEED);
                                    player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20000, config.getConfig().getInt("Vagtbuffs.B.Absorption")));
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20000, config.getConfig().getInt("Vagtbuffs.B.Speed")));
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, config.getConfig().getInt("Vagtbuffs.B.Strength")));
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtsign.buffs")));
                                } else if (player.getWorld().getName().equalsIgnoreCase(configWorld)) {
                                    player.removePotionEffect(PotionEffectType.ABSORPTION);
                                    player.removePotionEffect(PotionEffectType.SPEED);
                                    player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20000, config.getConfig().getInt("Vagtbuffs.C.Absorption")));
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20000, config.getConfig().getInt("Vagtbuffs.C.Speed")));
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20000, config.getConfig().getInt("Vagtbuffs.C.Strength")));
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtsign.buffs")));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


