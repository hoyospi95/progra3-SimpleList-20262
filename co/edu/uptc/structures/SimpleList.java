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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Permite recorrer los elementos de la lista uno por uno.
	 *
	 * @return un iterador para recorrer la lista
	 */
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			// Guarda el nodo que se está recorriendo actualmente.
			// Al comenzar, apunta al primer nodo de la lista.
			private Node<E> actual = head;

			/**
			 * Comprueba si todavía hay un elemento por recorrer.
			 *
			 * @return true si actual apunta a un nodo,
			 *         false si ya se llegó al final de la lista
			 */
			@Override
			public boolean hasNext() {
				return actual != null;
			}

			/**
			 * Obtiene el elemento del nodo actual y pasa al siguiente nodo.
			 *
			 * @return el valor del nodo actual
			 * @throws NoSuchElementException si ya no quedan elementos
			 */
			@Override
			public E next() {
				if (actual == null) {
					throw new NoSuchElementException();
				}

				// Guardamos el valor del nodo actual.
				E value = actual.getValue();

				// Pasamos al siguiente nodo de la lista.
				actual = actual.getNext();

				return value;
			}
		};
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

		boolean result = false;
		Node<E> current = head;
		Node<E> previous = null;

		while (current != null) {

			if (c.contains(current.getValue())) {

				previous = current;
				current = current.getNext();

			} else {
				result = true;
			}
			if (previous == null) {
				head = current.getNext();
			}else{ 
				previous.setNext(current.getNext());
			}

			current =current.getNext();

		}

		return result;
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
		Node<E> actual = head;	
		int i = -1;
		int j = 0;
		while(actual != null){
			if(actual.getValue().equals(o)){
				i = j;
			}
			j++;
			actual = actual.getNext();
		}
		return i;
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
