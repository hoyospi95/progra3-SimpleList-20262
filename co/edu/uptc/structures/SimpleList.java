package co.edu.uptc.structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

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
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		return new ListIterator<E>() {
			private int currentIndex = index;
			private Node<E> currentNode = (Node<E>) get(currentIndex);
			private Node<E> lastNode = null;

			@Override
			public boolean hasNext() {
				return currentIndex < size();
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				lastNode = currentNode;
				E data = currentNode.getValue();
				currentNode = currentNode.getNext();
				currentIndex++;
				return data;
			}

			@Override
			public boolean hasPrevious() {
				return currentIndex > 0;
			}

			@Override
			public E previous() {
				if (!hasPrevious()) {
					throw new NoSuchElementException();
				}
				currentIndex--;
				currentNode = (Node<E>) get(currentIndex);
				lastNode = currentNode;
				return currentNode.getValue();
			}

			@Override
			public int nextIndex() {
				return currentIndex;
			}

			@Override
			public int previousIndex() {
				return currentIndex - 1;
			}

			@Override
			public void remove() {
				if (lastNode == null) {
					throw new IllegalStateException();
				}
				Node<E> previous;
				if (lastNode == head) {
					previous = null;
				} else {
					int lastNodeIndex;
					if (currentNode == lastNode) {
						lastNodeIndex = currentIndex;
					} else {
						lastNodeIndex = currentIndex - 1;
					}
					previous = (Node<E>) get(lastNodeIndex - 1);
				}
				if (previous == null) {
					head = lastNode.getNext();
				} else {
					previous.setNext(lastNode.getNext());
				}
				if (currentNode == lastNode) {
					currentNode = lastNode.getNext();
				} else {
					currentIndex--;
				}
				lastNode = null;
			}

			@Override
			public void set(E e) {
				if (lastNode == null) {
					throw new IllegalArgumentException();
				}

				lastNode.setValue(e);

			}

			@Override
			public void add(E e) {
				Node<E> newNode = new Node<E>(e);
				if (currentIndex == 0) {
					newNode.setNext(head);
					head = newNode;
				} else {
					Node<E> previous = (Node<E>) get(currentIndex - 1);
					previous.setNext(newNode);
					newNode.setNext(currentNode);
				}
				currentIndex++;
				lastNode = null;

			}
		};
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
