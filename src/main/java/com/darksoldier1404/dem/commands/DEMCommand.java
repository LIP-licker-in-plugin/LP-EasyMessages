package com.darksoldier1404.dem.commands;

import com.darksoldier1404.dem.EasyMessages;
import com.darksoldier1404.dppc.utils.ColorUtils;
import com.darksoldier1404.dppc.utils.ConfigUtils;
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
public class DEMCommand implements CommandExecutor, TabCompleter {
    private final EasyMessages plugin = EasyMessages.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(plugin.prefix + "권한이 없습니다.");
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage(plugin.prefix + "/dem reload - 플러그인 콘피그 파일을 리로드 합니다.");
            sender.sendMessage(plugin.prefix + "/dem join <내용> - 플레이어 접속 메시지를 설정합니다.");
            sender.sendMessage(plugin.prefix + "/dem quit <내용> - 플레이어 퇴장 메시지를 설정합니다.");
            sender.sendMessage(plugin.prefix + "/dem motd1 <내용> - 서버 리스트 첫번째 메시지를 설정합니다.");
            sender.sendMessage(plugin.prefix + "/dem motd2 <내용> - 서버 리스트 두번째 메시지를 설정합니다.");
            sender.sendMessage(plugin.prefix + "/dem maxPlayer <숫자> - 서버 최대 인원을 설정합니다.");
            return false;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            plugin.config = ConfigUtils.reloadPluginConfig(plugin, plugin.config);
            plugin.prefix = ColorUtils.applyColor(plugin.config.getString("Settings.prefix"));
            sender.sendMessage(plugin.prefix + "성공적으로 리로드 되었습니다.");
            return false;
        }
        if (args[0].equalsIgnoreCase("join")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + "내용을 입력해주세요.");
                return false;
            }
            plugin.config.set("Settings.joinMessage", getText(args, 1));
            sender.sendMessage(plugin.prefix + "성공적으로 설정되었습니다.");
            return false;
        }
        if (args[0].equalsIgnoreCase("quit")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + "내용을 입력해주세요.");
                return false;
            }
            plugin.config.set("Settings.quitMessage", getText(args, 1));
            sender.sendMessage(plugin.prefix + "성공적으로 설정되었습니다.");
            return false;
        }
        if (args[0].equalsIgnoreCase("motd1")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + "내용을 입력해주세요.");
                return false;
            }
            plugin.config.set("Settings.motd1", getText(args, 1));
            sender.sendMessage(plugin.prefix + "성공적으로 설정되었습니다.");
            return false;
        }
        if (args[0].equalsIgnoreCase("motd2")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + "내용을 입력해주세요.");
                return false;
            }
            plugin.config.set("Settings.motd2", getText(args, 1));
            sender.sendMessage(plugin.prefix + "성공적으로 설정되었습니다.");
            return false;
        }
        if (args[0].equalsIgnoreCase("maxPlayer")) {
            if (args.length == 1) {
                sender.sendMessage(plugin.prefix + "숫자를 입력해주세요.");
                return false;
            }
            try {
                plugin.config.set("Settings.maxPlayer", Integer.parseInt(args[1]));
                sender.sendMessage(plugin.prefix + "성공적으로 설정되었습니다.");
                return false;
            } catch (NumberFormatException e) {
                sender.sendMessage(plugin.prefix + "옳바르지 않은 숫자입니다.");
                return false;
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
                return Arrays.asList("reload", "join", "quit", "motd1", "motd2", "maxPlayer");
            }
        }
        return null;
    }
}
