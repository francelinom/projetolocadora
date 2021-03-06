package Persistencia;

import Modelo.CadastraFilme;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastraFilmeDAO implements Serializable{

   

    private final Conexao conexao = new Conexao();
    private final String LOCADORA = "SELECT * FROM LOCADORA ORDER BY ID";
    private final String INSERTLOCADORA = "INSERT INTO LOCADORA(TITULO,DATALANCAMENTO,NOTA,DESCRICAO,QUANTIDADE) VALUES(?,?,?,?,?)";

    private final String UPDATEQUANTIDADE = "UPDATE LOCADORA SET QUANTIDADE = QUANTIDADE-1 WHERE ID = (?)";
    private final String UPDATEDEVOLVER = "UPDATE LOCADORA SET QUANTIDADE = QUANTIDADE+1 WHERE ID = (?)";

    public boolean insertLocadora(CadastraFilme u) {
        //convertendo em java.util.Date em java.sql.Date

        try {
            conexao.Conectar();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = conexao.getConexao().prepareStatement(INSERTLOCADORA);
            preparaInstrucao.setString(1, u.getTitulo());
            u.setDataLancamento(new java.util.Date());
            java.sql.Date dataSql = new java.sql.Date(u.getDataLancamento().getTime());
            preparaInstrucao.setDate(2, dataSql);
            preparaInstrucao.setInt(3, u.getNota());
            preparaInstrucao.setString(4, u.getDescricao());
            preparaInstrucao.setInt(5, u.getQuantidade());
            
            preparaInstrucao.executeUpdate();
            System.out.println("OOOOOOK"+u.toString());
            conexao.desconectar();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public ArrayList<CadastraFilme> listFilme() {
        ArrayList<CadastraFilme> cadFilme = new ArrayList<>();

        try {
            conexao.Conectar();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = conexao.getConexao().prepareStatement(LOCADORA);

            ResultSet rs = prepararInstrucao.executeQuery();

            while (rs.next()) {
                CadastraFilme x = new CadastraFilme(rs.getInt("id"),rs.getString("titulo"), rs.getDate("datalancamento"), rs.getInt("nota"), rs.getString("descricao"), rs.getInt("quantidade"));
                System.out.println(x);
                cadFilme.add(x);
            }
            conexao.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cadFilme;
    }

    public boolean updateQuantidade(CadastraFilme u) {
        try {
            // CONECTA
            conexao.Conectar();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = conexao.getConexao().prepareStatement(UPDATEQUANTIDADE);
            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, u.getId());

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();
            System.out.println("atualizaou a quantidade");

            // DESCONECTA
            conexao.desconectar();

            return true;

        } catch (SQLException e) {
            return false;

        }

    }
     public void alterarQ(CadastraFilme f) {
        try {
            // CONECTA
            conexao.Conectar();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = conexao.getConexao().prepareStatement(UPDATEQUANTIDADE);
            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, f.getId());

            // EXECUTA A INSTRUCAO
            preparaInstrucao.executeUpdate();
            System.out.println("atualizaou a quantidade");

            // DESCONECTA
            conexao.desconectar();

        } catch (SQLException e) {
          
        }
    }

    public void devolverQ(CadastraFilme c) {
        try {
            // CONECTA
            conexao.Conectar();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = conexao.getConexao().prepareStatement(UPDATEDEVOLVER);
            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, c.getId());

            // EXECUTA A INSTRUCAO
            preparaInstrucao.executeUpdate();
            System.out.println("atualizaou a quantidade");

            // DESCONECTA
            conexao.desconectar();

        } catch (SQLException e) {
          
        }
    }
}
