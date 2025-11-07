package biblioteca;

public class Pendiente {

    private final Libro libro;
    private final Usuario usuario;

    public Pendiente(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
