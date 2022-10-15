/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author USUARIO
 */
public class usuarios {
    private String username;
    private String contrasena; 
    private String razon_social;
    private String nit;
    private String email;
    private double saldo;
    private boolean premium;

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getString() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public usuarios(String username, String contrasena, String razon_social, String nit, String email, double saldo, boolean premium) {
        this.username = username;
        this.contrasena = contrasena;
        this.razon_social = razon_social;
        this.nit = nit;
        this.email = email;
        this.saldo = saldo;
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "usuarios{" + "username=" + username + ", contrasena=" + contrasena + ", razon_social=" + razon_social + ", nit=" + nit + ", email=" + email + ", saldo=" + saldo + ", premium=" + premium + '}';
    }
    
}
