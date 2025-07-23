package controller;

import model.Cliente;
import model.ClienteDAO;
import java.util.List;

/**
 * Controlador que se encarga de la lógica de negocio entre la vista y el DAO.
 */
public class ClienteController {
    private ClienteDAO dao = new ClienteDAO();

    public void agregarCliente(int id, String nombre, String correo) {
        Cliente cliente = new Cliente(id, nombre, correo);
        dao.agregarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return dao.obtenerClientes();
    }

    public void eliminarCliente(int id) {
        dao.eliminarCliente(id);
    }
}
