/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlGUI;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
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
import javafx.scene.shape.ArcType;
import modelo.ManejadorArchivos;
import modelo.Punto2D;

/**
 *
 * @author andres.aristizabal_m
 */
public class FXMLDocumentController implements Initializable {
     
    private GraphicsContext g;
    
    double x1[];
    double y1[];

    double coorX;
    double coorY;
    
    int contadorEstrella;
    int contadorEstrella2;
    int contadorHexagono;
    int contadorHeptagono;
    int contadorOctagono;
    int contadorDecagono;
    int contadorFlecha;
    int contadorCruz;
    int contadorPacman;
    int contadorCurva;
    
    LinkedList<Punto2D> listaPuntos;
    HashMap<String, LinkedList<Punto2D>> mapTaller2;
    
    @FXML
    private Canvas lienzo;
           
    @FXML
    private Pane panelFiguras;
   
    @FXML
    private ColorPicker colorRelleno;
    
    @FXML
    private ColorPicker colorMargen;
    
    @FXML
    private ImageView sun_jinwoo;
    
    
    @FXML
    private void crearEstrella(ActionEvent event) {
    
        listaPuntos = new LinkedList<>();
        int r = 100;        
        double h = coorX;
        double k = coorY;
        
        x1 = new double[10];
        y1 = new double[10];
        
        x1[0] = h;
        y1[0] = k+r;
        
        x1[1] = (0.22*r) + h;
        y1[1] = (0.31*r) + k;
        
        x1[2] = (0.95*r) + h;
        y1[2] = (0.31*r) + k;
        
        x1[3] = (0.36*r) + h;
        y1[3] = (-0.12*r) + k;
        
        x1[4] = (0.59*r) + h;
        y1[4] = (-0.81*r) + k;
        
        x1[5] = h;
        y1[5] = (-0.38*r) + k;
        
        x1[6] = (-0.59*r) + h;
        y1[6] = (-0.81*r) + k;
        
        x1[7] = (-0.36*r) + h;
        y1[7] = (-0.12*r) + k;
        
        x1[8] = (-0.95*r) + h;
        y1[8] = (0.31*r) + k;
        
        x1[9] = (-0.22*r) + h;
        y1[9] = (0.31*r) + k;
        
        for (int i = 0; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.add(punto);
            System.out.println("Coordenada: " + i + "x: " + x1[i] + "y: " + y1[i]);
        }  
        g.setStroke(colorRelleno.getValue());
        g.setLineWidth(3);
        g.strokePolygon(x1, y1, 10);
        
        contadorEstrella ++;
        mapTaller2.put("Estrella de 5 puntas #" + contadorEstrella, listaPuntos);
        asignarValores(event);
    }
    
    @FXML
    private void crearEstrella2(ActionEvent event) {
    
        listaPuntos = new LinkedList<>();
        int r = 70;
        g.setStroke(colorRelleno.getValue());
        double h = coorX;
        double k = coorY;
        x1 = new double[12];
        y1 = new double[12];
        
        x1[0] = h;
        y1[0] = r + k;
        
        x1[1] = (0.29*r) + h;
        y1[1] = (0.5*r) + k;
        
        x1[2] = (0.87*r) + h;
        y1[2] = (0.5*r) + k;
        
        x1[3] = (0.58*r) + h;
        y1[3] = k;
        
        x1[4] = (0.87*r) + h;
        y1[4] = -(0.5*r) + k;
        
        x1[5] = (0.29*r) + h;
        y1[5] = -(0.5*r) + k;
        
        x1[6] = h;
        y1[6] = -r + k;
        
        x1[7] = -(0.29*r) + h;
        y1[7] = -(0.5*r) + k;
        
        x1[8] = -(0.87*r) + h;
        y1[8] = -(0.5*r) + k;
        
        x1[9] = -(0.58*r) + h;
        y1[9] = k;
        
        x1[10] = -(0.87*r) + h;
        y1[10] = (0.5*r) + k;
        
        x1[11] = -(0.29*r) + h;
        y1[11] = (0.5*r) + k;
        
        for (int i = 0; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);
            System.out.println("Coordenada: " + i + "x: " + x1[i] + "y: " + y1[i]);
        }
        g.setLineWidth(3);
        g.strokePolygon(x1, y1,12);
        
