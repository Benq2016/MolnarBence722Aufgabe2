package src;

import src.Domain.*;
import src.Repository.*;

import java.util.List;

public class Controller {
    Repository<Medikamente> medikamenteRepository = new inMemoryRepo<>();
    Repository<Patienten> patientenRepository = new inMemoryRepo<>();

    /**
     * Creates a new Medicine object with the specified details and adds it to the repository.
     * @param id the unique identifier of the medicament
     * @param name the name of the medicament
     * @param price the price of the medicament
     * @param krankheit the illness the medicament is designed to cure
     * @return the created Medikamente object
     */
    Medikamente createMedicament(Integer id, String name, Integer price, String krankheit){
        Medikamente medikamente = new Medikamente(id, name, price, krankheit);
        medikamenteRepository.add(medikamente);
        return medikamente;
    }

    /**
     * Removes a medicament from the repository using its ID.
     * @param id the unique identifier of the medicament to be removed
     */
    void removeMedicament(Integer id){
        medikamenteRepository.remove(id);
    }

    /**
     * Updates the details of an existing medicament in the repository.
     * @param id the unique identifier of the medicament to update
     * @param name the new name of the medicament
     * @param price the new price of the medicament
     * @param krankheit the new illness the medicament can cure
     * @return the updated Medikamente instance
     */
    Medikamente updateMedicament(Integer id, String name, Integer price, String krankheit){
        Medikamente medikamente = new Medikamente(id, name, price, krankheit);
        medikamenteRepository.update(medikamente);
        return medikamente;
    }

    /**
     * Retrieves a medicament by its unique identifier from the repository.
     * @param id the unique identifier
     * @return the medicine object corresponding to the given id,
     */
    Medikamente getMedicament(Integer id){
        return medikamenteRepository.get(id);
    }

    /**
     * Retrieves all the medicines available in the repository.
     * @return a list of all Medikamente objects from the repository
     */
    List<Medikamente> getAllMedicaments(){
        return medikamenteRepository.getAll();
    }

    /**
     * Creates a new patient with the specified details and adds it to the repository.
     * @param id the unique identifier of the patient
     * @param name the name of the patient
     * @param age the age of the patient
     * @param diagnose the diagnosis of the patient
     * @param medikamente the list of prescribed medicines for the patient
     * @return the created Patienten object
     */
    Patienten createPatient(Integer id, String name, Integer age, String diagnose, List<Medikamente> medikamente){
        Patienten patienten = new Patienten(id, name, age, diagnose, medikamente);
        patientenRepository.add(patienten);
        return patienten;
    }

    /**
     * Removes a patient from the repository using their unique identifier.
     * @param id the unique identifier of the patient to be removed
     */
    void removePatient(Integer id){
        patientenRepository.remove(id);
    }

    /**
     * Updates an existing patient's details and saves the updated information into the repository.
     * @param id the unique identifier of the patient to update
     * @param name the new name of the patient
     * @param age the new age of the patient
     * @param diagnose the new diagnosis of the patient
     * @param medikamente the new list of prescribed medicines for the patient
     * @return the updated Patienten object
     */
    Patienten updatePatient(Integer id, String name, Integer age, String diagnose, List<Medikamente> medikamente){
        Patienten patienten = new Patienten(id, name, age, diagnose, medikamente);
        patientenRepository.update(patienten);
        return patienten;
    }

    /**
     * Retrieves a patient by their unique identifier from the repository.
     * @param id the unique identifier of the patient to retrieve
     * @return the Patienten object corresponding to the given id, or null if no patient is found
     */
    Patienten getPatient(Integer id){
        return patientenRepository.get(id);
    }

    /**
     * Retrieves a list of all patients from the repository.
     * @return a list of Patienten objects representing all patients in the repository
     */
    List<Patienten> getAllPatients(){
        return patientenRepository.getAll();
    }

    /**
     * Filters the list of all patients based on a specific diagnosis.
     * @param diagnose the diagnosis string used for filtering patients
     * @return a list of Patienten objects whose diagnosis matches the given diagnose string
     */
    List<Patienten> filterDiagnose(String diagnose){
        return getAllPatients()
                .stream()
                .filter(patienten-> patienten.getDiagnose().equalsIgnoreCase(diagnose))
                .toList();
    }

    /**
     * Retrieves a list of patients who have been prescribed at least one medication
     * targeting the specified illness
     * @param krankheit the name of the illness used to filter patients by their prescribed medications
     * @return a list of Patienten objects whose medication list includes at least one medication
     *         designed for the specified illness
     */
    List<Patienten> getPatientenMitMedikamentAufKrankheit(String krankheit){
        return getAllPatients()
                .stream()
                .filter(patienten -> patienten.getMedikamente().stream()
                        .anyMatch(medikamente -> medikamente.getKrankheit().equalsIgnoreCase(krankheit))
                )
                .toList();
    }

    /**
     * Retrieves a sorted list of medications prescribed to a specific patient
     * either in ascending or descending order
     * @param patienten the patient whose medications are to be sorted
     * @param sort the sorting order, either "asc" for ascending or "desc" for descending
     * @return a list of Medikamente objects sorted by price in the specified order
     */
    List<Medikamente> getMedikamenteSortedNachPatienten(Patienten patienten, String sort){
        return patienten.getMedikamente()
                .stream()
                .sorted((m1, m2)->sort.equalsIgnoreCase("asc") ?
                        Integer.compare(m1.getPrice(), m2.getPrice()) :
                        Integer.compare(m2.getPrice(), m1.getPrice()))
                .toList();
    }
}