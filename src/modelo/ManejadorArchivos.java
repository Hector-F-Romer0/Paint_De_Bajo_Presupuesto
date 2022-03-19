package modelo;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author andres.aristizabal_m
 */
public class ManejadorArchivos {
    public static boolean guardarFiguras(HashMap<String, LinkedList<Punto2D>> mp){
        boolean t = false;
        //Hay elementos y atributos, Elements - Atribs
        Element root = new Element("FigurasGeometricas");
        Document document = new Document(root);
        
        Iterator<Map.Entry<String, LinkedList<Punto2D>>> entries = mp.entrySet().iterator();
        
        while (entries.hasNext()) {
		Map.Entry<String, LinkedList<Punto2D>> entry = entries.next();
                Element fg = new Element("FiguraGeometrica");
                fg.setAttribute("nombreFigura", entry.getKey());
//                System.out.println(entry.getKey());
                LinkedList<Punto2D> listaP = entry.getValue();
                for (int i = 0; i < listaP.size(); i++) {                   
                    double x = listaP.get(i).getX(); 
                    double y = listaP.get(i).getY(); 
                    fg.addContent(new Element("Punto" + i).
                            setAttribute("X", String.valueOf(x)).
                            setAttribute("Y", String.valueOf(y)));
                    
                }
                document.getRootElement().addContent(fg);
                t = true;
//                    System.out.println("Puntos "+get.toString()+"\n");           		
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
}
