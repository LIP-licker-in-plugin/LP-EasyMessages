package com.darksoldier1404.dem.events;

import com.darksoldier1404.dem.EasyMessages;
import com.darksoldier1404.dppc.utils.ColorUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

@SuppressWarnings("all")
public class DEMEvent implements Listener {
    private final EasyMessages plugin = EasyMessages.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ColorUtils.applyColor(plugin.config.getString("Settings.joinMessage").replace("<player>", e.getPlayer().getName()).replace("<prefix>", plugin.prefix)));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(ColorUtils.applyColor(plugin.config.getString("Settings.quitMessage").replace("<player>", e.getPlayer().getName()).replace("<prefix>", plugin.prefix)));
    }

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        String s1 = plugin.config.getString("Settings.motd1");
        String s2 = plugin.config.getString("Settings.motd2");
        s1 = ColorUtils.applyColor(s1.replace("<prefix>", plugin.prefix));
        s2 = ColorUtils.applyColor(s2.replace("<prefix>", plugin.prefix));
        e.setMotd(s1 + "\n" + s2);
    }
}
