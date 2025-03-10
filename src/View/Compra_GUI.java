/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arthu
 */
public class Compra_GUI extends javax.swing.JFrame {
    
    String servidor = "localhost";
    String banco = "mercado";
    String url = "jdbc:mysql://localhost/mercado";
    String usuario = "root";
    String senhaBanco = "ceap";
    
    //inicio codigo
    
    public static DefaultTableModel  produto(ResultSet rs) {
        try {
           ResultSetMetaData metaData = rs.getMetaData();
         int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
       // AS LINHAS ABAIXO SÃO REFERENTES AOS CAMPOS DA TABELA CLIENTE
            columnNames.addElement("Código");
            columnNames.addElement("Nome");
            columnNames.addElement("QTDE");
            columnNames.addElement("Preço");
         
            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }
                rows.addElement(newRow);
            }
           return new DefaultTableModel(rows, columnNames);
       } catch (Exception e) {

           return null;
       }
    }
    
    public void refresh(){
    
        try{
           Connection conn;
           conn = (Connection) DriverManager.getConnection(url, usuario, senhaBanco);
           Controller.Conecta_BD.carregaDriver();


           System.out.println("realizado");
           String sql = "SELECT * FROM produto";
           PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           produto.setModel(produto(rs));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }    
    } 



    
    
    //fim codigo
    
    
    public Compra_GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("mercado?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        produtoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Produto p");
        produtoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : produtoQuery.getResultList();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        produto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cod_prod = new org.edisoncor.gui.textField.TextField();
        jLabel2 = new javax.swing.JLabel();
        preco = new org.edisoncor.gui.textField.TextField();
        jLabel3 = new javax.swing.JLabel();
        cliente = new org.edisoncor.gui.textField.TextField();
        jLabel4 = new javax.swing.JLabel();
        preco_Final = new org.edisoncor.gui.textField.TextField();
        calculo_btn = new org.edisoncor.gui.button.ButtonIcon();
        jLabel5 = new javax.swing.JLabel();
        prod = new org.edisoncor.gui.textField.TextField();
        jLabel6 = new javax.swing.JLabel();
        qtde = new org.edisoncor.gui.textField.TextField();
        pesquisaCliente_btn = new org.edisoncor.gui.button.ButtonIcon();
        Voltar_btn = new org.edisoncor.gui.button.ButtonNice();
        jLabel7 = new javax.swing.JLabel();
        cpf = new org.edisoncor.gui.textField.TextField();
        pesquisaProduto_btn = new org.edisoncor.gui.button.ButtonIcon();
        jLabel8 = new javax.swing.JLabel();
        escolhe_data = new com.toedter.calendar.JDateChooser();
        finaliza_btn1 = new org.edisoncor.gui.button.ButtonNice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setColorPrimario(new java.awt.Color(0, 0, 255));
        panel1.setColorSecundario(new java.awt.Color(0, 0, 153));
        panel1.setLayout(null);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produtoList, produto);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProd}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeProd}"));
        columnBinding.setColumnName("Produto");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtdeProd}"));
        columnBinding.setColumnName("Qtde em Estoque");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precoProd}"));
        columnBinding.setColumnName("Preço");
        columnBinding.setColumnClass(Float.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(produto);

        panel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 570, 110);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código do Produto");
        panel1.add(jLabel1);
        jLabel1.setBounds(350, 130, 140, 17);
        panel1.add(cod_prod);
        cod_prod.setBounds(350, 150, 50, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Preço");
        panel1.add(jLabel2);
        jLabel2.setBounds(350, 260, 80, 17);
        panel1.add(preco);
        preco.setBounds(350, 280, 100, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data da Compra");
        panel1.add(jLabel3);
        jLabel3.setBounds(350, 190, 120, 17);
        panel1.add(cliente);
        cliente.setBounds(30, 210, 170, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Preço Final");
        panel1.add(jLabel4);
        jLabel4.setBounds(350, 340, 80, 17);
        panel1.add(preco_Final);
        preco_Final.setBounds(350, 370, 130, 30);

        calculo_btn.setBackground(new java.awt.Color(0, 0, 204));
        calculo_btn.setBorder(null);
        calculo_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cifrao.png"))); // NOI18N
        calculo_btn.setToolTipText("Pesquisa de Produto");
        calculo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculo_btnActionPerformed(evt);
            }
        });
        panel1.add(calculo_btn);
        calculo_btn.setBounds(490, 360, 40, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Produto");
        panel1.add(jLabel5);
        jLabel5.setBounds(30, 260, 80, 17);
        panel1.add(prod);
        prod.setBounds(30, 290, 170, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("QTDE");
        panel1.add(jLabel6);
        jLabel6.setBounds(30, 350, 80, 17);
        panel1.add(qtde);
        qtde.setBounds(30, 370, 80, 30);

        pesquisaCliente_btn.setBackground(new java.awt.Color(0, 0, 204));
        pesquisaCliente_btn.setBorder(null);
        pesquisaCliente_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        pesquisaCliente_btn.setToolTipText("Pesquisa de Produto");
        pesquisaCliente_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaCliente_btnActionPerformed(evt);
            }
        });
        panel1.add(pesquisaCliente_btn);
        pesquisaCliente_btn.setBounds(210, 150, 30, 30);

        Voltar_btn.setText("VOLTAR");
        Voltar_btn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        Voltar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Voltar_btnActionPerformed(evt);
            }
        });
        panel1.add(Voltar_btn);
        Voltar_btn.setBounds(300, 430, 242, 64);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CPF");
        panel1.add(jLabel7);
        jLabel7.setBounds(30, 130, 80, 17);
        panel1.add(cpf);
        cpf.setBounds(30, 150, 170, 30);

        pesquisaProduto_btn.setBackground(new java.awt.Color(0, 0, 204));
        pesquisaProduto_btn.setBorder(null);
        pesquisaProduto_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        pesquisaProduto_btn.setToolTipText("Pesquisa de Produto");
        pesquisaProduto_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaProduto_btnActionPerformed(evt);
            }
        });
        panel1.add(pesquisaProduto_btn);
        pesquisaProduto_btn.setBounds(420, 150, 30, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cliente");
        panel1.add(jLabel8);
        jLabel8.setBounds(30, 190, 80, 17);
        panel1.add(escolhe_data);
        escolhe_data.setBounds(350, 210, 150, 30);

        finaliza_btn1.setText("FINALIZAR COMPRA");
        finaliza_btn1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        finaliza_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finaliza_btn1ActionPerformed(evt);
            }
        });
        panel1.add(finaliza_btn1);
        finaliza_btn1.setBounds(40, 430, 242, 64);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(569, 514));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisaCliente_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaCliente_btnActionPerformed
        //incio codigo
        
        try{     //Iniciando o possivel tratamento de erros
            //Declarando a variavel código
            long cpf2 = Long.valueOf(cpf.getText());
            Controller.Conecta_BD.carregaDriver(); // Carregando o driver
            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão
                Connection con = null;

                con = (Connection) DriverManager.getConnection(url,usuario,senhaBanco);

                // Declarando uma string com o comando mySQL para consulta
                String sql = "SELECT nome_cli FROM cliente WHERE cpf_cli ="+cpf2;
                // Criando variavel que executara o comando da string sql
                Statement stm = (Statement) con.createStatement();
                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs
                    ResultSet rs = stm.executeQuery(sql);

                    int i=0; // Variavel utilizada para saber se ha dados cadastrados

                    while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String nome2 = rs.getString("nome_cli");

                        i++;

                        //JOptionPane.showMessageDialog(null,"Nome: " + nome + "\nEmail: " +email + "\nTelefone: " +telefone, "Resultado",-1);
                        cliente.setText(String.valueOf(nome2));

                    }

                    if(i==0){ // Verificando se ha dados cadastrados atraves da variavel i

                        JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);

                    }

                } catch (Exception ex) { // Consulta mal sucedida
                    JOptionPane.showMessageDialog(null,"\nErro ao consultar!","ERRO",0);
                }

            } catch (SQLException ex) {
                // Conexão com servidor mal sucedida
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Código fora do formato
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod_prod.setText("");
        }
        //fim codigo
    }//GEN-LAST:event_pesquisaCliente_btnActionPerformed

    private void calculo_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculo_btnActionPerformed
        double preco2 = Double.parseDouble(preco.getText());
        int qtde2 = Integer.parseInt(qtde.getText());
        double precoFinal = preco2*qtde2;
        
        preco_Final.setText(String.valueOf(precoFinal));
    }//GEN-LAST:event_calculo_btnActionPerformed

    private void pesquisaProduto_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaProduto_btnActionPerformed
         //incio codigo
        
        try{     //Iniciando o possivel tratamento de erros
            //Declarando a variavel código
            int cod = Integer.valueOf(cod_prod.getText());
            Controller.Conecta_BD.carregaDriver(); // Carregando o driver
            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão
                Connection con = null;

                con = (Connection) DriverManager.getConnection(url,usuario,senhaBanco);

                // Declarando uma string com o comando mySQL para consulta
                String sql = "SELECT nome_prod, preco_prod FROM produto WHERE id_prod = "+cod;
                // Criando variavel que executara o comando da string sql
                Statement stm = (Statement) con.createStatement();
                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs
                    ResultSet rs = stm.executeQuery(sql);

                    int i=0; // Variavel utilizada para saber se ha dados cadastrados

                    while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String prod2 = rs.getString("nome_prod");
                        String preco2 = rs.getString("preco_prod");

                        i++;

                        //JOptionPane.showMessageDialog(null,"Nome: " + nome + "\nEmail: " +email + "\nTelefone: " +telefone, "Resultado",-1);
                        prod.setText(String.valueOf(prod2));
                        preco.setText(String.valueOf(preco2));

                    }

                    if(i==0){ // Verificando se ha dados cadastrados atraves da variavel i

                        JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);

                    }

                } catch (Exception ex) { // Consulta mal sucedida
                    JOptionPane.showMessageDialog(null,"\nErro ao consultar!","ERRO",0);
                }

            } catch (SQLException ex) {
                // Conexão com servidor mal sucedida
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Código fora do formato
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod_prod.setText("");
        }
        //fim codigo
    }//GEN-LAST:event_pesquisaProduto_btnActionPerformed

    private void Voltar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Voltar_btnActionPerformed
        dispose();
        new Menu_GUI().setVisible(true);
    }//GEN-LAST:event_Voltar_btnActionPerformed

    private void finaliza_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finaliza_btn1ActionPerformed
        String cliente2 = cliente.getText();
        long cpf2 = Long.valueOf(cpf.getText());
        int cod = Integer.parseInt(cod_prod.getText());
        String nomeProd = prod.getText();
        double precoInd = Double.parseDouble(preco.getText());
        int qtdeProd = Integer.parseInt(qtde.getText());
        double precoFinal = Double.parseDouble(preco_Final.getText());
        Date dataCom = escolhe_data.getDate();

        Controller.Conecta_BD.carregaDriver();

        try {
            Connection con = DriverManager.getConnection(url, usuario, senhaBanco);

            String sql = "INSERT INTO compra (cpf_com, cli_com, prod_com, preco_ind, qtde_com, data_com, preco_fin) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement inserir = con.prepareStatement(sql)) {
            inserir.setLong(1, cpf2);
            inserir.setString(2, cliente2);
            inserir.setString(3, nomeProd);
            inserir.setDouble(4, precoInd);
            inserir.setInt(5, qtdeProd);
            inserir.setDate(6, new java.sql.Date(dataCom.getTime()));  // Converte java.util.Date para java.sql.Date
            inserir.setDouble(7, precoFinal);

            inserir.executeUpdate();
            JOptionPane.showMessageDialog(null, "\nInserção realizada com sucesso!!!\n", "", -1);
            sleep(2000);
            dispose();
            new VisuCompra_GUI().setVisible(true);

            // Limpar os campos
            cpf.setText("");
            cliente.setText("");
            prod.setText("");
            cod_prod.setText("");
            preco.setText("");
            qtde.setText("");
            preco_Final.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "\nErro na inserção!\n" + ex.getMessage(), "ERRO!", 0);
        }   catch (InterruptedException ex) {
                Logger.getLogger(Compra_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "\nErro ao conectar ao banco de dados!\n" + ex.getMessage(), "ERRO!", 0);
        }

    }//GEN-LAST:event_finaliza_btn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compra_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonNice Voltar_btn;
    private org.edisoncor.gui.button.ButtonIcon calculo_btn;
    private org.edisoncor.gui.textField.TextField cliente;
    private org.edisoncor.gui.textField.TextField cod_prod;
    private org.edisoncor.gui.textField.TextField cpf;
    private javax.persistence.EntityManager entityManager;
    private com.toedter.calendar.JDateChooser escolhe_data;
    private org.edisoncor.gui.button.ButtonNice finaliza_btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.button.ButtonIcon pesquisaCliente_btn;
    private org.edisoncor.gui.button.ButtonIcon pesquisaProduto_btn;
    private org.edisoncor.gui.textField.TextField preco;
    private org.edisoncor.gui.textField.TextField preco_Final;
    private org.edisoncor.gui.textField.TextField prod;
    private javax.swing.JTable produto;
    private java.util.List<View.Produto> produtoList;
    private javax.persistence.Query produtoQuery;
    private org.edisoncor.gui.textField.TextField qtde;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
