package ProgettoSettimanale.GestionePrenotazioni.repositories;

import ProgettoSettimanale.GestionePrenotazioni.entities.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione,Integer> {



    //ricerca postazioni per tipo e citta interesse

    @Query("select p from Postazione p where p.tipo = :tipo and p.edificio.citta = :citta")
    public List<Postazione> findByTipoAndCittaDiInteresse(Tipo tipo, String citta);
}
