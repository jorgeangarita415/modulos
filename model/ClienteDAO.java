package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO que simula una base de datos en memoria para manejar clientes.
 * Permite agregar, eliminar, buscar y listar clientes.
 */
public class ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void eliminarCliente(int id) {
        clientes.removeIf(c -> c.getId() == id);
    }
}
