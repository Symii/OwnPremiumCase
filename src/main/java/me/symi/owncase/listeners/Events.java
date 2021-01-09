package me.symi.owncase.listeners;

import java.util.ArrayList;
import java.util.Random;

import me.symi.owncase.Main;
import me.symi.owncase.owncase.OwnCase;
import me.symi.owncase.preview.SInventory;
import me.symi.owncase.utils.ChatUtil;
import me.symi.owncase.utils.RandomUtil;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class Events implements Listener {

    Main plugin = Main.getPlugin(Main.class);

    ArrayList<Player> items = new ArrayList<Player>();

    @EventHandler
    private void invClick(InventoryClickEvent e)
    {
        if(e.getClickedInventory() == null)
        {
            return;
        }

        if(e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&6&lDrop &8- &7zwykla skrzynka"))
                || e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&6&lDrop &8- &brzadka skrzynka"))
                || e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&6&lDrop &8- &5epicka skrzynka"))
                || e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&6&lDrop &8- &elegendarna skrzynka"))
                || e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&6&lDrop &8- &dSkrzynka krupiera")))
        {
            e.setCancelled(true);
        }
        else if(e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&5Skrzynka Krupiera")))
        {
            e.setCancelled(true);
        }
        else if(e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&7Normalna skrzynka")))
        {
            e.setCancelled(true);
        }
        else if(e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&bRzadka skrzynka")))
        {
            e.setCancelled(true);
        }
        else if(e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&5Epicka skrzynka")))
        {
            e.setCancelled(true);
        }
        else if(e.getView().getTitle().equalsIgnoreCase(ChatUtil.format("&eLegendarna skrzynka")))
        {
            e.setCancelled(true);
        }
    }



    @EventHandler(priority = EventPriority.HIGH)
    private void blockPlace(BlockPlaceEvent e)
    {
        if(e.getItemInHand().getItemMeta() == null || !e.getItemInHand().hasItemMeta()
                || e.getItemInHand().getItemMeta().getDisplayName() == null)
        {
            return;
        }

        if(e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&7Klucz do zwyklej skrzynki"))
                || e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&bKlucz do rzadkiej skrzynki"))
                || e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&5Klucz do epickiej skrzynki"))
                || e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&eKlucz do legendarnej skrzynki"))
                || e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.format("&5Klucz do skrzynki krupiera")))
        {
            e.setCancelled(true);
        }

    }


    @EventHandler
    private void playerInteract(PlayerInteractEvent e)
    {
        if(!e.getPlayer().getWorld().getName().equalsIgnoreCase("freebuild"))
        {
            return;
        }

        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().getType() == Material.CHEST)
        {
            final Player player = e.getPlayer();
            final OwnCase symiCase = Main.getInst().getOwnCase();

            if(symiCase.isNormalCase(e.getClickedBlock().getLocation()))
            {
                e.setCancelled(true);
                if(symiCase.hasNormalKey(player))
                {
                    normalCaseRoll(player);
                    firework(e.getClickedBlock().getLocation());
                }
                else
                {
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&7nie posiadasz klucza do &fzwyklej skrzynki!"));
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                }
            }
            else if(symiCase.isRareCase(e.getClickedBlock().getLocation()))
            {
                e.setCancelled(true);
                if(symiCase.hasRareKey(player))
                {
                    rareCaseRoll(player);
                    firework(e.getClickedBlock().getLocation());
                }
                else
                {
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&7nie posiadasz klucza do &brzadkiej skrzynki!"));
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                }
            }
            else if(symiCase.isEpicCase(e.getClickedBlock().getLocation()))
            {
                e.setCancelled(true);
                if(symiCase.hasEpicKey(player))
                {
                    epicCaseRoll(player);
                    firework(e.getClickedBlock().getLocation());
                }
                else
                {
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&7nie posiadasz klucza do &5epickiej skrzynki!"));
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                }
            }
            else if(symiCase.isLegendaryCase(e.getClickedBlock().getLocation()))
            {
                e.setCancelled(true);
                if(symiCase.hasLegendaryKey(player))
                {
                    legendaryCaseRoll(player);
                    firework(e.getClickedBlock().getLocation());
                }
                else
                {
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&7nie posiadasz klucza do &elegendarnej skrzynki!"));
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                }
            }
            else if(symiCase.isKasynoCase(e.getClickedBlock().getLocation()))
            {
                e.setCancelled(true);
                if(symiCase.hasKasynoKey(player))
                {
                    kasynoCaseRoll(player);
                    firework(e.getClickedBlock().getLocation());
                }
                else
                {
                    player.sendMessage(ChatUtil.fixColorsWithPrefix("&7nie posiadasz klucza do &dskrzynki krupiera!"));
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                }
            }
        }
        else if(e.getAction().equals(Action.LEFT_CLICK_BLOCK) && e.getClickedBlock().getType() == Material.CHEST)
        {
            SInventory inv = new SInventory();
            Player player = e.getPlayer();
            OwnCase symiCase = Main.getInst().getOwnCase();

            if(symiCase.isNormalCase(e.getClickedBlock().getLocation()))
            {
                player.openInventory(inv.getNormalCase(player));
                e.setCancelled(true);
            }
            else if(symiCase.isRareCase(e.getClickedBlock().getLocation()))
            {
                player.openInventory(inv.getRareCase(player));
                e.setCancelled(true);
            }
            else if(symiCase.isEpicCase(e.getClickedBlock().getLocation()))
            {
                player.openInventory(inv.getEpicCase(player));
                e.setCancelled(true);
            }
            else if(symiCase.isLegendaryCase(e.getClickedBlock().getLocation()))
            {
                player.openInventory(inv.getLegendaryCase(player));
                e.setCancelled(true);
            }
            else if(symiCase.isKasynoCase(e.getClickedBlock().getLocation()))
            {
                player.openInventory(inv.getKasynoCase(player));
                e.setCancelled(true);
            }

        }
    }

    private void kasynoCaseRoll(final Player p)
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

                    p.openInventory(createKasynoCase(p, "&5Skrzynka Krupiera"));
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.5f, 1.5f);
                }
            }.runTaskLater(Main.getInst(), (int) (i * i - (i * i * 0.95)));
        }
    }

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

    private void rareCaseRoll(final Player p)
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

                    p.openInventory(createRareCase(p, "&bRzadka skrzynka"));
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.5f, 1.5f);
                }
            }.runTaskLater(Main.getInst(), (int) (i * i - (i * i * 0.95)));
        }

    }

    private void epicCaseRoll(final Player p)
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

                    p.openInventory(createEpicCase(p, "&5Epicka skrzynka"));
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.5f, 1.5f);
                }
            }.runTaskLater(Main.getInst(), (int) (i * i - (i * i * 0.95)));
        }


    }

    private void legendaryCaseRoll(final Player p)
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

                    p.openInventory(createLegendaryCase(p, "&eLegendarna skrzynka"));
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.5f, 1.5f);
                }
            }.runTaskLater(Main.getInst(), (int) (i * i - (i * i * 0.95)));
        }


    }


    private Inventory createKasynoCase(Player p, String nazwa)
    {
        Inventory inv;

        if(Main.getInst().playerCase.get(p.getUniqueId()) == null)
        {
            inv = Bukkit.createInventory(p, 27, ChatUtil.format(nazwa));
            ItemStack black = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemStack hopper = new ItemStack(Material.HOPPER);

            ItemStack blank = new ItemStack(Material.BARRIER);

            RandomUtil random = new RandomUtil();

            ItemStack item = random.getRandomKasynoItem();


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

            ItemStack item = random.getRandomKasynoItem();


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
                Bukkit.broadcastMessage(ChatUtil.format("&8» &5&lSkrzynka Krupiera &8« &a" + p.getName() + " &fwylosowal &6KOSMICZNY_DIRT &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
                p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 100f, 100f);
            }
            else
            {
                Bukkit.broadcastMessage(ChatUtil.format("&8» &5&lSkrzynka Krupiera &8« &a" + p.getName() + " &fwylosowal &6" + inv.getItem(13).getType() + " &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
            }

            firework(p);
        }


        return inv;
    }

    private Inventory createNormalCase(Player p, String nazwa)
    {
        Inventory inv;

        if(Main.getInst().playerCase.get(p.getUniqueId()) == null)
        {
            inv = Bukkit.createInventory(p, 27, ChatUtil.format(nazwa));
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
                p.sendMessage(ChatUtil.format("&8» &7Normalna skrzynka &8« &a" + p.getName() + " &fwylosowal &6KOSMICZNY_DIRT &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
                p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 100f, 100f);
            }
            else
            {
                p.sendMessage(ChatUtil.format("&8» &7Normalna skrzynka &8« &a" + p.getName() + " &fwylosowal &6" + inv.getItem(13).getType() + " &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
            }

            firework(p);
        }


        return inv;
    }

    private Inventory createRareCase(Player p, String nazwa)
    {
        Inventory inv;

        if(Main.getInst().playerCase.get(p.getUniqueId()) == null)
        {
            inv = Bukkit.createInventory(p, 27, ChatUtil.format(nazwa));
            ItemStack black = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemStack hopper = new ItemStack(Material.HOPPER);

            ItemStack blank = new ItemStack(Material.BARRIER, 1);

            RandomUtil random = new RandomUtil();

            ItemStack item = random.getRandomRareItem();


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

            ItemStack item = random.getRandomRareItem();


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
                p.sendMessage(ChatUtil.format("&8» &bRzadka skrzynka &8« &a" + p.getName() + " &fwylosowal &6KOSMICZNY_DIRT &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
                p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 100f, 100f);
            }
            else
            {
                p.sendMessage(ChatUtil.format("&8» &bRzadka skrzynka &8« &a" + p.getName() + " &fwylosowal &6" + inv.getItem(13).getType() + " &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
            }

            firework(p);
        }


        return inv;
    }

    private Inventory createEpicCase(Player p, String nazwa)
    {
        Inventory inv;

        if(Main.getInst().playerCase.get(p.getUniqueId()) == null)
        {
            inv = Bukkit.createInventory(p, 27, ChatUtil.format(nazwa));
            ItemStack black = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemStack hopper = new ItemStack(Material.HOPPER);

            ItemStack blank = new ItemStack(Material.BARRIER, 1);

            RandomUtil random = new RandomUtil();

            ItemStack item = random.getRandomEpicItem();


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

            ItemStack item = random.getRandomEpicItem();


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
                Bukkit.broadcastMessage(ChatUtil.format("&8» &5Epicka skrzynka &8« &a" + p.getName() + " &fwylosowal &6KOSMICZNY_DIRT &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
                p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 100f, 100f);
            }
            else
            {
                Bukkit.broadcastMessage(ChatUtil.format("&8» &5Epicka skrzynka &8« &a" + p.getName() + " &fwylosowal &6" + inv.getItem(13).getType() + " &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
            }

            firework(p);
        }


        return inv;
    }

    private Inventory createLegendaryCase(Player p, String nazwa)
    {
        Inventory inv;

        if(Main.getInst().playerCase.get(p.getUniqueId()) == null)
        {
            inv = Bukkit.createInventory(p, 27, ChatUtil.format(nazwa));
            ItemStack black = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemStack hopper = new ItemStack(Material.HOPPER);

            ItemStack blank = new ItemStack(Material.BARRIER, 1);

            RandomUtil random = new RandomUtil();

            ItemStack item = random.getRandomLegendaryItem();


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

            ItemStack item = random.getRandomLegendaryItem();


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
                Bukkit.broadcastMessage(ChatUtil.format("&8» &eLegendarna skrzynka &8« &a" + p.getName() + " &fwylosowal &6KOSMICZNY_DIRT &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
                p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 100f, 100f);
            }
            else
            {
                Bukkit.broadcastMessage(ChatUtil.format("&8» &eLegendarna skrzynka &8« &a" + p.getName() + " &fwylosowal &6" + inv.getItem(13).getType() + " &8(&fx" + inv.getItem(13).getAmount() + "&8)"));
            }

            firework(p);
        }

        return inv;
    }


    private void firework(HumanEntity p)
    {
        final FireworkEffect.Builder fb = FireworkEffect.builder();
        final Random r = new Random();
        FireworkEffect f = null;
        fb.withColor(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        final FireworkEffect.Type[] type = FireworkEffect.Type.values();
        fb.with(type[r.nextInt(type.length)]);
        if (r.nextInt(3) == 0) {
            fb.withTrail();
        }
        if (r.nextInt(2) == 0) {
            fb.withFade(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        }
        if (r.nextInt(3) == 0) {
            fb.withFlicker();
        }
        f = fb.build();


        Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);

        final FireworkMeta fwm = fw.getFireworkMeta();
        fwm.clearEffects();
        fwm.addEffect(f);
        fwm.setPower(1);
        fw.setFireworkMeta(fwm);
    }

    private void firework(Location loc)
    {
        final FireworkEffect.Builder fb = FireworkEffect.builder();
        final Random r = new Random();
        FireworkEffect f = null;
        fb.withColor(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        final FireworkEffect.Type[] type = FireworkEffect.Type.values();
        fb.with(type[r.nextInt(type.length)]);
        if (r.nextInt(3) == 0) {
            fb.withTrail();
        }
        if (r.nextInt(2) == 0) {
            fb.withFade(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        }
        if (r.nextInt(3) == 0) {
            fb.withFlicker();
        }
        f = fb.build();


        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);

        final FireworkMeta fwm = fw.getFireworkMeta();
        fwm.clearEffects();
        fwm.addEffect(f);
        fwm.setPower(1);
        fw.setFireworkMeta(fwm);
    }

}
