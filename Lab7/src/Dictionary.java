import java.util.Arrays;
import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private static class Pair {

        private final String key;
        private Integer value;

        private Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

    }

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if(key == null || value == null) {
        	throw new NullPointerException();
        }

        if (count == elems.length) {
            increaseCapacity();
        }

        elems[count++] = new Pair(key, value);
     
    }

    private void increaseCapacity() {
    	Pair[] temp = new Pair[elems.length + INCREMENT];
    	for(int i = 0; i<count; i++) {
    		temp[i] = elems[i];
    	}
    	elems = temp;
    }

    @Override
    public boolean contains(String key) {
        if(key == null) {
        	throw new NullPointerException();
        }

        for(int i = 0; i<count; i++) {
			if(elems[i].key.equals(key))
				return true;
		}
		return false;
    }

    @Override
    public Integer get(String key) {
        if(key == null) {
        	throw new NullPointerException();
        }

        boolean flag = false;
        int inx = count - 1;

        while (inx >= 0 && !flag) {
            if (elems[inx].key.equals(key)) {
                flag = true;
            } 
            else {
                inx--;
            }
        }

        if(!flag || inx < 0) {
        	throw new NoSuchElementException();
        }

        return elems[inx].value;
    }

    @Override
    public void replace(String key, Integer value) {

        if(key == null || value == null) {
        	throw new NullPointerException();
        }

        boolean flag = false;
        int inx = count - 1;

        while (inx >= 0 && !flag) {
            if (elems[inx].key.equals(key)) {
                flag = true;
            } 
            else {
                inx--;
            }
        }

        if(!flag || inx < 0) {
        	throw new NoSuchElementException();
        }

        elems[inx].value = value;
    }

    @Override
    public Integer remove(String key) {
        if(key == null) {
        	throw new NullPointerException();
        }

        boolean flag = false;
        int inx = count - 1;

        while (inx >= 0 && !flag) {
            if (elems[inx].key.equals(key)) {
                flag = true;
            } 
            else {
                inx--;
            }
        }

        if(!flag || inx < 0) {
        	throw new NoSuchElementException();
        }

        Integer hold = elems[inx].value;

        while (inx < count - 1) {
            elems[inx] = elems[inx + 1];
            inx++;
        }
        count--;
        elems[count] = null; 
        return hold;
    }
    
    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

    
}