package br.com.FreeLancer.controller;

import br.com.FreeLancer.model.People;

import java.sql.Connection;
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
        }catch (SQLException e){
            System.out.println("ERROR CRIAÇÃO DE CADASTRO: "+e.getMessage());
        }

    }
}
