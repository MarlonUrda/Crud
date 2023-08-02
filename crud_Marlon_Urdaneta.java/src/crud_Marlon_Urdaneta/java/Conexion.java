package crud_Marlon_Urdaneta.java;//C.I: 30763460

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
	
	public static void main(String[] args) {
		Connection conectbdd = null;
		
		try {
			
			//Establecemos la conexion con nuestra base de datos
			
			Class.forName("org.postgresql.Driver");
			conectbdd = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Base de Datos Universidad", "postgres" , "123456789");
			
			if(conectbdd != null) {
				System.out.println("Conexion establecida");
			}
			else {
				System.out.println("Conexion fallida");
			}
			
			Statement declaracion = conectbdd.createStatement();
			System.out.println("Objeto para consultas creado con exito");
			
			//Insertar registros en la tabla que queramos
			
			//String insertarSQL = "INSERT INTO carrera(nombre_carrera, duracion_años) VALUES('Produccion Animal', 4)";
			//String insertarSQL = "INSERT INTO materias(nombre_materia, hc_materia) VALUES('Sistemas Operativos', 3)";
			
			String insertSQL = "SELECT * FROM alumno";
			
			//Ejecutamos el query
			
			ResultSet ejecutar = declaracion.executeQuery(insertSQL);
			
			System.out.println("Query ejecutado exitosamente");
			
			//Actualizaciones de la tabla ya sea cambiar un valor o borrar una fila
			//String actualizarSQL = "UPDATE alumno SET \"EDAD\" = 23 WHERE \"EDAD\" = 19";
			//String borrarSQL = "DELETE FROM alumno WHERE \"SEMESTRE\" = 6";
			
			//Borramos las filas indicadas en el query
			//declaracion.executeUpdate(borrarSQL);
			
			while(ejecutar.next()) {
				System.out.println("id : " + ejecutar.getInt("id_alumno")+ 
						" nombre : " + ejecutar.getString("nombre") +
						" edad : " + ejecutar.getInt("edad") + 
						" semestre : " + ejecutar.getInt("semestre") +
						" carrera : " + ejecutar.getInt("id_carrera"));
			}
			
			System.out.println("Tabla mostrada exitosamente");
			
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
}