package domain.db;

import domain.model.DomainException;
import domain.model.Woord;

import java.util.ArrayList;

public class Woordenlijst {

    private ArrayList<Woord> woorden;

    public Woordenlijst(){
        this.woorden = new ArrayList<>();
    }

    public void voegToe(Woord woord) {
        if(woord == null) throw new DomainException("woord is null");
        if(woordInWoordenlijst(woord)) throw new DomainException("woord is al toegevoegd");
        woorden.add(woord);
    }

    public ArrayList<Woord> getWoorden() {
        return woorden;
    }
    public boolean woordInWoordenlijst(Woord woord){
        for(Woord wrd : woorden){
            if (woord.equals(wrd)){
                return true;
            }
        }
        return false;
    }
}
