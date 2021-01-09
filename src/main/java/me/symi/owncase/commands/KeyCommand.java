package me.symi.owncase.commands;

import me.symi.owncase.Main;
import me.symi.owncase.keys.PremiumKey;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.command.CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
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
                    if(args[0].equalsIgnoreCase("all"))
                    {
                        ItemStack normal = PremiumKey.NormalKey(amount);
                        ItemStack rare = PremiumKey.RareKey(amount);
                        ItemStack epic = PremiumKey.EpicKey(amount);
                        ItemStack legend = PremiumKey.LegendaryKey(amount);

                        for(Player player : Bukkit.getOnlinePlayers())
                        {
                            player.getInventory().addItem(legend);
                            player.getInventory().addItem(epic);
                            player.getInventory().addItem(rare);
                            player.getInventory().addItem(normal);
                        }

                        Bukkit.broadcastMessage(ChatUtil.format("&f&lO&9&lC &8» &9Caly serwer otrzymal &8(&fx" + amount + "&8) &enormal, rare, epic, legendary key"));
                    }
                    else if(args[0].equalsIgnoreCase("normal"))
                    {
                        ItemStack normal = PremiumKey.NormalKey(amount);

                        for(Player p : Bukkit.getOnlinePlayers())
                        {
                            p.getInventory().addItem(normal);
                        }


                        Bukkit.broadcastMessage(ChatUtil.format("&f&lO&9&lC &8» &9Caly serwer otrzymal &8(&fx" + amount + "&8) &enormal key"));
                    }
                    else if(args[0].equalsIgnoreCase("rare"))
                    {
                        ItemStack rare = PremiumKey.RareKey(amount);

                        for(Player p : Bukkit.getOnlinePlayers())
                        {
                            p.getInventory().addItem(rare);
                        }


                        Bukkit.broadcastMessage(ChatUtil.format("&f&lO&9&lC &8» &9Caly serwer otrzymal &8(&fx" + amount + "&8) &erare key"));
                    }
                    else if(args[0].equalsIgnoreCase("epic"))
                    {
                        ItemStack epic = PremiumKey.EpicKey(amount);

                        for(Player p : Bukkit.getOnlinePlayers())
                        {
                            p.getInventory().addItem(epic);
                        }


                        Bukkit.broadcastMessage(ChatUtil.format("&f&lO&9&lC &8» &9Caly serwer otrzymal &8(&fx" + amount + "&8) &eepic key"));
                    }
                    else if(args[0].equalsIgnoreCase("legend"))
                    {
                        ItemStack legend = PremiumKey.LegendaryKey(amount);

                        for(Player p : Bukkit.getOnlinePlayers())
                        {
                            p.getInventory().addItem(legend);
                        }


                        Bukkit.broadcastMessage(ChatUtil.format("&f&lO&9&lC &8» &9Caly serwer otrzymal &8(&fx" + amount + "&8) &elegendary key"));
                    }
                    else
                    {
                        sender.sendMessage("/key [normal;rare;epic;legend;all] [ilosc] [gracz;all]");
                    }




                }
                else if(Bukkit.getPlayer(args[2]) != null && Bukkit.getPlayer(args[2]).isOnline())
                {
                    if(args[0].equalsIgnoreCase("normal"))
                    {
                        ItemStack normal = PremiumKey.NormalKey(amount);
                        Player p = Bukkit.getPlayer(args[2]);
                        p.getInventory().addItem(normal);
                        p.sendMessage(ChatUtil.format("&f&lO&9&lC &8» &aotrzymales &8(&fx" + amount + "&8) &enormal key"));
                    }
                    else if(args[0].equalsIgnoreCase("rare"))
                    {
                        ItemStack rare = PremiumKey.RareKey(amount);
                        Player p = Bukkit.getPlayer(args[2]);
                        p.getInventory().addItem(rare);
                        p.sendMessage(ChatUtil.format("&f&lO&9&lC &8» &aotrzymales &8(&fx" + amount + "&8) &erare key"));
                    }
                    else if(args[0].equalsIgnoreCase("epic"))
                    {
                        ItemStack epic = PremiumKey.EpicKey(amount);
                        Player p = Bukkit.getPlayer(args[2]);
                        p.getInventory().addItem(epic);
                        p.sendMessage(ChatUtil.format("&f&lO&9&lC &8» &aotrzymales &8(&fx" + amount + "&8) &eepic key"));
                    }
                    else if(args[0].equalsIgnoreCase("legend"))
                    {
                        ItemStack legend = PremiumKey.LegendaryKey(amount);
                        Player p = Bukkit.getPlayer(args[2]);
                        p.getInventory().addItem(legend);
                        p.sendMessage(ChatUtil.format("&f&lO&9&lC &8» &aotrzymales &8(&fx" + amount + "&8) &elegendary key"));
                    }
                    else if(args[0].equalsIgnoreCase("all"))
                    {
                        Player p = Bukkit.getPlayer(args[2]);

                        ItemStack normal = PremiumKey.NormalKey(amount);
                        ItemStack rare = PremiumKey.RareKey(amount);
                        ItemStack epic = PremiumKey.EpicKey(amount);
                        ItemStack legend = PremiumKey.LegendaryKey(amount);

                        p.getInventory().addItem(normal);
                        p.getInventory().addItem(rare);
                        p.getInventory().addItem(epic);
                        p.getInventory().addItem(legend);

                        p.sendMessage(ChatUtil.format("&f&lO&9&lC &8» &aotrzymales &8(&fx" + amount + "&8) &enormal, rare, epic, legendary key"));
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
                    p.sendMessage(ChatUtil.format(plugin.prefix + "&cpodaj liczbe calkowita"));
                    return false;
                }


                ItemStack normalKey = PremiumKey.NormalKey(amount);
                ItemStack rareKey = PremiumKey.RareKey(amount);
                ItemStack epicKey = PremiumKey.EpicKey(amount);
                ItemStack legendaryKey = PremiumKey.LegendaryKey(amount);
                ItemStack kasynoKey = PremiumKey.KrupierKey(amount);

                p.getInventory().addItem(normalKey);
                p.getInventory().addItem(rareKey);
                p.getInventory().addItem(epicKey);
                p.getInventory().addItem(kasynoKey);
                p.getInventory().addItem(legendaryKey);
            }
            else
            {
                p.sendMessage(ChatUtil.format(plugin.prefix + "&c/key [ilosc]"));
            }
        }
        else
        {
            p.sendMessage(ChatUtil.format(plugin.prefix + "Zakup usluge na &6https://owncraft.eu"));
        }

        return false;
    }

}
