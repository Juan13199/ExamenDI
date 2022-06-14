package com.mycompany.examendi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

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
        
        
        //Seleccionamos la ventana y sus medidas
        scene = new Scene(root, 1000, 700);
        
         //Mostramos la vista
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch();
    }

}