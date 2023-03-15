package com.licker2689.lem.events;

import com.licker2689.lem.EasyMessages;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

@SuppressWarnings("all")
public class LEMEvent implements Listener {
    private final EasyMessages plugin = EasyMessages.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("Settings.joinMessage").replace("<player>", e.getPlayer().getName()).replace("<prefix>", plugin.prefix)));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("Settings.quitMessage").replace("<player>", e.getPlayer().getName()).replace("<prefix>", plugin.prefix)));
    }

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        String s1 = plugin.config.getString("Settings.motd1");
        String s2 = plugin.config.getString("Settings.motd2");
        s1 = ChatColor.translateAlternateColorCodes('&', s1.replace("<prefix>", plugin.prefix));
        s2 = ChatColor.translateAlternateColorCodes('&', s2.replace("<prefix>", plugin.prefix));
        e.setMotd(s1 + "\n" + s2);
    }
}
