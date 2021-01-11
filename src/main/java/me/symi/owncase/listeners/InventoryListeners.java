package me.symi.owncase.listeners;

import me.symi.owncase.Main;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryListeners implements Listener {

    private final Main plugin;

    public InventoryListeners(Main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event)
    {
        if(event.getView().getTitle().contains(ChatUtil.fixColors("&4&lSkrzynka &7- &e")))
        {
            String case_name = event.getView().getTitle().substring(18);
            List<ItemStack> items = new ArrayList<>();

            for(ItemStack item : event.getInventory().getContents())
            {
                if(item != null)
                {
                    items.add(item);
                }
            }

            try 
            {
                if(items.size() >= 1)
                {
                    plugin.getFileManager().savePremiumCase(case_name, items);
                    event.getPlayer().sendMessage(ChatUtil.fixColorsWithPrefix("&aPomyslnie stworzyles skrzynke o nazwie &e" + case_name));
                }
                else
                {
                    event.getPlayer().sendMessage(ChatUtil.fixColorsWithPrefix("&eNie wstawiles zadnych przedmiotow do skrzynki!"));
                }
            }
            catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
        }
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e)
    {
        if(e.getClickedInventory() == null)
        {
            return;
        }

        if(e.getView().getTitle().equalsIgnoreCase(ChatUtil.fixColors("&6&lDrop &8- &7zwykla skrzynka")))
        {
            e.setCancelled(true);
        }
        else if(e.getView().getTitle().equalsIgnoreCase(ChatUtil.fixColors("&7Normalna skrzynka")))
        {
            e.setCancelled(true);
        }
    }

}
