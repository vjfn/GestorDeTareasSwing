package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {
    private JPanel panel;
    private JTable table1;
    private JTextField txtTarea;
    private JComboBox comboPrioridad;
    private JTextField txtEstado;
    private JButton añadirButton;
    private JTextArea textArea1;
    private JLabel txtDescripcion;
    private DefaultTableModel datos;

    public Principal(){
        this.setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setTitle("Listado tareas");
        setResizable(false);
        setLocationRelativeTo(null);

        datos = (DefaultTableModel) table1.getModel();
        datos.addColumn("Tarea");
        datos.addColumn("Prioridad");
        datos.addColumn("Estado");
        datos.addColumn("Descripció");

//        JFrame frame = new JFrame ("Test");
//        JTextArea textArea = new JTextArea ("Test");
//
//        JScrollPane scroll = new JScrollPane (textArea,
//                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//
//        frame.add(scroll);
//        frame.setVisible (true);

        añadirButton.addActionListener(e -> {addToTable();});
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                readTable();
            }
        });
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


