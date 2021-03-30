package ui;

import domain.*;
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
        invoerLinkerBovenhoekYLabel = new Label("Geef de Y coordinaat van de linkerbovenhoek");
        invoerLinkerYBovenhoek = new TextField();
        init(root,1);
        invoerLinkerYBovenhoek.setOnAction(eventIngaveStraal -> {
            try {
                Punt punt = new Punt(Integer.parseInt(invoerLinkerXBovenhoek.getText()) , Integer.parseInt(invoerLinkerYBovenhoek.getText()));
                rechthoek = new Rechthoek(punt , Integer.parseInt(invoerBreedte.getText()) , Integer.parseInt(invoerHoogte.getText()));
                tekening.voegToe(rechthoek);
                cleanUp(root);

            } catch (NumberFormatException ne){
                invoerLinkerYBovenhoek.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e){
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }
    private void init(GridPane root, int teller){
        invoerBreedteLabel =  new Label("Geef de breedte van de rechthoek");
        invoerBreedte= new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek");
        invoerHoogte= new TextField();
        invoerLinkerBovenhoekXLabel = new Label("Geef de x coordinaat van de linkerbovenhoek");
        invoerLinkerXBovenhoek = new TextField();
        invoerLinkerBovenhoekYLabel = new Label("Geef de Y coordinaat van de linkerbovenhoek");
        invoerLinkerYBovenhoek = new TextField();

        root.add(invoerBreedteLabel , 0 ,1);
        root.add(invoerBreedte , 1 ,1);

        Actionevent.normalevent(root , 2, invoerBreedte , invoerHoogte , invoerHoogteLabel , foutenboodschap , "Breedte is invalid" );
        Actionevent.normalevent(root ,  3,invoerHoogte , invoerLinkerXBovenhoek , invoerLinkerBovenhoekXLabel , foutenboodschap , "Hoogte is invalid" );
        Actionevent.normalevent(root , 4, invoerLinkerXBovenhoek , invoerLinkerYBovenhoek , invoerLinkerBovenhoekYLabel , foutenboodschap , "Hoogte is invalid" );

    }
    private void  cleanUp(GridPane root){
        root.getChildren().remove(invoerBreedteLabel);
        root.getChildren().remove(invoerBreedte);
        root.getChildren().remove(invoerHoogteLabel);
        root.getChildren().remove(invoerHoogte);
        root.getChildren().remove(invoerLinkerBovenhoekXLabel);
        root.getChildren().remove(invoerLinkerXBovenhoek);
        root.getChildren().remove(invoerLinkerBovenhoekYLabel);
        root.getChildren().remove(invoerLinkerYBovenhoek);

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
