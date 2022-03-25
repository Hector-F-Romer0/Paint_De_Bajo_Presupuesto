package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


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
//                t = true;
	}
        
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File ficheroAGuardar = fileChooser.showSaveDialog(null);
            
            FileWriter writer = new FileWriter(ficheroAGuardar);
            XMLOutputter outputter = new XMLOutputter();
            
            outputter.setFormat(Format.getCompactFormat().getPrettyFormat());
            outputter.output(document, writer);
            outputter.output(document, System.out);
            t = true;
//        }catch(Exception e){
//            System.out.println("Error " + e.toString());
        }catch (IOException e) {
            System.out.println("Ha ocurrido en error en la entrada/salida del programa");
        }

        catch(NullPointerException e){
            System.out.println("Debes seleccionar una ruta para guardar el archivo");
        }
        
        return t;
    }

    public static boolean leerFiguras(){
        boolean t = true;
//        int i = 0;
//        try{
//            SAXBuilder builder = new SAXBuilder();
//            Document doc = builder.build(new File("figurasG.xml"));
//             
//            Element rootNode = doc.getRootElement();
//            List<Element> list = rootNode.getChildren("FiguraGeometrica");
//            
//            
//            
//             for (Element target : list) {
//                String nombreFigura = target.getAttributeValue("nombreFigura");
////                Color colorRelleno = Color.web(String.valueOf(target.getAttribute("colorRelleno")));
////                Color colorBorde = Color.web(String.valueOf(target.getAttribute("colorBorde")));
//                double grosor = Double.parseDouble(target.getAttributeValue("grosor"));
//                
//                int contador = 0;
//                LinkedList<Punto2D> listaPuntos = new LinkedList<>();
//                List<Content> contenidoPuntos = target.getContent();
//                
//                 for (Content c : contenidoPuntos) {
//                     c.getValue();
//                 }
//                
//                Double coordenadaX = Double.parseDouble(target.getAttributeValue("X"));
//                Double coordenadaY = Double.parseDouble(target.getAttributeValue("Y"));
////                double punto1x = Double.parseDouble(target.getChildTextTrim("Punto"));
//                
//                Punto2D punto = new Punto2D(coordenadaX,coordenadaY);
//                System.out.println("Nombre: " + nombreFigura + " Grosor: " + grosor);
//                System.out.println("X: " + coordenadaX+ " Y: " + coordenadaY);
//                System.out.println("Punto 2D: " + punto)
////                target.getChildTextTrim("Punto");
//                
//                
//                
//                    
////                    double punto1y = Double.parseDouble(target.getChildTextTrim("Y"));
//                    
//                
//                    ;
//                
//                
//  
//             }
////             if (t != null){
////                t = true;
////            }
////            JDOMFactory documentBuilder = new         
////            File archivo = new File("figurasG.xml");
////            Document documento = documentBuilder.parse(archivo);
//          
//
//            
//        }catch(Exception e){
//            System.out.println("Error " + e.toString());
//        }
//        
       return t;
    }
    
    public static LinkedList<Figura> leerArchivoXML(){
        
        LinkedList<Figura> listaFiguras = new LinkedList<>();
        
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar XML");
            // Sirve para delimitar la selección de archivos que el usuario puede escoger
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", "*.xml"));
            // Sirve para abrir la ventana de búsqueda y seleccionar la ruta del archivo que desea abrir el usuario
            File ficheroCargado = fileChooser.showOpenDialog(null);
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Cargo en memoria todo el contenido del XML
            org.w3c.dom.Document documento = builder.parse(ficheroCargado);

            // Almaneca todos los elementos que tengan nombre de etiqueta "FiguraGeometrica" en una NodeList 
            NodeList nodeListFiguras = documento.getElementsByTagName("FiguraGeometrica");
            
            for (int i = 0; i < nodeListFiguras.getLength(); i++) {
                Node nodo = nodeListFiguras.item(i);
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE){
 
                    org.w3c.dom.Element e = (org.w3c.dom.Element) nodo;
                    
                    LinkedList<Punto2D> listaPuntos = new LinkedList<>();
                    
                    // Obtenemos los valores de los atributos dentro de la etiqueta "FiguraGeometrica"
                    String nombreFigura = e.getAttribute("nombreFigura");
                    Color colorRelleno = Color.web(e.getAttribute("colorRelleno"));
                    Color colorBorde = Color.web(e.getAttribute("colorBorde"));
                    Double grosor = Double.parseDouble(e.getAttribute("grosor"));
                    
                    
                    // Creamos una NodeList para almacenar todos los nodos que tenga la etiqueta "Punto"
                    NodeList nodeListPuntos = e.getElementsByTagName("Punto");
                    for (int j = 0; j < nodeListPuntos.getLength(); j++) {
                        
                        // Accedemos a la etiqueta N° j para obtener el valor dentro del atributo
                        double coordenadaX = Double.parseDouble(nodeListPuntos.item(j).getAttributes().getNamedItem("X").getTextContent());
                        double coordenadaY = Double.parseDouble(nodeListPuntos.item(j).getAttributes().getNamedItem("Y").getTextContent());
                        Punto2D punto = new Punto2D(coordenadaX,coordenadaY);
                        
                        listaPuntos.add(punto);
                    }
//                    
                    Figura fig = new Figura(nombreFigura, colorRelleno, colorBorde, grosor, listaPuntos);
                    listaFiguras.add(fig);
                }
                
            }
            
        } catch (Exception e) {
            //IllegalArgumentException ocurre cuando no se selecciona ningún archivo a cargar
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
        
       
        
        return listaFiguras;
    }
}


