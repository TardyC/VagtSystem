package dev.crnyy.vagtsystem.plugins.vagtpay;

import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VagtPayMenu {
    private Inventory inv = Bukkit.createInventory(null, 45, "§6§lVAGT§f§l LØN");



    @Utility
    public void items(final Player player) {
        ItemStack item;
        ItemStackManager itemStack = new ItemStackManager();
        LoreManager lore = new LoreManager();

        //Vagt
        item = itemStack.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, lore.loreMaker(""));
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, item);
        }
        item = itemStack.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, lore.loreMaker(""));
        for (int i = 36; i < 45; i++) {
            inv.setItem(i, item);
        }

        //Items
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTI2MjlmMjY4MmRjZWUzMGY1ODU1YjFlNTQyN2NjNGJlZTczZDE4YTI3NmZhZmM1MjBkNjkzYjQwY2E4MWIyMiJ9fX0=", "§6§lVAGT§f§l LØN", lore.loreMaker(
                "&aLæs information om din nuværende løn.",
                "",
                "&8&m--------------------",
                "&7Løn: &f$", //Løn
                "&7Næste løn: &fNæste løn", //Løn Næste løn tid
                "",
                "",
                "&7Pris for opgradering: &fPris for næste opgrade",//Opgrade
                "",
                "",
                "&8Price: (PRIS HER)")); //Ved ikke om kommer til at blive brugt
        inv.setItem(22, item);
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU1MGI3Zjc0ZTllZDc2MzNhYTI3NGVhMzBjYzNkMmU4N2FiYjM2ZDRkMWY0Y2E2MDhjZDQ0NTkwY2NlMGIifX19", "§c§lTILBAGE", lore.loreMaker(
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
