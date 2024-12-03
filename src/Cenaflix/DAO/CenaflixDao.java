package Cenaflix.DAO;

import Cenaflix.conexao.Conexao;
import Cenaflix.beans.Filmes;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aulas
 */
public class CenaflixDao {

    /*
    *Variáveis para conexão com banco de dados
     */
    private Conexao conexao;
    private Connection conn;

    /**
     * construtor para inicializar a conexão com o banco de dados
     */
    public CenaflixDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    /**
     *
     * @param filmes método para cadastrar um filme no banco de dados
     */
    public void cadastrarFilme(Filmes filmes) {
        /*
        *comando para o banco de dados
         */
        String sql = "INSERT INTO filmes(nome, datalancamento, categoria) VALUES " + "(?, ?, ?)";

        /*
        *execução do código para inserir no banco os dados incluídos na classe modelo
         */
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, filmes.getNome());
            Date dataLanc = filmes.getDataLancamento();
            if (dataLanc != null) {
                java.sql.Date sqlDate = new java.sql.Date(dataLanc.getTime());
                stmt.setDate(2, sqlDate);
            } else {
                stmt.setDate(2, null);
            }
            stmt.setString(3, filmes.getCategoria());
            stmt.execute();

        } /*
        *Caso de erro a informação do que causou
         */ catch (Exception e) {
            System.out.println("Erro ao inserir filme." + e.getMessage());
        }
    }

    /**
     *
     * @param id
     * @return método para buscar Filmes no banco de dados através da pesquisa do id
     */
    public Filmes getFilmes(int id) {
        /*
        *comando para o banco de dados
         */
        String sql = "SELECT * FROM filmes WHERE id = ?";

        /*
        *execução do código para buscar os dados no banco e setar na classe modelo
         */
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            Filmes filme = new Filmes();

            rs.first(); //irá posicionar o ResultSet na primeira posição
            filme.setId(id);
            filme.setNome(rs.getString("nome"));
            filme.setDataLancamento(rs.getDate("datalancamento"));
            filme.setCategoria(rs.getString("categoria"));

            return filme;
        } /*
        *Caso de erro a informação do que causou
         */ catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    /**
     *
     * @param nomeFilme
     * @return método para buscar lista de filmes cadastrados no banco de dados
     */
    public List<Filmes> getFilmes(String nomeFilme) {
        /*
        *comando para o banco de dados
         */
        String sql = "SELECT * FROM filmes WHERE nome LIKE ?";

        /*execução do código para buscar os dados no banco e informar ao modelo a lista de todos os cadastros
        * de acordo com o nome do filme, se for vazio informa todos os itens da lista
         */
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nomeFilme + "%");
            ResultSet rs = stmt.executeQuery();

            List<Filmes> listaFilmes = new ArrayList<>();
            while (rs.next()) {
                Filmes filme = new Filmes();
                filme.setId(rs.getInt("id"));
                filme.setNome(rs.getString("nome"));
                filme.setDataLancamento(rs.getDate("datalancamento"));
                filme.setCategoria(rs.getString("categoria"));

                listaFilmes.add(filme);
            }

            return listaFilmes;
        } /*
        *Caso de erro a informação do que causou
         */ catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param filmes método para edição do filme que já havia sido cadastrado
     */
    public void editarFilme(Filmes filmes) {
        /*
        *comando para o banco de dados
         */
        String sql = "UPDATE filmes SET nome = ?, datalancamento = ?, categoria = ? WHERE id = ?";

        /*
        *execução do código para buscar dados no banco e editar na classe modelo e banco
         */
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, filmes.getNome());
            stmt.setDate(2, new java.sql.Date(filmes.getDataLancamento().getTime()));
            stmt.setString(3, filmes.getCategoria());
            stmt.setInt(4, filmes.getId());
            stmt.executeUpdate();

        } /*
        *Caso de erro a informação do que causou
         */ catch (Exception e) {
            System.out.println("Erro ao editar filme." + e.getMessage());
        }
    }

    /**
     *
     * @param id método para excluir filme pelo acesso do id
     */
    public void excluirFilme(int id) {
        /*
        *comando para o banco de dados
         */
        String sql = "DELETE FROM filmes WHERE id = ?";

        /*
        *execução do código para exclusão de filme de acordo com seu id cadastrado.
         */
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } /*
           *Caso de erro a informação do que causou
         */ catch (Exception e) {
            System.out.println("Erro ao excluir filme: " + e.getMessage());
        }
    }

}
