package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import org.prog.dto.PersonDto;
import org.prog.dto.SearchResultsDto;
import org.prog.util.DataHolder;

import java.sql.*;

public class SqlSteps {

    private final static String JENKINS = "jenkins";

    public static SearchResultsDto searchResultsDto;

    @Given("I store those persons in DB")
    public void storeInDB() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        String sqlPattern = "INSERT INTO Persons (FirstName, LastName, Title, Gender, Nat) " +
                "VALUES ('%s','%s','%s','%s','%s')";

        for (PersonDto personDto : searchResultsDto.getResults()) {
            try {
                statement.execute(String.format(sqlPattern,
                        personDto.getName().getFirst(),
                        personDto.getName().getLast(),
                        personDto.getName().getTitle(),
                        personDto.getGender(),
                        personDto.getNat()
                ));
            } catch (Exception e) {
                System.err.println("Could not store: " + personDto.getName().getFirst() + " " + personDto.getName().getLast());
            }
        }
        statement.close();
        connection.close();
    }

    @Given("I store persons from {string} in DB")
    public void storeInDBFromHolder(String alias) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        String sqlPattern = "INSERT INTO Persons (FirstName, LastName, Title, Gender, Nat) " +
                "VALUES ('%s','%s','%s','%s','%s')";

        SearchResultsDto dto = (SearchResultsDto) DataHolder.getInstance().get(alias);

        for (PersonDto personDto : dto.getResults()) {
            try {
                statement.execute(String.format(sqlPattern,
                        personDto.getName().getFirst(),
                        personDto.getName().getLast(),
                        personDto.getName().getTitle(),
                        personDto.getGender(),
                        personDto.getNat()
                ));
            } catch (Exception e) {
                System.err.println("Could not store: " + personDto.getName().getFirst() + " " + personDto.getName().getLast());
            }
        }
        statement.close();
        connection.close();
    }

    @Given("I pick a random person from DB")
    public void pickRandomPerson() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons ORDER BY RAND() LIMIT 1");
        while (resultSet.next()) {
            WebSteps.searchValue =
                    resultSet.getString("FirstName") + " " + resultSet.getString("LastName");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Given("I pick a random person from DB as {string}")
    public void pickRandomPersonWithHolder(String alias) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons ORDER BY RAND() LIMIT 1");
        while (resultSet.next()) {
            String searchValue =
                    resultSet.getString("FirstName") + " " + resultSet.getString("LastName");
            DataHolder.getInstance().put(alias, searchValue);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String driverType = System.getProperty("driver.type");
        if (JENKINS.equals(driverType)) {
            return DriverManager.getConnection(
                    "jdbc:mysql://mysql-db-1:3306/db",
                    "user",
                    "password"
            );
        } else {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db",
                    "user",
                    "password"
            );
        }
    }
}
