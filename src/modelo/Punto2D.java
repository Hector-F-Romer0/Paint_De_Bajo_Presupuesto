/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author andres.aristizabal_m
 */
public class Punto2D {
    
    private double X;
    private double Y;

    public Punto2D() {
    }

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

    @Override
    public String toString() {
        return  X + "," + Y ;
    }
    
}
