package sample;

/*
Shen Han 100088024
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Observable;

public class atheleteViewController {

    @FXML
    private Button allRacersButton;
    @FXML
    private Button femaleOnlyButton;
    @FXML
    private Button maleOnlyButton;
    @FXML
    private Button top10FemaleButton;
    @FXML
    private Button top10MaleButton;
    @FXML
    private Button femaleBestRunButton;
    @FXML
    private Button maleBestRunButton;
    @FXML
    private TableView<Athelete> runTable;
    @FXML
    private TableColumn<Athelete, String> runnerID;
    @FXML
    private TableColumn<Athelete, String> runnerFullName;
    @FXML
    private TableColumn<Athelete, Date> runnerYearOfBirth;
    @FXML
    private TableColumn<Athelete, Integer> runnerRun1;
    @FXML
    private TableColumn<Athelete, Integer> runnerRun2;
    @FXML
    private TableColumn<Athelete, Integer> runnerCombined;
    @FXML
    private TableColumn<Athelete, Integer> runnerBib;
    @FXML
    private TableColumn<Athelete, String> runnerClub;

    @FXML
    void initialize() throws SQLException {

        ObservableList<Athelete> athelete = FXCollections.observableArrayList();

        DBUtility connectDB = new DBUtility();
        Connection connection = connectDB.getConnection();

        /** may need to change 'users to 'raceResults'
         *
         */
        String sql = "SELECT* FROM 'raceResults'";
        //String sql = "SELECT* FROM 'users'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()){
            athelete.add(new Athelete(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getInt(8),
                    resultSet.getDouble(8),
                    resultSet.getString(8)));
        }

        runnerID.setCellValueFactory(new PropertyValueFactory<Athelete, String>("id"));
        runnerFullName.setCellValueFactory(new PropertyValueFactory<Athelete, String>("fullName"));
        runnerYearOfBirth.setCellValueFactory(new PropertyValueFactory<Athelete, Date>("yearOfBirth"));
        runnerRun1.setCellValueFactory(new PropertyValueFactory<Athelete, Integer>("run1"));
        runnerRun2.setCellValueFactory(new PropertyValueFactory<Athelete, Integer>("run2"));
        runnerBib.setCellValueFactory(new PropertyValueFactory<Athelete, Integer>("bib"));
        runnerClub.setCellValueFactory(new PropertyValueFactory<Athelete, String>("club"));

        /**
         * Might need to add a combined int value into Atheletes.java
         */
        runnerCombined.setCellValueFactory(new PropertyValueFactory<Athelete, Integer>("combined"));

        runTable.setItems(athelete);

    }

    public void iRanOutOfTime (){
        String sqlCommand = "SELECT top10 femaleAtheletes from 'raceResults' order by femaleAthletes;";

                //ran out of time can't finish.
    }




}
