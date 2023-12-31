package chatcliente;




import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pc
 */
public class FrameCliente extends javax.swing.JFrame {
    JFileChooser dlg;

    /**
     * Creates new form FrameCliente
     */
    
    Cliente cliente;
    public FrameCliente() {
        initComponents();
        //Instanciamos la variable cliente pasandole el panel y activamos el hilo
        cliente= new Cliente(peMsg);
        Thread hilo = new Thread(cliente);
        hilo.start();
        
        //Hacemos que el scroll baje automaticamente con los mensajes
        jScrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
            public void adjustmentValueChanged(AdjustmentEvent e) {  
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
            }
        });
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        peMsg = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        txNom = new javax.swing.JTextField();
        txMsg = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        peMsg.setContentType("text/html"); // NOI18N
        peMsg.setText(" <html>   <head>    </head>   <body>     <p style=\"margin-top: 0\">            </p>   </body> </html> ");
        jScrollPane1.setViewportView(peMsg);
        peMsg.getAccessibleContext().setAccessibleDescription("text/plain");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 83, 463, 313));

        jLabel2.setBackground(new java.awt.Color(255, 204, 255));
        jLabel2.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 204));
        jLabel2.setText(" Remitente");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 19, 250, 45));

        txNom.setBackground(new java.awt.Color(255, 247, 255));
        getContentPane().add(txNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, 45));

        txMsg.setBackground(new java.awt.Color(252, 244, 252));
        txMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txMsgActionPerformed(evt);
            }
        });
        getContentPane().add(txMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 415, 241, 42));

        jButton1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 255));
        jButton1.setText("ENVIAR MENSAJE");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 414, 227, 42));

        jButton4.setFont(new java.awt.Font("Wide Latin", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 255));
        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 230, 40));

        jLabel1.setBackground(new java.awt.Color(224, 239, 255));
        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 36)); // NOI18N
        jLabel1.setText("GUARDAR MENSAJE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 330, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/p.imagen1.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 0, 900, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Sacamos el nombre y el mensaje de las cajas de texto
        String nombre = txNom.getText();
        
        if(nombre.trim().length() == 0)nombre = "SinNombre";
        String msg = txMsg.getText();
        
       LocalTime horaActual = LocalTime.now();
        
        DateTimeFormatter formatoHora =  DateTimeFormatter.ofPattern("HH:mm:ss:ms✓");
        String horaFormateada = horaActual.format(formatoHora);
        
//        if(nombre.trim().length() == 0)return;
        //Limpiamos el cuadro de texto del mensaje
        
        txMsg.setText("");
        
        
        
        LocalTime horaActuaR = LocalTime.now();
        
       DateTimeFormatter formatoHoraR =  DateTimeFormatter.ofPattern("HH:mm:ss:ms✓✓");

        String horaFormateadaR = horaActuaR.format(formatoHoraR);
        
        //Utilizamos la funcion del cliente para enviar el mensaje y darle formate al mensaje
        cliente.enviarMsg("<h4>"+horaFormateada+"<h3><FONT COLOR=\"blue\">"+ nombre+"</FONT>"+ ":  </strong> "+msg  +  "<FONT COLOR=\"Teal\">"   +" _ "+horaFormateadaR +"<br> ");
       // cliente.enviarMsg("</h3><strong>"+nombre+": </strong> "+msg+"</h3><strong> "+horaFormateada +"<br> ");
        // TODO add your handling code here:
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       /* String NombreCrear = txtNombre.getText();
        String Carpeta= System.getProperty("D:\\GuardarTextosPrueba" );
        String direccionCompleta = Carpeta + "/" + NombreCrear + ".text";
        FileWriter direccion= null;
        try{
            direccion=new FileWriter(direccionCompleta);
            
        }
        catch(IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE
        },null, ex);
        }
        try{
            BufferedWriter escritor = new BufferedWriter (direccion);
            escritor.write(peMsg.getText());
            escritor.close();
            
        }
        catch(Exception ex){
        
            
                    }
        
        */
       
         try{
       JFileChooser filechooser = new JFileChooser();
        //FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt",);
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "htm");
       filechooser.setFileFilter(filter);
       filechooser.showSaveDialog(filechooser);
       File guarda = filechooser.getSelectedFile();
       

       if(guarda != null){
      try (
      /*guardamos el archivo y le damos el formatO*/
              
          FileWriter save = new FileWriter(guarda+".htm")) {
               
          save.write(peMsg.getText());
          }
       }
   }catch(IOException ex){}
   JOptionPane.showMessageDialog(null,"Su archivo se ha guardado ccorrectamente");
           
     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txMsgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMsgActionPerformed

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
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane peMsg;
    private javax.swing.JTextField txMsg;
    private javax.swing.JTextField txNom;
    // End of variables declaration//GEN-END:variables
}
