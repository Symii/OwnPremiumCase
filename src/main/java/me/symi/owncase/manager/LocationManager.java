package me.symi.owncase.manager;

import me.symi.owncase.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class LocationManager {

    private final Main plugin;
    private HashMap<String, Location> case_locations = new HashMap<>();

    public LocationManager(Main plugin)
    {
        this.plugin = plugin;
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () ->
        {
            try {
                loadLocations();
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
        }, 10L);
    }

    public void loadLocations() throws IOException, InvalidConfigurationException
    {
        case_locations.clear();
        FileConfiguration config = plugin.getFileManager().getConfig("locations");
        for(String s : config.getConfigurationSection("locations").getKeys(false))
        {
            Location location = new Location(Bukkit.getWorld(config.getString("locations." + s + ".world")), config.getInt("locations." + s + ".x")
                ,config.getInt("locations." + s + ".y"), config.getInt("locations." + s + ".z"));
            case_locations.put(s, location);
        }
    }

    public void saveLocation(String case_name, Location location) throws IOException, InvalidConfigurationException
    {
        FileConfiguration config = plugin.getFileManager().getConfig("locations");
        config.set("locations." + case_name + ".x", location.getBlockX());
        config.set("locations." + case_name + ".y", location.getBlockY());
        config.set("locations." + case_name + ".z", location.getBlockZ());
        config.set("locations." + case_name + ".world", location.getWorld().getName());
        File locations = new File(plugin.getDataFolder(), "locations.yml");
        config.save(locations);
        case_locations.put(case_name, location);
    }

    public boolean openCaseRoll(Player player, Location location)
    {
        for(String case_name : case_locations.keySet())
        {
            Location case_loc = case_locations.get(case_name);
            if(case_loc.getWorld().getName().equalsIgnoreCase(location.getWorld().getName())
                && case_loc.distance(location) < 1)
            {
                player.chat("/case roll " + case_name);
                return true;
            }
        }
        return false;
    }

    public boolean openCasePreview(Player player, Location location)
    {
        for(String case_name : case_locations.keySet())
        {
            Location case_loc = case_locations.get(case_name);
            if(case_loc.getWorld().getName().equalsIgnoreCase(location.getWorld().getName())
                    && case_loc.distance(location) < 1)
            {
                player.chat("/case preview " + case_name);
                return true;
            }
        }
        return false;
    }

}
