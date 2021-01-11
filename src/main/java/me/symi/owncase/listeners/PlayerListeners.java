package me.symi.owncase.listeners;

import me.symi.owncase.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class PlayerListeners implements Listener {

    private final Main plugin;

    public PlayerListeners(Main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent e)
    {
        final Player player = e.getPlayer();

        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().getType() == Material.CHEST)
        {
            if(plugin.getLocationManager().openCaseRoll(player, e.getClickedBlock().getLocation()))
            {
                e.setCancelled(true);
            }
        }
        else if(e.getAction().equals(Action.LEFT_CLICK_BLOCK) && e.getClickedBlock().getType() == Material.CHEST)
        {
            if(plugin.getLocationManager().openCasePreview(player, e.getClickedBlock().getLocation()))
            {
                e.setCancelled(true);
            }
        }
    }


}
