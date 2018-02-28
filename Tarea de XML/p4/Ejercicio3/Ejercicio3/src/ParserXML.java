import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserXML {

	public List<Artista> getXML(String xml){
		 try {

				File fXmlFile = new File(xml);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				
				List<Artista> artistas = new ArrayList<Artista>();
				//Sacamos la lista de nodos artista
				NodeList nodosArtistas = doc.getElementsByTagName("artista");

				//Recorremos la lista de nodos artista
				for (int temp = 0; temp < nodosArtistas.getLength(); temp++) {
					Node nodoArtista = nodosArtistas.item(temp);
					if (nodoArtista.getNodeType() == Node.ELEMENT_NODE) {
						List<Concierto> conciertos = new ArrayList<Concierto>();
						String nombre="";
						int numeroMiembros = -1;
						Element eElement = (Element) nodoArtista;
						nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
						numeroMiembros=Integer.parseInt(eElement.getElementsByTagName("numeroMiembros").item(0).getTextContent());
						
						//Sacamos la lista de nodos concierto
						NodeList con = eElement.getElementsByTagName("concierto");
						for (int i = 0; i < con.getLength(); i++) {
							Node c = con.item(i);
							if (nodoArtista.getNodeType() == Node.ELEMENT_NODE) {
								String nombreSala= "";
								String fecha = "";
								String ciudad="";
								String gira="";
								Element concierto = (Element) c;
								nombreSala=concierto.getTextContent();
								fecha=concierto.getAttribute("fecha");
								ciudad= concierto.getAttribute("ciudad");
								gira=concierto.getAttribute("gira");
								
								conciertos.add(new Concierto(nombreSala, fecha, ciudad, gira));

							}}

						Artista artistaEncontrado = new Artista(nombre, numeroMiembros, conciertos);
						artistas.add(artistaEncontrado);
					}
				}
				return artistas;
			    } catch (Exception e) {
			    	System.out.println("Solo se puede introducir un archivo .xml");
			    }return null;
			  }
	
  }