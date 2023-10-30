package org.prog.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.prog.dto.PersonDto;
import org.prog.dto.SearchResultsDto;
import org.testng.annotations.Test;

import java.sql.*;

public class SqlTests {

    @Test
    public void sqlReadTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "user",
                "password"
        );

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");
        while (resultSet.next()) {
            System.out.print(resultSet.getString("Title") + " ");
            System.out.print(resultSet.getString("FirstName") + " ");
            System.out.println(resultSet.getString("LastName"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void sqlWriteTest() throws ClassNotFoundException, SQLException {
        SearchResultsDto dto = RestAssured
                .given()
                .queryParam("results", "3")
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .get("https://randomuser.me/api/")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .body()
                .as(SearchResultsDto.class);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "user",
                "password"
        );

        Statement statement = connection.createStatement();

        String sqlPattern = "INSERT INTO Persons (FirstName, LastName, Title, Gender, Nat) " +
                "VALUES ('%s','%s','%s','%s','%s')";

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
                System.err.println("Could not store: " + personDto.getName().getFirst());
            }
        }

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");
        while (resultSet.next()) {
            System.out.print(resultSet.getString("Title") + " ");
            System.out.print(resultSet.getString("FirstName") + " ");
            System.out.println(resultSet.getString("LastName"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
