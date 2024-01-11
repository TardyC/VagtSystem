package dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.b;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantItems;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class BVagtEnchantListener implements Listener {

    private Economy economy = Main.economy;
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final double balance = economy.getBalance(player);
        CVagtEnchantItems items = new CVagtEnchantItems();
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
        if (view == null) {
            return;
        }
        if (player == null) {
            return;
        }
        if (e.getClickedInventory() == null) {
            return;
        }
        if (topInventory == null) {
            return;
        }
        if (topInventory.getName().equals("Vagt Enchant B")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("Vagt Enchant B")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            switch (e.getCurrentItem().getType()) {
                case GOLD_HELMET:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Hjelm")) {
                            e.setCancelled(true);
                            items.openInventory("helmet", player);
                        }
                    }
                    break;
                case DIAMOND_CHESTPLATE:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Brystplade")) {
                            e.setCancelled(true);
                            items.openInventory("chestplate", player);
                        }
                    }
                    break;
                case DIAMOND_LEGGINGS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Bukser")) {
                            e.setCancelled(true);
                            items.openInventory("leggings", player);
                        }
                    }
                    break;
                case DIAMOND_BOOTS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Sko")) {
                            e.setCancelled(true);
                            items.openInventory("boots", player);
                        }
                    }
                    break;
                case DIAMOND_SWORD:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Sværd")) {
                            e.setCancelled(true);
                            items.openInventory("sword", player);
                        }
                    }
                    break;
                case BOW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Bue")) {
                            e.setCancelled(true);
                            items.openInventory("bow", player);
                        }
                    }
                    break;
            }
        }
    }


}
