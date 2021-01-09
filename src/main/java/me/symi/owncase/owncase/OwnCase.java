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

    private Location normal_case_loc, rare_case_loc, epic_case_loc, legendary_case_loc, kasyno_case_loc;
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
        normal_case_loc = new Location(Bukkit.getWorld(config.getString("normal.world")),
                config.getInt("normal.x"), config.getInt("normal.y"), config.getInt("normal.z"));
        rare_case_loc = new Location(Bukkit.getWorld(config.getString("rare.world")),
                config.getInt("rare.x"), config.getInt("rare.y"), config.getInt("rare.z"));
        epic_case_loc = new Location(Bukkit.getWorld(config.getString("epic.world")),
                config.getInt("epic.x"), config.getInt("epic.y"), config.getInt("epic.z"));
        legendary_case_loc = new Location(Bukkit.getWorld(config.getString("legendary.world")),
                config.getInt("legendary.x"), config.getInt("legendary.y"), config.getInt("legendary.z"));
        kasyno_case_loc = new Location(Bukkit.getWorld(config.getString("kasyno.world")),
                config.getInt("kasyno.x"), config.getInt("kasyno.y"), config.getInt("kasyno.z"));
    }

    private void save()
    {
        plugin.getConfig().set("normal.x", normal_case_loc.getBlockX());
        plugin.getConfig().set("normal.y", normal_case_loc.getBlockY());
        plugin.getConfig().set("normal.z", normal_case_loc.getBlockZ());
        plugin.getConfig().set("normal.world", normal_case_loc.getWorld().getName());

        plugin.getConfig().set("rare.x", rare_case_loc.getBlockX());
        plugin.getConfig().set("rare.y", rare_case_loc.getBlockY());
        plugin.getConfig().set("rare.z", rare_case_loc.getBlockZ());
        plugin.getConfig().set("rare.world", rare_case_loc.getWorld().getName());

        plugin.getConfig().set("epic.x", epic_case_loc.getBlockX());
        plugin.getConfig().set("epic.y", epic_case_loc.getBlockY());
        plugin.getConfig().set("epic.z", epic_case_loc.getBlockZ());
        plugin.getConfig().set("epic.world", epic_case_loc.getWorld().getName());

        plugin.getConfig().set("legendary.x", legendary_case_loc.getBlockX());
        plugin.getConfig().set("legendary.y", legendary_case_loc.getBlockY());
        plugin.getConfig().set("legendary.z", legendary_case_loc.getBlockZ());
        plugin.getConfig().set("legendary.world", legendary_case_loc.getWorld().getName());

        plugin.getConfig().set("kasyno.x", kasyno_case_loc.getBlockX());
        plugin.getConfig().set("kasyno.y", kasyno_case_loc.getBlockY());
        plugin.getConfig().set("kasyno.z", kasyno_case_loc.getBlockZ());
        plugin.getConfig().set("kasyno.world", kasyno_case_loc.getWorld().getName());
        plugin.saveConfig();
        plugin.reloadConfig();
    }

    public boolean hasNormalKey(Player player)
    {
        boolean open = false;
        for(ItemStack klucz : player.getInventory().getContents())
        {
            if(klucz != null && klucz.hasItemMeta() && klucz.getType().equals(Material.TRIPWIRE_HOOK)
                    && klucz.getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&7Klucz do zwyklej skrzynki")))
            {
                open = true;
                klucz.setAmount(klucz.getAmount() - 1);
                break;
            }
        }
        return open;
    }

    public boolean hasRareKey(Player player)
    {
        boolean open = false;
        for(ItemStack klucz : player.getInventory().getContents())
        {
            if(klucz != null && klucz.hasItemMeta() && klucz.getType().equals(Material.TRIPWIRE_HOOK)
                    && klucz.getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&bKlucz do rzadkiej skrzynki")))
            {
                open = true;
                klucz.setAmount(klucz.getAmount() - 1);
                break;
            }
        }
        return open;
    }

    public boolean hasEpicKey(Player player)
    {
        boolean open = false;
        for(ItemStack klucz : player.getInventory().getContents())
        {
            if(klucz != null && klucz.hasItemMeta() && klucz.getType().equals(Material.TRIPWIRE_HOOK)
                    && klucz.getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&5Klucz do epickiej skrzynki")))
            {
                open = true;
                klucz.setAmount(klucz.getAmount() - 1);
                break;
            }
        }
        return open;
    }

    public boolean hasLegendaryKey(Player player)
    {
        boolean open = false;
        for(ItemStack klucz : player.getInventory().getContents())
        {
            if(klucz != null && klucz.hasItemMeta() && klucz.getType().equals(Material.TRIPWIRE_HOOK)
                    && klucz.getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&eKlucz do legendarnej skrzynki")))
            {
                open = true;
                klucz.setAmount(klucz.getAmount() - 1);
                break;
            }
        }
        return open;
    }

    public boolean hasKasynoKey(Player player)
    {
        boolean open = false;
        for(ItemStack klucz : player.getInventory().getContents())
        {
            if(klucz != null && klucz.hasItemMeta() && klucz.getType().equals(Material.TRIPWIRE_HOOK)
                    && klucz.getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&5Klucz do skrzynki krupiera")))
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

    public boolean isRareCase(Location loc)
    {
        if(rare_case_loc.distance(loc) < 1
                && rare_case_loc.getWorld().getName().equalsIgnoreCase(loc.getWorld().getName()))
        {
            return true;
        }
        return false;
    }

    public boolean isEpicCase(Location loc)
    {
        if(epic_case_loc.distance(loc) < 1
                && epic_case_loc.getWorld().getName().equalsIgnoreCase(loc.getWorld().getName()))
        {
            return true;
        }
        return false;
    }

    public boolean isLegendaryCase(Location loc)
    {
        if(legendary_case_loc.distance(loc) < 1
                && legendary_case_loc.getWorld().getName().equalsIgnoreCase(loc.getWorld().getName()))
        {
            return true;
        }
        return false;
    }

    public boolean isKasynoCase(Location loc)
    {
        if(kasyno_case_loc.distance(loc) < 1
                && kasyno_case_loc.getWorld().getName().equalsIgnoreCase(loc.getWorld().getName()))
        {
            return true;
        }
        return false;
    }

    public Location getNormalCaseLocation()
    {
        return normal_case_loc;
    }

    public Location getRareCaseLocation()
    {
        return rare_case_loc;
    }

    public Location getEpicCaseLocation()
    {
        return epic_case_loc;
    }

    public Location getLegendaryCaseLocation()
    {
        return legendary_case_loc;
    }

    public Location getKasynoCaseLocation()
    {
        return kasyno_case_loc;
    }

    public void setNormalCaseLocation(Location normal_case_loc)
    {
        this.normal_case_loc = normal_case_loc;
        save();
    }

    public void setRareCaseLocation(Location rare_case_loc)
    {
        this.rare_case_loc = rare_case_loc;
        save();
    }

    public void setEpicCaseLocation(Location epic_case_loc)
    {
        this.epic_case_loc = epic_case_loc;
        save();
    }

    public void setLegendaryCaseLocation(Location legendary_case_loc)
    {
        this.legendary_case_loc = legendary_case_loc;
        save();
    }

    public void setKasynoCaseLocation(Location kasyno_case_loc)
    {
        this.kasyno_case_loc = kasyno_case_loc;
        save();
    }

}
