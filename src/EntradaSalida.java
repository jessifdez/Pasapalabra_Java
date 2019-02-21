import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {
	static Scanner sc=new Scanner(System.in);
	
	public static int mostrarMenu() {
		System.out.println("ELIJA UNA OPCIÓN:");
        System.out.println("1.Jugar");
        System.out.println("2.Ver Ranking");
        System.out.println("3.SALIR");
        int opcion=sc.nextInt();sc.nextLine();
        return opcion;
	}

	public static String hacerPregunta(Pregunta p) {
		System.out.println(p.getPosicion()+" "+p.getLetra()+": "+p.getDefinicion()); 
		String respuesta_usuario=sc.nextLine();
        return respuesta_usuario;
	}

	public static String pedirNombre() {
		System.out.println("¿Cuál es su nombre?");
        String nombre=sc.nextLine();
        return nombre;
	}

	public static void mostrarRanking(ArrayList<Ranking> lista_puntuaciones) {
        for(int i=0;i<lista_puntuaciones.size();i++)
        {
            System.out.println("NOMBRE: "+lista_puntuaciones.get(i).getNombre()+"\t\t"+"ACIERTOS: "+lista_puntuaciones.get(i).getAciertos());
        }
		
	}

	public static void darEnhorabuena(int aciertos) {
		System.out.println("Has acertado. Llevas "+aciertos+" aciertos");
		
	}

	public static void mostrarCorrecta(String solucion) {
		System.out.println("Error. La respuesta correcta era "+solucion);
		
	}

	
	

}
