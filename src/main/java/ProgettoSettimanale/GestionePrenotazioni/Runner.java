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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    static Logger logger = LoggerFactory.getLogger("logger1");


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

        Utente utente3 = new Utente();
        utente3.setUsername("John");
        utente3.setNomeCompleto("Cena");
        utente3.setEmail("cena@gmail.com");


        Edificio edificio1 = new Edificio();
        edificio1.setCitta("Milano");
        edificio1.setNome("Grattacielo");
        edificio1.setIndirizzo("Via Giuseppe Meazza");

        Postazione postazione1 = new Postazione();

        postazione1.setTipo(Tipo.OPENSPACE);
        postazione1.setNumMaxOccupanti(2);
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
        utenteService.inserisciUtente(utente3);

        /*  System.out.println(utenteService.getUtenteById(1));*/

        /*System.out.println(postazioneService.getAllPostazioni());*/

        try {
            Prenotazione prenotazione1 = new Prenotazione();
            prenotazione1.setPostazione(postazione1);
            prenotazione1.setDataPrenotata(LocalDate.now());
            prenotazione1.setUtente(utente1);
            prenotazioneService.inserisciPrenotazione(prenotazione1);

        } catch (PrenotazioneException e) {
            logger.error(e.getMessage());
        }

        try {
            Prenotazione prenotazione2 = new Prenotazione();
            prenotazione2.setPostazione(postazione1);
            prenotazione2.setDataPrenotata(LocalDate.now());
            prenotazione2.setUtente(utente2);
            prenotazioneService.inserisciPrenotazione(prenotazione2);
        } catch (PrenotazioneException e) {
            logger.error(e.getMessage());
        }

        try {
            Prenotazione prenotazione3 = new Prenotazione();
            prenotazione3.setPostazione(postazione2);
            prenotazione3.setDataPrenotata(LocalDate.now());
            prenotazione3.setUtente(utente1);
            prenotazioneService.inserisciPrenotazione(prenotazione3);
        } catch (PrenotazioneException e) {
            logger.error(e.getMessage());

        }

        try {
            Prenotazione prenotazione4 = new Prenotazione();
            prenotazione4.setPostazione(postazione2);
            prenotazione4.setDataPrenotata(LocalDate.of(2024,5,20));
            prenotazione4.setUtente(utente1);
            prenotazioneService.inserisciPrenotazione(prenotazione4);
        } catch (PrenotazioneException e) {
            logger.error(e.getMessage());

        }
        try {
            Prenotazione prenotazione5 = new Prenotazione();
            prenotazione5.setPostazione(postazione1);
            prenotazione5.setDataPrenotata(LocalDate.now());
            prenotazione5.setUtente(utente3);
            prenotazioneService.inserisciPrenotazione(prenotazione5);
        } catch (PrenotazioneException e) {
            logger.error(e.getMessage());
        }


        /*System.out.println("Prova query");
        prenotazioneService.trovaPrenotazioniByDataEPostazione(LocalDate.of(2024, 05, 10), postazione1).forEach(System.out::println
        );*/

        System.out.println("_____Query ricerca postazione per tipo e città di interesse_____");
        System.out.println(postazioneService.findByTipoECittaDiInteresse(Tipo.OPENSPACE, "Milano"));


    }
}
