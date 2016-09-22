import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Zinoviy on 25.03.16.
 */
public class WindowDeleteData {
    ControllerDeleteData controller;
    Stage primaryStage = new Stage();
    public void openWindow()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("deleteData.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        controller =  loader.getController();
        controller.setWindowDeleteData(this);
        primaryStage.setScene(new Scene(root, 400 , 80));
        primaryStage.show();
    }

}
