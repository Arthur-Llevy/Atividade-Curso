package Conectividades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import meusclientes.*;
import Telas.*;

public class Conexao {
 
    private final String fonte = "jdbc:mysql://localhost/meusclientes";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String usuario = "arthur";
    private final String senha = "123";
    private Connection con;
    private PreparedStatement stm;
    
    public void cadastrarCliente(Cliente cliente) throws SQLException{
        try{
            this.con = DriverManager.getConnection(fonte, this.usuario, this.senha);        
            this.stm = this.con.prepareStatement("INSERT INTO" + " cliente (nome, telefone, celular, email)" + " values(?, ?, ?, ?)");
            this.stm.setString(1, cliente.getNome());
            this.stm.setString(2, cliente.getCelular());
            this.stm.setString(3, cliente.getTelefone());
            this.stm.setString(4, cliente.getEmail());
            this.stm.execute();
            this.stm.close();            
        } catch(SQLException e){
            System.out.print(e);
        }
    }
    
    public Cliente procurarCliente(int id) throws SQLException{
        try{
            this.con = DriverManager.getConnection(fonte, usuario, senha);
            this.stm = con.prepareStatement("SELECT * FROM cliente" + " WHERE id = ?");
            
            this.stm.setInt(1, id);
            ResultSet rs = this.stm.executeQuery();
            Cliente cliente = new Cliente();
            
            while(rs.next()){
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
            }
            
            this.con.close();           
            return cliente;
        }catch (SQLException e){
            e.printStackTrace();
        }        
        
        return new Cliente();
    }
    
    public void atualizarCliente(Cliente cliente, int id) throws SQLException{
        try{
            this.con = DriverManager.getConnection(fonte, usuario, senha);
            this.stm = this.con.prepareStatement("UPDATE cliente SET nome = ?," + "telefone = ?," + " celular = ?," + "email = ?" + " WHERE id = ?");
            this.stm.setString((1), cliente.getNome());
            this.stm.setString((2), cliente.getTelefone());
            this.stm.setString((3), cliente.getCelular());
            this.stm.setString((4), cliente.getEmail());
            this.stm.setInt(5, id);
            
            this.stm.executeUpdate();
            this.con.close();
            
        }catch (SQLException e){
            e.printStackTrace();
        }        
    }
    
    public void deletarCliente(Cliente cliente) throws SQLException {
        try {
            this.con = DriverManager.getConnection(fonte, usuario, senha);
            this.stm = this.con.prepareStatement("DELETE FROM cliente " + "WHERE id = ?");
            this.stm.setInt(1, cliente.getId());
            this.stm.execute();
            this.con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<Cliente> todosClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try {
            this.con = DriverManager.getConnection(fonte, usuario, senha);
            this.stm = this.con.prepareStatement("SELECT * FROM cliente");
            
            ResultSet resultados = this.stm.executeQuery();
            
            while(resultados.next()){
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String celular = resultados.getString("celular");
                String telefone = resultados.getString("telefone");
                String email = resultados.getString("email");
                
                Cliente cliente = new Cliente(id, nome, telefone, celular, email);
                clientes.add(cliente);
                
                
//                System.out.println(resultados.getString("nome"));  
//                System.out.println(clientes);  
            }
            
            return clientes;
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
        
}
