package org.example.colorchooser;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class ColorChooserController {

    @FXML
    private Slider redSlider;

    @FXML
    private TextField redTextField;

    @FXML
    private Slider greenSlider;

    @FXML
    private TextField greenTextField;

    @FXML
    private Slider blueSlider;

    @FXML
    private TextField blueTextField;

    @FXML
    private Pane colorDisplayPane;

    public void initialize() {
        // Bi-directional bindings for sliders and text fields
        Bindings.bindBidirectional(redTextField.textProperty(), redSlider.valueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(greenTextField.textProperty(), greenSlider.valueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(blueTextField.textProperty(), blueSlider.valueProperty(), new NumberStringConverter());

        // Update the color display pane in real-time
        colorDisplayPane.backgroundProperty().bind(Bindings.createObjectBinding(() ->
                        new Background(new BackgroundFill(Color.rgb((int) redSlider.getValue(), (int) greenSlider.getValue(), (int) blueSlider.getValue()), null, null)),
                redSlider.valueProperty(), greenSlider.valueProperty(), blueSlider.valueProperty()));
    }
}
