package com.github.redreaperlp.redmoneyapi.handler;

import com.github.redreaperlp.redmoneyapi.RedMoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHandler {

    int scoreVal = 0;

    String prefix = "§7[§cRedMoneyAPI§7] ";

    public void updateScoreboard(Player player) {


        PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
        PersistentDataContainer persistentDataContainer1 = persistentDataContainer;

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("abcd", "dummy");
        objective.setDisplayName(prefix);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("§abalance: §e" + scoreVal).setScore(3);
        objective.getScore("Server: " + player.getServer().getName()).setScore(5);
        player.setScoreboard(scoreboard);
        scoreVal++;
    }

}