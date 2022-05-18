public interface Map< K, V> {

	void put(String key, Integer value);

	boolean contains(String key);

	void replace(String key, Integer value);

	Integer get(String key);

	Integer remove(String key);

    /* Make the necessary abstract method definitions */

}