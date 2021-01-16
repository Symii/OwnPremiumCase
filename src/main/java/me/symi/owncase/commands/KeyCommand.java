package me.symi.owncase.commands;

import me.symi.owncase.Main;
import me.symi.owncase.keys.PremiumKey;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.command.CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KeyCommand implements CommandExecutor {

    private final Main plugin;

    public KeyCommand(Main plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
    {
        if(sender.hasPermission("symi.case.admin"))
        {
            if(args.length == 3)
            {
                int amount = 0;

                try
                {
                    amount = Integer.parseInt(args[1]);
                }
                catch(Exception e)
                {
                    sender.sendMessage("/key [nazwa skrzynki] [ilosc] [gracz]");
                }

                if(amount <= 0)
                {
                    sender.sendMessage("Podaj liczbe wieksza od 0");
                    return false;
                }

                if(args[2].equalsIgnoreCase("all"))
                {
                    ItemStack key = PremiumKey.getKey(args[0], amount);
                    for(Player p : Bukkit.getOnlinePlayers())
                    {
                        p.getInventory().addItem(key);
                        p.sendMessage(ChatUtil.fixColorsWithPrefix("&aotrzymales &8(&fx" + amount + "&8) &e" + args[0] + " key"));
                    }
                    Bukkit.broadcastMessage(ChatUtil.fixColorsWithPrefix("&eCaly serwer otrzymal &8(&fx" + amount + "&8) &e" + args[0] + " key"));
                }
                else {
                    if(Bukkit.getPlayer(args[2]) != null && Bukkit.getPlayer(args[2]).isOnline())
                    {
                        ItemStack key = PremiumKey.getKey(args[0], amount);
                        Player player = Bukkit.getPlayer(args[2]);
                        player.getInventory().addItem(key);
                        player.sendMessage(ChatUtil.fixColorsWithPrefix("&aotrzymales &8(&fx" + amount + "&8) &e" + args[0] + " key"));
                    }
                    else
                    {
                        sender.sendMessage("Podany gracz jest offline");
                    }
                }


            }
            else
            {
                sender.sendMessage("/key [nazwa skrzynki] [ilosc] [gracz]");
            }

            return false;
        }
        else
        {
            sender.sendMessage(ChatUtil.fixColorsWithPrefix("&cNie posiadasz uprawnien"));
        }

        return false;
    }

}
