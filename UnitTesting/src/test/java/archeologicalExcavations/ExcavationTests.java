package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

public class ExcavationTests {
    @Test(expected = NullPointerException.class)
    public void testCreateExcavationWhenNameNull(){
        new Excavation(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateExcavationWhenNameEmpty(){
        new Excavation("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateExcavationWhenCapacityBelowZero(){
        new Excavation("Excavation", -10);
    }

    @Test
    public void testCreateExcavationSuccessfully(){
        Excavation excavation = new Excavation("Excavation", 10);

        Assert.assertEquals("Excavation", excavation.getName());
        Assert.assertEquals(10, excavation.getCapacity());
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistWhenNoSpace(){
        Excavation excavation = new Excavation("Excavation", 1);
        Archaeologist archaeologist1 = new Archaeologist("Peter", 50);
        Archaeologist archaeologist2 = new Archaeologist("John", 100);

        excavation.addArchaeologist(archaeologist1);
        Assert.assertEquals(1, excavation.getCount());

        excavation.addArchaeologist(archaeologist2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistDuplicate(){
        Excavation excavation = new Excavation("Excavation", 10);
        Archaeologist archaeologist1 = new Archaeologist("Peter", 50);
        Archaeologist archaeologist2 = new Archaeologist("Peter", 100);

        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
    }

    @Test
    public void testSuccessfullyAddArchaeologist(){
        Excavation excavation = new Excavation("Excavation", 10);
        Archaeologist archaeologist1 = new Archaeologist("Peter", 50);
        Archaeologist archaeologist2 = new Archaeologist("John", 100);

        Assert.assertEquals(0, excavation.getCount());

        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);

        Assert.assertEquals(2, excavation.getCount());
    }

    @Test
    public void testRemoveArchaeologistWhenNotExist(){
        Excavation excavation = new Excavation("Excavation", 10);
        Archaeologist archaeologist1 = new Archaeologist("Peter", 50);
        Archaeologist archaeologist2 = new Archaeologist("John", 100);

        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);

        boolean isRemoved = excavation.removeArchaeologist("Gosho");
        Assert.assertFalse(isRemoved);
    }

    @Test
    public void testRemoveArchaeologistSuccessfully(){
        Excavation excavation = new Excavation("Excavation", 10);
        Archaeologist archaeologist1 = new Archaeologist("Peter", 50);
        Archaeologist archaeologist2 = new Archaeologist("John", 100);

        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);

        boolean isRemoved = excavation.removeArchaeologist("Peter");
        Assert.assertTrue(isRemoved);
    }

    @Test
    public void testArchaeologistGetEnergy(){
        Archaeologist archaeologist1 = new Archaeologist("Peter", 50);

        Assert.assertEquals(50, archaeologist1.getEnergy(), 40-60);
    }
}
