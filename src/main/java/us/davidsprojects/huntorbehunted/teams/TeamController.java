package us.davidsprojects.huntorbehunted.teams;

import java.util.ArrayList;
import java.util.List;

public class TeamController {
    private String name;
    private List<String> players = new ArrayList<>();

    /**
     * Constructor for creating a team
     * @param teamname name of the team
     */
    public TeamController(String teamname)
    {
        name = teamname;
    }

    /**
     * sets the name of the team
     * @param teamname is the name of the team
     */
    public void setName(String teamname)
    {
        name = teamname;
    }

    /**
     * Gets the name of the team
     * @return name of the team (String)
     */
    public String getName()
    {
        return name;
    }

    /**
     * Adds player to team
     * @param playerName is the name of the player to add
     * @return if it was a successful completion (boolean)
     */
    public String addPlayer(String playerName)
    {
        if(!players.contains(playerName)) {
            players.add(playerName);
            return "Successfully added player to " + name + " team";
        }
        return "Player already apart of " + name + " team";
    }

    /**
     * Removes player from a team
     * @param playerName is the name of the player to remove
     * @return if it was a successful completion (boolean)
     */
    public String removePlayer(String playerName)
    {
        if(players.indexOf(playerName) == -1) {
            if(players.remove(playerName))
            {
                return "Successfully removed player from " + name + " team";
            }
            else
            {
                return "Failed removing player from " + name + "team";
            }
        }

        return "Player not in team to be removed from";
    }

    public boolean findPlayer(String playerName)
    {
        return players.contains(playerName);
    }

    public List<String> getPlayers()
    {
        return players;
    }

    /**
     * Removes all players from a team
     * @return if it was a successful completion (boolean)
     */
    public boolean removeAllPlayers()
    {
        players = null;
        return players.isEmpty();
    }


}
