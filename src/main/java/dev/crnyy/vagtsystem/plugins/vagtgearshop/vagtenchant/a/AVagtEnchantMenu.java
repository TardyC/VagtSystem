package dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.a;

import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class AVagtEnchantMenu {

    private Inventory inv = Bukkit.createInventory(null, 54, "Vagt Enchant A");

    @Utility
    public void items(final Player player) {
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
        inv.setItem(45, item);
        inv.setItem(46, item);
        inv.setItem(47, item);
        inv.setItem(48, item);
        inv.setItem(49, item);
        inv.setItem(50, item);
        inv.setItem(51, item);
        inv.setItem(52, item);
        inv.setItem(53, item);


        //20-24 Armor
        //31
        ItemStack headItem = player.getInventory().getHelmet();
        ItemStack chestplateItem = player.getInventory().getChestplate();
        ItemStack leggingsItem = player.getInventory().getLeggings();
        ItemStack bootsItem = player.getInventory().getBoots();

        if (headItem != null && headItem.getType() == Material.GOLD_HELMET) {
            item = headItem.clone();
            inv.setItem(20, item);
        } else {
            item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS, 1, 14, loreManager.loreMaker(""));
            inv.setItem(20, item);
        }

        if (chestplateItem != null && chestplateItem.getType() == Material.DIAMOND_CHESTPLATE) {
            item = chestplateItem.clone();
            inv.setItem(21, item);
        } else {
            item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS, 1, 14, loreManager.loreMaker(""));
            inv.setItem(21, item);
        }

        if (leggingsItem != null && leggingsItem.getType() == Material.DIAMOND_LEGGINGS) {
            item = leggingsItem.clone();
            inv.setItem(22, item);
        } else {
            item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS, 1, 14, loreManager.loreMaker(""));
            inv.setItem(22, item);
        }

        if (bootsItem != null && bootsItem.getType() == Material.DIAMOND_BOOTS) {
            item = bootsItem.clone();
            inv.setItem(23, item);
        } else {
            item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS, 1, 14, loreManager.loreMaker(""));
            inv.setItem(23, item);
        }


        if (hasItemWithName(player.getInventory(), Material.DIAMOND_SWORD, "§aVagt Sværd")) {
            item = findItemWithName(player.getInventory(), Material.DIAMOND_SWORD, "§aVagt Sværd");;
            inv.setItem(24, item);
        } else {
            item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS, 1, 14, loreManager.loreMaker(""));
            inv.setItem(24, item);
        }

        if (hasItemWithName(player.getInventory(), Material.BOW, "§aVagt Bue")) {
            item = findItemWithName(player.getInventory(), Material.BOW, "§aVagt Bue");;
            inv.setItem(31, item);
        } else {
            item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS, 1, 14, loreManager.loreMaker(""));
            inv.setItem(31, item);
        }
    }

    public void openInventory(final Player player) {
        items(player);
        player.openInventory(inv);
    }

    @Utility
    private boolean hasItemWithName(PlayerInventory inventory, Material material, String itemName) {
        for (ItemStack itemStack : inventory.getContents()) {
            if (itemStack != null && itemStack.getType() == material && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    @Utility
    private ItemStack findItemWithName(PlayerInventory inventory, Material material, String itemName) {
        for (ItemStack itemStack : inventory.getContents()) {
            if (itemStack != null && itemStack.getType() == material && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equals(itemName)) {
                return itemStack;
            }
        }
        return null;
    }
}
