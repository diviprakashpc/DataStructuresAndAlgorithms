package SortingAlgos;

class MergeSort {
	public static void main(String[] args) {

		int[] arr = { 2, 3, 4, 5, 1, 6 };
		mergeSort(arr);

	}

	public static void mergeSort(int[] arr) {
		if (arr.length <= 1)
			return;
		int[] b = new int[arr.length / 2];
		int[] c = new int[arr.length - b.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = arr[i];
		}

		for (int i = 0; i < c.length; i++) {
			c[i] = arr[b.length + i];
		}

		mergeSort(b);
		mergeSort(c);
		merge(b, c, arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}
		System.out.println();
	}

	public static void merge(int[] arr1, int[] arr2, int[] dest) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length || j < arr2.length) {
			int x = (i < arr1.length) ? arr1[i] : Integer.MAX_VALUE;
			int y = (j < arr2.length) ? arr2[j] : Integer.MAX_VALUE;

			if (x < y) {
				dest[k++] = x;
				i++;
			} else {
				dest[k++] = y;
				j++;
			}
		}

	}
}