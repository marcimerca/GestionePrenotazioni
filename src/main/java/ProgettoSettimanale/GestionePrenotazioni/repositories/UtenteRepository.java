package ProgettoSettimanale.GestionePrenotazioni.repositories;

import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
}
