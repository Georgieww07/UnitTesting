package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {
    @Test(expected = NullPointerException.class)
    public void testCreateServiceNullName(){
        new Service(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateServiceEmptyName(){
        new Service("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateServiceInvalidCapacity(){
        new Service("Service", -10);
    }

    @Test
    public void testCreateServiceValidParams(){
        Service service = new Service("Service", 10);

        Assert.assertEquals("Service", service.getName());
        Assert.assertEquals(10, service.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotWhenNoSpace(){
        Service service = new Service("Service", 1);

        Robot robot1 = new Robot("Peter");
        Robot robot2 = new Robot("John");

        service.add(robot1);

        Assert.assertEquals(1, service.getCount());

        service.add(robot2);
    }

    @Test
    public void testAddRobotAvailableSpace(){
        Service service = new Service("Service", 10);

        Robot robot1 = new Robot("Peter");
        Robot robot2 = new Robot("John");

        service.add(robot1);

        Assert.assertEquals(1, service.getCount());

        service.add(robot2);

        Assert.assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotInvalidName(){
        Service service = new Service("Service", 10);

        Robot robot1 = new Robot("Peter");
        Robot robot2 = new Robot("John");

        service.add(robot1);
        service.add(robot2);

        service.remove("Gosho");

    }

    @Test
    public void testRemoveRobotValidArgs(){
        Service service = new Service("Service", 10);

        Robot robot1 = new Robot("Peter");
        Robot robot2 = new Robot("John");

        service.add(robot1);
        service.add(robot2);

        Assert.assertEquals(2, service.getCount());

        service.remove("Peter");

        Assert.assertEquals(1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRobotForSaleInvalidName(){
        Service service = new Service("Service", 10);

        Robot robot1 = new Robot("Peter");
        Robot robot2 = new Robot("John");

        service.add(robot1);
        service.add(robot2);

       service.forSale("Gosho");
    }

    @Test
    public void testRobotForSaleValidArgs(){
        Service service = new Service("Service", 10);

        Robot robot1 = new Robot("Peter");
        Robot robot2 = new Robot("John");

        service.add(robot1);
        service.add(robot2);

        Assert.assertTrue(robot1.isReadyForSale());

        service.forSale("Peter");

        Assert.assertFalse(robot1.isReadyForSale());
    }

    @Test
    public void testRobotReport(){
        Service service = new Service("Service", 10);

        Robot robot1 = new Robot("Peter");
        Robot robot2 = new Robot("John");

        service.add(robot1);
        service.add(robot2);

        String expectedOutput = "The robot Peter, John is in the service Service!";

        Assert.assertEquals(expectedOutput, service.report());
    }
}
