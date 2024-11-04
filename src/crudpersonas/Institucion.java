/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudpersonas;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Chris
 */
public class Institucion implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nombre;
    private int year;
    private String direccion;
    private String telefono;
    private List<Persona> personas;

    public Institucion(Integer id, String nombre, int year, String direccion, String telefono, List<Persona> personas) {
        this.id = id;
        this.nombre = nombre;
        this.year = year;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personas = personas;
    }
    //getters
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getYear() {
        return year;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Persona> getPersonas() {
        return personas;
    }
    
    //setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
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
        Institucion other = (Institucion) obj;
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
        return "Institucion{id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", Personas=" + personas + "}";
    }
    
    
}
