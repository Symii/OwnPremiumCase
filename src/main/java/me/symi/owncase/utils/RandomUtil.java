package me.symi.owncase.utils;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RandomUtil {

    public ItemStack getRandomNormalItem()
    {
        ItemStack item = new ItemStack(Material.AIR, 1);
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


        switch(new Random().nextInt(15) + 1)
        {
            case 1:
                item = shulker;
                item.setAmount(1);
                break;
            case 2:
                item = sea;
                item.setAmount(new Random().nextInt(3) + 1);
                break;
            case 3:
                item = hay;
                item.setAmount(new Random().nextInt(4) + 1);
                break;
            case 4:
                item = sponge;
                item.setAmount(new Random().nextInt(3) + 1);
                break;
            case 5:
                item = diamond;
                item.setAmount(new Random().nextInt(2) + 1);
                break;
            case 6:
                item = emerald;
                item.setAmount(new Random().nextInt(2) + 1);
                break;
            case 7:
                item = gold;
                item.setAmount(new Random().nextInt(3) + 1);
                break;
            case 8:
                item = iron;
                item.setAmount(new Random().nextInt(3) + 1);
                break;
            case 9:
                item = obsidian;
                item.setAmount(new Random().nextInt(4) + 1);
                break;
            case 10:
                item = observer;
                item.setAmount(new Random().nextInt(2) + 1);
                break;
            case 11:
                item = redstone;
                item.setAmount(new Random().nextInt(4) + 1);
                break;
            default:
                item = dirt;
                break;

        }

        return item;
    }


}
