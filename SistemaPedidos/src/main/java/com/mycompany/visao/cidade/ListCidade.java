/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.cidade;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEstado;
import com.mycompany.ferramenetas.DadosTemporarios;
import com.mycompany.ferramenetas.Formularios;
import com.mycompany.modelo.ModCidade;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jose.5989
 */
public class ListCidade extends javax.swing.JFrame {

    /**
     * Creates new form ListCidade
     */
    public ListCidade() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    
    public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCidade.getModel();
            
            tableCidade.setModel(defaultTableModel);

            DaoCidade daoCidade = new DaoCidade();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoCidade.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String estado = resultSet.getString(2);
                String cidade = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                        
                     
                
                defaultTableModel.addRow(new Object[]{id, estado, uf, cidade});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(int pId){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCidade.getModel();

            tableCidade.setModel(defaultTableModel);

            DaoCidade daoCidade = new DaoCidade();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoCidade.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String estado = resultSet.getString(2);
                String cidade = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, estado, uf, cidade});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNome(String pNome){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCidade.getModel();
            
            tableCidade.setModel(defaultTableModel);

            DaoCidade DaoCidade = new DaoCidade();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = DaoCidade.listarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String estado = resultSet.getString(2);
                String cidade = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, estado, uf, cidade});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorEstado(String pEstado){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCidade.getModel();
            
            tableCidade.setModel(defaultTableModel);

            DaoCidade DaoCidade = new DaoCidade();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = DaoCidade.listarPorEstado(pEstado);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String estado = resultSet.getString(2);
                String cidade = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, estado, uf, cidade});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorUf(String pUf){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCidade.getModel();
            
            tableCidade.setModel(defaultTableModel);

            DaoCidade DaoCidade = new DaoCidade();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = DaoCidade.listarPorUf(pUf);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String estado = resultSet.getString(2);
                String cidade = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, estado, uf, cidade});
            }
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

        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCidade = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Cidade");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "ESTADO", "UF", "CIDADE\t" }));
        jcbTipoFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoFiltroActionPerformed(evt);
            }
        });

        tableCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ESTADO", "UF", "CIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCidade);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Dê dois cliques no registro para editá-lo.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBuscar)
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfFiltro))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId(Integer.parseInt(tfFiltro.getText()));
                break;
            case 2:
                listarPorEstado(tfFiltro.getText());
                break;
            case 3:
                listarPorUf(tfFiltro.getText());
                break;
            case 4:
                listarPorNome(tfFiltro.getText());
                break;
        }        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tableCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCidadeMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModCidade modCidade = new ModCidade();

                modCidade.setId(Integer.parseInt(String.valueOf(tableCidade.getValueAt(tableCidade.getSelectedRow(), 0))));
                modCidade.setNome(String.valueOf(tableCidade.getValueAt(tableCidade.getSelectedRow(), 2)));

                DaoEstado daoEstado = new DaoEstado();
                ResultSet resultSet = daoEstado.listarPorNome(String.valueOf(tableCidade.getValueAt(tableCidade.getSelectedRow(), 1)), false);

                int idEstado = -1;
                while(resultSet.next())
                    idEstado = resultSet.getInt("ID");

                modCidade.setIdEstado(idEstado);
                
                DadosTemporarios.tempObject = (ModCidade) modCidade;

                CadCidade cadCidade = new CadCidade();
                cadCidade.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tableCidadeMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.listCidade = null;
    }//GEN-LAST:event_formWindowClosed

    private void jcbTipoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoFiltroActionPerformed

    void ListarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
            java.util.logging.Logger.getLogger(ListCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListCidade().setVisible(true);
            }
        });
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableCidade;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
