package com.practice.algo6006;

public class HeapSort {

    private void maxHeapify(int arr[], int start, int size) {
	int largest = start;
	int left = 2 * start + 1;
	int right = 2 * start + 2;
	if (left < size && arr[left] > arr[largest]) {
	    largest = left;
	}

	if (right < size && arr[right] > arr[largest]) {
	    largest = right;
	}
	if (largest != start) {

	    
	    int temp = arr[start];
	    arr[start] = arr[largest];
	    arr[largest] = temp;
	    
	    maxHeapify(arr, largest, size);
	}

    }

    private void createMaxHeap(int arr[], int size) {

	for (int i = (size-1) / 2; i >= 0; i--)
	    maxHeapify(arr, i, size);

	System.out.println("Heapified Array");
	for (int i : arr) {
	    System.out.print(i + " ");
	}

    }

    private void sort(int arr[], int size) {

	size = size-1;
	createMaxHeap(arr, size);
	System.out.println("------");
	while (size >= 0) {
	    int largest = arr[0];
	    int temp;
	    //System.out.print(largest + " ");
	    int last = arr[size];
	    temp = largest;
	    largest = last;
	    last = temp;
	    arr[0]=largest;
	    arr[size]=last;
	    size--;
	    maxHeapify(arr, 0, size);
	}

	for (int i : arr) {
	    System.out.print(i + " ");
	}
    }

    public static void main(String[] args) {

	int arr[] = { 11, 2, 22, 100, 8, 0, 7 };

	HeapSort heapSort = new HeapSort();
	heapSort.sort(arr, arr.length);
    }

}
