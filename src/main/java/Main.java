import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Classes.*;
import org.hibernate.Session;
import org.hibernate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import sample.Hibernate.HibernateUtil;
import sample.Service.CountryDAO;
import sample.Service.HeadDAO;
import sample.Service.ProducerDAO;


public class Main extends Application {
    public ObservableList currentData = FXCollections.observableArrayList();
    private Controller controller;
    public Connection connection;
    public String currentTableName;
    public Stage stage;
    public static HashMap<String, String> TABLES_MAP = new HashMap<String, String>() {{
        put("Головна Таблиця", "Main_Table");
        put("Країни", "Country");
        put("Виробник", "Producer");
        put("Ціль", "Target");
        put("Фасування", "Packing");
        put("Вид", "Kind");

    }};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = (Parent) loader.load();
        controller = loader.getController();
        controller.setMainWindow(this);
        updateTablesList();
        stage = primaryStage;
        primaryStage.setScene(new Scene(root, 700, 275));
        primaryStage.show();
    }

    private void updateTablesList() {
        try {
            ObservableList<String> obsList = FXCollections.observableArrayList();
            obsList.addAll(TABLES_MAP.keySet());
            //obsList.sort(String.CASE_INSENSITIVE_ORDER);
            controller.choiceTable.setItems(obsList);
            controller.choiceTable.getSelectionModel().selectFirst();
        } catch (Exception ex) {
            System.out.println("updateTablesList: " + ex.getMessage());
        }
    }

    public Stage getStage() {
        return this.stage;
    }

    public HashMap<String, String> getTABLES_MAP() {
        return TABLES_MAP;
    }

    public void loadTable(String tableName) {
        currentTableName = TABLES_MAP.get(tableName);
        controller.tableView.getColumns().clear();
        try {
            controller.tableView.getColumns().clear();
            switch (currentTableName) {
                case "Main_Table": {
                    TableColumn idColumn = new TableColumn("id");
                    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                    TableColumn nameColumn = new TableColumn("Назва");
                    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                    TableColumn infoColumn = new TableColumn("Іформація");
                    infoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
                    TableColumn usingColumn = new TableColumn("Використання");
                    usingColumn.setCellValueFactory(new PropertyValueFactory<>("using"));
                    TableColumn priceColumn = new TableColumn("Ціна");
                    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
                    TableColumn targetColumn = new TableColumn("Ціль");
                    targetColumn.setCellValueFactory(new PropertyValueFactory<>("target"));
                    TableColumn kindColimn = new TableColumn("Вид");
                    kindColimn.setCellValueFactory(new PropertyValueFactory<>("kind"));
                    TableColumn packingColumn = new TableColumn("Фасування");
                    packingColumn.setCellValueFactory(new PropertyValueFactory<>("packing"));
                    TableColumn producerColumn = new TableColumn("Виробник");
                    producerColumn.setCellValueFactory(new PropertyValueFactory<>("producer"));
                    controller.tableView.getColumns().addAll(idColumn, nameColumn, infoColumn, usingColumn, priceColumn, targetColumn,
                            kindColimn, packingColumn, producerColumn/*, weightColumn, firmColumn, countryColumn, ratingColumn*/);
                    currentData.clear();
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    List<Head> result = session.createQuery("from head").list();
                    session.getTransaction().commit();
                    for (Head next : result) {
                        currentData.addAll(new Head(next.getId(), next.getName(), next.getInfo(), next.getUsing(),
                                next.getPrice(), next.getProducer(), next.getPacking(), next.getKind(), next.getTarget()));
                    }
                    break;
                }

                case "Target": {
                    TableColumn idColumn = new TableColumn("id");
                    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                    TableColumn nameColumn = new TableColumn("Ціль");
                    nameColumn.setCellValueFactory(new PropertyValueFactory<>("Target"));
                    controller.tableView.getColumns().addAll(idColumn, nameColumn);
                    currentData.clear();
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    List<Target> result = session.createQuery("from Target").list();
                    session.getTransaction().commit();
                    for (Target next : result) {
                        currentData.addAll(new Target(next.getId(), next.getTarget()));
                    }
                    break;
                }
                case "Packing": {
                    TableColumn idColumn = new TableColumn("id");
                    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                    TableColumn packingColumn = new TableColumn("Фасування");
                    packingColumn.setCellValueFactory(new PropertyValueFactory<>("packing"));
                    TableColumn weightColumn = new TableColumn("Вага");
                    weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
                    controller.tableView.getColumns().addAll(idColumn, packingColumn, weightColumn);
                    currentData.clear();
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    List<Packing> result = session.createQuery("from Packing").list();
                    session.getTransaction().commit();
                    for (Packing next : result) {
                        currentData.addAll(new Packing(next.getId(), next.getPacking(), next.getWeight()));
                    }
                    break;
                }
                case "Kind": {
                    TableColumn idColumn = new TableColumn("id");
                    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                    TableColumn kindColumn = new TableColumn("Тип продукта");
                    kindColumn.setCellValueFactory(new PropertyValueFactory<>("kind"));
                    controller.tableView.getColumns().addAll(idColumn, kindColumn);
                    currentData.clear();
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    List<Kind> result = session.createQuery("from Kind").list();
                    session.getTransaction().commit();
                    for (Kind next : result) {
                        currentData.addAll(new Kind(next.getId(), next.getKind()));
                    }
                    break;
                }
                case "Producer": {
                    TableColumn idColumn = new TableColumn("id");
                    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                    TableColumn firmColumn = new TableColumn("Фірма");
                    firmColumn.setCellValueFactory(new PropertyValueFactory<>("firm"));
                    TableColumn countryColumn = new TableColumn("Країни");
                    countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
                    TableColumn ratingColumn = new TableColumn("Рейтинг");
                    ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
                    controller.tableView.getColumns().addAll(idColumn, firmColumn, countryColumn, ratingColumn);
                    currentData.clear();
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    List<Producer> result = session.createQuery("from Producer").list();
                    session.getTransaction().commit();
                    for (Producer next : result) {
                        currentData.addAll(new Producer(next.getId(), next.getFirm(), next.getCountry(), next.getRating()));
                    }
                    break;
                }
                case "Country": {
                    TableColumn idColumn = new TableColumn("id");
                    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                    TableColumn countryColumn = new TableColumn("Країна");
                    countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
                    controller.tableView.getColumns().addAll(idColumn, countryColumn);
                    currentData.clear();
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    List<Country> result = session.createQuery("from Country").list();
                    session.getTransaction().commit();
                    for (Country next : result) {
                        currentData.addAll(new Country(next.getId(), next.getCountry()));
                    }
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("loadTable:12331 " + ex.getMessage());
        }
    }


}
