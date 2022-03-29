/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Clase encargada de guardar las coordenadas de un punto en ámbito 2D.
 *
 * @author juliana.loaiza@uao.edu.co Juliana Loaiza Mejia Código 2205498
 * @author hector_fabio.romero@uao.edu.co Hector Fabio Romero Bocanegra Código
 * 2205024
 * @author andres.aristizabal_m@uao.edu.co Andrés Felipe Aristizabal Miranda
 * Código 2205296
 * @date 22 marzo 2022
 * @version 1.0
 */
public class Punto2D {

    private double X;
    private double Y;

    /**
     * Permite crear un objeto vacío de la clase Punto2D.
     */
    public Punto2D() {
    }

    /**
     * Permite crear un objeto de la clase Punto2D con coordenas en dos
     * dimensiones.
     *
     * @param x guarda la coordenada x del punto 2D
     * @param y guarda la coordenada y del punto 2D
     */
    public Punto2D(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    /**
     * Get the value of Y
     *
     * @return the value of Y
     */
    public double getY() {
        return Y;
    }

    /**
     * Set the value of Y
     *
     * @param Y new value of Y
     */
    public void setY(double Y) {
        this.Y = Y;
    }

    /**
     * Get the value of X
     *
     * @return the value of X
     */
    public double getX() {
        return X;
    }

    /**
     * Set the value of X
     *
     * @param X new value of X
     */
    public void setX(double X) {
        this.X = X;
    }

    /**
     * Genera una cadena de texto con los atributos del objeto de la clase
     * Punto2D.
     *
     * @return cadena de texto con los atributos del objeto.
     */
    @Override
    public String toString() {
        return X + "," + Y;
    }

}
