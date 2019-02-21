import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AccesoFicheroXML {

	public static ArrayList<Pregunta> parsearXML() {
		SAXBuilder builder=new SAXBuilder();
		Document documento;
		ArrayList<Pregunta> lista_preguntas=new ArrayList<>();
		try {
			documento = builder.build(new File("C:\\Jessica\\pasapalabra.xml"));
			Element elemento_raiz=documento.getRootElement();
			Element elemento_jugador=elemento_raiz.getChild("jugador");
			List<Element> lista_elementos_pregunta=elemento_jugador.getChildren("pregunta");
			for (int j= 0; j < lista_elementos_pregunta.size(); j++) 
			{
				Element elemento_pregunta=lista_elementos_pregunta.get(j);
				String letra=elemento_pregunta.getChild("letra").getValue();
				String posicion=elemento_pregunta.getChild("posicion").getValue();
				String definicion=elemento_pregunta.getChild("definicion").getValue();
				String solucion=elemento_pregunta.getChild("solucion").getValue();
				Pregunta p=new Pregunta(letra,posicion,definicion,solucion);
				lista_preguntas.add(p);//Lo añado a la lista de preguntas para que vaya guardando todas
				//System.out.println(p.getLetra()+p.getPosicion()+p.getDefinicion()+p.getSolucion());
			}
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista_preguntas;
	}

}
