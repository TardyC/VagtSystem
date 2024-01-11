package dev.crnyy.vagtsystem.plugins;

import com.avaje.ebean.validation.NotNull;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

    public static Map<UUID, Integer> level = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> coins = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> paycheck = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> ontime = new HashMap<UUID, Integer>();

    public void setLevel(final Player player, int amount) {
        level.put(player.getUniqueId(), amount);
        return;
    }

    public int getLevel(final Player player) {
        return level.getOrDefault(player.getUniqueId(), 0);
    }



    public void setCoins(final Player player, int amount) {
        coins.put(player.getUniqueId(), amount);
        return;
    }
    public int getCoins(final Player player) {
        return coins.get(player.getUniqueId());
    }


    public void setPaycheck(final Player player, int amount) {
        paycheck.put(player.getUniqueId(), amount);
        return;
    }
    public int getPaycheck(final Player player) {
        return paycheck.get(player.getUniqueId());
    }
}
