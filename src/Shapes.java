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
	
	public class Shapes extends Application
	{
		private String shape = "", color ="";
	    
		public void start (Stage stage)
		{
			//Make array of valid input
			String colorValid[] = {"orange", "blue", "grey"};
			String shapeValid[] = {"semi-circle", "rectangle", "pentagon"};
			
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
			//set a stroke color on canvas
			 gc.setStroke(Color.BLACK); 
		     
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
				//check if the input is valid.
				if(Arrays.asList(shapeValid).contains(inputShape.getText().toLowerCase()))
				{	
					//assign shape
					shape = inputShape.getText().toLowerCase();
					
					//clear canvas
					gc.clearRect(0, 0, 300,250);
					
					//set text on display			
					display.setText("Success!"); 
										
					//apply color
					if(color.equals("orange"))
						gc.setFill(Color.ORANGE);	
					
					else if(color.equals("blue"))
						gc.setFill(Color.BLUE);
					
					else if(color.equals("grey"))
						gc.setFill(Color.GREY);
					
					else
						gc.setFill(Color.WHITE);	
					 
					//apply shape
					if (shape.equals("semi-circle"))
					{
						gc.fillArc(40, 40, 250, 250, 0, 180, ArcType.CHORD);
						gc.strokeArc(40, 40, 250, 250,0, 180,ArcType.CHORD);
					}
					
						
					else if (shape.equals("rectangle"))
					{
						gc.fillRect(40, 40, 260, 150);			
						gc.strokeRect(40, 40, 260, 150);				
		
					}
						
					else if(shape.equals("pentagon"))
					{   
						gc.fillPolygon(new double[]{130, 249, 203, 56, 11},
					            new double[]{0, 91, 231, 231, 91}, 5);
						gc.strokePolygon(new double[]{130, 249, 203, 56, 11},
					            new double[]{0, 91, 231, 231, 91}, 5);
					}
		
				}
				else
				{
					display.setText("Please enter a valid shape. (semi-circle, rectangle, or pentagon)"); 
				}
			     
			});
			

			//button to apply color
			Button buttonColor = new Button();
			buttonColor.setText("Go!");
			buttonColor.setOnAction( e ->   
			{ 
				//check if the input is valid.
				if(Arrays.asList(colorValid).contains(inputColor.getText().toLowerCase()))
				{
					//assign color
					color = inputColor.getText().toLowerCase();
					
					//set text on display
					display.setText("Success!"); 
					
					//apply color
					if(color.equals("orange"))
						gc.setFill(Color.ORANGE);
					
					else if(color.equals("blue"))
						gc.setFill(Color.BLUE);
					
					else if(color.equals("grey")) 
						gc.setFill(Color.GREY);
		
					//apply shape
					if (shape.equals("semi-circle"))
					{
						gc.fillArc(40, 40, 250, 250, 0, 180, ArcType.CHORD);
						gc.strokeArc(40, 40, 250, 250,0, 180,ArcType.CHORD);
					
					}
					
						
					else if (shape.equals("rectangle"))
					{
						gc.fillRect(40, 40, 260, 150);			
						gc.strokeRect(40, 40, 260, 150);			
					}
						
					else if (shape.equals("pentagon")) 
					{
						gc.fillPolygon(new double[]{130, 249, 203, 56, 11},
					            new double[]{0, 91, 231, 231, 91}, 5);
						gc.strokePolygon(new double[]{130, 249, 203, 56, 11},
					            new double[]{0, 91, 231, 231, 91}, 5);
					}
					
					else
					{
						display.setText("Please select shape."); 			
					}
		
				}
				else
				{
					display.setText("Please enter a valid color. (orange, blue, or grey)"); 
				}
			     
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
		
		
		
		public static void main(String[] args)
		{
			launch(args);
		}
		
	
		
		
	}	
		
		
		
		
	
	    
	
	
