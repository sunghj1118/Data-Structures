/*
 * Name: Hyun Joon Sung
 * Student ID #: 2019147593
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class Sorter implements ISorter {
	public Sorter() { ; }

	@Override
	public int[] ascending(int[] a) {
		/*
		 * Input:
		 *  - an integer array A
		 *
		 *	1. sort the array by comparing every pair.
		 	2. repeat until no more swaps required.
		 	3. in order to do 2. 
		 * Output: a sorted array A in *ascending* order.
		 */
		int n = a.length;
		//loop 1 checks that the order is correct.
		for (int y = 0; y < n; y++){
			//loop 2 compares and swaps pairs until it reaches the end.
			for (int x = 0; x < n - 1; x++){
				if (a[x] > a[x + 1]){
					int temp = a[x];
					a[x] = a[x + 1];
					a[x + 1] = temp;
				}
			}
		}
		return a;
	}
	
	@Override
	public int[] descending(int[] a) {
		/*
		 * Input:
		 *  - an integer array A
		 *
		 * Output: a sorted array A in *descending* order.
		 */
		int n = a.length;
		//loop 1 checks that the order is correct.
		for (int y = 0; y < n; y++){
			//loop 2 compares and swaps pairs until it reaches the end.
			for (int x = 0; x < n - 1; x++){
				if (a[x] < a[x + 1]){
					int temp = a[x];
					a[x] = a[x + 1];
					a[x + 1] = temp;
				}
			}
		}
		return a;
	}
}