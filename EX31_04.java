import java.util.*;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.application.Application;
import javafx.application.Platform;
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

public class EX31_04 extends Application {
		int numOfClients = 0;
	@Override
	public void start(Stage stage){
		StackPane pane = new StackPane();
		TextArea tf = new TextArea("");
		pane.setAlignment(Pos.CENTER);
		new Thread(()->{
			try{
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() ->{
						tf.appendText("Server started at "+new Date()+"\n");
					});
				while(true){
					Socket socket =  serverSocket.accept();
					InetAddress inetAddress = socket.getInetAddress(); 
					new Thread(() ->{
						
					try{
						numOfClients++;
					DataOutputStream output = new DataOutputStream(socket.getOutputStream());
					DataInputStream input = new DataInputStream(socket.getInputStream());
					output.writeInt(numOfClients);
					Platform.runLater(() ->{
						tf.appendText("Client number "+numOfClients+"\n");
						tf.appendText("Inet address: "+inetAddress.getHostName());
					});
				}catch(IOException e){}
					}).start();				
				}
			
			}catch(IOException e){}
		}).start();

		pane.getChildren().add(tf);
		Scene scene = new Scene(pane,400,200);
		stage.setScene(scene);
		stage.show();
	}
}