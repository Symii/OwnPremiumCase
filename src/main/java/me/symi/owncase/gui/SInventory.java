package me.symi.owncase.gui;

import me.symi.owncase.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class SInventory {


    public Inventory getNormalCase(Player p)
    {
        Inventory inv = Bukkit.createInventory(p, 27, ChatUtil.fixColors("&6&lDrop &8- &7zwykla skrzynka"));

        ItemStack black = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);

        ItemStack shulker = new ItemStack(Material.WHITE_SHULKER_BOX, 1); // 1
        ItemStack sea = new ItemStack(Material.SEA_LANTERN, 1); // 2
        ItemStack hay = new ItemStack(Material.HAY_BLOCK, 1); // 3
        ItemStack sponge = new ItemStack(Material.SPONGE, 1); // 4
        ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK, 1); // 5
        ItemStack emerald = new ItemStack(Material.EMERALD_BLOCK, 1); // 6
        ItemStack gold = new ItemStack(Material.GOLD_BLOCK, 1); // 7
        ItemStack iron = new ItemStack(Material.IRON_BLOCK, 1); // 8
        ItemStack obsidian = new ItemStack(Material.OBSIDIAN, 1); // 9
        ItemStack observer = new ItemStack(Material.OBSERVER, 1); // 10
        ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK, 1); // 11
        ItemStack dirt = new ItemStack(Material.DIRT, 1); // 9 - 10
        ItemMeta dirtMeta = dirt.getItemMeta();
        dirtMeta.setDisplayName(ChatUtil.fixColors("&9&lKosmiczny dirt"));
        dirt.setItemMeta(dirtMeta);





        inv.setItem(0, black);
        inv.setItem(1, shulker);
        inv.setItem(2, black);
        inv.setItem(3, sea);
        inv.setItem(4, black);
        inv.setItem(5, hay);
        inv.setItem(6, black);
        inv.setItem(7, sponge);
        inv.setItem(8, black);
        inv.setItem(9, diamond);
        inv.setItem(10, black);
        inv.setItem(11, emerald);
        inv.setItem(12, black);
        inv.setItem(13, gold);
        inv.setItem(14, black);
        inv.setItem(15, iron);
        inv.setItem(16, black);
        inv.setItem(17, obsidian);
        inv.setItem(18, black);
        inv.setItem(19, observer);
        inv.setItem(20, black);
        inv.setItem(21, redstone);
        inv.setItem(22, black);
        inv.setItem(23, dirt);
        inv.setItem(24, black);
        inv.setItem(25, black);
        inv.setItem(26, black);

        return inv;
    }


}
