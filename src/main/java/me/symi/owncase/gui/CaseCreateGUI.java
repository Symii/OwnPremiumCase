package me.symi.owncase.gui;

import me.symi.owncase.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CaseCreateGUI {

    public static Inventory getInventory(Player player, String case_name)
    {
        Inventory inventory = Bukkit.createInventory(player, 27, ChatUtil.fixColors("&4&lSkrzynka &7- &e" + case_name));
        return inventory;
    }

}
