package com.darksoldier1404.dem.func;

import com.darksoldier1404.dem.EasyMessages;
import com.darksoldier1404.dppc.lang.DLang;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class DEMFunc {
    private static final EasyMessages plugin = EasyMessages.getInstance();

    private static final String prefix = plugin.prefix;

    private static final DLang lang = plugin.lang;

    public static void returnSounds(Player p, String i){
        switch (i){
            case "a":
                p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 100, 1);
            case "b":
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 1);
            case "c":
                p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_DEATH, 100 ,1);
            case "d":
                p.playSound(p.getLocation(),Sound.BLOCK_ENCHANTMENT_TABLE_USE, 100, 1);
            default: {
                p.sendMessage(plugin.prefix + plugin.lang.get("cmd_to_much_sounds_number"));

            }
        }
    }
}
