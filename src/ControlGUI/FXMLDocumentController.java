/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlGUI;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
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
    
    FileChooser fileChooser = new FileChooser();
    
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
    private void crearEstrella(MouseEvent event) {
    
    }
    
    @FXML
    private void crearEstrella2(MouseEvent event) {
    
    }
    
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
        g.strokePolygon(x1, y1, numLados);
        g.setLineWidth(3);

    }
    
    @FXML
    private void crearHeptagono(MouseEvent event) {
    
    }
   
    @FXML
    private void crearOctagono(MouseEvent event) {
    
    }
    
    @FXML
    private void crearDecagono(MouseEvent event) {
    
    }
    
    @FXML
    private void crearFlecha(MouseEvent event) {
    
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
        g.strokePolygon(x1, y1,12);
        g.setLineWidth(3);
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
    
    
    @FXML
    private void crearPacman(MouseEvent event) {
    
    }
       
    @FXML
    private void crearCurva(MouseEvent event) {
    
    }
    
    @FXML
    private void obtenerCoordenadas(MouseEvent event) { 
        
        coorX = event.getX();
        coorY = event.getY();   
        System.out.println("El punto " + coorX + ", " + coorY);
    }
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        fileChooser.setInitialDirectory(new File("C:\\temp"));
        g = lienzo.getGraphicsContext2D();

        double alto = lienzo.getHeight();
        double largo = lienzo.getWidth();

        g.setStroke(Color.BLACK);
        g.setLineWidth(3);  
        g.strokeRect(0, 0, largo, alto);               
    }    
    
}
