package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
    static final private int CFU_INIZIALI = 20; // Costante che rappresenta i CFU iniziali del giocatore

    private int cfu; // Punti CFU del giocatore
    private Borsa borsa; // La borsa del giocatore, che contiene gli attrezzi
    
    public Giocatore() {
        this.cfu = CFU_INIZIALI; // Imposta i CFU iniziali
        this.borsa = new Borsa(); // Crea una nuova borsa vuota per il giocatore
    }

    public int getCfu() {
        return this.cfu; // Restituisce i CFU del giocatore
    }

    public void setCfu(int cfu) {
        this.cfu = cfu; // Imposta i CFU del giocatore
    }

    public Borsa getBorsa() {
        return borsa; // Restituisce la borsa del giocatore
    }

    public void setBorsa(Borsa borsa) {
        this.borsa = borsa; // Imposta la borsa del giocatore
    }
	
	
}
