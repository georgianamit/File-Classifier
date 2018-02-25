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
import javafx.scene.control.ProgressIndicator;
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
    private ProgressIndicator proInd;
    
    File selectedDir;
    int totalFiles=0;


    
    @FXML
    private void browseBtnAction(ActionEvent event) {
         DirectoryChooser dirChooser = new DirectoryChooser();
         dirChooser.setTitle("Choose Folder");
         Stage stage = (Stage)anchorid.getScene().getWindow();
         selectedDir = dirChooser.showDialog(stage);
         
         
         if(selectedDir != null){
             pathfield.setText(selectedDir.getAbsolutePath());
         }else{
             errorlbl.setText("Try Again!");
         }
    }
    
    @FXML
    private void goBtnAction(ActionEvent event){
        proInd.setVisible(true);
        proInd.setProgress(-1.0f);
        fileClassifier(selectedDir);
        proInd.setProgress(1.0f);
    }
    
    public void fileClassifier(File file){
        
        if(file.isDirectory()){
            File[] innerFiles = file.listFiles();
            for(int i =0;i<innerFiles.length;i++){
                fileClassifier(innerFiles[i]);
            }
        }else{
            String fileExt = getExtension(file);
            if(fileExt.equals("jpeg") || fileExt.equals("jpg")|| fileExt.equals("png")){
                moveTo(file,"Images");
            }else
                if(fileExt.equals("pdf")){
                    moveTo(file,"PDF Documents");
                }else
                    if(fileExt.equals("mp3")){
                        moveTo(file,"Music");
                    }else
                        if(fileExt.equals("docx")||fileExt.equals("doc")){
                            moveTo(file,"Word Documents");
                        }else
                            if(fileExt.equals("xlsx")||fileExt.equals("xls")){
                                moveTo(file,"Excel Documents");
                            }else
                                if(fileExt.equals("mp4")||fileExt.equals("mkv")){
                                    moveTo(file,"Videos");
                                }
            
        }
    }
    
    public void moveTo(File file, String foldername){
        File newdir = new File(file.getParent()+"\\"+foldername);
        newdir.mkdir();
        file.renameTo(new File(newdir.getPath(),file.getName()));
    }
    
    String getExtension(File file){
        String fileExt=file.getName();
        return fileExt.substring(fileExt.lastIndexOf('.')+1).toLowerCase();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
