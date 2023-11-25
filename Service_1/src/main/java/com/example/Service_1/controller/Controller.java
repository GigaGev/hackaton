//UTF-8

package com.example.Service_1.controller;

import com.example.Service_1.ResultSetToString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class Controller {

    @GetMapping("/forms")
    public String getForms(){
        Connection conn = null;
        String rowAnswer;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","gevork");
            String query = "SELECT * FROM Forms;";

            ResultSetToString answer = new ResultSetToString();
            rowAnswer = answer.resultSetToJson(conn,query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rowAnswer;
    }

    @GetMapping("/clients")
    public String getClients(){
        Connection conn = null;
        String rowAnswer;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","gevork");
            String query = "SELECT * FROM Clients;";

            ResultSetToString answer = new ResultSetToString();
            rowAnswer = answer.resultSetToJson(conn,query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rowAnswer;
    }

    @PostMapping("/clientInfo")
    public String clientInfo(@RequestBody String clientID){
        Connection conn = null;
        String rowAnswer;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","gevork");
            String query = "SELECT * FROM Clients WHERE id_client = '" + clientID + "';";

            ResultSetToString answer = new ResultSetToString();
            rowAnswer = answer.resultSetToJson(conn,query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rowAnswer;
    }


}
