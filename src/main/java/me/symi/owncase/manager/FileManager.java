package me.symi.owncase.manager;

import me.symi.owncase.Main;
import org.bukkit.Bukkit;
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
        try {
            loadConifgs();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void loadConifgs() throws IOException, InvalidConfigurationException {
        File normal_case = new File(plugin.getDataFolder() + File.separator + "cases", "normal_case.yml");
        if(!normal_case.exists())
        {
            normal_case.getParentFile().mkdir();
            plugin.saveResource("normal_case.yml", false);
            File createdFile = new File(plugin.getDataFolder(), "normal_case.yml");
            createdFile.renameTo(new File(plugin.getDataFolder() + File.separator + "cases" + File.separator + "normal_case.yml"));
        }

        File locations = new File(plugin.getDataFolder(), "locations.yml");
        if(!locations.exists())
        {
            plugin.saveResource("locations.yml", false);
        }

        FileConfiguration locations_config = new YamlConfiguration();
        locations_config.load(locations);
        case_configs.add(locations_config);
        case_files.add(locations);

        File data_folder = new File(plugin.getDataFolder() + File.separator + "cases");
        for(File files : data_folder.listFiles())
        {
            FileConfiguration config = new YamlConfiguration();

            config.load(files);
            case_configs.add(config);
            case_files.add(files);
        }
    }

    public void reloadConfigs()
    {
        case_configs.clear();
        case_files.clear();
        try {
            loadConifgs();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public File getFile(String name)
    {
        for(File file : case_files)
        {
            if(file.getName().equalsIgnoreCase(name + ".yml"))
            {
                return file;
            }
        }
        return null;
    }

    public FileConfiguration getConfig(String name) throws IOException, InvalidConfigurationException
    {
        for(File file : case_files)
        {
            if(file.getName().equalsIgnoreCase(name + ".yml"))
            {
                FileConfiguration config = new YamlConfiguration();
                config.load(file);
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
        else
        {
            FileConfiguration configuration = new YamlConfiguration();
            configuration.load(file);

            case_configs.remove(configuration);
            case_files.remove(file);
            file.delete();

            file.createNewFile();
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

    public List<ItemStack> getPremiumCaseItems(String case_name) throws IOException, InvalidConfigurationException {
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
