import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {

    Main mainWindow;
    ControllerAddData controller;
    Stage primaryStage = new Stage();
    @FXML public MenuItem aboutMenuItem;
    @FXML public MenuItem closeMenuItem;
    @FXML public TableView tableView;
    @FXML public Label tableName;
    @FXML public ChoiceBox<String> choiceTable;
    @FXML public MenuBar menuBar;
    @FXML public Button addButton;
    @FXML public Button deleteButton;

    public void setMainWindow(Main mainWindow)
    {
        this.mainWindow = mainWindow;
        tableView.setItems(mainWindow.currentData);

    }
    public void initialize()
    {
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainWindow.getStage().setTitle("Hey man!)");
            }
        });
        closeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainWindow.getStage().close();
            }
        });
        choiceTable.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                   mainWindow.loadTable(newValue);
                });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WindowAddData windowAddData = new WindowAddData();
                windowAddData.openWindow();
                //mainWindow.getStage().close();
        }
        });
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WindowDeleteData windowDeleteData = new WindowDeleteData();
                windowDeleteData.openWindow();
            }
        });

    }

}
