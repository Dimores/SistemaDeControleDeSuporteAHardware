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


public class ClienteDAO implements IDao {

    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public ClienteDAO() {
        this.sql = "";
    }

    @Override
    public void save(Object obj) {
        Cliente cliente = (Cliente) obj;

        sql = " INSERT INTO "
                + " cliente(nome, CPF, dataNasc, senha, email, telefone) "
                + " VALUES(?,?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            //preencher cada ? com o campo adequado
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCPF());

            // Converter o Calendar para java.sql.Date
            java.sql.Date dataNascSql = new java.sql.Date(cliente.getDataNasc().getTimeInMillis());
            statement.setDate(3, dataNascSql);

            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getEmail());
            statement.setString(6, cliente.getTelefone());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void update(Object obj) {
        Cliente cliente = (Cliente) obj;

        sql = " UPDATE cliente "
                + " SET nome = ?, CPF = ?, dataNasc = ?, senha = ?, email = ?, telefone = ? "
                + " WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            //preencher cada ? com o campo adequado
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCPF());

            // Converter o Calendar para java.sql.Date
            java.sql.Date dataNascSql = new java.sql.Date(cliente.getDataNasc().getTimeInMillis());
            statement.setDate(3, dataNascSql);

            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getEmail());
            statement.setString(6, cliente.getTelefone());

            //preenche a condição do WHERE
            statement.setString(7, cliente.getIdCliente());

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

        sql = "SELECT * FROM cliente ORDER BY upper(nome)";
        try {
            statement = Persistencia.getConnection().prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {

                // Converter o java.sql.Date para Calendar
                java.sql.Date sqlDate = resultset.getDate(5);
                Calendar dataNasc = Calendar.getInstance();
                dataNasc.setTimeInMillis(sqlDate.getTime());

                Cliente cliente = new Cliente(
                        resultset.getString(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        dataNasc, // Usar o Calendar convertido
                        resultset.getString(4),
                        resultset.getString(5),
                        resultset.getString(6));

                list.add(cliente);
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
        Cliente cliente = (Cliente) obj;

        sql = " SELECT * FROM cliente WHERE id = ? ";
        try {

            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setString(1, cliente.getIdCliente());

            ResultSet resultset = statement.executeQuery();

            // Converter o java.sql.Date para Calendar
            java.sql.Date sqlDate = resultset.getDate(5);
            Calendar dataNasc = Calendar.getInstance();
            dataNasc.setTimeInMillis(sqlDate.getTime());

            Cliente c = null;
            while (resultset.next()) {
                c = new Cliente(
                        resultset.getString(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        dataNasc, // Usar o Calendar convertido
                        resultset.getString(4),
                        resultset.getString(5),
                        resultset.getString(6));
            }
            statement.close();
            return c;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }

    }

    /**
     * Procura um cliente pelo email, que é o identificador único
     *
     * @param email
     * @return Referencia para o cliente na lstCliente
     */
    public Object findByEmail(String email) {
        sql = " Select * FROM cliente as c WHERE c.email = ? ";

        Cliente cliente = null;
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            //preenche a condição
            statement.setString(1, email);

            ResultSet resultset = statement.executeQuery();

            // Converter o java.sql.Date para Calendar
            java.sql.Date sqlDate = resultset.getDate(5);
            Calendar dataNasc = Calendar.getInstance();
            dataNasc.setTimeInMillis(sqlDate.getTime());
            while (resultset.next()) {
                cliente = new Cliente(
                        resultset.getString(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        dataNasc, // Usar o Calendar convertido
                        resultset.getString(4),
                        resultset.getString(5),
                        resultset.getString(6));
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return cliente;
    }

    /**
     * Recebe um Cliente como parametro, procura o Cliente pelo ID Se
     * encontrar, remove ele da lstCliente.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        Cliente cliente = (Cliente) obj;

        sql = " DELETE FROM cliente WHERE id = ? ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            //preenche a condição
            statement.setString(1, cliente.getIdCliente());

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
