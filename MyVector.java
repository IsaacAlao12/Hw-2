import java.util.Arrays;

public class MyVector<T> {
    private Object[] data;
    private int size;

    //Default constructor
    public MyVector() {
        data = new Object[10]; //Starting capacity
        size = 0;
    }

    //Add
    public void add(T element) {
        ensureCapacity(size + 1);
        data[size++] = element;
    }

    //Get
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    //Set
    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    //Remove
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);

        T removed = (T) data[index];

        //Shift elements left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null; //Prevent memory leak
        size--;

        return removed;
    }

    //Size
    public int size() {
        return size;
    }

    //Ensure capacity
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = data.length * 2;

            // Ensure it's at least minCapacity
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            data = Arrays.copyOf(data, newCapacity);
        }
    }

    //Helper
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }
    }
}
