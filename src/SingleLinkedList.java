public class SingleLinkedList<T> implements IndexedListI<T> {

	private Node<T> head;
	private Node<T> tail;
	int numberOfentries;

	public SingleLinkedList() {
		clear();
	}

	@Override
	public void add(T entry) {
		Node<T> newNode = new Node<T>(entry);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		numberOfentries++;
	}

	@Override
	public void add(int index, T entry) {
		if (index >= 0 && index <= numberOfentries) {
			Node<T> newNode = new Node<T>(entry);
			if (isEmpty()) {
				head = newNode;
				tail = newNode;
			} else if (index == 0) {
				newNode.next = head;
				head = newNode;
			} else if (index == numberOfentries) {
				tail.next = newNode;
				tail = newNode;
			} else {
				Node<T> nodeBefore = getNodeAt(index - 1);
				Node<T> nodeAfter = nodeBefore.next;
				newNode.next = nodeAfter;
				nodeBefore.next = newNode;
			}
			numberOfentries++;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public T remove(int index) {
		T result = null;
		if (isEmpty() || (index >= 0 && index <= size() - 1)) {
			if (index == 0) {
				result = head.data;
				head = head.next;
				if (numberOfentries == 1) {
					tail = null;
				}
			} else {
				Node<T> nodeBefore = getNodeAt(index - 1);
				Node<T> nodeToRemove = nodeBefore.next;
				Node<T> nodeAfter = nodeToRemove.next;
				nodeBefore.next = nodeAfter;
				result = nodeToRemove.data;
				if (index == numberOfentries) {
					tail = nodeBefore;
				}
			}
			numberOfentries--;

		} else {
			throw new IndexOutOfBoundsException();
		}
		return result;
	}

	@Override
	public T replace(int index, T entry) {
		T result = null;
		if (isEmpty() || (index >= 0 && index <= size() - 1)) {
			Node<T> nodeToReplace = getNodeAt(index);
			result = nodeToReplace.data;
			nodeToReplace.data = entry;
		} else {
			throw new IndexOutOfBoundsException();
		}
		return result;
	}

	@Override
	public T get(int index) {
		T result = null;
		if (isEmpty() || (index >= 0 && index <= size() - 1)) {
			result = getNodeAt(index).data;
		} else {
			throw new IndexOutOfBoundsException();
		}
		return result;
	}

	@Override
	public boolean contains(T entry) {
		boolean found = false;
		Node<T> currentNode = head;
		while (!found && (currentNode != null)) {
			if (entry.equals(currentNode.data)) {
				found = true;
			} else {
				currentNode = currentNode.next;
			}
		}
		return found;
	}

	@Override
	public int size() {
		return numberOfentries;
	}

	@Override
	public boolean isEmpty() {
		boolean result;

		if (numberOfentries == 0) {
			assert head == null : "numberOfEntries is null but the head is not";
			result = true;
		} else {
			assert tail != null : "numberOfEntries is NOT null but the head is";
			result = false;
		}
		return result;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.numberOfentries = 0;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfentries];
		Node<T> currentNode = head;
		for (int i = 0; i < numberOfentries && currentNode != null; i++) {
			result[i] = currentNode.data;
			currentNode = currentNode.next;
		}
		return result;
	}

	private Node<T> getNodeAt(int index) {
		Node<T> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// if not static - the inner class can use the instance fields from the
	// outer class and the T
	private static class Node<T> {

		// all fields are visible to the outer class
		private T data; // entry in bag
		private Node<T> next; // link to next node

		public Node(T data) {
			this(data, null);
		}

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

	} // end Node<T> class

}
