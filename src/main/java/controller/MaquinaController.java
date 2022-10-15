package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.maquinas;
import connection.DBConnection;

public class MaquinaController implements IMaquinaController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from maquinas";

        if (ordenar == true) {
            sql += " order by modelo " + orden;
        }

        List<String> maquinas = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String referencia = rs.getString("referencia");
                String modelo = rs.getString("modelo");
                String potencia = rs.getString("potencia");
                String capacidad = rs.getString("capacidad");
                String otros = rs.getString("otros");
                int stock = rs.getInt("stock");
                

                maquinas maquina = new maquinas(id, nombre, referencia, modelo, potencia, capacidad, otros, stock);

                maquinas.add(gson.toJson(maquina));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(maquinas);

    }
    
    
    }