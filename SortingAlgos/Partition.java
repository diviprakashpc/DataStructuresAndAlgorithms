package SortingAlgos;

public class Partition {

	public static void main(String args[]) {
		int[] arr1 = { 7, 6, 4, 3, 9, 10, 11, 14, 2, 3, 5, 6, 8 };
		int[] arr2 = { 7, 6, 4, 3, 8, 9, 10, 11, 14, 2, 7, 3, 5, 6, 9 };
		partition_with_windowmethod(arr1, arr1[arr1.length - 1], 0, arr1.length - 1);
		// Works if you take pivot as last element and pivot duplicacy is not present.
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		partition_with_countmethod(arr2, arr2[0], 0, arr2.length - 1);
		// works if you take pivot as first element and pivot duplcacy is not present.
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();

	}

	public static void partition_with_windowmethod(int[] arr, int pivot, int start, int end) {
		int i = start;
		int j = start;

		while (i <= end) {
			if (arr[i] > pivot) {
				i++;
			} else {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				j++;
			}
		}
	}

	// I prefer count method
	public static void partition_with_countmethod(int[] arr, int pivot, int start, int end) {

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
	}

	public static void hoarealgo(int[] arr, int pivot, int start, int end) {

		int i = start - 1;
		int j = end - 1;
		while (true) {
			do {
				i++;
			} while (arr[i] < pivot);

			do {
				j--;
			} while (arr[j] > pivot);
			if (i >= j)
				return;
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

	}

}
