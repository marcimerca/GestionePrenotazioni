package ProgettoSettimanale.GestionePrenotazioni.service;

import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import ProgettoSettimanale.GestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void inserisciUtente(Utente utente){
        utenteRepository.save(utente);
    }

    public Utente getUtenteById(int id){
        return utenteRepository.findById(id).get();
    }

    public List<Utente> getAllUtenti(){
        return utenteRepository.findAll();
    }

    public void eliminaUtente(Utente utente){
        utenteRepository.delete(utente);
    }

}
