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
		if (isEmpty()) return false;
		if (o == null) throw new NullPointerException();
		if (o.getClass() != head.getValue().getClass()) throw new ClassCastException();
		
		if (head.getValue().equals(o)) {
			head = head.getNext();
			return true;
		}
		
		Node<E> prev = head;
		Node<E> next = head.getNext();

		while (next != null) {
			if (next.getValue().equals(o)) {
				prev.setNext(next.getNext());
				return true;
			}

			next = next.getNext();
			prev = prev.getNext();
		}

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
		// TODO Auto-generated method stub
		return null;
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
