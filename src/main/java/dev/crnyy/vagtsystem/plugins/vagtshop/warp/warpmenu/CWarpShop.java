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

public class CWarpShop {

    private Config config;
    private Messages messages;
    private Message message;
    public CWarpShop(Config config, Messages messages, Message message) {
        this.config = config;
        this.messages = messages;
        this.message = message;

    }
    private Inventory inv = Bukkit.createInventory(null, 45, "§6§lVAGT§f§l WARPSHOP - §c§lC");
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
        item = itemStackManager.itemMaker("§c" + config.getConfig().getString("VagtWarp.C.VagtWarp2"), Material.SIGN, 1, 0, loreManager.loreMaker(
                "§8§m-----------------------------",
                "",
                "§7Klik her for at købe",
                "§c" + config.getConfig().getString("VagtWarp.C.VagtWarp2"),
                "",
                "§7Pris§8: §f$" + config.getConfig().getInt("VagtWarpShop.C.VagtWarp2"),
                "",
                "§8§m-----------------------------"));
        inv.setItem(19, item);
        item = itemStackManager.itemMaker("§c" + config.getConfig().getString("VagtWarp.C.VagtWarp3"), Material.SIGN, 1, 0, loreManager.loreMaker(
                "§8§m-----------------------------",
                "",
                "§7Klik her for at købe",
                "§c" + config.getConfig().getString("VagtWarp.C.VagtWarp3"),
                "",
                "§7Pris§8: §f$" + config.getConfig().getInt("VagtWarpShop.C.VagtWarp3"),
                "",
                "§8§m-----------------------------"));
        inv.setItem(21, item);
        item = itemStackManager.itemMaker("§c" + config.getConfig().getString("VagtWarp.C.VagtWarp4"), Material.SIGN, 1, 0, loreManager.loreMaker(
                "§8§m-----------------------------",
                "",
                "§7Klik her for at købe",
                "§c" + config.getConfig().getString("VagtWarp.C.VagtWarp4"),
                "",
                "§7Pris§8: §f$" + config.getConfig().getInt("VagtWarpShop.C.VagtWarp4"),
                "",
                "§8§m-----------------------------"));
        inv.setItem(23, item);
        item = itemStackManager.itemMaker("§c" + config.getConfig().getString("VagtWarp.C.VagtWarp5"), Material.SIGN, 1, 0, loreManager.loreMaker(
                "§8§m-----------------------------",
                "",
                "§7Klik her for at købe",
                "§c" + config.getConfig().getString("VagtWarp.C.VagtWarp5"),
                "",
                "§7Pris§8: §f$" + config.getConfig().getInt("VagtWarpShop.C.VagtWarp5"),
                "",
                "§8§m-----------------------------"));
        inv.setItem(25, item);
        item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU1MGI3Zjc0ZTllZDc2MzNhYTI3NGVhMzBjYzNkMmU4N2FiYjM2ZDRkMWY0Y2E2MDhjZDQ0NTkwY2NlMGIifX19", "§c§lTILBAGE", loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        inv.setItem(36, item);
    }

    public void openInventory(final Player player) {
        items(player);
        player.openInventory(inv);
    }
}
