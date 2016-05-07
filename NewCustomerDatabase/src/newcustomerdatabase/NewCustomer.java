/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcustomerdatabase;

/**
 *
 * @author zacha
 */

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewCustomer extends JFrame {
     final String DB_URL = "jdbc:derby:CoffeeDB";
    private JPanel newCust;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel addressLabel;
    private JTextField addressField;
    private JLabel cityLabel;
    private JTextField cityField;
    private JLabel stateLabel;
    private JTextField stateField;
    private JLabel zipLabel;
    private JTextField zipField;
    private JLabel number;
    private JTextField custNumber;
    private JPanel newCustomer;
    private JButton create;
    
    
    public NewCustomer() {
        
        //setting standard swing items
        setTitle("New Customer");
        
        setSize(300,300);
        
        //default close action set 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        buildPanel();
        
        add(newCustomer);

        
        pack();
        setVisible(true);
        

        


        
    }
    
   private void clearNew(){
       //this will clear text when customers are submitted for usability 
       nameField.setText("");
      addressField.setText("");
      cityField.setText("");
      stateField.setText("");
      zipField.setText("");
      custNumber.setText("");
   }
    
    private void buildPanel(){
        //customer name info
        nameLabel = new JLabel("Customer Name");
         nameField = new JTextField(10);
        
        //customer address
         addressLabel = new JLabel("Address");
         addressField = new JTextField(10);
        
        //customer city
         cityLabel = new JLabel("City");
         cityField = new JTextField(10);
        
        //customer state 
         stateLabel = new JLabel("State");
        stateField = new JTextField(10);
        
        //customer zip
         zipLabel = new JLabel("Zipcode");
         zipField = new JTextField(10);
         
         //customer number
         number = new JLabel("Customer Number(Last three digits of phone#):");
         custNumber = new JTextField(5);
         
         //create button
         create = new JButton("Create");
         create.addActionListener(new CreateListener());
         
         //panel 
         newCustomer = new JPanel();
         
         //adding new items to new customer JPanel
         newCustomer.add(nameLabel);
         newCustomer.add(nameField);
         newCustomer.add(addressLabel);
         newCustomer.add(addressField);
         newCustomer.add(cityLabel);
         newCustomer.add(cityField);
         newCustomer.add(stateLabel);
         newCustomer.add(stateField);
         newCustomer.add(zipLabel);
         newCustomer.add(zipField);
         newCustomer.add(number);
         newCustomer.add(custNumber);
         newCustomer.add(create);
        
        
    }
 
    
    private class CreateListener implements ActionListener{
    public void actionPerformed (ActionEvent e){
        //getting all input text
        String name = nameField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String state  = stateField.getText();
        String zip = zipField.getText();
        String customerNumber = custNumber.getText();
        
        try{
          // Create new connection to the database.
      Connection conn = DriverManager.getConnection(DB_URL);
      // smtm for connect
      Statement stmt = conn.createStatement();
      
      //sql string from getText
          String sql = "INSERT INTO Customer VALUES"
              + "('" + customerNumber + "', '" + name + "', '" + address + "', '" + city + "','" + state + "', '" + zip + "')";

          //update table
      stmt.executeUpdate(sql);

          //call createCustomer method
          
           // Clear the text fields for quantity and order date.
          
           clearNew();
            
            // Let the user know the order was placed.
            JOptionPane.showMessageDialog(null, "New Customer Added");
          
          
           

        }
        
        catch(SQLException ex){
            System.exit(0);
        }
      
        
        
        
    }
    
}
       /**
       The clear method clears the text fields.
   */
   
 
    
   public static void main(String[] args){
       new NewCustomer();
   }

}


