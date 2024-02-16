package SortingAlgos;

import java.util.Arrays;

//T.C (nlogn)
//S.C (n)
public class mergeSortWithIndexes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,7,2,3,9,10,12,6,8,3,3};
		mergeSort(arr,0,arr.length-1);  // Notice r is initialized with alen-1 here.
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int l , int r) {
		if(r-l+1<=1) return;
		
		int mid = l + (r-l)/2;
		
		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,r);
		merge(arr,l,mid,r);
	}
	
	public static void merge(int[] arr , int l , int m , int r) {
		int[] arr1 = new int[m-l+1];
		int[] arr2 = new int[r-m];
		for(int i = l ; i<=m ; i++) {
			arr1[i-l] = arr[i];
		}
		for(int i = m+1 ; i<=r ; i++) {
			arr2[i-(m+1)] = arr[i];
		}
		int i = 0;
		int j = 0;
		int k = l;
		while (i < arr1.length || j < arr2.length) {
			int x = (i < arr1.length) ? arr1[i] : Integer.MAX_VALUE;
			int y = (j < arr2.length) ? arr2[j] : Integer.MAX_VALUE;

			if (x < y) {
				arr[k++] = x;
				i++;
			} else {
				arr[k++] = y;
				j++;
			}
		}
	}

}
