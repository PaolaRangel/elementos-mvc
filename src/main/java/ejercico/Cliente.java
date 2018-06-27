/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercico;

/**
 *
 * @author T-107
 */
public class Cliente {
    private String id;

    public Cliente(String id) {
        this.id = id;
    }
    private String nombre;
    private Tarjeta tarjeta;

    public Cliente() {
    }

    public Cliente(String nombre, Tarjeta tarjeta) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getid() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
    
}
