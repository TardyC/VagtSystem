package dev.crnyy.vagtsystem.plugins.vagtshop.warp.warpmenu;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import dev.crnyy.vagtsystem.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainWarp {
    private Config config;
    private Messages messages;
    private Message message;
    public MainWarp(Config config, Messages messages, Message message) {
        this.config = config;
        this.messages = messages;
        this.message = message;

    }
    private Inventory inv = Bukkit.createInventory(null, 45, "§6§lVAGT§f§l WARPSHOP");
    @Utility
    public void items(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, item);
        }
        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        for (int i = 36; i < 45; i++) {
            inv.setItem(i, item);
        }
        item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU1MGI3Zjc0ZTllZDc2MzNhYTI3NGVhMzBjYzNkMmU4N2FiYjM2ZDRkMWY0Y2E2MDhjZDQ0NTkwY2NlMGIifX19", "§c§lTILBAGE", loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        inv.setItem(36, item);
        item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWFjMGRhOTQ5NGI5NzRiZGJjYjc4ODYxZGY5NmFhNWFhYTVkYTM1YzY1ODcyMTcxOGFiMjZkYzJmZjY3ZDg3In19fQ==", "§c§lC §f§lWARPS", loreManager.loreMaker(
                "§8§m-----------------------------",
                "",
                "§7Denne fører til",
                "§fWarp §cC §7Købe menu",
                "",
                "",
                "§7Warpsne du finder her",
                "",
                "§c" + config.getConfig().getString("VagtWarp.C.VagtWarp2"),
                "§c" + config.getConfig().getString("VagtWarp.C.VagtWarp3"),
                "§c" + config.getConfig().getString("VagtWarp.C.VagtWarp4"),
                "§c" + config.getConfig().getString("VagtWarp.C.VagtWarp5"),
                "§8§m-----------------------------"));

        inv.setItem(19, item);
        if (player.hasPermission("BVagt")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzQ3ODk5ZDUxMWJhM2EzYmZlMTQ1NDFhNmE0Yjc3YjAzM2U0NGFjZDk1Njg5NmU3YjY1Njc0MjliZjE4ZDgzYyJ9fX0=", "§b§lB §f§lWARPS", loreManager.loreMaker(
                    "§8§m-----------------------------",
                    "",
                    "§7Denne fører til",
                    "§fWarp §bB §7Købe menu",
                    "",
                    "",
                    "§7Warpsne du finder her",
                    "",
                    "§b" + config.getConfig().getString("VagtWarp.B.VagtWarp2"),
                    "§b" + config.getConfig().getString("VagtWarp.B.VagtWarp3"),
                    "§b" + config.getConfig().getString("VagtWarp.B.VagtWarp4"),
                    "§b" + config.getConfig().getString("VagtWarp.B.VagtWarp5"),
                    "§8§m-----------------------------"));

            inv.setItem(22, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§b§lB §f§lWARPS", loreManager.loreMaker(
                    "§8§m-----------------------------",
                    "",
                    "§4§lINGEN ADGANG",
                    "",
                    "§8§m-----------------------------"));
            inv.setItem(22, item);
        }
        if (player.hasPermission("AVagt")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjBhZmQ3NzdkNTU3YTIwN2JhYzdhYWQ4NDIxZmRmNzg4ZDY2ODU4NzNjNDk1MTVkNTUyOTFlOTMwNjk5ZiJ9fX0=", "§a§lA §f§lWARPS", loreManager.loreMaker(
                    "§8§m-----------------------------",
                    "",
                    "§7Denne fører til",
                    "§fWarp §aA §7Købe Menu",
                    "",
                    "",
                    "§7Warpsne du finder her",
                    "",
                    "§a" + config.getConfig().getString("VagtWarp.A.VagtWarp2"),
                    "§a" + config.getConfig().getString("VagtWarp.A.VagtWarp3"),
                    "§a" + config.getConfig().getString("VagtWarp.A.VagtWarp4"),
                    "§a" + config.getConfig().getString("VagtWarp.A.VagtWarp5"),
                    "§8§m-----------------------------"));

            inv.setItem(25, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§a§lA §f§lWARPS", loreManager.loreMaker(
                    "§8§m-----------------------------",
                    "",
                    "§4§lINGEN ADGANG",
                    "",
                    "§8§m-----------------------------"));
            inv.setItem(25, item);
        }
    }

    public void openInventory(final Player player) {
        items(player);
        player.openInventory(inv);
    }
}
