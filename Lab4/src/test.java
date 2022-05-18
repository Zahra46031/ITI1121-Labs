import static org.junit.Assert.*;

import org.junit.Test;

public class test {
	int grade = 0;
	 @Test
	    public void testConstructorInitUserName() {
	      TextPost myPost = new TextPost("username", "hello world");
	      assertEquals("Username not initialized in TextPost constructor","username", myPost.getUserName());

	      grade += 0.25;

	    }

	    @Test
	    public void testConstructorInitMessage() {
	      TextPost myPost = new TextPost("username", "hello world");
	      assertEquals("Message not initialized in TextPost constructor", "hello world", myPost.getMessage());

	      grade += 0.25;
	    }


	    @Test
	    public void testNotPopularTextPost() {
	      TextPost myPost = new TextPost("username", "hello world");
	      assertFalse("New TextPost without any likes should not be popular", myPost.isPopular());
	      for (int i = 0; i < 49; i++) {
	        myPost.like();
	      }
	      assertFalse("A TextPost with less than 50 likes should not be popular", myPost.isPopular());

	      grade += 0.5;
	    }

	    @Test
	    public void testPopularTextPost() {
	      TextPost myPost = new TextPost("username", "hello world");
	      for (int i = 0; i < 51; i++) {
	        myPost.like();
	      }
	      assertTrue("A TextPost with more than 50 likes should be popular", myPost.isPopular());
	      myPost.like();
	      assertTrue("A TextPost with more than 50 likes should be popular", myPost.isPopular());

	      grade += 0.5;
	    }
	    @Test
	    public void testConstructorInitUsername() {
	      Post myPost = new Post("username");
	      assertEquals("Username not initialized in Post constructor", "username", myPost.getUserName());

	      grade += 0.25;
	    }

	    @Test
	    public void testConstructorInitLikes() {
	      Post myPost = new Post("username");
	      assertEquals("Number of likes not initialized in Post constructor", 0, myPost.getLikes());

	      grade += 0.25;
	    }



	    @Test
	    public void testLikes() {
	      Post myPost = new Post("username");
	      for (int i = 0; i < 10; i++) {
	        myPost.like();
	      }
	      assertEquals("Post - incorrect number of likes", 10, myPost.getLikes());

	      grade += 0.5;
	    }

	    @Test
	    public void testCompareSamePost() {
	      Post myPost = new Post("username");
	      assertEquals("Equality between the same post fails to return 0", 0, myPost.compareTo(myPost));

	      grade += 0.5;
	    }

	    @Test
	    public void testCompareDifferentPost() {
	      Post myPost = new Post("username");
	      try {
	          Thread.sleep(1);
	      } catch (InterruptedException e) {
	          ;
	      }
	      Post yourPost = new Post("username2");
	      assertTrue("Earlier posted post comparted to a later one should return a negative value", myPost.compareTo(yourPost) < 0);
	      assertTrue(yourPost.compareTo(myPost) > 0);

	      grade += 0.5;
	    }
	    @Test
	    public void testConstructorInitUsername1() {
	      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
	      assertEquals("username not initialized in PhotoPost constructor", "username", myPost.getUserName());

	      grade += 0.1;
	    }

	    @Test
	    public void testConstructorInitCaption() {
	      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
	      assertEquals("caption not initialized in PhotoPost constructor", "hello world", myPost.getCaption());

	      grade += 0.2;
	    }

	    @Test
	    public void testConstructorInitFileName() {
	      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
	      assertEquals("fileName not initialized in PhotoPost constructor", "hello.jpg", myPost.getFileName());

	      grade += 0.2;
	    }

	    @Test
	    public void testNewNotPopularPhotoPost() {
	      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
	      assertFalse("A new PhotoPost without likes should not be popular", myPost.isPopular());

	      grade += 0.25;
	    }

	    @Test
	    public void testNotPopularPhotoPost() {
	      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
	      for (int i = 0; i < 99; i++) {
	        myPost.like();
	      }
	      assertFalse("A PhotoPost with less than 100 likes should not be popular", myPost.isPopular());

	      grade += 0.25;
	    }


	    @Test
	    public void testPopularPhotoPost() {
	      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
	      for (int i = 0; i < 101; i++) {
	        myPost.like();
	      }
	      assertTrue("A PhotoPost with more than 100 likes should be popular", myPost.isPopular());
	      myPost.like();
	      assertTrue("A PhotoPost with more than 100 likes should be popular", myPost.isPopular());

	      grade += 0.5;
	    }
	    @Test
	    public void TestAddFirstPost() {
	      NewsFeed feed = new NewsFeed();
	      Post myPost = new Post("Hi");
	      feed.add(myPost);
	      assertEquals("NewsFeed's first post does not update the size", 1, feed.size());
	      assertEquals("The first post in NewsFeed is incorrect", myPost, feed.get(0));

	      grade += 0.5;
	    }

