package com.practice.algo6006;

public class PeakIn1Dand2DArray {
    
    private static int ROW=5;
    private static int COL=4;

    public static void main(String[] args) {

	int peakArr[] = {6,5,4,3,2,1};//{1,2,3,4,5,6};//{ 1, 2, 2, 4, 5, 7 };
	
	int peak2DArr[][]= {{16, 3, 8, 3},
		            {2, 4, 9, 15},
		            {4, 2, 7, 16},
		            {9, 1, 2, 17},
		            {5, 6, 20, 18}};

	int middle = (peakArr.length - 1 )/ 2;
	int peakItem = findPeak(peakArr, middle);
	//System.out.println("Peak element is present at " +  peakItem + " and value is " + peakArr[peakItem]);
	
	int middle2D = COL/2;
	int peakItem2D = find2DPeak(peak2DArr, 0, middle2D);
	System.out.println("Peak element is :" + peakItem2D);
	
    }
    
    public static int find2DPeak(int arr[][], int i, int middle) {
	
	// find global max
	// cond 1 where i,m/2 is peak
	// cond 2 where i,m/2 < i, m/2-1
	// cond 3 where i,m/2 < i, m/2 + 1
	
	int globalMaxRow = findGlobalMax(arr, middle);
	
	if(middle+1 > COL-1 || middle-1 < 0)
	    return arr[globalMaxRow][middle];
	
	if(arr[globalMaxRow][middle] >= arr[globalMaxRow][middle-1] && arr[globalMaxRow][middle] >= arr[globalMaxRow][middle+1])
	    return arr[globalMaxRow][middle];
	else if(arr[globalMaxRow][middle] < arr[globalMaxRow][middle-1]) 
	    return find2DPeak(arr, globalMaxRow, middle-1);
	else
	    return find2DPeak(arr, globalMaxRow, middle+1);
	
    }

    private static int findGlobalMax(int[][] arr, int middle) {

	int j = middle;
	int rowOfglobalMax=ROW-1;
	int globalMax = arr[ROW-1][j];

	for (int i = ROW - 1; i > 0; i--) {

	    if (arr[i][j] > globalMax)
		rowOfglobalMax = i;

	}
	System.out.println("Global Max is: " + arr[rowOfglobalMax][j] + " ROW and COL is " + rowOfglobalMax + " " + j );
	return rowOfglobalMax;

    }

    public static int findPeak(int arr[], int middle) {

	if (middle - 1 < 0 || middle + 1 >= arr.length)
	    return middle;
	
	if(arr[middle] >= arr[middle - 1] && arr[middle] >= arr[middle + 1])
	    return middle;

	else if (arr[middle] <= arr[middle - 1])
	    middle = findPeak(arr, middle - 1);
	else// (arr[middle] <= arr[middle + 1])
	    middle = findPeak(arr, middle + 1);

	return middle;

    }

}
