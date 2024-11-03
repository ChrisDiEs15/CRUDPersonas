/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudpersonas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Chris
 */
public class VentanaCrud extends JFrame {
    private final JPanel panelPrincipal;
    private JPanel panelLeerInstitucion, panelCrear, panelActualizar, panelEliminar, panelMostrar;
    private final CRUDAcciones crudAcciones;
    private Institucion ultimaInstitucionCreada; // Campo para almacenar la última institución creada

    
    public VentanaCrud(){
        crudAcciones = new CRUDAcciones();
        setTitle("CRUD de Personas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel principal con las opciones del CRUD
        panelPrincipal = new JPanel();
        //Layout panel principal
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        JButton botonLeer = new JButton("Leer Institucion");
        JButton botonCrear = new JButton("Crear Nueva Institucion");
        JButton botonActualizar = new JButton("Actualizar Institucion");
        JButton botonEliminar = new JButton("Eliminar Institucion");
        JButton botonMostrar = new JButton("Mostrar todas las Instituciones");
        
        botonLeer.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonActualizar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Acciónes  al presionar los botones
        botonLeer.addActionListener((ActionEvent e) -> {
            mostrarpanelLeerInstitucion();
        });
        botonCrear.addActionListener((ActionEvent e) -> {
            mostrarPanelCrear();
        });
        botonActualizar.addActionListener((ActionEvent e) -> {
            mostrarPanelActualizar();
        });
        botonEliminar.addActionListener((ActionEvent e) -> {
            mostrarPanelEliminar();
        });
        botonMostrar.addActionListener((ActionEvent e) -> {
            mostrarPanelMostrar();
        });

        //Agrega botones al panel principal
        panelPrincipal.add(botonLeer);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(botonCrear);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(botonActualizar);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(botonEliminar);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(botonMostrar);

        // Crear Instancias de los albumes
        crearpanelLeerInstitucion();
        crearPanelEliminar();
        CrearPanelCrear();

        /**/
        // Añadir el panel principal por defecto
        add(panelPrincipal);
    
    }
    
        // Métododos que sobreescriben el panel principal
    private void mostrarpanelLeerInstitucion() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelLeerInstitucion);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
    }

    private void mostrarPanelCrear() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelCrear);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
    }

    private void mostrarPanelActualizar() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelActualizar);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
    }

    private void mostrarPanelEliminar() {
       
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelEliminar);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
        
        
    }

    private void mostrarPanelMostrar() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelMostrar);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
    }

    // Método para crear el panel de leer álbum
    private void crearpanelLeerInstitucion() {
        panelLeerInstitucion = new JPanel();

        JLabel labelId = new JLabel("ID de la institucion:");
        JTextField inputId = new JTextField(5);
        JButton botonBuscar = new JButton("Buscar");
        JTextArea areaResultado = new JTextArea(5, 20);
        areaResultado.setEditable(false);

        // Botón para volver al panel principal
        JButton botonVolver = new JButton("Volver al menú principal");
        botonVolver.addActionListener((ActionEvent e) -> {
            getContentPane().removeAll();
            add(panelPrincipal);
            revalidate();
            repaint();
        });

        // Acción al presionar el botón "Buscar"
        botonBuscar.addActionListener((ActionEvent e) -> {
            int idLeer = Integer.parseInt(inputId.getText());
            Institucion institucionLeida = crudAcciones.select(idLeer);
            if (institucionLeida != null) {
                areaResultado.setText("InstitucionLeida: " + institucionLeida);
            } else {
                areaResultado.setText("La institucion con Id " + idLeer + " no existe.");
            }
        });

        // Agregar componentes al panel de leer álbum
        panelLeerInstitucion.add(labelId);
        panelLeerInstitucion.add(inputId);
        panelLeerInstitucion.add(botonBuscar);
        panelLeerInstitucion.add(new JLabel());  // Espacio vacío
        panelLeerInstitucion.add(areaResultado);
        panelLeerInstitucion.add(botonVolver);
    }

    //panel
    @SuppressWarnings("empty-statement")
    private void CrearPanelCrear(){
        panelCrear = new JPanel();
        JLabel labelId = new JLabel("ID de la institucion:");
        JTextField inputId = new JTextField(5);
        JLabel labelDireccion = new JLabel("Direccion de la institucion:");
        JTextField inputDireccion = new JTextField(5);
        JLabel labelNombre = new JLabel("Nombre de la institucion");
        JTextField inputNombre = new JTextField(5);
        JLabel labelAno = new JLabel("ano de creacion");
        JTextField inputYear = new JTextField(5);
        JLabel labelTelefono = new JLabel("Telefono de la institucion");
        JTextField inputTelefono = new JTextField(5);
        JLabel labelPersonasNum = new JLabel("Numero de personas a afiliar a la institucion");
        JTextField inputPersonasNum = new JTextField(5);
        JButton botonSiguiente = new JButton("Siguiente");
        JButton botonVolver = new JButton("Volver al menú principal");
        
    // Acciones de los botones
        botonVolver.addActionListener((ActionEvent e) -> {
            getContentPane().removeAll();
            add(panelPrincipal);
            revalidate();
            repaint();
        });
        
    botonSiguiente.addActionListener((ActionEvent e) -> {
        try {
            int id = Integer.parseInt(inputId.getText());
            String direccion = inputDireccion.getText();
            String nombre = inputNombre.getText();
            int year = Integer.parseInt(inputYear.getText());
            String telefono = inputTelefono.getText();
            int numPersonas = Integer.parseInt(inputPersonasNum.getText());
            List<Persona> personas = new ArrayList<>(numPersonas);
            
            // Crear la institución con los datos obtenidos
            ultimaInstitucionCreada = new Institucion(id, nombre, year, direccion, telefono, personas);
            crudAcciones.insertar(ultimaInstitucionCreada);

            // Mostrar mensaje de éxito y capturar la opción
            int opcion = JOptionPane.showConfirmDialog(this, "Institución creada con éxito", "Información", JOptionPane.OK_CANCEL_OPTION);
            
            // Verificar si se presionó el botón "OK"
            if (opcion == JOptionPane.OK_OPTION) {
                // Mostrar la segunda ventana
                crearPanelPersonas(numPersonas);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa valores válidos");
        }
    });


        
        panelCrear.add(labelId);
        panelCrear.add(inputId);
        panelCrear.add(labelDireccion);
        panelCrear.add(inputDireccion);
        panelCrear.add(labelNombre);
        panelCrear.add(inputNombre);
        panelCrear.add(labelAno);
        panelCrear.add(inputYear);
        panelCrear.add(labelTelefono);
        panelCrear.add(inputTelefono);
        panelCrear.add(labelPersonasNum);
        panelCrear.add(inputPersonasNum);
        panelCrear.add(botonSiguiente);
        panelCrear.add(botonVolver);
    }
private void crearPanelPersonas(int numeroPersonas) {
    JPanel panelPersonas = new JPanel();
    panelPersonas.setLayout(new BoxLayout(panelPersonas, BoxLayout.Y_AXIS));

    // Lista para almacenar las personas
    List<Persona> personas = new ArrayList<>(numeroPersonas);

    for (int i = 0; i < numeroPersonas; i++) {
        // Crear campos de entrada para cada persona
        JTextField inputId = new JTextField(10);
        JTextField inputNombre = new JTextField(5);
        JTextField inputaPaterno = new JTextField(10);
        JTextField inputaMaterno = new JTextField(10);
        JTextField inputEdad = new JTextField(10);

        // Crear un botón para agregar cada persona
        JButton botonAgregarPersona = new JButton("Agregar Persona " + (i + 1));
        
        botonAgregarPersona.addActionListener((ActionEvent e) -> {
            try {
                int id = Integer.parseInt(inputId.getText());
                String nombre = inputNombre.getText();
                String aPaterno = inputaPaterno.getText();
                String aMaterno = inputaMaterno.getText();
                int edad = Integer.parseInt(inputEdad.getText());
                
                // Crear una nueva persona
                Persona nuevaPersona = new Persona(id, nombre, aPaterno, aMaterno, edad);
                personas.add(nuevaPersona);
                
                // Limpiar los campos después de agregar
                inputNombre.setText("");
                inputEdad.setText("");
                inputaPaterno.setText("");
                inputaMaterno.setText("");

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Persona agregada con éxito.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa una edad válida.");
            }
        });

        // Agregar componentes al panel
        panelPersonas.add(new JLabel("Nombre de la Persona " + (i + 1) + ":"));
        panelPersonas.add(inputNombre);
        panelPersonas.add(new JLabel("Apellido Paterno:"));
        panelPersonas.add(inputaPaterno);
        panelPersonas.add(new JLabel("Apellido Materno:"));
        panelPersonas.add(inputaMaterno);
        panelPersonas.add(new JLabel("Edad:"));
        panelPersonas.add(inputEdad);
        panelPersonas.add(botonAgregarPersona);
        panelPersonas.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado
    }

    // Botón para finalizar la adición de personas
    JButton botonFinalizar = new JButton("Finalizar");
    botonFinalizar.addActionListener((ActionEvent e) -> {
        // Asociar la lista de personas a la institución
        ultimaInstitucionCreada.setPersonas(personas); // Asegúrate de tener un método setPersonas en Institucion
        crudAcciones.update(ultimaInstitucionCreada); // Asegúrate de implementar este método

        // Volver al menú principal después de finalizar
        getContentPane().removeAll();
        add(panelPrincipal);
        revalidate();
        repaint();
        JOptionPane.showMessageDialog(this, "Proceso completado. Regresando al menú principal.");
    });

    panelPersonas.add(botonFinalizar);

    // Mostrar el nuevo panel de personas
    getContentPane().removeAll();
    add(panelPersonas);
    revalidate();
    repaint();
}
     
    
    private void crearPanelEliminar(){
     panelEliminar = new JPanel();
        
        JLabel labelId = new JLabel("ID de la institucion:");
        JTextField inputId = new JTextField(5);
        JButton botonEliminar = new JButton("Eliminar");
        JTextArea areaResultado = new JTextArea(5, 20);
        areaResultado.setEditable(false);
        
        JButton botonVolver = new JButton("Volver al menú principal");
        botonVolver.addActionListener((ActionEvent e) -> {
            getContentPane().removeAll();
            add(panelPrincipal);
            revalidate();
            repaint();
        });
        
        botonEliminar.addActionListener((ActionEvent e) ->{
        int idLeer = Integer.parseInt(inputId.getText());
        Institucion institucionLeida = crudAcciones.select(idLeer);
        if (institucionLeida != null) {
                areaResultado.setText(institucionLeida+"se eliminara a continuacion");
                crudAcciones.delete(idLeer);
                areaResultado.setText("La institucion se ha eliminado con exito");
            } else {
                areaResultado.setText("La institucion con Id " + idLeer + " no existe.");
            }
        
        });
        panelEliminar.add(labelId);
        panelEliminar.add(inputId);
        panelEliminar.add(botonEliminar);
        panelEliminar.add(new JLabel());  // Espacio vacío
        panelEliminar.add(areaResultado);
        panelEliminar.add(botonVolver);
    }
    
}