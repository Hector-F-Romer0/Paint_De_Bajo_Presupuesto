package modelo;

import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javafx.scene.paint.Color;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**
 *
 * @author andres.aristizabal_m
 */  
public class ManejadorArchivos {
    public static boolean guardarFiguras(LinkedList<Figura> listaFigurasCreadas){
        boolean t = false;
        //Hay elementos y atributos, Elements - Atribs
        Element root = new Element("FigurasGeometricas");
        Document document = new Document(root);
        
        Iterator<Figura> entries = listaFigurasCreadas.iterator();
        
        while (entries.hasNext()) {
		Figura entry = entries.next();
                Element fg = new Element("FiguraGeometrica");
                fg.setAttribute("nombreFigura", entry.getNombreFigura());
                fg.setAttribute("colorRelleno", String.valueOf(entry.getColorRelleno()));
                fg.setAttribute("colorBorde", String.valueOf(entry.getColorBorde()));
                fg.setAttribute("grosor", String.valueOf(entry.getGrosor()));

                for (int i = 0; i < entry.listaPuntos.size(); i++) {                   
                    double x = entry.listaPuntos.get(i).getX(); 
                    double y = entry.listaPuntos.get(i).getY(); 
               
                    fg.addContent(new Element("Punto").
                            setAttribute("X", String.valueOf(x)).
                            setAttribute("Y", String.valueOf(y)));
                    
                }
                document.getRootElement().addContent(fg);
                t = true;
	}
        
        try{
            FileWriter writer = new FileWriter("figurasG.xml");
            XMLOutputter outputter = new XMLOutputter();
            
            outputter.setFormat(Format.getCompactFormat().getPrettyFormat());
            outputter.output(document, writer);
            outputter.output(document, System.out);
        }catch(Exception e){
            System.out.println("Error " + e.toString());
        }
        
        return t;
    }

    public static boolean leerFiguras(){
        boolean t = true;
        int i = 0;
        try{
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new File("figurasG.xml"));
             
            Element rootNode = doc.getRootElement();
            List<Element> list = rootNode.getChildren("FiguraGeometrica");
            
            
            
             for (Element target : list) {
                String nombreFigura = target.getAttributeValue("nombreFigura");
//                Color colorRelleno = Color.web(String.valueOf(target.getAttribute("colorRelleno")));
//                Color colorBorde = Color.web(String.valueOf(target.getAttribute("colorBorde")));
                double grosor = Double.parseDouble(target.getAttributeValue("grosor"));
                
                int contador = 0;
                LinkedList<Punto2D> listaPuntos = new LinkedList<>();
                List<Content> contenidoPuntos = target.getContent();
                
                 for (Content c : contenidoPuntos) {
                     c.getValue();
                 }
                
                Double coordenadaX = Double.parseDouble(target.getAttributeValue("X"));
                Double coordenadaY = Double.parseDouble(target.getAttributeValue("Y"));
//                double punto1x = Double.parseDouble(target.getChildTextTrim("Punto"));
                
                Punto2D punto = new Punto2D(coordenadaX,coordenadaY);
                System.out.println("Nombre: " + nombreFigura + " Grosor: " + grosor);
                System.out.println("X: " + coordenadaX+ " Y: " + coordenadaY);
                System.out.println("Punto 2D: " + punto)
//                target.getChildTextTrim("Punto");
                
                
                
                    
//                    double punto1y = Double.parseDouble(target.getChildTextTrim("Y"));
                    
                
                    ;
                
                
  
             }
//             if (t != null){
//                t = true;
//            }
//            JDOMFactory documentBuilder = new         
//            File archivo = new File("figurasG.xml");
//            Document documento = documentBuilder.parse(archivo);
          

            
        }catch(Exception e){
            System.out.println("Error " + e.toString());
        }
        
       return t;
    }
}
