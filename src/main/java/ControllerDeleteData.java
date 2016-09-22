import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import sample.Classes.*;
import sample.Hibernate.HibernateUtil;
import sample.Service.*;

import java.sql.SQLException;


/**
 * Created by Zinoviy on 25.03.16.
 */
public class ControllerDeleteData {
    WindowDeleteData windowDeleteData;
    String currentTable = "Головна Таблиця";
    @FXML ChoiceBox<String> choiceTableForDelete;
    @FXML Button deleteButton;
    @FXML TextField deleteTextField;
    public void setWindowDeleteData(WindowDeleteData windowDeleteData)
    {
        this.windowDeleteData = windowDeleteData;
    }

    public void initialize()
    {
        updateTablesList();
        choiceTableForDelete.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    this.currentTable = newValue;
                });
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(deleteTextField.getText()!=null) {
                        int a = Integer.parseInt(deleteTextField.getText());
                        deleteElement(currentTable, a );
                        deleteTextField.setText("");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Ви ввели некоретне id для видалення");
                }
            }
        });

    }
    private void updateTablesList() {
        try {
            ObservableList<String> obsList = FXCollections.observableArrayList();
            obsList.addAll(Main.TABLES_MAP.keySet());
            //obsList.sort(String.CASE_INSENSITIVE_ORDER);
            choiceTableForDelete.setItems(obsList);
            choiceTableForDelete.getSelectionModel().selectFirst();
        } catch (Exception ex) {
            System.out.println("updateTablesList: " + ex.getMessage());
        }
    }
    public void deleteElement(String tableName,int id) throws SQLException {
        String currentTableName = Main.TABLES_MAP.get(tableName);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        switch (currentTableName) {
            case "Main_Table": {
                HeadDAO.delete(id);
                break;
            }
            case "Kind": {
                KindDAO.delete(id);
                break;
            }
            case "Target": {
                TargetDAO.delete(id);
                break;
            }
            case "Producer": {
                ProducerDAO.delete(id);
                break;
            }
            case "Country": {
                CountryDAO.delete(id);
                break;
            }
            case "Packing": {
                PackingDAO.delete(id);
                break;
            }

        }
    }
}
