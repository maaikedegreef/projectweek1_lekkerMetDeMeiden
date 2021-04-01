package domain;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan;
    private WoordenLijst woordenLijst;
    private HintWoord hintWoord;
    private boolean gewonnen;

    public HangMan(Speler speler, WoordenLijst woordenLijst) {
        if (speler==null) throw new DomainException("Speler mag niet null zijn");
        if (woordenLijst==null) throw new DomainException("Woordenlijst mag niet null zijn");
        if (woordenLijst.getAantalWoorden()==0) throw new DomainException("Woordenlijst mag niet leeg zijn");
        this.speler = speler;
        this.tekeningHangMan = new TekeningHangMan();
        this.woordenLijst = woordenLijst;
        this.hintWoord = new HintWoord(woordenLijst.getRandomWoord());
        this.gewonnen=false;
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
        return !gewonnen;
    }

    public boolean raad(char letter) {
        return gewonnen;
    }

}
