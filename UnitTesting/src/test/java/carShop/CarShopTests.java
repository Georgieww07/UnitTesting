package carShop;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarShopTests {
    //CreateCarShop
    @Test
    public void testCreateCarShop(){
        CarShop carShop = new CarShop();
        Assert.assertEquals(new ArrayList<>(), carShop.getCars());
    }

    @Test
    public void testGetCount(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Audi", 200, 1500.50);
        Car car2 = new Car("BMW", 100, 1768.98);
        Car car3 = new Car("Opel", 150, 1876.65);

        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);

        Assert.assertEquals(3, carShop.getCount());
    }

    @Test
    public void testFindAllCarsMaxHp(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Audi", 200, 1500.50);
        Car car2 = new Car("BMW", 100, 1768.98);
        Car car3 = new Car("Opel", 150, 1876.65);

        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);

        List<Car> allCarsWithMaxHorsePower = carShop.findAllCarsWithMaxHorsePower(100);

        Assert.assertEquals(2, allCarsWithMaxHorsePower.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullCar(){
        CarShop carShop = new CarShop();
        Car car = null;
        carShop.add(car);
    }

    @Test
    public void testAddCarSuccessfully(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Audi", 200, 1500.50);
        Car car2 = new Car("BMW", 100, 1768.98);

        Assert.assertEquals(0, carShop.getCount());

        carShop.add(car1);
        carShop.add(car2);

        Assert.assertEquals(2, carShop.getCount());

    }

    @Test
    public void testRemoveCar(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Audi", 200, 1500.50);
        Car car2 = new Car("BMW", 100, 1768.98);

        carShop.add(car1);
        carShop.add(car2);

        Assert.assertEquals(2, carShop.getCount());
        carShop.remove(car1);

        Assert.assertEquals(1, carShop.getCount());

    }

    @Test
    public void testGetTheMostLuxuriousCarInvalidParams(){
        CarShop carShop = new CarShop();

        Car theMostLuxuryCar = carShop.getTheMostLuxuryCar();

        Assert.assertNull(theMostLuxuryCar);
    }

    @Test
    public void testGetTheMostLuxuriousCarValid(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Audi", 200, 1500.50);
        Car car2 = new Car("BMW", 100, 1768.98);

        carShop.add(car1);
        carShop.add(car2);

        Assert.assertEquals(car2, carShop.getTheMostLuxuryCar());
    }

    @Test
    public void testFindAllCarsByModel(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Audi", 200, 1500.50);
        Car car2 = new Car("Audi", 200, 1500.50);
        Car car3 = new Car("BMW", 100, 1768.98);
        Car car4 = new Car("Opel", 100, 1768.98);

        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);

        List<Car> audiCars = carShop.findAllCarByModel("Audi");

        Assert.assertEquals(2, audiCars.size());
    }

}

