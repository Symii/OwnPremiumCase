package me.symi.owncase.utils;

import org.bukkit.ChatColor;

public class ChatUtil {

    public static String format(String text)
    {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String fixColors(String text)
    {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String fixColorsWithPrefix(String text)
    {
        return "§f§lO§9§lC §8| " + ChatColor.translateAlternateColorCodes('&', text);
    }

}
