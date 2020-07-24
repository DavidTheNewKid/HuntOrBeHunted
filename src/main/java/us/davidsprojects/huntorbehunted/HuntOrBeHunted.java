package us.davidsprojects.huntorbehunted;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

@SuppressWarnings("unused")
public final class HuntOrBeHunted extends JavaPlugin {

    private HuntOrBeHunted instance = null;

    /*
        TODO: hunters and hunteds teams
     */
    // private List<String> hunters = null;
    // private List<String> hunteds = null;


    @Override
    public void onEnable() {
        instance = this;

        // TODO: Message Formatter
        // messageFormatter = new MessageFormatter();

        this.getCommand("hobh").setExecutor(new HuntOrBeHuntedCommandHandler());
        this.getCommand("hobh").setTabCompleter(new HuntOrBeHuntedTabCompleter());

    }

    @Override
    public void onDisable() {
        instance = null;
        // TODO: Message Formatter
        // messageFormatter = null;
        // TODO: hunters and hunteds teams
        // hunters = null;
        // hunteds = null;
    }
}
