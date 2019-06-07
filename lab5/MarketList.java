package lab5;

import java.util.EmptyStackException;
import java.util.Iterator;

public class MarketList<E> implements Generic<E>,Iterable<E> {

    public MarketList() {
        setTop(null);
    }

    public static class Element<E> {
        E data;
        Element<E> next;

        Element(E data, Element<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Element<E> top;

    /*******Add Element*******/
    public void push(E v) {
        if (v == null) {
            throw new NullPointerException();
        }
        setTop(new Element<E>(v, getTop()));
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E data = getTop().data;
        setTop(getTop().next);
        return data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E data = getTop().data;
        return data;
    }

    /*******Remove
     * @param position*******/
    void deleteElement(int position) {
        if (isEmpty())
            return;

        Element<E> temp = top;
        if (position == 0) {
            top = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Element<E> next = temp.next.next;
        temp.next = next;
    }

    /*******Search*******/
    void findElement(String find) {
        boolean c = false;
        for (Iterator<E> iterator = iterator(); iterator.hasNext(); ) {
            E data = iterator.next();
            if (((Shop) data).getProduct().equals(find)) {
                c = true;
                break;
            }
        }
        if (c) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    /*******Swap list*******/
    void reverse(MarketList<E> list) {
        Element<E> node = list.top;
        Element<E> previous = null;
        while (node != null) {
            //next item
            Element<E> tmp = node.next;

            //swap items
            node.next = previous;
            previous = node;
            list.top = node;

            //next item
            node = tmp;

        }
    }


    @Override
    public boolean isEmpty() {
        return (getTop() == null);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    public Element<E> getTop() {
        return top;
    }

    public void setTop(Element<E> top) {
        this.top = top;
    }


    class MyIterator implements Iterator<E> {
        private Element<E> current;

        public MyIterator() {
            current = null;
        }

        @Override
        public boolean hasNext() {
            if (current == null)
                return true;
            return current.next != null;
        }

        @Override
        public E next() {
            if (current == null) {
                current = getTop();
                return (E) current.data;
            }
            current = current.next;
            return (E) current.data;
        }
    }
}

