package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class TekeningHangMan extends Tekening{
    ArrayList<Vorm> vormen = new ArrayList<>();
    Pane root;
    int index = 0;

    public TekeningHangMan(Pane root) {
        super();
        this.root = root;
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
        galgBodem.setZichtbaar(true);
        vormen.add(galgBodem);
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
        galgStaaf.setZichtbaar(true);
        vormen.add(galgStaaf);
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
        hangbar.setZichtbaar(true);
        vormen.add(hangbar);
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
        koord.setZichtbaar(true);
        vormen.add(koord);
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);//na 1 fout
        vormen.add(hoofd);
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
        vormen.add(oogLinks);
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);// na 3
        vormen.add(oogRechts);
        Vorm neus = new Cirkel(new Punt(280, 128), 2);// na 4
        vormen.add(neus);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        vormen.add(mond);
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        vormen.add(lijf);
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        vormen.add(beenLinks);
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        vormen.add(beenRechts);
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        vormen.add(voetLinks);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        vormen.add(voetRechts);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        vormen.add(armLinks);
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        vormen.add(armRechts);
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        vormen.add(handLinks);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        vormen.add(handRechts);
        zetVolgendeZichtbaar();
    }

    public int getAantalOnzichtbaar() {
        return 0;
    }

    public void voegToe(Vorm vorm) {
         vorm.teken(root);
    }

    public void verwijder(Vorm vorm) {

    }

    public void zetVolgendeZichtbaar() {
        vormen.get(index).setZichtbaar(true);
        int i = index;
        while(i < vormen.size()){
            if(vormen.get(i).isZichtbaar()) {
                voegToe(vormen.get(i));
                index = i+1;
            }
            i++;
        }
    }
}
