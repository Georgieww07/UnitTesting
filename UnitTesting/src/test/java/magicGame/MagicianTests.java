package magicGame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MagicianTests {

    @Test(expected = NullPointerException.class)
    public void testCreateMagicianWhenUsernameNull(){
        new Magician(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateMagicianWhenUsernameEmpty(){
        new Magician("", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMagicianWhenHealthNegative(){
        new Magician("Magician", -100);
    }

    @Test
    public void testCreateMagicianSuccessfully(){
        Magician magician = new Magician("Magician", 100);

        Assert.assertEquals("Magician", magician.getUsername());
        Assert.assertEquals(100, magician.getHealth());
        Assert.assertEquals(new ArrayList<>(), magician.getMagics());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadMagicianTakeDamage(){
        Magician magician = new Magician("Magician", 0);

        magician.takeDamage(50);
    }

    @Test
    public void testMagicianTakeDamageHealthBelowZero(){
        Magician magician = new Magician("Magician", 50);
        magician.takeDamage(100);

        Assert.assertEquals(0, magician.getHealth());
    }

    @Test
    public void testMagicianTakeDamageSuccessfully(){
        Magician magician = new Magician("Magician", 100);
        magician.takeDamage(50);

        Assert.assertEquals(50, magician.getHealth());

    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicWhenMagicNull(){
        Magician magician = new Magician("Magician", 100);
        Magic magic = null;

        magician.addMagic(magic);
    }

    @Test
    public void testAddMagicSuccessfully(){
        Magician magician = new Magician("Magician", 100);
        Magic magic = new Magic("Magic", 10);


        Assert.assertEquals(0, magician.getMagics().size());
        magician.addMagic(magic);
        Assert.assertEquals(1, magician.getMagics().size());
    }

    @Test
    public void testRemoveMagic(){
        Magician magician = new Magician("Magician", 100);
        Magic magic1 = new Magic("Magic1", 10);
        Magic magic2 = new Magic("Magic2", 5);

        magician.addMagic(magic1);
        magician.addMagic(magic2);
        Assert.assertEquals(2, magician.getMagics().size());
        magician.removeMagic(magic1);
        Assert.assertEquals(1, magician.getMagics().size());
    }

    @Test
    public void testGetMagicWhenNoSuchAvailable(){
        Magician magician = new Magician("Magician", 100);
        Magic magic1 = new Magic("Magic1", 10);
        Magic magic2 = new Magic("Magic2", 5);

        magician.addMagic(magic1);
        magician.addMagic(magic2);

        Magic currentMagic = magician.getMagic("Gosho");
        Assert.assertNull(currentMagic);
    }

    @Test
    public void testGetMagicSuccessfully(){
        Magician magician = new Magician("Magician", 100);
        Magic magic1 = new Magic("Magic1", 10);
        Magic magic2 = new Magic("Magic2", 5);

        magician.addMagic(magic1);
        magician.addMagic(magic2);

        Magic currentMagic = magician.getMagic("Magic1");
        Assert.assertEquals(magic1, currentMagic);
    }

    @Test
    public void testGetBullets(){
        Magic magic1 = new Magic("Magic1", 10);
        Assert.assertEquals(10, magic1.getBullets());
    }
}
