package me.symi.owncase.manager;

import me.symi.owncase.Main;

public class ConfigManager {

    private final Main plugin;

    public ConfigManager(Main plugin)
    {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        loadConfig();
    }

    public void loadConfig()
    {

    }

}
