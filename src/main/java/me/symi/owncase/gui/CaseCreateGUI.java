package me.symi.owncase.gui;

import me.symi.owncase.Main;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class CaseCreateGUI {

    public static Inventory getInventory(Player player, String case_name)
    {
        Inventory inventory = Bukkit.createInventory(player, 27, ChatUtil.fixColors("&4&lSkrzynka &7- &e" + case_name));
        return inventory;
    }

    public static Inventory getEditInventory(Player player, String case_name) throws IOException, InvalidConfigurationException {
        Inventory inventory = Bukkit.createInventory(player, 27, ChatUtil.fixColors("&4&lSkrzynka &7- &e" + case_name));

        int counter = 0;

        for(ItemStack item : Main.getInst().getFileManager().getPremiumCaseItems(case_name))
        {
            inventory.setItem(counter, item);
            counter++;
        }

        return inventory;
    }

}
