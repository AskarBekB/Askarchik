import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Client extends Application{
	@Override
	public void start(Stage stage){
		BorderPane pane = new BorderPane();

		try{
			Socket socket = new Socket("localhost",8000);
			DataInputStream input = new DataInputStream(socket.getInputStream());

				Platform.runLater(() -> {
					try{
						pane.setCenter(new Label("Server Visitor it: " + input.readInt()+""));
					}catch(IOException e){}
			});
			}catch(IOException e){}
		

		Scene scene = new Scene(pane,400,200);
		stage.setScene(scene);
		stage.show();
	}
}