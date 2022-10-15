/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author USUARIO
 */
public class maquinas {
    private int id;
    private String Nombre;
    private String Referencia;
    private String Modelo;
    private String Potencia;
    private String Capacidad;
    private String Otros;
    private int Stock;

    public maquinas(int id, String Nombre, String Referencia, String Modelo, String Potencia, String Capacidad, String Otros, int Stock) {
        this.id = id;
        this.Nombre = Nombre;
        this.Referencia = Referencia;
        this.Modelo = Modelo;
        this.Potencia = Potencia;
        this.Capacidad = Capacidad;
        this.Otros = Otros;
        this.Stock = Stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getPotencia() {
        return Potencia;
    }

    public void setPotencia(String Potencia) {
        this.Potencia = Potencia;
    }

    public String getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(String Capacidad) {
        this.Capacidad = Capacidad;
    }

    public String getOtros() {
        return Otros;
    }

    public void setOtros(String Otros) {
        this.Otros = Otros;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    @Override
    public String toString() {
        return "maquinas{" + "id=" + id + ", Nombre=" + Nombre + ", Referencia=" + Referencia + ", Modelo=" + Modelo + ", Potencia=" + Potencia + ", Capacidad=" + Capacidad + ", Otros=" + Otros + ", Stock=" + Stock + '}';
    }
    
    
    
}
