
public class LinkedListDeque<T> {
	
	public class Node<T>{
		public T item ;
		public Node next;
		public Node prev;
		
		public Node() {
			this.item = null;
			this.next = null;
			this.prev = null;
		}
		
		public Node(T value, Node next, Node prev) {
			this.item = value;
			this.next = next;
			this.prev = prev;
		}
		
		public T recursiveGet(int index) {
			if (index == 0) {
				return this.item;
			} else {
				return (T) this.next.recursiveGet(index - 1);
			}
		}
	}
	
	private Node<T> frontSentiel;
	private Node<T> endSentiel;
	private int size;
	private T item;
	private Object next;
	
	
	/**
	 * Creates an empty linked list deque.
	 */
	public LinkedListDeque(){
		this.frontSentiel = new Node<T>();
		this.endSentiel = new Node<T>();
		frontSentiel.next = endSentiel;
		endSentiel.prev = frontSentiel;
		size = 0;
	}
	
	/**
	 * Adds an item of type T to the front of the deque.
	 * @param item
	 */
	public void addFirst(T item) {
		Node<T> temp = frontSentiel.next;
		Node<T> newNode = new Node<>(item, temp, frontSentiel);
		frontSentiel.next = newNode;
		temp.prev = newNode;
		size ++;
		
	}
	
	/**
	 * Adds an item of type T to the back of the deque.
	 * @param item
	 */
	public void addLast(T item) {
		Node<T> temp = endSentiel.prev;
		Node<T> newNode = new Node<>(item, endSentiel, temp);
		endSentiel.prev = newNode;
		temp.next = newNode;
		size ++;
		
	}
	
	/**
	 * Returns true if deque is empty, false otherwise.
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns the number of items in the deque.
	 * @return
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Prints the items in the deque from first to last, separated by a space.
	 */
	public void printDeque() {
		Node<T> curr = frontSentiel.next;
		String output = ""; 
		while (curr.next != null && curr.next.next != null) {
			output += curr.item;
			output += " ";
			curr = curr.next;
		}
		System.out.println(output);
	}
	
	/**
	 * Removes and returns the item at the front of the deque. If no such item exists, returns null.
	 * @return
	 */
	public T removeFirst() {
		if (size < 1) {
			return null;
		} else {
			T returnValue = (T) frontSentiel.next.item;
			Node<T> newFirst = frontSentiel.next.next;
			newFirst.prev = frontSentiel;
			frontSentiel.next = newFirst;
			size --;
			return returnValue;
		}
	}
	
	/**
	 * Removes and returns the item at the back of the deque. If no such item exists, returns null.
	 * @return
	 */
	public T removeLast() {
		if (size < 1) {
			return null;
		} else {
			T returnValue = (T) endSentiel.prev.item;
			Node<T> newLast = endSentiel.prev.prev;
			newLast.next = endSentiel;
			endSentiel.prev = newLast;
			size --;
			return returnValue;
		}
	}
	
	/**
	 * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. 
	 * If no such item exists, returns null. Must not alter the deque!
	 * @param index
	 * @return
	 */
	public T get(int index) {
		if (index > size) {
			return null;
		} else {
			int currIndex = index;
			Node<T> curr = frontSentiel;
			while (currIndex >0) {
				curr = curr.next;
				currIndex --; 
			}
			return (T) curr.item;
			
		}
	}
	
	/**
	 * Same as get, but uses recursion.
	 * @param index
	 * @return
	 */
	public T getRecursive(int index) {
		if (index > size) {
			return null;
		} else {
			return (T) frontSentiel.next.recursiveGet(index);
		} 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
