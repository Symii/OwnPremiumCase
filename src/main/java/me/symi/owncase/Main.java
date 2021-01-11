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
import me.symi.owncase.owncase.OwnCase;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin{

    private static Main INSTANCE;
    public HashMap<UUID, Inventory> playerCase = new HashMap<>();
    public HashMap<UUID, Integer> current = new HashMap<>();
    private OwnCase ownCase;
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
        getCommand("key").setExecutor(new KeyCommand());
        getCommand("setcase").setExecutor(new SetcaseCommand());
        getCommand("case").setExecutor(new CaseCommand());

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                ownCase = new OwnCase(INSTANCE);
            }
        }.runTaskLater(this, 10L);

        configManager = new ConfigManager(this);
        fileManager = new FileManager(this);
    }

    public static Main getInst()
    {
        return INSTANCE;
    }

    public OwnCase getOwnCase()
    {
        return ownCase;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
