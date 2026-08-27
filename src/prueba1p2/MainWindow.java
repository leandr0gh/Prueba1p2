
package prueba1p2;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    botonExaminar.addActionListener(e -> seleccionarDirectorio());
    
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
    
    private void hacerAnalisis(){
    String ruta = campoRuta.getText().trim();
    String textoBusqueda = campoBusqueda.getText().trim();
    
    File directorioRaiz = validarDirectorio(ruta);
        if (directorioRaiz == null){
        return;
        }
        
        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un texto de busqueda", "Dato faltante", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        contadortxt = 0;
        contadorjava = 0;
        contadorPdf = 0;
        contadorOtros = 0;
        
        contarArchivosPorTipo(directorioRaiz);
        
        List<String> archivosEncontrados = new ArrayList<>();
        buscarArchivosPorNombre(directorioRaiz, textoBusqueda, archivosEncontrados);
 
        mostrarResultados(directorioRaiz, textoBusqueda, archivosEncontrados);
        
    }
    
    private File validarDirectorio(String ruta) {
        if (ruta.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar una ruta de directorio.",
                    "Dato faltante",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }
 
        File directorio = new File(ruta);
 
        if (!directorio.exists()) {
            JOptionPane.showMessageDialog(this,
                    "La ruta introducida no existe en el sistema.",
                    "Ruta inválida",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
 
        if (!directorio.isDirectory()) {
            JOptionPane.showMessageDialog(this,
                    "La ruta introducida corresponde a un archivo, no a un directorio.",
                    "Ruta inválida",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
 
        return directorio;
    }
    
    private void contarArchivosPorTipo(File directorio) {
        File[] contenido = directorio.listFiles();
 
        if (contenido == null) {
            return;
        }
 
        for (File elemento : contenido) {
            if (elemento.isDirectory()) {
                contarArchivosPorTipo(elemento);
            } else {
                clasificarArchivo(elemento);
            }
        }
    }
    
    private void clasificarArchivo(File archivo) {
        String nombre = archivo.getName().toLowerCase();
 
        if (nombre.endsWith(".txt")) {
            contadortxt++;
        } else if (nombre.endsWith(".java")) {
            contadorjava++;
        } else if (nombre.endsWith(".pdf")) {
            contadorPdf++;
        } else {
            contadorOtros++;
        }
    }
    
    private void buscarArchivosPorNombre(File directorio, String textoBusqueda, List<String> resultados){
    File[] contenido = directorio.listFiles();
    
        if (contenido == null) {
            return;
        }
        
        String textoMinusculas = textoBusqueda.toLowerCase();
        
        for (File elemento : contenido) {
            if (elemento.isDirectory()) {
                buscarArchivosPorNombre(elemento, textoBusqueda, resultados);
            } else if (elemento.getName().toLowerCase().contains(textoMinusculas)) {
                resultados.add(elemento.getAbsolutePath());
            }
        }
    }
    
    
     private void mostrarResultados(File directorioRaiz, String textoBusqueda, List<String> archivosEncontrados) {
        StringBuilder sb = new StringBuilder();
 
        sb.append(" ANÁLISIS ").append(directorioRaiz.getAbsolutePath()).append(" ===\n\n");
 
        sb.append("--- CONTEO DE ARCHIVOS POR TIPO ---\n");
        sb.append(String.format("TXT: ", contadortxt));
        sb.append(String.format("JAVA: ", contadorjava));
        sb.append(String.format("PDF: ", contadorPdf));
        sb.append(String.format("OTROS: ", contadorOtros));
 
        int total = contadortxt + contadorjava + contadorPdf + contadorOtros;
        sb.append(String.format("TOTAL: ", total));
 
        sb.append("--- BÚSQUEDA POR NOMBRE: \"").append(textoBusqueda).append("\" ---\n");
        if (archivosEncontrados.isEmpty()) {
            sb.append("No se encontraron archivos que coincidan con los criterios.\n");
        } else {
            sb.append(String.format("Se encontraron  coincidencia(s):", archivosEncontrados.size()));
            for (String ruta : archivosEncontrados) {
                sb.append(ruta).append("\n");
            }
        }
 
        areaResultado.setText(sb.toString());
        areaResultado.setCaretPosition(0);
    }
    
}
