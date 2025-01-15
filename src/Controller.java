package src;

import src.Domain.*;
import src.Repository.*;

import java.util.List;

public class Controller {
    Repository<Medikamente> medikamenteRepository = new inMemoryRepo<>();
    Repository<Patienten> patientenRepository = new inMemoryRepo<>();

    Medikamente createMedicament(Integer id, String name, Integer price, String krankheit){
        Medikamente medikamente = new Medikamente(id, name, price, krankheit);
        medikamenteRepository.add(medikamente);
        return medikamente;
    }

    void removeMedicament(Integer id){
        medikamenteRepository.remove(id);
    }

    Medikamente updateMedicament(Integer id, String name, Integer price, String krankheit){
        Medikamente medikamente = new Medikamente(id, name, price, krankheit);
        medikamenteRepository.update(medikamente);
        return medikamente;
    }

    Medikamente getMedicament(Integer id){
        return medikamenteRepository.get(id);
    }

    List<Medikamente> getAllMedicaments(){
        return medikamenteRepository.getAll();
    }

    Patienten createPatient(Integer id, String name, Integer age, String diagnose, List<Medikamente> medikamente){
        Patienten patienten = new Patienten(id, name, age, diagnose, medikamente);
        patientenRepository.add(patienten);
        return patienten;
    }

    void removePatient(Integer id){
        patientenRepository.remove(id);
    }

    Patienten updatePatient(Integer id, String name, Integer age, String diagnose, List<Medikamente> medikamente){
        Patienten patienten = new Patienten(id, name, age, diagnose, medikamente);
        patientenRepository.update(patienten);
        return patienten;
    }

    Patienten getPatient(Integer id){
        return patientenRepository.get(id);
    }

    List<Patienten> getAllPatients(){
        return patientenRepository.getAll();
    }

    List<Patienten> filterDiagnose(String diagnose){
        return getAllPatients()
                .stream()
                .filter(patienten-> patienten.getDiagnose().equalsIgnoreCase(diagnose))
                .toList();
    }

    List<Patienten> getPatientenMitMedikamentAufKrankheit(String krankheit){
        return getAllPatients()
                .stream()
                .filter(patienten -> patienten.getMedikamente().stream()
                        .anyMatch(medikamente -> medikamente.getKrankheit().equalsIgnoreCase(krankheit))
                )
                .toList();
    }

    List<Medikamente> getMedikamenteSortedNachPatienten(Patienten patienten, String sort){
        return patienten.getMedikamente()
                .stream()
                .sorted((m1, m2)->sort.equalsIgnoreCase("asc") ?
                        Integer.compare(m1.getPrice(), m2.getPrice()) :
                        Integer.compare(m2.getPrice(), m1.getPrice()))
                .toList();

    }
}
