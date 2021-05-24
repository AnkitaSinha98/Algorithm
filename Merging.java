package Algorithm;
public class Merging {

	public static void merge(int[] arr1, int[] arr2, int[] arr3, int n1, int n2) 
	{
		int i = 0, j = 0, k = 0;
		while (i < n1 && j < n2) 
		{
			if (arr1[i] < arr2[j])
				arr3[k++] = arr1[i++];
			else
				arr3[k++] = arr2[j++];
		}
		while(i<n1)
		{
			arr3[k++]=arr1[i++];
		}
		
		while(j<n2)
		{
			arr3[k++]=arr2[j++];
		}
		
	}

	public static void main(String[] args) 
	{
		int[] arr1 = { 2, 8, 15, 18};
		int[] arr2 = { 5, 9, 12, 17, 19 };
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[] arr3 = new int[n1 + n2];

		merge(arr1, arr2, arr3, n1, n2);
		System.out.println("\nSorted list: ");

		for (int i = 0; i < n1 + n2; i++)
			System.out.println(arr3[i] + " ");
	}

}
