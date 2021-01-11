package me.symi.owncase.listeners;

import me.symi.owncase.Main;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListeners implements Listener {

    private final Main plugin;

    public BlockListeners(Main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    private void blockPlace(BlockPlaceEvent e)
    {
        if(e.getItemInHand().getItemMeta() == null || !e.getItemInHand().hasItemMeta()
                || e.getItemInHand().getItemMeta().getDisplayName() == null)
        {
            return;
        }

        if(e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.fixColors("&7Klucz do zwyklej skrzynki")))
        {
            e.setCancelled(true);
        }

    }

}
