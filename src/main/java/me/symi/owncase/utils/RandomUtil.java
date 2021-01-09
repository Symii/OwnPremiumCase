package me.symi.owncase.utils;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RandomUtil {

    public ItemStack getRandomKasynoItem()
    {
        ItemStack item = new ItemStack(Material.AIR, 1);
        ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1); // 1
        ItemMeta meta = axe.getItemMeta();
        meta.setDisplayName(ChatUtil.format("&5Siekiera krupiera"));
        axe.setItemMeta(meta);
        axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 6);
        axe.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1); // 2
        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
        pickaxeMeta.setDisplayName(ChatUtil.format("&5Kilof krupiera"));
        pickaxe.setItemMeta(pickaxeMeta);
        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1); // 3
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatUtil.format("&5Miecz krupiera"));
        sword.setItemMeta(swordMeta);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
        sword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);

        ItemStack bow = new ItemStack(Material.BOW, 1); // 4
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatUtil.format("&5Luk krupiera"));
        bow.setItemMeta(bowMeta);
        bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
        bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
        bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);

        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1); // 5
        ItemMeta helmetMeta = bow.getItemMeta();
        helmetMeta.setDisplayName(ChatUtil.format("&5Helm krupiera"));
        helmet.setItemMeta(helmetMeta);
        helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1); // 6
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        chestplateMeta.setDisplayName(ChatUtil.format("&5Klata krupiera"));
        chestplate.setItemMeta(chestplateMeta);
        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemStack spodnie = new ItemStack(Material.DIAMOND_LEGGINGS, 1); // 7
        ItemMeta spodnieMeta = spodnie.getItemMeta();
        spodnieMeta.setDisplayName(ChatUtil.format("&5Spodnie krupiera"));
        spodnie.setItemMeta(spodnieMeta);
        spodnie.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        spodnie.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1); // 8
        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.setDisplayName(ChatUtil.format("&5Buty krupiera"));
        boots.setItemMeta(bootsMeta);
        boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        boots.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemStack pandora = new ItemStack(Material.DRAGON_EGG, 6); // 9
        ItemMeta pandoraMeta = pandora.getItemMeta();
        pandoraMeta.setDisplayName(ChatUtil.format("&4SPandora"));
        pandoraMeta.setLore(Arrays.asList(ChatUtil.format("&7Postaw, aby sprawdzic co jest w srodku!")));
        pandora.setItemMeta(pandoraMeta);

        ItemStack klatwa = new ItemStack(Material.STICK, 1);
        ItemMeta klatwaMeta = klatwa.getItemMeta();
        klatwaMeta.setDisplayName(ChatUtil.format("&cKlatwa"));
        klatwaMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Oslabia przeciwnikow, dziala tylko na moby")
        ));
        klatwa.setItemMeta(klatwaMeta);
        klatwa.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

        ItemStack masc = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta mascMeta = masc.getItemMeta();
        mascMeta.setDisplayName(ChatUtil.format("&cMasc smoka"));
        mascMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Po uzyciu dodaje efekt speed, haste oraz widzenie w ciemnosci")
        ));
        masc.setItemMeta(mascMeta);
        masc.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

        ItemStack kremik = new ItemStack(Material.REDSTONE, 1);
        ItemMeta kremikMeta = kremik.getItemMeta();
        kremikMeta.setDisplayName(ChatUtil.format("&cKremik withera"));
        kremikMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Po uzyciu dodaje efekt speed oraz regeneracji")
        ));
        kremik.setItemMeta(kremikMeta);
        kremik.addUnsafeEnchantment(Enchantment.DURABILITY, 10);


        ItemStack pazur = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta pazurMeta = pazur.getItemMeta();
        pazurMeta.setDisplayName(ChatUtil.format("&cPazur smoka"));
        pazurMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Po uzyciu dodaje zadaje damage potworom")
        ));
        pazur.setItemMeta(pazurMeta);
        pazur.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

        ItemStack jumpWand = new ItemStack(Material.STICK, 1);
        ItemMeta jumpMeta = jumpWand.getItemMeta();
        jumpMeta.setDisplayName(ChatUtil.format("&cJumper"));
        jumpMeta.setLore(Arrays.asList(
                ChatUtil.format("&6Po uzyciu podbija do gory")
        ));
        jumpWand.setItemMeta(jumpMeta);
        jumpWand.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

        ItemStack banknot = new ItemStack(Material.PAPER, 1);
        ItemMeta banknotMeta = banknot.getItemMeta();
        banknotMeta.setDisplayName(ChatUtil.format("&a&lBanknot"));
        banknotMeta.setLore(Arrays.asList(
                ChatUtil.format("&e» &7Wartosc: &a$" + 100000),
                ChatUtil.format(""),
                ChatUtil.format("&e» &7Aby uzyc kliknij lewym")
        ));
        banknot.setItemMeta(banknotMeta);

        ItemStack beacon = new ItemStack(Material.BEACON, 1);

        ItemStack token = new ItemStack(Material.PURPLE_DYE, 3);
        ItemMeta tokenMeta = token.getItemMeta();
        tokenMeta.setDisplayName(ChatUtil.format("&5&lZeton"));
        token.setItemMeta(tokenMeta);

        ItemStack dirt = new ItemStack(Material.DIRT, 1); // 9 - 10
        ItemMeta dirtMeta = dirt.getItemMeta();
        dirtMeta.setDisplayName(ChatUtil.format("&9&lKosmiczny dirt"));
        dirt.setItemMeta(dirtMeta);

        switch(new Random().nextInt(17))
        {
            case 0:
                item = axe;
                break;
            case 1:
                item = pickaxe;
                break;
            case 2:
                item = sword;
                break;
            case 3:
                item = bow;
                break;
            case 4:
                item = helmet;
                break;
            case 5:
                item = chestplate;
                break;
            case 6:
                item = spodnie;
                break;
            case 7:
                item = boots;
                break;
            case 8:
                item = pandora;
                break;
            case 9:
                item = klatwa;
                break;
            case 10:
                item = masc;
                break;
            case 11:
                item = kremik;
                break;
            case 12:
                item = pazur;
                break;
            case 13:
                item = jumpWand;
                break;
            case 14:
                item = banknot;
                break;
            case 15:
                item = beacon;
                break;
            case 16:
                item = token;
                break;
            default:
                item = dirt;
                break;

        }

        return item;
    }

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
        dirtMeta.setDisplayName(ChatUtil.format("&9&lKosmiczny dirt"));
        dirt.setItemMeta(dirtMeta);


        switch(new Random().nextInt(17) + 1)
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
            case 12:
                item = dirt;
                item.setAmount(1);
                break;
            case 13:
                item = dirt;
                item.setAmount(1);
                break;
            case 14:
                item = dirt;
                item.setAmount(1);
                break;
            case 15:
                item = dirt;
                item.setAmount(1);
                break;
            case 16:
                item = dirt;
                item.setAmount(1);
                break;
            case 17:
                item = dirt;
                item.setAmount(1);
                break;
            default:
                item = dirt;
                break;

        }

        return item;
    }

    public ItemStack getRandomRareItem()
    {
        ItemStack item = new ItemStack(Material.AIR, 1);

        ItemStack wolfEgg = new ItemStack(Material.WOLF_SPAWN_EGG, 1);
        ItemStack rabbitEgg = new ItemStack(Material.RABBIT_SPAWN_EGG, 1);
        ItemStack ocelotEgg = new ItemStack(Material.OCELOT_SPAWN_EGG, 1);

        ItemStack firePotion = new ItemStack(Material.POTION);
        PotionMeta firePotionMeta = (PotionMeta) firePotion.getItemMeta();
        firePotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, 1), true);
        firePotion.setItemMeta(firePotionMeta);

        ItemStack regPotion = new ItemStack(Material.POTION);
        PotionMeta regPotionMeta = (PotionMeta) regPotion.getItemMeta();
        regPotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000, 1), true);
        regPotion.setItemMeta(regPotionMeta);

        ItemStack speedPotion = new ItemStack(Material.POTION);
        PotionMeta speedPotionMeta = (PotionMeta) speedPotion.getItemMeta();
        speedPotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1), true);
        speedPotion.setItemMeta(speedPotionMeta);


        ItemStack goldApple = new ItemStack(Material.GOLDEN_APPLE, 8);
        ItemStack goldApple2 = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 4);
        ItemStack arrow = new ItemStack(Material.ARROW, 32);


        ItemStack dirt = new ItemStack(Material.DIRT, 1); // 9 - 10
        ItemMeta dirtMeta = dirt.getItemMeta();
        dirtMeta.setDisplayName(ChatUtil.format("&9&lKosmiczny dirt"));
        dirt.setItemMeta(dirtMeta);

        switch(new Random().nextInt(13) + 1)
        {
            case 1:
                item = wolfEgg;
                item.setAmount(1);
                break;
            case 2:
                item = rabbitEgg;
                item.setAmount(1);
                break;
            case 3:
                item = ocelotEgg;
                item.setAmount(1);
                break;
            case 4:
                item = regPotion;
                item.setAmount(1);
                break;
            case 5:
                item = speedPotion;
                item.setAmount(1);
                break;
            case 6:
                item = firePotion;
                item.setAmount(1);
                break;
            case 7:
                item = goldApple;
                item.setAmount(16);
                break;
            case 8:
                item = goldApple2;
                item.setAmount(8);
                break;
            case 9:
                item = arrow;
                item.setAmount(32);
                break;
            case 10:
                item = dirt;
                item.setAmount(1);
                break;
            case 11:
                item = dirt;
                item.setAmount(1);
                break;
            case 12:
                item = dirt;
                item.setAmount(1);
                break;
            case 13:
                item = dirt;
                item.setAmount(1);
                break;
            default:
                item = dirt;
                break;

        }

        return item;
    }

    public ItemStack getRandomEpicItem()
    {
        ItemStack item = new ItemStack(Material.DIRT, 1); // 9 - 10
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatUtil.format("&9&lKosmiczny dirt"));
        item.setItemMeta(itemMeta);

        ItemStack nether = new ItemStack(Material.NETHER_STAR, 1); // 1
        ItemStack name = new ItemStack(Material.NAME_TAG, 1); // 2
        ItemStack head = new ItemStack(Material.DRAGON_HEAD, 1); // 3
        ItemStack elytra = new ItemStack(Material.ELYTRA, 1); // 4
        ItemStack beacon = new ItemStack(Material.BEACON, 1); // 5
        ItemStack diax = new ItemStack(Material.DIAMOND_HORSE_ARMOR, 1); // 6
        ItemStack shield = new ItemStack(Material.SHIELD, 1); // 7
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1); // 8


        switch(new Random().nextInt(11) + 1)
        {
            case 1:
                item = nether;
                item.setAmount(1);
                break;
            case 2:
                item = name;
                item.setAmount(1);
                break;
            case 3:
                item = head;
                item.setAmount(1);
                break;
            case 4:
                item = elytra;
                item.setAmount(1);
                break;
            case 5:
                item = beacon;
                item.setAmount(1);
                break;
            case 6:
                item = diax;
                item.setAmount(1);
                break;
            case 7:
                item = shield;
                item.setAmount(1);
                break;
            case 8:
                item = totem;
                item.setAmount(1);
                break;
            default:
                break;

        }

        return item;
    }

    public ItemStack getRandomLegendaryItem()
    {
        ItemStack item = new ItemStack(Material.DIRT, 1); // 9 - 10
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatUtil.format("&9&lKosmiczny dirt"));
        item.setItemMeta(itemMeta);


        // MIECZ - 1
        ItemStack weapon = new ItemStack(Material.DIAMOND_SWORD);
        weapon.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        weapon.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
        weapon.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemMeta weaponMeta = weapon.getItemMeta();
        weaponMeta.setDisplayName(ChatColor.RED + "Marsowy miecz");
        weaponMeta.setLore(Arrays.asList(ChatColor.GOLD + "Prawdziwa legenda"));
        weapon.setItemMeta(weaponMeta);

        // KLATA - 2
        ItemStack klata = new ItemStack(Material.DIAMOND_CHESTPLATE);
        klata.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        klata.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemMeta itemMeta1 = klata.getItemMeta();
        itemMeta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Kosmiczna klata");
        itemMeta1.setLore(Arrays.asList(ChatColor.GOLD + "Przedmiot epicki"));
        klata.setItemMeta(itemMeta1);

        // SPODNIE - 3
        ItemStack spodnie = new ItemStack(Material.DIAMOND_LEGGINGS);
        spodnie.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        spodnie.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemMeta itemMeta11 = spodnie.getItemMeta();
        itemMeta11.setDisplayName(ChatColor.LIGHT_PURPLE + "Kosmiczne spodnie");
        itemMeta11.setLore(Arrays.asList(ChatColor.GOLD + "Przedmiot epicki"));
        spodnie.setItemMeta(itemMeta11);

        // BUTY - 4
        ItemStack buty = new ItemStack(Material.DIAMOND_BOOTS);
        buty.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        buty.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemMeta itemMeta111 = buty.getItemMeta();
        itemMeta111.setDisplayName(ChatColor.LIGHT_PURPLE + "Kosmiczne buty");
        itemMeta111.setLore(Arrays.asList(ChatColor.GOLD + "Przedmiot epicki"));
        buty.setItemMeta(itemMeta111);

        // HELM - 5
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,5);
        helm.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

        ItemMeta itemMeta1111 = helm.getItemMeta();
        itemMeta1111.setDisplayName(ChatColor.LIGHT_PURPLE + "Kosmiczny helm");
        itemMeta1111.setLore(Arrays.asList(ChatColor.GOLD + "Przedmiot epicki"));
        helm.setItemMeta(itemMeta1111);

        // LUK - 6
        ItemStack luk = new ItemStack(Material.BOW);
        luk.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 6);
        luk.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
        luk.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
        luk.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);

        ItemMeta itemMeta11111 = luk.getItemMeta();
        itemMeta11111.setDisplayName(ChatColor.RED + "Marsowy luk");
        itemMeta11111.setLore(Arrays.asList(ChatColor.GOLD + "Luk marsowy"));
        luk.setItemMeta(itemMeta11111);

        // MENDING - 7
        ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) mending.getItemMeta();
        meta.addStoredEnchant(Enchantment.MENDING, 1, true);
        mending.setItemMeta(meta);

        ItemStack dirt = new ItemStack(Material.DIRT, 1); // 9 - 10
        ItemMeta dirtMeta = dirt.getItemMeta();
        dirtMeta.setDisplayName(ChatUtil.format("&9&lKosmiczny dirt"));
        dirt.setItemMeta(dirtMeta);

        ItemStack pandora = new ItemStack(Material.DRAGON_EGG, 6);

        ItemMeta itemMetaPandora = pandora.getItemMeta();
        itemMetaPandora.setDisplayName(ChatColor.DARK_RED + "SPandora");
        itemMetaPandora.setLore(Arrays.asList(ChatColor.GRAY + "Postaw, aby sprawdzic co jest w srodku!"));
        pandora.setItemMeta(itemMetaPandora);


        switch(new Random().nextInt(13) + 1)
        {
            case 1:
                item = weapon;
                item.setAmount(1);
                break;
            case 2:
                item = luk;
                item.setAmount(1);
                break;
            case 3:
                item = helm;
                item.setAmount(1);
                break;
            case 4:
                item = klata;
                item.setAmount(1);
                break;
            case 5:
                item = spodnie;
                item.setAmount(1);
                break;
            case 6:
                item = buty;
                item.setAmount(1);
                break;
            case 7:
                item = pandora;
                break;
            case 8:
                item = mending;
                item.setAmount(1);
                break;
            default:
                break;

        }

        return item;
    }

}
