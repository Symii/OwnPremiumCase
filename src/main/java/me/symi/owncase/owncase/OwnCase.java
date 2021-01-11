package me.symi.owncase.owncase;

import me.symi.owncase.Main;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class OwnCase {

    private Location normal_case_loc;
    private Main plugin;

    public OwnCase(Main plugin)
    {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        loadLocations();
    }

    private void loadLocations()
    {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();
        //normal_case_loc = new Location(Bukkit.getWorld(config.getString("normal.world")),
        //        config.getInt("normal.x"), config.getInt("normal.y"), config.getInt("normal.z"));
    }

    private void save()
    {
        plugin.getConfig().set("normal.x", normal_case_loc.getBlockX());
        plugin.getConfig().set("normal.y", normal_case_loc.getBlockY());
        plugin.getConfig().set("normal.z", normal_case_loc.getBlockZ());
        plugin.getConfig().set("normal.world", normal_case_loc.getWorld().getName());

        plugin.saveConfig();
        plugin.reloadConfig();
    }

    public boolean hasNormalKey(Player player)
    {
        boolean open = false;
        for(ItemStack klucz : player.getInventory().getContents())
        {
            if(klucz != null && klucz.hasItemMeta() && klucz.getType().equals(Material.TRIPWIRE_HOOK)
                    && klucz.getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.fixColors("&7Klucz do zwyklej skrzynki")))
            {
                open = true;
                klucz.setAmount(klucz.getAmount() - 1);
                break;
            }
        }
        return open;
    }

    public boolean isNormalCase(Location loc)
    {
        if(normal_case_loc.distance(loc) < 1
                && normal_case_loc.getWorld().getName().equalsIgnoreCase(loc.getWorld().getName()))
        {
            return true;
        }
        return false;
    }

    public Location getNormalCaseLocation()
    {
        return normal_case_loc;
    }

    public void setNormalCaseLocation(Location normal_case_loc)
    {
        this.normal_case_loc = normal_case_loc;
        save();
    }


}
