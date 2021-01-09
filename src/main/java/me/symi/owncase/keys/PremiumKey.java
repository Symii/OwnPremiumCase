package me.symi.owncase.keys;

import java.util.Arrays;

import me.symi.owncase.utils.ChatUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PremiumKey {

    public static ItemStack NormalKey(int amount)
    {
        ItemStack normalKey = new ItemStack(Material.TRIPWIRE_HOOK, amount);
        ItemMeta normalKeyMeta = normalKey.getItemMeta();
        normalKeyMeta.setDisplayName(ChatUtil.format("&7Klucz do zwyklej skrzynki"));
        normalKeyMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Otworzysz tym &7zwykla &6skrzynke")));
        normalKey.setItemMeta(normalKeyMeta);

        return normalKey;
    }

    public static ItemStack RareKey(int amount)
    {
        ItemStack rareKey = new ItemStack(Material.TRIPWIRE_HOOK, amount);
        ItemMeta rareKeyMeta = rareKey.getItemMeta();
        rareKeyMeta.setDisplayName(ChatUtil.format("&bKlucz do rzadkiej skrzynki"));
        rareKeyMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Otworzysz &brzadka &6skrzynke")));
        rareKey.setItemMeta(rareKeyMeta);

        return rareKey;
    }

    public static ItemStack EpicKey(int amount)
    {
        ItemStack epicKey = new ItemStack(Material.TRIPWIRE_HOOK, amount);
        ItemMeta epicKeyMeta = epicKey.getItemMeta();
        epicKeyMeta.setDisplayName(ChatUtil.format("&5Klucz do epickiej skrzynki"));
        epicKeyMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Otworzysz &5epicka &6skrzynke")));
        epicKey.setItemMeta(epicKeyMeta);

        return epicKey;
    }

    public static ItemStack LegendaryKey(int amount)
    {
        ItemStack legendaryKey = new ItemStack(Material.TRIPWIRE_HOOK, amount);
        ItemMeta legendaryKeyMeta = legendaryKey.getItemMeta();
        legendaryKeyMeta.setDisplayName(ChatUtil.format("&eKlucz do legendarnej skrzynki"));
        legendaryKeyMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Otworzysz &elegendarna &6skrzynke")));
        legendaryKey.setItemMeta(legendaryKeyMeta);

        return legendaryKey;
    }

    public static ItemStack KrupierKey(int amount)
    {
        ItemStack krupierKey = new ItemStack(Material.TRIPWIRE_HOOK, amount);
        ItemMeta krupierKeyMeta = krupierKey.getItemMeta();
        krupierKeyMeta.setDisplayName(ChatUtil.format("&5Klucz do skrzynki krupiera"));
        krupierKeyMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Otworzysz skrzynke &5krupiera")));
        krupierKey.setItemMeta(krupierKeyMeta);

        return krupierKey;
    }

}
