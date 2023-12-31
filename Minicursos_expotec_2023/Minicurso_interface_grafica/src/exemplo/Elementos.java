/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Augusto
 */
public class Elementos extends javax.swing.JFrame {

    /**
     * Creates new form Elementos
     */
    public Elementos() {
        initComponents();
        
        //setResizable(false);
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radio_masculino);
        grupo.add(radio_feminino);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_principal = new javax.swing.JPanel();
        painel_cabecalho = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painel_form = new javax.swing.JPanel();
        botao_enviar = new javax.swing.JButton();
        campo_nome = new javax.swing.JTextField();
        label_nome = new javax.swing.JLabel();
        label_cpf = new javax.swing.JLabel();
        campo_cpf = new javax.swing.JFormattedTextField();
        painel_sexo = new javax.swing.JPanel();
        radio_masculino = new javax.swing.JRadioButton();
        radio_feminino = new javax.swing.JRadioButton();
        combo_curso = new javax.swing.JComboBox<>();
        label_curso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JFrame - exemplo");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        painel_cabecalho.setBackground(new java.awt.Color(153, 0, 153));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulário");

        javax.swing.GroupLayout painel_cabecalhoLayout = new javax.swing.GroupLayout(painel_cabecalho);
        painel_cabecalho.setLayout(painel_cabecalhoLayout);
        painel_cabecalhoLayout.setHorizontalGroup(
            painel_cabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_cabecalhoLayout.setVerticalGroup(
            painel_cabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_cabecalhoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painel_form.setBackground(new java.awt.Color(255, 255, 255));

        botao_enviar.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        botao_enviar.setText("Enviar");
        botao_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_enviarActionPerformed(evt);
            }
        });

        campo_nome.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        label_nome.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        label_nome.setText("Nome:");

        label_cpf.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        label_cpf.setText("CPF:");

        try {
            campo_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campo_cpf.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        painel_sexo.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        radio_masculino.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        radio_masculino.setSelected(true);
        radio_masculino.setText("Masculino");
        radio_masculino.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        radio_feminino.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        radio_feminino.setText("Feminino");

        javax.swing.GroupLayout painel_sexoLayout = new javax.swing.GroupLayout(painel_sexo);
        painel_sexo.setLayout(painel_sexoLayout);
        painel_sexoLayout.setHorizontalGroup(
            painel_sexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_sexoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radio_masculino)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(radio_feminino)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_sexoLayout.setVerticalGroup(
            painel_sexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_sexoLayout.createSequentialGroup()
                .addGroup(painel_sexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_masculino)
                    .addComponent(radio_feminino))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        combo_curso.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        combo_curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informática", "Química" }));

        label_curso.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        label_curso.setText("Curso:");

        javax.swing.GroupLayout painel_formLayout = new javax.swing.GroupLayout(painel_form);
        painel_form.setLayout(painel_formLayout);
        painel_formLayout.setHorizontalGroup(
            painel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_formLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(painel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_formLayout.createSequentialGroup()
                        .addGroup(painel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_cpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_curso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painel_formLayout.createSequentialGroup()
                                .addGap(0, 43, Short.MAX_VALUE)
                                .addComponent(botao_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113))
                            .addComponent(campo_nome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_cpf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_curso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_formLayout.setVerticalGroup(
            painel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_formLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(painel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nome))
                .addGap(18, 18, 18)
                .addGroup(painel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_cpf)
                    .addComponent(campo_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_curso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(painel_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(botao_enviar)
                .addContainerGap())
        );

        javax.swing.GroupLayout painel_principalLayout = new javax.swing.GroupLayout(painel_principal);
        painel_principal.setLayout(painel_principalLayout);
        painel_principalLayout.setHorizontalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_cabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(painel_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        painel_principalLayout.setVerticalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addComponent(painel_cabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painel_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_enviarActionPerformed
        String nome = campo_nome.getText();
        String cpf = campo_cpf.getText();
        String curso = combo_curso.getSelectedItem().toString();
        String sexo;
        if (radio_masculino.isSelected()) {
            sexo = "masculino";
        } else {
            sexo = "feminino";
        }
        
        String mensagem = String.format("Nome: %s%nCPF: %s%nCurso: %s%nSexo: %s%n", nome,cpf,curso,sexo);
        
        JOptionPane.showMessageDialog(this, mensagem);
    }//GEN-LAST:event_botao_enviarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Elementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Elementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Elementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Elementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Elementos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_enviar;
    private javax.swing.JFormattedTextField campo_cpf;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JComboBox<String> combo_curso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_cpf;
    private javax.swing.JLabel label_curso;
    private javax.swing.JLabel label_nome;
    private javax.swing.JPanel painel_cabecalho;
    private javax.swing.JPanel painel_form;
    private javax.swing.JPanel painel_principal;
    private javax.swing.JPanel painel_sexo;
    private javax.swing.JRadioButton radio_feminino;
    private javax.swing.JRadioButton radio_masculino;
    // End of variables declaration//GEN-END:variables
}
