package lab8_2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {
	
	private List<Event> events = new ArrayList<>();

	@FXML
	private Pane saving, loading, listElements;
	@FXML
	private TextField start, duration, place,
			description;
	@FXML
	private TextArea members, listArea, loadedInfo;
	@FXML
	private Label startLabel, durationLabel;
	
	@FXML
	private boolean nextClick(ActionEvent event) {
		Event buffer = new Event();
		String[] dateTime = start.getText().split(" ");
		boolean breakInput = false;
		if (dateTime.length == 2 ? Input.isDateRight(dateTime[0]) && Input.isTimeRight(dateTime[1]) : false) {
			try {
				buffer.setStart(Input.dateIn(dateTime[0]+" "+dateTime[1]));
			} catch (ParseException e) {
				somethingGoesWrong(e, startLabel);
				breakInput = true;
			}
		} else {
			tryAgain(startLabel);
			breakInput = true;
		}
		if (Input.isTimeRight(duration.getText())) {
			try {
				buffer.setDuration(Input.timeIn(duration.getText()));
			} catch (ParseException e) {
				somethingGoesWrong(e, durationLabel);
				breakInput = true;
			}
		} else {
			tryAgain(durationLabel);
			breakInput = true;
		}
		if (breakInput) {
			return false;
		}
		if (place.getText() == null) {
			buffer.setPlace("");
		}
		else {
			buffer.setPlace(place.getText());
		}
		if (description.getText() == null) {
			buffer.setDescription("");
		}
		else {
			buffer.setDescription(description.getText());
		}
		List<String> membersList = new ArrayList<>();
		String[] membersArray = members.getText().split("(\n\r)|(\r\n)|\n|\r");
		for (String string : membersArray) {
			membersList.add(string);
		}
		buffer.setMembers(membersList);
		events.add(buffer);
		clear();
		return true;
	}

	@FXML
	private void saveClick(ActionEvent event) {
		if (nextClick(event) || events.size() > 0) {
			String path = FileManager.dirChoose();
			if (path != null) {
				FileManager.save(path, events);
				events.clear();
			}
		}
	}

	@FXML
	private void saveGoClick(ActionEvent event) {
		saving.setVisible(true);
		loading.setVisible(false);
		listElements.setVisible(false);
	}

	@FXML
	private void loadGoClick(ActionEvent event) {
		saving.setVisible(false);
		loading.setVisible(true);
		listElements.setVisible(false);
	}

	@FXML
	private void listGo(ActionEvent event) {
		saving.setVisible(false);
		loading.setVisible(false);
		listElements.setVisible(true);
		if (events.size() > 0) {
			listArea.setText(events.toString());
		} else {
			listArea.setText("You didn't create any event.");
		}
	}
	
	@SuppressWarnings("unchecked")
	@FXML
	private void loadClick(ActionEvent event) {
		String path = FileManager.selectFile();
		if (path != null) {
			List<Event> loadedText = (List<Event>) FileManager.load(path);
			loadedInfo.setText(loadedText.toString());
		}
	}
	
	private void clear() {
		startLabel.setText("Start(yyyy-MM-dd HH:mm:ss):");
		startLabel.setStyle("-fx-text-fill: #3EA689");
		durationLabel.setText("Duration (HH:mm:ss):");
		durationLabel.setStyle("-fx-text-fill: #3EA689");
		start.setText("");
		duration.setText("");
		place.setText("");
		description.setText("");
		members.setText("");
	}
	
	private void tryAgain(Label label) {
		if (!label.getText().matches("(Try again:){1}\\s+(.)+")) {
			label.setText("Try again:\n"+label.getText());
			label.setStyle("-fx-text-fill: #A63E53");
		}
	}
	
	private void somethingGoesWrong(Exception e, Label label) {
		label.setText("Something goes wrong");
		label.setStyle("-fx-text-fill: #A63E53");
		e.printStackTrace();
	}
}
