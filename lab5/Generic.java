package lab5;

public interface Generic<E> {
    void push(E v);
    E pop();
    E peek();
    boolean isEmpty();
}
