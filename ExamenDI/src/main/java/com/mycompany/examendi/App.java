package com.mycompany.examendi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
         //Creamos un objeto FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        
        //Indicamos la localizacion de nuestra vista fxml
        loader.setLocation(getClass().getResource("Parking.fxml"));
        //Indicamos el lugar donde se encuentra nuestro 
        //bundle.properties predeterminado
        loader.setResources(ResourceBundle.getBundle("com.mycompany.examendi.bundle.bundle"));
        //Carga todos los datos en un Parent
        Parent root = loader.load();
      
        //Indicamos el Titulo de la Ventana y el Estilo
        stage.setTitle("Parking-ES-EN");
       
        stage.getIcons().add(new Image("com/mycompany/examendi/images/espana.png"));
        stage.initStyle(StageStyle.DECORATED);
        
        //Seleccionamos la ventana y sus medidas
        scene = new Scene(root, 800, 500);
        
         //Mostramos la vista
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch();
    }

}