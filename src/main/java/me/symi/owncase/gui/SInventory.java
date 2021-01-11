package me.symi.owncase.gui;

import me.symi.owncase.Main;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class SInventory {

    public static Inventory getCasePreview(Player player, String case_name) throws IOException, InvalidConfigurationException {
        Inventory inv = Bukkit.createInventory(player, 27, ChatUtil.fixColors("&6&lDrop &8- &7" + case_name));
        int counter = 0;

        for(ItemStack item : Main.getInst().getFileManager().getPremiumCaseItems(case_name))
        {
            inv.setItem(counter, item);
            counter++;
        }

        return inv;
    }


}
