
import javafx.event.*;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;

public class SCalcu{
	
	static Button b[];
	static Button add,mul,div,sub,dot,res,clear,clearEntire,backspace;
	static Button sin,isin,cos,icos,tan,itan,sqr,log;
	static Button xpow,xpoy,pi,expo,epow,tenpow,fact;
	static String resstr;
	TextField t1;
	Label label;
	static GridPane gp,pp;
	BorderPane v;
	int i=0,c=0,a=0,d=0;
	char h = 'd';
	Float vlu;
	Boolean flag = true;
	static EventHandler<ActionEvent> buttonaction;
	Double result = 0.0,num1 = 0.0,num2 = 0.0;
	FlowPane fp = new FlowPane();
	ListView<Pane> option;
	ObservableList<Pane> ll = FXCollections.observableArrayList();
	static Scene s;

	SCalcu(Stage st){
		
		v = new BorderPane();

		SVGPath bk = new SVGPath();
		bk.setContent("M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z");


		buttonaction = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				if(!t1.getText().isEmpty())
					if(Double.parseDouble(t1.getText())==result){
						num1 = 0.0;
		         		t1.setText("");
						label.setText("");
					}
				t1.setText(t1.getText().concat(String.valueOf(((Button)ae.getSource()).getText())));
	   		}
		};
		
		gp = from1to9(buttonaction);
		
		t1 = new TextField();
		
		label = new Label();
		
		fp.getChildren().add(label);
		fp.setAlignment(Pos.CENTER_RIGHT);

		t1.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
	
		t1.setPadding(new Insets(7, 7, 7, 7));
		label.setPadding(new Insets(7, 7, 7, 7));

		
		t1.setPrefHeight(130);
		label.setPrefHeight(70);
		b = new Button[255];
		
		add = new Button("+");
		add.setPrefSize(170,100);

		sub = new Button("-");
		sub.setPrefSize(170,100);

		mul = new Button("*");
		mul.setPrefSize(170,100);

		div = new Button("/");
		div.setPrefSize(170,100);

		res = new Button("=");
		res.setPrefSize(170,100);
		
		dot = new Button(".");
		dot.setPrefSize(170,100);
		
		clear = new Button("C");
		clear.setPrefSize(170,100);

		clearEntire = new Button("CE");
		clearEntire.setPrefSize(170,100);

		backspace = new Button("",bk);
		backspace.setPrefSize(170,100);


		sin = new Button("sin");
		sin.setPrefSize(170,100);

		cos = new Button("cos");
		cos.setPrefSize(170,100);

		tan = new Button("tan");
		tan.setPrefSize(170,100);

		isin = new Button("cosec");
		isin.setPrefSize(170,100);

		icos = new Button("sec");
		icos.setPrefSize(170,100);
		
		itan = new Button("cot");
		itan.setPrefSize(170,100);

		log = new Button("log");
		log.setPrefSize(170,100);

		sqr = new Button("sqroot");
		sqr.setPrefSize(170,100);

		xpow = new Button("x2");
		xpow.setPrefSize(170,100);

		tenpow = new Button("10pow");
		tenpow.setPrefSize(170,100);

		xpoy = new Button("xy");
		xpoy.setPrefSize(170,100);

		pi = new Button("pi");
		pi.setPrefSize(170,100);

		fact = new Button("n!");
		fact.setPrefSize(170,100);
		
		expo = new Button("e");
		expo.setPrefSize(170,100);

		epow = new Button("ey");
		epow.setPrefSize(170,100);

	
		
		 gp.add(clear,4,1);
		 gp.add(clearEntire,5,1);
		 gp.add(backspace,6,1);


		 gp.add(add,7,2);
		 gp.add(sub,7,4);
		 gp.add(mul,4,5);
		 gp.add(div,7,3);
		 gp.add(res,7,5);
		 gp.add(dot,6,5);

		 gp.add(sin,2,1);
		 gp.add(cos,3,1);
		 gp.add(tan,2,2);
		 gp.add(isin,3,2);
		 gp.add(icos,2,3);
		 gp.add(itan,3,3);
		 gp.add(xpow,2,4);
		 gp.add(xpoy,3,4);

		 gp.add(tenpow,1,1);
		 gp.add(expo,1,2);
		 gp.add(epow,1,3);
		 gp.add(fact,1,4);
		 gp.add(pi,1,5);

		 gp.add(sqr,2,5);
		 gp.add(log,3,5);
	
		
		v.setCenter(new VBox(fp,t1,gp));
	
		SVGPath lines = new SVGPath();
        lines.setContent("M1 2.5A1.5 1.5 0 0 1 2.5 1h3A1.5 1.5 0 0 1 7 2.5v3A1.5 1.5 0 0 1 5.5 7h-3A1.5 1.5 0 0 1 1 5.5v-3zm8 0A1.5 1.5 0 0 1 10.5 1h3A1.5 1.5 0 0 1 15 2.5v3A1.5 1.5 0 0 1 13.5 7h-3A1.5 1.5 0 0 1 9 5.5v-3zm-8 8A1.5 1.5 0 0 1 2.5 9h3A1.5 1.5 0 0 1 7 10.5v3A1.5 1.5 0 0 1 5.5 15h-3A1.5 1.5 0 0 1 1 13.5v-3zm8 0A1.5 1.5 0 0 1 10.5 9h3a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 13.5v-3z");    
		lines.setScaleX(2);
		lines.setScaleY(2);

		Button threelines = new Button("",lines);
        threelines.setId("threeline"); 
		threelines.setPrefSize(30, 30);
		threelines.setStyle("-fx-background-color:transparent;");
       

		SVGPath hisd = new SVGPath();
		hisd.setContent("M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z");
		hisd.setScaleX(1.5);
		hisd.setScaleY(1.5);

		Button hisdel = new Button("",hisd);
		hisdel.setStyle("-fx-background-color:transparent;");
       
		Label his = new Label("History");
	
		v.setTop(threelines);

		option = new ListView<Pane>();
		option.setPrefSize(350,700);

		VBox right = new VBox();

		FlowPane ff = new FlowPane();
		ff.setPrefSize(350,60);
		ff.setAlignment(Pos.BOTTOM_RIGHT);
		ff.getChildren().add(hisdel);

		FlowPane tt = new FlowPane();
		tt.setAlignment(Pos.BOTTOM_CENTER);
		tt.getChildren().add(his);


		right.getChildren().addAll(tt,option,ff);

		v.setRight(right);
	

		add.setOnAction(ae->{
			if(h =='a'){
				num1 =  Double.parseDouble(t1.getText());
			}else{
				num1 = num1 + Double.parseDouble(t1.getText());
			}
			label.setText(label.getText()+t1.getText()+"+");
			h = '+';
		 	t1.setText("");
		});

		sub.setOnAction(ae->{	
			if(h =='a'){
				num1 =  Double.parseDouble(t1.getText());
			}else{
				num1 = Double.parseDouble(t1.getText());
			}
			label.setText(label.getText()+t1.getText()+"-");
		    h = '-';
			t1.setText("");
		});
		
		mul.setOnAction(ae->{
			if(h =='a'){
				num1 =  Double.parseDouble(t1.getText());
			}else{
				num1 = num1 * Double.parseDouble(t1.getText());
			}
			label.setText(label.getText()+t1.getText()+"*");
			h = '*';
			t1.setText("");
		});
		
		div.setOnAction(ae->{
			num2 = Double.parseDouble(t1.getText());
			label.setText(label.getText()+t1.getText()+"/");
			gettextvalue();	
		    h = '/';	
			t1.setText("");
		});

		xpoy.setOnAction(ae->{
			num1 = Double.parseDouble(t1.getText());
			System.out.println(num1);
			label.setText(label.getText()+t1.getText()+"^");
		    h = '^';
			t1.setText("");
		});
		
		res.setOnAction(ae->{	
			num2 = Double.parseDouble(t1.getText());
			label.setText(label.getText()+t1.getText()+"=");
			gettextvalue();
			setHistory();
			resstr = "";
			h = 'a';
	    });
		
		dot.setOnAction(ae->{
			t1.setText(t1.getText()+".");
		});

		clear.setOnAction(ae->{
			t1.setText("");
		});

		clearEntire.setOnAction(ae->{
			num1 = 0.0;
			num2 = 0.0;
			result = 0.0;
			h = 'n';
			t1.setText("");
			label.setText("");
		});

		backspace.setOnAction(ae->{
			String str = t1.getText();
			t1.setText("");
			for(int i=0;i<str.length()-1;i++){
				t1.setText(""+t1.getText()+str.charAt(i));
			}
		});
		
		threelines.setOnAction(ae->{
				new App(st);	
		});

		hisdel.setOnAction(ae->{
			ll.clear();
			option.setItems(ll);
			right.getChildren().removeAll(his,option,ff);
			right.getChildren().addAll(his,option,ff);
			v.setRight(right);
		});

		sin.setOnAction(ae->{
			Double r = Math.sin(Double.parseDouble(t1.getText()));
			t1.setText(""+r);
			label.setText(label.getText()+"sin("+t1.getText()+")");
		});

		cos.setOnAction(ae->{
			Double r = Math.cos(Double.parseDouble(t1.getText()));
			t1.setText(""+r);
			label.setText(label.getText()+"cos("+t1.getText()+")");
		});
		
		tan.setOnAction(ae->{
			Double r = Math.tan(Double.parseDouble(t1.getText()));
			t1.setText(""+r);
			label.setText(label.getText()+"tan("+t1.getText()+")");
		});

		isin.setOnAction(ae->{
			Double r = Math.sin(Double.parseDouble(t1.getText()));
			t1.setText(""+1/r);
			label.setText(label.getText()+"cosec("+t1.getText()+")");
		});
		
		icos.setOnAction(ae->{
			Double r = Math.cos(Double.parseDouble(t1.getText()));
			t1.setText(""+1/r);
			label.setText(label.getText()+"sec("+t1.getText()+")");
		});
		
		itan.setOnAction(ae->{
			Double r = Math.tan(Double.parseDouble(t1.getText()));
			t1.setText(""+1/r);
			label.setText(label.getText()+"cot("+t1.getText()+")");
		});
				
		xpow.setOnAction(ae->{
			Double r = Math.pow(Double.parseDouble(t1.getText()),2);
			t1.setText(""+r);
			label.setText(label.getText()+t1.getText()+"^2");
		});
		
		sqr.setOnAction(ae->{
			Double r = Math.sqrt(Double.parseDouble(t1.getText()));
			t1.setText(""+r);
			label.setText(label.getText()+"sqrt("+t1.getText()+")");
		});
		

		log.setOnAction(ae->{
			Double r = Math.log(Double.parseDouble(t1.getText()));
			t1.setText(""+r);
			label.setText(label.getText()+"log("+t1.getText()+")");
		});

		tenpow.setOnAction(ae->{
			Double r = Math.log10(Double.parseDouble(t1.getText()));
			t1.setText(""+r);
			label.setText(label.getText()+"10^"+t1.getText());
		});
		
		expo.setOnAction(ae->{
			Double r = Math.E;
			t1.setText(""+r);
			label.setText(label.getText()+t1.getText());
		});
		
		epow.setOnAction(ae->{
			Double r = Math.pow(Math.E,Double.parseDouble(t1.getText()));
			t1.setText(""+r);
			label.setText(label.getText()+"e^"+t1.getText());
		});

		fact.setOnAction(ae->{
			Double r = fact(Double.parseDouble(t1.getText()));
			t1.setText(""+r);
			label.setText(label.getText()+"fact("+t1.getText()+")");
		});
		
		pi.setOnAction(ae->{
			Double r = Math.PI;
			t1.setText(""+r);
			label.setText(label.getText()+t1.getText());
		});


		v.getStylesheets().add("main.css");
	    //v.setStyle("-fx-background-color:linear-gradient(to bottom,#5252ff,#5c5cff,#6161ff,#6b6bff,#7575ff,#7a7aff);");
		s = new Scene(v,Screen.getPrimary().getVisualBounds().getWidth(),Screen.getPrimary().getVisualBounds().getHeight());
		st.setTitle("Arithemetic Operations");
		st.setScene(s);
		st.show();
	}
	
	public void gettextvalue(){
		switch(h){
			case '+':result = num1+num2;
						break;
			case '-':result = num1-num2;
						break;
			case '*':result = num1*num2;
						break;
			case '/': result = num1/num2;
						break;
			case 'n':break;
			case '^': result = Math.pow(num1,num2);
						break;
		}
		if(result<0){
			String u = String.valueOf(result);
			String v = "";
			for(i=1;i<u.length();i++)
				v = v + u.charAt(i);
			t1.setText(""+v+"-");
		}
		else{
			t1.setText(String.valueOf(result));
		}
		resstr = String.valueOf(result);
		num1 = result;
	}

    public static GridPane from1to9( EventHandler<ActionEvent> aee){
		pp = new GridPane(); 
		b = new Button[10];
		for(int i=0;i<=9;i++){
			b[i] = new Button(""+i);
			b[i].setPrefSize(170,100);
			b[i].setOnAction(aee);
		}
		pp.add(b[2],5,2);
		pp.add(b[1],4,2);
		pp.add(b[3],6,2);
		pp.add(b[4],4,3);
		pp.add(b[5],5,3);
		pp.add(b[6],6,3);
		pp.add(b[7],4,4);
		pp.add(b[8],5,4);
		pp.add(b[9],6,4);
		pp.add(b[0],5,5);
		return pp;
	}

	public void setHistory(){
		VBox ss = new VBox();
		ss.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		ss.getChildren().addAll(new Label(label.getText()),new Label(resstr));
	
		ll.addAll(ss);
		option.setItems(ll);
	}


	public static Double fact(Double n){
		Double sum =1.0;
		for(int i=1;i<n;i++){
			sum *=i;
		}
		return sum;
	}
		
	}
	