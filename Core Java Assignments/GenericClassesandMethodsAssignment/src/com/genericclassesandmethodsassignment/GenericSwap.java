package com.genericclassesandmethodsassignment;



import java.util.Arrays;

public class GenericSwap {
    
    public static <T> void swap(T[] array, int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array.length) {
            throw new IndexOutOfBoundsException("Invalid index for swapping.");
        }
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before Swap (Integer): " + Arrays.toString(intArray));
        swap(intArray, 1, 3);
        System.out.println("After Swap (Integer): " + Arrays.toString(intArray));

      
        String[] strArray = {"Sai", "Naveen", "Sandeep", "Teja"};
        System.out.println("\nBefore Swap (String): " + Arrays.toString(strArray));
        swap(strArray, 0, 2);
        System.out.println("After Swap (String): " + Arrays.toString(strArray));
        
        Person[] persons = {
                new Person("Sai", 25),
                new Person("Naveen", 30),
                new Person("Sandeep", 22)
            };

            System.out.println("\nBefore Swap: " + Arrays.toString(persons));
            swap(persons, 0, 2);
            System.out.println("After Swap: " + Arrays.toString(persons));

        
    }
}

