package main;

public interface map<K,V> {

	public void put(K newKey, V data);
	
	public V get(K key);
	
	public boolean remove(K deleteKey);
	
	public void display();
	
}
