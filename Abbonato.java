package FitGym;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Abbonato {
    /*
    Attributi dell'abbonato
     */
    private String nome;
    private String cognome;
    private String codiceTessera;
    private Date dataScadenza;

    private ArrayList<Attrezzi> attrezziInUso;

    /*
    Costruttori della classe abbonato
     */

    public Abbonato(String nome, String cognome, String codiceTessera, Date dataScadenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceTessera = codiceTessera;
        this.dataScadenza = dataScadenza;
    }
    public Abbonato(){
        this.attrezziInUso = new ArrayList<>();
    }

    /*
    Getter e Setter della classe abbonato
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceTessera() {
        return codiceTessera;
    }

    public void setCodiceTessera(String codiceTessera) {
        this.codiceTessera = codiceTessera;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public ArrayList<Attrezzi> getAttrezziInUso() {
        return attrezziInUso;
    }

    public void AttrezziInUso(Attrezzi at) {
        attrezziInUso.add(at);
    }

    /*
        Metodi toString e equals
         */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Abbonato{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", cognome='").append(cognome).append('\'');
        sb.append(", codiceTessera=").append(codiceTessera);
        sb.append(", dataScadenza=").append(dataScadenza);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abbonato abbonato = (Abbonato) o;

        if (getCodiceTessera() != abbonato.getCodiceTessera()) return false;
        if (getNome() != null ? !getNome().equals(abbonato.getNome()) : abbonato.getNome() != null) return false;
        if (getCognome() != null ? !getCognome().equals(abbonato.getCognome()) : abbonato.getCognome() != null)
            return false;
        return getDataScadenza() != null ? getDataScadenza().equals(abbonato.getDataScadenza()) : abbonato.getDataScadenza() == null;
    }

    /*
    Metodi della classe
     */

    public static Abbonato creaAbbonato(Scanner scanner) throws ParseException {
        scanner.nextLine();
        Abbonato abbonato = new Abbonato();
        System.out.println("Inserisci cognome");
        abbonato.cognome = scanner.nextLine();
        System.out.println("Inserisci nome");
        abbonato.nome = scanner.nextLine();
        System.out.println("Codice fiscal(e)");
        abbonato.codiceTessera = scanner.nextLine();
        System.out.println("Inserisci data scadenza nel formato dd/mm/yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        abbonato.dataScadenza = formatter.parse(scanner.nextLine());
        return abbonato;

    }

    public static void clrscr(){
        for(int i = 0; i < 80*300; i++){
            System.out.print("\b");
    }
}
}

