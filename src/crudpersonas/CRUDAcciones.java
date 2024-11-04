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
       
      public Persona findPersona(Integer idIns, Integer idPersona) {
    // Load the institution by its ID
    Institucion institucion = select(idIns);
    if (institucion == null) {
        System.err.println("Institucion no encontrada con ID: " + idIns);
        return null; // Institution not found
    }

    // Get the list of persons and ensure it's not null
    List<Persona> personas = institucion.getPersonas();
    if (personas == null) {
        System.err.println("No hay personas registradas en la institucion con ID: " + idIns);
        return null; // No persons found
    }
    
    for (Persona persona : personas) {
        if (persona.getId() == idPersona) {
            System.out.println("Persona encontrada: " + persona);
            return persona; // Return the found person
        }
    }
    
    System.err.println("Persona no encontrada con ID: " + idPersona + " en la institucion ID: " + idIns);
    return null; // Person not found
}
      
      public boolean updatePersona(Integer idInstitucion, Integer idPersona, Persona updatedPersona) {
    // Step 1: Load the institution using its ID
    Institucion institucion = select(idInstitucion);
    
    if (institucion != null) {
        // Step 2: Find the person in the institution
        Persona foundPersona = null;
        
        for (Persona persona : institucion.getPersonas()) {
            if (persona.getId()==idPersona) {
                foundPersona = persona;
                break;
            }
        }
        
        // Step 3: Check if the person was found
        if (foundPersona != null) {
            // Step 4: Update the person's details
            foundPersona.setNombre(updatedPersona.getNombre());
            foundPersona.setaPaterno(updatedPersona.getaPaterno());
            foundPersona.setaMaterno(updatedPersona.getaMaterno());
            foundPersona.setEdad(updatedPersona.getEdad());
            
            // Step 5: Save the updated institution
            update(institucion);
            System.out.println("Persona actualizada: " + foundPersona);
            return true; // Return true indicating the update was successful
        } else {
            System.err.println("Persona con ID " + idPersona + " no encontrada en la institucion con ID " + idInstitucion);
            return false; // Return false if the person was not found
        }
    } else {
        System.err.println("Institucion con ID " + idInstitucion + " no encontrada.");
        return false; // Return false if the institution was not found
    }
}

}
