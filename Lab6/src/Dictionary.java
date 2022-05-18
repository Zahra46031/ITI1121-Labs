public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count = 0;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
    	  elems =  new Pair[INITIAL_CAPACITY];
    }

    @Override
    public void put(String key, Integer value) {
    	if(count >= this.getCapacity()) {
    		this.increaseCapacity();
    	}
    	elems[count++] = new Pair(key, value);
        /* Your code here */
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
    	Pair[] temp = new Pair[this.getCapacity() + INCREMENT];
    	for(int i = 0; i<count; i++) {
    		temp[i] = elems[i];
    	}
    	elems = temp;
    }

    @Override
    public boolean contains(String key) {
		for(int i = 0; i<count; i++) {
			if(elems[i].getKey().equals(key))
				return true;
		}
		return false;
        /* Your code here. */
    }

    @Override
    public Integer get(String key) {
    	Integer a = 0;
    	for(int i = 0; i<count; i++) {
    		if(elems[i].getKey().equals(key))
    			a =  elems[i].getValue();
    	}
		return a;
	
        /* Your code here. */
    }

    @Override
    public void replace(String key, Integer value) {
        for(int i = 0; i<count; i++) {
        	if(elems[i].getKey().equals(key)) {
        		elems[i] = new Pair(key, value);
        	}
        		
        }
    }

    @Override
    public Integer remove(String key) {
    	int a = 0;
    	int b = 0;
        if(contains(key)) {
        	a = get(key);
        	count--;
        	for(int i = 0; i<count; i++) {
        		if(elems[i].getKey().equals(key)) {
        			b = i;
        		}
        	}
        	for(int j = b; j < count-1; j++) {
				elems[j] = elems[j+1];
			}
        	elems[elems.length-1] = null;
        }
        return a; 
        /* Your code here. */
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