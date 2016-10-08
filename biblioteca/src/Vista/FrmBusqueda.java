package Vista;
import Controlador.Editorial;
import Controlador.autor;
import Controlador.control_conexion;
import Controlador.libro;
import Controlador.usuario;
import javax.swing.table.DefaultTableModel;

public class FrmBusqueda extends javax.swing.JFrame {
public static int opc; 
public static int opcion; 

int fila=-1;
 control_conexion con=new control_conexion();
    /** Creates new form FrmBusqueda */
    public FrmBusqueda() {
        // centrando el frmlogin
this.setLocation(350, 0);
        
        initComponents();
    }
public void buscar_editorial(){
    switch (opc) { 
        case 1:
//Buscar ciudades

    Editorial ed = new Editorial();
    
con.conectar();
Object[][] dtEdi;        
String[] columNames = {"Código","Nombre"};  
// se utiliza la funcion
dtEdi = ed.getDatos();
// se colocan los datos en la tabla
DefaultTableModel datos = new DefaultTableModel(dtEdi,columNames);                        
Tabla.setModel(datos);
break;
}    
}

public void buscar_autor(){
    switch (opc){ 
        case 2:
     autor au = new autor();
    
        
con.conectar();
Object[][] dtAu;        
String[] columNames = {"Código","Nombre","Pais"};  
// se utiliza la funcion
dtAu = au.getDatos();
// se colocan los datos en la tabla
DefaultTableModel datos = new DefaultTableModel(dtAu,columNames);                        
Tabla.setModel(datos);
break;
    }
}
public void buscar_libro(){
    switch (opcion){ 
        case 1:
     libro libr = new libro();
        
con.conectar();
Object[][] dtlibr;        
String[] columNames = {"Código","Titulo","codEditorial","codAutor"};  
// se utiliza la funcion
dtlibr = libr.getDatos();
// se colocan los datos en la tabla
DefaultTableModel datos = new DefaultTableModel(dtlibr,columNames);                        
Tabla.setModel(datos);
break;
    }
}
public void buscar_usuario(){
    switch (opcion){ 
        case 2:
     usuario usr = new usuario();
        
con.conectar();
Object[][] dtusr;        
String[] columNames = {"Rut","Nombre","Apeliido","direccion","telefono"};  
// se utiliza la funcion
dtusr = usr.getDatos();
// se colocan los datos en la tabla
DefaultTableModel datos = new DefaultTableModel(dtusr,columNames);                        
Tabla.setModel(datos);
break;
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Salir"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
// TODO add your handling code here:
    switch(opc){
        case 1:
            buscar_editorial();
        break;
        case 2:
            buscar_autor();
        break;
    }
    switch(opcion){
        case 1:
            buscar_libro();
        break;
        case 2:
            buscar_usuario();
        break;
        
    }
}//GEN-LAST:event_formWindowOpened

private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
// TODO add your handling code here:
switch(opc){
case 1:
fila = Tabla.rowAtPoint(evt.getPoint());                 
         if (fila > -1){                          
         FrmLibro.TxtCodeditorial.setText(String.valueOf(Tabla.getValueAt(fila, 0)));
         FrmLibro.Txtnombreeditorial.setText(String.valueOf(Tabla.getValueAt(fila, 1)));
         }
this.dispose();
break;
    case 2:
fila = Tabla.rowAtPoint(evt.getPoint());                 
         if (fila > -1){                          
         FrmLibro.Txtcodautor.setText(String.valueOf(Tabla.getValueAt(fila, 0)));
         FrmLibro.Txtnombreautor.setText(String.valueOf(Tabla.getValueAt(fila, 1)));
         }
this.dispose();
break;         
     }
switch(opcion){
case 1:
fila = Tabla.rowAtPoint(evt.getPoint());                 
         if (fila > -1){                          
         FrmTransaccion.Txtcodlibro.setText(String.valueOf(Tabla.getValueAt(fila, 0)));
         FrmTransaccion.Txtlibro.setText(String.valueOf(Tabla.getValueAt(fila, 1)));
         }
this.dispose();
break;
    case 2:
fila = Tabla.rowAtPoint(evt.getPoint());                 
         if (fila > -1){                          
         FrmTransaccion.Txtrutusu.setText(String.valueOf(Tabla.getValueAt(fila, 0)));
         FrmTransaccion.txtusuario.setText(String.valueOf(Tabla.getValueAt(fila, 1)));
         }
this.dispose();
break;         
 
     }
}//GEN-LAST:event_TablaMouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    this.dispose();
    
}//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBusqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
