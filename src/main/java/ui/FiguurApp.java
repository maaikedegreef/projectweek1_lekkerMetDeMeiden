package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class FiguurApp {
    private ComboBox<String> keuzeMenu;
    private ObservableList<String> mogelijkeFiguren;

    public FiguurApp(GridPane root) {
        mogelijkeFiguren = FXCollections.observableArrayList("Lijnstuk", "Cirkel", "Rechthoek","Driehoek");
        keuzeMenu = new ComboBox(mogelijkeFiguren);
        root.add(keuzeMenu,0,0);
        keuzeMenu.setOnAction(eventKeuze -> {
            keuzeMenu.setVisible(false);

            if (keuzeMenu.getValue()!=null){

                switch (keuzeMenu.getValue()) {
                    case "Lijnstuk" -> new LijnstukApp(root);
                    case "Rechthoek" -> new RechthoekApp(root);
                    case "Cirkel" -> new CirkelApp(root);
                    //case "Driehoek" -> new DriehoekApp(root);
                }
            }
        });
    }
}