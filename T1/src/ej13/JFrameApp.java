package ej13;

import java.awt.*;
import java.io.*;

public class JFrameApp extends javax.swing.JFrame {
    private static final File CARPETA = new File("T1/src/ej13");

    private File archivo = null;
    private javax.swing.JButton jButtonInsertarFinal;
    private javax.swing.JButton jButtonMostrarContenido;
    private javax.swing.JButton jButtonSobreescribir;
    private javax.swing.JTextArea jTextAreaContenido;
    private javax.swing.JTextArea jTextAreaTexto;
    private javax.swing.JTextField jTextFieldFichero;

    public JFrameApp() {
        this.initComponents();
    }

    private void escribirEnFichero(boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.archivo, append))) {
            writer.write(this.jTextAreaTexto.getText());
        } catch (IOException exception) {
            System.err.println("Error de lectura.");
        }
    }

    private void jTextFieldFicheroKeyEvent(java.awt.event.KeyEvent ignoredEvent) {
        String textoTextField = this.jTextFieldFichero.getText();
        boolean botonesActivos = !textoTextField.isEmpty();

        archivo = new File(JFrameApp.CARPETA, textoTextField);
        this.jButtonMostrarContenido.setEnabled(botonesActivos);
        this.jButtonSobreescribir.setEnabled(botonesActivos);
        this.jButtonInsertarFinal.setEnabled(botonesActivos);
    }

    private void jButtonMostrarContenidoActionPerformed(java.awt.event.ActionEvent ignoredEvent) {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.archivo))) {
            this.jTextAreaContenido.setText("");
            reader.lines().forEach(linea -> this.jTextAreaContenido.append(linea + "\n"));
        } catch (FileNotFoundException exception) {
            this.jTextAreaContenido.setText("*El fichero no existe*");
        } catch (IOException exception) {
            System.err.println("Error de lectura.");
        }
    }

    private void jButtonSobreescribirActionPerformed(java.awt.event.ActionEvent ignoredEvent) {
        this.escribirEnFichero(false);
    }

    private void jButtonInsertarFinalActionPerformed(java.awt.event.ActionEvent ignoredEvent) {
        this.escribirEnFichero(true);
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException exception) {
            System.err.println(exception.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> new JFrameApp().setVisible(true));
    }

    private void initComponents() {
        javax.swing.JLabel jLabelTexto = new javax.swing.JLabel();
        javax.swing.JLabel jLabelFichero = new javax.swing.JLabel();
        javax.swing.JLabel jLabelContenido = new javax.swing.JLabel();
        this.jTextFieldFichero = new javax.swing.JTextField();
        javax.swing.JScrollPane jScrollPaneContenido = new javax.swing.JScrollPane();
        this.jTextAreaContenido = new javax.swing.JTextArea();
        javax.swing.JScrollPane jScrollPaneTexto = new javax.swing.JScrollPane();
        this.jTextAreaTexto = new javax.swing.JTextArea();
        this.jButtonMostrarContenido = new javax.swing.JButton();
        this.jButtonSobreescribir = new javax.swing.JButton();
        this.jButtonInsertarFinal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTexto.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12));
        jLabelTexto.setText("Texto a escribir:");

        jLabelFichero.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12));
        jLabelFichero.setText("Nombre del fichero:");

        jLabelContenido.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12));
        jLabelContenido.setText("Contenido:");

        jTextFieldFichero.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFicheroKeyEvent(evt);
            }
        });

        this.jTextAreaContenido.setColumns(20);
        this.jTextAreaContenido.setRows(5);
        this.jTextAreaContenido.setEditable(false);
        jScrollPaneContenido.setViewportView(this.jTextAreaContenido);

        this.jTextAreaTexto.setColumns(20);
        this.jTextAreaTexto.setRows(5);
        jScrollPaneTexto.setViewportView(this.jTextAreaTexto);

        this.jButtonMostrarContenido.setText("Mostrar contenido");
        this.jButtonMostrarContenido.setEnabled(false);
        this.jButtonMostrarContenido.addActionListener(this::jButtonMostrarContenidoActionPerformed);

        this.jButtonSobreescribir.setText("Sobreescribir");
        this.jButtonSobreescribir.setEnabled(false);
        this.jButtonSobreescribir.addActionListener(this::jButtonSobreescribirActionPerformed);

        this.jButtonInsertarFinal.setText("Añadir al final");
        this.jButtonInsertarFinal.setEnabled(false);
        this.jButtonInsertarFinal.addActionListener(this::jButtonInsertarFinalActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelFichero)
                                                .addGap(16, 16, 16)
                                                .addComponent(this.jTextFieldFichero))
                                        .addComponent(jScrollPaneContenido)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(this.jButtonSobreescribir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(this.jButtonInsertarFinal)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(this.jButtonMostrarContenido))
                                        .addComponent(jScrollPaneTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelTexto)
                                                        .addComponent(jLabelContenido))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(this.jTextFieldFichero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelFichero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jLabelTexto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabelContenido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(this.jButtonMostrarContenido)
                                        .addComponent(this.jButtonSobreescribir)
                                        .addComponent(this.jButtonInsertarFinal))
                                .addGap(29, 29, 29))
        );

        pack();
    }
}
