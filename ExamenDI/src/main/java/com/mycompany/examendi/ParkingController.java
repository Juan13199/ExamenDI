/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.examendi;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author casqu
 */
public class ParkingController implements Initializable {


    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colApellido;
    @FXML
    private TableColumn<?, ?> colPlaza;
    @FXML
    private TableColumn<?, ?> colMatricula;
    @FXML
    private Label nombre;
    @FXML
    private Label apellido;
    @FXML
    private Label plaza;
    @FXML
    private Label matricula;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnSalida;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField textApellido;
    @FXML
    private TextField textPlaza;
    @FXML
    private TextField textMatricula;
    @FXML
    private Label hora;
    @FXML
    private Button btnEspaña, btnIngles;
     private ResourceBundle bundle;
    private Locale locale;
    private Stage stage;
    private Scene scene;
    /**
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void agregar(ActionEvent event) {
    }

    @FXML
    private void modificar(ActionEvent event) {
    }

    @FXML
    private void salir(ActionEvent event) {
    }
    
     public void LoadView(Locale locale) {
        //Creamos un objeto de tipo FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        
        //Indicamos la localizacion de nuestra vista fxml
        loader.setLocation(getClass().getResource("Parking.fxml"));
        
        //Indicamos el lugar donde se encuentra nuestro bundle.properties
        // y añadimos el archivo locale que hemos pasado en el metodo
        loader.setResources(ResourceBundle.getBundle("com.mycompany.examendi.bundle.bundle", locale));
        
        try {
            //Carga todos los datos en un Parent
            Parent root = loader.load();
            
            //En el Stage indicamos el objeto Parent, las medidas y lo mostramos
            stage = (Stage) btnEspaña.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void onClickButton(ActionEvent event) {
        
         Object evt = event.getSource();
        
        if(evt.equals(btnIngles)) { //Si pulsamos en el boton de Ingles
            
            //Creamos un objeto de tipo Locale que debe ser US 
            //asi debe terminar nuestro archivo .properties
            Locale l = new Locale("US");
            
            //Llamamos al metodo LoadView y le pasamos el parametro creado anteriormente
            LoadView(l);
            
        } else if(evt.equals(btnEspaña)) { //Si pulsamos en el boton de España
            
            //Creamos un objeto de tipo Locale que debe ser ES 
            //asi debe terminar nuestro archivo .properties
            Locale l = new Locale("ES");
            
            //Llamamos al metodo LoadView y le pasamos el parametro creado anteriormente
            LoadView(l);
    }

}
}
