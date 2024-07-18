package br.com.FreeLancer.controller;

import br.com.FreeLancer.model.User;

import java.sql.*;

public class userController {

    public void createCad(User user){
        String sql = "insert into frelancer (username,name,surname,email,senha) values(?,?,?,?,?)";

        try {
            Connection conect = new Connecta().conecta();
            PreparedStatement preparedStatement = conect.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getNome());
            preparedStatement.setString(3, user.getSobrenome());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPass());
            preparedStatement.execute();
            System.out.println("CAD FEITO");
            createLogin(user);
        }catch (SQLException e){
            System.out.println("ERROR CRIAÇÃO DE CADASTRO: "+e.getMessage());
        }
    }

    public void createLogin(User user){
        String sql = "insert into login (login,senha) values (?,?)";
        try{
            Connection conect = new Connecta().conecta();
            PreparedStatement preparedStatement = conect.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.execute();
            System.out.println("CAD LOGIN FEITO");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean verify(User user){
        String sql = "select * from login where login = ?";

        try {
            Connection connection = new Connecta().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String pass = resultSet.getString("senha");

                if(pass.equals(user.getPass())){
                    return true;
                }
            }
            return false;
        }catch (SQLException e){
            System.out.println("ERROR VERIFY "+e.getMessage());
            return false;
        }
    }

    public User returnLogin(User user){
        String sql = "SELECT * FROM frelancer WHERE userName = ?";
        try {
            Connection connection = new Connecta().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
            String sobrenome = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String about = resultSet.getString("description");
            String name = resultSet.getString("name");
            String telefone = resultSet.getString("telephone");
            if(about == null){
                about = "DIGITE SOBRE VOCE";
            }
            if(telefone == null)
                telefone = "digite seu telefone";

            user.setTelefone(telefone);
            user.setNome(name);
            user.setEmail(email);
            user.setSobrenome(sobrenome);
            user.setAboutMe(about);
            return user;
            }
            return user;
        }catch (SQLException e){
            System.out.println("ERROR RETURN LOGIN: "+e.getMessage());
            return null;
        }
    }
    public void updateCad(User usuario){
        String sql = "update frelancer set name = ?, surname = ?, description = ?, telephone = ? where userName = ?";
        try {
            Connection connection = new Connecta().conecta();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setString(3, usuario.getAboutMe());
            preparedStatement.setString(4, usuario.getTelefone());
            preparedStatement.setString(5, usuario.getUserName());
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println("UPDATE ERROR : "+e.getMessage());
        }
    }
}
