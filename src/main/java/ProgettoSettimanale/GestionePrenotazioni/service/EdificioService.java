package ProgettoSettimanale.GestionePrenotazioni.service;

import ProgettoSettimanale.GestionePrenotazioni.entities.Edificio;
import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import ProgettoSettimanale.GestionePrenotazioni.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void inserisciEdificio(Edificio edificio){
        edificioRepository.save(edificio);
    }

    public Edificio getEdificioById(int id){
        return edificioRepository.findById(id).get();
    }

    public List<Edificio> getAllEdifici(){
        return edificioRepository.findAll();
    }

    public void eliminaEdificio(Edificio edificio){
       edificioRepository.delete(edificio);
    }
}
