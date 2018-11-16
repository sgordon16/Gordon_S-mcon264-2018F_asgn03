
public class DoublyLinkedList<T> implements IList<T> {
	
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;
	
	@Override
	public void insertAtHead(T data) {		
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(head);
		if (isEmpty())
			tail = newNode;
		head = newNode;
		size++;
	}

	@Override
	public void insertAt(T data, int index) throws InvalidIndexException {
		// TODO Auto-generated method stub
		if (index < 0)
			throw new InvalidIndexException("Negative index specified");
		
		if (index >= size)
			throw new InvalidIndexException();
		
		if (index == size)
			insertAtTail(data);
		
		if (index == 0)
			insertAtHead(data);
		else {
			Node<T> newNode = new Node<T>(data);
			Node<T> currNode = head;
			if(index < size / 2) {
				for (int i = 0; i < index; i++) 
					currNode = currNode.getNext();
			}
			else {
				for(int i = size; i > index; i--)
					currNode = currNode.getNext();
			}
			currNode.getPrev().setNext(newNode);
			newNode.setNext(currNode);
			newNode.setPrev(currNode.getPrev());
			currNode.setPrev(newNode);
			size++;
		}
	}

	@Override
	public void insertAtTail(T data) {
		if (isEmpty())
			insertAtHead(data);
		else {
			Node<T> currNode = head;
			while (currNode.getNext() != null) 
				currNode = currNode.getNext();
			
			Node<T> newNode = new Node<T>(data);
			currNode.setNext(newNode);
			newNode.setPrev(currNode);
			tail = newNode;
			size++;
		}
	}

	@Override
	public void deleteHead() throws EmptyListException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyListException();
		if (size == 1)
			tail = null;
		
		head = head.getNext();
		size--;
	}

	@Override
	public void deleteAt(int index) throws EmptyListException, InvalidIndexException {
		if (index < 0)
			throw new InvalidIndexException("Negative index specified");
		
		if (index == 0)
			deleteHead();
		
		if (index >= size)
			throw new InvalidIndexException();
		
		if (index == size)
			deleteTail();
		
		Node<T> currNode = head;
		
		if(index < size / 2) {
			for (int i = 0; i < index; i++) 
				currNode = currNode.getNext();
		}
		else {
			for(int i = size; i > index; i--)
				currNode = currNode.getNext();
		}
		
		currNode.getPrev().setNext(currNode.getNext());
		size--;
	}

	@Override
	public void deleteTail() throws EmptyListException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyListException();
		
		if (size == 1)
		{
			head = null;
			tail = null;
		}
		
		Node<T> currNode = head;
		
		while (currNode.getNext().getNext() != null)
			currNode = currNode.getNext();
		
		currNode.setNext(null);
		tail = currNode;
		
		size--;
	}

	@Override
	public T getHead() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException();
		return head.getData();
	}

	@Override
	public T getAt(int index) throws EmptyListException, InvalidIndexException {
		// TODO Auto-generated method stub
		if (index < 0)
			throw new InvalidIndexException("Negative index specified");
		
		if (isEmpty())
			throw new InvalidIndexException();
		
		if (index >= size)
			throw new InvalidIndexException();
		
		if (index == size - 1)
			return getTail();
		
		Node<T> currNode = head;
		for (int i = 0; i < index; i++)
			currNode = currNode.getNext();	
		
		return currNode.getData();
	}

	@Override
	public T getTail() throws EmptyListException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyListException();

		return tail.getData();
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}

}
