package stuntClimb;


import org.junit.Assert;
import org.junit.Test;

public class ClimbingTests {
    private static final double DELTA = 1e-15;

    //Create Climbing class with null name
    @Test(expected = NullPointerException.class)
    public void testCreateClimbingNullName(){
        new Climbing(null, 50);
    }

    //Create Climbing class with empty name
    @Test(expected = NullPointerException.class)
    public void testCreateClimbingEmptyName(){
        new Climbing("", 50);
    }

    //Create Climbing class with invalid capacity
    @Test(expected = IllegalArgumentException.class)
    public void testCreateClimbingInvalidCapacity(){
        new Climbing("Climbing1", -1);
    }

    //Create Climbing class with valid values
    @Test
    public void testCreateClimbingValidValues(){
        Climbing climbing = new Climbing("Climbing1", 50);
        Assert.assertEquals("Climbing1", climbing.getName());
        Assert.assertEquals(50, climbing.getCapacity());
    }

    //climbers == capacity
    @Test(expected = IllegalArgumentException.class)
    public void testAddClimberWhenNoCapacity(){
        Climbing climbing = new Climbing("Climbing1", 1);
        RockClimber gosho = new RockClimber("Gosho", 6);
        RockClimber tosho = new RockClimber("Tosho", 5);

        climbing.addRockClimber(gosho);
        Assert.assertEquals(1, climbing.getCount());

        climbing.addRockClimber(tosho);

    }
    //climber does not exist
    @Test(expected = IllegalArgumentException.class)
    public void testAddClimberNotExist(){
        Climbing climbing = new Climbing("Climbing1", 10);
        RockClimber gosho = new RockClimber("Gosho", 6);
        RockClimber climber2 = new RockClimber("Gosho", 5);

        climbing.addRockClimber(gosho);
        climbing.addRockClimber(climber2);


    }
    //successfully added climber
    @Test
    public void testAddClimberSuccessfully(){
        Climbing climbing = new Climbing("Climbing1", 10);
        RockClimber gosho = new RockClimber("Gosho", 6);

        Assert.assertEquals(0, climbing.getCount());
        climbing.addRockClimber(gosho);

        Assert.assertEquals(1, climbing.getCount());


    }

    //Remove climber with name null
    @Test
    public void testRemoveClimberInvalidName(){
        Climbing climbing = new Climbing("Climbing1", 10);
        RockClimber gosho = new RockClimber("Gosho", 6);
        RockClimber peter = new RockClimber("Peter", 6);

        climbing.addRockClimber(gosho);
        climbing.addRockClimber(peter);


        Assert.assertFalse(climbing.removeRockClimber("Josh"));


    }
    //Remove climber successfully
    @Test
    public void testRemoveClimberSuccessfully(){
        Climbing climbing = new Climbing("Climbing1", 10);
        RockClimber gosho = new RockClimber("Gosho", 6);
        RockClimber peter = new RockClimber("Peter", 6);

        climbing.addRockClimber(gosho);
        climbing.addRockClimber(peter);

        Assert.assertTrue(climbing.removeRockClimber("Gosho"));
    }

    @Test
    public void testClimberStrength(){
        RockClimber gosho = new RockClimber("Gosho", 6.6);

        double expectedStrength = gosho.getStrength();

        Assert.assertEquals(6.6, expectedStrength, DELTA);
    }

}
