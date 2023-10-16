/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.Persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.DispositivoDeRede;
import model.interfaces.IDao;

/**
 *
 * @author diego
 */
public class DispositivoRedeDAO implements IDao {

    public DispositivoRedeDAO() {
        this.sql = "";
    }
    
    protected Connection connection;
    private PreparedStatement statement;
    private String sql;

    @Override
    public void save(Object obj) {
        DispositivoDeRede dispositivoRede = (DispositivoDeRede) obj;

        sql = " INSERT INTO "
                + " dispositivorede(nome, enderecoIP, tipo, fabricante, modelo, preco) "
                + " VALUES(?,?,?,?,?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            // Preencher cada ? com o campo adequado
            statement.setString(1, dispositivoRede.getNome());
            statement.setString(2, dispositivoRede.getEnderecoIP());
            statement.setString(3, dispositivoRede.getTipo());
            statement.setString(4, dispositivoRede.getFabricante());
            statement.setString(5, dispositivoRede.getModelo());
            statement.setDouble(8, dispositivoRede.getPreco());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
