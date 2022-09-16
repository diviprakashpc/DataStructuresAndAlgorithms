package SortingAlgos;

public class QuickSort {

	 public static void main(String[] args) {
		 int[] arr = {1,5,6,2,1,3};
		 quickSort(arr,0,arr.length-1);
		 for(int i = 0 ; i < arr.length ; i++) {
			 System.out.print(arr[i]+" ");
		 }
		 System.out.println();
	 }
	
	public static void quickSort(int[] arr , int si , int ei ) {
		 if(si>=ei){
	            return;
	        }
	        
	        int partitionIndex=partition(arr,si,ei);
	        
	        quickSort(arr,si,partitionIndex-1);
	        quickSort(arr,partitionIndex+1,ei);
	}
	
	public static int partition(int[] arr, int start, int end) {
         int pivot = arr[start];
		int smallNumberCount = 0;
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < pivot)
				smallNumberCount++;
		}

		int temp = arr[start + smallNumberCount];
		arr[start + smallNumberCount] = arr[start];
		arr[start] = temp;
		int i = start;
		int j = end;
		while (i < j) {
			if (arr[i] < pivot)
				i++;
			else if (arr[j] > pivot)
				j--;
			else {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				j--;

			}
		}
		return start + smallNumberCount;
	}
}
