package home.test.pecs;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

class Stack<T> {
    private T[] elementData;

    private int elementCount = 0;

    private void ensureCapacityHelper(int minCapacity){
        if (minCapacity - elementData.length > 0)
            elementData = Arrays.copyOf(elementData, 2 * elementData.length);
    }
    public Stack(){
        this(10);
    }

    @SuppressWarnings("unchecked")
    public Stack(int initialCapacity){
        elementData = (T[]) new Object[initialCapacity];
    }

    public T push(T item){
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = item;
        System.out.println("push " + item.toString());
        return item;
    }

    public T pop(){
        T item;
        if (elementCount == 0)
            throw new EmptyStackException();
        item = elementData[elementCount - 1];
        elementCount--;
        elementData[elementCount] = null;
        System.out.println("pop " + item.toString());
        return item;
    }
    /*
     * Добавляем елементы из коллекции в стек.
     * В качестве входного параметра можно передавать коллекции
     * производных от T типов.
     */
    public void pushAll(Collection<? extends T> c) {
        for(T item: c)
            push(item);
    }
    /*
     * Извлекаем елементы из стека в коллекцию.
     * В качестве входного параметра можно передавать коллекции
     * супертипов для Т.
     */
    public void popAll(Collection<? super T> c) {
        while(elementCount > 0)
            c.add(pop());
    }
}