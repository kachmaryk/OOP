package lab8_2;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileManager {
	private FileManager() {}
	
	public static String dirChoose() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Save Document");
	    FileChooser.ExtensionFilter extFilter = 
	    new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
	    fileChooser.getExtensionFilters().add(extFilter);
	    Stage additionStage = new Stage();
	    additionStage.setScene(new Scene(new Pane()));
	    File file = fileChooser.showSaveDialog(additionStage);
	    if (file == null) {
	    	return null;
	    }
	    return file.getAbsolutePath();
	}
	
	public static String selectFile() {
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Document");
        FileChooser.ExtensionFilter extFilter = 
        new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        Stage additionStage = new Stage();
	    additionStage.setScene(new Scene(new Pane()));
	    File file = fileChooser.showOpenDialog(additionStage);
	    if (file == null) {
	    	return null;
	    }
	    return file.getAbsolutePath();
	}
	
	public static boolean save (String dir, Object obj) {
		try {
			XMLEncoder encoder;
			encoder = new XMLEncoder(
			           new BufferedOutputStream(
			           new FileOutputStream(dir)));
			encoder.writeObject(obj);
			encoder.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	
	public static Object load(String dir) {
		try {
			XMLDecoder decoder;
			decoder = new XMLDecoder(
			    new BufferedInputStream(
			    new FileInputStream(dir)));
	    	Object object = decoder.readObject();
	    	decoder.close();
			return object;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
	
}
