package scubaDive;


import org.junit.Assert;
import org.junit.Test;

public class DivingTests {

    @Test(expected = NullPointerException.class)
    public void testCreateDivingNullName(){
        new Diving(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateDivingEmptyName(){
        new Diving("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateDivingInvalidCapacity(){
        new Diving("Diving", -10);
    }

    @Test
    public void testCreateDivingSuccessfully(){
        Diving diving = new Diving("Diving", 10);

        Assert.assertEquals("Diving", diving.getName());
        Assert.assertEquals(10, diving.getCapacity());
        Assert.assertEquals(0, diving.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDeepWaterDiverWhenNoCapacity(){
        Diving diving = new Diving("Diving", 1);
        DeepWaterDiver diver1 = new DeepWaterDiver("Diver1", 5.5);
        DeepWaterDiver diver2 = new DeepWaterDiver("Diver2", 6.5);

        diving.addDeepWaterDiver(diver1);
        Assert.assertEquals(1, diving.getCount());

        diving.addDeepWaterDiver(diver2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDeepWaterDiverExist(){
        Diving diving = new Diving("Diving", 10);
        DeepWaterDiver diver1 = new DeepWaterDiver("Diver1", 5.5);
        DeepWaterDiver diver2 = new DeepWaterDiver("Diver2", 6.5);
        DeepWaterDiver diver3 = new DeepWaterDiver("Diver2", 6.5);

        diving.addDeepWaterDiver(diver1);
        diving.addDeepWaterDiver(diver2);

        diving.addDeepWaterDiver(diver3);

    }

    @Test
    public void testAddDeepWaterDiverSuccessfully(){
        Diving diving = new Diving("Diving", 10);
        DeepWaterDiver diver1 = new DeepWaterDiver("Diver1", 5.5);
        DeepWaterDiver diver2 = new DeepWaterDiver("Diver2", 6.5);
        DeepWaterDiver diver3 = new DeepWaterDiver("Diver3", 7.5);

        Assert.assertEquals(0, diving.getCount());

        diving.addDeepWaterDiver(diver1);
        diving.addDeepWaterDiver(diver2);
        diving.addDeepWaterDiver(diver3);

        Assert.assertEquals(3, diving.getCount());
    }

    @Test
    public void testRemoveDiverWhenNoSuchOne(){
        Diving diving = new Diving("Diving", 10);
        DeepWaterDiver diver1 = new DeepWaterDiver("Diver1", 5.5);
        DeepWaterDiver diver2 = new DeepWaterDiver("Diver2", 6.5);
        DeepWaterDiver diver3 = new DeepWaterDiver("Diver3", 7.5);

        diving.addDeepWaterDiver(diver1);
        diving.addDeepWaterDiver(diver2);
        diving.addDeepWaterDiver(diver3);

        Assert.assertFalse(diving.removeDeepWaterDiver("Diver5"));

    }

    @Test
    public void testRemoveDeepWaterDiverSuccessfully(){
        Diving diving = new Diving("Diving", 10);
        DeepWaterDiver diver1 = new DeepWaterDiver("Diver1", 5.5);
        DeepWaterDiver diver2 = new DeepWaterDiver("Diver2", 6.5);
        DeepWaterDiver diver3 = new DeepWaterDiver("Diver3", 7.5);

        diving.addDeepWaterDiver(diver1);
        diving.addDeepWaterDiver(diver2);
        diving.addDeepWaterDiver(diver3);

        Assert.assertTrue(diving.removeDeepWaterDiver("Diver1"));
    }

    @Test
    public void testGetOxygen(){
        Diving diving = new Diving("Diving", 10);
        DeepWaterDiver diver1 = new DeepWaterDiver("Diver1", 5.5);
        diving.addDeepWaterDiver(diver1);

        Assert.assertEquals(5.5, diver1.getOxygen(), 5-10);
    }

}
