package biblioteca;

public class Usuario implements Comparable<Usuario> {

    private int codigousuario;
    private int dniusuario;
    private String nombreUsuario;
    private String direcionUsuario;
    private int telecfonoUsuario;
    private int cantidadLibrosPrestados;

    public Usuario(int codigousuario) {
        this.codigousuario = codigousuario;
    }

    public Usuario(int dniusuario, String nombreUsuario, String direcionUsuario, int telecfonoUsuario) {
        this.codigousuario = Integer.parseInt(Biblioteca.instancia().obtenerCodigoUnico());
        this.dniusuario = dniusuario;
        this.nombreUsuario = nombreUsuario;
        this.direcionUsuario = direcionUsuario;
        this.telecfonoUsuario = telecfonoUsuario;
        this.cantidadLibrosPrestados = 0;
    }

    public int getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(int codigousuario) {
        this.codigousuario = codigousuario;
    }

    public int getDniusuario() {
        return dniusuario;
    }

    public void setDniusuario(int dniusuario) {
        this.dniusuario = dniusuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDirecionUsuario() {
        return direcionUsuario;
    }

    public void setDirecionUsuario(String direcionUsuario) {
        this.direcionUsuario = direcionUsuario;
    }

    public int getTelecfonoUsuario() {
        return telecfonoUsuario;
    }

    public void setTelecfonoUsuario(int telecfonoUsuario) {
        this.telecfonoUsuario = telecfonoUsuario;
    }

    public int getCantidadLibrosPrestados() {
        return cantidadLibrosPrestados;
    }

    public void setCantidadLibrosPrestados(int cantidadLibrosPrestados) {
        this.cantidadLibrosPrestados = cantidadLibrosPrestados;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "codigousuario=" + codigousuario + ", dniusuario=" + dniusuario + ", nombreUsuario=" + nombreUsuario + ", direcionUsuario=" + direcionUsuario + ", telecfonoUsuario=" + telecfonoUsuario + ", cantidadLibrosPrestados=" + cantidadLibrosPrestados + '}';
    }

    @Override
    public int compareTo(Usuario o) {
        if (o.codigousuario == this.codigousuario) {
            return 0;
        }
        return o.codigousuario > this.codigousuario ? 1 : -1;
    }

}
