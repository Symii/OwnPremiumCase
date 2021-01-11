package me.symi.owncase.utils;

import me.symi.owncase.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class CaseRollUtil {

    private ArrayList<Player> items = new ArrayList<>();

    private void normalCaseRoll(final Player p)
    {
        for(int i = 1; i <= 40; i++)
        {
            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    int j = 1;
                    if(Main.getInst().current.get(p.getUniqueId()) != null)
                    {
                        j = Main.getInst().current.get(p.getUniqueId()) + 1;
                    }
                    Main.getInst().current.put(p.getUniqueId(), j);

                    p.openInventory(createNormalCase(p, "&7Normalna skrzynka"));
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.5f, 1.5f);
                }
            }.runTaskLater(Main.getInst(), (int) (i * i - (i * i * 0.95)));
        }

    }

    private Inventory createNormalCase(Player p, String nazwa)
    {
        Inventory inv;

        if(Main.getInst().playerCase.get(p.getUniqueId()) == null)
        {
            inv = Bukkit.createInventory(p, 27, ChatUtil.fixColors(nazwa));
            ItemStack black = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemStack hopper = new ItemStack(Material.HOPPER);

            ItemStack blank = new ItemStack(Material.BARRIER, 1);

            RandomUtil random = new RandomUtil();

            ItemStack item = random.getRandomNormalItem();


            inv.setItem(0, black);
            inv.setItem(1, black);
            inv.setItem(2, black);
            inv.setItem(3, black);
            inv.setItem(4, hopper);
            inv.setItem(5, black);
            inv.setItem(6, black);
            inv.setItem(7, black);
            inv.setItem(8, black);

            inv.setItem(9, blank);
            inv.setItem(10, blank);
            inv.setItem(11, blank);
            inv.setItem(12, blank);
            inv.setItem(13, blank);
            inv.setItem(14, blank);
            inv.setItem(15, blank);
            inv.setItem(16, blank);
            inv.setItem(17, item);

            inv.setItem(18, black);
            inv.setItem(19, black);
            inv.setItem(20, black);
            inv.setItem(21, black);
            inv.setItem(22, hopper);
            inv.setItem(23, black);
            inv.setItem(24, black);
            inv.setItem(25, black);
            inv.setItem(26, black);

            Main.getInst().playerCase.put(p.getUniqueId(), inv);
        }
        else
        {
            inv = Main.getInst().playerCase.get(p.getUniqueId());
            ItemStack black = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemStack hopper = new ItemStack(Material.HOPPER);

            RandomUtil random = new RandomUtil();

            ItemStack item = random.getRandomNormalItem();


            inv.setItem(0, black);
            inv.setItem(1, black);
            inv.setItem(2, black);
            inv.setItem(3, black);
            inv.setItem(4, hopper);
            inv.setItem(5, black);
            inv.setItem(6, black);
            inv.setItem(7, black);
            inv.setItem(8, black);

            inv.setItem(9, inv.getItem(10));
            inv.setItem(10, inv.getItem(11));
            inv.setItem(11, inv.getItem(12));
            inv.setItem(12, inv.getItem(13));
            inv.setItem(13, inv.getItem(14));
            inv.setItem(14, inv.getItem(15));
            inv.setItem(15, inv.getItem(16));
            inv.setItem(16, inv.getItem(17));
            inv.setItem(17, item);

            inv.setItem(18, black);
            inv.setItem(19, black);
            inv.setItem(20, black);
            inv.setItem(21, black);
            inv.setItem(22, hopper);
            inv.setItem(23, black);
            inv.setItem(24, black);
            inv.setItem(25, black);
            inv.setItem(26, black);

            Main.getInst().playerCase.put(p.getUniqueId(), inv);
        }

        if(Main.getInst().current.get(p.getUniqueId()) != null
                && Main.getInst().current.get(p.getUniqueId()) >= 40)
        {
            Main.getInst().current.remove(p.getUniqueId());
            Main.getInst().playerCase.remove(p.getUniqueId());

            p.getInventory().addItem(inv.getItem(13));

            if(inv.getItem(13).getType() == Material.DIRT)
            {
                p.sendMessage(ChatUtil.fixColors("&8» &7Normalna skrzynka &8« &a" + p.getName() + " &fwylosowal &6KOSMICZNY_DIRT &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
                p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 100f, 100f);
            }
            else
            {
                p.sendMessage(ChatUtil.fixColors("&8» &7Normalna skrzynka &8« &a" + p.getName() + " &fwylosowal &6" + inv.getItem(13).getType() + " &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
            }

            FireworkUtil.spawnFirework(p);
        }


        return inv;
    }

}
