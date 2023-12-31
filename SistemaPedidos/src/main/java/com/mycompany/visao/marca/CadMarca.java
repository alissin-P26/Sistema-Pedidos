/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.marca;

import com.mycompany.dao.DaoCategoria;
import com.mycompany.dao.DaoMarca;
import com.mycompany.ferramenetas.Constantes;
import com.mycompany.ferramenetas.DadosTemporarios;
import com.mycompany.ferramenetas.Formularios;
import com.mycompany.modelo.ModCategoria;
import com.mycompany.modelo.ModMarca;
import com.mycompany.visao.categoria.ListCategoria;
import javax.swing.JOptionPane;


/**
 *
 * @author jose.5989
 */
public class CadMarca extends javax.swing.JFrame {

    /**
     * Creates new form CadMarca
     */
    public CadMarca() {              
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoMarca daoMarca = new DaoMarca();

            int id = daoMarca.buscarProximoId(); 
            if (id >= 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
    }
    
    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModMarca){
            int id = ((ModMarca) DadosTemporarios.tempObject).getId();
            String nome = ((ModMarca) DadosTemporarios.tempObject).getNome();
            
            
            tfId.setText(String.valueOf(id));
            tfNome.setText(nome);
            
        
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    
    }
    
    private void inserir(){
        DaoMarca daoMarca = new DaoMarca();
        
        if (daoMarca.inserir(Integer.parseInt(tfId.getText()), tfNome.getText())){
            JOptionPane.showMessageDialog(null, "Categoria salva com sucesso!");
            
            tfId.setText(String.valueOf(daoMarca.buscarProximoId()));
            tfNome.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar a categoria!");
        }
    }
    
    private void alterar(){
        DaoMarca daoMarca = new DaoMarca();
        
        if (daoMarca.alterar(Integer.parseInt(tfId.getText()), tfNome.getText())){
            JOptionPane.showMessageDialog(null, "Marca alterada com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a marca!");
        }
        
        ((ListCategoria) Formularios.listCategoria).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoMarca daoMarca = new DaoMarca();
        
        if (daoMarca.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Categoria " + tfNome.getText() + " excluída com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a marca!");
        }
        
        ((ListCategoria) Formularios.listCategoria).listarTodos();
        
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnAcao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Marca");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addGap(96, 96, 96)
                        .addComponent(btnAcao))
                    .addComponent(jLabel2)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAcao))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir a categoria " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        DaoMarca daoMarca = new DaoMarca();
        
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            tfId.setText(String.valueOf(daoMarca.buscarProximoId()));
            tfNome.setText("");
            
        }
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT){
            alterar();
            ((ListMarca) Formularios.listMarca).listarTodos();
            dispose();
        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadCategoria = null;
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(CadMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadMarca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables


}
