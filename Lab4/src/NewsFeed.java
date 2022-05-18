/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	this.messages = new Post[MAX_SIZE];
    	this.size = 0;
    	// Your code here.
    }

    public void add(Post message) {
    	if(this.size == 25) {
    		return;
    	}
    	this.messages[size] = message;
    	size++;
    	// Your code here.
    }

    public Post get(int index) {
	     return messages[index];
    }

    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){
  		NewsFeed n = new NewsFeed();

  		for(int i = 0; i<this.size; i++) {
  			if(this.messages[i].getClass() == PhotoPost.class) {
  				n.add(messages[i]);
  			}
  		}
		return n;
  	}

  	public NewsFeed plus(NewsFeed other){
  		NewsFeed n = new NewsFeed();
  		for(int j = 0; j<this.size; j++) {
  				n.add(this.messages[j]);
  			}
  			
  		for(int i = 0; i<other.size; i++) {
  			n.add(other.messages[i]);		
  		}
  	
  		n.sort();
		return n;
}
  	  // Your code here
  	

}
