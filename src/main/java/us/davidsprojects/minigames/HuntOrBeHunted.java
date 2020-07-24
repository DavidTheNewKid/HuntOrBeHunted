package us.davidsprojects.minigames;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class HuntOrBeHunted extends JavaPlugin {

    @Override
    public void onEnable() {
        /*
            TODO: Create compass interaction for hunters
         */
        // Bukkit.getPluginManager().registerEvents(new CompassInteractListener(), this);
        Objects.requireNonNull(this.getCommand("hunter")).setExecutor(new HunterCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
