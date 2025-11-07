package biblioteca;

public class Prestamo extends Operacion {

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.codigo = Biblioteca.instancia().obtenerCodigoUnico();
    }

    @Override
    public void Aplicar() {
        System.out.println("Aplicando prestamo de libro " + libro.getCodigoLibro() + " al usuario " + usuario.getCodigousuario());
        usuario.setCantidadLibrosPrestados(usuario.getCantidadLibrosPrestados() + 1);
        libro.setDisponibleLibro(false);
    }

    @Override
    public void Revertir() {
        System.out.println("Revirtiendo prestamo de libro " + libro.getCodigoLibro() + " al usuario " + usuario.getCodigousuario());
        usuario.setCantidadLibrosPrestados(usuario.getCantidadLibrosPrestados() - 1);
        libro.setDisponibleLibro(true);
    }

}
