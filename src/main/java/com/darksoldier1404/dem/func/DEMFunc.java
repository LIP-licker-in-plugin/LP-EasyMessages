package com.darksoldier1404.dem.func;

import com.darksoldier1404.dem.EasyMessages;
import com.darksoldier1404.dppc.lang.DLang;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class DEMFunc {
    private static final EasyMessages plugin = EasyMessages.getInstance();

    private static final String prefix = plugin.prefix;

    private static final DLang lang = plugin.lang;

    public static void returnSounds(Player p, int i){
        switch (i){
            case 1:
                p.playSound(p, Sound.ENTITY_ARROW_HIT_PLAYER, 100, 1);
            case 2:
                p.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 1);
            case 3:
                p.playSound(p,Sound.ENTITY_PLAYER_DEATH, 100 ,1);
            case 4:
                p.playSound(p,Sound.BLOCK_ENCHANTMENT_TABLE_USE, 100, 1);
            default: if (i > 4){
                p.sendMessage(plugin.prefix + plugin.lang.get("cmd_to_much_sounds_number"));

            }
        }
    }
}
