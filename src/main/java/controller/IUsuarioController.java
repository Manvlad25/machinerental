package controller;

import java.util.Map;

public interface IUsuarioController {

    
    public String login(String username, String contrasena);
    
    public String register(String username, String contrasena, 
            String razon_social, String nit, String email, double saldo, boolean premium);
    
    public String pedir(String username);
    
    public String modificar(String username, String nuevaContrasena, 
            String nuevoRazon_Social, String nuevosNit, String nuevoEmail, 
            double nuevoSaldo, boolean nuevoPremium);
    //Metodo para eliminar usuario
    public String verStock(String username);
    public String devolverMaquinas(String username, Map<Integer, Integer> stock);

    public String eliminar(String username);
    
    
}

