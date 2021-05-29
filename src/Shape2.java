	import javafx.application.Application;
	import javafx.geometry.Pos;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.VBox;
	import javafx.scene.paint.Color;
	import javafx.scene.text.Font;
	import javafx.scene.Scene;
	import javafx.scene.shape.ArcType;
	import javafx.stage.Stage;
	import javafx.scene.canvas.Canvas;
	import javafx.scene.canvas.GraphicsContext;
	import java.util.Arrays;
	
	public class Shape2 extends Application
	{
		private String shape = "", color ="";
		private static String[] validColors;
		private static String[] validShapes;
	    
		public void start (Stage stage)
		{

			
			//create and configure text field for input of shape
			TextField inputShape = new TextField();
			inputShape.setMaxWidth(100);
		
			//create and configure text field for input of color
			TextField inputColor = new TextField();
			inputColor.setMaxWidth(100);
			
			//create and configure Labels for the text field of shape
			Label labelShape = new Label("Shape");
			labelShape.setTextFill(Color.BLACK);
			labelShape.setFont(Font.font("Arial", 18));
			
			//create and configure Labels for the text field of color  
			Label labelColor = new Label("Color");
			labelColor.setTextFill(Color.BLACK);
			labelColor.setFont(Font.font("Arial", 18));
			
			//create and configure canvas
			 Canvas canvas = new Canvas(300,250);
			 GraphicsContext gc = canvas.getGraphicsContext2D();
		     
			//create a non-editable text area to display the results
			TextArea display = new TextArea();
			display.setEditable(false);         
			display.setMinSize(500,30);         
			display.setMaxSize(500,30); 
			
			//create and configure button to apply shape
			Button buttonShape = new Button();
			buttonShape.setText("Go!");
			buttonShape.setOnAction( e ->                     
			{ 
				clickAction(validShapes, inputShape, gc, display);
			     
			});
			

			//button to apply color
			Button buttonColor = new Button();
			buttonColor.setText("Go!");
			buttonColor.setOnAction( e ->   
			{ 
				clickAction(validColors, inputColor, gc, display);
			     
			});
			
		
			//create horizontal box for shape
			HBox inputComponentsShape = new HBox (15);
			inputComponentsShape.setAlignment(Pos.CENTER);
			inputComponentsShape.getChildren().addAll(labelShape, inputShape, buttonShape);
			
			//create horizontal box	
			HBox inputComponentsColor = new HBox (15);
			inputComponentsColor.setAlignment(Pos.CENTER);
			inputComponentsColor.getChildren().addAll(labelColor,inputColor,buttonColor );
			
			//create vertical box
			VBox root = new VBox(25);
			root.setAlignment(Pos.CENTER);
			root.getChildren().addAll(inputComponentsShape, inputComponentsColor, display, canvas);
			
			//create scene and add to the stage
			Scene scene = new Scene(root, 750, 550);
			stage.setScene(scene);
			stage.setTitle("Shapes");
			stage.show();				
		}
		
		
		public static void setValidColors(String[] array)
		{
			validColors = array;
		}
		
		public static void setValidShapes(String[] array)
		{
			validShapes = array;
		}
		
		public GraphicsContext setColor(GraphicsContext gc, String colorIn)
		{
			//apply color
			
			if(colorIn.equals("orange"))
				gc.setFill(Color.ORANGE);	
			
			else if(colorIn.equals("blue"))
				gc.setFill(Color.BLUE);
			
			else if(colorIn.equals("grey"))
				gc.setFill(Color.GREY);
			
			else
				gc.setFill(Color.WHITE);	
			
			return gc;
		}
		
		public GraphicsContext setShape(GraphicsContext gc, String shapeIn, TextArea displayIn)
		{
			//apply shape
			
		 	gc.setStroke(Color.BLACK); 
		 	
			if (shapeIn.equals("semi-circle"))
			{
				gc.fillArc(40, 40, 250, 250, 0, 180, ArcType.CHORD);
				gc.strokeArc(40, 40, 250, 250,0, 180,ArcType.CHORD);
			}
			
				
			else if (shapeIn.equals("rectangle"))
			{
				gc.fillRect(40, 40, 260, 150);			
				gc.strokeRect(40, 40, 260, 150);				

			}
				
			else if(shapeIn.equals("pentagon"))
			{   
				gc.fillPolygon(new double[]{130, 249, 203, 56, 11},
			            new double[]{0, 91, 231, 231, 91}, 5);
				gc.strokePolygon(new double[]{130, 249, 203, 56, 11},
			            new double[]{0, 91, 231, 231, 91}, 5);
			}
			else
			{
				displayIn.setText("Please select shape."); 				
			}
			return gc;
		}
		
		public GraphicsContext drawShape(GraphicsContext gc, String shapeIn, String colorIn, TextArea displayIn)
		{
			 	//clear canvas
				gc.clearRect(0, 0, 300,250);
				
				//set text on display			
				displayIn.setText("Success!"); 
				
			 	setColor(gc, colorIn);
				setShape(gc, shapeIn, displayIn);
				
				return gc;
		}
		
		public void clickAction(String[] validInput, TextField input, GraphicsContext gc,TextArea displayIn)
		{	
			//check if the input is valid.
			if(Arrays.asList(validInput).contains(input.getText().toLowerCase()))
			{
	
				if (validInput == validColors)
				{
					color = input.getText().toLowerCase();
					drawShape(gc, shape, color, displayIn);				
				}
				else if (validInput == validShapes)
				{
					shape = input.getText().toLowerCase();
					drawShape(gc, shape, color, displayIn);				
				}			
	
			}
			else
			{
				if (validInput == validColors)
				{
					displayIn.setText("Please enter a valid color. " + Arrays.toString(validColors)); 				
				}
				else if (validInput == validShapes)
				{
					displayIn.setText("Please enter a valid shape. " + Arrays.toString(validShapes)); 				
				}				
			}
		}
		
		

		

		//main
		public static void main(String[] args)
		{
			setValidColors(new String [] {"orange", "blue", "grey"});
			setValidShapes(new String [] {"semi-circle", "rectangle", "pentagon"});
			
			launch(args);
			
		}
		
	
		
		
	}	
		
		
		
		
	
	    
	
	
