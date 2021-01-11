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
        normalKeyMeta.setDisplayName(ChatUtil.fixColors("&7Klucz do zwyklej skrzynki"));
        normalKeyMeta.setLore(Arrays.asList(
                ChatUtil.fixColors("&6Otworzysz tym &7zwykla &6skrzynke")));
        normalKey.setItemMeta(normalKeyMeta);

        return normalKey;
    }

}
