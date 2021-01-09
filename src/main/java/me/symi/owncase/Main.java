package me.symi.owncase;

import java.util.HashMap;
import java.util.UUID;

import me.symi.owncase.commands.KeyCommand;
import me.symi.owncase.commands.SetcaseCommand;
import me.symi.owncase.listeners.Events;
import me.symi.owncase.owncase.OwnCase;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin{

    private static Main INSTANCE;
    public String prefix = "&f&lO&9&lC &8»&7 ";
    public HashMap<UUID, Inventory> playerCase = new HashMap<UUID, Inventory>();
    public HashMap<UUID, Integer> current = new HashMap<UUID, Integer>();
    private OwnCase ownCase;


    @Override
    public void onLoad()
    {
        INSTANCE = this;
    }

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new Events(), this);
        getCommand("key").setExecutor(new KeyCommand());
        getCommand("setcase").setExecutor(new SetcaseCommand());

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                ownCase = new OwnCase(INSTANCE);
            }
        }.runTaskLater(this, 10L);
    }

    public static Main getInst()
    {
        return INSTANCE;
    }

    public OwnCase getOwnCase()
    {
        return ownCase;
    }

}
