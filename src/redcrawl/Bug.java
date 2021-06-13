/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redcrawl;

import java.util.Random;


/**
 *
 * @author me
 */
public class Bug {
    public static void main(String[] args) {
        
     int r = (int) (Math.random() * (5000 - 2000)) + 2000;
     
        System.out.println(r);
        
        
        String example = "/abc/def/ghfj.doc";
        System.out.println(example.substring(example.lastIndexOf("/") + 1));
        String a= "https://ih1.redbubble.net/image.476192731.9200/mo,small,flatlay,product_square,600x600.u2.jpg";
        
        a.replace("https://ih1.redbubble.net/", "");
        
        String b=a.replace("https://ih1.redbubble.net/", "");
        int firstIndex = b.indexOf('/'); 
        System.out.println(b.substring(0, firstIndex));
       String abc= "https://ih0.redbubble.net/"+b.substring(0, firstIndex)+"/--.u1.png";
        System.out.println(abc);
        
    }
}
