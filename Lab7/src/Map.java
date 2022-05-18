public interface Map< K, V> {

	boolean contains(String key);

	Integer get(String key);

	void replace(String key, Integer value);

	Integer remove(String key);

	void put(String key, Integer value);

    /* Make the necessary abstract method definitions */

}