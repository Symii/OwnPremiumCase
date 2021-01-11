package me.symi.owncase.commands;

import me.symi.owncase.gui.CaseCreateGUI;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CaseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player))
        {
            sender.sendMessage("Nie mozesz tego uzywac");
            return true;
        }

        final Player player = (Player) sender;
        if(player.hasPermission("ownpremiumcase.case"))
        {
            if(args.length == 2 && args[0].equalsIgnoreCase("create"))
            {
                player.openInventory(CaseCreateGUI.getInventory(player, args[1]));
            }
            else
            {
                player.sendMessage(ChatUtil.fixColorsWithPrefix("&c/case create <nazwa skrzynki>"));
            }
        }

        return false;
    }
}
