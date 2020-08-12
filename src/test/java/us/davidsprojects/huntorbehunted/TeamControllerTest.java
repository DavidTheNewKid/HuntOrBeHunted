package us.davidsprojects.huntorbehunted;

import org.bukkit.entity.Player;
import org.powermock.core.classloader.annotations.PrepareForTest;
import us.davidsprojects.huntorbehunted.teams.TeamController;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TeamController.class)
public class TeamControllerTest {

    @Test
    public void testSimpleTeam()
    {
        String teamName = "mockTeam";
        TeamController mockTeam = new TeamController(teamName);

        assertEquals(mockTeam.getName(), teamName);
    }
    
    @Test
    public void testAddPlayerTeam()
    {
        TeamController mockTeam = new TeamController("mockTeam");
        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getName()).thenReturn("mockPlayer");

        String addPlayerSuccess = mockTeam.addPlayer(mockPlayer.getName());

        assertEquals(addPlayerSuccess, "Successfully added player to mockTeam team");
    }

}
