package com.strategyassignment;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        SortingContext context = new SortingContext();

        int[] numbers1 = {64, 34, 25, 12, 22, 11, 90};
        context.setStrategy(new BubbleSort());
        context.executeSorting(numbers1);

        int[] numbers2 = {64, 34, 25, 12, 22, 11, 90};
        context.setStrategy(new QuickSort());
        context.executeSorting(numbers2);
    }
}
