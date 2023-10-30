/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.cidade;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEstado;
import com.mycompany.ferramenetas.Constantes;
import com.mycompany.ferramenetas.DadosTemporarios;
import com.mycompany.ferramenetas.Formularios;
import com.mycompany.modelo.ModCidade;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jose.5989
 */
public class CadCidade extends javax.swing.JFrame {

    /**
     * Creates new form CadCidade
     */
           
        public CadCidade() {
        initComponents();
        
        carregarEstados();
        
        if(!existeDadosTemporarios()){
            DaoCidade daoCidade = new DaoCidade();

            int id = daoCidade.buscarProximoId(); 
            if (id > 0)
                tfID.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdEstado();
        
        setLocationRelativeTo(null);
        
        tfID.setEnabled(false);
        
        tfIDEstado.setVisible(false);
    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModCidade){
            int id = ((ModCidade) DadosTemporarios.tempObject).getId();
            int idEstado = ((ModCidade) DadosTemporarios.tempObject).getIdEstado();
            String nome = ((ModCidade) DadosTemporarios.tempObject).getNome();
            
            tfID.setText(String.valueOf(id));
            tfIDEstado.setText(String.valueOf(idEstado));
            tfNome.setText(nome);
            
            //jcbEstado.setSelectedIndex(idEstado - 1);
            //
            try{
                DaoEstado daoEstado = new DaoEstado();
                ResultSet resultSet = daoEstado.listarPorId(idEstado);
                resultSet.next();
                String pais = resultSet.getString("ESTADO");
                int index = 0;
                for(int i = 0; i < jcbEstado.getItemCount(); i++){
                    if(jcbEstado.getItemAt(i).equals(pais)){
                        index = i;
                        break;
                    }
                }
                jcbEstado.setSelectedIndex(index);
            }catch(Exception e){}
            //
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        DaoCidade daoCidade = new DaoCidade();
        
        if (daoCidade.inserir(Integer.parseInt(tfID.getText()), Integer.parseInt(tfIDEstado.getText()), tfNome.getText())){
            JOptionPane.showMessageDialog(null, "Cidade salva com sucesso!");
            
            tfID.setText(String.valueOf(daoCidade.buscarProximoId()));
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar a cidade!");
        }
    }
    
    private void alterar(){
        DaoCidade daoCidade = new DaoCidade();
        
        if (daoCidade.alterar(Integer.parseInt(tfID.getText()), tfIDEstado.getText(), tfNome.getText())){
            JOptionPane.showMessageDialog(null, "Cidade alterada com sucesso!");
            
            tfID.setText("");
            tfIDEstado.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a cidade!");
        }
        
        ((ListCidade) Formularios.listCidade).ListarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoCidade daoCidade = new DaoCidade();
        
        if (daoCidade.excluir(Integer.parseInt(tfID.getText()))){
            JOptionPane.showMessageDialog(null, "Cidade " + tfNome.getText() + " excluída com sucesso!");
            
            tfID.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a cidade!");
        }
        
        ((ListCidade) Formularios.listCidade).listarTodos();
        
        dispose();
    }
    
    public void carregarEstados(){
        try{
            DaoEstado daoEstado = new DaoEstado();

            ResultSet resultSet = daoEstado.listarTodos();

            while(resultSet.next()){
                jcbEstado.addItem(resultSet.getString("ESTADO"));
            }
        }catch(Exception e){
            
        }
    }
    
    private void recuperaIdEstado(){
        try{
            DaoEstado daoEstado = new DaoEstado();
            ResultSet resultSet = daoEstado.listarPorNome(jcbEstado.getSelectedItem().toString(), false);
            
            resultSet.next();
            tfIDEstado.setText(resultSet.getString("ID"));
        }catch(Exception e){
            System.out.println(e.getMessage());            
        }
    }
    
    private void recuperaUfEstado(){
        try{
            DaoEstado daoEstado = new DaoEstado();
            ResultSet resultSet = daoEstado.listarPorNome(jcbEstado.getSelectedItem().toString(), false);
            resultSet.next();
            tfUF.setText(resultSet.getString("UF"));
        }catch(Exception e){
            System.out.println(e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        tfIDEstado = new javax.swing.JTextField();
        jcbEstado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfUF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Cidade");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        tfIDEstado.setText("ID Estado");

        jcbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoItemStateChanged(evt);
            }
        });
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome da Cidade");

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

        tfUF.setText("   UF");
        tfUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAcao))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfIDEstado)
                                .addGap(197, 197, 197)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfUF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(221, 221, 221))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfIDEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
         if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT)
            inserir();
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEstadoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir a cidade " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadCidade = null;
    }//GEN-LAST:event_formWindowClosed

    private void tfUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUFActionPerformed

    private void jcbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadoItemStateChanged
        recuperaIdEstado();
        recuperaUfEstado();
    }//GEN-LAST:event_jcbEstadoItemStateChanged

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
            java.util.logging.Logger.getLogger(CadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfIDEstado;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfUF;
    // End of variables declaration//GEN-END:variables
}
