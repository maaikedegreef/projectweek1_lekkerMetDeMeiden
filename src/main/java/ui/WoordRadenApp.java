package ui;

import domain.DomainException;
import domain.HintLetter;
import domain.HintWoord;
import domain.Speler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class WoordRadenApp {
    private Label vraagLabel, hintLabel, radenLabel, resultaatLabel;
    private TextField raden;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    HintWoord woord = new HintWoord("hangman");

    public WoordRadenApp(GridPane root, Speler speler) {
        vraagLabel =  new Label("Rarara, welk woord zoeken we?");
        hintLabel =  new Label(woord.toString());
        radenLabel =  new Label("Geef een letter:");
        resultaatLabel =  new Label("Super, doe zo voort!");
        raden= new TextField();

        root.add(vraagLabel,0,0);
        root.add(hintLabel,0,1);
        root.add(radenLabel,0,3);
        root.add(raden,0,5);
        root.add(resultaatLabel,0,7);

        Actionevent.raadWoordEvent(root,raden,woord,speler,resultaatLabel,hintLabel,foutenboodschap);

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

    }
}
