package domain;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan;
    private WoordenLijst woordenLijst;
    private HintWoord hintWoord;
    private boolean gewonnen;
    private boolean gameOver;

    public HangMan(Speler speler, WoordenLijst woordenLijst) {
        if (speler==null) throw new DomainException("Speler mag niet null zijn");
        if (woordenLijst==null) throw new DomainException("Woordenlijst mag niet null zijn");
        if (woordenLijst.getAantalWoorden()==0) throw new DomainException("Woordenlijst mag niet leeg zijn");
        this.speler = speler;
        this.tekeningHangMan = new TekeningHangMan();
        this.woordenLijst = woordenLijst;
        String woord = woordenLijst.getRandomWoord();
        this.hintWoord = new HintWoord(woord);
        this.gewonnen=false;
        this.gameOver=false;
    }

    public Speler getSpeler() {
        return speler;
    }

    public TekeningHangMan getTekening() {
        return tekeningHangMan;
    }

    public String getHint() {
        return hintWoord.toString();
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean raad(char letter) {
        if (!hintWoord.raad(letter)) {
            tekeningHangMan.zetVolgendeZichtbaar();
            if (tekeningHangMan.getAantalOnzichtbaar()==0){
                gameOver = true;
            }
            return false;
        }

        if (hintWoord.isGeraden()){
            gewonnen = true;
            gameOver = false;
        }
        return true;
    }

}
