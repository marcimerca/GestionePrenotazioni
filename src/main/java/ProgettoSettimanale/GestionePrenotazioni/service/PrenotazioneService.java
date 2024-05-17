package ProgettoSettimanale.GestionePrenotazioni.service;

import ProgettoSettimanale.GestionePrenotazioni.PrenotazioneException;
import ProgettoSettimanale.GestionePrenotazioni.entities.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Prenotazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import ProgettoSettimanale.GestionePrenotazioni.enums.Tipo;
import ProgettoSettimanale.GestionePrenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    public void inserisciPrenotazione(Prenotazione prenotazione) throws PrenotazioneException {
        List<Prenotazione> prenotazioniAttualiPostazione = trovaPrenotazioniByDataEPostazione(prenotazione.getDataPrenotata(), prenotazione.getPostazione());

        List<Prenotazione> prenotazioniAttualiUtente = trovaPrenotazioniByUtenteEData(prenotazione.getDataPrenotata(), prenotazione.getUtente());

        if (prenotazioniAttualiPostazione.size() >= prenotazione.getPostazione().getNumMaxOccupanti()) {
            throw new PrenotazioneException("La postazione ha già raggiunto il numero massimo di occupanti (" + prenotazione.getPostazione().getNumMaxOccupanti() + ").");
        }
        if (!prenotazioniAttualiUtente.isEmpty()) {
            throw new PrenotazioneException("L'utente ha già delle prenotazioni attive per questa data: " + prenotazione.getDataPrenotata());
        }
        prenotazioneRepository.save(prenotazione);

    }

    public Prenotazione getPrenotazioneById(int id) {
        return prenotazioneRepository.findById(id).get();
    }

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void eliminaPrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.delete(prenotazione);
    }

    public List<Prenotazione> trovaPrenotazioniByDataEPostazione(LocalDate data, Postazione postazione) {
        return prenotazioneRepository.findByDataPrenotataAndPostazione(data, postazione);
    }

    public List<Prenotazione> trovaPrenotazioniByUtenteEData(LocalDate data, Utente utente) {
        return prenotazioneRepository.findByDataPrenotataAndUtente(data, utente);
    }



}
