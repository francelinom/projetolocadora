package Controle;

import Modelo.CadastraFilme;
import Persistencia.CadastraFilmeDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Cesta {

    private float valor = 0;
    private int qtdCesta = 0;
    private int qtd = 0;
    CadastraFilmeDAO filmesDao = new CadastraFilmeDAO();

    private List<CadastraFilme> cesta = new ArrayList<CadastraFilme>();
    private CadastraFilme filme = new CadastraFilme();

    public CadastraFilme getFilme() {
        return filme;
    }

    public void setFilme(CadastraFilme filme) {
        this.filme = filme;
    }

    CadastraFilmeDAO filmeDao = new CadastraFilmeDAO();
    CadastraFilme cadFilme;

    public void adicionarCesta(CadastraFilme f) {
        filmeDao.alterarQ(f);
        cesta.add(f);
    }

    public void removerFilme(CadastraFilme c) {
        if (cesta.contains(c)) {
            cesta.remove(c);
        }

        filmeDao.devolverQ(c);
    }

    public void limpar() {

        for (int i = 0; i < cesta.size(); i++) {
            filmeDao.devolverQ(cesta.get(i));
            cesta.remove(cadFilme);
        }

        qtdCesta = 0;
        cesta = new ArrayList<>();
        valor = 0;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void finalizarCompra() {
        valor = cesta.size()*2;
        //valor = qtdCesta * 2;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQtdCesta() {
        return qtdCesta;
    }

    public void setQtdCesta(int qtdCesta) {
        this.qtdCesta = qtdCesta;
    }

    public List<CadastraFilme> getCesta() {
        return cesta;
    }

    public void setCesta(List<CadastraFilme> cesta) {
        this.cesta = cesta;
    }

    public CadastraFilmeDAO getFilmeDao() {
        return filmeDao;
    }

    public void setFilmeDao(CadastraFilmeDAO filmeDao) {
        this.filmeDao = filmeDao;
    }

    public CadastraFilme getCadFilme() {
        return cadFilme;
    }

    public void setCadFilme(CadastraFilme cadFilme) {
        this.cadFilme = cadFilme;
    }

}
