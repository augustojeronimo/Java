import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConexaoPessoa extends ConexaoBD{
    
    public void cadastrar(Pessoa p) {
        conectar();
        
        String sql = "insert into pessoa values (?,?,?,?)";
        
        try {
            estado = con.prepareCall(sql);
            
            estado.setString(1, p.getCpf());
            estado.setString(2, p.getNome());
            estado.setString(3, p.getSexo());
            estado.setInt(4, p.getIdade());
            
            estado.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar...");
        } finally {
            fecharConexao();
        }
    }
    
    public void atualizar(Pessoa p) {
        conectar();
        
        String sql = "update pessoa set nome = ?, sexo = ?, idade = ? where cpf = ? limit 1";
        
        try {
            estado = con.prepareCall(sql);
            
            estado.setString(1, p.getNome());
            estado.setString(2, p.getSexo());
            estado.setInt(3, p.getIdade());
            estado.setString(4, p.getCpf());
            
            estado.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar...");
        } finally {
            fecharConexao();
        }
    }
    
    public void remover(Pessoa p) {
        conectar();
        
        String sql = "delete from pessoa where cpf = ? limit 1";
        
        try {
            estado = con.prepareCall(sql);
            
            estado.setString(1, p.getCpf());
            
            estado.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover...");
        } finally {
            fecharConexao();
        }
    }
    
    public ArrayList<Pessoa> consultar(){
        
        conectar();
        
        ArrayList<Pessoa> lista = new ArrayList<>();
        
        String sql = "select * from pessoa";
        
        try {
            
            estado = con.prepareStatement(sql);
            ResultSet resul = estado.executeQuery();
            
            while (resul.next()) {                
                
                Pessoa p = new Pessoa();
                p.setCpf(resul.getString("cpf"));
                p.setNome(resul.getString("nome"));
                p.setSexo(resul.getString("sexo"));
                p.setIdade(resul.getInt("idade"));
                
                lista.add(p);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar...");
        } finally {
            fecharConexao();
        }
        
        return lista;
    }
    
}
