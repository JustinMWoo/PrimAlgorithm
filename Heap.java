/*
 * Justin Woo 250860368
 * jwoo58@uwo.ca
 * Assignment 3, CS3340
 */

/**
 * Heap data structure
 * 
 * @author Justin Woo
 */
public class Heap implements HeapADT {
	private int[] keys, H;
	private int n, curr;

	/*
	 * Constructor for a heap
	 * 
	 * @param keys array of elements to be set as the keys in the heap
	 * 
	 * @param n number of elements in the heap
	 * 
	 */
	public Heap(int[] keys, int n) {
		this.keys = keys;
		this.n = n;

		H = new int[2 * n - 1];

		// Set the leaves in the heap
		for (int i = n; i <= 2 * n - 1; i++) {
			H[i - 1] = i - n + 1;
		}

		// Set the parents of nodes up to the root using the minimum of the children
		// i.e. Heapify
		for (int i = n - 1; i >= 1; i--) {
			if (keys[H[2 * i - 1] - 1] < keys[H[2 * i] - 1])
				H[i - 1] = H[2 * i - 1];
			else
				H[i - 1] = H[2 * i];
		}
	}

	/*
	 * Returns true if the element whose id is id is in the heap
	 * 
	 * @param id id to be checked to see if in the heap
	 * 
	 * @return true if id is in the heap, false otherwise
	 */
	public boolean in_heap(int id) {
		return id <= n && id > 0;
	}

	/*
	 * Returns the minimum key in the heap
	 * 
	 * @return the minimum key in the heap or -1 if there are no more elements in
	 * the heap
	 */
	public int min_key() {
		// If no more elements in the heap
		if (!in_heap(H[0]))
			return -1;

		return keys[H[0] - 1];
	}

	/*
	 * Returns the id of the element with minimum key in the heap
	 * 
	 * @return the id of the element with the minimum key in the heap
	 */
	public int min_id() {
		return H[0];
	}

	/*
	 * Returns the key of the element whose id is id in the heap
	 * 
	 * @param id the id of the element to obtain the key for
	 * 
	 * @return the key of the element whose id is id in the heap
	 */
	public int key(int id) {
		return keys[id - 1];
	}

	/*
	 * Deletes the element with minimum key from the heap
	 * 
	 */
	public void delete_min() {
		// Remove leaf containing minimum in heap
		H[H[0] + n - 2] = 0;

		// Start heapify at parent of leaf that was deleted
		int i = (H[0] + n - 1) / 2;

		// Heapify
		while (i >= 1) {
			if (H[2 * i - 1] == 0) // Element has been deleted
				H[i - 1] = H[2 * i];
			else if (H[2 * i] == 0)
				H[i - 1] = H[2 * i - 1];
			else if (keys[H[2 * i - 1] - 1] < keys[H[2 * i] - 1])
				H[i - 1] = H[2 * i - 1];
			else
				H[i - 1] = H[2 * i];
			i /= 2;
		}
	}

	/*
	 * Sets the key of the element whose id is id to new_key if its current key is
	 * greater than new_key
	 * 
	 * @param id the id to potentially be changed
	 * 
	 * @param new_key the value for the key to be updated to
	 */
	public void decrease_key(int id, int new_key) {
		// If old value is greater than new key value
		if (keys[id - 1] > new_key) {
			keys[id - 1] = new_key;

			// Start heapify at parent of node that was altered
			int i = (id + n - 1) / 2;
			// Heapify
			while (i >= 1) {
				if (H[2 * i - 1] == 0)
					H[i - 1] = H[2 * i];
				else if (H[2 * i] == 0)
					H[i - 1] = H[2 * i - 1];
				else if (keys[H[2 * i - 1] - 1] < keys[H[2 * i] - 1])
					H[i - 1] = H[2 * i - 1];
				else
					H[i - 1] = H[2 * i];
				i /= 2;
			}
		}
	}
}
