package biblioteca;

import java.util.ArrayList;
import java.util.Random;

public class Biblioteca {

    private static Biblioteca instance;
    private BinarySearchTree<Usuario> usuariosBST = new BinarySearchTree<>();
    private SimpleList<Usuario> usuarios = new SimpleList<>();
    private BinarySearchTree<Libro> librosBST = new BinarySearchTree<>();
    private SimpleList<Libro> libros = new SimpleList<>();
    private ArrayList<String> codigos = new ArrayList<>();

    public static Biblioteca instancia() {
        if (instance == null) {
            instance = new Biblioteca();
        }
        return instance;
    }

    public Biblioteca() {
        usuariosBST = new BinarySearchTree<>();
        librosBST = new BinarySearchTree<>();
        usuarios = new SimpleList<>();
        libros = new SimpleList<>();
        codigos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        librosBST.add(libro);
        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuariosBST.add(usuario);
        usuarios.add(usuario);
    }

    public Usuario[] getUsuarios() {
        Object[] arrayNoTipado = usuarios.toArray();
        var usuariosArray = new Usuario[usuarios.size()];
        for (int i = 0; i < usuarios.size(); i++) {
            usuariosArray[i] = (Usuario) arrayNoTipado[i];
        }
        return usuariosArray;
    }

    public Libro[] getLibros() {
        Object[] arrayNoTipado = libros.toArray();
        var librosArray = new Libro[libros.size()];
        for (int i = 0; i < libros.size(); i++) {
            librosArray[i] = (Libro) arrayNoTipado[i];
        }
        return librosArray;
    }

    public Libro buscarLibroPorCodigo(int codigo) {

        try {
            return librosBST.search(new Libro(codigo));
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario buscarUsuarioPorCodigo(int codigo) {
        try {
            return usuariosBST.search(new Usuario(codigo));
        } catch (Exception e) {
            return null;
        }
    }

    public String obtenerCodigoUnico() {
        int random = new Random().nextInt(200);
        while (codigos.contains(String.valueOf(random))) {
            random = new Random().nextInt(200);
        }
        return String.valueOf(random);
    }

}
