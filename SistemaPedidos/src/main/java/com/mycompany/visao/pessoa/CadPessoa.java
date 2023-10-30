/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.pessoa;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.dao.DaoEstadoCivil;
import com.mycompany.dao.DaoPessoa;
import com.mycompany.ferramenetas.Constantes;
import com.mycompany.ferramenetas.DadosTemporarios;
import com.mycompany.ferramenetas.Formularios;
import com.mycompany.modelo.ModCliente;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.modelo.ModPessoa;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jose.5989
 */
public class CadPessoa extends javax.swing.JFrame {

    /**
     * Creates new form CadPessoa
     */
    public CadPessoa() {
        initComponents();
        carregarEstadosCivis();
        carregarCidades();
        
        if(!existeDadosTemporarios()){
            DaoPessoa daoPessoa = new DaoPessoa();
            DaoEndereco daoEndereco = new DaoEndereco();
            DaoCliente daoCliente = new DaoCliente();
            
            int id = daoPessoa.buscarProximoId(); 
            int idEnd = daoEndereco.buscarProximoId();
            int idCli = daoCliente.buscarProximoId();
            if (id > 0){
                tfId.setText(String.valueOf(id));
                tfIdEndereco.setText(String.valueOf(idEnd));
                tfIdCliente.setText(String.valueOf(idCli));
            }
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdEstadoCivil();
        recuperaIdCidade();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        setExtendedState(MAXIMIZED_BOTH);
        
//        tfIdEndereco.setVisible(false);
//        tfIdEstadoCivil.setVisible(false);
//        tfIdCidade.setVisible(false);
//        tfIdCliente.setVisible(false);
    }
    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModPessoa){
            int id = ((ModPessoa) DadosTemporarios.tempObject).getId();
            int idEndereco = ((ModPessoa) DadosTemporarios.tempObject).getIdEndereco();
            int idEstadoCivil = ((ModPessoa) DadosTemporarios.tempObject).getIdEstadoCivil();
            String nome = ((ModPessoa) DadosTemporarios.tempObject).getNome();
            String sobrenome = ((ModPessoa) DadosTemporarios.tempObject).getSobrenome();
            String genero = ((ModPessoa) DadosTemporarios.tempObject).getGenero();
            String telefone = ((ModPessoa) DadosTemporarios.tempObject).getTelefone();
            String email = ((ModPessoa) DadosTemporarios.tempObject).getEmail();
            
            tfId.setText(String.valueOf(id));
            tfIdEndereco.setText(String.valueOf(idEndereco));
            tfIdEstadoCivil.setText(String.valueOf(idEstadoCivil));
            tfNome.setText(nome);
            tfSobrenome.setText(sobrenome);
            tfTelefone.setText(telefone);
            tfEmail.setText(email);
            
            //
            try{
                DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();
                ResultSet resultSet = daoEstadoCivil.listarPorId(idEstadoCivil);
                resultSet.next();
                String estadoCivil = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < jcbEstadoCivil.getItemCount(); i++){
                    if(jcbEstadoCivil.getItemAt(i).equals(estadoCivil)){
                        index = i;
                        break;
                    }
                }
                jcbEstadoCivil.setSelectedIndex(index);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            //
            
            //
            try{
                DaoEndereco daoEndereco = new DaoEndereco();
                ResultSet resultSet = daoEndereco.listarPorId(idEndereco);
                resultSet.next();
                String cidade = resultSet.getString("CIDADE");
                int index = 0;
                for(int i = 0; i < jcbCidade.getItemCount(); i++){
                    if(jcbCidade.getItemAt(i).equals(cidade)){
                        index = i;
                        break;
                    }
                }
                jcbCidade.setSelectedIndex(index);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            //
            
            //
            int index = 0;
            for(int i = 0; i < jcbGenero.getItemCount(); i++){
                if(jcbGenero.getItemAt(i).equals(genero)){
                    index = i;
                    break;
                }
            }
            jcbGenero.setSelectedIndex(index);
            //
            
            String rua = ((ModEndereco) DadosTemporarios.tempObject2).getNomeRua();
            String cep = ((ModEndereco) DadosTemporarios.tempObject2).getCep();
            String numRes = ((ModEndereco) DadosTemporarios.tempObject2).getNumeroResidencia();
            
            tfRua.setText(rua);
            tfCep.setText(cep);
            tfNumero.setText(numRes);
            
            int idCliente = ((ModCliente) DadosTemporarios.tempObject3).getId();
            tfIdCliente.setText(String.valueOf(idCliente));
            
            DadosTemporarios.tempObject = null;
            DadosTemporarios.tempObject2 = null;
            DadosTemporarios.tempObject3 = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        DaoPessoa daoPessoa = new DaoPessoa();
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoPessoa.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdEstadoCivil.getText()), tfNome.getText(), tfSobrenome.getText(), (String) jcbGenero.getSelectedItem(), tfTelefone.getText(), tfEmail.getText(), tfUsuario.getText(), String.valueOf(pfSenha.getPassword()))){
            JOptionPane.showMessageDialog(null, "Pessoa salva com sucesso!");
            
//            tfId.setText(String.valueOf(daoPessoa.buscarProximoId()));
//            tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));
            tfNome.setText("");
            tfSobrenome.setText("");
            tfTelefone.setText("");
            tfEmail.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar a pessoa!");
        }
    }
    
    private void inserirEndereco(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.inserir(Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumero.getText())){
//            JOptionPane.showMessageDialog(null, "Endereço salvo com sucesso!");
            
            tfRua.setText("");
            tfNumero.setText("");
            tfCep.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o endereço!");
        }
    }
    
    private void inserirCliente(){
        DaoCliente daoCliente = new DaoCliente();
        
        if (daoCliente.inserir(Integer.parseInt(tfIdCliente.getText()), Integer.parseInt(tfId.getText()))){
//            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o cliente!");
        }
    }
    
    private void alterar(){
        DaoPessoa daoPessoa = new DaoPessoa();
        
        if (daoPessoa.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdEstadoCivil.getText()), tfNome.getText(), tfSobrenome.getText(), (String) jcbGenero.getSelectedItem(), tfTelefone.getText(), tfEmail.getText())){
            JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
            
            //tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));          
            tfNome.setText("");
            tfSobrenome.setText("");
            tfTelefone.setText("");
            tfEmail.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a pessoa!");
        }
        
        //((ListPessoa) Formularios.listPessoa).listarTodos();
        
        dispose();
    }
    
    private void alterarEndereco(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.alterar(Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumero.getText())){
            //JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
            
            tfRua.setText("");
            tfCep.setText("");
            tfNumero.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a pessoa!");
        }
    }
    
    private void excluir(){
        DaoPessoa daoPessoa = new DaoPessoa();
        
        if (daoPessoa.excluir(Integer.parseInt(tfId.getText())))
            JOptionPane.showMessageDialog(null, "Pessoa excluída com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a pessoa!");
        
        ((ListPessoa) Formularios.listPessoa).listarTodos();
        
        dispose();
    }
    
    private void excluirEndereco(){
        
        DaoEndereco daoEndereco = new DaoEndereco();

        if (daoEndereco.excluir(Integer.parseInt(tfIdEndereco.getText()))){

        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o endereco!");
        }
    }
    
    private void excluirCliente(){
        
        DaoCliente daoCliente = new DaoCliente();

        if (daoCliente.excluir(Integer.parseInt(tfIdCliente.getText()))){

        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o endereco!");
        }
    }
    
    private void carregarEstadosCivis(){
        try{
            DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();

            ResultSet resultSet = daoEstadoCivil.listarTodos();

            while(resultSet.next())
                jcbEstadoCivil.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void carregarCidades(){
        try{
            DaoCidade daoCidade = new DaoCidade();

            ResultSet resultSet = daoCidade.listarTodos();

            while(resultSet.next())
                jcbCidade.addItem(resultSet.getString("CIDADE"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdEstadoCivil(){
        try{
            DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();
            ResultSet resultSet = daoEstadoCivil.listarPorNome(jcbEstadoCivil.getSelectedItem().toString());
            
            resultSet.next();
            tfIdEstadoCivil.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void recuperaIdCidade(){
        try{
            DaoCidade daoCidade = new DaoCidade();
            ResultSet resultSet = daoCidade.listarPorNome(jcbCidade.getSelectedItem().toString());
            
            resultSet.next();
            tfIdCidade.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private boolean camposObrigatoriosPreenchidos(JTextField campos[]){
        boolean b = true;
        
        for(int i = 0; i < campos.length; i++){
            if(campos[i].getText().equals("")){
                JOptionPane.showMessageDialog(null, "O campo " + campos[i].getToolTipText() + " é obrigatório!");
                campos[i].requestFocus();
                b = false;
                break;
            }
        }
        
        return b;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pfConfirmacaoSenha = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        tfIdEndereco = new javax.swing.JTextField();
        tfIdEstadoCivil = new javax.swing.JTextField();
        tfIdCidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbCidade = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        jcbEstadoCivil = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfSobrenome = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jcbGenero = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfIdCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        tfUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();
        tfEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Pessoa");

        jLabel16.setText("Confirmação de senha");

        tfIdEndereco.setText("idEndereco");

        tfIdEstadoCivil.setText("idEstadoCivil");

        tfIdCidade.setText("idCidade");

        jLabel2.setText("Cidade");

        jcbCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCidadeItemStateChanged(evt);
            }
        });

        jLabel9.setText("Rua *");

        jLabel1.setText("ID");

        tfRua.setToolTipText("Rua");

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        jLabel10.setText("CEP *");

        jLabel3.setText("Estado civil");

        tfCep.setToolTipText("CEP");

        jcbEstadoCivil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoCivilItemStateChanged(evt);
            }
        });

        jLabel11.setText("Número *");

        jLabel4.setText("Nome *");

        tfNome.setToolTipText("Nome");

        tfNumero.setToolTipText("Número");

        jLabel5.setText("Sobrenome *");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Endereço");

        tfSobrenome.setToolTipText("Sobrenome");

        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMININO", "OUTROS" }));
        jcbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGeneroActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Pessoa");

        jLabel6.setText("Gênero");

        tfIdCliente.setText("idCliente");

        jLabel7.setText("Telefone *");

        jLabel14.setText("Usuário");

        tfTelefone.setToolTipText("Telefone");

        jLabel8.setText("E-mail *");

        tfEmail.setToolTipText("E-mail");

        jLabel15.setText("Senha");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfNumero)))
                    .addComponent(jSeparator1)
                    .addComponent(tfRua)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbGenero, javax.swing.GroupLayout.Alignment.LEADING, 0, 189, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSobrenome, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(tfEmail)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfIdEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(pfConfirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnAcao)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pfConfirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAcao))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCidadeItemStateChanged
        recuperaIdCidade();
    }//GEN-LAST:event_jcbCidadeItemStateChanged

    private void jcbEstadoCivilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadoCivilItemStateChanged
        recuperaIdEstadoCivil();
    }//GEN-LAST:event_jcbEstadoCivilItemStateChanged

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        String senha = String.valueOf(pfSenha.getPassword());
        String confirmacaoSenha = String.valueOf(pfConfirmacaoSenha.getPassword());

        if(senha.equals(confirmacaoSenha)){
            DaoPessoa daoPessoa = new DaoPessoa();
            DaoCliente daoCliente = new DaoCliente();
            DaoEndereco daoEndereco = new DaoEndereco();

            if(camposObrigatoriosPreenchidos(new JTextField[]{tfRua, tfCep, tfNumero, tfNome, tfSobrenome, tfTelefone, tfEmail})){
                if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
                    inserirEndereco();
                    inserir();
                    inserirCliente();

                    tfId.setText(String.valueOf(daoPessoa.buscarProximoId()));
                    tfIdCliente.setText(String.valueOf(daoCliente.buscarProximoId()));
                    tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));
                }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT){
                    alterarEndereco();
                    alterar();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, Constantes.CONFIRMACAO_SENHA_DIFERENTES);
        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha =
        JOptionPane.showConfirmDialog(
            null,
            "Deseja realmente excluir a pessoa?");

        if(escolha == JOptionPane.YES_OPTION){
            excluirCliente();
            excluir();
            excluirEndereco();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void jcbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGeneroActionPerformed

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
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox<String> jcbEstadoCivil;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JPasswordField pfConfirmacaoSenha;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdCidade;
    private javax.swing.JTextField tfIdCliente;
    private javax.swing.JTextField tfIdEndereco;
    private javax.swing.JTextField tfIdEstadoCivil;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfSobrenome;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
