package me.symi.owncase.utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class FireworkUtil {

    public static void spawnFirework(HumanEntity entity)
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

        Firework fw = (Firework) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.FIREWORK);
        final FireworkMeta fwm = fw.getFireworkMeta();
        fwm.clearEffects();
        fwm.addEffect(f);
        fwm.setPower(1);
        fw.setFireworkMeta(fwm);
    }

    public static void spawnFirework(Location location)
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

        Firework fw = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
        final FireworkMeta fwm = fw.getFireworkMeta();
        fwm.clearEffects();
        fwm.addEffect(f);
        fwm.setPower(1);
        fw.setFireworkMeta(fwm);
    }

}
