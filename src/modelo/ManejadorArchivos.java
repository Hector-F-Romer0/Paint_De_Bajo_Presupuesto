package modelo;

import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jdom2.Document;
import org.jdom2.Element;
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
                    fg.addContent(new Element("Punto" + i).
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
        boolean t = false;
        try{
//            JDOMFactory documentBuilder = new         
//            File archivo = new File("figurasG.xml");
//            Document documento = documentBuilder.parse(archivo);
          

//            if (t != null){
//                t = true;
//            }
        }catch(Exception e){
            System.out.println("Error " + e.toString());
        }
        
       return t;
    }
}
