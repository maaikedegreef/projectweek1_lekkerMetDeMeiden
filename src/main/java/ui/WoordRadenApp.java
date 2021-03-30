package ui;

import domain.HintLetter;
import domain.HintWoord;
import domain.Speler;
import javafx.scene.layout.GridPane;

public class WoordRadenApp {
    public static void main(String[] args) {

        HintWoord test = new HintWoord("test");
        System.out.println(test);

    }


    public WoordRadenApp(GridPane root, Speler speler) {
    }
}
