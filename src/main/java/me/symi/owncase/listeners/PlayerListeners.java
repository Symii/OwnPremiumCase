package me.symi.owncase.listeners;

import me.symi.owncase.Main;
import me.symi.owncase.gui.SInventory;
import me.symi.owncase.owncase.OwnCase;
import me.symi.owncase.utils.ChatUtil;
import me.symi.owncase.utils.FireworkUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
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
    private void playerInteract(PlayerInteractEvent e)
    {
        if(!e.getPlayer().getWorld().getName().equalsIgnoreCase("freebuild"))
        {
            return;
        }

        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().getType() == Material.CHEST)
        {
            final Player player = e.getPlayer();
            final OwnCase symiCase = Main.getInst().getOwnCase();

            if(symiCase.isNormalCase(e.getClickedBlock().getLocation()))
            {
                e.setCancelled(true);
                if(symiCase.hasNormalKey(player))
                {
                    //normalCaseRoll(player);
                    FireworkUtil.spawnFirework(e.getClickedBlock().getLocation());
                }
                else
                {
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&7nie posiadasz klucza do &fzwyklej skrzynki!"));
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                }
            }
        }
        else if(e.getAction().equals(Action.LEFT_CLICK_BLOCK) && e.getClickedBlock().getType() == Material.CHEST)
        {
            SInventory inv = new SInventory();
            Player player = e.getPlayer();
            OwnCase symiCase = Main.getInst().getOwnCase();

            if(symiCase.isNormalCase(e.getClickedBlock().getLocation()))
            {
                player.openInventory(inv.getNormalCase(player));
                e.setCancelled(true);
            }
        }
    }


}
