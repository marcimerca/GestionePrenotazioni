package ProgettoSettimanale.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String nomeCompleto;
    private String email;

    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
