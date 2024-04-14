package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
    public final static int DEFAULT_PESO_MAX_BORSA = 10; // Costante che rappresenta il peso massimo della borsa

    private Attrezzo[] attrezzi; // Array che contiene gli attrezzi nella borsa
    private int numeroAttrezzi; // Numero di attrezzi attualmente presenti nella borsa
    private int pesoMax; // Peso massimo che la borsa può contenere

    
    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA); // Chiama il costruttore con il peso massimo di default
    }
    
    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax; // Imposta il peso massimo della borsa
        this.attrezzi = new Attrezzo[10]; // Crea un array per gli attrezzi (sperando che bastino...)
        this.numeroAttrezzi = 0; // Inizializza il numero di attrezzi a 0
    }
    
    public boolean addAttrezzo(Attrezzo attrezzo) {
        // Verifica se aggiungere l'attrezzo supererebbe il peso massimo della borsa
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
            return false;
        // Verifica se la borsa è piena
        if (this.numeroAttrezzi == 10)
            return false;
        // Aggiunge l'attrezzo alla borsa e aumenta il contatore degli attrezzi
        this.attrezzi[this.numeroAttrezzi] = attrezzo;
        this.numeroAttrezzi++;
        return true;
    }
    

    public int getPesoMax() {
        return pesoMax; // Restituisce il peso massimo della borsa
    }
    
    
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        // Cerca l'attrezzo nella borsa per nome e lo restituisce se lo trova
        Attrezzo a = null;
        for (int i = 0; i < this.numeroAttrezzi; i++)
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
                a = attrezzi[i];
        return a;
    }

    

    public int getPeso() {
        int peso = 0; // Inizializza il peso totale della borsa
        // Calcola il peso totale sommando i pesi degli attrezzi presenti nella borsa
        for (int i = 0; i < this.numeroAttrezzi; i++)
            peso += this.attrezzi[i].getPeso();
        return peso; // Restituisce il peso totale della borsa
    }

    public boolean isEmpty() {
        return this.numeroAttrezzi == 0; // Verifica se la borsa è vuota
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null; // Verifica se la borsa contiene un attrezzo specifico
    }

    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        Attrezzo a = null;

        if (nomeAttrezzo != null) {
            // Cerca l'attrezzo nella borsa per nome
            int i = 0;
            for (Attrezzo att : this.attrezzi) {
                if (att != null) {
                    if (att.getNome().equals(nomeAttrezzo)) {
                        // Rimuove l'attrezzo dalla borsa e diminuisce il contatore degli attrezzi
                        a = att;
                        this.attrezzi[i] = null;
                        this.numeroAttrezzi--;
                    }
                }
                i++;
            }
        }
        return a; // Restituisce l'attrezzo rimosso dalla borsa
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        if (!this.isEmpty()) {
            // Costruisce una stringa rappresentante il contenuto della borsa
            s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
            for (int i = 0; i < this.numeroAttrezzi; i++)
                s.append(attrezzi[i].toString() + " ");
        } else
            s.append("Borsa vuota"); // Se la borsa è vuota, lo indica
        return s.toString();
    }
}