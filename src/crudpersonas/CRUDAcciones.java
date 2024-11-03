/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudpersonas;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris
 */
public class CRUDAcciones {
    private final String PATH_FOLDER = "C:/uaemex/paradigmas1/escuelas/instituciones";
    
    public CRUDAcciones() {
        // Ensure the directory exists
        File folder = new File(PATH_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }
    
    public void insertar(Institucion institucion){
        File file = new File(PATH_FOLDER + File.separator + institucion.getId() + ".txt");
     try (FileOutputStream fileOut = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(institucion);
            System.out.println("Institucion guardada" + institucion);
        } catch (IOException e) {
            System.err.println("Error agregando la institucion: " + e.getMessage());
        }
    
    }
    
    public Institucion select(Integer id) {
        Institucion institucion = null;
        File file = new File(PATH_FOLDER + File.separator + id + ".txt");
        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            institucion = (Institucion) in.readObject();
            System.out.println("Institucion leida " + institucion);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error selecting album: " + e.getMessage());
        }
        return institucion;
    }
    
     public List<Integer> list() {
        List<Integer> ids = new ArrayList<>();
        File folder = new File(PATH_FOLDER);
        String[] pathnames = folder.list();
        if (pathnames != null) {
            for (String pathname : pathnames) {
                try {
                    Integer id = Integer.valueOf(pathname.replace(".txt", ""));
                    ids.add(id);
                    System.out.println("Encontrado ID de la institucion: " + id);
                } catch (NumberFormatException e) {
                    System.err.println("Nombre invalido: " + pathname);
                }
            }
        }
        return ids;
    }
     
       public void update(Institucion institucion) {
        insertar(institucion); // Reuse insert logic to handle update
    }
       
       public void delete(Integer id) {
        File file = new File(PATH_FOLDER + File.separator + id + ".txt");
        if (file.delete()) {
            System.out.println("Institucion borrada: " + id);
        } else {
            System.err.println("Error al borrar la institucion con id: " + id);
        }
    }
}
