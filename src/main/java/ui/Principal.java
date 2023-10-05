package ui;

import org.example.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class Principal extends JFrame {
    private JPanel panel;
    private JTable table1;
    private JTextField txtTarea;
    private JComboBox comboPrioridad;
    private JTextField txtEstado;
    private JButton añadirButton;
    private JTextArea textArea1;
    private JLabel txtDescripcion;
    private JLabel info;
    private DefaultTableModel datos;

    public Principal(){
        this.setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setTitle("Listado de tareas");
        setResizable(false);
        setLocationRelativeTo(null);

        datos = (DefaultTableModel) table1.getModel();
        datos.addColumn("Tarea");
        datos.addColumn("Prioridad");
        datos.addColumn("Estado");
        datos.addColumn("Descripció");

        loadUserData();
        table1.setModel(datos);

        info.setText("Bienvenido "+ Session.getUsername());

        //JMenuBar
        var menuBar = new JMenuBar();
        var menu = new JMenu("Archivo");

        var menuItem0 = new JMenuItem("Guardar");
        menu.add(menuItem0);
        menu.addSeparator();

        var menuItem1 = new JMenuItem("Logout");
        menu.add(menuItem1);
        menu.addSeparator();

        var menuItem2 = new JMenuItem(("Salir"));
        menu.add(menuItem2);
        menu.addSeparator();


        menuBar.add(menu);

        setJMenuBar(menuBar);

        menuItem0.addActionListener(e -> actionMenuGuardar() );
        menuItem1.addActionListener(e -> actionMenu1() );
        menuItem2.addActionListener(e -> actionMenu2() );


        añadirButton.addActionListener(e -> {addToTable();});
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                readTable();
                (new Login()).load();
            }
        });
    }

    private void actionMenuGuardar() {
        String f = Session.getUsername() + ".obj";
        try (var oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(datos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadUserData() {
        String f = Session.getUsername() + ".obj";
        try (var ois = new ObjectInputStream(new FileInputStream("f"))) {
            datos = (DefaultTableModel) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void actionMenu2() {
        System.exit(0);
    }

    private void actionMenu1() {
        Session.setUsername(null);
        this.dispose();
        (new Login()).load();

    }

    private void readTable(){
        var selected = table1.getSelectedRow();
        System.out.println(selected);
        System.out.println(datos.getValueAt(selected, 0));
        System.out.println(datos.getValueAt(selected, 1));
        System.out.println(datos.getValueAt(selected, 2));
        System.out.println(datos.getValueAt(selected, 3));
    }
    private void addToTable(){
        String tarea = txtTarea.getText();
        String prioridad = (String) comboPrioridad.getSelectedItem();
        String estado = txtEstado.getText();
        String descripcion = txtDescripcion.getText();

        System.out.println(tarea);
        System.out.println(prioridad);
        System.out.println(estado);
        System.out.println(descripcion);

        String[] dato = {tarea,prioridad,estado,descripcion};
        datos.addRow(dato);
    };
    public void load(){
        setVisible(true);
    }



}


