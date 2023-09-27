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

public class ServicoDAO implements IDao {

    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public ServicoDAO() {
        this.sql = "";
    }

    @Override
    public void save(Object obj) {
        Servico servico = (Servico) obj;

        sql = " INSERT INTO "
                + " servico(tecnicoResponsavel, clienteAtendido, valor, descricaoServico, dataServico, concluido) "
                + " VALUES(?,?,?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            // Preencher cada ? com o campo adequado
            statement.setString(1, servico.getTecnico().getNome());
            statement.setString(2, servico.getCliente().getNome());
            statement.setFloat(3, servico.getValor());
            statement.setString(4, servico.getDescricaoServico());

            // Converter o Calendar para java.sql.Date
            java.sql.Date dataServicoSql = new java.sql.Date(servico.getDataServico().getTimeInMillis());
            statement.setDate(5, dataServicoSql);

            statement.setBoolean(6, servico.isConcluido());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void update(Object obj) {
        Servico servico = (Servico) obj;

        sql = " UPDATE servico "
                + " SET tecnicoResponsavel = ?, clienteAtendido = ?, valor = ?, descricaoServico = ?, dataServico = ?, concluido = ? "
                + " WHERE idServico = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            // Preencher cada ? com o campo adequado
            statement.setString(1, servico.getTecnico().getNome());
            statement.setString(2, servico.getCliente().getNome());
            statement.setFloat(3, servico.getValor());
            statement.setString(4, servico.getDescricaoServico());

            statement.setString(5, servico.getDataServico());

            statement.setBoolean(6, servico.isConcluido());

            // Preencher a condição do WHERE
            statement.setString(7, servico.getIdServico());

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

        sql = "SELECT * FROM servico ORDER BY upper(descricaoServico)";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {

                // Converter o java.sql.Date para Calendar
                java.sql.Date sqlDate = resultset.getDate(6);
                Calendar dataServico = Calendar.getInstance();
                dataServico.setTimeInMillis(sqlDate.getTime());

                Servico servico = new Servico(
                        resultset.getString(1),
                        null, // Tecnico nao e mais buscado
                        null,  // Cliebte nao e mais buscado
                        resultset.getFloat(4),
                        resultset.getString(5),
                        dataServico,
                        resultset.getBoolean(7));

                list.add(servico);
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
        Servico servico = (Servico) obj;

        sql = " SELECT * FROM servico WHERE idServico = ? ";
        try {

            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setString(1, servico.getIdServico());

            ResultSet resultset = statement.executeQuery();

            // Converter o java.sql.Date para Calendar
            java.sql.Date sqlDate = resultset.getDate(6);
            Calendar dataServico = Calendar.getInstance();
            dataServico.setTimeInMillis(sqlDate.getTime());

            Servico s = null;
            while (resultset.next()) {
                s = new Servico(
                         resultset.getString(1),
                        null, // Tecnico nao e mais buscado
                        null,  // Cliebte nao e mais buscado
                        resultset.getFloat(4),
                        resultset.getString(5),
                        dataServico,
                        resultset.getBoolean(7));

            }
            statement.close();
            return s;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }

    }

    /**
     * Procura um serviço pelo código, que é o identificador único
     *
     * @return Referência para o serviço na lista de serviços
     */
    public Object findByValor(float valor) {
        sql = " Select * FROM servico as s WHERE s.valor = ? ";

        Servico servico = null;
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            // Preencher a condição
            statement.setFloat(1, valor);

            ResultSet resultset = statement.executeQuery();

            // Converter o java.sql.Date para Calendar
            java.sql.Date sqlDate = resultset.getDate(6);
            Calendar dataServico = Calendar.getInstance();
            dataServico.setTimeInMillis(sqlDate.getTime());

            while (resultset.next()) {
                servico = new Servico(
                        resultset.getString(1),
                        null, // Tecnico nao e mais buscado
                        null,  // Cliebte nao e mais buscado
                        resultset.getFloat(4),
                        resultset.getString(5),
                        dataServico,
                        resultset.getBoolean(7));

            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return servico;
    }

    /**
     * Recebe um serviço como parâmetro, procura o serviço pelo código. Se encontrar,
     * remove ele da lista de serviços.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        Servico servico = (Servico) obj;

        sql = " DELETE FROM servico WHERE idServico = ? ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            // Preencher a condição
            statement.setString(1, servico.getIdServico());

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
