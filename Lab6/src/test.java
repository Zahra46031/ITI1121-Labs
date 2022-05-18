import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	int grade = 0;
	 @Test
	    public void testClearEmptyStack() {
	      ArrayStack<Integer> myStack = new ArrayStack<Integer>(5);
	      assertTrue("Uninitialized Stack should be empty", myStack.isEmpty());
	      myStack.clear();
	      assertTrue("A cleared stack should be empty", myStack.isEmpty());

	      grade += 0.5;
	    }

	    @Test
	    public void testClearPopulatedStack() {
	      ArrayStack<Integer> myStack = new ArrayStack<Integer>(5);
	      myStack.push(1);
	      myStack.push(2);
	      myStack.push(3);
	      assertFalse("Non empty array should not be empty", myStack.isEmpty());
	      myStack.clear();
	      assertTrue("Stack should be empty after a clear call", myStack.isEmpty());

	      grade += 0.5;
	    }
	    @Test
	    public void testConstructorAgesCount() {
	      Dictionary ages = new Dictionary();

	      assertEquals("The counter variable is not being initialized with 0", 0, ages.getCount());

	      grade += 0.25;
	    }

	    @Test
	    public void testConstructorCapacity() {
	      Dictionary ages = new Dictionary();

	      assertEquals("The default capacity should be 10", 10, ages.getCapacity());

	      grade += 0.25;
	    }


	    @Test
	    public void testConstructorImplementsMap() {
	      Dictionary ages = new Dictionary();

	      assertTrue("Dictionary should implement the interface Map", ages instanceof Map);

	      grade += 0.5;
	    }

	    @Test
	    public void testGetLeftmost() {
	      Dictionary ages = new Dictionary();
	      ages.put("Marc", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);

	      assertEquals("Get should return the last pair added for a given key", 15, (int) ages.get("Marc"));

	      grade += 0.5;
	    }

	    @Test
	    public void testGetSingular() {
	      Dictionary ages = new Dictionary();
	      ages.put("Marc", 25);
	      ages.put("John", 20);
	      ages.put("Betty", 15);

	      assertEquals("Get by key", 25, (int) ages.get("Marc"));

	      grade += 0.5;
	    }

	    @Test
	    public void testContainsTrue() {
	      Dictionary ages = new Dictionary();
	      ages.put("Marc", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);

	      assertTrue("contains returning true when a key is found", ages.contains("Marc"));

	      grade += 0.5;
	    }

	    @Test
	    public void testContainsFalse() {
	      Dictionary ages = new Dictionary();
	      ages.put("Marc", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);

	      assertFalse("contains returning false when no key is found", ages.contains("Takashi"));

	      grade += 0.5;
	    }

	    @Test
	    public void testPutOverCapacityOnce() {
	      Dictionary ages = new Dictionary();
	      ages.put("Marc", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);
	      ages.put("Jack", 11);
	      ages.put("Betty", 18);
	      ages.put("Takashi", 30);
	      ages.put("Reileen", 25);
	      ages.put("Mike", 22);
	      ages.put("Edward", 40);
	      ages.put("Samantha", 28);
	      ages.put("Gackt", 500);
	      ages.put("Zeus", 9999);

	      assertEquals("Adding more than 10 pairs should lead to a capacity increase of 5", 15, ages.getCapacity());

	      grade += 0.5;
	    }

	    @Test
	    public void testPutOverCapacityTwice() {
	      Dictionary ages = new Dictionary();
	      
	      for(int i = 0; i < 17; i++){
	        ages.put("Marc" + i, i + 18);
	      }
	      assertEquals("Increasing capacity twice should lead to a new capacity of 20", 20, ages.getCapacity());

	      grade += 0.5;
	    }

	    @Test
	    public void testReplaceExistOnceCount() {
	      Dictionary ages = new Dictionary();
	      ages.put("Mary", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);

	      ages.replace("Mary", 28);

	      assertEquals("When replacing, the value of counter should not change", 3, ages.getCount());

	      grade += 0.25;
	    }

	    @Test
	    public void testReplaceExistOnceValue() {
	      Dictionary ages = new Dictionary();
	      ages.put("Mary", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);

	      ages.replace("Mary", 28);

	      assertEquals("Replacing a pair should modify the value of the given key", 28, (int) ages.get("Mary"));

	      grade += 0.25;
	    }

	    @Test
	    public void testReplaceExistsTwiceCount() {
	      Dictionary ages = new Dictionary();
	      ages.put("Marc", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);

	      ages.replace("Marc", 16);

	      assertEquals("When replacing, the value of counter should not change", 3, ages.getCount());

	      grade += 0.25;
	    }

	    @Test
	    public void testReplaceExistsTwiceValue() {
	      Dictionary ages = new Dictionary();
	      ages.put("Marc", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);

	      ages.replace("Marc", 16);

	      assertEquals("Replace should only modify the last pair's value", 16, (int) ages.get("Marc"));

	      grade += 0.25;
	    }

	    @Test
	    public void testRemoveOnceReturns() {
	      Dictionary ages = new Dictionary();
	      ages.put("Mary", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);

	      int ret = ages.remove("Mary");

	      assertEquals("Remove should return the removed value for a given key", 25, ret);
	      grade += 0.25;
	    }

	    @Test
	    public void testRemoveOnceCountDecrease() {
	      Dictionary ages = new Dictionary();
	      ages.put("Mary", 25);
	      ages.put("John", 20);
	      ages.put("Marc", 15);

	      int ret = ages.remove("Mary");

	      assertEquals("Counter value should be decreased after removal", 2, ages.getCount());
	      grade += 0.25;
	    }

	    @Test
	    public void testRemoveOnceWhenMultipleEntriesCount() {
	      Dictionary ages = new Dictionary();
	      ages.put("Mary", 25);
	      ages.put("John", 20);
	      ages.put("Mary", 15);

	      int ret = ages.remove("Mary");

	      assertEquals("Counter value should be decreased after removal", 2, ages.getCount());
	      grade += 0.25;
	    }

	    @Test
	    public void testRemoveOnceWhenMultipleEntries() {
	      Dictionary ages = new Dictionary();
	      ages.put("Mary", 25);
	      ages.put("John", 20);
	      ages.put("Mary", 15);

	      int ret = ages.remove("Mary");

	      assertEquals("remove should only remove the last added pair", 15, ret);
	      grade += 0.25;
	    }

	    @Test
	    public void testPushDynamic24th() {
	      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
	      for (int i = 0; i < 24; i++) {
	        myStack.push(i);
	      }
	      assertEquals(23, (int) myStack.peek());
	      assertEquals(25, (int) myStack.getCapacity());

	      grade += 0.5;
	    }

	    @Test
	    public void testPushDynamic26th() {
	      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
	      for (int i = 0; i < 26; i++) {
	        myStack.push(i);
	      }
	      assertEquals(25, (int) myStack.peek());
	      assertEquals(50, (int) myStack.getCapacity());

	      grade += 0.5;
	    }

	    @Test
	    public void testPopDynamic1st() {
	      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(0);
	      assertEquals(25, (int) myStack.getCapacity());
	      myStack.push(999);
	      assertEquals(999, (int) myStack.pop());

	      grade += 0.5;
	    }

	    @Test
	    public void testPopDynamic26th25th() {
	      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
	      for (int i = 0; i < 26; i++) {
	        myStack.push(i);
	      }
	      myStack.pop();
	      myStack.pop();
	      assertEquals(25, (int) myStack.getCapacity());

	      grade += 0.5;
	    }

	    @Test
	    public void testClearDynamic5() {
	      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
	      for (int i = 0; i < 5; i++) {
	        myStack.push(i);
	      }
	      myStack.clear();
	      assertEquals(true, myStack.isEmpty());
	      assertEquals(25, (int) myStack.getCapacity());

	      grade += 0.5;
	    }

	    @Test
	    public void testClearDynamic100() {
	      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
	      for (int i = 0; i < 100; i++) {
	        myStack.push(i);
	      }
	      myStack.clear();
	      assertEquals(true, myStack.isEmpty());
	      assertEquals(25, (int) myStack.getCapacity());

	      grade += 0.5;
	    }


	


}



