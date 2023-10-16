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

public class RelatorioManutencaoDAO implements IDao {

    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public RelatorioManutencaoDAO() {
        this.sql = "";
    }

    @Override
    public void save(Object obj) {
        RelatorioManutencao relatorioManutencao = (RelatorioManutencao) obj;

        sql = " INSERT INTO "
                + " relatorio_manutencao(dataRelatorio, descricao, equipamentos, cliente_id, tecnico_id) "
                + " VALUES(?,?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);


            statement.setString(1, relatorioManutencao.getDataRelatorio());

            statement.setString(2, relatorioManutencao.getDescricao());
            statement.setString(3, relatorioManutencao.getEquipamentos());

            // Preencher com o ID do cliente e do técnico
            statement.setString(4, relatorioManutencao.getNomeClienteRelacionado());
            statement.setString(5, relatorioManutencao.getNomeTecnicoResponsavel());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void update(Object obj) {
        RelatorioManutencao relatorioManutencao = (RelatorioManutencao) obj;

        sql = " UPDATE relatorio_manutencao "
                + " SET dataRelatorio = ?, descricao = ?, equipamentos = ?, cliente_id = ?, tecnico_id = ? "
                + " WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            // Preencher cada ? com o campo adequado

            statement.setString(1, relatorioManutencao.getDataRelatorio());

            statement.setString(2, relatorioManutencao.getDescricao());
            statement.setString(3, relatorioManutencao.getEquipamentos());

            // Preencher com o ID do cliente e do técnico
            statement.setString(4, relatorioManutencao.getNomeClienteRelacionado());
            statement.setString(5, relatorioManutencao.getNomeTecnicoResponsavel());

            // Preencher a condição do WHERE
            //statement.setString(6, relatorioManutencao.getIdRelatorio());

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

        sql = "SELECT * FROM relatorio_manutencao";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {


                RelatorioManutencao relatorioManutencao = new RelatorioManutencao(
                        resultset.getLong(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        null, // Cliente não é mais buscado
                        null // Técnico não é mais buscado
                );

                list.add(relatorioManutencao);
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
        RelatorioManutencao relatorioManutencao = (RelatorioManutencao) obj;

        sql = " SELECT * FROM relatorio_manutencao WHERE id = ? ";
        try {

            statement = Persistencia.getConnection().prepareStatement(sql);
            //statement.setString(1, relatorioManutencao.getIdRelatorio());

            ResultSet resultset = statement.executeQuery();

            RelatorioManutencao r = null;
            while (resultset.next()) {
                r = new RelatorioManutencao(
                        resultset.getLong(1),
                        resultset.getString(2),
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

    /**
     * Procura um relatório de manutenção pelo ID, que é o identificador único
     *
     * @param idRelatorio
     * @return Referência para o relatório de manutenção
     */
    public Object findByIdRelatorio(int idRelatorio) {
        sql = " Select * FROM relatorio_manutencao as r WHERE r.idRelatorio = ? ";

        RelatorioManutencao relatorioManutencao = null;
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
                relatorioManutencao = new RelatorioManutencao(
                        resultset.getLong(1),
                        resultset.getString(2),
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
        return relatorioManutencao;
    }

    /**
     * Recebe um relatório de manutenção como parâmetro, procura o relatório pelo
     * ID. Se encontrar, remove-o da lista de relatórios de manutenção.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        RelatorioManutencao relatorioManutencao = (RelatorioManutencao) obj;

        sql = " DELETE FROM relatorio_manutencao WHERE id = ? ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            // Preencher a condição
            //statement.setString(1, relatorioManutencao.getIdRelatorio());

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
