package org.example.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.dao.EmployeeDAO;
import org.example.entity.EmployeeEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GUI extends Application {

    private final EmployeeDAO employeeDAO;

    public GUI() {
        // Konfiguracja Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Inicjalizacja DAO
        this.employeeDAO = new EmployeeDAO(sessionFactory);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Przekazanie primaryStage do metody displayEmployeesList
        displayEmployeesList(primaryStage);
    }

    private void displayEmployeesList(Stage primaryStage) {
        primaryStage.setTitle("Lista pracowników");

        // Pobierz wszystkich pracowników z bazy danych
        List<EmployeeEntity> employees = employeeDAO.getAllEmployees();

        // Tworzenie listy widoku
        ListView<String> listView = new ListView<>();
        for (EmployeeEntity employee : employees) {
            listView.getItems().add(employee.getName() + " - " + employee.getSalary());
        }

        // Tworzenie layoutu
        VBox vBox = new VBox(listView);
        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
