package me.symi.owncase.manager;

import me.symi.owncase.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private final Main plugin;
    private ArrayList<FileConfiguration> case_configs = new ArrayList<>();
    private ArrayList<File> case_files = new ArrayList<>();

    public FileManager(Main plugin)
    {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        loadConifgs();
    }

    private void loadConifgs()
    {
        File data_folder = new File(plugin.getDataFolder() + File.separator + "cases");
        if(!data_folder.exists())
        {
            data_folder.getParentFile().mkdir();
        }
        for(File files : data_folder.listFiles())
        {
            FileConfiguration config = new YamlConfiguration();
            try
            {
                config.load(files);
                case_configs.add(config);
                case_files.add(files);
            }
            catch(IOException | InvalidConfigurationException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void reloadConigs()
    {
        case_configs.clear();
        case_files.clear();
        loadConifgs();
    }

    public File getFile(String name)
    {
        for(File file : case_files)
        {
            if(file.getName().equalsIgnoreCase(name))
            {
                return file;
            }
        }
        return null;
    }

    public FileConfiguration getConfig(String name)
    {
        for(FileConfiguration config : case_configs)
        {
            if(config.getName().equalsIgnoreCase(name))
            {
                return config;
            }
        }
        return null;
    }

}
