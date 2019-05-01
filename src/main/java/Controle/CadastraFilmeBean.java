
package Controle;

import Modelo.CadastraFilme;
import Persistencia.CadastraFilmeDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cadFilme")
@ViewScoped
public class CadastraFilmeBean {
   private String titulo;
    private Date dataLancamento;
    private Integer nota;
    private String descricao;
    private Integer quantidade;
    private CadastraFilme filme;
    private List<CadastraFilme> filmes = new ArrayList<>();

    CadastraFilmeDAO cadastraFilmeDao = new CadastraFilmeDAO();
    //private Date dataLancamento;
    //private String dataL;

    public void adicionar() throws ParseException, SQLException {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //dataL = dateFormat.format(dataLancamento);
        //dataLancamento = dateFormat.parse(dataL);
       

        filme = new CadastraFilme(titulo, dataLancamento, nota, descricao, quantidade, 4);
        cadastraFilmeDao.insertLocadora(filme);

        filmes.add(filme);
        //filme = new CadastraFilme();
    }
    
    public void adicionaLista(){
        filmes.clear();
        filmes.addAll(cadastraFilmeDao.listFilme());
    }
   
    /*public void remover(CadastraFilme f){
        if(filmes.contains(f)){
            filmes.remove(f);
                 
        }
    }
    public void editar(CadastraFilme f){
        this.filme = f;
    }
    public void salvar(){
        if(!filmes.contains(filme)){
            filmes.add(filme);
            filme = new CadastraFilme();
        }
    }*/
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String cancelar() {
        return "cancelar";
    }

    public CadastraFilme getFilme() {
        return filme;
    }

    public void setFilme(CadastraFilme filme) {
        this.filme = filme;
    }


    public void setFilmes(List<CadastraFilme> filmes) {
        this.filmes = filmes;
    }

}