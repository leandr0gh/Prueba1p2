/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_labprogra2;

/**
 *
 * @author denam
 */
public enum nivelComplejidad {

    BAJO(1, 0, "complejidad basica, util para novato"),
    MEDIO(2, 3, "complejidad intermedia, "),
    ALTO(3, 7, "alta complejidad, nivel restringido");

    private final int valorNumerico;
    private final int diasAdicionales;
    private final String descripcion;

    nivelComplejidad(int valorNumerico, int diasAdicionales, String descripcion) {
        this.valorNumerico = valorNumerico;
        this.diasAdicionales = diasAdicionales;
        this.descripcion = descripcion;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }

    public int getDiasAdicionales() {
        return diasAdicionales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean requiereAutorizacion() {
        return this == ALTO;
    }

}
