# JAVA JDBC


# Projeto java Formulário
**Athor:Allan**
**Data:28/08/2019**
**Linguagem:Java**

*Java Database
Connectivity (JDBC)*
- AWT
- SWING

 *VS:5.1.48* 

 ## Tabela de Cadastro:

> Formulário

|#Nome                |      #sexo         | #Data     | #CPF |    #RG      |     
|:--------------------|:------------------:|-----------|-----:|:-----------:|
|Newton               |        M           |2000/0/0   |100033|99899899     |
|Allan                |        M           |1994/06/28 |611112|11213445     |
|Helio                |        M           |1994/03/22 |523456|123456677    |
|Eduardo              |        M           |2003/01/12 |434667|133353333    |
|Fernando             |        M           |2002/04/17 |224678|123567789    |  
|---------------------|--------------------|-----------|------|-------------|


**SQL**

MYSQL:
Gerenciador:HeidiSQL
**Xammp**
Banco:sala
PORT:3308
Usuário:root
Senha:root

```sql
USE sala;
CREATE TABLE tb_Pessoas (
 id_aluno INT NOT NULL AUTO_INCREMENT,
 nome VARCHAR(50),
 dt_data DATE DEFAULT "2000/6/1",
 sexo ENUM('M','F'),
 rg  VARCHAR(10) NOT NULL,
 cpf VARCHAR(10),
  CONSTRAINT pk_alunos PRIMARY KEY (id_aluno)
)ENGINE = INNODB;

```
##Java

 - String de Coneção
   - DRIVE = "com.mysql.jdbc.Driver";
   - "jdbc:mysql://localhost:3306/aula"; IP: (127.0.0.1)
   -  USER = "root";
   -  PASS = "root";
 - conect
 
> Classes import

- ### JAVA.SQL E JAVAX.SQL
- import com.mysql.jdbc.Driver;
- import java.sql.Connection;
- import java.sql.DriverManager;
- import java.sql.PreparedStatement;
- import java.sql.ResultSet;
- import java.sql.SQLException;

