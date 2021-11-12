/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_oct;

/**
 *
 * @author amolika
 */
public class cartDetails {
    int pid,offer_price,price,qty,total_price;
    String pname;

    public cartDetails(int pid, int offer_price, int price, int qty, int total_price, String pname) {
        this.pid = pid;
        this.offer_price = offer_price;
        this.price = price;
        this.qty = qty;
        this.total_price = total_price;
        this.pname = pname;
    }
  
    
}
