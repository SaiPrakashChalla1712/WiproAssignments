package com.functionalinterfacesassignment;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesExample {

    public static void main(String[] args) {
        Person person = new Person("sai", 25);

        
        Predicate<Person> isAdult = p -> p.getAge() >= 18;
        System.out.println("Is Adult: " + isAdult.test(person));

        
        Function<Person, Integer> ageIn5Years = p -> p.getAge() + 5;
        System.out.println("Age in 5 years: " + ageIn5Years.apply(person));

       
        Consumer<Person> updateName = p -> p.setName("Sai");
        updateName.accept(person);
        System.out.println("Updated Person: " + person);

       
        Supplier<Person> defaultPersonSupplier = () -> new Person("Sai", 0);
        Person defaultPerson = defaultPersonSupplier.get();
        System.out.println("Default Person: " + defaultPerson);
    }
}
