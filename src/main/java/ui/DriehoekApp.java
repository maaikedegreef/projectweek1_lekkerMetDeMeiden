package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {

    private Label invoerPunt1xLabel, invoerPunt1yLabel,invoerPunt2xLabel,invoerPunt2yLabel,invoerPunt3xLabel,invoerPunt3yLabel;
    private TextField invoerPunt1x, invoerPunt1y,invoerPunt2x,invoerPunt2y,invoerPunt3x,invoerPunt3y;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Driehoek driehoek;
    public DriehoekApp(GridPane root , Tekening tekening) {

        invoerPunt3yLabel = new Label("Geef de Y coordinaat van de linkerbovenhoek");
        invoerPunt3y = new TextField();
        init(root,1);
        invoerPunt3y.setOnAction(eventIngaveY -> {
            try {
                Punt punt1 = new Punt(Integer.parseInt(invoerPunt1x.getText()),Integer.parseInt(invoerPunt1y.getText()));
                Punt punt2 = new Punt(Integer.parseInt(invoerPunt2x.getText()),Integer.parseInt(invoerPunt2y.getText()));
                Punt punt3 = new Punt(Integer.parseInt(invoerPunt3x.getText()),Integer.parseInt(invoerPunt3y.getText()));
                driehoek = new Driehoek(punt1,punt2,punt3);
                tekening.voegToe(driehoek);
                cleanUp(root);
            } catch (NumberFormatException ne){
                invoerPunt3y.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            } catch (DomainException e){
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });

    }
    private void init(GridPane root, int teller){
        invoerPunt1xLabel =  new Label("Geef de x coordinaat van punt 1");
        invoerPunt1x= new TextField();
        invoerPunt1yLabel =  new Label("Geef de y coordinaat van punt 1");
        invoerPunt1y= new TextField();

        invoerPunt2xLabel =  new Label("Geef de x coordinaat van punt 2");
        invoerPunt2x= new TextField();
        invoerPunt2yLabel =  new Label("Geef de y coordinaat van punt 2");
        invoerPunt2y= new TextField();

        invoerPunt3xLabel =  new Label("Geef de x coordinaat van punt 3");
        invoerPunt3x= new TextField();
        invoerPunt3yLabel =  new Label("Geef de y coordinaat van punt 3");
        invoerPunt3y= new TextField();

        root.add(invoerPunt1xLabel , 0 ,1);
        root.add(invoerPunt1x , 1 ,1);
        Actionevent.normalevent(root , 2, invoerPunt1x , invoerPunt1y , invoerPunt1yLabel , foutenboodschap , "Coordinaat is invalid" );
        Actionevent.normalevent(root , 3, invoerPunt1y , invoerPunt2x , invoerPunt2xLabel , foutenboodschap , "Coordinaat is invalid" );
        Actionevent.normalevent(root ,  4,invoerPunt2x , invoerPunt2y , invoerPunt2yLabel , foutenboodschap , "Coordinaat is invalid" );
        Actionevent.normalevent(root , 5, invoerPunt2y , invoerPunt3x , invoerPunt3xLabel , foutenboodschap , "Coordinaat is invalid" );
        Actionevent.normalevent(root , 6, invoerPunt3x , invoerPunt3y , invoerPunt3yLabel , foutenboodschap , "Coordinaat is invalid" );

    }
    private void  cleanUp(GridPane root){

        root.getChildren().remove(invoerPunt1xLabel);
        root.getChildren().remove(invoerPunt1x);
        root.getChildren().remove(invoerPunt1yLabel);
        root.getChildren().remove(invoerPunt1y);
        root.getChildren().remove(invoerPunt2xLabel);
        root.getChildren().remove(invoerPunt2x);
        root.getChildren().remove(invoerPunt2yLabel);
        root.getChildren().remove(invoerPunt2y);
        root.getChildren().remove(invoerPunt3xLabel);
        root.getChildren().remove(invoerPunt3x);
        root.getChildren().remove(invoerPunt3yLabel);
        root.getChildren().remove(invoerPunt3y);

    }
    public DriehoekApp(GridPane root) {
        invoerPunt1xLabel =  new Label("Geef de x coordinaat van punt 1");
        invoerPunt1x= new TextField();
        invoerPunt1yLabel =  new Label("Geef de y coordinaat van punt 1");
        invoerPunt1y= new TextField();

        invoerPunt2xLabel =  new Label("Geef de x coordinaat van punt 2");
        invoerPunt2x= new TextField();
        invoerPunt2yLabel =  new Label("Geef de y coordinaat van punt 2");
        invoerPunt2y= new TextField();

        invoerPunt3xLabel =  new Label("Geef de x coordinaat van punt 3");
        invoerPunt3x= new TextField();
        invoerPunt3yLabel =  new Label("Geef de y coordinaat van punt 3");
        invoerPunt3y= new TextField();

        root.add(invoerPunt1xLabel , 0 ,0);
        root.add(invoerPunt1x , 1 ,0);

        Actionevent.normalevent(root , 1, invoerPunt1x , invoerPunt1y , invoerPunt1yLabel , foutenboodschap , "Coordinaat is invalid" );
        Actionevent.normalevent(root , 2, invoerPunt1y , invoerPunt2x , invoerPunt2xLabel , foutenboodschap , "Coordinaat is invalid" );
        Actionevent.normalevent(root ,  3,invoerPunt2x , invoerPunt2y , invoerPunt2yLabel , foutenboodschap , "Coordinaat is invalid" );
        Actionevent.normalevent(root , 4, invoerPunt2y , invoerPunt3x , invoerPunt3xLabel , foutenboodschap , "Coordinaat is invalid" );
        Actionevent.normalevent(root , 5, invoerPunt3x , invoerPunt3y , invoerPunt3yLabel , foutenboodschap , "Coordinaat is invalid" );

        invoerPunt3y.setOnAction(eventIngaveY -> {
            try {
                Punt punt1 = new Punt(Integer.parseInt(invoerPunt1x.getText()),Integer.parseInt(invoerPunt1y.getText()));
                Punt punt2 = new Punt(Integer.parseInt(invoerPunt2x.getText()),Integer.parseInt(invoerPunt2y.getText()));
                Punt punt3 = new Punt(Integer.parseInt(invoerPunt3x.getText()),Integer.parseInt(invoerPunt3y.getText()));

                driehoek = new Driehoek(punt1,punt2,punt3);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(driehoek.toString());
                root.add(uitvoer, 0, 0);

            } catch(NumberFormatException e){
                invoerPunt3y.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            } catch(DomainException e){
                invoerPunt3y.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

}
