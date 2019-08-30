package trabalho;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoBancoDeDados {

    private Connection conexao;
    private final String URLDB = "jdbc:mysql://localhost:3306/teste";
    private final String usuario = "root";
    private final String senha = "root";

    public ConexaoBancoDeDados() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(URLDB, usuario, senha);
             System.out.println("Conecao estabelecida");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserir() {
        Statement inserir;

        try {
            inserir = conexao.createStatement();
            inserir.execute("INSERT INTO tb_pessoas (nome,dt_data,sexo,rg,cpf) VALUES('2','Allan','200/04/1994','M','456788-9','677899000')");
        } catch (SQLException ex) {
           
        }
    }

    public void update() {
        Statement comando;

        try {
            comando = conexao.createStatement();
            comando.execute("UPDATE tb_pessoas SET nome ='Eduardo' WHERE id_aluno = 2");
        } catch (SQLException ex) {
            
        }
    }
    public void delete() {
        Statement comando;

        try {
            comando = conexao.createStatement();
            comando.execute("delete from tb_pessoas WHERE id_aluno = 3");
        } catch (SQLException ex) {
           
        }
    }
    public void selecionar() {
        try {
            Statement comando;
            comando = conexao.createStatement();
            ResultSet res = comando.executeQuery("SELECT * FROM tb_pessoas");

            while (res.next()) {
                System.out.println(res.getString("nome"));
            }
        } catch (SQLException ex) {
          
        }
    }
    
    public void prepareSelect(){
        try {
            PreparedStatement psSelect= this.conexao.prepareStatement("Select * from tb_pessoas where id_aluno=?");
            psSelect.setString(1, "1");
            ResultSet res = psSelect.executeQuery();
            while (res.next()) {
                System.out.println(res.getString("nome"));
              
            }
            
        } catch (SQLException ex) {
            
        }
        
    }

    public static void main(String[] args) {
        ConexaoBancoDeDados conexao = new ConexaoBancoDeDados();
        conexao.prepareSelect();
        //conexao.selecionar();
    }
}
