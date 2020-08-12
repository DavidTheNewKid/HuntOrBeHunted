package us.davidsprojects.huntorbehunted.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.davidsprojects.huntorbehunted.HuntOrBeHunted;

import java.util.List;

public class ListCommand extends AbstractCommand {
    /**
     * The name of the command
     */
    public static final String NAME = "list";

    /**
     * The description of the command
     */
    public static final String DESCRIPTION = "lets a player list team players";

    /**
     * The permission of the command
     */
    public static final String PERMISSION = "hobh.list";

    /**
     * The subpermissions of the command
     */
    private static final String[] SUBPERMISSIONS = {};

    /**
     * The usage of the command
     */
    private static final String USAGE = "/hobh list";

    /**
     * Construct the command
     *
     * @param sender    the command sender
     */
    public ListCommand(CommandSender sender)
    {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUBPERMISSIONS, USAGE);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player)
        {
            Player player = (Player) sender;

            if(HuntOrBeHunted.hunters.findPlayer(player.getName()))
            {
                List<String> players = HuntOrBeHunted.hunters.getPlayers();

                player.sendMessage("Hunters Team Members: ");
                for(String teamPlayer : players)
                {
                    sender.sendMessage(teamPlayer);
                }
            }
            else if (HuntOrBeHunted.hunteds.findPlayer(player.getName()))
            {
                List<String> players = HuntOrBeHunted.hunteds.getPlayers();
                player.sendMessage("Hunteds Team Members: ");
                for(String teamPlayer : players)
                {
                    sender.sendMessage(teamPlayer);
                }
            }
            else
            {
                sender.sendMessage("Need to be in a team to list the players");
            }
        }
        else
        {
            sender.sendMessage("Need to be a player to list a team");
        }
    }

}
