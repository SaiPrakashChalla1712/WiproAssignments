package com.strategyassignment;

class SortingContext {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSorting(int[] numbers) {
        if (strategy == null) {
            throw new IllegalStateException("Sorting strategy is not set.");
        }
        strategy.sort(numbers);
    }
}
