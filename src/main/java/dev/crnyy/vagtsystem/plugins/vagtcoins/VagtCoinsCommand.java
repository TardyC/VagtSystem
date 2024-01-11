package dev.crnyy.vagtsystem.plugins.vagtcoins;

import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.plugins.vagtwarps.StartVagtMenu;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VagtCoinsCommand implements CommandExecutor {

    private final PlayerManager manager;
    private final VagtCoinsMenu menu;

    public VagtCoinsCommand(PlayerManager manager, VagtCoinsMenu menu) {
        this.manager = manager;
        this.menu = menu;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;

        }
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("vagtcoins")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("menu")) {
                    VagtCoinsMenu menu = new VagtCoinsMenu();
                    menu.openInventory(player);

                }
            } else {
                player.sendMessage("Coins system");
                player.sendMessage("§8Dine Coins§7" + manager.coins.get(player.getUniqueId()));
            }
        }

        return true;
    }
}
