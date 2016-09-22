import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Classes.*;
import sample.Service.*;

import java.lang.annotation.Target;
import java.sql.SQLException;


/**
 * Created by Zinoviy on 25.03.16.
 */
public class ControllerAddData {
    @FXML
    public Button buttonTarget;
    @FXML
    public TextField targetEditorTarget;
    @FXML
    public Button buttonPacking;
    @FXML
    public TextField packingEditorPacking;
    @FXML
    public TextField weightEditorPacking;
    @FXML
    public Button buttonProducer;
    @FXML
    public TextField firmEditorProducer;
    @FXML
    public TextField countryEditorProducer;
    @FXML
    public TextField ratingEditorProducer;
    @FXML
    public Button buttonKind;
    @FXML
    public TextField kindEditorKind;
    @FXML
    public Button buttonMainTable;
    @FXML
    public TextField nameEditorMainTable;
    @FXML
    public TextField infoEditorMainTable;
    @FXML
    public TextField usingEditorMainTable;
    @FXML
    public TextField priceEditorMainTable;
    @FXML
    public TextField firmEditorMainTable;
    @FXML
    public TextField countryEditorMainTable;
    @FXML
    public TextField ratingEditorMainTable;
    @FXML
    public TextField kindEditorMainTable;
    @FXML
    public TextField packingEditorMainTable;
    @FXML
    public TextField weightEditorMainTable;
    @FXML
    public TextField targetEditorMainTable;

    WindowAddData windowAddData;

    public void setWindowAddData(WindowAddData windowAddData) {
        this.windowAddData = windowAddData;
    }

    public void initialize() {

    buttonTarget.setOnAction(new EventHandler<ActionEvent>()

    {
        @Override
        public void handle (ActionEvent event){
        if (targetEditorTarget.getText() != null) {
            try {
                TargetDAO.add(targetEditorTarget.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
            targetEditorTarget.setText(null);
        }
    }
    }

    );
    buttonKind.setOnAction(new EventHandler<ActionEvent>()

    {
        @Override
        public void handle (ActionEvent event){
        if (kindEditorKind.getText() != null) {
            KindDAO.add(kindEditorKind.getText());
            kindEditorKind.setText(null);
        }
    }
    }

    );
    buttonPacking.setOnAction(new EventHandler<ActionEvent>()

    {
        @Override
        public void handle (ActionEvent event){
        if ((packingEditorPacking.getText() != null) && (weightEditorPacking.getText() != null)) {
            PackingDAO.add(packingEditorPacking.getText(), Integer.parseInt(weightEditorPacking.getText()));
            packingEditorPacking.setText(null);
            weightEditorPacking.setText(null);
        }
    }
    }

    );
    buttonProducer.setOnAction(new EventHandler<ActionEvent>()

    {
        @Override
        public void handle (ActionEvent event){
        if ((firmEditorProducer.getText() != null) && (countryEditorProducer.getText() != null) && (ratingEditorProducer != null)) {
            ProducerDAO.add(firmEditorProducer.getText(), Integer.parseInt(ratingEditorProducer.getText()), new Country(countryEditorProducer.getText()));
            firmEditorProducer.setText(null);
            countryEditorProducer.setText(null);
            ratingEditorProducer.setText(null);
        }
    }
    }

    );
    buttonMainTable.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        HeadDAO.add(nameEditorMainTable.getText(), infoEditorMainTable.getText(), usingEditorMainTable.getText(), Integer.parseInt(priceEditorMainTable.getText()),
                new Producer(firmEditorMainTable.getText(), Integer.parseInt(ratingEditorMainTable.getText()), new Country(countryEditorMainTable.getText())),
                new Packing(packingEditorMainTable.getText(), Integer.parseInt(weightEditorMainTable.getText())), new Kind(kindEditorMainTable.getText()),
                new sample.Classes.Target(targetEditorMainTable.getText()));
        countryEditorMainTable.setText(null);
        firmEditorMainTable.setText(null);
        infoEditorMainTable.setText(null);
        kindEditorMainTable.setText(null);
        nameEditorMainTable.setText(null);
        packingEditorMainTable.setText(null);
        priceEditorMainTable.setText(null);
        ratingEditorMainTable.setText(null);
        targetEditorMainTable.setText(null);
        usingEditorMainTable.setText(null);
        weightEditorMainTable.setText(null);

        }
    });

  }

}



