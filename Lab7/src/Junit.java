import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class Junit {

	/**
	 *
	 * @author Diana Lucaci (dluca058@uottawa.ca)
	 */
	int grade = 0;
	
	    @Test
	    public void testConstructorGetBalance() {
	        Account account = new Account();
	        assertEquals("The initial balance should be 0",0, account.getBalance(), 0.0001);
	        grade += 0.5;
	    }

	    @Test
	    public void testDeposit() {
	        Account account = new Account();
	        account.deposit(10.37);
	        assertEquals("The balance after deposit should be updated",10.37, account.getBalance(),0.0001);
	        grade += 0.25;
	    }

		@Test
	    public void testWithdraw() {
	        Account account = new Account();
	        account.deposit(10.37);
	        account.withdraw(5.37);
	        assertEquals("The balance after a withdrawal should be updated",5.0, account.getBalance(),0.0001);
	        grade += 0.25;
	    }
	    @Test(expected = NotEnoughMoneyException.class)
	    public void testWithdrawThrowsNotEnoughMoneyException() {
	        Account account = new Account();
	        account.deposit(10.37);
	        account.withdraw(15.37);
	        grade += 0.5;
	    }

	    @Test
	    public void testWithdrawThrowsNotEnoughMoneyExceptionGetAmount() {
	        Account account = new Account();
	        account.deposit(10.37);
	        try {
	            account.withdraw(15.37);
	        } catch(NotEnoughMoneyException e){
	            assertEquals("Amount saved by the exception", 15.37, e.getAmount(),0.0001);
	            grade += 0.25;
	        }
	    }

	    @Test
	    public void testWithdrawThrowsNotEnoughMoneyExceptionGetBalance() {
	        Account account = new Account();
	        account.deposit(10.37);
	        try {
	            account.withdraw(15.37);
	        } catch(NotEnoughMoneyException e){
	            assertEquals("Amount saved by the exception", 15.37, e.getAmount(),0.0001);
	            grade += 0.25;
	        }
	    }

	    @Test
	    public void testWithdrawThrowsNotEnoughMoneyExceptionGetMissingAmount() {
	        Account account = new Account();
	        account.deposit(10.37);
	        try {
	            account.withdraw(15.37);
	        } catch(NotEnoughMoneyException e){
	            assertEquals("Missing amount saved by the exception", 5.0, e.getMissingAmount(), 0.0001);
	            grade += 0.5;
	        }
	    }
	    @Test
	    public void testPeekThrowsEmptyStackException1(){
	        ArrayStack<String> stack = new ArrayStack<String>(10);
	        try{
	            stack.peek();
	            fail("Peek - empty stack should raise EmptyStackException(from java.util)");
	        } catch (EmptyStackException e){
	          grade += 0.5;
	        }
	    }

	    @Test
	    public void testPopThrowsEmptyStackException1(){
	        ArrayStack<String> stack = new ArrayStack<String>(10);
	        try {
	            String element = stack.pop();
	            fail("Poping from an empty stack should raise EmptyStackException (from java.util)");
	        }catch (EmptyStackException e){
	            grade += 0.5;
	        }
	    }

	    @Test
	    public void testPushThrowsFullStackException(){
	        ArrayStack<String> stack = new ArrayStack<String>(0);
	        try{
	            stack.push("dogs");
	            fail("Pop element from an empty stack should raise the custom exception FullStackException");
	        }catch (FullStackException e){
	            grade += 0.25;
	        }
	    }

	    @Test
	    public void testPushCapacity1ThrowsFullStackException(){
	        ArrayStack<String> stack = new ArrayStack<String>(1);
	        try{
	            stack.push("cats");
	            stack.push("dogs");
	            fail("Pop element from an empty stack should raise the custom exception FullStackException");
	        }catch (FullStackException e){
	            grade += 0.25;
	        }
	    }
	    @Test
	    public void testGetNoSuchElementException() {
	        Dictionary dict = new Dictionary();
	        try {
	            dict.get("V");
	            fail("Get inexistent key should raise NoSuchElementException");
	        } catch (NoSuchElementException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testGetNoSuchElementExceptionNonEmpty() {
	        try {
	            Dictionary dict = new Dictionary();
	            dict.put("X", 1);
	            dict.put("Y", 2);
	            dict.put("Z", 3);
	            dict.get("V");
	            fail("Get inexistent key should raise NoSuchElementException");
	        } catch (NoSuchElementException e) {
	            grade += 0.5;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testGetNullPointerException() {
	        try {
	            Dictionary dict = new Dictionary();
	            dict.get(null);
	            fail("Get null key should raise a NullPointerException");
	        } catch(NullPointerException e) {
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Get method failed to raise NullPointerException, instead: " + e.toString());
	        }
	    }

	    @Test
	    public void testContainsNullPointerException() {
	        Dictionary dict = new Dictionary();
	        try {
	            dict.contains(null);
	            fail("Searching for a null key should raise NullPointerException");
	        } catch (NullPointerException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Contains method failed to raise NullPointerException, instead: " + e.toString());
	        }
	    }

	    @Test
	    public void testPutNullPointerExceptionKey() {
	        Dictionary dict = new Dictionary();
	        try {
	            dict.put(null, 1);
	            fail("Putting a null key should raise NullPointerException");
	        } catch (NullPointerException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testPutNullPointerExceptionValue() {
	        Dictionary dict = new Dictionary();
	        try {
	            dict.put("X", null);
	            fail("Putting a null value should raise NullPointerException");
	        } catch (NullPointerException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testPutNullPointerExceptionKeyValue() {
	        Dictionary dict = new Dictionary();
	        try {
	            dict.put(null, null);
	            fail("Putting a null key and null value should raise NullPointerException");
	        } catch (NullPointerException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testReplaceNullPointerExceptionKey() {
	        Dictionary dict = new Dictionary();
	        try{
	            dict.replace(null, 1);
	            fail("Replacing a null key should raise NullPointerException");
	        } catch (NullPointerException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testReplaceNullPointerExceptionValue() {
	        Dictionary dict = new Dictionary();
	        try{
	            dict.replace("X", null);
	            fail("Replacing a null value should raise NullPointerException");
	        } catch (NullPointerException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testReplaceNullPointerExceptionKeyValue() {
	        Dictionary dict = new Dictionary();
	        try{
	            dict.replace(null, null);
	            fail("Replacing a null key and a null value should raise NullPointerException");
	        } catch (NullPointerException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testReplaceNoSuchElementException() {
	        Dictionary dict = new Dictionary();
	        try{
	            dict.replace("V", 1);
	            fail("Replacing an inexistent key should raise NoSuchElementException");
	        } catch (NoSuchElementException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testReplaceNonEmptyNoSuchElementException() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        try{
	            dict.replace("V", 1);
	            fail("Replacing an inexistent key should raise NoSuchElementException");
	        } catch (NoSuchElementException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testRemoveNullPointerException() {
	        Dictionary dict = new Dictionary();
	        try{
	            dict.remove(null);
	            fail("Removing a null key value should raise NullPointerException");
	        } catch (NullPointerException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testRemoveNoSuchElementException() {
	        Dictionary dict = new Dictionary();
	        try{
	            dict.remove("V");
	            fail("Removing an inexitent key should raise NoSuchElementException");
	        } catch (NoSuchElementException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test
	    public void testRemoveNoSuchElementExceptionNonEmpty() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        try{
	            dict.remove("V");
	            fail("Removing an inexistent key should raise NoSuchElementException");
	        } catch (NoSuchElementException e){
	            grade += 0.25;
	        } catch(Exception e){
	            fail("Exception raised during test: " + e.toString());
	        }
	    }

	    @Test()
	    public void testRemoveX() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.remove("X");
	        Assert.assertFalse(dict.contains("X"));
	        assertEquals(2, (int) dict.get("Y"));
	        assertEquals(3, (int) dict.get("Z"));
	    }

	    @Test()
	    public void testRemoveY() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.remove("Y");
	        Assert.assertFalse(dict.contains("Y"));
	        assertEquals(1, (int) dict.get("X"));
	        assertEquals(3, (int) dict.get("Z"));
	    }

	    @Test()
	    public void testRemoveZ() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.remove("Z");
	        Assert.assertFalse(dict.contains("Z"));
	        assertEquals(1, (int) dict.get("X"));
	        assertEquals(2, (int) dict.get("Y"));
	    }

	    @Test()
	    public void testRemoveXX() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("X", 4);
	        dict.remove("X");
	        assertEquals(1, (int) dict.get("X"));
	        assertEquals(2, (int) dict.get("Y"));
	        assertEquals(3, (int) dict.get("Z"));
	    }

	    @Test()
	    public void testRemoveYY() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("Y", 4);
	        dict.remove("Y");
	        assertEquals(1, (int) dict.get("X"));
	        assertEquals(2, (int) dict.get("Y"));
	        assertEquals(3, (int) dict.get("Z"));
	    }

	    @Test()
	    public void testRemoveZZ() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("Z", 4);
	        dict.remove("Z");
	        assertEquals(1, (int) dict.get("X"));
	        assertEquals(2, (int) dict.get("Y"));
	        assertEquals(3, (int) dict.get("Z"));
	    }

	    @Test()
	    public void testGetStatic() {
	        Dictionary d1 = new Dictionary();
	        Dictionary d2 = new Dictionary();
	        d1.put("X", 1);
	        Assert.assertFalse(d2.contains("X"));
	    }
	    @Test()
	    public void testGetX() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        assertEquals(1, (int) dict.get("X"));
	    }

	    @Test()
	    public void testGetY() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        assertEquals(2, (int) dict.get("Y"));
	    }

	    @Test()
	    public void testGetZ() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        assertEquals(3, (int) dict.get("Z"));
	    }

	    @Test()
	    public void testGetXX() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("X", 4);
	        assertEquals(4, (int) dict.get("X"));
	    }

	    @Test()
	    public void testGetYY() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("Y", 4);
	        assertEquals(4, (int) dict.get("Y"));
	    }

	    @Test()
	    public void testGetZZ() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("Z", 4);
	        assertEquals(4, (int) dict.get("Z"));
	    }

	    @Test()
	    public void testReplaceX() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.replace("X", 4);
	        assertEquals(4, (int) dict.get("X"));
	    }

	    @Test()
	    public void testReplaceY() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.replace("Y", 4);
	        assertEquals(4, (int) dict.get("Y"));
	    }

	    @Test()
	    public void testReplaceZ() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.replace("Z", 4);
	        assertEquals(4, (int) dict.get("Z"));
	    }

	    @Test()
	    public void testReplaceXX() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("X", 4);
	        dict.replace("X", 5);
	        assertEquals(5, (int) dict.get("X"));
	    }

	    @Test()
	    public void testReplaceYY() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("Y", 4);
	        dict.replace("Y", 5);
	        assertEquals(5, (int) dict.get("Y"));
	    }

	    @Test()
	    public void testReplaceZZ() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("Z", 4);
	        dict.replace("Z", 5);
	        assertEquals(5, (int) dict.get("Z"));
	    }

	    @Test()
	    public void testPutDyncamicArray() {
	        Dictionary dict = new Dictionary();
	        for (int i = 0; i < 1000; i++) {
	            dict.put("X" + i, i);
	        }
	        for (int i = 0; i < 1000; i++) {
	            assertEquals(i, (int) dict.get("X" + i));
	        }
	    }

	    @Test()
	    public void testContainsEmpty() {
	        Dictionary dict = new Dictionary();
	        Assert.assertFalse(dict.contains("X"));
	    }

	    @Test()
	    public void testContainsNotFound() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        Assert.assertFalse(dict.contains("W"));
	    }

	    @Test()
	    public void testContainsX() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        Assert.assertTrue(dict.contains("X"));
	    }

	    @Test()
	    public void testContainsY() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        Assert.assertTrue(dict.contains("Y"));
	    }

	    @Test()
	    public void testContainsZ() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        Assert.assertTrue(dict.contains("Z"));
	    }

	    @Test()
	    public void testContainsXX() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("X", 4);
	        Assert.assertTrue(dict.contains("X"));
	    }

	    @Test()
	    public void testContainsYY() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("Y", 4);
	        Assert.assertTrue(dict.contains("Y"));
	    }

	    @Test()
	    public void testContainsZZ() {
	        Dictionary dict = new Dictionary();
	        dict.put("X", 1);
	        dict.put("Y", 2);
	        dict.put("Z", 3);
	        dict.put("Z", 4);
	        Assert.assertTrue(dict.contains("Z"));
	    }
	    @Test
	    public void testPeekThrowsEmptyStackException(){
	        DynamicArrayStack<String> stack = new DynamicArrayStack<String>(10);
	        try{
	            stack.peek();
	            fail("Peek - empty stack should raise EmptyStackException(from java.util)");
	        } catch (EmptyStackException e){
	            grade += 0.75;
	        }
	    }

	    @Test
	    public void testPopThrowsEmptyStackException(){
	        DynamicArrayStack<String> stack = new DynamicArrayStack<String>(10);
	        try {
	            String element = stack.pop();
	            fail("Poping from an empty stack should raise EmptyStackException (from java.util)");
	        }catch (EmptyStackException e){
	            grade += 0.75;
	        }
	    }
	    @Test
	    public void testRandomException1() {
	        String exceptionName = Exercise1.catchException(1);
	        assertEquals("Throwing Exception", "Exception", exceptionName);
	        grade += 0.25;
	    }

	    @Test
	    public void testRandomException2() {
	        String exceptionName = Exercise1.catchException(2);
	        assertEquals("Throwing ArrayIndexOutOfBoundsException", "ArrayIndexOutOfBoundsException", exceptionName);
	        grade += 0.15;
	    }

	    @Test
	    public void testRandomException3() {
	        String exceptionName = Exercise1.catchException(3);
	        assertEquals("Throwing IOException", "IOException", exceptionName);
	        grade += 0.15;
	    }

	    @Test
	    public void testRandomException4() {
	        String exceptionName = Exercise1.catchException(4);
	        assertEquals("Throwing IllegalArgumentException", "IllegalArgumentException", exceptionName);
	        grade += 0.15;
	    }

	    @Test
	    public void testRandomException5() {
	        String exceptionName = Exercise1.catchException(5);
	        assertEquals("Throwing NullPointerException", "NullPointerException", exceptionName);
	        grade += 0.15;
	    }

	    @Test
	    public void testRandomExceptionNoException() {
	        String exceptionName = Exercise1.catchException(15);
	        assertEquals("NoException thrown", "NoException", exceptionName);
	        grade += 0.15;
	    }




}
