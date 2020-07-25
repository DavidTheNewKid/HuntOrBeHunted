package us.davidsprojects.huntorbehunted.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class HelpCommand extends AbstractCommand {
    /**
     * The name of the command
     */
    public static final String NAME = "help";

    /**
     * The description of the command
     */
    public static final String DESCRIPTION = "provides help to a user";

    /**
     * The permission of the command
     */
    public static final String PERMISSION = "hobh.help";

    /**
     * The subpermissions of the command
     */
    private static final String[] SUBPERMISSIONS = {};

    /**
     * The usage of the command
     */
    private static final String USAGE = "/hobh compass";

    /**
     * Construct the command
     *
     * @param sender    the command sender
     */
    public HelpCommand(CommandSender sender)
    {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUBPERMISSIONS, USAGE);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("This will be more helpful in the future");
    }

}
