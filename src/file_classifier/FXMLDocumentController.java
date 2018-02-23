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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author spider
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label lbl;
    FileChooser fileChooser = new FileChooser();


    
    @FXML
    private void browseBtnAction(ActionEvent event) {
         File selectedDir = fileChooser.showOpenDialog(null);
         
         
         if(selectedDir != null){
             if(selectedDir.isDirectory()){
                 System.out.print("its ok");
             }
         }else{
             
         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser.setTitle("Choose Folder");
    }    
    
}
