import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Zinoviy on 25.03.16.
 */
public class WindowAddData {
    ControllerAddData controller;
    Stage primaryStage = new Stage();
    WindowAddData()
    {

    }
    public void openWindow()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addData.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        controller =  loader.getController();
        controller.setWindowAddData(this);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
