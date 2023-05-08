import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

public class App{

    Button standard,scientific,lenght,volume,weight,temparature;
    FlowPane fp,fpp;

    App(Stage st){

        SVGPath stan = new SVGPath();
        stan.setContent("M12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h8zM4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4z M4 2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-7a.5.5 0 0 1-.5-.5v-2zm0 4a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-4z");
        stan.setFill(Color.web("#8eda70"));

        SVGPath len = new SVGPath();
        len.setContent("M1 0a1 1 0 0 0-1 1v14a1 1 0 0 0 1 1h5v-1H2v-1h4v-1H4v-1h2v-1H2v-1h4V9H4V8h2V7H2V6h4V2h1v4h1V4h1v2h1V2h1v4h1V4h1v2h1V2h1v4h1V1a1 1 0 0 0-1-1H1z");
        len.setFill(Color.web("#8eda70"));

        SVGPath vol = new SVGPath();
        vol.setContent("M8.186 1.113a.5.5 0 0 0-.372 0L1.846 3.5 8 5.961 14.154 3.5 8.186 1.113zM15 4.239l-6.5 2.6v7.922l6.5-2.6V4.24zM7.5 14.762V6.838L1 4.239v7.923l6.5 2.6zM7.443.184a1.5 1.5 0 0 1 1.114 0l7.129 2.852A.5.5 0 0 1 16 3.5v8.662a1 1 0 0 1-.629.928l-7.185 2.874a.5.5 0 0 1-.372 0L.63 13.09a1 1 0 0 1-.63-.928V3.5a.5.5 0 0 1 .314-.464L7.443.184z");
        vol.setFill(Color.web("#8eda70"));

        SVGPath scie = new SVGPath();
        scie.setContent("");
        scie.setFill(Color.web("#8eda70"));

        SVGPath tmp = new SVGPath();
        tmp.setContent("M9.5 12.5a1.5 1.5 0 1 1-2-1.415V6.5a.5.5 0 0 1 1 0v4.585a1.5 1.5 0 0 1 1 1.415z M5.5 2.5a2.5 2.5 0 0 1 5 0v7.55a3.5 3.5 0 1 1-5 0V2.5zM8 1a1.5 1.5 0 0 0-1.5 1.5v7.987l-.167.15a2.5 2.5 0 1 0 3.333 0l-.166-.15V2.5A1.5 1.5 0 0 0 8 1z");
        tmp.setFill(Color.web("#8eda70"));

        SVGPath exi = new SVGPath();
        exi.setContent("M13.854 2.146a.5.5 0 0 1 0 .708l-11 11a.5.5 0 0 1-.708-.708l11-11a.5.5 0 0 1 .708 0Z M2.146 2.146a.5.5 0 0 0 0 .708l11 11a.5.5 0 0 0 .708-.708l-11-11a.5.5 0 0 0-.708 0Z");
        //exi.setFill(Color.web("#ff5c4d"));
        exi.setId("exi");


        scientific = new Button("SCIENTIFIC",scie);
        scientific.setContentDisplay(ContentDisplay.TOP);

        lenght = new Button("LENGHT",len);
        lenght.setContentDisplay(ContentDisplay.TOP);

        standard = new Button("STANDARD",stan);
        standard.setContentDisplay(ContentDisplay.TOP);

        volume = new Button("VOLUME",vol);
        volume.setContentDisplay(ContentDisplay.TOP);

        weight = new Button("WEIGHT");
        weight.setContentDisplay(ContentDisplay.TOP);

        temparature = new Button("TEMPARATURE",tmp);
        temparature.setContentDisplay(ContentDisplay.TOP);

        fp = new FlowPane();
        fp.setAlignment(Pos.CENTER);
        fp.setVgap(40);
        fp.setHgap(200);
        fp.getChildren().addAll(standard,scientific);        
        //fp.setStyle("-fx-background-color:blue;");


        
        VBox cal = new VBox();
        cal.setAlignment(Pos.TOP_CENTER);
        Label l = new Label("Calculations");
      
        Button Exit = new Button("",exi);
        Exit.setPrefSize(70,80); 
        Exit.setId("exit");

        FlowPane v = new FlowPane(Exit); 
       

        
        fpp = new FlowPane();
        fpp.setAlignment(Pos.CENTER);
        fpp.setVgap(40);
        fpp.setHgap(200);
        fpp.getChildren().addAll(lenght,volume,weight,temparature);
        // fpp.setStyle("-fx-background-color:blue;");
        cal.setSpacing(100);

        VBox v1 = new VBox();
        v1.setAlignment(Pos.TOP_CENTER);
        v1.setSpacing(70);
        v1.getChildren().addAll(l,fp);

        VBox v2 = new VBox();
        v2.setAlignment(Pos.TOP_CENTER);
        v2.setSpacing(70);
        v2.getChildren().addAll(new Label("Convertions"),fpp);

        cal.getChildren().addAll(v1,v2);

        

        BorderPane bp = new BorderPane();
        bp.setTop(v);
        bp.setCenter(cal);
        bp.setStyle("-fx-background-color:#353433;");
        bp.getStylesheets().add("Script.css");



        standard.setOnAction(ae->{
           st.setScene(Calculator.s);
           st.show();
        });

        scientific.setOnAction(ae->{
            new SCalcu(st);
        });

        lenght.setOnAction(ae->{
            new WCon(st,"Lenght");
        });

        volume.setOnAction(ae->{
            new WCon(st,"Volume");
        });

        weight.setOnAction(ae->{
            new WCon(st,"Weight");
        });

        temparature.setOnAction(ae->{
            new WCon(st,"Temp");
        });

        Scene s = new Scene(bp,Screen.getPrimary().getVisualBounds().getWidth(),Screen.getPrimary().getVisualBounds().getHeight());
        st.setScene(s);
        st.show();
    }
}



