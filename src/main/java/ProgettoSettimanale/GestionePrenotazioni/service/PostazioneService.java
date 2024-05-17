package ProgettoSettimanale.GestionePrenotazioni.service;

import ProgettoSettimanale.GestionePrenotazioni.entities.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import ProgettoSettimanale.GestionePrenotazioni.enums.Tipo;
import ProgettoSettimanale.GestionePrenotazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;


    public void inserisciPostazione(Postazione postazione){
        postazioneRepository.save(postazione);
    }

    public Postazione getPostazioneById(int id){
        return postazioneRepository.findById(id).get();
    }

    public List<Postazione> getAllPostazioni(){
        return postazioneRepository.findAll();
    }

    public void eliminaPostazione(Postazione postazione){
       postazioneRepository.delete(postazione);
    }

    //cerca per tipo e citta di interesse

    public List<Postazione> findByTipoECittaDiInteresse(Tipo tipo, String citta){
        return postazioneRepository.findByTipoAndCittaDiInteresse(tipo,citta);

    }


}
