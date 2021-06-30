package emphasis;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Emphasis {
    private StringProperty text = new SimpleStringProperty();

    // Uses default constructor.

    public void emphasis() {
        if (!getText().endsWith("!")) {
            setText(getText().toUpperCase() + "!!!!");
        }
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public StringProperty textProperty() {
        return text;
    }
}
