import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBD {
    String banco = "select_01";
    String host = "localhost";
    String str_con = "jdbc:mysql://"+host+":3306/"+banco;
    String driver = "com.mysql.jdbc.Driver";
    String usuario = "root";
    String senha = "";
    
    Connection con;
    PreparedStatement estado;
    
    public void conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(str_con, usuario, senha);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar driver...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar...");
        }
    }
    
    public void fecharConexao() {
        try {
            estado.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão...");
        }
    }
    
}
