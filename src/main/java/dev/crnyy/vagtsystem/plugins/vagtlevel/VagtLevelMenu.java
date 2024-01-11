package dev.crnyy.vagtsystem.plugins.vagtlevel;

import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VagtLevelMenu {

    private final PlayerManager manager;
    private final VagtLevelQuests quests;
    public VagtLevelMenu(PlayerManager manager, VagtLevelQuests quests) {
        this.manager = manager;
        this.quests = quests;
    }

    private Inventory inv = Bukkit.createInventory(null, 45, "§6§lVAGT §f§lLEVEL");

    @Utility
    public void items(final Player player) {
        ItemStack item;
        ItemStackManager itemStack = new ItemStackManager();
        LoreManager lore = new LoreManager();

        item = itemStack.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, lore.loreMaker(""));
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, item);
        }
        item = itemStack.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, lore.loreMaker(""));
        for (int i = 36; i < 45; i++) {
            inv.setItem(i, item);

        }
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU1MGI3Zjc0ZTllZDc2MzNhYTI3NGVhMzBjYzNkMmU4N2FiYjM2ZDRkMWY0Y2E2MDhjZDQ0NTkwY2NlMGIifX19", "§c§lTILBAGE", lore.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        inv.setItem(36, item);
        int level = manager.getLevel(player) + 1;
        if (!(quests.ironIsCollectedValue(player))) {
            item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTM4MjYxODFjZTkwMTJiNjY1ODY1ZjNhYzAwNjYzMDdiNGQwMmRhMjgxNTQwMTA0ZTA0NjFmZmVmYTc0NTlmZCJ9fX0=", "§6§lKRAV FOR §f§lLEVELUP §8§l( §e§l" + level + " §8§l)", lore.loreMaker(
                    "§8§m-------------------------",
                    "",
                    "§7Krav for at §flevelup§7 når du kan,",
                    "§7opfylde alle kravene.",
                    "",
                    "§8[ §4§l✘ §8] §cAflevere et total af §4" + quests.ironCollected.get(player.getUniqueId()) + "/32§c iron ingot.",
                    "",
                    "",
                    "§7Du har klaret§8: §f0/1",
                    "",
                    "§8§m-------------------------"));
            inv.setItem(22, item);
        } else {
            item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTM4MjYxODFjZTkwMTJiNjY1ODY1ZjNhYzAwNjYzMDdiNGQwMmRhMjgxNTQwMTA0ZTA0NjFmZmVmYTc0NTlmZCJ9fX0=", "§6§lKRAV FOR §f§lLEVELUP §8§l( §e§l" + level + " §8§l)", lore.loreMaker(
                    "§8§m-------------------------",
                    "",
                    "§7Krav for at §flevelup§7 når du kan,",
                    "§7opfylde alle kravene.",
                    "",
                    "§8[ §2§l✔ §8] §aAflevere et total af §2" + quests.ironCollected.get(player.getUniqueId()) + "§a iron ingot.",
                    "",
                    "",
                    "§7Du har klaret§8: §f1/1",
                    "",
                    "§8§m-------------------------"));
            inv.setItem(22, item);
        }

    }

    public void openInventory(final Player player) {
        items(player);
        player.openInventory(inv);
    }

}