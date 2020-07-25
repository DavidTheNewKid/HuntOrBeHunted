package us.davidsprojects.huntorbehunted;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import us.davidsprojects.huntorbehunted.command.*;


/*
    Command Parser for Hunt Or Be Hunted Gamemode
 */
public class HuntOrBeHuntedCommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        AbstractCommand cmd = new HelpCommand(sender);
        if(args.length == 0)
        {
            cmd.execute(sender, command, label, args);
            return true;
        }

        switch(args[0].toLowerCase())
        {
            case "help":
                cmd = new HelpCommand(sender);
                break;
            case "set":
                cmd = new SetCommand(sender);
                break;
            case "unset":
                cmd = new UnsetCommand(sender);
                break;
            case "join":
                cmd = new JoinCommand(sender);
                break;
            case "leave":
                cmd = new LeaveCommand(sender);
                break;
            case "start":
                cmd = new StartCommand(sender);
                break;
            case "stop":
                cmd = new StopCommand(sender);
                break;
            case "compass":
                cmd = new CompassCommand(sender);
                break;
        }

        cmd.execute(sender, command, label, args);
        return true;
    }
}
