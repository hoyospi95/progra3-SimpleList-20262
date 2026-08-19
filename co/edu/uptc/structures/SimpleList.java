package co.edu.uptc.structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleList<E> implements Collection<E>, List<E> {
	private Node<E> head;
	
	
	public SimpleList() {
		head = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		Node<E> newNode = new Node<E>(e);
		if(head == null){
			head = newNode;
		}else{
			Node<E> actual = head;
			while(actual.getNext() != null){
				actual = actual.getNext();
			}
			actual.setNext(newNode);
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ListIterator<E> listIterator() {

	    ListIterator<E> iterator = new ListIterator<E>() {

	        Node<E> actual = head;

	        @Override
	        public boolean hasNext() {
	            return actual != null;
	        }

	        @Override
	        public E next() {
	            E element = actual.getValue();
	            actual = actual.getNext();
	            return element;
	        }

	        @Override
	        public boolean hasPrevious() {
	            return false;
	        }

	        @Override
	        public E previous() {
	            return null;
	        }

	        @Override
	        public int nextIndex() {
	            return 0;
	        }

	        @Override
	        public int previousIndex() {
	            return -1;
	        }

	        @Override
	        public void remove() {
	        }

	        @Override
	        public void set(E e) {
	        }

	        @Override
	        public void add(E e) {
	        }
	    };

	    return iterator;
	}



	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "SimpleList [head=" + head + "]";
	}

}
