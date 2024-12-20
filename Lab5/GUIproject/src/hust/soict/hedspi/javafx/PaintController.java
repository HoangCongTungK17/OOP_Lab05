package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaintController {
	boolean Eraser = false;
	private double eraserSize = 10.0;
	@FXML
	private Pane drawingAreaPane;

	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}

	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		// Check if the target is the drawing area
		if (event.getTarget() == drawingAreaPane) {
			if (Eraser) {
				Circle eraser = new Circle(event.getX(), event.getY(), eraserSize, Color.WHITE);
				drawingAreaPane.getChildren().add(eraser);
			} else {
				Circle pen = new Circle(event.getX(), event.getY(), 4, Color.AQUA);
				drawingAreaPane.getChildren().add(pen);
			}
		}
	}

	@FXML
	void penMode(ActionEvent event) {
		Eraser = false;
	}

	@FXML
	void eraserMode(ActionEvent event) {
		Eraser = true;
	}
}
