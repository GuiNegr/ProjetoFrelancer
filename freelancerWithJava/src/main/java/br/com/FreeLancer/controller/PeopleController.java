package br.com.FreeLancer.controller;

import br.com.FreeLancer.model.People;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PeopleController {

    public void createCad(People people){
        String sql = "insert into FreeLAPeople (username,nome,sobrenome,email,pass) values(?,?,?,?,?)";

        try {
            Connection conect = new Connecta().conecta();
            PreparedStatement preparedStatement = conect.prepareStatement(sql);
            preparedStatement.setString(1, people.getUserName());
            preparedStatement.setString(2,people.getNome());
            preparedStatement.setString(3,people.getSobrenome());
            preparedStatement.setString(4,people.getEmail());
            preparedStatement.setString(5,people.getPass());
            preparedStatement.execute();
            System.out.println("CAD FEITO");
            createLogin(people);
        }catch (SQLException e){
            System.out.println("ERROR CRIAÇÃO DE CADASTRO: "+e.getMessage());
        }
    }

    public void createLogin(People people){
        String sql = "insert into login (userFk,pass) values (?,?)";
        try{
            Connection conect = new Connecta().conecta();
            PreparedStatement preparedStatement = conect.prepareStatement(sql);
            preparedStatement.setString(1, people.getUserName());
            preparedStatement.setString(2, people.getPass());
            preparedStatement.execute();
            System.out.println("CAD LOGIN FEITO");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
