package dev.crnyy.vagtsystem.plugins.vagtshop.pvshop.menu;

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

public class PvShop {

    private Config config;
    private Messages messages;
    private Message message;
    public PvShop(Config config, Messages messages, Message message) {
        this.config = config;
        this.messages = messages;
        this.message = message;

    }
    private Inventory inv = Bukkit.createInventory(null, 63, "§6§lVAGT§f§l PVSHOP");
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
        for (int i = 54; i < 63; i++) {
            inv.setItem(i, item);
        }
        item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU1MGI3Zjc0ZTllZDc2MzNhYTI3NGVhMzBjYzNkMmU4N2FiYjM2ZDRkMWY0Y2E2MDhjZDQ0NTkwY2NlMGIifX19", "§c§lTILBAGE", loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        inv.setItem(54, item);
        if (player.hasPermission("playervaults.amount.1")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l1 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §71",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(19, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l1 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §71",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv1"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(19, item);
        }
        if (player.hasPermission("playervaults.amount.2")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l2 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §72",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(21, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l2 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §72",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv2"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(21, item);
        }
        if (player.hasPermission("playervaults.amount.3")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l3 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §73",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(23, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l3 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §73",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv3"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(23, item);
        }
        if (player.hasPermission("playervaults.amount.4")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l4 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §74",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(25, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l4 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §74",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv4"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(25, item);
        }
        if (player.hasPermission("playervaults.amount.5")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l5 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §75",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(29, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l5 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §75",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv5"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(29, item);
        }
        if (player.hasPermission("playervaults.amount.6")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l6 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §76",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(31, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l6 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §76",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv6"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(31, item);
        }
        if (player.hasPermission("playervaults.amount.7")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l7 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §77",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(33, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l7 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §77",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv7"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(33, item);
        }
        if (player.hasPermission("playervaults.amount.8")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l8 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §78",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(37, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l8 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §78",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv8"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(37, item);
        }
        if (player.hasPermission("playervaults.amount.9")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l9 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §79",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(39, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l9 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §79",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv9"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(39, item);
        }
        if (player.hasPermission("playervaults.amount.10")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l10 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §710",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(41, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l10 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §710",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv10"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(41, item);
        }
        if (player.hasPermission("playervaults.amount.11")) {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAyNTE4MWM3MDI2ZTU4M2RlNmQ4Mjk3Y2FjNWVlZThmOTdhYmEyY2M0NjM5ZWUzNmI2Yjg1ZTRjZWQ0ZjI1YyJ9fX0=", "§6§l11 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §711",
                    "",
                    "§a§lDu har købt denne",
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(43, item);
        } else {
            item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0=", "§6§l11 §f§lPV", loreManager.loreMaker(
                    "§8§m-------------------------------",
                    "",
                    "§7Klik her for at købe adgang til",
                    "§fPV §8# §711",
                    "",
                    "§7Pris&8: §f$" + config.getConfig().getInt("VagtPvShop.pv11"),
                    "",
                    "§8§m-------------------------------"));
            inv.setItem(43, item);
        }
    }

    public void openInventory(final Player player) {
        items(player);
        player.openInventory(inv);
    }
}

