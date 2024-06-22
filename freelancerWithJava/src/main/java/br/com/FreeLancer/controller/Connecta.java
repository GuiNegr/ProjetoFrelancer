package br.com.FreeLancer.controller;

import java.sql.Connection;

import java.sql.DriverManager;

public class Connecta {

    public Connection conecta(){
        Connection connect = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/FreeLancerBD?user=root&password=Root@2107";
            connect = DriverManager.getConnection(url);
            System.out.println("Connexão estabelecida");
            return connect;
        }catch (Exception e){
            System.out.println("ERROR NA CLASSE DE CONEXÃO: "+e.getMessage());
            return null;
        }
    }
}
