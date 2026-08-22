/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_labprogra2;

/**
 *
 * @author denam
 */
public class revista extends Material{
     private int numeroEdicion;
    private periodicidad periodicidad;

    public revista(String titulo,  String codigo, estadoPrestamo estadoPrestamo, int diasMaximoPrestamo, nivelComplejidad nivelComplejidad, String rutaImagen,int numeroEdicion,periodicidad periodicidad) {

        super(titulo, codigo, estadoPrestamo, diasMaximoPrestamo,
              nivelComplejidad, rutaImagen);

        this.numeroEdicion = numeroEdicion;
        this.periodicidad = periodicidad;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }


    public periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    @Override
    public String descripcion() {
        return "Revista: " + getTitulo()+ "Número de edición: " + numeroEdicion + "Periodicidad: " + periodicidad + "Nivel de complejidad: " + getNivelComplejidad().getDescripcion();
    }

    @Override
    public int calcularDiasPrestamo() {

        int dias;

        switch (periodicidad) {

            case SEMANAL:
                dias = 5;
                break;

            case MENSUAL:
                dias = 14;
                break;

            case ANUAL:
                dias = 30;
                break;

            default:
                dias = getDiasMaximoPrestamo();
        }

        dias += getNivelComplejidad().getDiasAdicionales();

        return dias;
    }
}
