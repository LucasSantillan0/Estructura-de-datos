package edd.tp3.E5;

public class StackGenerica<ELEMENT> {

    private final int maximoTamanio = 10;
    private ELEMENT[] datos;
    private int cuenta;

    public StackGenerica() {
        this.datos = (ELEMENT[]) new Object[this.maximoTamanio];
        this.cuenta = 0;
    }

    public void push(ELEMENT elemento) {
        if (this.isFull()) {
            ELEMENT[] newArray = (ELEMENT[]) new Object[this.datos.length * 2];
            System.arraycopy(this.datos, 0, newArray, 0, this.datos.length);
            this.datos = newArray;
        }
        this.datos[this.cuenta] = elemento;
        ++this.cuenta;
    }

    public ELEMENT pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila est� vac�a...");
        }
        --this.cuenta;
        return this.datos[this.cuenta];
    }

    public ELEMENT peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila est� vac�a...");
        }
        return this.datos[this.cuenta - 1];
    }

    public boolean isEmpty() {
        return this.cuenta <= 0;
    }

    public boolean isFull() {
        return this.cuenta >= this.datos.length;
    }

    public int count() {
        return this.cuenta;
    }

    @Override
    public String toString() {
        String result = "{ ";
        for (int i = 0; i < this.cuenta; i++) {
            result += this.datos[i] + ", ";
        }
        result += "}";
        return result;
    }

}