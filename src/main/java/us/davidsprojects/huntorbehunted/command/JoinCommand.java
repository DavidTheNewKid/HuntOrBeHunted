package us.davidsprojects.huntorbehunted.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import us.davidsprojects.huntorbehunted.HuntOrBeHunted;
import us.davidsprojects.huntorbehunted.HuntOrBeHunted.*;

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
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            // used for interpreting what the outcome was for the player
            String status;
            if(args.length >= 2)
            {
                String team = args[1].toLowerCase();
                if(team.equals("hunters"))
                {

                    if(!HuntOrBeHunted.hunteds.findPlayer(player.getName()))
                    {
                        // Only give a compass if they join the hunter team
                        PlayerInventory inventory = player.getInventory();
                        inventory.addItem(HuntOrBeHunted.helper.getCompass());
                        status = HuntOrBeHunted.hunters.addPlayer(player.getName());
                        HuntOrBeHunted.trackingMap.put(player.getUniqueId(), 0);
                    }
                    else
                    {
                        status = "Can only join one team - /hobh leave hunteds";
                    }
                }
                else if(team.equals("hunteds"))
                {
                    if(!HuntOrBeHunted.hunters.findPlayer(player.getName()))
                    {
                        status = HuntOrBeHunted.hunteds.addPlayer(player.getName());
                    }
                    else
                    {
                        status = "Can only join one team - /hobh leave hunters";
                    }
                }
                else
                {
                    status = "Tried to join an invalid team";
                }
            }
            else
            {
                status = "/hobh join [team] - Missing team";
            }

            player.sendMessage(status);

        }
        else
        {
            sender.sendMessage("Need to be a player to join a team");
        }


    }

}
