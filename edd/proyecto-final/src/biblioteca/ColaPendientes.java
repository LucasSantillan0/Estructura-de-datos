package biblioteca;

public class ColaPendientes {

    public static ColaPendientes instancia;

    private Queue<Pendiente> pendientes = new Queue<>();

    public static ColaPendientes instancia() {
        if (instancia == null) {
            instancia = new ColaPendientes();
        }
        return instancia;
    }

    public ColaPendientes() {
    }

    public void agregarPendiente(Usuario usuario, Libro libro) {
        Pendiente pendiente = new Pendiente(usuario, libro);
        pendientes.add(pendiente);
    }

    public Pendiente primerPendiente() {
        return pendientes.peek();
    }

    public void eliminarPrimerPendiente() {
        pendientes.remove();
    }

    public void atenderPendientes() {
        int respuesta = 1;
        while (pendientes.size() > 0 && respuesta != 0) {
            Pendiente pendiente = primerPendiente();
            System.out.println("Atendiendo pendiente para el usuario con codigo " + pendiente.getUsuario().getCodigousuario()
                    + " y el libro con codigo " + pendiente.getLibro().getCodigoLibro()
            );
            boolean disponible = pendiente.getLibro().isDisponibleLibro();
            if (!disponible) {
                System.out.println("El libro con codigo " + pendiente.getLibro().getCodigoLibro() + " aún no esta disponible.");
                System.out.println("Volviendo al menú principal.");
                return;
            } else {
                System.out.println("El libro con codigo " + pendiente.getLibro().getCodigoLibro() + " ya esta disponible para el usuario "
                        + pendiente.getUsuario().getCodigousuario());
            }

            if (disponible) {
                System.out.println("¿Desea autorizar el prestamo del libro? (1: Sí, 2: No)");
                respuesta = 0;
            }
            System.out.println("0: Salir de la atención de pendientes");
            int atender = Helper.validarEntero(Main.entrada, "Ingrese su opción: ");
            if (atender == 1 && disponible) {
                pendiente.getLibro().setDisponibleLibro(false);
                System.out.println("Préstamo autorizado para el usuario " + pendiente.getUsuario().getCodigousuario()
                        + " con el libro " + pendiente.getLibro().getCodigoLibro());
                pendiente.getUsuario().setCantidadLibrosPrestados(
                        pendiente.getUsuario().getCantidadLibrosPrestados() + 1
                );
                eliminarPrimerPendiente();
            } else if (atender == 2 || !disponible) {
                System.out.println("Préstamo no autorizado para el usuario " + pendiente.getUsuario().getCodigousuario()
                        + " con el libro " + pendiente.getLibro().getCodigoLibro());
            }
            if (pendientes.size() == 0) {
                System.out.println("No hay más pendientes por atender.");
                break;
            }
            System.out.println("¿Desea continuar atendiendo pendientes? (1: Sí, 2: No)");
            respuesta = Helper.validarEntero(Main.entrada, "Ingrese su opción: ");
        }
    }
}
