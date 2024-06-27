package br.com.FreeLancer.controller;

import br.com.FreeLancer.model.People;

import java.sql.*;

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

    public boolean verify(People people){
        String sql = "select * from login where userFK = ?";

        try {
            Connection connection = new Connecta().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, people.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String pass = resultSet.getString("pass");

                if(pass.equals(people.getPass())){
                    return true;
                }
            }
            return false;
        }catch (SQLException e){
            System.out.println("ERROR VERIFY "+e.getMessage());
            return false;
        }
    }

    public People returnLogin(People people){
        String sql = "SELECT * FROM FreeLAPeople WHERE USERNAME = ?";
        try {
            Connection connection = new Connecta().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,people.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
            String sobrenome = resultSet.getString("sobrenome");
            String email = resultSet.getString("email");
            String about = resultSet.getString("aboutMe");

            if(about == null){
                about = "DIGITE SOBRE VOCE";
            }
            people.setEmail(email);
            people.setSobrenome(sobrenome);
            people.setAboutMe(about);
            return people;
            }
            return people;
        }catch (SQLException e){
            System.out.println("ERROR RETURN LOGIN: "+e.getMessage());
            return null;
        }
    }
}
