package ProgettoSettimanale.GestionePrenotazioni.entities;

import ProgettoSettimanale.GestionePrenotazioni.enums.Tipo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "postazioni")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codiceUnivoco;

    private String descrizione;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private int numMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    @Override
    public String toString() {
        return "Postazione{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", numMaxOccupanti=" + numMaxOccupanti +
                ", edificio=" + edificio +
                '}';
    }
}
