/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Allan
 */
import Alunos.Aluno;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
//import java.awt.List;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import trabalho.ConexaoBancoDeDados;


public class Painel extends JFrame{
      
        private Container cn;
        private  JPanel painelFundo;
        private JTable  tabela;
        private  JScrollPane barraRolagem; 
        private  JTextField  jtxt;
        private JButton btn1,btn2; 
        
        
        Aluno al = new Aluno();
        ConexaoBancoDeDados conect = new ConexaoBancoDeDados(); 
        List<Aluno> li = conect.prepareSelect();  
    
        
      
        String pa[][] = new String[1][1];
        private final String [] colunas= {"Nome","Data NC","Sexo","RG","CPF"};       
        private Object[][] dados = { 
        {li.get(0).getNome(),li.get(0).getData(),li.get(0).isSexo(),li.get(0).getRg(),li.get(0).getCpf()},
        {li.get(1).getNome(),li.get(1).getData(),li.get(1).isSexo(),li.get(1).getRg(),li.get(1).getCpf()},
        {li.get(2).getNome(),li.get(2).getData(),li.get(2).isSexo(),li.get(2).getRg(),li.get(2).getCpf()},
        {li.get(3).getNome(),li.get(3).getData(),li.get(3).isSexo(),li.get(3).getRg(),li.get(3).getCpf()},
        {li.get(4).getNome(),li.get(4).getData(),li.get(4).isSexo(),li.get(4).getRg(),li.get(4).getCpf()},
        {li.get(5).getNome(),li.get(5).getData(),li.get(5).isSexo(),li.get(5).getRg(),li.get(5).getCpf()},
        {li.get(6).getNome(),li.get(6).getData(),li.get(6).isSexo(),li.get(6).getRg(),li.get(6).getCpf()},
        {li.get(7).getNome(),li.get(7).getData(),li.get(7).isSexo(),li.get(7).getRg(),li.get(7).getCpf()},
        {li.get(8).getNome(),li.get(8).getData(),li.get(8).isSexo(),li.get(8).getRg(),li.get(8).getCpf()} 
        };
        
        
        Painel(){
         
            tabela();
            this.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE); 
            this.setSize(500,250);
            this.setTitle("Formulário");
            cn = getContentPane();
            //cn.setLayout(null);
            this.setVisible(true);
           

       

        }
    
        
        public void tabela(){   
            painelFundo = new JPanel();
            painelFundo.setLayout(new BorderLayout()); //new GridLayout(1, 1
            tabela = new JTable(dados,colunas);
            barraRolagem = new JScrollPane(tabela);
            painelFundo.add(barraRolagem); 
            cadastro();
            this.add(btn1);
            this.add(btn2);
            getContentPane().add(painelFundo,BorderLayout. CENTER);
     
        }
        
        public void  fixa(){
             al.setNome("Allan");
             al.setData("28/06/1994");
             al.setSexo(true);
             al.setRg("55009791-9");
             al.setCpf("439794688");                  
        }
          
        
          public void cadastro(){
            jtxt = new JTextField();
            btn1 = new JButton("ok");
            btn2 = new JButton("Cancel");
            btn1.setBounds(0, 180, 50, 30);
            btn2.setBounds(50, 180, 80, 30);
          
          }
    
        
        public static void main(String[] args) {
            Painel pn = new Painel();
      
    }
        
}
