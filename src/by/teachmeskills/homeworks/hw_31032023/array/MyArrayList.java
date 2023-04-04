package by.teachmeskills.homeworks.hw_31032023.array;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private Object[] elements;
    private int size;
    private final int DEFAULT_CAPACITY = 5;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        }
        elements = new Object[capacity];
    }

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T element) {
        changeSize();
        elements[size] = element;
        size++;
    }

    private void changeSize() {
        if (elements.length == size) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    public void add(int index, T element) {
        Objects.checkIndex(index, size + 1);
        changeSize();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public void delete(int index) {
        if (index >= size) {
            System.out.println("Index is bigger than size");
        }
        if (index < 0) {
            System.out.println("Index is less than 0");
        }
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void displayAll() {
        for (Object elem : elements) {
            System.out.print(elem + " ");
        }
    }

    public void display(int index) {
        for (int i = index; i < size; i++) {
            System.out.print(elements[i]);
            break;
        }
    }

    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }

    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        elements[index] = element;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}