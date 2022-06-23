package com.github.redreaperlp.redmoneyapi.listener;

import com.github.redreaperlp.redmoneyapi.RedMoneyAPI;
import com.github.redreaperlp.redmoneyapi.handler.ScoreboardHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class RedMoneyPlayerJoinListener implements Listener {

    public RedMoneyAPI plugin;
    public RedMoneyPlayerJoinListener(RedMoneyAPI ourMain) {
        plugin = ourMain;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        ScoreboardHandler scoreboardHandler = new ScoreboardHandler();
    }
}
