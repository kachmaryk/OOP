package lab8_2;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		    Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\user\\IdeaProjects\\untitled\\src\\lab8_2\\fxml"));
			Scene scene = new Scene(root,525,525);
			scene.getStylesheets().add(getClass().getResource("C:\\Users\\user\\IdeaProjects\\untitled\\src\\lab8_2\\css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
