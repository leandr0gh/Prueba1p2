
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
    return panel;
    }
}
