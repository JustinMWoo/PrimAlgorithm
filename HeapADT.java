
public interface HeapADT {
	// Constructor for heap with array keys and n elements
//	public heap(int[] keys, int n);

	// returns true if the element whose id is id is in the heap
	public boolean in_heap(int id);

	// returns the minimum key of the heap
	public int min_key();

	// returns the id of the element with minimum key in the heap
	public int min_id();

	// returns the key of the element whose id is id in the heap
	public int key(int id);

	// deletes the element with minimum key from the heap
	public void delete_min();

	// sets the key of the element whose id is id to new_key if its current key is
	// greater than new_key
	public void decrease_key(int id, int new_key);
}
