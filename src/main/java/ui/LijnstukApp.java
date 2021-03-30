package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnstukApp {

    private TextField invoerStartX, invoerStartY, invoerEindX, invoerEindY;
    private Label invoerStartXLabel, invoerStartYLabel, invoerEindXLabel, invoerEindYLabel;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING, "Warning");
    private LijnStuk lijnStuk;

    public LijnstukApp(GridPane root, Tekening tekening) {
        init(root, 1);

        invoerEindY.setOnAction(actionEvent -> {
            try{
                Integer.parseInt(invoerEindY.getText());
                lijnStuk = new LijnStuk(
                        new Punt(
                                Integer.parseInt(invoerStartX.getText()),
                                Integer.parseInt(invoerStartY.getText())),
                        new Punt(
                                Integer.parseInt(invoerEindX.getText()),
                                Integer.parseInt(invoerEindY.getText())));
                tekening.voegToe(lijnStuk);
                cleanUp(root);

            } catch (NumberFormatException e){
                invoerEindY.clear();
                foutenboodschap.setContentText("Invalid Y");
                foutenboodschap.showAndWait();
            } catch (DomainException e) {
                invoerEindY.clear();
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    public LijnstukApp(GridPane root) {
        init(root, 0);

        invoerEindY.setOnAction(actionEvent ->{
            try{
                Integer.parseInt(invoerEindY.getText());
                lijnStuk = new LijnStuk(
                        new Punt(
                                Integer.parseInt(invoerStartX.getText()),
                                Integer.parseInt(invoerStartY.getText())),
                        new Punt(
                                Integer.parseInt(invoerEindX.getText()),
                                Integer.parseInt(invoerEindY.getText())));

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
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        } );

    }

    private void init(GridPane root, int teller) {
        invoerStartXLabel =  new Label("Startpunt x: ");
        invoerStartX= new TextField();
        invoerStartYLabel =  new Label("Startpunt y: ");
        invoerStartY= new TextField();
        invoerEindXLabel =  new Label("Eindpunt x: ");
        invoerEindX = new TextField();
        invoerEindYLabel =  new Label("Eindpunt y: ");
        invoerEindY= new TextField();

        root.add(invoerStartXLabel, 0, teller);
        root.add(invoerStartX, 1, teller);

        invoerStartX.setOnAction(eventIngaveBreedte ->{
            try{
                Integer.parseInt(invoerStartX.getText());
                root.add(invoerStartYLabel , 0 ,teller + 1);
                root.add(invoerStartY , 1 ,teller + 1);

            }catch (NumberFormatException e){
                invoerStartX.clear();
                foutenboodschap.setContentText("Invalid X");
                foutenboodschap.showAndWait();
            }
        });

        invoerStartY.setOnAction(eventIngaveBreedte ->{
            try{
                Integer.parseInt(invoerStartY.getText());
                root.add(invoerEindXLabel , 0 ,teller + 2);
                root.add(invoerEindX , 1 ,teller + 2);


            }catch (NumberFormatException e){
                invoerStartY.clear();
                foutenboodschap.setContentText("Invalid Y");
                foutenboodschap.showAndWait();
            }
        } );

        invoerEindX.setOnAction(actionEvent ->{
            try{
                Integer.parseInt(invoerEindX.getText());
                root.add(invoerEindYLabel , 0 ,teller + 3);
                root.add(invoerEindY , 1 ,teller + 3);
            }catch (NumberFormatException e){
                invoerEindX.clear();
                foutenboodschap.setContentText("Invalid X");
                foutenboodschap.showAndWait();
            }
        } );
    }

    private void  cleanUp(GridPane root){
        root.getChildren().remove(invoerStartXLabel);
        root.getChildren().remove(invoerStartX);
        root.getChildren().remove(invoerStartYLabel);
        root.getChildren().remove(invoerStartY);
        root.getChildren().remove(invoerEindXLabel);
        root.getChildren().remove(invoerEindX);
        root.getChildren().remove(invoerEindYLabel);
        root.getChildren().remove(invoerEindY);
    }
}
