package biblioteca;

public class GestorOperaciones {

    private static GestorOperaciones instance;
    private final StackGenerica<Operacion> operaciones = new StackGenerica<>();

    public static GestorOperaciones instancia() {
        if (instance == null) {
            instance = new GestorOperaciones();
        }
        return instance;
    }

    public void agregar(Operacion operacion) {
        operaciones.push(operacion);
        operacion.Aplicar();
    }

    public void revertir() {
        Operacion operacion = operaciones.pop();
        operacion.Revertir();
    }
}
