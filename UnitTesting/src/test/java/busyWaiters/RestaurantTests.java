package busyWaiters;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class RestaurantTests {

    @Test(expected = NullPointerException.class)
    public void testCreateRestaurantNullName(){
        new Restaurant(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateRestaurantEmptyName(){
        new Restaurant("", 10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCreateRestaurantNegativeCapacity(){
        new Restaurant("SanMarco", -10);
    }

    @Test
    public void testCreateRestaurantSuccessfully(){
        Restaurant restaurant = new Restaurant("SanMarco", 10);

        Assert.assertEquals("SanMarco", restaurant.getName());
        Assert.assertEquals(10, restaurant.getCapacity());
        Assert.assertEquals(new ArrayList<>(), restaurant.getWaiters());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWaiterWhenNoCapacity(){
        Restaurant restaurant = new Restaurant("SanMarco", 1);

        FullTimeWaiter waiter1 = new FullTimeWaiter("Peter", 5);
        FullTimeWaiter waiter2 = new FullTimeWaiter("John", 6);

        restaurant.addFullTimeWaiter(waiter1);
        restaurant.addFullTimeWaiter(waiter2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWaiterDuplicate(){
        Restaurant restaurant = new Restaurant("SanMarco", 10);

        FullTimeWaiter waiter1 = new FullTimeWaiter("Peter", 5);
        FullTimeWaiter waiter2 = new FullTimeWaiter("John", 6);
        FullTimeWaiter waiter3 = new FullTimeWaiter("John", 7);

        restaurant.addFullTimeWaiter(waiter1);
        restaurant.addFullTimeWaiter(waiter2);
        restaurant.addFullTimeWaiter(waiter3);
    }

    @Test
    public void testAddWaiterSuccessfully(){
        Restaurant restaurant = new Restaurant("SanMarco", 10);

        FullTimeWaiter waiter1 = new FullTimeWaiter("Peter", 5);
        FullTimeWaiter waiter2 = new FullTimeWaiter("John", 6);
        FullTimeWaiter waiter3 = new FullTimeWaiter("Katy", 7);

        Assert.assertEquals(0, restaurant.getCount());

        restaurant.addFullTimeWaiter(waiter1);
        restaurant.addFullTimeWaiter(waiter2);
        restaurant.addFullTimeWaiter(waiter3);

        Assert.assertEquals(3, restaurant.getCount());

    }

    @Test
    public void testRemoveWaiterWhenNoSuchExists(){
        Restaurant restaurant = new Restaurant("SanMarco", 10);

        FullTimeWaiter waiter1 = new FullTimeWaiter("Peter", 5);
        FullTimeWaiter waiter2 = new FullTimeWaiter("John", 6);

        restaurant.addFullTimeWaiter(waiter1);
        restaurant.addFullTimeWaiter(waiter2);

        boolean isRemoved = restaurant.removeFullTimeWaiter("Gosho");

        Assert.assertFalse(isRemoved);

    }

    @Test
    public void testRemoveWaiterSuccessfully(){
        Restaurant restaurant = new Restaurant("SanMarco", 10);

        FullTimeWaiter waiter1 = new FullTimeWaiter("Peter", 5);
        FullTimeWaiter waiter2 = new FullTimeWaiter("John", 6);

        restaurant.addFullTimeWaiter(waiter1);
        restaurant.addFullTimeWaiter(waiter2);

        Assert.assertEquals(2, restaurant.getCount());

        boolean isRemoved = restaurant.removeFullTimeWaiter("Peter");
        Assert.assertEquals(1, restaurant.getCount());

        Assert.assertTrue(isRemoved);
    }

    @Test
    public void testWaiterGetEfficiency(){
        FullTimeWaiter waiter1 = new FullTimeWaiter("Peter", 5);

        Assert.assertEquals(5, waiter1.getEfficiency());

    }
}
