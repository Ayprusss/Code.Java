public interface Map<K, V> {

    public abstract V get(K key); // returns rightmost value associated to key specified in parameter.

    public abstract boolean contains(K key); //returns true if there is assocation for key specified in parameter.

    public abstract void put(K key, V value); // creates new key-value assocation.

    public abstract void replace(K key, V value); //replaces value of rightmost occurence of assocation for specified key.

    public abstract V remove (K key); //removes rightmost occurence of specified key; returns value associated to keey.
}
