package Cenaflix.beans;

import java.util.Date;

/**
 *
 * @author aulas
 */
public class Filmes {

    private int id;
    private String nome;
    private Date dataLancamento;
    private String categoria;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public Date getDataLancamento() {
        return dataLancamento;
    }

    /**
     *
     * @param dataLancamento
     */
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    /**
     *
     * @return
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     *
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
