package handball;

import org.junit.Assert;
import org.junit.Test;

public class TeamTests {

    //Create team with null name
    @Test(expected = NullPointerException.class)
    public void testCreateTeamNullName() {
        new Team(null, 10);
    }

    //Create team with empty name
    @Test(expected = NullPointerException.class)
    public void testCreateTeamEmptyName() {
        new Team("", 10);
    }

    //Create team with invalid position
    @Test(expected = IllegalArgumentException.class)
    public void testCreateTeamInvalidPosition() {
        new Team("Team1", -10);
    }

    //Create team with valid values
    @Test
    public void testCreateTeamValidParams() {
        Team team = new Team("Team1", 10);
        Assert.assertEquals("Team1", team.getName());
        Assert.assertEquals(10, team.getPosition());

    }

    //HandballPlayers.size == position
    @Test(expected = IllegalArgumentException.class)
    public void testAddWhenNoSpaceAvailable() {
        Team team = new Team("Team1", 1);
        HandballPlayer handballPlayer1 = new HandballPlayer("Peter");
        HandballPlayer handballPlayer2 = new HandballPlayer("John");

        team.add(handballPlayer1);
        Assert.assertEquals(1, team.getCount());
        team.add(handballPlayer2);

    }

    //Successfully added
    @Test
    public void testAddValidParams() {
        Team team = new Team("Team1", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("Peter");
        HandballPlayer handballPlayer2 = new HandballPlayer("John");

        team.add(handballPlayer1);
        Assert.assertEquals(1, team.getCount());
        team.add(handballPlayer2);
        Assert.assertEquals(2, team.getCount());
    }

    //remove non-existing person
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExisting() {
        Team team = new Team("Team1", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("Peter");
        HandballPlayer handballPlayer2 = new HandballPlayer("John");

        team.add(handballPlayer1);
        team.add(handballPlayer2);

        team.remove("Gosho");
    }

    //remove successfully
    @Test
    public void testRemoveSuccessfully() {
        Team team = new Team("Team1", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("Peter");
        HandballPlayer handballPlayer2 = new HandballPlayer("John");

        team.add(handballPlayer1);
        team.add(handballPlayer2);

        Assert.assertEquals(2, team.getCount());

        team.remove("Peter");

        Assert.assertEquals(1, team.getCount());
    }

    //test playerForAnotherTeamNonExisting
    @Test(expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamNonExisting() {
        Team team = new Team("Team1", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("Peter");
        HandballPlayer handballPlayer2 = new HandballPlayer("John");

        team.add(handballPlayer1);
        team.add(handballPlayer2);

        team.playerForAnotherTeam("Gosho");
    }

    //test playerForAnotherTeamExisting
    @Test
    public void testPlayerForAnotherTeamExisting() {
        Team team = new Team("Team1", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("Peter");

        team.add(handballPlayer1);

        Assert.assertTrue(handballPlayer1.isActive());
        team.playerForAnotherTeam("Peter");

        Assert.assertFalse(handballPlayer1.isActive());

    }

    //test Statistics
    @Test
    public void testStatistics(){
        Team team = new Team("Team1", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("Peter");
        HandballPlayer handballPlayer2 = new HandballPlayer("John");

        team.add(handballPlayer1);
        team.add(handballPlayer2);

        String expectedOutput = "The player Peter, John is in the team Team1.";

        Assert.assertEquals(expectedOutput, team.getStatistics());

    }
}
