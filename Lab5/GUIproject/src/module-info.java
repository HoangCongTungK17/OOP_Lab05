/**
 * 
 */
/**
 * 
 */
module GUIproject {
	requires javafx.controls;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.swing;
	requires javafx.base;

	opens hust.soict.hedspi.javafx to javafx.fxml;
	opens hust.soict.hedspi.aims.screen to javafx.fxml;
	opens hust.soict.hedspi.aims.media to javafx.base;

	exports hust.soict.hedspi.javafx to javafx.graphics, javafx.fxml;
}