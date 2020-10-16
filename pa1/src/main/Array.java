/*
 * Name: Hyun Joon Sung
 * Student ID #: 2019147593
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class Array implements IArray {
	/*
	 * Add some variables you will use.
	 */
	private int[] array;
	private int entries = 0;
	private boolean sorted = false;

	public Array() {
		/*
		 * Constructor This function is an initializer for this class.
		 */
		array = new int[10];
	}

	@Override
	public void insert(int value) {
		/*
		 * Function input: + value: An integer to be inserted.
		 * 
		 * Job: Insert the given integer according to the state of the array. -
		 * unsorted: insert the integer as the last element of the array. - sorted:
		 * insert the integer at the position that makes the array sorted in ascending
		 * order.
		 */

		if (isSorted() == true) {
//    		sorted
			// shifts every element to the right
			for (int i = 0; i < entries; i++) {
				int temp = array[i + 1];
				array[i + 1] = array[i];
			}
			entries++;
			array[0] = value;
			sort();
		} else {
//    		unsorted
//    		add one space if the array is too short
			entries++;
			int c = entries - 1;
			array[c] = value;
		}
	}

	@Override
	public void delete(int value) throws IllegalStateException {
		/*
		 * Function input: + value: An integer to delete.
		 * 
		 * Job: Delete the first element that has the given integer as its value. If
		 * there is no such element, raise an exception.
		 */
		if(search(value) > entries - 1) {
			throw new IllegalStateException("value not in bounds");
		}
		for (int i = search(value); i < entries - 1; i++) {
			array[i] = array[i + 1];
		}
		entries--;
	}

	@Override
	public int search(int value) throws IllegalStateException {
		/*
		 * Function input: + value: An integer to search.
		 * 
		 * Job: Return the first index of the element with the given value. If there is
		 * no such element, raise an exception.
		 */
		for (int i = 0; i < entries; i++) {
			if (value == array[i])
				return i;
		}
		throw new IllegalStateException("Value not found");
	}

	@Override
	public void sort() {
		/**
		 * Function input: Nothing
		 * 
		 * Job: Change the state of the array to sorted. Sort the elements in the array
		 * in ascending order.
		 */
		for (int y = 0; y < entries; y++) {
			for (int x = 0; x < entries - 1; x++) {
				if (array[x] > array[x + 1]) {
					int temp = array[x];
					array[x] = array[x + 1];
					array[x + 1] = temp;
				}
			}
		}
		sorted = true;
	}

	@Override
	public void unsort() {
		/**
		 * Function input: Nothing
		 * 
		 * Job: Change the state of the array to unsorted.
		 */
		sorted = false;
	}

	@Override
	public int atIndex(int index) throws IndexOutOfBoundsException {
		/**
		 * Function input: + index: An integer to find the element at that position
		 * 
		 * Job: Return the value of the element at the given index.
		 */

		if (index > array.length || index < 0)
			throw new IndexOutOfBoundsException("index out of bounds");
		else
			return array[index];
	}

	@Override
	public int size() {
		/*
		 * Function input: Nothing
		 *
		 * Job: Return the number of elements in this array.
		 */
		return entries;
	}

	@Override
	public boolean isSorted() {
		/**
		 * Function input: Nothing
		 * 
		 * Job: Return true if the array is sorted and false otherwise.
		 */
		return sorted;
	}

	@Override
	public boolean isEmpty() {
		/* You do not have to edit this function. */
		return size() == 0;
	}
}