	    @Test
	    public void TestAdd25Posts() {
	      NewsFeed feed = new NewsFeed();
	      Post myPost = new Post("Hi");
	      for (int i = 0; i < 25; i++) {
	        feed.add(myPost);
	      }
	      assertEquals("Adding 25 posts to NewsFeed", 25, feed.size());

	      grade += 0.5;
	    }

	    @Test
	    public void TestAddMoreThan25Posts() {
	      NewsFeed feed = new NewsFeed();
	      Post myPost = new Post("Hi");
	      try{
	        for (int i = 0; i < 26; i++) {
	          feed.add(myPost);
	        }
	        assertEquals("Maximum number of posts exceeded. Add should not add more than MAX_SIZE(25) posts", 25, feed.size());
	        grade += 0.5;
	      } catch (ArrayIndexOutOfBoundsException e){
	        fail("Method add should not attempt to add more than MAX_SIZE(25) posts");
	      }

	    }

	    /*********************** getPhotoPost tests ********************/

	    @Test
	    public void TestGetPhotoPostEmpty() {
	      NewsFeed feed = new NewsFeed();
	      NewsFeed feed2 = feed.getPhotoPost();
	      assertEquals("Empty NewsFeed - GetPhotoPost does not return a 0-size NewsFeed", 0, feed2.size());

	      grade += 0.5;
	    }

	    @Test
	    public void TestGetPhotoPostBlank() {
	      NewsFeed feed = new NewsFeed();
	      Post myPost = new Post("Hi");
	      for (int i = 0; i < 25; i++) {
	        feed.add(myPost);
	      }
	      NewsFeed feed2 = feed.getPhotoPost();
	      assertEquals("Non-empty NewsFeed with no PhotoPosts - GetPhotoPost does not return a 0-size NewsFeed", 0, feed2.size());

	      grade += 0.5;
	    }

	    @Test
	    public void TestGetPhotoPostSome() {
	      NewsFeed feed = new NewsFeed();
	      Post myPost = new Post("Hi");
	      Post myPhotoPost = new PhotoPost("Hi", "hi.png", "Hi");
	      feed.add(myPhotoPost);
	      for (int i = 0; i < 10; i++) {
	        feed.add(myPost);
	      }

	      feed.add(myPhotoPost);
	      feed.add(myPost);
	      feed.add(myPhotoPost);
	      NewsFeed feed2 = feed.getPhotoPost();
	      assertEquals("GetPhotoPost - wrong returned size for multiple PhotoPosts", 3, feed2.size());

	      grade += 0.5;
	    }

	    /*********************** plus tests *************************/

	    @Test
	    public void TestAddEmptyFeedToEmptyFeed() {
	      NewsFeed feed = new NewsFeed();
	      NewsFeed feed2 = new NewsFeed();
	      NewsFeed feed3 = feed.plus(feed2);
	      assertEquals("Plus - two empty feeds should return a 0-size NewsFeed", 0, feed3.size());

	      grade += 0.5;
	    }

	    @Test
	    public void TestAddSingletonFeedToSelf() {
	      NewsFeed feed = new NewsFeed();
	      Post myPost = new Post("Hi");
	      feed.add(myPost);
	      NewsFeed feed2 = feed.plus(feed);
	      assertEquals("Singleton NewsFeed plus itself should return a 2-size NewsFeed", 2, feed2.size());

	      grade += 0.5;
	    }

	    @Test
	    public void TestAddFeedSorted() {
	      NewsFeed feed = new NewsFeed();
	      Post myPostSorted = new Post("Sorted");
	      NewsFeed feed2 = new NewsFeed();
	      Post myPostUnsorted = new Post ("Unsorted");
	      feed.add(myPostSorted);
	      feed2.add(myPostUnsorted);
	      NewsFeed feed3 = feed2.plus(feed);
	      assertEquals("plus should return a sorted merged NewsFeed", myPostSorted, feed.get(0));

	      grade += 0.5;
	    }

	    @Test
	    public void TestAddFeedAtCapacity() {
	      NewsFeed feed = new NewsFeed();
	      Post myPost = new Post("Hi");
	      for (int i = 0; i < 10; i++) {
	        feed.add(myPost);
	      }
	      NewsFeed feed2 = new NewsFeed();
	      Post myPost2 = new Post("Ha");
	      for (int i = 0; i < 15; i++) {
	        feed2.add(myPost2);
	      }
	      NewsFeed feed3 = feed.plus(feed2);
	      assertEquals("Adding the maximum number of posts in a feed", 25, feed3.size());

	      grade += 0.5;
	    }

}
