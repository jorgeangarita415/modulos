package model;

/**
 * Clase que representa un cliente en el sistema.
 * Contiene atributos básicos y métodos de acceso (get/set).
 */
public class Cliente {
    private int id;
    private String nombre;
    private String correo;

    public Cliente(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getId() { return id; }

    public String getNombre() { return nombre; }

    public String getCorreo() { return correo; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setCorreo(String correo) { this.correo = correo; }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + correo;
    }
}
