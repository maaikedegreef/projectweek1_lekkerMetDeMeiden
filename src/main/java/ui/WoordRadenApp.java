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


<<<<<<< HEAD
    public WoordRadenApp(GridPane root, Speler speler) {
=======
        /*raden.setOnAction(eventIngaveLetter ->{
            try{
                char letter = raden.getText().toCharArray()[0];

                if (woord.isGeraden()){
                    root.getChildren().clear();
                    Text uitvoer = new Text();
                    uitvoer.setText("Goed gedaan "+speler.getNaam()+"! Je hebt het woord geraden");
                    root.add(uitvoer, 0, 0);;
                } else {
                    if (woord.raad(letter)){
                        resultaatLabel.setText("Super, doe zo voort!");
                        root.add(resultaatLabel,0,7);
                    } else {
                        resultaatLabel.setText("Helaas volgende keer beter");
                        root.add(resultaatLabel,0,7);
                    }
                    hintLabel.setText(woord.toString());
                }
            } catch (DomainException e){
                raden.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });*/

>>>>>>> parent of 7834a21... Story 12 af wejow
    }
}
