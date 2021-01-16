package me.symi.owncase.commands;

import me.symi.owncase.Main;
import me.symi.owncase.gui.CaseCreateGUI;
import me.symi.owncase.gui.SInventory;
import me.symi.owncase.keys.PremiumKey;
import me.symi.owncase.utils.CaseRollUtil;
import me.symi.owncase.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class CaseCommand implements CommandExecutor {

    private final Main plugin;

    public CaseCommand(Main plugin)
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
        if(player.hasPermission("ownpremiumcase.case"))
        {
            if(args.length == 2)
            {
                if(args[0].equalsIgnoreCase("edit"))
                {
                    String case_name = args[1];
                    try {
                        player.openInventory(CaseCreateGUI.getEditInventory(player, case_name));
                    } catch (IOException | InvalidConfigurationException e) {
                        player.sendMessage(ChatUtil.fixColorsWithPrefix("&cBłąd... Zglos to do autora pluginu."));
                    }
                }
                else if(args[0].equalsIgnoreCase("create"))
                {
                    String case_name = args[1];
                    player.openInventory(CaseCreateGUI.getInventory(player, case_name));
                }
                else if(args[0].equalsIgnoreCase("roll"))
                {
                    boolean has_key = false;
                    ItemStack key = PremiumKey.getKey(args[1], 1);
                    for(ItemStack item : player.getInventory().getContents())
                    {
                        if(item == null) continue;
                        if(item.hasItemMeta() && item.getItemMeta().getDisplayName().equalsIgnoreCase(key.getItemMeta().getDisplayName()))
                        {
                            has_key = true;
                            item.setAmount(item.getAmount() - 1);
                            break;
                        }
                    }

                    if(has_key)
                    {
                        CaseRollUtil caseRollUtil = new CaseRollUtil();
                        caseRollUtil.rollCase(player, args[1]);
                    }
                    else
                    {
                        player.sendMessage(ChatUtil.fixColorsWithPrefix("&cNie posiadasz klucza do skrzynki &e" + args[1]));
                    }
                }
                else if(args[0].equalsIgnoreCase("preview"))
                {
                    try {
                        player.openInventory(SInventory.getCasePreview(player, args[1]));
                    } catch (IOException | InvalidConfigurationException e) {
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                player.sendMessage(ChatUtil.fixColorsWithPrefix("&c/case create <nazwa skrzynki>"));
                player.sendMessage(ChatUtil.fixColorsWithPrefix("&c/case preview <nazwa skrzynki>"));
                player.sendMessage(ChatUtil.fixColorsWithPrefix("&c/case roll <nazwa skrzynki>"));
            }
        }

        return false;
    }
}
