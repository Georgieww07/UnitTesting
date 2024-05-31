package bank;

import org.junit.Assert;
import org.junit.Test;

public class BankTests {

    //1.Test constructor

    //Create Bank with null name
    @Test(expected = NullPointerException.class)
    public void testCreateBankNullName(){
        new Bank(null, 10);
    }
    //Create Bank with empty name
    @Test(expected = NullPointerException.class)
    public void testCreateBankEmptyName(){
        new Bank("", 10);
    }
    //Create Bank with invalid capacity
    @Test(expected = IllegalArgumentException.class)
    public void testCreateBankInvalidCapacity(){
        new Bank("PostBank", -10);
    }
    //Create Bank with valid values
    @Test
    public void testCreateBankValidParams(){
        Bank bank = new Bank("PostBank", 10);

        Assert.assertEquals("PostBank", bank.getName());
        Assert.assertEquals(10, bank.getCapacity());

    }

    //AddClient when clients == capacity
    @Test(expected = IllegalArgumentException.class)
    public void testAddClientNoSpaceAvailable(){
        Bank bank = new Bank("PostBank", 1);
        Client client1 = new Client("Peter");
        Client client2 = new Client("John");

        bank.addClient(client1);

        Assert.assertEquals(1, bank.getCount());

        bank.addClient(client2);

    }
    //Successfully added
    @Test
    public void testAddClientSuccessfully(){
        Bank bank = new Bank("PostBank", 10);
        Client client1 = new Client("Peter");
        Client client2 = new Client("John");

        bank.addClient(client1);
        Assert.assertEquals(1, bank.getCount());
        bank.addClient(client2);
        Assert.assertEquals(2, bank.getCount());
    }

    //Test remove non-existing name
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingName(){
        Bank bank = new Bank("PostBank", 10);
        Client client1 = new Client("Peter");

        bank.addClient(client1);
        bank.removeClient("Gosho");

    }
    //Test remove with valid name
    @Test
    public void testRemoveValidParams(){
        Bank bank = new Bank("PostBank", 10);
        Client client1 = new Client("Peter");
        Client client2 = new Client("John");

        bank.addClient(client1);
        bank.addClient(client2);

        Assert.assertEquals(2, bank.getCount());
        bank.removeClient("Peter");

        Assert.assertEquals(1, bank.getCount());
    }

    //Test withdraw non-existing name
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNonExistingName(){
        Bank bank = new Bank("PostBank", 10);
        Client client1 = new Client("Peter");
        Client client2 = new Client("John");

        bank.addClient(client1);
        bank.addClient(client2);

        bank.loanWithdrawal("Gosho");
    }
    //Test withdraw valid params
    @Test
    public void testWithdrawValidParams(){
        Bank bank = new Bank("PostBank", 10);
        Client client1 = new Client("Peter");
        Client client2 = new Client("John");

        bank.addClient(client1);
        bank.addClient(client2);

        Assert.assertTrue(client1.isApprovedForLoan());

        bank.loanWithdrawal("Peter");

        Assert.assertFalse(client1.isApprovedForLoan());

    }

    @Test
    public void testStatistics(){
        Bank bank = new Bank("PostBank", 10);
        Client client1 = new Client("Peter");
        Client client2 = new Client("John");

        bank.addClient(client1);
        bank.addClient(client2);

        String expectedOutput = "The client Peter, John is at the PostBank bank!";

        Assert.assertEquals(expectedOutput, bank.statistics());
    }
}
