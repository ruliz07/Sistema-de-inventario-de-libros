package bibliotecajava;

import bibliotecajava.Consultar;
import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Borrar extends javax.swing.JFrame {

    private JFrame ventanaPadre;
    private File archivo; //archivo con el que vamos a trabajar

    /**
     * Creates new form Borrar
     */
    public Borrar(JFrame jF, File arch) {
        this.ventanaPadre = jF;
        this.archivo = arch;
        this.ventanaPadre.setVisible(false);
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto IPOO");
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabelTitulo.setText("Borrar Prestamo");

        jLabelNombre.setText("Nombre:");

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLimpiar.setText("Limpiar dato");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonAtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonBorrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBorrar)
                        .addGap(20, 20, 20))))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabelTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtras)
                    .addComponent(jButtonBorrar))
                .addGap(20, 20, 20))
        );

        setSize(new java.awt.Dimension(428, 317));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        this.setVisible(false);
        ventanaPadre.setVisible(true);
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed

        jTextFieldNombre.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed

        String espacios = " "; //separa el nombre, el usuario y la contraseña dentro del archivo
        String[] pedazos; // separamos la linea del archivo en varias unidades
        String nombre; // nombre del usuario XD
        String nombrePedazo; // nombre dentro del string pedazos
        Boolean encontrado = false;
        LinkedList<String> paraGuardar = new LinkedList(); /*almacenamos lo requerido, borramos lo otro
        para volverlas a guardar*/

        if (jTextFieldNombre.getText().equals("")) { //mensajito de error... S:
            JOptionPane.showMessageDialog(this, "Te falta agregar el nombre", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(archivo));  //abrimos el archivo para leerlo
                String linea = reader.readLine(); //leemos la primera linea

                if (linea == null) {
                    JOptionPane.showMessageDialog(this, "El archivo no tiene ese nombre", "Archivo vacío", JOptionPane.INFORMATION_MESSAGE);
                    reader.close();//cerramos el archivo para leer
                } else {
                    do {

                        pedazos = linea.split(espacios, 3); //dividimos la linea leida en tres partes

                        nombre = jTextFieldNombre.getText().toUpperCase();
                        nombrePedazo = pedazos[0].toUpperCase();

                        if (!nombrePedazo.equals(nombre)) {
                            //checamos si la linea esta vacia, si lo esta, no la guardamos
                            if (!nombrePedazo.equals("")) {
                                paraGuardar.add(linea);
                            }
                        } else {
                            encontrado = true;
                        }

                        linea = reader.readLine(); // ahora leemos la siguiente línea

                    } while (linea != null);

                    reader.close();//cerrar

                    if (!encontrado) {
                        JOptionPane.showMessageDialog(this, "No hay ningun nombre que coincida", "Error..", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
                        while (!paraGuardar.isEmpty()) {
                            writer.write(paraGuardar.poll().toString());
                            writer.newLine();
                        }
                        writer.flush();
                        writer.close();
                        JOptionPane.showMessageDialog(this, "Archivo eliminado!!", "Eliminado S:", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonBorrarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
