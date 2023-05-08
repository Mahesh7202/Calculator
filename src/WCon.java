import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;

public class WCon{
	
	Button b[];
	TextField t1,t2;
	GridPane gp;
	Scene s;
	BorderPane v;
	int i=0,c=0,a=0,d=0;
	String h;
	Float vlu;
    Button resbut;
	int result=0;
	ComboBox<String> cb1,cb2;
	String  s1,s2;
	Button dot,clear,clearEntire,backspace;
	Boolean flag = false, flagm = false;
	String which;

	ObservableList<String> cb1lst,cb2lst;

	WCon(Stage st,String wh){
		which = wh;

		if(which.equals("Weight")){
			cb1lst = FXCollections.observableArrayList("gram","ton","kilogram","carat","pound");
			cb2lst = FXCollections.observableArrayList("kilogram","ton","gram","carat","pound");

		}else if(which.equals("Volume")){
			cb1lst = FXCollections.observableArrayList("liter","cubicmeter","milliliter","centiliter","gallon");
			cb2lst = FXCollections.observableArrayList("milliliter","cubicmeter","liter","centiliter","gallon");
	
		}else if(which.equals("Lenght")){
			cb1lst = FXCollections.observableArrayList("meter","miles","kilometer","inches","centimeter");
			cb2lst = FXCollections.observableArrayList("centimeter","miles","kilometer","inches","meter");

		}else if(which.equals("Temp")){
			cb1lst = FXCollections.observableArrayList("Fahrenheit","Celsius","Kelvin");
			cb2lst = FXCollections.observableArrayList("Celsius","Fahrenheit","Kelvin");

		}


		v = new BorderPane();

		EventHandler<ActionEvent> buttonaction = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				if(!t1.getText().isEmpty())
					if(flagm){
						flagm = false;
		         		t1.setText("");
					}
				if(flag)
					t1.setText(t1.getText().concat(String.valueOf(((Button)ae.getSource()).getText())));
				else
					t2.setText(t2.getText().concat(String.valueOf(((Button)ae.getSource()).getText())));
				result(s1,s2);
	   		}
		
		};
		

		SVGPath lines = new SVGPath();
        lines.setContent("M1 2.5A1.5 1.5 0 0 1 2.5 1h3A1.5 1.5 0 0 1 7 2.5v3A1.5 1.5 0 0 1 5.5 7h-3A1.5 1.5 0 0 1 1 5.5v-3zm8 0A1.5 1.5 0 0 1 10.5 1h3A1.5 1.5 0 0 1 15 2.5v3A1.5 1.5 0 0 1 13.5 7h-3A1.5 1.5 0 0 1 9 5.5v-3zm-8 8A1.5 1.5 0 0 1 2.5 9h3A1.5 1.5 0 0 1 7 10.5v3A1.5 1.5 0 0 1 5.5 15h-3A1.5 1.5 0 0 1 1 13.5v-3zm8 0A1.5 1.5 0 0 1 10.5 9h3a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 13.5v-3z");      lines.setScaleY(1.5);
        lines.setScaleX(1.5);

        Button threelines = new Button("",lines);
        threelines.setId("threeline"); 
        threelines.setPrefSize(40,40);
		threelines.setId("lines");
		threelines.setStyle("-fx-background-color:transparent;");
		
		v.setTop(new HBox(threelines));
		
		resbut = new Button("=");
		gp = Calculator.from1to9(buttonaction);
		gp.setAlignment(Pos.CENTER);
		

		SVGPath bk = new SVGPath();
		bk.setContent("M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z");

		dot = new Button(".");
		dot.setPrefSize(255,100);
		
		clear = new Button("C");
		clear.setPrefSize(255,100);

		clearEntire = new Button("CE");
		clearEntire.setPrefSize(255,100);

		backspace = new Button("",bk);
		backspace.setPrefSize(255,100);

			
		gp.add(clear,0,1);
		gp.add(clearEntire,1,1);
		gp.add(backspace,2,1);

		gp.add(dot,2,5);

		v.setRight(gp);

