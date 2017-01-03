package readingFromFile;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class saveData implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public SimpleStringProperty word;
	public SimpleIntegerProperty lettersToGuess;
	public ObservableList<Node> letters;
	
	

}
