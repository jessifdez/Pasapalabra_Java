import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoBD {
	public static void crearTabla() {
		
        try {
			Class.forName("com.mysql.jdbc.Driver");
			 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pasapalabra?serverTimezone=UTC", "root","");
	         Statement stmt=connection.createStatement();
	         String query="CREATE TABLE  if not exists ranking "
	                +"( nombre varchar(50), aciertos int(5))";
	         stmt.executeUpdate(query);
	         stmt.close();
	         connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void grabarRanking(Ranking r) {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pasapalabra?serverTimezone=UTC", "root","");
            Statement stmt=connection.createStatement();
            String query="INSERT INTO ranking VALUES('"+r.getNombre()+"', '"+r.getAciertos()+"')";
            stmt.executeUpdate(query);
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}


	public static ArrayList<Ranking> recuperarRanking() {
		ArrayList<Ranking> lista_puntuaciones=new ArrayList ();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pasapalabra?serverTimezone=UTC", "root","");
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM ranking ORDER BY aciertos DESC");
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                int puntuacion=rs.getInt("aciertos");
                
                Ranking r=new Ranking(nombre, puntuacion);
                lista_puntuaciones.add(r);        
            }   
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_puntuaciones; 
    }
	
	

}