VBox main = new VBox();
main.setAlignment(Pos.CENTER_LEFT);

		VBox one =  new VBox();
		
		t1 = new TextField();
		t1.setPrefSize(700, 100);
		cb1 = new ComboBox<String>();
	
		cb1.setItems(cb1lst);
		cb1.getSelectionModel().selectFirst();
		one.setSpacing(20);
		one.getChildren().addAll(t1,cb1);

		VBox two =  new VBox();
		
		t2 = new TextField();
		t2.setPrefSize(700, 100);
		cb2 = new ComboBox<String>();
		cb2.setItems(cb2lst);
		cb2.getSelectionModel().selectFirst();
		
		s1 = cb1.getValue();
		s2 = cb2.getValue();

		two.getChildren().addAll(t2,cb2);
		two.setSpacing(20);

		main.setSpacing(100);
		main.setPadding(new Insets(15));
		main.getChildren().addAll(one,two);


v.setLeft(main);

t1.setOnAction(ae->{
	flag = true;
	result(s1,s2);
});

t2.setOnAction(ae->{
	result(s1,s2);
});

cb1.setOnAction(ae->{
	s1 = cb1.getValue();
	s2 = cb2.getValue();
});

cb2.setOnAction(ae->{
	s2 = cb2.getValue();
	s1 = cb1.getValue();
});

threelines.setOnAction(ae->{
	new App(st);
});

dot.setOnAction(ae->{
	t1.setText(t1.getText()+".");			
});

clear.setOnAction(ae->{
	t1.setText("");
});

clearEntire.setOnAction(ae->{
	t1.setText("");
	t2.setText("");
});

t1.setOnMouseClicked(ae->{
	flag = true;
	t1.setStyle("-fx-border-color:blue;");
	t2.setStyle("-fx-border-color:transparent;");
});

t2.setOnMouseClicked(ae->{
	flag = false;
	t1.setStyle("-fx-border-color:transparent;");
	t2.setStyle("-fx-border-color:blue;");
});

backspace.setOnAction(ae->{
	if(flag){
		String str = t1.getText();
		t1.setText("");
		for(int i=0;i<str.length()-1;i++){
			t1.setText(""+t1.getText()+str.charAt(i));
		}
	}
	else{
		String str = t2.getText();
		t2.setText("");
		for(int i=0;i<str.length()-1;i++){
			t2.setText(""+t2.getText()+str.charAt(i));
		}
	}
	});
	
		v.getStylesheets().add("submain.css");
		s = new Scene(v,Screen.getPrimary().getVisualBounds().getWidth(),Screen.getPrimary().getVisualBounds().getHeight());
		st.setScene(s);
		st.show();
}


