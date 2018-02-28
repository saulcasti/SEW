import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GestorFacutras {
	
	List<Factura> facturas = new ArrayList<Factura>();
	
	public void addFacturas(Factura factu) {
		facturas.add(factu);
	}
	public void generarXML(String xml) {
		
		 try {
			 DecimalFormat df = new DecimalFormat("#.00");
			 
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

				// elemento raiz
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("facturas");
				doc.appendChild(rootElement);

				for(Factura f:facturas) {
					// Factura
					Element factura = doc.createElement("factura");
					rootElement.appendChild(factura);

					// atributos del elemento factura
					Element fecha = doc.createElement("fecha");
					fecha.appendChild(doc.createTextNode(f.getFecha()));
					factura.appendChild(fecha);
					
					Element direccion = doc.createElement("direccion");
					direccion.appendChild(doc.createTextNode(f.getDireccion()));
					factura.appendChild(direccion);
					
					Element total = doc.createElement("totalSinIva");
					total.appendChild(doc.createTextNode(""+df.format(f.getTotal())));
					factura.appendChild(total);
					
					Element totalC = doc.createElement("total");
					totalC.appendChild(doc.createTextNode(""+df.format(f.getTotalConIva())));
					factura.appendChild(totalC);


					// trabajo
					for(Trabajo t:f.getTrabajos()) {
						Element trabajo = doc.createElement("trabajo");
						trabajo.appendChild(doc.createTextNode("Pintado de " + t.getArea()));
						factura.appendChild(trabajo);
						
						Attr costePintura = doc.createAttribute("costePintura");
						costePintura.setValue(""+df.format(t.getTotalpintura()));
						trabajo.setAttributeNode(costePintura);
						
						Attr costeManoObra = doc.createAttribute("costeManoObra");
						costeManoObra.setValue(""+df.format(t.getTotalTrabajo()));
						trabajo.setAttributeNode(costeManoObra);
						
						Attr costeT = doc.createAttribute("costeTotal");
						costeT.setValue(""+df.format(t.getTotalTrabajo() + t.getTotalpintura()));
						trabajo.setAttributeNode(costeT);
						
					}

				}
				// escribimos el contenido en un archivo .xml
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				//StreamResult result = new StreamResult(new File("C:\\archivo.xml"));
				StreamResult result = new StreamResult(new File(xml+".xml"));
		 
				// Si se quiere mostrar por la consola...
				//StreamResult result = new StreamResult(System.out);
		 
				transformer.transform(source, result);
		 
				System.out.println("File saved!");
		 
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (TransformerException tfe) {
					tfe.printStackTrace();
				}
	}
}
