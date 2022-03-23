/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlGUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import modelo.Figura;
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
    
    FileChooser fileChooser = new FileChooser();
       
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
    LinkedList<Figura> listaFigurasCreadas;
    
    @FXML
    private Canvas lienzo;
           
    @FXML
    private Pane panelFiguras;
   
    @FXML
    private ColorPicker colorRelleno;
    
    @FXML
    private ColorPicker colorBorde;
    
    @FXML
    private ImageView sun_jinwoo;
    
    @FXML
    private TextField campoTamano;
    
    @FXML
    private TextField campoGrosor;
    
    @FXML
    private Label labelGrosor;
    
    @FXML
    private Label labelTamano;
    
    @FXML
    private Label labelAviso;
    
    @FXML
    private Label labelTamanoValue;
    
    @FXML
    private Label labelGrosorValue;
    
    @FXML
    private Slider deslizadorTamano;
    
    @FXML
    private Slider deslizadorGrosor;
    
    @FXML
    private void agregarTamanoyGrosor(MouseEvent event){
        
        labelTamanoValue.setText(String.valueOf(Math.round(deslizadorTamano.getValue())));
        labelGrosorValue.setText(String.valueOf(Math.round(deslizadorGrosor.getValue())));
    }
    
    /**
    * Crea una figura geométrica de cinco puntos con forma de estrella de cinco puntas.
    * @param event evento de tipo ActionEvent que desencadenará la función del método.
    */
    @FXML
    private void crearEstrella(ActionEvent event) {
                  
        listaPuntos = new LinkedList<>();
        double r = deslizadorTamano.getValue();       
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
        g.setLineWidth(deslizadorGrosor.getValue());
        g.setStroke(colorBorde.getValue());
        g.strokePolygon(x1, y1, 10);
        g.setFill(colorRelleno.getValue());
        g.fillPolygon(x1, y1, 10);
        
        contadorEstrella ++;

        Figura fg = new Figura("Estrella 5 puntas " + contadorEstrella, colorRelleno.getValue(), colorBorde.getValue(), Math.round(deslizadorGrosor.getValue()), listaPuntos);
        listaFigurasCreadas.add(fg);
    }
    
    @FXML
    private void crearEstrella2(ActionEvent event) {
       
        listaPuntos = new LinkedList<>();
        double r = deslizadorTamano.getValue();  
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
        g.setLineWidth(deslizadorGrosor.getValue());
        g.setStroke(colorBorde.getValue());
        g.strokePolygon(x1, y1, 12);
        g.setFill(colorRelleno.getValue());
        g.fillPolygon(x1, y1, 12);

        contadorEstrella2 ++;

        Figura fg = new Figura("Estrella 6 puntas " + contadorEstrella2, colorRelleno.getValue(), colorBorde.getValue(), Math.round(deslizadorGrosor.getValue()), listaPuntos);
        listaFigurasCreadas.add(fg);        
    }
    
    @FXML
    private void crearHexagono(ActionEvent event) {

        listaPuntos = new LinkedList<>();
        double r = deslizadorTamano.getValue(); 
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
        g.setLineWidth(deslizadorGrosor.getValue());
        g.setStroke(colorBorde.getValue());
        g.strokePolygon(x1, y1, numLados);
        g.setFill(colorRelleno.getValue());
        g.fillPolygon(x1, y1, numLados);       

        contadorHexagono ++;

        Figura fg = new Figura("Hexágono " + contadorHexagono, colorRelleno.getValue(), colorBorde.getValue(), Math.round(deslizadorGrosor.getValue()), listaPuntos);
        listaFigurasCreadas.add(fg);
    }
    
    @FXML
    private void crearHeptagono(ActionEvent event) {

        listaPuntos = new LinkedList<>();
        double r = deslizadorTamano.getValue(); 
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
        g.setLineWidth(deslizadorGrosor.getValue());
        g.setStroke(colorBorde.getValue());
        g.strokePolygon(x1, y1, numLados);
        g.setFill(colorRelleno.getValue());
        g.fillPolygon(x1, y1, numLados);  
        
            
        contadorHeptagono ++;
            
        Figura fg = new Figura("Heptágono " + contadorHeptagono, colorRelleno.getValue(), colorBorde.getValue(), Math.round(deslizadorGrosor.getValue()), listaPuntos);
        listaFigurasCreadas.add(fg);
    }
   
    @FXML
    private void crearOctagono(ActionEvent event) {
    
        listaPuntos = new LinkedList<>();
        double r = deslizadorTamano.getValue(); 
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
        g.setLineWidth(deslizadorGrosor.getValue());
        g.setStroke(colorBorde.getValue());
        g.strokePolygon(x1, y1, numLados);
        g.setFill(colorRelleno.getValue());
        g.fillPolygon(x1, y1, numLados);  
            
        contadorOctagono ++;
            
        Figura fg = new Figura("Octágono " + contadorOctagono, colorRelleno.getValue(), colorBorde.getValue(), Math.round(deslizadorGrosor.getValue()), listaPuntos);
        listaFigurasCreadas.add(fg);
    }
    
    @FXML
    private void crearDecagono(ActionEvent event) {
    
        listaPuntos = new LinkedList<>();
        double r = deslizadorTamano.getValue(); 
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
        g.setLineWidth(deslizadorGrosor.getValue());
        g.setStroke(colorBorde.getValue());
        g.strokePolygon(x1, y1, numLados);
        g.setFill(colorRelleno.getValue());
        g.fillPolygon(x1, y1, numLados);  
            
        contadorDecagono ++;
            
        Figura fg = new Figura("Decágono " + contadorDecagono, colorRelleno.getValue(), colorBorde.getValue(), Math.round(deslizadorGrosor.getValue()), listaPuntos);
        listaFigurasCreadas.add(fg);
    }
    
    @FXML
    private void crearFlecha(ActionEvent event) {
           
        listaPuntos = new LinkedList<>();
        double r = deslizadorTamano.getValue();         
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
        g.setLineWidth(deslizadorGrosor.getValue());
        g.setStroke(colorBorde.getValue());
        g.strokePolygon(x1, y1, 7);
        g.setFill(colorRelleno.getValue());
        g.fillPolygon(x1, y1, 7);  
            
        contadorFlecha ++;
            
        Figura fg = new Figura("Flecha " + contadorFlecha, colorRelleno.getValue(), colorBorde.getValue(), Math.round(deslizadorGrosor.getValue()), listaPuntos);
        listaFigurasCreadas.add(fg);
    }
   
    @FXML
    private void crearCruz(ActionEvent event) {
        
        listaPuntos = new LinkedList<>();
        double r = deslizadorTamano.getValue(); 
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
        g.setLineWidth(deslizadorGrosor.getValue());
        g.setStroke(colorBorde.getValue());
        g.strokePolygon(x1, y1, 12);
        g.setFill(colorRelleno.getValue());
        g.fillPolygon(x1, y1, 12);  
            
        contadorCruz ++;
            
        Figura fg = new Figura("Cruz " + contadorCruz, colorRelleno.getValue(), colorBorde.getValue(), Math.round(deslizadorGrosor.getValue()), listaPuntos);
        listaFigurasCreadas.add(fg);
    }
    
    @FXML
    private void crearPacman(ActionEvent event) {
    
        listaPuntos = new LinkedList<>();
        double r = deslizadorTamano.getValue(); 
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
    }
       
    @FXML
    private void crearCurva(ActionEvent event) {
    
        
    }
         
    @FXML
    private void guardarCanva(ActionEvent event){
        
        // Abre un explorador de archivos para indicar donde se van a guardar los canvas
        File archivoAGuardar = fileChooser.showSaveDialog(null);
        
        if(archivoAGuardar != null){
            try {
                WritableImage writableImage = new WritableImage((int)lienzo.getWidth(),(int)lienzo.getHeight());
                // Toma una instantánea o foto del lienzo en ese momento
                lienzo.snapshot(null, writableImage);
                BufferedImage bImage =SwingFXUtils.fromFXImage(writableImage, null);
//                RenderedImage imagenRenderizada = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(bImage, "jpg", archivoAGuardar);
            } catch (Exception e) {
                System.out.println("Error al guardar la imagen");
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("No se seleccionó archivo");
        }
    }
    
    @FXML
    private void cargarCanva(ActionEvent event) {
 
        //Ayuda a que solo se pueden seleccionar archivos 'JPG' y que obligatoriamente sean "JPG"
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
        
        // Creamos un objeto File donde se guardará el archivo que el usuario escoja y abrimos el explorador de archivos
        File archivoSeleccionado = fileChooser.showOpenDialog(null);
        // Sirve para seleccionar un solo archivo
        
        
        // Si se cargó un archivo, será diferente de null
        if(archivoSeleccionado !=null){
            System.out.println("Se cargó el archivo");
        }else{
            System.out.println("No se cargó el archivo");
        }        
    }
    
    /**
    * Obtiene las coordenadas del mouse cuando el usuario haga click dentro del lienzo.
    * @param event evento de tipo MouseEvent que desencadenará la función del método cuando detecte una acción del mouse.
    */
    @FXML
    private void obtenerCoordenadas(MouseEvent event) { 
        
        coorX = event.getX();
        coorY = event.getY();   
        System.out.println("El punto " + coorX + ", " + coorY);
    }
    
    /**
    * Limpia el lienzo donde el usuario puede dibujar las figuras geométricas.
    * @param event evento de tipo ActionEvent que desencadenará la función del método.
    */
    @FXML
    private void borrarLienzo(ActionEvent event) {
        
        g.clearRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
    }    
   
    @FXML
    private void guardarXML(ActionEvent event) {

        boolean t = ManejadorArchivos.guardarFiguras(listaFigurasCreadas);
        if (t == true ){
            System.out.println("Se guardó");
        }else{
            System.out.println("No se guardó");
        }       
    }
    
    @FXML
    private void leerXML(ActionEvent event) {

        boolean t = ManejadorArchivos.leerFiguras();
        if (t == true ){
            System.out.println("Se Leyó");
        }else{
            System.out.println("No se leyó");
        }       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaFigurasCreadas = new LinkedList<>();
        g = lienzo.getGraphicsContext2D();

        double alto = lienzo.getHeight();
        double largo = lienzo.getWidth();
        
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
