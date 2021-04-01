
package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import domain.*;

public class FxTekenHangManApp extends Application {
    private Button maakVolgendeZichtbaarKnop = new Button("maak volgende zichtbaar");

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root,400,400);
        TekeningHangMan tekening = new TekeningHangMan(root);
        primaryStage.setScene(scene);
        root.getChildren().add(maakVolgendeZichtbaarKnop);

        primaryStage.setTitle("hangman");
        primaryStage.show();
        TekenVensterApp t = new TekenVensterApp(root,tekening);

        Cirkel boomkruin = new Cirkel(new Punt(50,50), 40);
        LijnStuk boomstam = new LijnStuk(new Punt(50,90), new Punt(50,240));
        Rechthoek gebouw = new Rechthoek(new Punt(100, 90), 100, 150);
        Driehoek dak = new Driehoek(new Punt(100, 90), new Punt(200, 90), new Punt(150, 45));


        maakVolgendeZichtbaarKnop.setOnAction(eventMaakVolgendeZichtbaar -> {
            try {
                tekening.zetVolgendeZichtbaar();
                new TekenVensterApp(root, tekening);
            } catch (DomainException e){
                maakVolgendeZichtbaarKnop.setDisable(true);
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}
