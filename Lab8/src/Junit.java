import static org.junit.Assert.*;

import org.junit.Test;

public class Junit {
	int grade = 0;

	@Test
    public void testCashierConstructor() {
      try{
        Cashier cashier = new Cashier();
        assertEquals("Cashier get initial total customer wait time", 0, cashier.getTotalCustomerWaitTime());
        assertEquals("Cashier get initial total items served", 0, cashier.getTotalItemsServed());
        assertEquals("Cashier get initial total customers served", 0, cashier.getTotalCustomersServed());

        grade += 1;
      } catch (Exception e){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Exception thrown in method testCashierConstructor");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void testCashierServeEmpty() {
      try{
        Cashier cashier = new Cashier();
        cashier.serveCustomers(5);
        assertEquals("Cashier with no customers - total wait time", 0, cashier.getTotalCustomerWaitTime());
        assertEquals("Cashier with no customers - total items served", 0, cashier.getTotalItemsServed());
        assertEquals("Cashier with no customers - total customers served", 0, cashier.getTotalCustomersServed());

        grade += 1;
      } catch (Exception e){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Exception thrown in method testCashierServeEmpty");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void testCashierServeOne() {
      try{
        Cashier cashier = new Cashier();
        Customer customer = new Customer(5);
        cashier.addCustomer(customer);

        assertEquals("Queue size with one customer", 1, cashier.getQueueSize());
        grade += 0.5;

        int items = customer.getNumberOfItems();

        for (int i = 0; i < items; i++) {
          cashier.serveCustomers(10);
        }

        assertEquals("Queue size after finishing to serve all items", 0, cashier.getQueueSize());
        grade += 0.5;

        assertEquals("Total number of items served after one customer", items, cashier.getTotalItemsServed());
        assertEquals("Total customers served after one customer", 1, cashier.getTotalCustomersServed());
        grade += 0.5;

        assertEquals("Total wait time after one customer", 5, cashier.getTotalCustomerWaitTime());
        grade += 0.5;
      } catch (Exception e){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Exception thrown in method testCashierServeOne");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void cashierServeTwo() {
      try{
        Cashier cashier = new Cashier();
        Customer customer1 = new Customer(5);
        Customer customer2 = new Customer(10);
        cashier.addCustomer(customer1);
        cashier.addCustomer(customer2);

        assertEquals("Queue size with 2 customers", 2, cashier.getQueueSize());
        grade += 0.5;

        int items1 = customer1.getNumberOfItems();
        int items2 = customer2.getNumberOfItems();

        for (int i = 0; i < items1; i++) {
          cashier.serveCustomers(10);
        }

        assertEquals("Total customers served after one customer", 1, cashier.getTotalCustomersServed());
        grade += 0.25;

        assertEquals("Total customers remained in queue after one customer", 1, cashier.getQueueSize());
        grade += 0.25;

        for (int i = 0; i < items2; i++) {
          cashier.serveCustomers(15);
        }

        assertEquals("Total customers served after 2 customers", 2, cashier.getTotalCustomersServed());
        grade += 0.5;

        assertEquals("Total items served after 2 customers", items1 + items2, cashier.getTotalItemsServed());
        grade += 0.5;

        assertEquals("Total wait time for multiple customers", 10, cashier.getTotalCustomerWaitTime());
        grade += 0.5;

        assertEquals("Queue size with no customers left", 0, cashier.getQueueSize());
        grade += 0.5;
      } catch (Exception e){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Exception thrown in method testCashierServeOne");
        e.printStackTrace();
        fail(e.toString());
      }
    }
    @Test
    public void testCustomerConstructorGetArrivalTime() {
      try{
        Customer someGuy = new Customer(5);
        assertEquals("ArrivalTime initialization in constructor", 5, someGuy.getArrivalTime());

        Customer fastGuy = new Customer(0);
        assertEquals("ArrivalTime initialization in constructor", 0, fastGuy.getArrivalTime());

        grade += 1;
      } catch (Exception e){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Exception thrown in test method testCustomerConstructorGetArrivalTime");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void testCustomerServeItems() {
      try{
        Customer someGuy = new Customer(5);
        int beforeItems = someGuy.getNumberOfItems();
        someGuy.serve();
        int afterItems = someGuy.getNumberOfItems();
        int diffItems = beforeItems - afterItems;
        assertEquals("Customer serve should decrease the number of items to be served", 1, diffItems);

        grade += 1;
      } catch (Exception e){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Exception thrown in test method testCustomerServeItems");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void testCustomerGetNumberOfServedItems() {
      try{
        Customer someGuy = new Customer(5);
        assertEquals("Initially, there are no served items", 0, someGuy.getNumberOfServedItems());
        someGuy.serve();
        assertEquals("Served one item", 1, someGuy.getNumberOfServedItems());
        someGuy.serve();
        someGuy.serve();
        assertEquals("Served multiple items", 3, someGuy.getNumberOfServedItems());

        grade += 1;
      } catch (Exception e){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Exception thrown in test method testCustomerGetNumberOfServedItems");
        e.printStackTrace();
        fail(e.toString());
      }
    }



}
