public interface IndexedListI<T> {
	/**
	 * Adds the entry at the end of this list.
	 */
	public void add(T entry);

	/**
	 * Adds the entry at the index. Throws IndexOutOfBoundsException if index is
	 * not in [0, size()].
	 */
	public void add(int index, T entry);

	/**
	 * Removes and returns the entry at the index. Throws
	 * IndexOutOfBoundsException if this list is empty or index is not in [0,
	 * size()-1].
	 */
	public T remove(int index);

	/**
	 * Replaces and returns the old entry at the index with the specified entry.
	 * Throws IndexOutOfBoundsException if this list is empty or index is not in
	 * [0, size()-1].
	 */
	public T replace(int index, T entry);

	/**
	 * Returns the entry at the index. Throws IndexOutOfBoundsException if this
	 * list is empty or index is not in [0, size()-1].
	 */
	public T get(int index);

	/**
	 * Return true if the entry is in this list.
	 */
	public boolean contains(T entry);

	/**
	 * Returns the number of entries in this list.
	 */
	public int size();

	/**
	 * Returns true if this list is empty.
	 */
	public boolean isEmpty();

	/**
	 * Removes all entries from this list.
	 */
	public void clear();

	/**
	 * Returns an array containing all entries in the same order as in this
	 * list.
	 */
	public T[] toArray();
}
