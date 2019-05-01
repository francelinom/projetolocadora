
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://ec2-23-23-92-204.compute-1.amazonaws.com:5432/dcahohqv0mno0n?&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    private static final String USUARIO = "xriwyanciecuso";
    private static final String SENHA = "301935de970d5291dfcfc7ebe17aab39a39bf14eb986f99d058f4ffe82111607";
    private Connection conexao;
    
    public void Conectar(){
        try{
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Banco OK");
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e);
            System.out.println("Não deu Certo");        
        }
    }
   
    public void desconectar(){
        try {
            conexao.close();
            System.out.println("desconectado");
        } catch (Exception ex) {
            System.err.println(ex);
            System.out.println("Não desconectou");
        }
    }
    
    public Connection getConexao(){
        return conexao;
    }
}

