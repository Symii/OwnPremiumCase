package me.symi.owncase;

import java.util.HashMap;
import java.util.UUID;

import me.symi.owncase.commands.CaseCommand;
import me.symi.owncase.commands.KeyCommand;
import me.symi.owncase.commands.SetcaseCommand;
import me.symi.owncase.listeners.BlockListeners;
import me.symi.owncase.listeners.InventoryListeners;
import me.symi.owncase.listeners.PlayerListeners;
import me.symi.owncase.manager.ConfigManager;
import me.symi.owncase.manager.FileManager;
import me.symi.owncase.manager.LocationManager;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private static Main INSTANCE;
    public HashMap<UUID, Inventory> playerCase = new HashMap<>();
    public HashMap<UUID, Integer> current = new HashMap<>();
    private LocationManager locationManager;
    private ConfigManager configManager;
    private FileManager fileManager;


    @Override
    public void onLoad()
    {
        INSTANCE = this;
    }

    @Override
    public void onEnable()
    {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new BlockListeners(this), this);
        manager.registerEvents(new PlayerListeners(this), this);
        manager.registerEvents(new InventoryListeners(this), this);
        getCommand("key").setExecutor(new KeyCommand(this));
        getCommand("setcase").setExecutor(new SetcaseCommand(this));
        getCommand("case").setExecutor(new CaseCommand(this));

        configManager = new ConfigManager(this);
        fileManager = new FileManager(this);
        locationManager = new LocationManager(this);
    }

    public static Main getInst()
    {
        return INSTANCE;
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
