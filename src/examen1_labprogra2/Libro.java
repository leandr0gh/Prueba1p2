/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_labprogra2;

/**
 *
 * @author denam
 */
public class Libro extends Material {
    
     
    private String autor;
    private int numeroPaginas;
    private String isbn;

    public Libro(String titulo,String codigo, estadoPrestamo estadoPrestamo, int diasMaximoPrestamo, nivelComplejidad nivelComplejidad, String rutaImagen,String autor,int numeroPaginas,String isbn) {

        super(titulo, codigo, estadoPrestamo, diasMaximoPrestamo,
              nivelComplejidad, rutaImagen);

        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

  

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

 

    public String getIsbn() {
        return isbn;
    }

  
    @Override
    public String descripcion() {
        return "Libro: " + getTitulo() + "Autor: " + autor  + " Número de páginas: " + numeroPaginas  + "ISBN: " + isbn  + "Nivel de complejidad: "  + getNivelComplejidad().getDescripcion();
    }

    @Override
    public int calcularDiasPrestamo() {

        int dias = getDiasMaximoPrestamo();

        if (numeroPaginas > 500) {
            dias += 5;
        } else if (numeroPaginas > 300) {
            dias += 3;
        }

        dias += getNivelComplejidad().getDiasAdicionales();

        return dias;
    }
}
