package biblioteca;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static Scanner entrada = new Scanner(System.in);

    public static void mostrarOpcionesPrincipales() {
        System.out.println("----- Biblioteca -----");
        System.out.println("1. Consultas");
        System.out.println("2. Gestionar datos");
        System.out.println("3. Gestionar prestamos");
        System.out.println("4. Salir");
    }

    public static void main(String[] args) {
        int option = 1;
        while (option != 4) {
            mostrarOpcionesPrincipales();
            option = Helper.validarEnteroEnRango(entrada,
                    "Elige una opción ",
                    1, 4);
            switch (option) {
                case 1 ->
                    consultas();
                case 2 ->
                    gestionDedatos();
                case 3 ->
                    gestionDePrestamos();
                case 4 -> {
                    System.out.println("Estás seguro que deseas salir? ");
                    int confirmacion = Helper.validarEnteroEnRango(entrada,
                            "1. Sí\n2. No\nElige una opción ",
                            1, 2);
                    if (confirmacion != 1) {
                        option = 1;
                    }
                }

                default ->
                    System.out.println("Opción incorrecta.");
            }
        }
    }

    public static void consultas() {
        int option = 1;
        while (option != 6) {
            System.out.println("----- Consultas -----");
            System.out.println("1. Listar todos los libros");
            System.out.println("2. Listar usuarios registrados");
            System.out.println("3. Cantidad de libros prestados");
            System.out.println("4. Buscar libro por autor");
            System.out.println("5. Buscar usuarios con x libros prestados");
            System.out.println("6. Salir de consultas");

            option = Helper.validarEnteroEnRango(entrada,
                    "Elige una opción ",
                    1, 6);
            switch (option) {
                case 1 -> {
                    Libro[] libros = Biblioteca.instancia().getLibros();

                    for (Libro libro : libros) {
                        System.out.println(libro);
                    }
                    if (!libros.equals(null) && libros.length == 0) {
                        System.out.println("No hay libros registrados.");
                    }
                }
                case 2 -> {
                    Usuario[] usuarios = Biblioteca.instancia().getUsuarios();

                    for (Usuario usuario : usuarios) {
                        System.out.println(usuario);
                    }
                    if (!usuarios.equals(null) && usuarios.length == 0) {
                        System.out.println("No hay usuarios registrados.");
                    }
                }
                case 3 -> {
                    int cantidadTotal = 0;
                    Libro[] allLibros = Biblioteca.instancia().getLibros();
                    for (Libro libro : allLibros) {
                        if (!libro.isDisponibleLibro()) {
                            cantidadTotal++;
                        }
                    }
                    System.out.println("Cantidad total de libros prestados: " + cantidadTotal);
                }
                case 4 -> {
                    String autor = Helper.validarStringNoVacio(entrada, "Ingrese el nombre del autor a buscar:");
                    Libro[] allLibrosAutor = Biblioteca.instancia().getLibros();
                    System.out.println("Libros del autor " + autor + ":");
                    for (Libro libro : allLibrosAutor) {
                        if (libro.getAutorLibro().contains(autor)) {
                            System.out.println(libro);
                        }
                    }
                }
                case 5 -> {
                    int cantidad = Helper.validarEntero(entrada, "Ingrese la cantidad de libros prestados a buscar:");
                    Usuario[] allUsuarios = Biblioteca.instancia().getUsuarios();
                    System.out.println("Usuarios con " + cantidad + " libros prestados:");
                    SimpleLinkedList<Usuario> usuariosEncontrados = new SimpleLinkedList<>();
                    for (Usuario usuario : allUsuarios) {
                        if (usuario.getCantidadLibrosPrestados() >= cantidad) {
                            usuariosEncontrados.addLast(usuario);
                        }
                    }
                    for (Usuario usuario : usuariosEncontrados) {
                        System.out.println(usuario);
                    }
                }

                default ->
                    System.out.println("Opción en construcción...");
            }
        }
    }

    public static void gestionDedatos() {
        int option = 0;
        while (option != 3) {
            System.out.println("----- Gestión de datos -----");
            System.out.println("1. Agregar nuevo libro");
            System.out.println("2. Agregar nuevo usuario");
            System.out.println("3. Salir de gestión de datos");
            option = Helper.validarEnteroEnRango(entrada,
                    "Elige una opción ",
                    1, 3);
            switch (option) {
                case 1 -> {
                    String titulo = Helper.validarStringNoVacio(entrada, "Ingrese el título del libro:");
                    String autor = Helper.validarStringNoVacio(entrada, "Ingrese el autor del libro:");
                    double precio = Helper.validarDouble(entrada, "Ingrese el precio del libro:");
                    Libro nuevoLibro = new Libro(autor, titulo, precio);
                    Biblioteca.instancia().agregarLibro(nuevoLibro);
                    System.out.println("Libro agregado exitosamente: " + nuevoLibro);
                }
                case 2 -> {
                    int dni = Helper.validarEntero(entrada, "Ingrese el DNI del usuario:");
                    String nombre = Helper.validarStringNoVacio(entrada, "Ingrese el nombre del usuario:");
                    String direccion = Helper.validarStringNoVacio(entrada, "Ingrese la dirección del usuario:");
                    int telefono = Helper.validarEntero(entrada, "Ingrese el teléfono del usuario:");
                    Usuario nuevoUsuario = new Usuario(dni, nombre, direccion, telefono);
                    Biblioteca.instancia().agregarUsuario(nuevoUsuario);
                    System.out.println("Usuario agregado exitosamente: " + nuevoUsuario);
                }
                case 3 ->
                    System.out.println("Saliendo de gestión de datos...");
                default ->
                    System.out.println("Opción incorrecta. Intente nuevamente.");
            }
        }
    }

    public static void gestionDePrestamos() {
        int option = 0;
        while (option != 5) {
            System.out.println("----- Gestión de préstamos -----");
            System.out.println("1. Prestar libro");
            System.out.println("2. Devolver libro");
            System.out.println("3. Préstamos pendientes");
            System.out.println("4. Deshacer última acción (solo prestamos y devoluciones)");
            System.out.println("5. Salir de gestión de préstamos");

            option = Helper.validarEnteroEnRango(entrada,
                    "Elige una opción ",
                    1, 5);
            switch (option) {
                case 1 -> {
                    int codigoUsuarioPrestamo = Helper.validarEntero(entrada, "Ingrese el código del usuario:");
                    Usuario usuario = Biblioteca.instancia().buscarUsuarioPorCodigo(codigoUsuarioPrestamo);
                    if (usuario == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }
                    int codigoLibroPrestamo = Helper.validarEntero(entrada, "Ingrese el código del libro:");
                    Libro libro = Biblioteca.instancia().buscarLibroPorCodigo(codigoLibroPrestamo);
                    if (libro == null) {
                        System.out.println("Libro no encontrado.");
                        break;
                    }
                    if (!libro.isDisponibleLibro()) {
                        System.out.println("El libro no está disponible para préstamo.");
                        System.out.println("Agregando a la cola de pendientes...");
                        ColaPendientes.instancia().agregarPendiente(usuario, libro);
                        break;
                    }
                    Prestamo prestamo = new Prestamo(usuario, libro);
                    GestorOperaciones.instancia().agregar(prestamo);
                }
                case 2 -> {
                    int codigoUsuarioDevolucion = Helper.validarEntero(entrada, "Ingrese el código del usuario:");
                    Usuario usuario = Biblioteca.instancia().buscarUsuarioPorCodigo(codigoUsuarioDevolucion);
                    if (usuario == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }
                    int codigoLibroDevolucion = Helper.validarEntero(entrada, "Ingrese el código del libro:");
                    Libro libro = Biblioteca.instancia().buscarLibroPorCodigo(codigoLibroDevolucion);
                    if (libro == null) {
                        System.out.println("Libro no encontrado.");
                        break;
                    }
                    if (libro.isDisponibleLibro()) {
                        System.out.println("El libro ya está disponible en la biblioteca.");
                        break;
                    }
                    Devolucion devolucion = new Devolucion(usuario, libro);
                    GestorOperaciones.instancia().agregar(devolucion);
                }
                case 3 -> {
                    ColaPendientes.instancia().atenderPendientes();
                }
                case 4 -> {
                    GestorOperaciones.instancia().revertir();
                }
                default ->
                    System.out.println("Opción incorrecta. ");
            }
        }
    }

}
