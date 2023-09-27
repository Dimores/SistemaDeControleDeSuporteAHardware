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

public class RelatorioRedeDAO implements IDao {

    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public RelatorioRedeDAO() {
        this.sql = "";
    }

    @Override
    public void save(Object obj) {
        RelatorioRede relatorioRede = (RelatorioRede) obj;

        sql = " INSERT INTO "
                + " relatorio_rede(dataRelatorio, descricao, tipoRede, cliente_id, tecnico_id) "
                + " VALUES(?,?,?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            // Preencher cada ? com o campo adequado

            // Converter o Calendar para java.sql.Date
            java.sql.Date dataRelatorioSql = new java.sql.Date(relatorioRede.getDataRelatorio().getTimeInMillis());
            statement.setDate(1, dataRelatorioSql);

            statement.setString(2, relatorioRede.getDescricao());
            statement.setString(3, relatorioRede.getTipoRede());

            // Preencher com o ID do cliente e do técnico
            statement.setString(4, relatorioRede.getClienteRelacionado().getId());
            statement.setString(5, relatorioRede.getTecnicoResponsavel().getId());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void update(Object obj) {
        RelatorioRede relatorioRede = (RelatorioRede) obj;

        sql = " UPDATE relatorio_rede "
                + " SET dataRelatorio = ?, descricao = ?, tipoRede = ?, cliente_id = ?, tecnico_id = ? "
                + " WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            // Preencher cada ? com o campo adequado

            // Converter o Calendar para java.sql.Date
            java.sql.Date dataRelatorioSql = new java.sql.Date(relatorioRede.getDataRelatorio().getTimeInMillis());
            statement.setDate(1, dataRelatorioSql);

            statement.setString(2, relatorioRede.getDescricao());
            statement.setString(3, relatorioRede.getTipoRede());

            // Preencher com o ID do cliente e do técnico
            statement.setString(4, relatorioRede.getClienteRelacionado().getId());
            statement.setString(5, relatorioRede.getTecnicoResponsavel().getId());

            // Preencher a condição do WHERE
            statement.setString(6, relatorioRede.getIdRelatorio());

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

        sql = "SELECT * FROM relatorio_rede";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {

                // Converter o java.sql.Date para Calendar
                java.sql.Date sqlDate = resultset.getDate(2);
                Calendar dataRelatorio = Calendar.getInstance();
                dataRelatorio.setTimeInMillis(sqlDate.getTime());

                RelatorioRede relatorioRede = new RelatorioRede(
                        resultset.getString(1),
                        dataRelatorio,
                        resultset.getString(3),
                        resultset.getString(4),
                        null, // Cliente não é mais buscado
                        null // Técnico não é mais buscado
                );

                list.add(relatorioRede);
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
        RelatorioRede relatorioRede = (RelatorioRede) obj;

        sql = " SELECT * FROM relatorio_rede WHERE id = ? ";
        try {

            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setString(1, relatorioRede.getIdRelatorio());

            ResultSet resultset = statement.executeQuery();

            // Converter o java.sql.Date para Calendar
            java.sql.Date sqlDate = resultset.getDate(2);
            Calendar dataRelatorio = Calendar.getInstance();
            dataRelatorio.setTimeInMillis(sqlDate.getTime());

            RelatorioRede r = null;
            while (resultset.next()) {
                r = new RelatorioRede(
                        resultset.getString(1),
                        dataRelatorio,
                        resultset.getString(3),
                        resultset.getString(4),
                        null, // Cliente não é mais buscado
                        null // Técnico não é mais buscado
                );
            }
            statement.close();
            return r;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }

    }

/*
    public Object findByIdRelatorio(int idRelatorio) {
        sql = " Select * FROM relatorio_rede as r WHERE r.idRelatorio = ? ";

        RelatorioRede relatorioRede = null;
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            // Preencher a condição
            statement.setInt(1, idRelatorio);

            ResultSet resultset = statement.executeQuery();

            // Converter o java.sql.Date para Calendar
            java.sql.Date sqlDate = resultset.getDate(2);
            Calendar dataRelatorio = Calendar.getInstance();
            dataRelatorio.setTimeInMillis(sqlDate.getTime());

            while (resultset.next()) {
                relatorioRede = new RelatorioRede(
                        resultset.getString(1),
                        dataRelatorio,
                        resultset.getString(3),
                        resultset.getString(4),
                        null, // Cliente não é mais buscado
                        null // Técnico não é mais buscado
                );
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return relatorioRede;
    } */

    /**
     * Recebe um relatório de rede como parâmetro, procura o relatório pelo
     * ID. Se encontrar, remove-o da lista de relatórios de rede.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        RelatorioRede relatorioRede = (RelatorioRede) obj;

        sql = " DELETE FROM relatorio_rede WHERE id = ? ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            // Preencher a condição
            statement.setString(1, relatorioRede.getIdRelatorio());

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
