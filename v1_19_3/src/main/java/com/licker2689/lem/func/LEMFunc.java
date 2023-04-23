package com.licker2689.lem.func;

import com.licker2689.lem.EasyMessages;
import com.licker2689.lpc.lang.LLang;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LEMFunc {
    private static final EasyMessages plugin = EasyMessages.getInstance();

    private static final String prefix = plugin.prefix;

    private static final LLang lang = plugin.lang;

    public static void returnSounds(Player p, String i){
        switch (i){
            case "a":
                p.playSound(p, Sound.ENTITY_ARROW_HIT_PLAYER, 100, 1);
            case "b":
                p.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 1);
            case "c":
                p.playSound(p,Sound.ENTITY_PLAYER_DEATH, 100 ,1);
            case "d":
                p.playSound(p,Sound.BLOCK_ENCHANTMENT_TABLE_USE, 100, 1);
            default: {
                p.sendMessage(plugin.prefix + plugin.lang.get("cmd_to_much_sounds_number"));

            }
        }
    }
}
