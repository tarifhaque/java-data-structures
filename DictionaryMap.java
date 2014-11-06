/****************************************************
 * Written by Tarif Haque on 23 February 2013
 * CS 360 Data Structures & Algorithms
 * Project 4
 * 
 * A DictionaryMap maps a String (the key) to a value 
 * of any type. This Dictionary is implemented using
 * a Hash Table that uses Separate Chaining. 
 ****************************************************/

import java.util.*;

public class DictionaryMap<Type> {
	
	/* Each entry in the DictionaryMap contains a 
	 * String key and a value to store.  
	 * */
	private class Entry {
		String key;
		Type value;
		Entry(String keyString, Type val) {
			key = keyString;
			value = val;
		}
	}
	
	private int tableSize;
	LinkedList<Entry>[] theLists;
	
	/* Construct a new DictionaryMap. For best performance, the 
	 * size should be prime. 
	 * */
	public DictionaryMap(int size) {
		tableSize = size;
		theLists = new LinkedList[tableSize];
		for (int i = 0; i < tableSize; i++)
			theLists[i] = new LinkedList<Entry>(); // Create an array of Lists 
	}

	/* Given a unique key, return the associated value. */
	public Type find(String keyString) {
		int index = hash(keyString); // hash the key
		// search chain for entry with given key
		LinkedList<Entry> chain = theLists[index];
		for (int i = 0; i < chain.size(); i ++) {
			if (chain.get(i).key.equals(keyString)) 
				return chain.get(i).value;
		}
		return null; // if key is not found, return null.
	}
	
	/* Insert a key that will be mapped to a value. */
	public void insert(String keyString, Type value) {
		Entry entry = new Entry(keyString, value);
		int index = hash(keyString); // get the index of the bucket 
		theLists[index].add(entry); // insert entry @ the end of the chain
	}

	/* A good hash function for Strings. */
	private int hash(String key) {
		 int hashVal = 0;
		 for(int i = 0; i < key.length( ); i++)
	    	 hashVal = 37 * hashVal + key.charAt( i );
		 hashVal %= tableSize;
		 if(hashVal < 0)
			 hashVal += tableSize;
		 return hashVal;
	}
}