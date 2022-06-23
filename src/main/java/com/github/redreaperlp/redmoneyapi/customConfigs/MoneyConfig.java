package com.github.redreaperlp.redmoneyapi.customConfigs;

import com.github.redreaperlp.redmoneyapi.RedMoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class MoneyConfig {

    String prefix = "§7[§cRedMoneyAPI§7] ";
    public RedMoneyAPI plugin;
    public MoneyConfig(RedMoneyAPI ourMain) {
        plugin = ourMain;
    }

    private File moneyFile;
    private FileConfiguration moneyConfig;

    public void setup() {
        moneyFile = new File(Bukkit.getServer().getPluginManager().getPlugin("RedMoneyAPI").getDataFolder(), "money.yml");

        if (!moneyFile.exists()) {
            try {
                moneyFile.createNewFile();
            } catch (Exception e) {
                plugin.console.sendMessage(prefix + "§cError while creating money.yml!");
            }
        }
        moneyConfig = YamlConfiguration.loadConfiguration(moneyFile);
    }

    public FileConfiguration getMoney() {
        return moneyConfig;
    }

    public void saveMoney() {
        try {
            moneyConfig.save(moneyFile);
        } catch (Exception e) {
            plugin.console.sendMessage(prefix + "§cError while saving money.yml!");
        }
    }

    public void reloadMoney() {
        moneyConfig = YamlConfiguration.loadConfiguration(moneyFile);
    }
}
