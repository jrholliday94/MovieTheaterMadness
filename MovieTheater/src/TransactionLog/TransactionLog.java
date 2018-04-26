/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionLog;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Spencer
 */
public class TransactionLog extends javax.swing.JFrame {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
    /**
     * Creates new form TransactionLog
     */
    public TransactionLog() {
        initComponents();
        Show_Customers_in_JTable();
    }

public class Customer {
    
        private String firstName;
        private String lastName;
        private String age;
        private String movieName;
        private String movieTime;
        private String moviePrice;
        private String orderId;
        private String paymentMethod;
        private String transactionTotal;
        private String giftCardBalance;
        private String giftCardId;
             
    public Customer(String FirstName, String LastName, String Age, String MovieName, String MovieTime, String MoviePrice, String OrderID, String PaymentMethod, String TransactionTotal, String GiftCardBalance, String GiftCardID)
    {
        this.firstName = FirstName;
        this.lastName = LastName;
        this.age = Age;
        this.movieName = MovieName;
        this.movieTime = MovieTime;
        this.moviePrice = MoviePrice;
        this.orderId = OrderID;
        this.paymentMethod = PaymentMethod;
        this.transactionTotal = TransactionTotal;
        this.giftCardBalance = GiftCardBalance;
        this.giftCardId = GiftCardID;

    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getAge()
    {
        return age;
    }
    public String getMovieName()
    {
        return movieName;
    }
    public String getMovieTime()
    {
        return movieTime;
    }
    public String getMoviePrice()
    {
        return moviePrice;
    }
    public String getOrderID()
    {
        return orderId;
    }
    public String getPaymentMethod()
    {
        return paymentMethod;
    }
    public String getTransactionTotal()
    {
        return transactionTotal;
    }
    public String getGiftCardBalance()
    {
        return giftCardBalance;
    }
    public String getGiftCardID()
    {
        return giftCardId;
    }
    
    

}
public Connection getConnection()
{
    Connection con;
    try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_theater_madness","root","");
        return con;
       
    }catch (SQLException e){
        e.printStackTrace();
        return null;
    }
}
 public ArrayList<Customer> getCustomerList()
{
    ArrayList<Customer> customerList = new ArrayList<Customer>();
    Connection connection = getConnection();
    String query = "SELECT * FROM `customer`";
    Statement st;
    ResultSet rs;
    
    try{
        st = connection.createStatement();
        rs = st.executeQuery(query);
        Customer customer;
        while(rs.next())
                {
                    customer = new Customer(rs.getString("fname"),rs.getString("lname"),rs.getString("age"),rs.getString("movie_name"),rs.getString("movie_time"),rs.getString("movie_price"),rs.getString("payment_method"),rs.getString("transaction_total"),rs.getString("order_id"),rs.getString("gc_bal"),rs.getString("gc_id"));
                    customerList.add(customer);
                }
    }catch (SQLException e){
    }
    return customerList;
}
 
public void Show_Customers_in_JTable()
{
    ArrayList<Customer> list = getCustomerList();
    DefaultTableModel model = (DefaultTableModel)jTable_Customers.getModel();
    Object[] row = new Object[11];
    for(int i = 0; i < list.size(); i++)
    {
        row[0] = list.get(i).getFirstName();
        row[1] = list.get(i).getLastName();
        row[2] = list.get(i).getAge();
        row[3] = list.get(i).getMovieName();
        row[4] = list.get(i).getMovieTime();   
        row[5] = list.get(i).getMoviePrice();
        row[6] = list.get(i).getPaymentMethod();        
        row[7] = list.get(i).getTransactionTotal();        
        row[8] = list.get(i).getOrderID();       
        row[9] = list.get(i).getGiftCardBalance();        
        row[10] = list.get(i).getGiftCardID();    
        
        model.addRow(row);
       
    }

}

public void executeSQLQuery(String query, String message){
    
    Connection con = getConnection();
    Statement st;
    try{                                   
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_theater_madness","root","");
        st = con.createStatement();
        if((st.executeUpdate(query)) == 1)
        {
            JOptionPane.showMessageDialog(null, message);
        }else
            JOptionPane.showMessageDialog(null, "Table Update Failed");
    }catch(Exception ex){
        ex.printStackTrace();
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Customers = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtext_fname = new javax.swing.JTextField();
        jtext_lname = new javax.swing.JTextField();
        jtext_age = new javax.swing.JTextField();
        jtext_moviename = new javax.swing.JTextField();
        jtext_mtime = new javax.swing.JTextField();
        jtext_mprice = new javax.swing.JTextField();
        jtext_paymethod = new javax.swing.JTextField();
        jtext_total = new javax.swing.JTextField();
        jtext_orderid = new javax.swing.JTextField();
        jtext_gcbal = new javax.swing.JTextField();
        jtext_gcid = new javax.swing.JTextField();
        jbutton_insert = new javax.swing.JButton();
        jbutton_update = new javax.swing.JButton();
        jbutton_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("First Name");

        jTable_Customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fname", "lname", "age", "movie_name", "movie_time", "movie_price", "transaction_total", "order_id", "payment_method", "gc_bal", "gc_id"
            }
        ));
        jTable_Customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Customers);

        jLabel2.setText("Last Name");

        jLabel3.setText("Age");

        jLabel4.setText("Movie Name");

        jLabel5.setText("Movie Time");

        jLabel6.setText("Movie Price");

        jLabel7.setText("Payment Method");

        jLabel8.setText("Transaction Total");

        jLabel9.setText("Order ID");

        jLabel10.setText("Gift Card Balance");

        jLabel11.setText("Gift Card ID");

        jtext_age.setText("0");

        jtext_mprice.setText("0");

        jtext_total.setText("0");

        jtext_gcid.setText("0");

        jbutton_insert.setText("Insert");
        jbutton_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_insertActionPerformed(evt);
            }
        });

        jbutton_update.setText("Update");
        jbutton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_updateActionPerformed(evt);
            }
        });

        jbutton_delete.setText("Delete");
        jbutton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtext_fname)
                            .addComponent(jtext_lname)
                            .addComponent(jtext_age)
                            .addComponent(jtext_moviename)
                            .addComponent(jtext_mtime)
                            .addComponent(jtext_mprice)
                            .addComponent(jtext_paymethod)
                            .addComponent(jtext_total)
                            .addComponent(jtext_orderid)
                            .addComponent(jtext_gcbal)
                            .addComponent(jtext_gcid, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jbutton_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbutton_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbutton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtext_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtext_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtext_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jtext_moviename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jtext_mtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jtext_mprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtext_paymethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jtext_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jtext_orderid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jtext_gcbal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jtext_gcid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbutton_insert, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(jbutton_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbutton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutton_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_insertActionPerformed
        String query = "INSERT INTO `customer`(`fname`, `lname`, `age`, `movie_name`, `movie_time`, `movie_price`, `payment_method`, `transaction_total`, `gc_bal`, `gc_id`) VALUES ('"+jtext_fname.getText()+"','"+jtext_lname.getText()+"','"+jtext_age.getText()+"','"+jtext_moviename.getText()+"','"+jtext_mtime.getText()+"','"+jtext_mprice.getText()+"','"+jtext_paymethod.getText()+"','"+jtext_total.getText()+"','"+jtext_gcbal.getText()+"','"+jtext_gcid.getText()+"')";
        
        executeSQLQuery(query, "Transaction Successful");

         DefaultTableModel model = (DefaultTableModel)jTable_Customers.getModel();
         model.setRowCount(0);
         Show_Customers_in_JTable();

    }//GEN-LAST:event_jbutton_insertActionPerformed

    private void jbutton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_updateActionPerformed
        // TODO add your handling code here:
  
        
        String query;
        query = "UPDATE `customer` SET `fname`='"+jtext_fname.getText()+"',`lname`='"+jtext_lname.getText()+"',`age`='"+jtext_age.getText()+"',`movie_name`='"+jtext_moviename.getText()+"',`movie_time`='"+jtext_mtime.getText()+"',`movie_price`='"+jtext_mprice.getText()+"',`payment_method`='"+jtext_paymethod.getText()+"',`transaction_total`='"+jtext_total.getText()+"',`order_id`='"+jtext_orderid.getText()+"',`gc_bal`='"+jtext_gcbal.getText()+"',`gc_id`='"+jtext_gcid.getText()+"' WHERE order_id = '"+jtext_orderid.getText()+"'";
        executeSQLQuery(query, "Transaction Updated");
        
        DefaultTableModel model = (DefaultTableModel)jTable_Customers.getModel();
         model.setRowCount(0);
         Show_Customers_in_JTable();
           
    
    }//GEN-LAST:event_jbutton_updateActionPerformed

    private void jbutton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_deleteActionPerformed
        // TODO add your handling code here:
        String query;
            query = "DELETE FROM `customer` WHERE order_id = '"+jtext_orderid.getText()+"'";
        
        executeSQLQuery(query, "Transaction Removed");
        DefaultTableModel model = (DefaultTableModel)jTable_Customers.getModel();
         model.setRowCount(0);
         Show_Customers_in_JTable();
    }//GEN-LAST:event_jbutton_deleteActionPerformed

    private void jTable_CustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CustomersMouseClicked
        // TODO add your handling code here:
        int i = jTable_Customers.getSelectedRow();
    TableModel model = jTable_Customers.getModel();
    jtext_fname.setText(model.getValueAt(i,0).toString());
    jtext_lname.setText(model.getValueAt(i,1).toString());
    jtext_age.setText(model.getValueAt(i,2).toString());
    jtext_moviename.setText(model.getValueAt(i,3).toString());
    jtext_mtime.setText(model.getValueAt(i,4).toString());
    jtext_mprice.setText(model.getValueAt(i,5).toString());
    jtext_total.setText(model.getValueAt(i,6).toString());
    jtext_orderid.setText(model.getValueAt(i,7).toString());
    jtext_paymethod.setText(model.getValueAt(i,8).toString());
    jtext_gcbal.setText(model.getValueAt(i,9).toString());
    jtext_gcid.setText(model.getValueAt(i,10).toString());
    }//GEN-LAST:event_jTable_CustomersMouseClicked
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
            java.util.logging.Logger.getLogger(TransactionLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Customers;
    private javax.swing.JButton jbutton_delete;
    private javax.swing.JButton jbutton_insert;
    private javax.swing.JButton jbutton_update;
    private javax.swing.JTextField jtext_age;
    private javax.swing.JTextField jtext_fname;
    private javax.swing.JTextField jtext_gcbal;
    private javax.swing.JTextField jtext_gcid;
    private javax.swing.JTextField jtext_lname;
    private javax.swing.JTextField jtext_moviename;
    private javax.swing.JTextField jtext_mprice;
    private javax.swing.JTextField jtext_mtime;
    private javax.swing.JTextField jtext_orderid;
    private javax.swing.JTextField jtext_paymethod;
    private javax.swing.JTextField jtext_total;
    // End of variables declaration//GEN-END:variables


}