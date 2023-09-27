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
                + " VALUES(?,?,?,?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            //preencher cada ? com o campo adequado

            statement.setDouble(1, tecnico.getSalario());
            statement.setString(2, tecnico.getNome());
            statement.setString(3, tecnico.getCPF());

            statement.setString(4, tecnico.getDataNasc());


            statement.setString(5, tecnico.getSenha());
            statement.setString(6, tecnico.getEmail());
            statement.setString(7, tecnico.getTelefone());
            
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            System.out.println("Erro ao salvar");
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
            statement.setDouble(1, tecnico.getSalario());
            statement.setString(2, tecnico.getNome());
            statement.setString(3, tecnico.getCPF());

            statement.setString(4, tecnico.getDataNasc());

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
            


            Tecnico tecnico = new Tecnico(
                    resultset.getString(1),
                    resultset.getDouble(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5),
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
            


            Tecnico t = null;
            while (resultset.next()) {
                t = new Tecnico(
                    resultset.getString(1),
                    resultset.getDouble(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5),
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
            

            while (resultset.next()) {
                tecnico = new Tecnico(
                    resultset.getString(1),
                    resultset.getDouble(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5),
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
