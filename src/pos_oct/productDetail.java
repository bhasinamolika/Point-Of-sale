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
public class productDetail {
    int pid,price,offer_price;
    String category,pname,description,photo;
    productDetail(int pid,int price,int offer_price,String category,String pname,String description,String Photo)
    {
        this.pid=pid;
        this.category=category;
        this.description=description;
        this.price=price;
        this.offer_price=offer_price;
        this.pname=pname;
        this.photo=photo;
        
    }
}
