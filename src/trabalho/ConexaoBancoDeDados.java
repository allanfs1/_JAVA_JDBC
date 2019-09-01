package trabalho;

import Alunos.Aluno;
import com.mysql.jdbc.Driver;
//import java.awt.List;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
           
            inserir = conexao.createStatement(); //PreparedStatement
            inserir.execute("INSERT INTO tb_Pessoas VALUES(NULL,'Jair','1874/06/2','M','6867854','3468905')");
            System.out.println("Dados Inseridos com sucesso");
        } catch (SQLException ex) {
           System.out.println("Erro de Inseri dados");
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
    
    public List<Aluno> prepareSelect(){
        
          List<Aluno> aluno = new ArrayList<Aluno>();
          
        try {
            PreparedStatement psSelect= this.conexao.prepareStatement("Select * from tb_pessoas");
           // psSelect.setString(1, "7");
            ResultSet res = psSelect.executeQuery();
            while (res.next()) {
             Aluno al = new Aluno();   
            //(res.getString("id_aluno"));     
             al.setNome(res.getString("nome"));
             al.setData(res.getString("dt_data"));
             al.setSexo(res.getBoolean("sexo"));
             al.setRg(res.getString("rg"));
             al.setCpf(res.getString("cpf"));
             System.out.println("Select");
             aluno.add(al);
            }
            
        } catch (SQLException ex) {
            
        }
        
        for(int i =0;i<aluno.size();i++)
            System.out.println(aluno.get(i).getNome());
            
        
        
        return aluno;
    }

    public static void main(String[] args) {
        ConexaoBancoDeDados conexao = new ConexaoBancoDeDados();
       // conexao.inserir();
        conexao.prepareSelect();
       
    }
}
