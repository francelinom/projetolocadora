package Controle;

import Modelo.CadastraFilme;
import Persistencia.CadastraFilmeDAO;
import Persistencia.Conexao;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cadFilme")
@ViewScoped
public class CadastraFilmeBean implements Serializable{

    private CadastraFilme filme = new CadastraFilme();
    private List<CadastraFilme> filmes = new ArrayList<CadastraFilme>();
    Conexao conexao = new Conexao();
    CadastraFilmeDAO filmesDao = new CadastraFilmeDAO();

    public CadastraFilmeBean() {
        filme = new CadastraFilme();

        filmes = filmesDao.listFilme();
    }
    public List<CadastraFilme> filmesList(){
        filmes = filmesDao.listFilme();
        return filmes;
    }

    public void addFilme() {
        
        filmesDao.insertLocadora(filme);
        filmes = filmesDao.listFilme();
        filme = new CadastraFilme();

    }

    public void getLIST() {
//        filme.setTitulo("");
//        filme.setData(null);
//        filme.setNota(0);
//        filme.setDescricao("");
//        filme.setQuantidade(0);

    }

    public CadastraFilme getFilme() {
        return filme;
    }

    public void setFilme(CadastraFilme filme) {
        this.filme = filme;
    }

    public List<CadastraFilme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<CadastraFilme> filmes) {
        this.filmes = filmes;
    }

}
