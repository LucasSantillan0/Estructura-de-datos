/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author 10tia
 */
public class Devolucion extends Operacion {

    public Devolucion(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.codigo = Biblioteca.instancia().obtenerCodigoUnico();
    }

    @Override
    public void Aplicar() {
        System.out.println("Aplicando devolucion de libro " + libro.getCodigoLibro() + " del usuario " + usuario.getCodigousuario());
        libro.setDisponibleLibro(true);
        usuario.setCantidadLibrosPrestados(usuario.getCantidadLibrosPrestados() - 1);
    }

    @Override
    public void Revertir() {
        System.out.println("Revirtiendo devolucion de libro " + libro.getCodigoLibro() + " del usuario " + usuario.getCodigousuario());
        libro.setDisponibleLibro(false);
        usuario.setCantidadLibrosPrestados(usuario.getCantidadLibrosPrestados() + 1);
    }

}
