/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Punto2D;
import java.util.LinkedList;
import javafx.scene.paint.Color;

/**
 *
 * @author Hector Fabio Romero
 */
public class Figura {
    
    String nombreFigura;
    Color colorRelleno;
    Color colorBorde;
    double grosor;
    LinkedList<Punto2D> listaPuntos;

    public Figura(String nombreFigura, Color colorRelleno, Color colorBorde, double grosor, LinkedList<Punto2D> listaPuntos) {
        this.nombreFigura = nombreFigura;
        this.colorRelleno = colorRelleno;
        this.colorBorde = colorBorde;
        this.grosor = grosor;
        this.listaPuntos = listaPuntos;
    }


    public Figura() {
    }
    
    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
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

    public LinkedList<Punto2D> getListaPuntos() {
        return listaPuntos;
    }

    public void setListaPuntos(LinkedList<Punto2D> listaPuntos) {
        this.listaPuntos = listaPuntos;
    }

    @Override
    public String toString() {
        return "Figura{" + "nombreFigura=" + nombreFigura + ", colorRelleno=" + colorRelleno + ", colorBorde=" + colorBorde + ", grosor=" + grosor + ", listaPuntos=" + listaPuntos + '}';
    }   
}
