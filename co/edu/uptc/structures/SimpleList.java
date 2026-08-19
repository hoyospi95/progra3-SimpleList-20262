package co.edu.uptc.structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class SimpleList<E> implements Collection<E>, List<E> {
	private Node<E> head;

	public SimpleList() {
		head = null;
	}

	@Override
	public int size() {
		Node<E> current = head;
		int count = 0;
		while (current != null) {
			count += 1;
			current = current.getNext();
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(Object o) {
		Node<E> aux = head;
		while (aux != null) {
			if (o == null ? aux.getValue() == null : o.equals(aux.getValue())) {
				return true;
			}
			aux = aux.getNext();
		}
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
		if (head == null) {
			head = newNode;
		} else {
			Node<E> actual = head;
			while (actual.getNext() != null) {
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
	public boolean containsAll(Collection<?> c) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException{
		for (Object object : c) {
			if(!contains(object)){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		boolean isAdded = false;

        if (index >= 0 && index <= this.size()) { 
            if (!c.isEmpty()) {
                Node<E> predecessor = null;
                Node<E> successor = this.head;
                for (int i = 0; i < index; i++) {
                    predecessor = successor;
                    successor = successor.getNext();
                }
                Node<E> current = predecessor;
                for (E element : c) {
                    Node<E> newNode = new Node<>(element);
                    if (current == null) {
                        this.head = newNode;
                    } else {
                        current.setNext(newNode);
                    }
                    current = newNode; 
                }
                if (current != null) {
                    current.setNext(successor);
                }
                isAdded = true;
            }
        }
        return isAdded;
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
		head = null;
	}

	@Override
	public E get(int index) {
		if (index < 0 || head == null) {
			return null;
		}

		Node currentNode = head;
		int currentIndex = 0;

		while (currentNode != null) {
			if (currentIndex == index) {
				return currentNode.getValue();
			}
			else {
				currentIndex ++;
				currentNode = currentNode.getNext();
			}
		}
		
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		Node<E> newNode = new Node<>(element);

		if (index == 0) {
			newNode.setNext(head);
			head = newNode;
			return;
		}
		
		Node<E> aux = head;
		for (int i = 0; i < index - 1; i++) {
			aux = aux.getNext();
		}

		newNode.setNext(aux.getNext());
		aux.setNext(newNode);
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		Node<E> aux = head;
		int counter = 0;
		while(aux != null){
			if(aux.getValue().equals(o)){
				return counter;
			}
			aux = aux.getNext();
			counter++;
		}
		return -1;
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
