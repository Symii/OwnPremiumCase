package me.symi.owncase.keys;

import java.util.Arrays;

import me.symi.owncase.utils.ChatUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PremiumKey {

    public static ItemStack getKey(String case_name, int amount)
    {
        ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK, amount);
        ItemMeta key_meta = key.getItemMeta();
        key_meta.setDisplayName(ChatUtil.fixColors("&dKlucz do " + case_name + " skrzynki"));
        key_meta.setLore(Arrays.asList(
                ChatUtil.fixColors("&6Otworzysz tym &e" + case_name + " &6skrzynke")));
        key.setItemMeta(key_meta);

        return key;
    }

}
