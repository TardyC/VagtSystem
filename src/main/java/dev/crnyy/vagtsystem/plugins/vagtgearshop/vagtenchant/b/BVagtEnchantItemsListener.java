package dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.b;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantItems;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantMenu;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BVagtEnchantItemsListener implements Listener {

    private final ArmorManager armorManager;
    private final CVagtEnchantItems menus;
    private final Messages messages;
    private final Config config;
    public BVagtEnchantItemsListener(ArmorManager armorManager, Config config, Messages messages, CVagtEnchantItems menus) {
        this.armorManager = armorManager;
        this.menus = menus;
        this.messages = messages;
        this.config = config;
    }

    private Map<UUID, Integer> helmetEnchant = new HashMap<UUID, Integer>();
    private Map<UUID, Integer> chestplateEnchant = new HashMap<UUID, Integer>();
    private Map<UUID, Integer> leggingsEnchant = new HashMap<UUID, Integer>();
    private Map<UUID, Integer> bootsEnchant = new HashMap<UUID, Integer>();
    private Map<UUID, Integer> swordEnchant = new HashMap<UUID, Integer>();
    private Map<UUID, Integer> bowEnchant = new HashMap<UUID, Integer>();

    private Economy economy = Main.economy;

    /**
     * @param e
     */
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final double balance = economy.getBalance(player);
        CVagtEnchantItems items = new CVagtEnchantItems();
        BVagtEnchantMenu menu = new BVagtEnchantMenu();
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
        if (topInventory.getName().equals("Enchant Hjelm") || topInventory.getName().equals("Enchant Brystplade") || topInventory.getName().equals("Enchant Bukser") || topInventory.getName().equals("Enchant Sko") || topInventory.getName().equals("Enchant Sværd") || topInventory.getName().equals("Enchant Bue")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("Enchant Hjelm") || e.getClickedInventory().getName().equals("Enchant Brystplade") || e.getClickedInventory().getName().equals("Enchant Bukser") || e.getClickedInventory().getName().equals("Enchant Sko") || e.getClickedInventory().getName().equals("Enchant Sværd") || e.getClickedInventory().getName().equals("Enchant Bue")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() == Material.INK_SACK) {
                if (e.getCurrentItem().hasItemMeta()) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lTILBAGE")) {
                        e.setCancelled(true);
                        menu.openInventory(player);
                    }
                }
            }
            switch (e.getCurrentItem().getType()) {
                case GOLD_HELMET:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Hjelm")) {
                            e.setCancelled(true);
                            ItemStack helmet = player.getInventory().getHelmet();
                            if (helmet == null || helmet.getItemMeta() == null) {
                                return;
                            }
                            ItemMeta itemMeta = helmet.getItemMeta();
                            List<String> currentLore = itemMeta.getLore();
                            if (currentLore == null) {
                                return;
                            }
                            if (!helmetEnchant.containsKey(player.getUniqueId())) {
                                helmetEnchant.put(player.getUniqueId(), 0);
                            }
                            int protection = helmetEnchant.get(player.getUniqueId());
                            int protectionLevel = player.getInventory().getHelmet().getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
                            if (protectionLevel == 4) {
                                player.sendMessage("Du har allerede maks proctection!");
                                player.closeInventory();
                                helmetEnchant.remove(player.getUniqueId());
                                return;
                            }
                            if (protection < 4) {
                                int cost = calculateEnchantCost(protection);
                                if (balance >= cost) {
                                    protection++;
                                    currentLore.set(3, "§8- §7Protection§8: §f" + protection);
                                    itemMeta.setLore(currentLore);
                                    helmet.setItemMeta(itemMeta);
                                    player.getInventory().setHelmet(helmet);
                                    e.setCurrentItem(helmet);
                                    player.sendMessage("Du købte protection " + protection);
                                    economy.withdrawPlayer(player, cost);
                                    helmetEnchant.put(player.getUniqueId(), protection);
                                    player.getInventory().getHelmet().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, protection);
                                    player.updateInventory();
                                    menus.openInventory("helmet", player);
                                } else {
                                    player.sendMessage("Du har ikke nok penge til dette.");
                                    player.closeInventory();
                                }
                            } else {
                                player.sendMessage("Du har allerede maks proctection!");
                                player.closeInventory();
                                helmetEnchant.remove(player.getUniqueId());
                            }
                        }
                    }
                    break;
                case DIAMOND_CHESTPLATE:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Brystplade")) {
                            e.setCancelled(true);
                            ItemStack chestplate = player.getInventory().getChestplate();
                            if (chestplate == null || chestplate.getItemMeta() == null) {
                                return;
                            }
                            ItemMeta itemMeta = chestplate.getItemMeta();
                            List<String> currentLore = itemMeta.getLore();
                            if (currentLore == null) {
                                return;
                            }
                            if (!chestplateEnchant.containsKey(player.getUniqueId())) {
                                chestplateEnchant.put(player.getUniqueId(), 0);
                            }
                            int protection = chestplateEnchant.get(player.getUniqueId());
                            int protectionLevel = player.getInventory().getChestplate().getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
                            if (protectionLevel == 4) {
                                player.sendMessage("Du har allerede maks proctection!");
                                player.closeInventory();
                                chestplateEnchant.remove(player.getUniqueId());
                                return;
                            }
                            if (protection < 4) {
                                int cost = calculateEnchantCost(protection);
                                if (balance >= cost) {
                                    protection++;
                                    currentLore.set(3, "§8- §7Protection§8: §f" + protection);
                                    itemMeta.setLore(currentLore);
                                    chestplate.setItemMeta(itemMeta);
                                    player.getInventory().setChestplate(chestplate);
                                    e.setCurrentItem(chestplate);
                                    player.sendMessage("Du købte protection " + protection);
                                    economy.withdrawPlayer(player, cost);
                                    chestplateEnchant.put(player.getUniqueId(), protection);
                                    player.getInventory().getChestplate().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, protection);
                                    player.updateInventory();
                                    menus.openInventory("chestplate", player);
                                } else {
                                    player.sendMessage("Du har ikke nok penge til dette.");
                                    player.closeInventory();
                                }
                            } else {
                                player.sendMessage("Du har allerede maks proctection!");
                                player.closeInventory();
                                chestplateEnchant.remove(player.getUniqueId());
                            }
                        }
                    }
                    break;
                case DIAMOND_LEGGINGS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Bukser")) {
                            e.setCancelled(true);
                            ItemStack leggings = player.getInventory().getLeggings();
                            if (leggings == null || leggings.getItemMeta() == null) {
                                return;
                            }
                            ItemMeta itemMeta = leggings.getItemMeta();
                            List<String> currentLore = itemMeta.getLore();
                            if (currentLore == null) {
                                return;
                            }
                            if (!leggingsEnchant.containsKey(player.getUniqueId())) {
                                leggingsEnchant.put(player.getUniqueId(), 0);
                            }
                            int protection = leggingsEnchant.get(player.getUniqueId());
                            int protectionLevel = player.getInventory().getLeggings().getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
                            if (protectionLevel == 4) {
                                player.sendMessage("Du har allerede maks proctection!");
                                player.closeInventory();
                                leggingsEnchant.remove(player.getUniqueId());
                                return;
                            }
                            if (protection < 4) {
                                int cost = calculateEnchantCost(protection);
                                if (balance >= cost) {
                                    protection++;
                                    currentLore.set(3, "§8- §7Protection§8: §f" + protection);
                                    itemMeta.setLore(currentLore);
                                    leggings.setItemMeta(itemMeta);
                                    player.getInventory().setLeggings(leggings);
                                    e.setCurrentItem(leggings);
                                    player.sendMessage("Du købte protection " + protection);
                                    economy.withdrawPlayer(player, cost);
                                    leggingsEnchant.put(player.getUniqueId(), protection);
                                    player.getInventory().getLeggings().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, protection);
                                    player.updateInventory();
                                    menus.openInventory("leggings", player);
                                } else {
                                    player.sendMessage("Du har ikke nok penge til dette.");
                                    player.closeInventory();
                                }
                            } else {
                                player.sendMessage("Du har allerede maks proctection!");
                                player.closeInventory();
                                leggingsEnchant.remove(player.getUniqueId());
                            }
                        }
                    }
                    break;
                case DIAMOND_BOOTS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Sko")) {
                            e.setCancelled(true);
                            ItemStack boots = player.getInventory().getBoots();
                            if (boots == null || boots.getItemMeta() == null) {
                                return;
                            }
                            ItemMeta itemMeta = boots.getItemMeta();
                            List<String> currentLore = itemMeta.getLore();
                            if (currentLore == null) {
                                return;
                            }
                            if (!bootsEnchant.containsKey(player.getUniqueId())) {
                                bootsEnchant.put(player.getUniqueId(), 0);
                            }
                            int protection = bootsEnchant.get(player.getUniqueId());
                            int protectionLevel = player.getInventory().getBoots().getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
                            if (protectionLevel == 4) {
                                player.sendMessage("Du har allerede maks proctection!");
                                player.closeInventory();
                                bootsEnchant.remove(player.getUniqueId());
                                return;
                            }
                            if (protection < 4) {
                                int cost = calculateEnchantCost(protection);
                                if (balance >= cost) {
                                    protection++;
                                    currentLore.set(3, "§8- §7Protection§8: §f" + protection);
                                    itemMeta.setLore(currentLore);
                                    boots.setItemMeta(itemMeta);
                                    player.getInventory().setBoots(boots);
                                    e.setCurrentItem(boots);
                                    player.sendMessage("Du købte protection " + protection);
                                    economy.withdrawPlayer(player, cost);
                                    bootsEnchant.put(player.getUniqueId(), protection);
                                    player.getInventory().getBoots().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, protection);
                                    player.updateInventory();
                                    menus.openInventory("boots", player);
                                } else {
                                    player.sendMessage("Du har ikke nok penge til dette.");
                                    player.closeInventory();
                                }
                            } else {
                                player.sendMessage("Du har allerede maks proctection!");
                                player.closeInventory();
                                bootsEnchant.remove(player.getUniqueId());
                            }
                        }
                    }
                    break;
                case DIAMOND_SWORD:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Sværd")) {
                            e.setCancelled(true);
                            ItemStack sword = findItemWithName(player.getInventory(), Material.IRON_SWORD, "§cVagt Sværd");
                            if (sword == null || sword.getItemMeta() == null) {
                                return;
                            }
                            ItemMeta itemMeta = sword.getItemMeta();
                            List<String> currentLore = itemMeta.getLore();
                            if (currentLore == null) {
                                return;
                            }
                            if (!swordEnchant.containsKey(player.getUniqueId())) {
                                swordEnchant.put(player.getUniqueId(), 0);
                            }
                            int protection = swordEnchant.get(player.getUniqueId());
                            int protectionLevel = sword.getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
                            if (protectionLevel == 4) {
                                player.sendMessage("Du har allerede maks sharpness!");
                                player.closeInventory();
                                swordEnchant.remove(player.getUniqueId());
                                return;
                            }
                            if (protection < 4) {
                                int cost = calculateEnchantCost(protection);
                                if (balance >= cost) {
                                    protection++;
                                    currentLore.set(3, "§8- §7Sharpness§8: §f" + protection);
                                    itemMeta.setLore(currentLore);
                                    sword.setItemMeta(itemMeta);
                                    player.sendMessage("Du købte sharpness " + protection);
                                    economy.withdrawPlayer(player, cost);
                                    swordEnchant.put(player.getUniqueId(), protection);
                                    sword.addEnchantment(Enchantment.DAMAGE_ALL, protection);
                                    player.updateInventory();
                                    menus.openInventory("sword", player);
                                } else {
                                    player.sendMessage("Du har ikke nok penge til dette.");
                                    player.closeInventory();
                                }
                            } else {
                                player.sendMessage("Du har allerede maks sharpness!");
                                player.closeInventory();
                                swordEnchant.remove(player.getUniqueId());
                            }
                        }
                    }
                    break;
                case BOW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVagt Bue")) {
                            e.setCancelled(true);
                            ItemStack bow = findItemWithName(player.getInventory(), Material.BOW, "§bVagt Bue");
                            if (bow == null || bow.getItemMeta() == null) {
                                return;
                            }
                            ItemMeta itemMeta = bow.getItemMeta();
                            List<String> currentLore = itemMeta.getLore();
                            if (currentLore == null) {
                                return;
                            }
                            if (!bowEnchant.containsKey(player.getUniqueId())) {
                                bowEnchant.put(player.getUniqueId(), 0);
                            }
                            int protection = bowEnchant.get(player.getUniqueId());
                            int protectionLevel = bow.getItemMeta().getEnchantLevel(Enchantment.ARROW_DAMAGE);
                            if (protectionLevel == 4) {
                                player.sendMessage("Du har allerede maks power!");
                                player.closeInventory();
                                bowEnchant.remove(player.getUniqueId());
                                return;
                            }
                            if (protection < 4) {
                                int cost = calculateEnchantCost(protection);
                                if (balance >= cost) {
                                    protection++;
                                    currentLore.set(3, "§8- §7Power§8: §f" + protection);
                                    itemMeta.setLore(currentLore);
                                    bow.setItemMeta(itemMeta);
                                    player.sendMessage("Du købte power " + protection);
                                    economy.withdrawPlayer(player, cost);
                                    bowEnchant.put(player.getUniqueId(), protection);
                                    bow.addEnchantment(Enchantment.ARROW_DAMAGE, protection);
                                    player.updateInventory();
                                    menus.openInventory("bow", player);
                                } else {
                                    player.sendMessage("Du har ikke nok penge til dette.");
                                    player.closeInventory();
                                }
                            } else {
                                player.sendMessage("Du har allerede maks power!");
                                player.closeInventory();
                                bowEnchant.remove(player.getUniqueId());
                            }
                        }
                    }
                    break;
            }
        }
    }
    @Utility
    private int calculateEnchantCost(int protectionLevel) {
        switch (protectionLevel) {
            case 1:
                return config.getConfig().getInt("VagtEnchant.B.protection-1");
            case 2:
                return config.getConfig().getInt("VagtEnchant.B.protection-2");
            case 3:
                return config.getConfig().getInt("VagtEnchant.B.protection-3");
            case 4:
                return config.getConfig().getInt("VagtEnchant.B.protection-4");
        }
        return protectionLevel;
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
