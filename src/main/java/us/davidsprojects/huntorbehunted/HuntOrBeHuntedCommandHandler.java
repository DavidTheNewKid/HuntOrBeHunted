package us.davidsprojects.huntorbehunted;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/*
    Command Parser for Hunt Or Be Hunted Gamemode
 */
public class HuntOrBeHuntedCommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length == 0)
        {
            sender.sendMessage("no");
        }

        return true;
    }
}
