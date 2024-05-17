package ProgettoSettimanale.GestionePrenotazioni.repositories;

import ProgettoSettimanale.GestionePrenotazioni.entities.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Prenotazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {

    public List<Prenotazione> findByDataPrenotataAndPostazione(LocalDate data, Postazione postazione);

    //troco prenotazione da utente

    public List<Prenotazione> findByDataPrenotataAndUtente(LocalDate data, Utente utente);



}
