/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcustomerdatabase;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author zacha
 */
public class Main extends JFrame{
    //global
    private JButton placeOrder;
    private JButton newCustomer;
    private JPanel main;
    private JLabel info;
public Main(){
    //stnd gui stuff
    setTitle("Coffee DB Manager");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    setSize(400,400);
    setLayout(new BorderLayout());
    buildPanel();
    add(main);
     pack();
    setVisible(true);     
    
}

private void buildPanel(){
    //items to panel with action events
    main = new JPanel();
    info = new JLabel("Select an operation:");
    placeOrder = new JButton("Place an Order");
    placeOrder.addActionListener(new PlaceButtonListener());
    newCustomer = new JButton("Add a New Customer");
    newCustomer.addActionListener(new NewCustomerListener());
    
    
    
    main.add(info);
    main.add(placeOrder);
    main.add(newCustomer);
    
}

/*
Allows user to open new customer application
*/
   private class NewCustomerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            //brings up New Customer Program
            NewCustomer newCustomer1 = new NewCustomer();
            
        }
}
   /*
   allows customer to place order 
   */
   
   private class PlaceButtonListener implements ActionListener{
       public void actionPerformed(ActionEvent ex){
           new PlaceOrder();
       }
   }
    
    
    


   public static void main(String[] args){
       new Main();
       
       
   }
}