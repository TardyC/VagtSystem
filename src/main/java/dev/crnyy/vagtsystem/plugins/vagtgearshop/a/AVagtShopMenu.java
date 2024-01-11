package dev.crnyy.vagtsystem.plugins.vagtgearshop.a;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AVagtShopMenu {
    private Config config;

    public AVagtShopMenu(Config config) {
        this.config = config;
    }

    private Inventory inv = Bukkit.createInventory(null, 54, "Vagt Shop A");

    @Utility
    public void items() {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();
        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        inv.setItem(0, item);
        inv.setItem(1, item);
        inv.setItem(2, item);
        inv.setItem(3, item);
        inv.setItem(4, item);
        inv.setItem(5, item);
        inv.setItem(6, item);
        inv.setItem(7, item);
        inv.setItem(8, item);
        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        inv.setItem(9, item);
        inv.setItem(17, item);
        inv.setItem(18, item);
        inv.setItem(26, item);
        inv.setItem(27, item);
        inv.setItem(35, item);
        inv.setItem(36, item);
        inv.setItem(44, item);
        inv.setItem(45, item);
        inv.setItem(46, item);
        inv.setItem(47, item);
        inv.setItem(48, item);
        inv.setItem(49, item);
        inv.setItem(50, item);
        inv.setItem(51, item);
        inv.setItem(52, item);
        inv.setItem(53, item);

        /**
         * ARMOR
         */
        item = itemStackManager.itemMaker("§a§lHJELM", Material.GOLD_HELMET, 1, 0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at købe en hjelm.",
                "",
                "§8【 &7Pris§8: §f$" + config.getConfig().getInt("Vagtshop.A.helmet") + " §8】",
                "",
                "§8§m-------------------------"));
        inv.setItem(11, item);
        item = itemStackManager.itemMaker("§a§lBRYSTPLADE", Material.DIAMOND_CHESTPLATE, 1, 0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at købe en brystplade.",
                "",
                "§8【 &7Pris§8: §f$" + config.getConfig().getInt("Vagtshop.A.chestplate") + " §8】",
                "",
                "§8§m-------------------------"));
        inv.setItem(20, item);
        item = itemStackManager.itemMaker("§a§lBUKSER", Material.DIAMOND_LEGGINGS, 1, 0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at købe et par bukser.",
                "",
                "§8【 &7Pris§8: §f$" + config.getConfig().getInt("Vagtshop.A.legs") + " §8】",
                "",
                "§8§m-------------------------"));
        inv.setItem(29, item);
        item = itemStackManager.itemMaker("§a§lSKO", Material.DIAMOND_BOOTS, 1, 0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at købe et par sko.",
                "",
                "§8【 &7Pris§8: §f$" + config.getConfig().getInt("Vagtshop.A.boots") + " §8】",
                "",
                "§8§m-------------------------"));
        inv.setItem(38, item);

        /**
         * ITEMS
         */
        item = itemStackManager.itemMaker("§a§lSVÆRD", Material.DIAMOND_SWORD, 1, 0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at købe et sværd.",
                "",
                "§8【 &7Pris§8: §f$" + config.getConfig().getInt("Vagtshop.A.sword") + " §8】",
                "",
                "§8§m-------------------------"));
        inv.setItem(22, item);
        item = itemStackManager.itemMaker("§a§lBUE", Material.BOW, 1, 0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at købe en bue.",
                "",
                "§8【 &7Pris§8: §f$" + config.getConfig().getInt("Vagtshop.A.bow") + " §8】",
                "",
                "§8§m-------------------------"));
        inv.setItem(23, item);
        item = itemStackManager.itemMMaker("§a§lPIND", Material.STICK, 1, 0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at købe en pind..",
                "",
                "§8【 &7Pris§8: §f$" + config.getConfig().getInt("Vagtshop.A.stick") + " §8】",
                "",
                "§8§m-------------------------"));
        inv.setItem(24, item);
        item = itemStackManager.itemMaker("§a§lMAD", Material.GRILLED_PORK, 16, 0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at købe 16x mad.",
                "",
                "§8【 &7Pris§8: §f$" + config.getConfig().getInt("Vagtshop.A.food") + " §8】",
                "",
                "§8§m-------------------------"));
        inv.setItem(31, item);
        item = itemStackManager.itemMaker("§a§lPILE", Material.ARROW, 16, 0, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at købe 16x pile.",
                "",
                "§8【 &7Pris§8: §f$" + config.getConfig().getInt("Vagtshop.A.arrow") + " §8】",
                "",
                "§8§m-------------------------"));
        inv.setItem(32, item);
    }

    public void openInventory(final Player player) {
        items();
        player.openInventory(inv);
    }

}
