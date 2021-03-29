package ui;

import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class RechthoekApp {

    private Label invoerBreedteLabel, invoerHoogteLabel , invoerLinkerBovenhoekXLabel , invoerLinkerBovenhoekYLabel;
    private TextField invoerBreedte, invoerHoogte , invoerLinkerXBovenhoek ,  invoerLinkerYBovenhoek;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Rechthoek rechthoek;
    public RechthoekApp(GridPane root, Tekening tekening) {

    }
    public RechthoekApp(GridPane root) {

        invoerBreedteLabel =  new Label("Geef de breedte van de rechthoek");
        invoerBreedte= new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek");
        invoerHoogte= new TextField();
        invoerLinkerBovenhoekXLabel = new Label("Geef de x coordinaat van de linkerbovenhoek");
        invoerLinkerXBovenhoek = new TextField();
        invoerLinkerBovenhoekYLabel = new Label("Geef de Y coordinaat van de linkerbovenhoek");
        invoerLinkerYBovenhoek = new TextField();

        root.add(invoerBreedteLabel , 0 ,0);
        root.add(invoerBreedte , 1 ,0);

        Actionevent.normalevent(root , 1, invoerBreedte , invoerHoogte , invoerHoogteLabel , foutenboodschap , "Breedte is invalid" );
        Actionevent.normalevent(root ,  2,invoerHoogte , invoerLinkerXBovenhoek , invoerLinkerBovenhoekXLabel , foutenboodschap , "Hoogte is invalid" );
        Actionevent.normalevent(root , 3, invoerLinkerXBovenhoek , invoerLinkerYBovenhoek , invoerLinkerBovenhoekYLabel , foutenboodschap , "Hoogte is invalid" );

        invoerLinkerYBovenhoek.setOnAction(eventIngaveY -> {
            try {
                Punt punt = new Punt(Integer.parseInt(invoerLinkerXBovenhoek.getText()) , Integer.parseInt(invoerLinkerYBovenhoek.getText()));
                rechthoek = new Rechthoek(punt , Integer.parseInt(invoerBreedte.getText()) , Integer.parseInt(invoerHoogte.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(rechthoek.toString());
                root.add(uitvoer, 0, 0);

            } catch(NumberFormatException e){
                invoerLinkerYBovenhoek.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Y is invalid");
                foutenboodschap.showAndWait();
            } catch(DomainException e){
                invoerLinkerYBovenhoek.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }
}
