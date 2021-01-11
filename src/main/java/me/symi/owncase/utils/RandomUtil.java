package me.symi.owncase.utils;

import me.symi.owncase.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class RandomUtil {

    public ItemStack getRandomItemstack(String case_name) throws IOException, InvalidConfigurationException
    {
        List<ItemStack> items = Main.getInst().getFileManager().getPremiumCaseItems(case_name);
        return items.get(new Random().nextInt(items.size()));
    }


}
