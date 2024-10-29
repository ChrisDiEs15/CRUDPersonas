/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudpersonas;
import java.io.Serializable;

/**
 *
 * @author Chris
 */
public class Persona implements Serializable {
     private static final long serialVersionUID = 1L;
     private Integer id;
     private String nombre;
     private String aPaterno;
     private String aMaterno;
     private int edad;

    public Persona(int id, String nombre, String aPaterno, String aMaterno, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.edad = edad;
    }
    //getters

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public int getEdad() {
        return edad;
    }
    //Setters 

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Persona other = (Persona) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
     @Override
    public String toString() {
        return "\n\tPersona{id=" + id + ", nombre='" + nombre + "'}";
    }
    
}
