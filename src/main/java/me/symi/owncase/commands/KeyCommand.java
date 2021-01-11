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

    Main plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args)
    {

        if(!(sender instanceof Player))
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
                    sender.sendMessage("/key [normal;rare;epic;legend;all] [ilosc] [gracz;all]");
                }

                if(amount <= 0)
                {
                    sender.sendMessage("Podaj liczbe wieksza od 0");
                    return false;
                }

                if(args[2].equalsIgnoreCase("all"))
                {
                    if(args[0].equalsIgnoreCase("normal"))
                    {
                        ItemStack normal = PremiumKey.NormalKey(amount);

                        for(Player p : Bukkit.getOnlinePlayers())
                        {
                            p.getInventory().addItem(normal);
                        }

                        Bukkit.broadcastMessage(ChatUtil.fixColorsWithPrefix("&9Caly serwer otrzymal &8(&fx" + amount + "&8) &enormal key"));
                    }
                    else
                    {
                        sender.sendMessage("/key [normal] [ilosc] [gracz;all]");
                    }
                }
                else if(Bukkit.getPlayer(args[2]) != null && Bukkit.getPlayer(args[2]).isOnline())
                {
                    if(args[0].equalsIgnoreCase("normal"))
                    {
                        ItemStack normal = PremiumKey.NormalKey(amount);
                        Player p = Bukkit.getPlayer(args[2]);
                        p.getInventory().addItem(normal);
                        p.sendMessage(ChatUtil.fixColorsWithPrefix("&aotrzymales &8(&fx" + amount + "&8) &enormal key"));
                    }
                    else if(args[0].equalsIgnoreCase("all"))
                    {
                        Player p = Bukkit.getPlayer(args[2]);

                        ItemStack normal = PremiumKey.NormalKey(amount);

                        p.getInventory().addItem(normal);
                        p.sendMessage(ChatUtil.fixColorsWithPrefix("&aotrzymales &8(&fx" + amount + "&8) &enormal, rare, epic, legendary key"));
                    }
                    else
                    {
                        sender.sendMessage("/key [normal;rare;epic;legend;all] [ilosc] [gracz;all]");
                    }
                }
                else
                {
                    sender.sendMessage("Podany gracz jest offline");
                }
            }
            else
            {
                sender.sendMessage("/key [normal;rare;epic;legend;all] [ilosc] [gracz;all]");
            }

            return false;
        }

        Player p = (Player) sender;

        if(p.hasPermission("symi.case.admin"))
        {
            if(args.length == 1)
            {
                int amount = 1;
                try
                {
                    amount = Integer.parseInt(args[0]);
                }
                catch(Exception e)
                {
                    p.sendMessage(ChatUtil.fixColorsWithPrefix("&cpodaj liczbe calkowita"));
                    return false;
                }


                ItemStack normalKey = PremiumKey.NormalKey(amount);

                p.getInventory().addItem(normalKey);
            }
            else
            {
                p.sendMessage(ChatUtil.fixColorsWithPrefix("&c/key [ilosc]"));
            }
        }
        else
        {
            p.sendMessage(ChatUtil.fixColorsWithPrefix("Zakup usluge na &6https://owncraft.eu"));
        }

        return false;
    }

}
