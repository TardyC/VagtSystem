package dev.crnyy.vagtsystem.plugins.vagtlevel;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VagtLevelQuests  {

    public static Map<UUID, Integer> ironCollected = new HashMap<UUID, Integer>();
    public static Map<UUID, Boolean> ironIsCollected = new HashMap<UUID, Boolean>();
    public static Map<UUID, Integer> breadCollected = new HashMap<UUID, Integer>();
    public static Map<UUID, Integer> seedsCollected = new HashMap<UUID, Integer>();
    public static Map<UUID, Integer> ironGearCollected = new HashMap<UUID, Integer>();


    public int getIronCollected(final Player player) {
        Integer ic = ironCollected.get(player.getUniqueId());
        return ic != null ? ic : 0;
    }

    public void setIronCollected(final Player player, int amount) {
        ironCollected.put(player.getUniqueId(), amount);
    }

    public boolean ironIsCollectedValue(final Player player) {
        Boolean ic = ironIsCollected.get(player.getUniqueId());
        return ic != null ? ic : false;
    }

}