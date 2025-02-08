package com.genericsandtypesafetyassignment;

public class Pair<T, U> {
	private T obj1;
	private U obj2;

	public Pair(T obj1, U obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public Pair<U, T> reverse() {
		return new Pair<>(obj2, obj1);
	}

	@Override
	public String toString() {
		return "[" + obj1 + ", " + obj2 + "]";
	}

	public static void main(String[] args) {
		Pair<Integer, String> pair = new Pair<>(23546, "Sai Prakash Reddy Challa");
		System.out.println("Original Pair: " + pair);

		Pair<String, Integer> reversedPair = pair.reverse();
		System.out.println("Reversed Pair: " + reversedPair);
	}
}
