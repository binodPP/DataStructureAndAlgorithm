package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem;

import com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.overriding.E;

public class CustomList<E> {
    private E[] elements;
    private int size = 0;

    // Constructor with initial capacity
    @SuppressWarnings("unchecked")
    public CustomList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elements = (E[]) new Object[initialCapacity];
    }

    // Adds an element to the list
    public boolean add(E e) {
        if (size == elements.length) {
            // Grow the array if needed
            grow();
        }
        elements[size++] = e;
        return true;
    }

    // Gets the element at the specified index
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    // Removes the element at the specified index
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = elements[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear to let GC do its work

        return oldValue;
    }

    // Gets the number of elements in the list
    public int size() {
        return size;
    }

    // Grows the underlying array
    @SuppressWarnings("unchecked")
    private void grow() {
        int newCapacity = elements.length * 2;
        E[] newArray = (E[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    public static void main(String[] args) {
        CustomList<String> customList = new CustomList<>(10);
        customList.add("Hello");
        customList.add("World");
        System.out.println(customList.get(0)); // Output: Hello
        System.out.println(customList.get(1)); // Output: World
        customList.remove(0);
        System.out.println(customList.get(0)); // Output: World
        System.out.println(customList.size()); // Output: 1
    }
}
