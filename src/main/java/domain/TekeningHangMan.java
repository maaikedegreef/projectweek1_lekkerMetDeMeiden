package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class TekeningHangMan extends Tekening{
    public TekeningHangMan(Pane root) {
        super();
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
        galgBodem.teken(root);
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
        galgStaaf.teken(root);
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
        hangbar.teken(root);
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
        koord.teken(root);
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);//na 1 fout
        hoofd.teken(root);
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
        oogLinks.teken(root);
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);// na 3
        oogRechts.teken(root);
        Vorm neus = new Cirkel(new Punt(280, 128), 2);// na 4
        neus.teken(root);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        mond.teken(root);
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        lijf.teken(root);
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        beenLinks.teken(root);
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        beenRechts.teken(root);
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        voetLinks.teken(root);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        voetRechts.teken(root);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        armLinks.teken(root);
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        armRechts.teken(root);
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        handLinks.teken(root);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        handRechts.teken(root);

    }



    public int getAantalOnzichtbaar() {
        return 0;
    }

    public void voegToe(Vorm vorm) {

    }

    public void verwijder(Vorm vorm) {

    }

    public void zetVolgendeZichtbaar() {

    }
}
