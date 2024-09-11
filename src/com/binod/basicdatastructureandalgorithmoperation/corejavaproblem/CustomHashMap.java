package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem;

import java.util.HashMap;

//https://chatgpt.com/c/56fb0ca7-a1dd-4d9d-bb4a-e0af21360b65
public class CustomHashMap<K,V> {
    private static final int INITIAL_CAPACITY=16;
    private static final float LOAD_FACTOR=0.75f;
    private Entry<K,V>[] bucket;
    private int size;
    private int threshold;

    public CustomHashMap() {
        this.bucket = new Entry[INITIAL_CAPACITY];
        this.threshold = (int)(INITIAL_CAPACITY * LOAD_FACTOR);
    }

    public void put(K key, V value){
        //not allowed to store null key in map
        if(key == null){
            return;
        }
        int hash = hash(key);
        int index= indexFor(hash, bucket.length);
        for(Entry<K,V> entry = bucket[index]; entry != null; entry= entry.next){
          if(entry.key.equals(key)){
              entry.value = value;
              return;
          }
        }
        addEntry(key,value,index);
    }

    public V get(K key){
        int hash = hash(key);
        int index= indexFor(hash, bucket.length);
        for(Entry<K,V> entry = bucket[index]; entry != null; entry= entry.next){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }

    public V remove(K key){
        int hash = hash(key);
        int index= indexFor(hash, bucket.length);
        Entry<K,V> previous= null;
        Entry<K,V> entry = bucket[index];

        while (entry != null){
            if(entry.key.equals(key)){
                if(previous == null){
                    bucket[index] = entry.next;
                }else {
                    previous.next = entry.next;
                }

                size--;
                return entry.value;
            }

            previous = entry;
            entry= entry.next;
        }
       return null;
    }

    //Why It Works
    //Power of Two Length: The hash table's length is usually a power of two (e.g., 16, 32, 64). This design choice simplifies the index calculation. For example, if the length is 16, then table.length - 1 is 15, which in binary is 1111.
    //Efficient Modulo Operation: The expression key.hashCode() & (table.length - 1) is equivalent to key.hashCode() % table.length but is more efficient because bitwise operations are faster than arithmetic operations like modulo. Using a power of two length allows us to use this optimization.
    //Example
    //Let's consider an example with a table length of 16:
    //
    //Suppose key.hashCode() returns 42. In binary, 42 is 101010.
    //table.length - 1 is 15, which is 1111 in binary.
    //Performing the bitwise AND operation: 101010 & 1111 results in 1010 (which is 10 in decimal).


    //Method 1: Division by 2 (Manual Method)
    //Divide the number by 2 and record the remainder.
    //Repeat the division on the quotient until the quotient is 0.
    //The binary representation is the sequence of remainders read from bottom to top.
    //Example: Converting 42 to Binary
    //42 ÷ 2 = 21 remainder 0
    //21 ÷ 2 = 10 remainder 1
    //10 ÷ 2 = 5 remainder 0
    //5 ÷ 2 = 2 remainder 1
    //2 ÷ 2 = 1 remainder 0
    //1 ÷ 2 = 0 remainder 1
    //Reading the remainders from bottom to top, we get: 101010

    private int hash(Object o){
        return o == null? 0: o.hashCode();
    }

    private int indexFor(int hash, int length){
        return hash % length-1;
    }

    private void addEntry(K key, V value, int index){
        Entry<K,V> entry= bucket[index];
        bucket[index] = new Entry<>(key,value);
        entry.next = bucket[index];
        if(size++ >= threshold){
            resize(2 * bucket.length);
        }
    }

    private void resize(int newCapacity){
        Entry<K,V>[] oldBucket = bucket;
        bucket = new Entry[newCapacity];
        size =0;
        threshold = (int)(newCapacity * LOAD_FACTOR);
        for(Entry<K,V> entry : oldBucket){
            while (entry != null){
                put(entry.key,entry.value);
                entry = entry.next;
            }
        }
    }

    public int size(){
        return size;
    }

    private static class Entry<K,V>{
      final K key;
      V value;
      Entry<K,V> next;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println(map.get("one")); // 1
        System.out.println(map.get("two")); // 2
        System.out.println(map.get("three")); // 3

        map.remove("two");
        System.out.println(map.get("two")); // null

        System.out.println("Size: " + map.size()); // 2
    }

    //Method 1: Manual Conversion Algorithm
    //To manually convert a binary number to decimal:
    //
    //Start from the rightmost bit (least significant bit).
    //Multiply each bit by 2 raised to the power of its position (starting from 0).
    //Sum all the results to get the decimal value.
    //Example: Converting Binary "101010" to Decimal
    //markdown
    //Copy code
    //Binary:   1  0  1  0  1  0
    //Positions:5  4  3  2  1  0
    //
    //Decimal: (1*2^5) + (0*2^4) + (1*2^3) + (0*2^2) + (1*2^1) + (0*2^0)
    //        = 32 + 0 + 8 + 0 + 2 + 0
    //        = 42
}
