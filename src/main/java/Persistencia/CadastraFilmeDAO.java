
package Persistencia;

import Modelo.CadastraFilme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CadastraFilmeDAO {
    private final Conexao conexao = new Conexao();
    private final String LOCADORA = "SELECT * FROM LOCADORA";
    private final String INSERTLOCADORA = "INSERT INTO LOCADORA(TITULO,DATALANCAMENTO,NOTA,DESCRICAO,QUANTIDADE, VALOR) VALUES(?,?,?,?,?,?)";

public boolean insertLocadora(CadastraFilme f) {
        //convertendo em java.util.Date em java.sql.Date
        java.util.Date dataUtil = f.getDataLancamento();  
        dataUtil= new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        try {
            conexao.Conectar();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = conexao.getConexao().prepareStatement(INSERTLOCADORA);

            prepararInstrucao.setString(1, f.getTitulo().toUpperCase());
            //prepararInstrucao.setDate(2, (Date) f.getDataLancamento());
            prepararInstrucao.setDate(2, dataSql);
            prepararInstrucao.setInt(3, f.getNota());
            prepararInstrucao.setString(4, f.getDescricao());
            prepararInstrucao.setInt(5, f.getQuantidade());
            prepararInstrucao.setFloat(6, 4);
            

            prepararInstrucao.execute();

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
                CadastraFilme x = new CadastraFilme(rs.getString("titulo"), rs.getDate("datalancamento"), rs.getInt("nota"), rs.getString("descricao"), rs.getInt("quantidade"), rs.getFloat("valor"));
                System.out.println(x);
                cadFilme.add(x);
            }
            conexao.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cadFilme;
    }

}
