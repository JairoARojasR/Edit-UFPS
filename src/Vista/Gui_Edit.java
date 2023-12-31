package Vista;

import util.Pdf;
import Control.EditUFPS;
import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.ArchivoLeerURL;

/**
 *
 * @author Jairo Alexis Ramirez Rojas 1152142, Cristian Julian Lamus 1152139
 */
public class Gui_Edit extends javax.swing.JFrame {

    /**
     * Creates new form Gui_Edit
     */
    private EditUFPS editufps;
    private ImageIcon imagen;
    private Icon icono;
    private int layoutX, layoutY;
    private Pdf pdf;
    private final Color btnPressed = new Color(215, 245, 254);
    private final Color btnFocused = new Color(254, 215, 215);

    public Gui_Edit() {
        initComponents();
        inicializar_Gui();
    }

    public Gui_Edit(String url) {
        //https://gitlab.com/madarme/archivos-persistencia/-/raw/master/archivos%20texto%20plano/texto.txt
        initComponents();
        inicializar_Gui();
        this.mostrarContenidoURL(url);
    }

    private void inicializar_Gui() {
        pdf = new Pdf();
        editufps = new EditUFPS();
        this.setLocationRelativeTo(this);
        this.mostrarImagen(lblCerrar, "src/images/cerrar.png");
        this.mostrarImagen(this.lblUfps, "src/images/ufps.png");
        this.mostrarImagen(lblMaximizar, "src/images/maximizar.png");
        this.mostrarImagen(lblMinimizar, "src/images/minimizar.png");
        this.mostrarImagen(this.lblIngenieria, "src/images/ing_sistemas.jpg");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
    }

