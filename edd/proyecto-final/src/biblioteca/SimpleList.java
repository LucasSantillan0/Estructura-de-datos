package biblioteca;

public class SimpleList<ELEMENT> {

    private Object[] items;
    private int cantidad;

    public SimpleList() {
        this.items = new Object[10];
        this.cantidad = 0;
    }

    public void add(ELEMENT item) {
        if (this.cantidad >= this.items.length) {
            Object[] nuevoArray = new Object[this.items.length * 2];
            for (int i = 0; i < this.items.length; i++) {
                nuevoArray[i] = this.items[i];
            }
            this.items = nuevoArray;
        }
        this.items[this.cantidad] = item;
        this.cantidad++;
    }

    public int size() {
        return this.cantidad;
    }

    public void remove(ELEMENT item) {
        int index = -1;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.items[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < this.cantidad - 1; i++) {
                this.items[i] = this.items[i + 1];
            }
            this.items[this.cantidad - 1] = null;
            this.cantidad--;
        }
    }

    public Object[] toArray() {
        return items;
    }

}
