package Cenaflix.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aulas
 */
public class Conexao {

    /**
     *
     * @return
     */
    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cenaflixBd", "root", "root123");
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco." + e.getMessage());
            return null;
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Conexao c = new Conexao();
        c.getConexao();
    }
}
