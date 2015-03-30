/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 *
 * @author Ciambe
 */
public class Contatore {
    
    String[] contenitore;
    HashSet set; 
    
    
    String filename = "data/davidcopperfield.txt";   // per cambiare romanzo basta cambiare qua il percorso.
    int p;
    int diverse;                    

    public Contatore() {
        p = 0;
        diverse = 0;
        set = new HashSet();
    }
    
    
    public void lettore() {
        
        
        try {
            
            FileInputStream InputStream = new FileInputStream(filename);
            InputStreamReader streamReader = new InputStreamReader(InputStream);
            BufferedReader buffReader = new BufferedReader(streamReader);
            
            
            
            while (buffReader.ready()) {
                String s = buffReader.readLine();
                contenitore = s.split(" |,|\\.|;|:|'|-|!|\\?");
                for (int j = 0; j < contenitore.length; j++) {
                    if (set.contains(contenitore[j])) {
                        diverse++;
                    }
                    set.add(contenitore[j]);
                    p++;
                }
            }
            if (filename == "data/davidcopperfield.txt") {
                System.out.println(" Il romanzo scelto è David Copperfield");
            } else if (filename == "data/ipromessisposi.txt") {
                System.out.println(" Il romanzo scelto è I promessi Sposi");
                
            } else if (filename == "data/miseriaenobilta.txt") {
                System.out.println(" Il romanzo scelto è Miseria e nobiltà");
            } else if (filename == "data/warandpeace.txt") {
                System.out.println(" Il romanzo scelto è Warand Peace");
            }
                
            System.out.println("Nel Romanzo ci sono " + p + " parole");
            
            System.out.println("Nel romanzo ci sono " + diverse + " parole diverse");
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
