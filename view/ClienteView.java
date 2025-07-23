package view;

import controller.ClienteController;
import model.Cliente;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal que permite al usuario agregar, eliminar y listar clientes.
 * Utiliza el controlador para acceder a los datos.
 */
public class ClienteView extends JFrame {
    private ClienteController controller = new ClienteController();
    private JTextArea area;
    private JTextField idField, nombreField, correoField;

    public ClienteView() {
        setTitle("Gestión de Clientes");
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear campos de texto
        idField = new JTextField(5);
        nombreField = new JTextField(10);
        correoField = new JTextField(15);

        // Crear botones
        JButton agregarBtn = new JButton("Agregar");
        JButton listarBtn = new JButton("Listar");
        JButton eliminarBtn = new JButton("Eliminar");

        // Área de resultados
        area = new JTextArea(10, 35);
        area.setEditable(false);

        // Agregar elementos al frame
        add(new JLabel("ID:")); add(idField);
        add(new JLabel("Nombre:")); add(nombreField);
        add(new JLabel("Correo:")); add(correoField);
        add(agregarBtn); add(listarBtn); add(eliminarBtn);
        add(new JScrollPane(area));

        // Acciones de botones
        agregarBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                String correo = correoField.getText();
                controller.agregarCliente(id, nombre, correo);
                limpiarCampos();
                mostrarMensaje("Cliente agregado exitosamente.");
            } catch (NumberFormatException ex) {
                mostrarMensaje("ID debe ser un número.");
            }
        });

        listarBtn.addActionListener(e -> {
            area.setText("");
            for (Cliente c : controller.listarClientes()) {
                area.append(c.toString() + "\n");
            }
        });

        eliminarBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                controller.eliminarCliente(id);
                limpiarCampos();
                mostrarMensaje("Cliente eliminado.");
            } catch (NumberFormatException ex) {
                mostrarMensaje("ID inválido para eliminar.");
            }
        });
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        correoField.setText("");
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
