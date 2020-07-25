package us.davidsprojects.huntorbehunted.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class StartCommand extends AbstractCommand {
    /**
     * The name of the command
     */
    public static final String NAME = "start";

    /**
     * The description of the command
     */
    public static final String DESCRIPTION = "starts a game";

    /**
     * The permission of the command
     */
    public static final String PERMISSION = "hobh.start";

    /**
     * The subpermissions of the command
     */
    private static final String[] SUBPERMISSIONS = {};

    /**
     * The usage of the command
     */
    private static final String USAGE = "/hobh start";

    /**
     * Construct the command
     *
     * @param sender    the command sender
     */
    public StartCommand(CommandSender sender)
    {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUBPERMISSIONS, USAGE);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {

    }

}
