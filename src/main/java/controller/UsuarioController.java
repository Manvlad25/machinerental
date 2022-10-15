package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.usuarios;
import connection.DBConnection;
import java.util.HashMap;
import java.util.Map;


public class UsuarioController implements IUsuarioController {

    //Metodo para proceso de logeo
    @Override
    public String login(String username, String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuarios where username = '" + username
                + "' and contrasena = '" + contrasena + "'";
        
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String razon_social = rs.getString("razon_social");
                String nit = rs.getString("nit");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");
                boolean premium = rs.getBoolean("premium");

                usuarios usuario
                        = new usuarios(username, contrasena, razon_social, nit, email, saldo, premium);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    //Metodo para proceso de registro de usuario
    @Override
    public String register(String username, String contrasena, String razon_social, String nit, String email,
            double saldo, boolean premium) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuarios values('" + username + "', '" + contrasena + "', '" + razon_social
                + "', '" + nit + "', '" + email + "', " + saldo + ", " + premium + ")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            usuarios usuario = new usuarios(username, contrasena, razon_social, nit, email, saldo, premium);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";
    }
    
     //Metodo para traer las peliculas (pedir)
    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuarios where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String razon_social = rs.getString("razon_social");
                String nit = rs.getString("nit");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");
                boolean premium = rs.getBoolean("premium");

                usuarios usuario = new usuarios(username, contrasena,
                        razon_social, nit, email, saldo, premium);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
       //Metodo para modificar usuario
      @Override
    public String modificar(String username, String nuevaContrasena, 
            String nuevoRazon_Social, String nuevosNit,
            String nuevoEmail, double nuevoSaldo, boolean nuevoPremium) {   

        DBConnection con = new DBConnection();

        String sql = "Update usuarios set contrasena = '" + nuevaContrasena +
                "', razon_social = '" + nuevoRazon_Social + "', "
                + "nit = '" + nuevosNit + "', email = '" 
                + nuevoEmail + "', saldo = " + nuevoSaldo + ", premium = ";

        if (nuevoPremium == true) {
            sql += " 1 ";
        } else {
            sql += " 0 ";
        }

        sql += " where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }
    @Override
    public String verStock(String username) {

        DBConnection con = new DBConnection();
        String sql = "Select id,count(*) as num_stock from rental where username = '" 
                + username + "' group by id;";

        Map<Integer, Integer> stock = new HashMap<Integer, Integer>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int num_stock = rs.getInt("num_stock");

                stock.put(id, num_stock);
            }

            devolverMaquinas(username, stock);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }
    
    @Override
    public String devolverMaquinas(String username, Map<Integer, Integer> stock) {

        DBConnection con = new DBConnection();

        try {
            for (Map.Entry<Integer, Integer> maquina : stock.entrySet()) {
                int id = maquina.getKey();
                int num_stock = maquina.getValue();

                String sql = "Update maquinas setstock = (Select stock + " + num_stock +
                        " from maquinas where id = " + id + ") where id = " + id;

                Statement st = con.getConnection().createStatement();
                st.executeUpdate(sql);

            }

            this.eliminar(username);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    
          @Override
    public String eliminar(String username) {

        DBConnection con = new DBConnection();

        String sql1 = "Delete from rental where username = '" + username + "'";
        String sql2 = "Delete from usuarios where username = '" + username + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    }
      
    