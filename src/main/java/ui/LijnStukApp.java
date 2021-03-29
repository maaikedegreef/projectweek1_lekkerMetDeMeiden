package ui;

import domain.DomainException;
import domain.LijnStuk;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnStukApp {

    private TextField invoerStartX, invoerStartY, invoerEindX, invoerEindY;
    private Label invoerStartXLabel, invoerStartYLabel, invoerEindXLabel, invoerEindYLabel;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private LijnStuk lijnStuk;
    private int x1, x2, y1, y2;

    public LijnStukApp(GridPane root) {
        invoerStartXLabel =  new Label("Startpunt x: ");
        invoerStartX= new TextField();

        invoerStartYLabel =  new Label("Startpunt y: ");
        invoerStartY= new TextField();

        invoerEindXLabel =  new Label("Eindpunt x: ");
        invoerEindX = new TextField();

        invoerEindYLabel =  new Label("Eindpunt y: ");
        invoerEindY= new TextField();

        root.add(invoerStartXLabel, 0, 0);
        root.add(invoerStartX, 1, 0);

        invoerStartX.setOnAction(eventIngaveBreedte ->{
            try{
                x1 = Integer.parseInt(invoerStartX.getText());
                root.add(invoerStartYLabel , 0 ,1);
                root.add(invoerStartY , 1 ,1);

            }catch (NumberFormatException e){
                invoerStartX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Invalid X");
                foutenboodschap.showAndWait();
            }
        } );

        invoerStartY.setOnAction(eventIngaveBreedte ->{
            try{
                y1 = Integer.parseInt(invoerStartY.getText());
                root.add(invoerEindXLabel , 0 ,2);
                root.add(invoerEindX , 1 ,2);


            }catch (NumberFormatException e){
                invoerStartY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Invalid Y");
                foutenboodschap.showAndWait();
            }
        } );

        invoerEindX.setOnAction(eventIngaveBreedte ->{
            try{
                x2 = Integer.parseInt(invoerEindX.getText());
                root.add(invoerEindYLabel , 0 ,3);
                root.add(invoerEindY , 1 ,3);
            }catch (NumberFormatException e){
                invoerEindX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Invalid X");
                foutenboodschap.showAndWait();
            }
        } );

        invoerEindY.setOnAction(eventIngaveBreedte ->{
            try{
                y2 = Integer.parseInt(invoerEindY.getText());
                lijnStuk = new LijnStuk(new Punt(x1, y1), new Punt(x2, y2));

                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(lijnStuk.toString());
                root.add(uitvoer, 0, 0);

            }catch (NumberFormatException e){
                invoerEindY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Invalid Y");
                foutenboodschap.showAndWait();
            } catch (DomainException e) {
                invoerEindY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        } );

    }
}
