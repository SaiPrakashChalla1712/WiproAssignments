package com.lambdaexpressionsassignment;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpression {
	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Sai Prakash", 30));
		persons.add(new Person("Naveen", 25));
		persons.add(new Person("Sandeep", 35));
		persons.add(new Person("Teja", 28));


		persons.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

		System.out.println("Sorted by age:");
		for (Person person : persons) {
			System.out.println(person);
		}
	}

}
