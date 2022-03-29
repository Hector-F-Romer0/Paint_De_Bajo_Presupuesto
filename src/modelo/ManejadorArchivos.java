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
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Clase encargada de administrar la lectura y escritura de archivos externos
 * que puede manejar el proyecto.
 *
 * @author juliana.loaiza@uao.edu.co Juliana Loaiza Mejia Código 2205498
 * @author hector_fabio.romero@uao.edu.co Hector Fabio Romero Bocanegra Código
 * 2205024
 * @author andres.aristizabal_m@uao.edu.co Andrés Felipe Aristizabal Miranda
 * Código 2205296
 * @date 25 marzo 2022
 * @version 1.0
 */
public class ManejadorArchivos {

    /**
     * Permite guardar la información de las figuras realizadas por el usuario
     * en un archivo XML externo.
     *
     * @param listaFigurasCreadas LinkedList que contiene las figuras realizadas
     * por el usuario.
     * @return devuelve un booleano que determina si se completó el proceso de
     * guardado.
     */
   
    public static boolean guardarFiguras(LinkedList<Figura> listaFigurasCreadas) {
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
        }

        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File ficheroAGuardar = fileChooser.showSaveDialog(null);

            FileWriter writer = new FileWriter(ficheroAGuardar);
            XMLOutputter outputter = new XMLOutputter();

            outputter.setFormat(Format.getCompactFormat().getPrettyFormat());
            outputter.output(document, writer);
            outputter.output(document, System.out);
            t = true;
        } catch (IOException e) {
            System.out.println("Ha ocurrido en error en la entrada/salida del programa");
        } catch (NullPointerException e) {
            System.out.println("Debes seleccionar una ruta para guardar el archivo");
        }

        return t;
    }

    /**
     * Permite leer la información de las figuras realizadas por el usuario en
     * un archivo XML externo.
     *
     * @return devuelve una LinkedList con la información de las figuras que
     * existían dentro del XML externo.
     */
    public static LinkedList<Figura> leerArchivoXML() {

        LinkedList<Figura> listaFiguras = new LinkedList<>();

        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar XML");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File ficheroCargado = fileChooser.showOpenDialog(null);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            org.w3c.dom.Document documento = builder.parse(ficheroCargado);

            NodeList nodeListFiguras = documento.getElementsByTagName("FiguraGeometrica");

            for (int i = 0; i < nodeListFiguras.getLength(); i++) {
                Node nodo = nodeListFiguras.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                    org.w3c.dom.Element e = (org.w3c.dom.Element) nodo;

                    LinkedList<Punto2D> listaPuntos = new LinkedList<>();

                    String nombreFigura = e.getAttribute("nombreFigura");
                    Color colorRelleno = Color.web(e.getAttribute("colorRelleno"));
                    Color colorBorde = Color.web(e.getAttribute("colorBorde"));
                    Double grosor = Double.parseDouble(e.getAttribute("grosor"));

                    NodeList nodeListPuntos = e.getElementsByTagName("Punto");
                    for (int j = 0; j < nodeListPuntos.getLength(); j++) {

                        double coordenadaX = Double.parseDouble(nodeListPuntos.item(j).getAttributes().getNamedItem("X").getTextContent());
                        double coordenadaY = Double.parseDouble(nodeListPuntos.item(j).getAttributes().getNamedItem("Y").getTextContent());
                        Punto2D punto = new Punto2D(coordenadaX, coordenadaY);

                        listaPuntos.add(punto);
                    }
                    Figura fig = new Figura(nombreFigura, colorRelleno, colorBorde, grosor, listaPuntos);
                    listaFiguras.add(fig);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
        return listaFiguras;
    }

}
