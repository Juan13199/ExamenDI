/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.examendi;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author casqu
 */
public class ParkingController implements Initializable {


    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn  colPlaza;
    @FXML
    private TableColumn  colMatricula;
    
     private ObservableList<Cliente> clientes;
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
    @FXML
    private TableView<Cliente> tbClientes;
    /**
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    clientes = FXCollections.observableArrayList();

        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colPlaza.setCellValueFactory(new PropertyValueFactory("plaza"));
        this.colMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
    }   
    
    @FXML
    private void agregar(ActionEvent event) {
         try {

            // Obtengo los datos del formulario
            String nombre = this.txtNombre.getText();
            String apellidos = this.textApellido.getText();
            int plaza = Integer.parseInt(this.textPlaza.getText());
            String matricula = this.textMatricula.getText();

            // Creo una persona
            Cliente p = new Cliente(nombre, apellidos, plaza, matricula);

            // Compruebo si el cliente esta en el lista
            if (!this.clientes.contains(p)) {
                // Lo añado a la lista
                this.clientes.add(p);
                // Seteo los items
                this.tbClientes.setItems(clientes);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Persona añadida");
                alert.showAndWait();
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La persona existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
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