    private void mostrarContenidoURL(String url) {
        ArchivoLeerURL archivo = new ArchivoLeerURL(url);
        Object datos[] = archivo.leerArchivo();
        String texto = "";
        for (Object x : datos) {
            texto = x.toString() + "\n";
        }
        this.txtDocumento.setText(texto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDocumento = new javax.swing.JTextArea();
        cmdGuardarEnLista = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmdBuscar = new javax.swing.JButton();
        cmdReemplazar = new javax.swing.JButton();
        cmdEliminar = new javax.swing.JButton();
        cmdGuardarPDF = new javax.swing.JButton();
        cmdGuardarPDFSubrayado = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMaximizar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblUfps = new javax.swing.JLabel();
        lblIngenieria = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblDesarrolladores = new javax.swing.JLabel();
        lblDesarrolladores1 = new javax.swing.JLabel();
        lblDesarrolladores3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        txtDocumento.setColumns(20);
        txtDocumento.setRows(5);
        txtDocumento.setAutoscrolls(false);
        txtDocumento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(txtDocumento);

        cmdGuardarEnLista.setBackground(new java.awt.Color(204, 204, 204));
        cmdGuardarEnLista.setText("Guardar en ListaCD");
        cmdGuardarEnLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdGuardarEnListaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdGuardarEnListaMouseExited(evt);
            }
        });
        cmdGuardarEnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarEnListaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 48)); // NOI18N
        jLabel1.setText("EDIT_UFPS");

        cmdBuscar.setBackground(new java.awt.Color(255, 255, 255));
        cmdBuscar.setText("Buscar Palabra");
        cmdBuscar.setEnabled(false);
        cmdBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmdBuscarFocusLost(evt);
            }
        });
        cmdBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarActionPerformed(evt);
            }
        });

        cmdReemplazar.setBackground(new java.awt.Color(255, 255, 255));
        cmdReemplazar.setText("Reemplazar");
        cmdReemplazar.setEnabled(false);
        cmdReemplazar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdReemplazarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmdReemplazarFocusLost(evt);
            }
        });
        cmdReemplazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdReemplazarActionPerformed(evt);
            }
        });

        cmdEliminar.setBackground(new java.awt.Color(255, 255, 255));
        cmdEliminar.setText("Eliminar");
        cmdEliminar.setEnabled(false);
        cmdEliminar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdEliminarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmdEliminarFocusLost(evt);
            }
        });
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
            }
        });

        cmdGuardarPDF.setBackground(new java.awt.Color(255, 255, 255));
        cmdGuardarPDF.setText("Guardar como PDF");
        cmdGuardarPDF.setEnabled(false);
        cmdGuardarPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdGuardarPDFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdGuardarPDFMouseExited(evt);
            }
        });
        cmdGuardarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarPDFActionPerformed(evt);
            }
        });

        cmdGuardarPDFSubrayado.setBackground(new java.awt.Color(255, 255, 255));
        cmdGuardarPDFSubrayado.setText("Guardar como PDF subrayado");
        cmdGuardarPDFSubrayado.setEnabled(false);
        cmdGuardarPDFSubrayado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdGuardarPDFSubrayadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdGuardarPDFSubrayadoMouseExited(evt);
            }
        });
        cmdGuardarPDFSubrayado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarPDFSubrayadoActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel2.setText("Edit_UFPS - Programa de Ingenería de Sistemas 2022");

        lblMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMaximizarMouseClicked(evt);
            }
        });

        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });

        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblUfps.setBackground(new java.awt.Color(204, 204, 204));
        lblUfps.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblIngenieria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lblDesarrolladores.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        lblDesarrolladores.setText("Desarrolladores: Cristian Julian Lamus ");

        lblDesarrolladores1.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        lblDesarrolladores1.setText("Cód: 1152139  &&  Jairo Alexis Rojas Rarimez");

        lblDesarrolladores3.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        lblDesarrolladores3.setText("Cód: 1152142");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmdBuscar)
                                .addGap(56, 56, 56)
                                .addComponent(cmdReemplazar))
                            .addComponent(lblUfps, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmdEliminar)
                                .addGap(49, 49, 49)
                                .addComponent(cmdGuardarPDF))
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38)
                        .addComponent(cmdGuardarPDFSubrayado)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdGuardarEnLista))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIngenieria, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDesarrolladores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDesarrolladores1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDesarrolladores3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUfps, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdGuardarPDFSubrayado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdBuscar)
                        .addComponent(cmdReemplazar)
                        .addComponent(cmdEliminar)
                        .addComponent(cmdGuardarPDF)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIngenieria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDesarrolladores)
                            .addComponent(lblDesarrolladores1)
                            .addComponent(lblDesarrolladores3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdGuardarEnLista)
                        .addGap(16, 16, 16)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizarMouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1)
            this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_lblMaximizarMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1)
            this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1)
            System.exit(0);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void cmdBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarActionPerformed
        if (!editufps.documentoVacio()) {
        String palabra = JOptionPane.showInputDialog(null, "Palabra a buscar", "Edit_UFPS", JOptionPane.QUESTION_MESSAGE);
            if ((palabra != null) && (palabra.length() > 0)) {
                
                int buscados = editufps.buscar(palabra);
                JOptionPane.showMessageDialog(null, "Se encontraron " + buscados + " palabras: " + palabra, "Edit_UFPS", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "DOCUMENTO VACIO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdBuscarActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setLocation(evt.getXOnScreen() - layoutX, evt.getYOnScreen() - layoutY);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            layoutX = evt.getX();
            layoutY = evt.getY();
        }
    }//GEN-LAST:event_jPanel2MousePressed

    private void cmdReemplazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReemplazarActionPerformed
        if (!editufps.documentoVacio()) {
            JTextField palabraBuscar = new JTextField(8);
            JTextField palabraReemplazar = new JTextField(8);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Buscar:"));
            myPanel.add(palabraBuscar);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Reemplazar:"));
            myPanel.add(palabraReemplazar);

            int result = JOptionPane.showConfirmDialog(null, myPanel, "Por favor ingrese los siguientes datos:", JOptionPane.OK_CANCEL_OPTION);
            if ((palabraReemplazar.getText().isEmpty()||palabraBuscar.getText().isEmpty()))
                return;
            if (result == JOptionPane.OK_OPTION) {
                int reemplazos = editufps.reemplazar(palabraBuscar.getText(), palabraReemplazar.getText());
                this.txtDocumento.setText(editufps.getCadena());
                //editufps = new EditUFPS(txtDocumento.getText());
                
                JOptionPane.showMessageDialog(null, "Se realizaron " + reemplazos + " reemplazos", "Edit_UFPS", JOptionPane.INFORMATION_MESSAGE);
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(null, "DOCUMENTO VACÍO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdReemplazarActionPerformed

    private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed
        if (!editufps.documentoVacio()) {
            String palabra = JOptionPane.showInputDialog(null, "Palabra a eliminar", "Edit_UFPS", JOptionPane.QUESTION_MESSAGE);
            if ((palabra != null) && (palabra.length() > 0)) {
                int borrados = editufps.eliminar(palabra);
                this.txtDocumento.setText(editufps.getCadena());
                //editufps = new EditUFPS(txtDocumento.getText());
                JOptionPane.showMessageDialog(null, "Se eliminaron " + borrados + " palabras " + palabra, "Edit_UFPS", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "DOCUMENTO VACIO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdEliminarActionPerformed

    private void cmdGuardarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarPDFActionPerformed
        if (!editufps.documentoVacio()) {
            String nombre = JOptionPane.showInputDialog(null, "Nombre del archivo pdf", "Edit_UFPS", JOptionPane.QUESTION_MESSAGE);
            if ((nombre != null) && (nombre.length() > 0)) {
                try {
                    pdf.generarPdf(txtDocumento.getText(), nombre);
                } catch (DocumentException | FileNotFoundException ex) {
                    Logger.getLogger(Gui_Edit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else
            JOptionPane.showMessageDialog(null, "DOCUMENTO VACÍO", "ERROR", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_cmdGuardarPDFActionPerformed

    private void cmdGuardarPDFSubrayadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarPDFSubrayadoActionPerformed
        if (!editufps.documentoVacio()) {

            JTextField nombreField = new JTextField(8);
            JTextField palabraSubrayarField = new JTextField(8);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Nombre del archivo:"));
            myPanel.add(nombreField);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Palabra a subrayar:"));
            myPanel.add(palabraSubrayarField);

            
            int result = JOptionPane.showConfirmDialog(null, myPanel, "Por favor ingrese los siguientes datos:", JOptionPane.OK_CANCEL_OPTION);
            if ((nombreField.getText().isEmpty()||palabraSubrayarField.getText().isEmpty()))
                return;
            if (result == JOptionPane.OK_OPTION) {
            }
            try {
                pdf.generarPdfResaltado(txtDocumento.getText(), nombreField.getText(), palabraSubrayarField.getText());
            } catch (DocumentException | FileNotFoundException ex) {
                Logger.getLogger(Gui_Edit.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
            JOptionPane.showMessageDialog(null, "DOCUMENTO VACÍO", "ERROR", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_cmdGuardarPDFSubrayadoActionPerformed

    private void cmdGuardarEnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarEnListaActionPerformed
        editufps = new EditUFPS(txtDocumento.getText());
        cmdBuscar.setEnabled(!editufps.documentoVacio());
        cmdEliminar.setEnabled(!editufps.documentoVacio());
        cmdReemplazar.setEnabled(!editufps.documentoVacio());
        cmdGuardarPDF.setEnabled(!editufps.documentoVacio());
        cmdGuardarPDFSubrayado.setEnabled(!editufps.documentoVacio());
        JOptionPane.showMessageDialog(null, "Documento guardado en ListaCD", "Informacíon", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_cmdGuardarEnListaActionPerformed

    private void cmdBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdBuscarFocusGained
        cmdBuscar.setBackground(btnPressed);
    }//GEN-LAST:event_cmdBuscarFocusGained

    private void cmdBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdBuscarFocusLost
        cmdBuscar.setBackground(Color.white);
    }//GEN-LAST:event_cmdBuscarFocusLost

    private void cmdReemplazarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdReemplazarFocusGained
        cmdReemplazar.setBackground(btnPressed);
    }//GEN-LAST:event_cmdReemplazarFocusGained

    private void cmdReemplazarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdReemplazarFocusLost
        cmdReemplazar.setBackground(Color.white);
    }//GEN-LAST:event_cmdReemplazarFocusLost

    private void cmdEliminarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdEliminarFocusGained
        cmdEliminar.setBackground(btnPressed);
    }//GEN-LAST:event_cmdEliminarFocusGained

    private void cmdEliminarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdEliminarFocusLost
        cmdEliminar.setBackground(Color.white);
    }//GEN-LAST:event_cmdEliminarFocusLost

    private void cmdGuardarPDFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdGuardarPDFMouseEntered
        cmdGuardarPDF.setBackground(btnFocused);
    }//GEN-LAST:event_cmdGuardarPDFMouseEntered

    private void cmdGuardarPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdGuardarPDFMouseExited
        cmdGuardarPDF.setBackground(Color.white);
    }//GEN-LAST:event_cmdGuardarPDFMouseExited

    private void cmdGuardarPDFSubrayadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdGuardarPDFSubrayadoMouseExited
        cmdGuardarPDFSubrayado.setBackground(Color.white);
    }//GEN-LAST:event_cmdGuardarPDFSubrayadoMouseExited

    private void cmdGuardarPDFSubrayadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdGuardarPDFSubrayadoMouseEntered
        cmdGuardarPDFSubrayado.setBackground(btnFocused);
    }//GEN-LAST:event_cmdGuardarPDFSubrayadoMouseEntered

    private void cmdGuardarEnListaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdGuardarEnListaMouseExited
        cmdGuardarEnLista.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_cmdGuardarEnListaMouseExited

    private void cmdGuardarEnListaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdGuardarEnListaMouseEntered
        cmdGuardarEnLista.setBackground(Color.white);
    }//GEN-LAST:event_cmdGuardarEnListaMouseEntered

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
            java.util.logging.Logger.getLogger(Gui_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui_Edit().setVisible(true);
            }
        });
    }

    private void mostrarImagen(JLabel lbl, String ruta) {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
        lbl.setIcon(icono);
        lbl.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBuscar;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JButton cmdGuardarEnLista;
    private javax.swing.JButton cmdGuardarPDF;
    private javax.swing.JButton cmdGuardarPDFSubrayado;
    private javax.swing.JButton cmdReemplazar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblDesarrolladores;
    private javax.swing.JLabel lblDesarrolladores1;
    private javax.swing.JLabel lblDesarrolladores3;
    private javax.swing.JLabel lblIngenieria;
    private javax.swing.JLabel lblMaximizar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblUfps;
    private javax.swing.JTextArea txtDocumento;
    // End of variables declaration//GEN-END:variables
}
