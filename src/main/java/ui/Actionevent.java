package ui;

import domain.DomainException;
import domain.HintWoord;
import domain.Speler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Actionevent {

    public static void normalevent(GridPane root, int ycoordinate, TextField texfield, TextField nexttextfield, Label nextLabel, Alert alert, String errormessage) {
        texfield.setOnAction(eventIngaveBreedte -> {
            /* de tekst halen en een integer maken */
            try {
                Integer.parseInt(texfield.getText());
                root.add(nextLabel, 0, ycoordinate);
                root.add(nexttextfield, 1, ycoordinate);
            } catch (NumberFormatException e) {
                texfield.clear();
                alert.setTitle("Warning");
                alert.setContentText(errormessage);
                alert.showAndWait();
            }
        });

    }

    public static void raadWoordEvent(GridPane root, TextField raden, HintWoord woord, Speler speler, Label resultaatLabel, Label hintLabel, Alert foutenboodschap) {
        raden.setOnAction(eventIngaveLetter -> {
            try {
                char letter = raden.getText().toCharArray()[0];
                //checken of letter leeg is of meer dan 1 is!!

                root.getChildren().remove(resultaatLabel);
                if (woord.raad(letter)) {
                    resultaatLabel.setText("Super, doe zo voort!");
                    root.add(resultaatLabel, 0, 7);
                } else {
                    resultaatLabel.setText("Helaas volgende keer beter");
                    root.add(resultaatLabel, 0, 7);
                }
                root.getChildren().remove(hintLabel);
                hintLabel.setText(woord.toString());
                root.add(hintLabel, 0, 1);
                raden.clear();

            } catch (DomainException | ArrayIndexOutOfBoundsException e) {
                raden.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
            if (!woord.isGeraden()) {
                raadWoordEvent(root, raden, woord, speler, resultaatLabel, hintLabel, foutenboodschap);
            } else{
                root.getChildren().clear();
                Text uitvoer = new Text();
                uitvoer.setText("Goed gedaan " + speler.getNaam() + "! Je hebt het woord geraden");
                root.add(uitvoer, 0, 0);

            }

        });
    }
}
