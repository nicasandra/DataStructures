package first;

import java.util.NoSuchElementException;

/**
 * Created by nicasandra on 10/31/2016.
 */
public class Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int n;

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public class Node<T> {
        private Node<T> next;
        private T elem;

        public Node<T> getNext() {
            return next;
        }

        public T getElem() {
            return elem;
        }
    }

    public Queue() {
        this.first = null;
        this.last = null;
        this.n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return first.elem;
    }

    public void add(T elem) {
        Node<T> aux = last;
        last = new Node<T>();
        last.elem = elem;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            aux.next = last;
        }
        n++;
    }

    public boolean remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        first = first.next;
        n--;
        return true;
    }

    public T getFromIndex(int i) {
        int s = 0;
        Node<T> neww = first;
        while (s < i) {
            neww = neww.next;
            s++;
        }
        return neww.elem;
    }

    public String toStr() {
        int s = 0;
        StringBuilder str = new StringBuilder();
        Node<T> newNode = first;
        while (s < this.n) {
            str.append(newNode.elem).append(" ");
            newNode = newNode.next;
            s++;
        }
        return str.toString();
    }

    public boolean containsElement(T elem) {
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (getFromIndex(i).equals(elem)) {
                return true;
            }
        }
        return false;
    }
}
