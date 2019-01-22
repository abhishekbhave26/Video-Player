package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;



public class Controller implements Initializable

{

    private String filepath;
    private MediaPlayer mediaPlayer;
    @FXML
    private Label label;

    @FXML
    private MediaView mediaView;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        FileChooser fileChooser=new FileChooser();
        FileChooser.ExtensionFilter filter=new FileChooser.ExtensionFilter("Only MP4 files","*.mp4");
        fileChooser.getExtensionFilters().add(filter);

        File file=fileChooser.showOpenDialog(null);
        filepath=file.toURI().toString();

        if(filepath!=null)
        {
            Media media=new Media(filepath);
            mediaPlayer =new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        }

    }



    @FXML
    private void handlePauseAction(ActionEvent event)
    {
        mediaPlayer.pause();


    }


    @FXML
    private void handleResumeAction(ActionEvent event)
    {

        mediaPlayer.play();


    }

    @FXML
    private void runPy(ActionEvent event)
    {
        System.out.println("Here");
                try
                {
        ProcessBuilder pb = new ProcessBuilder("python","downloadVideo.py");
        Process p = pb.start();

    }
                catch(Exception e)
                {
                    System.out.println(e);
                }
        System.out.println("Done");
    }




    @Override
    public  void initialize(URL url, ResourceBundle rb)
    {
        //TODO
    }



}
