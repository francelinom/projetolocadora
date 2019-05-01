
package Modelo;

import java.util.Date;

public class CadastraFilme {
    private Integer id;
    private String titulo;
    private Date dataLancamento;
    private Integer nota;
    private String descricao;
    private Integer quantidade;
    private Float valor;

    public CadastraFilme() {
    }

        
    public CadastraFilme(String titulo, Date dataLancamento, Integer nota, String descricao, Integer quantidade) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.nota = nota;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    
    public CadastraFilme(String titulo, Date dataLancamento, Integer nota, String descricao, Integer quantidade, float valor) {
        //super();
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.nota = nota;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
       
         
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
    
    
}
