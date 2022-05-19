package FitGym;

import java.util.Objects;
import java.util.Scanner;

/**
 * Questa classe contiene metodi per la gestione e creazione degli oggetti
 * della classe attrezzo, in aggiunta ai getter/setter e i costruttori della classe
 */

public class Attrezzi {


    //attributi
    private String nomeOggetto;
    private int quantità;
    private String codice;

    static Scanner input = new Scanner(System.in);

    public String getNomeOggetto() {
        return nomeOggetto;
    }

    public void setNomeOggetto(String nomeOggetto) {
        this.nomeOggetto = nomeOggetto;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Attrezzi() {
    }

    public Attrezzi(String nomeOggetto, int quantità, String codice) {
        this.nomeOggetto = nomeOggetto;
        this.quantità = quantità;
        this.codice = codice;
    }

    public static Attrezzi daInput (){
        Attrezzi attrezzo = new Attrezzi();
        System.out.println("Nome oggetto: \n");
        attrezzo.setNomeOggetto(input.nextLine());
        System.out.println("Codice oggetto: \n");
        attrezzo.setCodice(input.nextLine());
        System.out.println("Inserisci la quantità iniziale: \n");
        attrezzo.setQuantità(input.nextInt());
        return attrezzo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attrezzi attrezzi = (Attrezzi) o;
        return getQuantità() == attrezzi.getQuantità() && getCodice() == attrezzi.getCodice() && Objects.equals(getNomeOggetto(), attrezzi.getNomeOggetto());
    }

    /*
    Metodi aggiuntivi per aggiungere/togliere un attrezzo (come quantità)
    Oppure impostarne la quantità
     */

    public void aggiungiAttrezzo(){
        this.quantità++;
    }

    public void rimuoviAttrezzo(){
        this.quantità--;
    }

    public void impostaQuantita(int quantità){
        this.quantità = quantità;
    }
}
