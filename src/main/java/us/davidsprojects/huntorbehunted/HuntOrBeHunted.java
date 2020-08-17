package us.davidsprojects.huntorbehunted;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import us.davidsprojects.huntorbehunted.helpers.CompassHelper;
import us.davidsprojects.huntorbehunted.listeners.EventListeners;
import us.davidsprojects.huntorbehunted.teams.TeamController;

import java.util.HashMap;
import java.util.UUID;


public final class HuntOrBeHunted extends JavaPlugin {

    private HuntOrBeHunted instance = null;

    // Used for seeing who is tracking who :eyes: , via circular indexing
    public static HashMap<UUID, Integer> trackingMap = new HashMap<>();

    // Used for adding players to teams
    public static TeamController hunters = new TeamController("hunters");
    public static TeamController hunteds = new TeamController("hunteds");
    
    public static CompassHelper helper = new CompassHelper();

    @Override
    public void onEnable() {
        instance = this;

        // TODO: Message Formatter
        // messageFormatter = new MessageFormatter();


        Bukkit.getPluginManager().registerEvents(new EventListeners(), this);

        this.getCommand("hobh").setExecutor(new HuntOrBeHuntedCommandHandler());
        this.getCommand("hobh").setTabCompleter(new HuntOrBeHuntedTabCompleter());

    }

    @Override
    public void onDisable() {
        instance = null;
        hunters = null;
        hunteds = null;
        trackingMap = null;
    }
}
