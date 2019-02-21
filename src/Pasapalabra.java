import java.util.ArrayList;

public class Pasapalabra {

	public static void main(String[] args) {
		AccesoBD.crearTabla();
		String nombre=EntradaSalida.pedirNombre();
		ArrayList<Pregunta> lista_preguntas=AccesoFicheroXML.parsearXML();
		int opcion=EntradaSalida.mostrarMenu();
		while(opcion!=3)
        {
            switch(opcion)
            {
            case 1://Jugar
            	int aciertos=0;
                for(int i=0;i<lista_preguntas.size();i++)
                {
                    Pregunta pr=lista_preguntas.get(i);
                    String respuesta_usuario=EntradaSalida.hacerPregunta(pr);
                    if(respuesta_usuario.equalsIgnoreCase(pr.getSolucion()))//IgnoreCase es para que no importe mayuscula o miniscula
                    {
                        aciertos++;
                        EntradaSalida.darEnhorabuena(aciertos);
                    }
                    else {
                    	EntradaSalida.mostrarCorrecta(pr.getSolucion());
                    }
                }
                Ranking r=new Ranking(nombre,aciertos);
                AccesoBD.grabarRanking(r);
                break;
                    
            case 2:
            	ArrayList<Ranking> lista_puntuaciones=AccesoBD.recuperarRanking();
                EntradaSalida.mostrarRanking(lista_puntuaciones);
                break;
            }
            opcion=EntradaSalida.mostrarMenu();

	}

}
}
