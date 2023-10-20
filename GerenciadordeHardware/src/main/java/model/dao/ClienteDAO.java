package model.dao;

import factory.Persistencia;
import model.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                + " VALUES(?,?,?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            //preencher cada ? com o campo adequado
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCPF());

            // Converter o Calendar para java.sql.Date

            statement.setString(3, cliente.getDataNasc());

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

            statement.setString(3, cliente.getDataNasc());

            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getEmail());
            statement.setString(6, cliente.getTelefone());

            //preenche a condição do WHERE
            statement.setLong(7, cliente.getId());

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



                Cliente cliente = new Cliente(
                        resultset.getLong(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5),
                        resultset.getString(6),
                        resultset.getString(7));

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
            statement.setLong(1, cliente.getId());

            ResultSet resultset = statement.executeQuery();



            Cliente c = null;
            while (resultset.next()) {
                c = new Cliente(
                        resultset.getLong(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5),
                        resultset.getString(6),
                        resultset.getString(7));
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


            while (resultset.next()) {
                cliente = new Cliente(
                        resultset.getLong(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5),
                        resultset.getString(6),
                        resultset.getString(7));
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
            statement.setLong(1, cliente.getId());

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
