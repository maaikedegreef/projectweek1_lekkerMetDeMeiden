package domain;

import java.util.ArrayList;

public class WoordenLijst {

    private ArrayList<String> woorden;

    public WoordenLijst(){
        this.woorden = new ArrayList<>();
    }

    public void voegToe(String woord) {
        if(woord == null) throw new DomainException("woord is null");
        if(woord.isEmpty()) throw new DomainException("woord is leeg");
        if(woorden.contains(woord)) throw new DomainException("woord is al toegevoegd");
        woorden.add(woord);
    }

    public int getAantalWoorden() {
        return woorden.size();
    }

    public String getRandomWoord(){
        if(woorden.size() == 0) return null;
        if(woorden.size() == 1) return woorden.get(0);
        int number = (int) (Math.random() * woorden.size());
        return woorden.get(number);

    }

}
