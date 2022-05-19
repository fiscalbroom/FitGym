package FitGym;

import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Il programma contiene un sistema di login/autenticazione
 * - Per il login come amministratore usare "admin" come
 *   nome utente e password
 *   in questo modo si potranno utilizzare tutti i metodi
 *   del menù, aggiungendo e togliendo attrezzi o abbonati
 *   e prestando degli attrezzi a degli abbonati
 *
 * - Per il login come utente (della palestra) utilizzare
 *   come nome utente e password il nome utente del proprio
 *   computer (basta guardare il percorso file del progetto)
 *   in questo modo ci si potrà abbonare alla palestra,
 *   disdire l'abbonamento oppure visualizzare gli attrezzi disponibili
 */

public class Main {
    public static void main(String[] args) throws ParseException, InterruptedException {
        Scanner input = new Scanner(System.in);
        Palestra p = new Palestra();
        Caricamento caricamento = new Caricamento();

        /*
        il login aggiunge funzionalità, come descritto sopra
         */

        boolean bool = true;
        String nomeAdmin = "admin";
        String passAdmin = "admin";
        String nomeInput;
        String passInput;
        String nomeUtente = System.getProperty("user.name");
        String password = System.getProperty("user.name");

        System.out.println("*------------------------------------*");

        do {
            System.out.println("Inserire il nome utente");
            nomeInput = input.nextLine();
            System.out.println("Inserire la password");
            passInput = input.nextLine();
            if (Objects.equals(passInput.toLowerCase(), System.getProperty("user.name")) || Objects.equals(nomeInput.toLowerCase(), System.getProperty("user.name"))) {
                System.out.println("Bentornato " + System.getProperty("user.name"));
                System.out.println("Connesso da un dispositivo " + System.getProperty("os.name"));

                System.out.println("*------------------------------------*");

                int scelta = 0;
                int n = 0;

                caricamento.caricamentoConsole();


                while (n == 0) {
                    System.out.println(System.lineSeparator().repeat(50));
                    System.out.printf("""
                            *------------------------------------*
                            Ciao e benvenuto nella mia palestra!
                                                
                            Seleziona cosa desideri fare:
                            1) Abbonati
                            2) Disdici abbonamento
                            3) Visualizza attrezzi
                                                
                            (Per uscire dal programma premi 0)
                                                
                            Login  eseguito come: %s
                            *------------------------------------*
                                                
                            """, System.getProperty("user.name"));
                    scelta = input.nextInt();
                    switch (scelta) {
                        case 0:
                            System.out.println("Arrivederci " + System.getProperty("user.name"));
                            System.out.println("Abbi una buona giornata!");
                            return;
                        case 1:
                            Abbonato a = Abbonato.creaAbbonato(input);
                            p.aggiungiAbbonato(a);
                           break;
                        case 2:
                            System.out.println("Inserisci il codice dell'abbonato da rimuovere");
                            p.rimuoviAbbonatoDaCodice(input.nextLine());
                            break;
                        case 3:
                            p.stampaAttrezzi();
                            break;
                        default:
                            System.out.println("L'operazione richiesta è inesistente");
                    }
                }
            }if (Objects.equals(nomeAdmin, nomeInput) && Objects.equals(passAdmin, passInput)) {
                System.out.println("Bentornato admin");
                System.out.println("Connesso da un dispositivo " + System.getProperty("os.name"));

                System.out.println("*------------------------------------*");

                int scelta = 0;
                int n = 0;

                caricamento.caricamentoConsole();


                while (n == 0) {
                    System.out.println(System.lineSeparator().repeat(50));
                    System.out.printf("""
                            *------------------------------------*
                            Ciao e benvenuto nella mia palestra!
                                                
                            Seleziona cosa desideri fare:
                            1) Aggiungi attrezzo
                            2) Rimuovi attrezzo 
                            3) Aggiungi abbonato
                            4) Rimuovi abbonato
                            5) Presta un attrezzo a un abbonato
                            6) Stampa lista abbonati e attrezzi
                                                
                            (Per uscire dal programma premi 0)
                                                
                            Login  eseguito come: %s
                            *------------------------------------*
                                                
                            """, "admin");
                    scelta = input.nextInt();
                    switch (scelta) {
                        case 0:
                            System.out.println("Arrivederci admin");
                            System.out.println("Abbi una buona giornata!");
                            return;
                        case 1:
                            Attrezzi at = Attrezzi.daInput();
                            break;
                        case 2:
                            System.out.println("Inserisci il codice dell'attrezzo da rimuovere");
                            p.rimuoviAttrezzoDaCodice(input.nextLine());
                            break;
                        case 3:
                            Abbonato a = Abbonato.creaAbbonato(input);
                            p.aggiungiAbbonato(a);
                            break;
                        case 4:
                            System.out.println("Inserisci il codice dell'abbonato da rimuovere");
                            p.rimuoviAbbonatoDaCodice(input.nextLine());
                            break;
                        case 5:
                            System.out.println("Inserisci il codice dell'abbonato");
                            Abbonato abbonato = p.getAbbonatoDaCodiceTessera(input.nextLine());
                            if (abbonato == null) {
                                System.out.println("L'abbonato non è stato trovato");
                                break;
                            }
                            System.out.println("Seleziona un attrezzo da prestare inserendone il codice");
                            p.stampaAttrezzi();
                            Attrezzi attrezzo = null;
                            String codice;
                            while (attrezzo == null) {
                                codice = input.nextLine();
                                attrezzo = p.getAttrezzoDaCodice(codice);
                                if (attrezzo == null) {
                                    System.out.println("L'attrezzo non è ancora disponibile alla FitGym");
                                }
                            }
                            p.usaAttrezzo(abbonato, attrezzo);
                            break;
                        default:
                            System.out.println("L'operazione richiesta è inesistente");
                    }
                }
            }else{
                System.out.println("Credenziali errate, riprovare");
            }
        } while (true);
    }
}