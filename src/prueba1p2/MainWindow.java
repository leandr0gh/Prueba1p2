
package prueba1p2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class MainWindow extends JFrame{
    private JTextField campoRuta;
    private JTextField campoBusqueda;
    private JButton botonAnalizar;
    private JTextArea areaResultado;
    
    //counters
    private int contadortxt;
    private int contadorjava;
    private int contadorPdf;
    private int contadorOtros;
    
    public MainWindow(){
        setTitle("Analizador de Sistema de Archivos");
        setSize(700,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(crearPanelEntrada(), BorderLayout.NORTH);
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        add(scroll, BorderLayout.CENTER);
    }
    
    private JPanel crearPanelEntrada(){
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 0;
    panel.add(new JLabel("Ruta de directorio: "),gbc);
    
    campoRuta = new JTextField(25);
    gbc.gridx = 1;
    gbc.weightx = 1;
    panel.add(campoRuta,gbc);
    
    JButton botonExaminar = new JButton("Examinar");
    gbc.gridx = 2;
    gbc.weightx = 0;
    panel.add(botonExaminar,gbc);
    
    gbc.gridx = 1;
    gbc.gridy = 1;
    panel.add(new JLabel("Texto para buscar"),gbc);
    
    campoBusqueda = new JTextField(25);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 1;
    panel.add(campoBusqueda, gbc);
    
    botonAnalizar = new JButton("Analizar");
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.weightx = 0;
    gbc.anchor = GridBagConstraints.CENTER;
    panel.add(botonAnalizar,gbc);
    
    return panel;
    }
    
    private void seleccionarDirectorio(){
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int resultado = chooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            campoRuta.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }
}
