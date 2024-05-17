package ProgettoSettimanale.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "prenotazioni")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    private LocalDate dataPrenotata;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


}