public void result(String st1,String st2){
	if(which.equals("Weight")){
		if(st1.equals("gram")){
			if(st2.equals("kilogram")){
				if(flag){
					t2.setText(""+0.001*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.001*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("carat")){
				if(flag){
					t2.setText(""+ 5*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 5*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("ton")){
				if(flag){
					t2.setText(""+ 0.000001*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 0.000001*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("pound")){
				if(flag){
					t2.setText(""+ 0.002204*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 0.002204*(Double.parseDouble(t2.getText())));
				}
			}
		}

		if(st1.equals("kilogram")){
			if(st2.equals("gram")){
				if(flag){	
					Double r = (1000*(Double.parseDouble(t1.getText())));
					t2.setText(""+r);
				}else{
					Double r = (1000*(Double.parseDouble(t2.getText())));
					t1.setText(""+r);
				}
			}
			if(st2.equals("ton")){
				if(flag){
					t2.setText(""+ 0.001*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 0.001*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("carat")){
   				if(flag){			
					t2.setText(""+ 5000*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 5000*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("pound")){
				if(flag){	
					t2.setText(""+2.204*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+2.204*(Double.parseDouble(t2.getText())));
				}
			}
		}

		if(st1.equals("pound")){
			if(st2.equals("gram")){
				if(flag){
					Double r = (453.59237*(Double.parseDouble(t1.getText())));
					t2.setText(""+r);
				}else{
					Double r = (453.59237*(Double.parseDouble(t2.getText())));
					t1.setText(""+r);
				}
			}
			if(st2.equals("kilogram")){
				if(flag){
					t2.setText(""+0.45359*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.45359*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("carat")){
				if(flag){	
					t2.setText(""+2267.96187*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+2267.96187*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("ton")){
				if(flag){		
					t2.setText(""+0.00045359*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.00045359*(Double.parseDouble(t2.getText())));
				}
			}
		}
		if(st1.equals("ton")){
			if(st2.equals("gram")){
				if(flag){
					t2.setText(""+1000000*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+1000000*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("kilogram")){
				if(flag){
					t2.setText(""+1000*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+1000*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("carat")){
				if(flag){		
					t2.setText(""+5000000*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+5000000*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("pound")){
				if(flag){
					t2.setText(""+2204.6226*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+2204.6226*(Double.parseDouble(t2.getText())));
				}
			}
		}
		if(st1.equals("carat")){
			if(st2.equals("gram")){
				if(flag){
					t2.setText(""+0.0254*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.0254*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("kilogram")){
				if(flag){
					t2.setText(""+0.0000254*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.0000254*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("ton")){
				if(flag){
					t2.setText(""+0.0000002*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.0000002*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("pound")){
				if(flag){
					t2.setText(""+0.000441*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.000441*(Double.parseDouble(t2.getText())));
				}
			}
		}
	}else if(which.equals("Volume")){
		if(st1.equals("liter")){
			if(st2.equals("milliliter")){
				if(flag){
					t2.setText(""+1000*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+1000*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("centiliter")){
				if(flag){
					t2.setText(""+ 100*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 100*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("cubicmeter")){
				if(flag){
					t2.setText(""+ 0.001*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 0.001*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("gallon")){
				if(flag){
					t2.setText(""+ 0.26417*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 0.26417*(Double.parseDouble(t2.getText())));
				}
			}
		}

		if(st1.equals("milliliter")){
			if(st2.equals("liter")){
				if(flag){
					Double r = (0.001*(Double.parseDouble(t1.getText())));
					t2.setText(""+r);
				}else{
					Double r = (0.001*(Double.parseDouble(t2.getText())));
					t1.setText(""+r);
				}
			}
			if(st2.equals("cubicmeter")){
				if(flag){
					t2.setText(""+ 0.000001*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 0.000001*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("centiliter")){
				if(flag){
					t2.setText(""+ 0.1*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 0.1*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("gallon")){
				if(flag){
					t2.setText(""+0.00026417*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.00026417*(Double.parseDouble(t2.getText())));
				}
			}
		}

		if(st1.equals("gallon")){
			if(st2.equals("liter")){
				if(flag){
					t2.setText(""+3.785411*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+3.785411*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("milliliter")){
				if(flag){
					t2.setText(""+3785.411*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+3785.411*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("centiliter")){
				if(flag){
					t2.setText(""+378.5411*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+378.5411*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("cubicmeter")){
				if(flag){
					t2.setText(""+0.003785411*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.003785411*(Double.parseDouble(t2.getText())));
				}
			}
		}
		if(st1.equals("cubicmeter")){
			if(st2.equals("liter")){
				if(flag){
					t2.setText(""+1000*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+1000*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("milliliter")){
				if(flag){
					t2.setText(""+1000000*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+1000000*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("centiliter")){
				if(flag){
					t2.setText(""+100000*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+100000*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("gallon")){
				if(flag){
					t2.setText(""+264.1720524*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+264.1720524*(Double.parseDouble(t2.getText())));
				}
			}
		}
		if(st1.equals("centiliter")){
			if(st2.equals("liter")){
				if(flag){
					t2.setText(""+0.01*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.01*(Double.parseDouble(t2.getText())));
				}
			}	
			if(st2.equals("milliliter")){
				if(flag){
					t2.setText(""+10*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+10*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("cubicmeter")){
				if(flag){
					t2.setText(""+0.00001*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.00001*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("gallon")){
				if(flag){
					t2.setText(""+0.002641720524*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.002641720524*(Double.parseDouble(t2.getText())));
				}
			}
		}
	}else if(which.equals("Temp")){
		
		if(st1.equals("Celsius")){
			if(st2.equals("Fahrenheit")){
				if(flag){
					Double r = ((9/5) * Double.parseDouble(t1.getText()))+ 32;
					t2.setText(""+r);
				}else{
					Double r = ((9/5) * Double.parseDouble(t2.getText()))+ 32;
					t1.setText(""+r);
				}
			}
			if(st2.equals("Kelvin")){
				if(flag){
					Double r = (Double.parseDouble(t1.getText()) + 273.15);
					t2.setText(""+ r);
				}else{
					Double r = (Double.parseDouble(t2.getText()) + 273.15);
					t1.setText(""+ r);
				}
			}
		}

		if(st1.equals("Fahrenheit")){
			if(st2.equals("Celsius")){
				if(flag){
					Double r = ((5/9)*(Double.parseDouble(t1.getText())))-32;
					t2.setText(""+r);
				}else{
					Double r = ((5/9)*(Double.parseDouble(t2.getText())))-32;
					t1.setText(""+r);
				}
			}
			if(st2.equals("Kelvin")){
				if(flag){
					Double r = 273.5 + (Double.parseDouble(t1.getText())  - 32.0) * (5.0/9.0);
					t2.setText(""+r);
				}else{
					Double r = 273.5 + (Double.parseDouble(t2.getText())  - 32.0) * (5.0/9.0);
					t1.setText(""+r);
				}
			}
		}

		if(st1.equals("Kelvin")){
			if(st2.equals("Fahrenheit")){
				if(flag){
					Double r = (9.0/5.0)*(Double.parseDouble(t1.getText())) - 273+32;
					t2.setText(""+r);
				}else{
					Double r = (9.0/5.0)*(Double.parseDouble(t2.getText())) - 273+32;
					t1.setText(""+r);
				}
			}
			if(st2.equals("Celsius")){
				if(flag){
					Double r = Double.parseDouble(t1.getText())-273.15;
					t2.setText(""+r);
				}else{
					Double r = Double.parseDouble(t2.getText())-273.15;
					t1.setText(""+r);
				}
			}
		}
	}else if(which.equals("Lenght")){
		if(st1.equals("meter")){
			if(st2.equals("kilometer")){
				if(flag){
					t2.setText(""+0.001*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.001*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("inches")){
				if(flag){
					t2.setText(""+ 39.37*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 39.37*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("miles")){
				if(flag){
					t2.setText(""+ 0.000621371192*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 0.000621371192*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("centimeter")){
				if(flag){
					t2.setText(""+ 100*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 100*(Double.parseDouble(t2.getText())));
				}
			}
		}

		if(st1.equals("kilometer")){
			if(st2.equals("meter")){
				if(flag){
					Double r = (1000*(Double.parseDouble(t1.getText())));
					t2.setText(""+r);
				}else{
					Double r = (1000*(Double.parseDouble(t2.getText())));
					t1.setText(""+r);
				}
			
			}
			if(st2.equals("miles")){
				if(flag){
					t2.setText(""+ 0.621*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 0.621*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("inches")){

				if(flag){
					t2.setText(""+ 39370.0787*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+ 39370.0787*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("centimeter")){
				if(flag){
					t2.setText(""+100000*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+100000*(Double.parseDouble(t2.getText())));
				}
				
			}
		}

		if(st1.equals("centimeter")){
			if(st2.equals("meter")){
				if(flag){
					Double r = (0.01*(Double.parseDouble(t1.getText())));
					t2.setText(""+r);
				}else{
					Double r = (0.01*(Double.parseDouble(t2.getText())));
					t1.setText(""+r);
				}
			}
			if(st2.equals("kilometer")){
				if(flag){
					t2.setText(""+0.00001*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.00001*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("inches")){
				if(flag){
					t2.setText(""+0.393700787*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.393700787*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("miles")){
				if(flag){
					t2.setText(""+0.0000062137*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.0000062137*(Double.parseDouble(t2.getText())));
				}
			}
		}
		if(st1.equals("miles")){
			if(st2.equals("meter")){
				if(flag){
					t2.setText(""+1609.2693916*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+1609.2693916*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("kilometer")){
				if(flag){
					t2.setText(""+1.609269391*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+1.609269391*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("inches")){
				if(flag){
					t2.setText(""+63357.06260057*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+63357.06260057*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("centimeter")){
				if(flag){
					t2.setText(""+160926.93916961*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+160926.93916961*(Double.parseDouble(t2.getText())));
				}
			}
		}
		if(st1.equals("inches")){
			if(st2.equals("meter")){
				if(flag){
					t2.setText(""+0.0254*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.0254*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("kilometer")){
				if(flag){
					t2.setText(""+0.0000254*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.0000254*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("miles")){
				if(flag){
					t2.setText(""+0.0000157835600*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+0.0000157835600*(Double.parseDouble(t2.getText())));
				}
			}
			if(st2.equals("centimeter")){
				if(flag){
					t2.setText(""+2.54*(Double.parseDouble(t1.getText())));
				}else{
					t1.setText(""+2.54*(Double.parseDouble(t2.getText())));
				}
			}
		}
	}
}
}