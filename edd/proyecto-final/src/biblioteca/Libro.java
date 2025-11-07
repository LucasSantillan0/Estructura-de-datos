package biblioteca;

public class Libro implements Comparable<Libro> {

    private int codigoLibro;
    private String autorLibro;
    private String tituloLibro;
    private double precioLibro;
    private boolean disponibleLibro;

    public Libro(String autorLibro, String titulo, double precioLibro) {
        this.tituloLibro = titulo;
        this.autorLibro = autorLibro;
        this.precioLibro = precioLibro;
        this.disponibleLibro = true;
        this.codigoLibro = Integer.parseInt(Biblioteca.instancia().obtenerCodigoUnico());
    }

    public Libro(int codigo) {
        this.codigoLibro = codigo;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public double getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(double precioLibro) {
        this.precioLibro = precioLibro;
    }

    public boolean isDisponibleLibro() {
        return disponibleLibro;
    }

    public void setDisponibleLibro(boolean disponibleLibro) {
        this.disponibleLibro = disponibleLibro;
    }

    @Override
    public String toString() {
        return "Libro{" + "codigoLibro=" + codigoLibro + ", autorLibro=" + autorLibro + ", precioLibro=" + precioLibro + ", disponibleLibro=" + disponibleLibro + '}';
    }

    @Override
    public int compareTo(Libro o) {
        if (o.codigoLibro == this.codigoLibro) {
            return 0;
        }
        return o.codigoLibro > this.codigoLibro ? 1 : -1;
    }

}
