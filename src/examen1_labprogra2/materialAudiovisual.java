/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_labprogra2;

/**
 *
 * @author denam
 */
public class materialAudiovisual extends Material{
    
    private int duracionMinutos;
    private formatoAudiovisual formato;

    public materialAudiovisual(String titulo, String ID, estadoPrestamo estadoPrestamo, int diasMaximoPrestamo, nivelComplejidad nivelComplejidad, String rutaImagen,int duracionMinutos,  formatoAudiovisual formato) {

        super(titulo, ID, estadoPrestamo, diasMaximoPrestamo,
              nivelComplejidad, rutaImagen);

        this.duracionMinutos = duracionMinutos;
        this.formato = formato;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public formatoAudiovisual getFormato() {
        return formato;
    }

    public void setFormato(formatoAudiovisual formato) {
        this.formato = formato;
    }

    @Override
    public String descripcion() {
        return "Material audiovisual: " + getTitulo() + "Duración: " + duracionMinutos + " minutos" + "Formato: " + formato+ "Nivel de complejidad: "+ getNivelComplejidad().getDescripcion();
    }

    @Override
    public int calcularDiasPrestamo() {

        int dias;

        if (duracionMinutos > 120) {
            dias = 3;
        } else if (duracionMinutos > 60) {
            dias = 5;
        } else {
            dias = 7;
        }

        if (formato == formatoAudiovisual.BLU_RAY) {
            dias += 1;
        }

        dias += getNivelComplejidad().getDiasAdicionales();

        return dias;
    }
}
