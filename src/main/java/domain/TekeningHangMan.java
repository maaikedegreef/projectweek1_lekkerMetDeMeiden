package domain;

public class TekeningHangMan extends Tekening {

    public TekeningHangMan() {
        super("Hangman");
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
        galgBodem.setZichtbaar(true);
        super.voegToe(galgBodem);
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
        galgStaaf.setZichtbaar(true);
        super.voegToe(galgStaaf);
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
        hangbar.setZichtbaar(true);
        super.voegToe(hangbar);
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
        koord.setZichtbaar(true);
        super.voegToe(koord);
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);//na 1 fout
        super.voegToe(hoofd);
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
        super.voegToe(oogLinks);
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);// na 3
        super.voegToe(oogRechts);
        Vorm neus = new Cirkel(new Punt(280, 128), 2);// na 4
        super.voegToe(neus);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        super.voegToe(mond);
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        super.voegToe(lijf);
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        super.voegToe(beenLinks);
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        super.voegToe(beenRechts);
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        super.voegToe(voetLinks);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        super.voegToe(voetRechts);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        super.voegToe(armLinks);
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        super.voegToe(armRechts);
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        super.voegToe(handLinks);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        super.voegToe(handRechts);

    }

    public int getAantalOnzichtbaar() {
        int aantal = 0;
        for (int i = 0; i < this.getAantalVormen(); i++) {
            if (!this.getVorm(i).isZichtbaar()) {
                aantal++;
            }
        }
        return aantal;
    }

    public void voegToe(Vorm vorm) {
        throw new DomainException("je mag geen vormen toevoegen aan de hangman");
    }

    public void verwijder(Vorm vorm) {
        throw new DomainException("je mag geen vormen verwijderen uit de hangman");
    }

    public void zetVolgendeZichtbaar() {
        this.getVorm(this.getAantalVormen() - getAantalOnzichtbaar()).setZichtbaar(true);
    }
}
