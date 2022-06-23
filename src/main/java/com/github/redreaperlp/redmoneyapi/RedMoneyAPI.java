package com.github.redreaperlp.redmoneyapi;

import com.github.redreaperlp.redmoneyapi.handler.ScoreboardHandler;
import com.github.redreaperlp.redmoneyapi.listener.RedMoneyPlayerJoinListener;
import com.github.redreaperlp.redpermsapi.Managers.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class RedMoneyAPI extends JavaPlugin {

    public ConsoleCommandSender console = getServer().getConsoleSender();
    String prefix = "§7[§6RedMoneyAPI§7] ";

    public static RedMoneyAPI getInstance() {
        return instance;
    }

    public static RedMoneyAPI instance;

    @Override
    public void onEnable() {
        instance = this;
        if (getServer().getPluginManager().getPlugin("RedPermsAPI") != null) {
            console.sendMessage(prefix + "§aRedMoneyAPI has been enabled!");
            setUpPermissions();
            getServer().getPluginManager().registerEvents(new RedMoneyPlayerJoinListener(this), this);

        } else {
            console.sendMessage("\n" + prefix + "§cRedPermsAPI is not installed!\n" +
                    prefix + "§cPlease install RedPermsAPI!\n" +
                    prefix + "https://www.github.com/RedReaperLP/RedPermsAPI");
            getServer().getPluginManager().disablePlugin(this);
        }
        ScoreboardHandler scoreboardHandler = new ScoreboardHandler();
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            for (Player players : Bukkit.getOnlinePlayers()) {
                scoreboardHandler.updateScoreboard(players);
            }
        }, 0, 20 * 10);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void setUpPermissions() {
        PermissionManager permissionManager = new PermissionManager();
        permissionManager.addPermission("redmoneyapi_use", null);
    }
}
