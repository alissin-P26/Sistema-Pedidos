/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.estado;

import com.mycompany.dao.DaoCategoria;
import com.mycompany.dao.DaoEstado;
import com.mycompany.dao.DaoPais;
import com.mycompany.ferramenetas.Constantes;
import com.mycompany.ferramenetas.DadosTemporarios;
import com.mycompany.ferramenetas.Formularios;
import com.mycompany.modelo.ModEstado;
import com.mycompany.visao.categoria.ListCategoria;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jose.5989
 */
public class CadEstado extends javax.swing.JFrame {

    /**
     * Creates new form CadEndereco
     */
    public CadEstado() {
        initComponents();
        
        carregarPaises();
        
        if(!existeDadosTemporarios()){
            DaoEstado daoEstado = new DaoEstado();

            int id = daoEstado.buscarProximoId(); 
            if (id > 0)
                tfID.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdPais();
        
        setLocationRelativeTo(null);
        
        tfID.setEnabled(false);
        
        tfIDPais.setVisible(false);;
    }
    
    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModEstado){
            int id = ((ModEstado) DadosTemporarios.tempObject).getId();
            int idPais = ((ModEstado) DadosTemporarios.tempObject).getIdPais();
            String nome = ((ModEstado) DadosTemporarios.tempObject).getNome();
            String uf = ((ModEstado) DadosTemporarios.tempObject).getUf();
            
            tfID.setText(String.valueOf(id));
            tfIDPais.setText(String.valueOf(idPais));
            tfNome.setText(nome);
            tfUf.setText(uf);
            
            //
            try{
                DaoPais daoPais = new DaoPais();
                ResultSet resultSet = daoPais.listarPorId(idPais);
                resultSet.next();
                String pais = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < jcbPais.getItemCount(); i++){
                    if(jcbPais.getItemAt(i).equals(pais)){
                        index = i;
                        break;
                    }
                }
                jcbPais.setSelectedIndex(index);
            }catch(Exception e){}
            //
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }

    private void inserir(){
        DaoEstado daoEstado = new DaoEstado();
        
        if (daoEstado.inserir(Integer.parseInt(tfID.getText()), Integer.parseInt(tfIDPais.getText()), tfNome.getText(), tfUf.getText())){
            JOptionPane.showMessageDialog(null, "Estado salvo com sucesso!");
            
            tfID.setText(String.valueOf(daoEstado.buscarProximoId()));
            tfNome.setText("");
            tfUf.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o estado!");
        }
    }
    
    private void alterar(){
        DaoEstado daoEstado = new DaoEstado();
        
        if (daoEstado.alterar(Integer.parseInt(tfID.getText()), Integer.parseInt(tfIDPais.getText()), tfNome.getText(), tfUf.getText())){
            JOptionPane.showMessageDialog(null, "Estado alterada com sucesso!");
            
            tfID.setText("");
            tfIDPais.setText("");
            tfNome.setText("");
            tfUf.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o estado!");
        }
        
        ((ListEstado) Formularios.listEstado).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoEstado daoEstado = new DaoEstado();
        
        if (daoEstado.excluir(Integer.parseInt(tfID.getText()))){
            JOptionPane.showMessageDialog(null, "Estado " + tfNome.getText() + " excluída com sucesso!");
            
            tfID.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o estado!");
        }
        
        ((ListEstado) Formularios.listEstado).listarTodos();
        
        dispose();
    }
    
    private void carregarPaises(){
        try{
            DaoPais daoPais = new DaoPais();

            ResultSet resultSet = daoPais.listarTodos();

            while(resultSet.next())
                jcbPais.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdPais(){
        try{
            DaoPais daoPais = new DaoPais();
            ResultSet resultSet = daoPais.listarPorNome(jcbPais.getSelectedItem().toString());
            
            resultSet.next();
            tfIDPais.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfID = new javax.swing.JTextField();
        tfIDPais = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfUf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jcbPais = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Estado");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDActionPerformed(evt);
            }
        });

        tfIDPais.setText("ID País");

        jLabel3.setText("Nome Do Estado");

        jLabel4.setText("UF");

        jLabel1.setText("ID");

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jcbPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPaisItemStateChanged(evt);
            }
        });
        jcbPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAcao))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfIDPais, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIDPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAcao))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDActionPerformed
        
    }//GEN-LAST:event_tfIDActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o estado " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void jcbPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPaisActionPerformed
        
    }//GEN-LAST:event_jcbPaisActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
       if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT)
            inserir();
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void jcbPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPaisItemStateChanged
        recuperaIdPais();
    }//GEN-LAST:event_jcbPaisItemStateChanged

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
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadEstado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> jcbPais;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfIDPais;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfUf;
    // End of variables declaration//GEN-END:variables

}
