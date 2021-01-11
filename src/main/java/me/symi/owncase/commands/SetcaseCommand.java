package me.symi.owncase.commands;

import me.symi.owncase.Main;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SetcaseCommand implements CommandExecutor {

    private final Main plugin;

    public SetcaseCommand(Main plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player))
        {
            sender.sendMessage("Nie mozesz tego uzywac");
            return true;
        }

        final Player player = (Player) sender;
        if(player.hasPermission("ownpremiumcase.setcase"))
        {
            if(args.length == 1)
            {
                Block block = player.getLocation().getBlock();
                if(block.getType() != Material.CHEST)
                {
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&cblok znajdujacy sie pod toba to nie skrzynka!"));
                    return true;
                }

                String case_name = args[0];
                try {
                    plugin.getLocationManager().saveLocation(case_name, block.getLocation());
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&aPomyslnie zapisano lokacje dla skrzynki!"));
                } catch (IOException | InvalidConfigurationException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                player.sendMessage(ChatUtil.fixColorsWithPrefix("&7Poprawne uzycie: &c/setcase [nazwa skrzynki]"));
            }
        }
        else
        {
            player.sendMessage(ChatUtil.fixColorsWithPrefix("&cnie posiadasz uprawnien."));
        }

        return true;
    }

}
