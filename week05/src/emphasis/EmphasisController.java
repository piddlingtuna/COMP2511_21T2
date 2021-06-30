package emphasis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EmphasisController {

    @FXML
    private TextField text;

    private Emphasis emphasis = new Emphasis();
    
    @FXML
    public void handleEmphasise(ActionEvent event) {
        emphasis.emphasis();
    }

    @FXML
    public void initialize() {
        emphasis.textProperty().bindBidirectional(text.textProperty());
    }
}
