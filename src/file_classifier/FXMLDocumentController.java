/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_classifier;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
/**
 *
 * @author spider
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label errorlbl;
    @FXML
    private TextField pathfield;
    @FXML
    private AnchorPane anchorid;



    
    @FXML
    private void browseBtnAction(ActionEvent event) {
         DirectoryChooser dirChooser = new DirectoryChooser();
         dirChooser.setTitle("Choose Folder");
         Stage stage = (Stage)anchorid.getScene().getWindow();
         File selectedDir = dirChooser.showDialog(stage);
         
         
         if(selectedDir != null){
             pathfield.setText(selectedDir.getAbsolutePath());
         }else{
             errorlbl.setText("The folder is not being open. Try Again!");
         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
