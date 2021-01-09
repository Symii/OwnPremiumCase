package me.symi.owncase.commands;

import me.symi.owncase.Main;
import me.symi.owncase.owncase.OwnCase;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetcaseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player))
        {
            sender.sendMessage("Nie mozesz tego uzywac");
            return true;
        }

        final Player player = (Player) sender;
        if(player.hasPermission("symi.setcase.admin"))
        {
            if(args.length == 1)
            {
                Block block = player.getLocation().add(0,-1,0).getBlock();
                if(block.getType() != Material.CHEST)
                {
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&cblok znajdujacy sie pod toba to nie skrzynka!"));
                    return true;
                }

                OwnCase symiCase = Main.getInst().getOwnCase();

                if(args[0].equalsIgnoreCase("normal"))
                {
                    symiCase.setNormalCaseLocation(block.getLocation());
                }
                else if(args[0].equalsIgnoreCase("rare"))
                {
                    symiCase.setRareCaseLocation(block.getLocation());
                }
                else if(args[0].equalsIgnoreCase("epic"))
                {
                    symiCase.setEpicCaseLocation(block.getLocation());
                }
                else if(args[0].equalsIgnoreCase("legendary"))
                {
                    symiCase.setLegendaryCaseLocation(block.getLocation());
                }
                else if(args[0].equalsIgnoreCase("kasyno"))
                {
                    symiCase.setKasynoCaseLocation(block.getLocation());
                }
                else
                {
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&7Poprawne uzycie: &c/setcase [normal;rare,epic,legendary;kasyno]"));
                    return true;
                }
                player.sendMessage(ChatUtil.fixColorsWithPrefix("&aPomyslnie zapisano lokacje dla skrzynki!"));
            }
            else
            {
                player.sendMessage(ChatUtil.fixColorsWithPrefix("&7Poprawne uzycie: &c/setcase [normal;rare,epic,legendary;kasyno]"));
            }
        }
        else
        {
            player.sendMessage(ChatUtil.fixColorsWithPrefix("&cnie posiadasz uprawnien."));
        }

        return true;
    }

}
