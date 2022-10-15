
package test;

import beans.maquinas;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
    
    public static void main(String[]  args) {
        listarMaquinas ();
      
    }
    public static void actualizarMaquinas (int id, String Modelo) {
        
        DBConnection con = new DBConnection();
        String sql = "UPDATE Maquinas SET Modelo = "
                + "'" + Modelo  + "'WHERE id =" + id;
        
        try { 
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            con.desconectar();
        }
    }
    
    public static void listarMaquinas(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM maquinas";
        
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String Nombre = rs.getString("Nombre");
                String Referencia = rs.getString("Referencia");
                String Modelo = rs.getString("Modelo");
                String Potencia = rs.getString("Potencia");
                String Capacidad = rs.getString("Capacidad");
                String Otros = rs.getString("Otros");
                int Stock = rs.getInt ("Stock");
                                 
                maquinas maquinas = new maquinas (id, Nombre, Referencia,Modelo, Potencia, Capacidad, Otros, Stock);
                System.out.println(maquinas.toString());               
                        
            }
            st.executeQuery (sql);
            
        }catch (Exception ex){
        
           System.out.println(ex.getMessage());
    }finally {
       con.desconectar(); 
    }
    }

}