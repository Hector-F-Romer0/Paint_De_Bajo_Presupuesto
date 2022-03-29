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
 * Clase encargada de tomar y asignar atributos a las figuras
 *
 * @author juliana.loaiza@uao.edu.co Juliana Loaiza Mejia Código 2205498
 * @author hector_fabio.romero@uao.edu.co Hector Fabio Romero Bocanegra Código
 * 2205024
 * @author andres.aristizabal_m@uao.edu.co Andrés Felipe Aristizabal Miranda
 * Código 2205296
 * @date 25 marzo 2022
 * @version 1.0
 */
public class Figura {

    public String nombreFigura;
    public Color colorRelleno;
    public Color colorBorde;
    public double grosor;
    public LinkedList<Punto2D> listaPuntos;

    /**
     * Constructor el cual crea los objetos Figura
     * @param nombreFigura Contiene el nombre de la figura
     * @param colorRelleno Contiene el color del relleno de la figura
     * @param colorBorde Contiene el color del borde de la figura
     * @param grosor Contiene el tamaño de grosor del contorno de la figura
     * @param listaPuntos Contiene los puntos necesarios para crear la figura
     */
    public Figura(String nombreFigura, Color colorRelleno, Color colorBorde, double grosor, LinkedList<Punto2D> listaPuntos) {
        this.nombreFigura = nombreFigura;
        this.colorRelleno = colorRelleno;
        this.colorBorde = colorBorde;
        this.grosor = grosor;
        this.listaPuntos = listaPuntos;
    }

    /**
     * Permite crear un objeto vacío de la clase Figura.
     */
    
    public Figura() {
    }

    /**
     * Toma la cadena nombreFigura
     *
     * @return Retorna la cadena nombreFigura
     */
    public String getNombreFigura() {
        return nombreFigura;
    }

    /**
     * Asigna una cadena a nombreFigura
     *
     * @param nombreFigura nueva cadena nombreFigura
     */
    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    /**
     * Toma el color getColorRelleno
     *
     * @return Retorna el color getColorRelleno
     */
    public Color getColorRelleno() {
        return colorRelleno;
    }

    /**
     * Asigna un color a colorRelleno
     *
     * @param colorRelleno nuevo color colorRelleno
     */
    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    /**
     * Toma el color colorBorde
     *
     * @return Retorna el color colorBorde
     */
    public Color getColorBorde() {
        return colorBorde;
    }

    /**
     * Asigna un color a colorBorde
     *
     * @param colorBorde nuevo color Borde
     */
    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
    }

    /**
     * Toma el valor de grosor
     *
     * @return Retorna el valor de grosor
     */
    public double getGrosor() {
        return grosor;
    }

    /**
     * Asigna un valor a grosor
     *
     * @param grosor nuevo color grosor
     */
    public void setGrosor(double grosor) {
        this.grosor = grosor;
    }

    /**
     * Toma la lista de puntos de la figura
     * @return listaPuntos 
     */
    public LinkedList<Punto2D> getListaPuntos() {
        return listaPuntos;
    }

    /**
     * Asigna puntos a listaPuntos
     *
     * @param grosor nueva listaPuntos
     */
    public void setListaPuntos(LinkedList<Punto2D> listaPuntos) {
        this.listaPuntos = listaPuntos;
    }

    /**
     * Genera una cadena de texto con los atributos del objeto de la clase
     * Figura
     *
     * @return cadena de texto con los atributos del objeto.
     */
    @Override
    public String toString() {
        return "Figura{" + "nombreFigura=" + nombreFigura + ", colorRelleno=" + colorRelleno + ", colorBorde=" + colorBorde + ", grosor=" + grosor + ", listaPuntos=" + listaPuntos + '}';
    }
}
