package dev.crnyy.vagtsystem.plugins.vagtwarps;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AVagtWarpMenu {
    private Config config;
    public AVagtWarpMenu(Config config) {
        this.config = config;
    }

    private Inventory avagtwarp = Bukkit.createInventory(null, 45, "§6§lVAGT§f§l WARP§7 - §aA§7 Menu");

    @Utility
    public void items(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        for (int i = 0; i < 9; i++) {
            avagtwarp.setItem(i, item);
        }
        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        for (int i = 36; i < 45; i++) {
            avagtwarp.setItem(i, item);
        }
        item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU1MGI3Zjc0ZTllZDc2MzNhYTI3NGVhMzBjYzNkMmU4N2FiYjM2ZDRkMWY0Y2E2MDhjZDQ0NTkwY2NlMGIifX19", "§c§lTILBAGE", loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        avagtwarp.setItem(36, item);
        item = itemStackManager.itemMaker("§6§lVAGT WARP §8(§7#5§8)", Material.SIGN, 5,0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at warpe til",
                "§f" + config.getConfig().getString("VagtWarp.A.VagtWarp5") + " §7#5",
                "",
                "§8§m-------------------------"));

        avagtwarp.setItem(24, item);
        item = itemStackManager.itemMaker("§6§lVAGT WARP §8(§7#4§8)", Material.SIGN, 4,0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at warpe til",
                "§f" + config.getConfig().getString("VagtWarp.A.VagtWarp4") + " §7#4",
                "",
                "§8§m-------------------------"));


        avagtwarp.setItem(23, item);
        item = itemStackManager.itemMaker("§6§lVAGT WARP §8(§7#3§8)", Material.SIGN, 3,0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at warpe til",
                "§f" + config.getConfig().getString("VagtWarp.A.VagtWarp3") + " §7#3",
                "",
                "§8§m-------------------------"));

        avagtwarp.setItem(22, item);
        item = itemStackManager.itemMaker("§6§lVAGT WARP §8(§7#2§8)", Material.SIGN, 2,0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at warpe til",
                "§f" + config.getConfig().getString("VagtWarp.A.VagtWarp2") + " §7#2",
                "",
                "§8§m-------------------------"));

        avagtwarp.setItem(21, item);
        item = itemStackManager.itemMaker("§6§lVAGT WARP §8(§7#1§8)", Material.SIGN, 1,0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at warpe til",
                "§f" + config.getConfig().getString("VagtWarp.A.VagtWarp1") + " §7#1",
                "",
                "§8§m-------------------------"));

        avagtwarp.setItem(20, item);
    }
    public void openInventory(final Player player) {
        items(player);
        player.openInventory(avagtwarp);
    }
}
