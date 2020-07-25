package us.davidsprojects.huntorbehunted.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class JoinCommand extends AbstractCommand {
    /**
     * The name of the command
     */
    public static final String NAME = "join";

    /**
     * The description of the command
     */
    public static final String DESCRIPTION = "lets a player join a team";

    /**
     * The permission of the command
     */
    public static final String PERMISSION = "hobh.join";

    /**
     * The subpermissions of the command
     */
    private static final String[] SUBPERMISSIONS = {};

    /**
     * The usage of the command
     */
    private static final String USAGE = "/hobh join [team]";

    /**
     * Construct the command
     *
     * @param sender    the command sender
     */
    public JoinCommand(CommandSender sender)
    {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUBPERMISSIONS, USAGE);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {

    }

}
