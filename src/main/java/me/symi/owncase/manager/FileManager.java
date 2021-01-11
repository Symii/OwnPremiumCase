package me.symi.owncase.manager;

import me.symi.owncase.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            if(config.getName().contains(name))
            {
                return config;
            }
        }
        return null;
    }

    public void savePremiumCase(String case_name, List<ItemStack> items) throws IOException, InvalidConfigurationException
    {
        File file = new File(plugin.getDataFolder() + File.separator + "cases", case_name + ".yml");
        if(!file.exists())
        {
            file.createNewFile();
            FileConfiguration configuration = new YamlConfiguration();
            configuration.load(file);
            int counter = 1;
            for(ItemStack item : items)
            {
                configuration.set("drop." + counter, item);
                counter++;
            }
            configuration.save(file);
            case_files.add(file);
            case_configs.add(configuration);
        }
    }

    public List<ItemStack> getPremiumCaseItems(String case_name)
    {
        List<ItemStack> items = new ArrayList<>();
        FileConfiguration config = getConfig(case_name);
        for(String s : config.getConfigurationSection("drop").getKeys(false))
        {
            ItemStack item = config.getItemStack("drop." + s);
            items.add(item);
        }
        return items;
    }

}
