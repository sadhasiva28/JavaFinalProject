package Behaviuorpattrn.simplem;

import java.util.Arrays;

//Example  for strategy design pattern
//Context class that uses a strategy to sort an array of integers
class Sorter {
	private SortingStrategy strategy;

	public Sorter(SortingStrategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(SortingStrategy strategy) {
		this.strategy = strategy;
	}

	public void sort(int[] array) {
		strategy.sort(array);
	}
}

//Strategy interface for sorting algorithms
interface SortingStrategy {
	void sort(int[] array);
}

//Concrete implementation of the SortingStrategy interface that uses bubble sort to sort an array of integers
class BubbleSortStrategy implements SortingStrategy {
	public void sort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
}

//Concrete implementation of the SortingStrategy interface that uses selection sort to sort an array of integers
class SelectionSortStrategy implements SortingStrategy {
	public void sort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
}

//Example usage
public class SortApplication {
	public static void main(String[] args) {
		int[] array = { 5, 3, 8, 4, 2 };

		SortingStrategy strategy1 = new BubbleSortStrategy();
		SortingStrategy strategy2 = new SelectionSortStrategy();

		Sorter sorter = new Sorter(strategy1);
		sorter.sort(array);
		System.out.println(Arrays.toString(array));

		sorter.setStrategy(strategy2);
		sorter.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
