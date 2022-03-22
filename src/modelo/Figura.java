/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.paint.Color;

/**
 *
 * @author Hector Fabio Romero
 */
public class Figura {
    Color colorRelleno;
    Color colorBorde;
    double grosor;

    public Figura(Color colorRelleno, Color colorBorde, double grosor) {
        this.colorRelleno = colorRelleno;
        this.colorBorde = colorBorde;
        this.grosor = grosor;
    }
    
    public Color getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public Color getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
    }

    public double getGrosor() {
        return grosor;
    }

    public void setGrosor(double grosor) {
        this.grosor = grosor;
    }

    @Override
    public String toString() {
        return "Figura{" + "colorRelleno=" + colorRelleno + ", colorBorde=" + colorBorde + ", grosor=" + grosor + '}';
    }
    
    
}