        contadorEstrella2 ++;
        mapTaller2.put("Estrella de 6 puntas #" + contadorEstrella2, listaPuntos);
        asignarValores(event);
    }
    
    @FXML
    private void crearHexagono(ActionEvent event) {

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
     
        for (int i = numLados - 1; i > 0; i--) {
            double a = r * Math.sin(angulo * i);
            double b = r * Math.cos(angulo * i);
            
            x1[i] = b + h;
            y1[i] = a + k;
        }
        
        Punto2D puntoInicial = new Punto2D(x1[0], y1[0]);
        listaPuntos.add(puntoInicial);
        for (int i = 1; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);
        }
        g.setLineWidth(3);
        g.strokePolygon(x1, y1, numLados);
        
        contadorHexagono ++;
        mapTaller2.put("Hexágono #" + contadorHexagono, listaPuntos);
        asignarValores(event);
    }
    
    @FXML
    private void crearHeptagono(ActionEvent event) {
        
        listaPuntos = new LinkedList<>();
        int r = 40;
        g.setStroke(colorRelleno.getValue());
        int numLados = 7;
        double angulo = (2 * Math.PI)/ numLados;
        
        double h = coorX;
        double k = coorY;
        x1 = new double[numLados];
        y1 = new double[numLados];
        x1[0] = h + r;
        y1[0] = k;
     
        for (int i = numLados - 1; i > 0; i--) {
            double a = r * Math.sin(angulo * i);
            double b = r * Math.cos(angulo * i);
            
            x1[i] = b + h;
            y1[i] = a + k;
        }
        
        Punto2D puntoInicial = new Punto2D(x1[0], y1[0]);
        listaPuntos.add(puntoInicial);
        for (int i = 1; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);
        }
        g.setLineWidth(3);
        g.strokePolygon(x1, y1, numLados);
        
        contadorHeptagono ++;
        mapTaller2.put("Heptágono #" + contadorHeptagono, listaPuntos);
        asignarValores(event);
    }
   
    @FXML
    private void crearOctagono(ActionEvent event) {
    
        listaPuntos = new LinkedList<>();
        int r = 40;
        g.setStroke(colorRelleno.getValue());
        int numLados = 8;
        double angulo = (2 * Math.PI)/ numLados;
        
        double h = coorX;
        double k = coorY;
        x1 = new double[numLados];
        y1 = new double[numLados];
        x1[0] = h + r;
        y1[0] = k;
     
        for (int i = numLados - 1; i > 0; i--) {
            double a = r * Math.sin(angulo * i);
            double b = r * Math.cos(angulo * i);
            
            x1[i] = b + h;
            y1[i] = a + k;
        }
        
        Punto2D puntoInicial = new Punto2D(x1[0], y1[0]);
        listaPuntos.add(puntoInicial);
        for (int i = 1; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);
        }
        g.setLineWidth(3);
        g.strokePolygon(x1, y1, numLados);
        
        contadorOctagono ++;
        mapTaller2.put("Octágono #" + contadorOctagono, listaPuntos);
        asignarValores(event);
    }
    
    @FXML
    private void crearDecagono(ActionEvent event) {
    
        listaPuntos = new LinkedList<>();
        int r = 40;
        g.setStroke(colorRelleno.getValue());
        int numLados = 10;
        double angulo = (2 * Math.PI)/ numLados;
        
        double h = coorX;
        double k = coorY;
        x1 = new double[numLados];
        y1 = new double[numLados];
        x1[0] = h + r;
        y1[0] = k;
     
        for (int i = numLados - 1; i > 0; i--) {
            double a = r * Math.sin(angulo * i);
            double b = r * Math.cos(angulo * i);
            
            x1[i] = b + h;
            y1[i] = a + k;
        }
        
        Punto2D puntoInicial = new Punto2D(x1[0], y1[0]);
        listaPuntos.add(puntoInicial);
        for (int i = 1; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);
        }
        g.setLineWidth(3);
        g.strokePolygon(x1, y1, numLados);
        
        contadorDecagono ++;
        mapTaller2.put("Decágono #" + contadorDecagono, listaPuntos);
        asignarValores(event);
    }
    
    @FXML
    private void crearFlecha(ActionEvent event) {
           
        listaPuntos = new LinkedList<>();
        int r = 100;        
        double v = (r/4);
        double w = (r/2);
        double u = (0.03*r);
        double h = coorX;
        double k = coorY;
        
        x1 = new double[7];
        y1 = new double[7];
        
        x1[0] = v+h;
        y1[0] = v+k;
        
        x1[1] = v+h;
        y1[1] = w+k;
        
        x1[2] = r+h;
        y1[2] = k;
        
        x1[3] = v+h;
        y1[3] = -w+k;
        
        x1[4] = v+h;
        y1[4] = -v+k;
        
        x1[5] = -r+u+h;
        y1[5] = -v+k;
        
        x1[6] = -r+u+h;
        y1[6] = v+k;
        
        for (int i = 0; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);
            System.out.println("Coordenada: " + i + "x: " + x1[i] + "y: " + y1[i]);
        }  
        g.setStroke(colorRelleno.getValue());
        g.setLineWidth(3);
        g.strokePolygon(x1, y1, 7);
        
        contadorFlecha ++;
        mapTaller2.put("Fleha #" + contadorFlecha, listaPuntos);
        asignarValores(event);
    }
   
    @FXML
    private void crearCruz(ActionEvent event) {
        
        listaPuntos = new LinkedList<>();
        int r = 70;
        g.setStroke(colorRelleno.getValue());
        double v = (0.2*r);
        double w = (0.78*r);
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
        g.setLineWidth(3);
        g.strokePolygon(x1, y1,12);
        
        contadorCruz ++;
        mapTaller2.put("Cruz #" + contadorCruz, listaPuntos);
        asignarValores(event);
    }
    
    @FXML
    private void crearPacman(ActionEvent event) {
    
        listaPuntos = new LinkedList<>();
        int r = 100; 
        g.setStroke(colorRelleno.getValue());
        double x = coorX;
        double y = coorY;
        x1 = new double[3];
        y1 = new double[3];
        for (int i = 0; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);
            System.out.println("Coordenada: " + i + "x: " + x1[i] + "y: " + y1[i]);
        }
        g.setLineWidth(3);
        g.strokeArc(x, y, r, r, 60, 270, ArcType.ROUND);
        
        contadorPacman ++;
        mapTaller2.put("Pacman #" + contadorPacman, listaPuntos);
        asignarValores(event);
    }
       
    @FXML
    private void crearCurva(ActionEvent event) {
    
        
    }
    
    @FXML
    private void obtenerCoordenadas(MouseEvent event) { 
        
        coorX = event.getX();
        coorY = event.getY();   
        System.out.println("El punto " + coorX + ", " + coorY);
    }
      
    @FXML
    private void borrarTodo(ActionEvent event) {
        
        g.clearRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
        g.setStroke(Color.BLACK);
        g.setLineWidth(3);  
        g.strokeRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
    }
    
    private void asignarValores(ActionEvent event) {
       
        Iterator<Map.Entry<String, LinkedList<Punto2D>>> entries = mapTaller2.entrySet().iterator();
        
        while (entries.hasNext()) {
            Map.Entry<String, LinkedList<Punto2D>> entry = entries.next();
            System.out.println(entry.getKey());
             
                for (int i = 0; i < entry.getValue().size(); i++) {
                    Punto2D get = entry.getValue().get(i);  
                    System.out.println("Puntos "+get.toString()+"\n");
                }               
        }
    }      
   
    @FXML
    private void guardar(ActionEvent event) {

        boolean t = ManejadorArchivos.guardarFiguras(mapTaller2);
        if (t == true ){
            System.out.println("Se guardó");
        }else{
            System.out.println("No se guardó");
        }       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        g = lienzo.getGraphicsContext2D();

        double alto = lienzo.getHeight();
        double largo = lienzo.getWidth();

        g.setStroke(Color.BLACK);
        g.setLineWidth(3);  
        g.strokeRect(0, 0, largo, alto);  
        
        mapTaller2 = new HashMap<>();
        contadorEstrella = 0;
        contadorEstrella2 = 0;
        contadorHexagono = 0;
        contadorHeptagono = 0;
        contadorOctagono = 0;
        contadorDecagono = 0;
        contadorFlecha = 0;
        contadorCruz = 0;
        contadorPacman = 0;
        contadorCurva = 0;
    }    
    
}
