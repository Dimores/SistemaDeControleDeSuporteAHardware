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
import model.interfaces.*;

public class TecnicoDAO implements IDao {

    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    public TecnicoDAO() {
        this.sql = "";
    }

    @Override
    public void save(Object obj) {
        Tecnico tecnico = (Tecnico) obj;

        sql = " INSERT INTO "
                + " tecnico(salario,  nome, CPF, dataNasc, senha, email, telefone) "
                + " VALUES(?,?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            //preencher cada ? com o campo adequado
            statement.setString(1, tecnico.getNome());
            statement.setDouble(2, tecnico.getSalario());
            statement.setString(3, tecnico.getCPF());

            // Converter o Calendar para java.sql.Date
            java.sql.Date dataNascSql = new java.sql.Date(tecnico.getDataNasc().getTimeInMillis());
            statement.setDate(4, dataNascSql);

            statement.setString(5, tecnico.getSenha());
            statement.setString(6, tecnico.getEmail());
            statement.setString(7, tecnico.getTelefone());
            
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void update(Object obj) {
        Tecnico tecnico = (Tecnico) obj;

        sql = " UPDATE tecnico "
                + " SET salario = ?,  nome = ?, CPF = ?, dataNasc = ?, senha = ?, email = ?, telefone = ? "
                + " WHERE id = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            //preencher cada ? com o campo adequado
            statement.setString(1, tecnico.getNome());
            statement.setDouble(2, tecnico.getSalario());
            statement.setString(3, tecnico.getCPF());

            // Converter o Calendar para java.sql.Date
            java.sql.Date dataNascSql = new java.sql.Date(tecnico.getDataNasc().getTimeInMillis());
            statement.setDate(4, dataNascSql);

            statement.setString(5, tecnico.getSenha());
            statement.setString(6, tecnico.getEmail());
            statement.setString(7, tecnico.getTelefone());

            //preenche a condição do WHERE
            statement.setString(8, tecnico.getId());

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

    sql = "SELECT * FROM tecnico ORDER BY upper(nome)";
    try {
        statement = Persistencia.getConnection().prepareStatement(sql);
        ResultSet resultset = statement.executeQuery();
        while (resultset.next()) {
            
            // Converter o java.sql.Date para Calendar
            java.sql.Date sqlDate = resultset.getDate(5);
            Calendar dataNasc = Calendar.getInstance();
            dataNasc.setTimeInMillis(sqlDate.getTime());

            Tecnico tecnico = new Tecnico(
                    resultset.getString(1),
                    resultset.getDouble(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    dataNasc, // Usar o Calendar convertido
                    resultset.getString(6),
                    resultset.getString(7),
                    resultset.getString(8));

            list.add(tecnico);
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
        Tecnico tecnico = (Tecnico) obj;

        sql = " SELECT * FROM tecnico WHERE id = ? ";
        try {

            statement = Persistencia.getConnection().prepareStatement(sql);
            statement.setString(1, tecnico.getId());

            ResultSet resultset = statement.executeQuery();
            
            // Converter o java.sql.Date para Calendar
            java.sql.Date sqlDate = resultset.getDate(5);
            Calendar dataNasc = Calendar.getInstance();
            dataNasc.setTimeInMillis(sqlDate.getTime());

            Tecnico t = null;
            while (resultset.next()) {
                t = new Tecnico(
                    resultset.getString(1),
                    resultset.getDouble(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    dataNasc, // Usar o Calendar convertido
                    resultset.getString(6),
                    resultset.getString(7),
                    resultset.getString(8));
            }
            statement.close();
            return t;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }

    }

    /**
     * Procura um tenico pelo email, que é o identificador único
     *
     * @param email
     * @return Referencia para o tenico na lstTecnico
     */
    public Object findByEmail(String email) {
        sql = " Select * FROM tecnico as t WHERE t.email = ? ";

        Tecnico tecnico = null;
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
                tecnico = new Tecnico(
                    resultset.getString(1),
                    resultset.getDouble(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    dataNasc, // Usar o Calendar convertido
                    resultset.getString(6),
                    resultset.getString(7),
                    resultset.getString(8));
            }
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return tecnico;
    }

    /**
     * Recebe um Aluno como parametro, procura o Aluno pela Matricula Se
     * encontrar remove ele da lstAlunos.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        Tecnico tecnico = (Tecnico) obj;

        sql = " DELETE FROM tecnico WHERE id = ? ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            //preenche a condição
            statement.setString(1, tecnico.getId());

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
