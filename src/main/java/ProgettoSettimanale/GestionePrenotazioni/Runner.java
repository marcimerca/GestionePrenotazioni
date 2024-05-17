package ProgettoSettimanale.GestionePrenotazioni;

import ProgettoSettimanale.GestionePrenotazioni.entities.Edificio;
import ProgettoSettimanale.GestionePrenotazioni.entities.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Prenotazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import ProgettoSettimanale.GestionePrenotazioni.enums.Tipo;
import ProgettoSettimanale.GestionePrenotazioni.service.EdificioService;
import ProgettoSettimanale.GestionePrenotazioni.service.PostazioneService;
import ProgettoSettimanale.GestionePrenotazioni.service.PrenotazioneService;
import ProgettoSettimanale.GestionePrenotazioni.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;


    @Override
    public void run(String... args) throws Exception {

        Utente utente1 = new Utente();
        utente1.setUsername("mcmcm");
        utente1.setNomeCompleto("Marcello Mercanzin");
        utente1.setEmail("cjoidcj@gmail.com");

        Utente utente2 = new Utente();
        utente2.setUsername("The Rock");
        utente2.setNomeCompleto("Dwayne Johnson");
        utente2.setEmail("rock@gmail.com");

        Edificio edificio1 = new Edificio();
        edificio1.setCitta("Milano");
        edificio1.setNome("Grattacielo");
        edificio1.setIndirizzo("Via Giuseppe Meazza");

        Postazione postazione1 = new Postazione();

        postazione1.setTipo(Tipo.OPENSPACE);
        postazione1.setNumMaxOccupanti(1);
        postazione1.setDescrizione("Sala open");
        postazione1.setEdificio(edificio1);

        Postazione postazione2 = new Postazione();

        postazione2.setTipo(Tipo.SALA_RIUNIONI);
        postazione2.setNumMaxOccupanti(8);
        postazione2.setDescrizione("Riunione");
        postazione2.setEdificio(edificio1);

        edificioService.inserisciEdificio(edificio1);

        postazioneService.inserisciPostazione(postazione1);
        postazioneService.inserisciPostazione(postazione2);


        utenteService.inserisciUtente(utente1);
        utenteService.inserisciUtente(utente2);

        /*  System.out.println(utenteService.getUtenteById(1));*/

        /*System.out.println(postazioneService.getAllPostazioni());*/

        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setDataPrenotata(LocalDate.now());
        prenotazione1.setUtente(utente1);
        prenotazioneService.inserisciPrenotazione(prenotazione1);

        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setPostazione(postazione1);
        prenotazione2.setDataPrenotata(LocalDate.of(2024, 05, 10));
        prenotazione2.setUtente(utente2);
        prenotazioneService.inserisciPrenotazione(prenotazione2);

        System.out.println("Prova query");
        prenotazioneService.trovaPrenotazioniByDataEPostazione(LocalDate.of(2024, 05, 10), postazione1).forEach(System.out::println
        );


    }
}
