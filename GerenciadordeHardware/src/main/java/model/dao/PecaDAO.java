package model.dao;

import factory.Persistencia;
import model.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import model.interfaces.IDao;

public class PecaDAO implements IDao {

    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public PecaDAO() {
        this.sql = "";
    }

    @Override
    public void save(Object obj) {
        Peca peca = (Peca) obj;

        sql = " INSERT INTO "
                + " peca(codigo, nome, descricao, preco, estoque, categoria, dataFabricacao, tipo) "
                + " VALUES(?,?,?,?,?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            // Preencher cada ? com o campo adequado
            statement.setString(1, peca.getCodigo());
            statement.setString(2, peca.getNome());
            statement.setString(3, peca.getDescricao());
            statement.setDouble(4, peca.getPreco());
            statement.setInt(5, peca.getEstoque());
            statement.setString(6, peca.getCategoria());
            statement.setString(7, peca.getDataFabricacao());
            statement.setString(8, peca.getTipo());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public void update(Object obj) {
        Peca peca = (Peca) obj;

        sql = " UPDATE peca "
                + " SET codigo = ?, nome = ?, descricao = ?, preco = ?, estoque = ?, categoria = ?, dataFabricacao = ?, tipo = ? "
                + " WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            // Preencher cada ? com o campo adequado
            statement.setString(1, peca.getCodigo());
            statement.setString(2, peca.getNome());
            statement.setString(3, peca.getDescricao());
            statement.setDouble(4, peca.getPreco());
            statement.setInt(5, peca.getEstoque());
            statement.setString(6, peca.getCategoria());
            statement.setString(7, peca.getDataFabricacao());

            statement.setString(8, peca.getTipo());

            // Preencher a condição do WHERE
            statement.setString(9, peca.getIdPeca());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public List<Object> findAll() {
        List<Object> list = new ArrayList<>();

        sql = "SELECT * FROM peca ORDER BY upper(id)";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                Peca peca = new Peca(
                        resultset.getString(1), 
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getDouble(5),
                        resultset.getInt(6),
                        resultset.getString(7),
                        resultset.getString(8),
                        resultset.getString(9));
                 list.add(peca);
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }

        return list;
    }

    @Override
    public Object find(Object obj) {
        Peca peca = (Peca) obj;

        sql = " SELECT * FROM peca WHERE id = ? ";
        try {

            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setString(1, peca.getIdPeca());

            ResultSet resultset = statement.executeQuery();



            Peca p = null;
            while (resultset.next()) {
                p = new Peca(
                        resultset.getString(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getDouble(5),
                        resultset.getInt(6),
                        resultset.getString(7),
                        resultset.getString(8),
                        resultset.getString(9));

            }
            statement.close();
            return p;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }

    }

    /**
     * Procura uma peça pelo código, que é o identificador único
     *
     * @param codigo
     * @return Referência para a peça na lista de peças
     */
    public Object findByCodigo(String codigo) {
        sql = " Select * FROM peca as p WHERE p.codigo = ? ";

        Peca peca = null;
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            // Preencher a condição
            statement.setString(1, codigo);

            ResultSet resultset = statement.executeQuery();

            // Converter o java.sql.Date para Calendar

            while (resultset.next()) {
                peca = new Peca(
                        resultset.getString(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getDouble(5),
                        resultset.getInt(6),
                        resultset.getString(7),
                        resultset.getString(8),
                        resultset.getString(9));

            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return peca;
    }

    /**
     * Recebe uma peça como parâmetro, procura a peça pelo código. Se encontrar,
     * remove ela da lista de peças.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        Peca peca = (Peca) obj;

        sql = " DELETE FROM peca WHERE id = ? ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            // Preencher a condição
            statement.setString(1, peca.getIdPeca());

            statement.execute();
            statement.close();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }
}
