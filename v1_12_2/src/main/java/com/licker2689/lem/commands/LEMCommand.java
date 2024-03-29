package com.licker2689.lem.commands;

import com.licker2689.lem.EasyMessages;
import com.licker2689.lem.func.LEMFunc;
import com.licker2689.lpc.utils.ColorUtils;
import com.licker2689.lpc.utils.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class LEMCommand implements CommandExecutor, TabCompleter {
    private final EasyMessages plugin = EasyMessages.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_permission_deny"));
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_info_reload"));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_info_join"));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_info_quit"));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_info_motd1"));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_info_motd2"));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_info_title"));            return false;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            plugin.config = ConfigUtils.reloadPluginConfig(plugin, plugin.config);
            plugin.prefix = ColorUtils.applyColor(plugin.config.getString("Settings.prefix"));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_succsfully_reloaded"));
            return false;
        }
        if (args[0].equalsIgnoreCase("join")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_text_required"));
                return false;
            }
            plugin.config.set("Settings.joinMessage", getText(args, 1));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_succsfully_set"));
            return false;
        }
        if (args[0].equalsIgnoreCase("quit")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_text_required"));
                return false;
            }
            plugin.config.set("Settings.quitMessage", getText(args, 1));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_succsfully_set"));
            return false;
        }
        if (args[0].equalsIgnoreCase("motd1")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_text_required"));
                return false;
            }
            plugin.config.set("Settings.motd1", getText(args, 1));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_succsfully_set"));
            return false;
        }
        if (args[0].equalsIgnoreCase("motd2")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_text_required"));
                return false;
            }
            plugin.config.set("Settings.motd2", getText(args, 1));
            sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_succsfully_set"));
            return false;
        }
        if (args[0].equalsIgnoreCase("title")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + plugin.lang.get("cmd_msg_text_required"));
                return false;
            }
            if (args.length == 2) {
                String title = String.join(" ", args[1]);
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.sendTitle(title, "", 10, 70, 20);
                    LEMFunc.returnSounds(player, args[2]);
                });
                return true;
            }

        }

        return false;
    }

    public String getText(String[] args, int line) {
        StringBuilder s = new StringBuilder();
        args = Arrays.copyOfRange(args, line, args.length);
        Iterator<String> i = Arrays.stream(args).iterator();
        while (i.hasNext()) {
            s.append(i.next()).append(" ");
        }
        // delete last space
        if (s.charAt(s.length() - 1) == ' ') {
            s.deleteCharAt(s.length() - 1);
        }
        return s.toString();
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender.isOp()) {
            if (args.length == 1) {
                return Arrays.asList("reload", "join", "quit", "motd1", "motd2");
            }
        }
        return null;
    }
}
