/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_labprogra2;

/**
 *
 * @author denam
 */
import javax.swing.*;
import java.awt.Image;
public abstract class Material {
    
    protected String titulo;
    protected String ID;
    protected estadoPrestamo estadoPrestamo;
    protected int diasMaximoPrestamo;
    protected nivelComplejidad nivelComplejidad;
    protected String rutaImagen;

    public Material(String titulo,String codigo, estadoPrestamo estadoPrestamo,int diasMaximoPrestamo, nivelComplejidad nivelComplejidad,String rutaImagen) {

        this.titulo = titulo;
        this.ID = codigo;
        this.estadoPrestamo = estadoPrestamo;
        this.diasMaximoPrestamo = diasMaximoPrestamo;
        this.nivelComplejidad = nivelComplejidad;
        this.rutaImagen = rutaImagen;
    }

    public String getTitulo() {
        return titulo;
    }

 

    public String getCodigo() {
        return ID;
    }

   
    public estadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(estadoPrestamo estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public int getDiasMaximoPrestamo() {
        return diasMaximoPrestamo;
    }

    public void setDiasMaximoPrestamo(int diasMaximoPrestamo) {
        this.diasMaximoPrestamo = diasMaximoPrestamo;
    }

    public nivelComplejidad getNivelComplejidad() {
        return nivelComplejidad;
    }

    public void setNivelComplejidad(nivelComplejidad nivelComplejidad) {
        this.nivelComplejidad = nivelComplejidad;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

   

    public abstract String descripcion();

    public abstract int calcularDiasPrestamo();

}
