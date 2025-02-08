package com.reflectionapiassignment;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            
            Class<?> personClass = Person.class;

            
            System.out.println("Constructors:");
            Constructor<?>[] constructors = personClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            
            System.out.println("\nMethods:");
            Method[] methods = personClass.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

           
            System.out.println("\nFields:");
            Field[] fields = personClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

           
            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            Object personInstance = constructor.newInstance("John Doe", 30);

            
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true); 
            nameField.set(personInstance, "Alice Johnson");

            
            Method displayMethod = personClass.getMethod("displayInfo");
            displayMethod.invoke(personInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
