/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlGUI;


import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import modelo.Punto2D;

/**
 *
 * @author andres.aristizabal_m
 */
public class FXMLDocumentController implements Initializable {
      
    double x1[];
    double y1[];

    double coorX;
    double coorY;
    
    LinkedList<Punto2D> listaPuntos;
    
    @FXML
    private Canvas lienzo;
    
    @FXML
    private GraphicsContext g;
        
    @FXML
    private Pane panelFiguras;
   
    @FXML
    private ColorPicker colorRelleno;
    
    @FXML
    private ColorPicker colorMargen;
    
    @FXML
    private ImageView sun_jinwoo;
    
    
    @FXML
    private void crearHexagono(ActionEvent event) {
        System.out.println("El punto " + coorX + ", " + coorY);

        listaPuntos = new LinkedList<>();
        int r = 40;
        g.setStroke(colorRelleno.getValue());
        int numLados = 6;
        double angulo = (2 * Math.PI)/ numLados;
        
        double h = coorX;
        double k = coorY;
        x1 = new double[numLados];
        y1 = new double[numLados];
        x1[0] = h + r;
        y1[0] = k;
        
        System.out.println("Coordenada: 0" + "x: " + x1[0] + ", y: " + y1[0]);
     
        for (int i = numLados - 1; i > 0; i--) {
            double a = r * Math.sin(angulo * i);
            double b = r * Math.cos(angulo * i);
            
            x1[i] = b + h;
            y1[i] = a + k;
            System.out.println("Coordenada: " + i + "x: " + x1[i] + "y: " + y1[i]);
        }
        
        Punto2D puntoInicial = new Punto2D(x1[0], y1[0]);
        listaPuntos.add(puntoInicial);
        for (int i = 1; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);
        }
        // Se crea el polígono
        g.strokePolygon(x1, y1, numLados);
        g.setLineWidth(3);
        
        //HOLA
        
    }
    
//    @FXML
//    private void crearHeptagono(MouseEvent event) {
//        
//        coorX = event.getX();
//        coorY = event.getY();   
//        System.out.println("El punto " + coorX + ", " + coorY);
//    }
   
    @FXML
    private void crearCruz(ActionEvent event) {
        listaPuntos = new LinkedList<>();
        int r = 70;
        g.setStroke(colorRelleno.getValue());
        double v = (0.2*r);
        double w = (0.78*r);
        
        // Obtenemos las coordenadas del centro de la circunferencia donde incribiremos la cruz
        double h = coorX;
        double k = coorY;
        x1 = new double[12];
        y1 = new double[12];
        
        x1[0] = v+h;
        y1[0] = v+k;
        
        x1[1] = v+w+h;
        y1[1] = v+k;
        
        x1[2] = v+w+h;
        y1[2] = -v+k;
        
        x1[3] = v+h;
        y1[3] = -v+k;
        
        x1[4] = v+h;
        y1[4] = -v-w+k;
        
        x1[5] = -v+h;
        y1[5] = -v-w+k;
        
        x1[6] = -v+h;
        y1[6] = -v+k;
        
        x1[7] = -v-w+h;
        y1[7] = -v+k;
        
        x1[8] = -v-w+h;
        y1[8] = v+k;
        
        x1[9] = -v+h;
        y1[9] = v+k;
        
        x1[10] = -v+h;
        y1[10] = v+w+k;
        
        x1[11] = v+h;
        y1[11] = v+w+k;
        
        for (int i = 0; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);
            System.out.println("Coordenada: " + i + "x: " + x1[i] + "y: " + y1[i]);
        }
        
        // Se crea el polígono
        g.strokePolygon(x1, y1,12);
        g.setLineWidth(3);
    }
    
    @FXML
    private void obtenerCoordenadas(MouseEvent event) { 
        coorX = event.getX();
        coorY = event.getY();   
        System.out.println("El punto " + coorX + ", " + coorY);
    }
    
    public void saludar(){
        System.out.println("Hola");
        System.out.println("Esto es un segundo pull desde rama1");
        System.out.println("CALI TU PAPÁ");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        g = lienzo.getGraphicsContext2D();

        double alto = lienzo.getHeight();
        double largo = lienzo.getWidth();

        g.setStroke(Color.BLACK);
        g.setLineWidth(3);  
        g.strokeRect(0, 0, largo, alto); 
        
        
    }    
    
}
