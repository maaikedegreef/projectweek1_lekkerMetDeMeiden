package ui;

import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;
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

    public RechthoekApp(GridPane root) {

        invoerBreedteLabel =  new Label("Geef de breedte van de rechthoek");
        invoerBreedte= new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek");
        invoerHoogte= new TextField();

        invoerLinkerBovenhoekXLabel = new Label("Geef de x coordinate van de linkerbovenhoek");
        invoerLinkerXBovenhoek = new TextField();
        invoerLinkerBovenhoekYLabel = new Label("Geef de Y coordinate van de linkerbovenhoek");
        invoerLinkerYBovenhoek = new TextField();

        root.add(invoerBreedteLabel , 0 ,0);
        root.add(invoerBreedte , 1 ,0);

        root.add(invoerHoogteLabel , 0 ,1);
        root.add(invoerHoogte , 1 ,1);

        root.add(invoerLinkerBovenhoekXLabel , 0 ,2);
        root.add(invoerLinkerXBovenhoek , 1 ,2);

        root.add(invoerLinkerBovenhoekYLabel , 0 ,3);
        root.add(invoerLinkerYBovenhoek , 1 ,3);

        invoerBreedte.setOnAction(eventIngaveBreedte ->{
            /* de tekst halen en een integer maken */
            try{
                Integer.parseInt(invoerBreedte.getText());
                root.add(invoerBreedteLabel , 0 ,0);
                root.add(invoerBreedte , 1 ,0);
            }catch (NumberFormatException e){

                invoerBreedte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Breedte is invalid");
                foutenboodschap.showAndWait();
            }

        } );

        invoerHoogte.setOnAction(eventIngaveBreedte ->{
            /* de tekst halen en een integer maken */
            try{
                Integer.parseInt(invoerHoogte.getText());
                root.add(invoerHoogteLabel , 0 ,0);
                root.add(invoerHoogte , 1 ,0);
            }catch (NumberFormatException e){

                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Hoogte is invalid");
                foutenboodschap.showAndWait();
            }

        } );
        invoerLinkerXBovenhoek.setOnAction(eventIngaveBreedte ->{
            /* de tekst halen en een integer maken */
            try{
                Integer.parseInt(invoerLinkerXBovenhoek.getText());
                root.add(invoerLinkerBovenhoekXLabel , 0 ,0);
                root.add(invoerLinkerXBovenhoek , 1 ,0);
            }catch (NumberFormatException e){

                invoerLinkerXBovenhoek.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x is invalid");
                foutenboodschap.showAndWait();
            }

        } );

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
            }
            catch(DomainException e){

                invoerLinkerYBovenhoek.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("breedte of lengte is invalid");
                foutenboodschap.showAndWait();
            }
        });






    }


}
