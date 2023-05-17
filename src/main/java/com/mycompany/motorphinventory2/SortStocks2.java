/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphinventory2;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Cha
 */
public class SortStocks2 implements Comparable<SortStocks2> {
    String date,label,brand,number,status;
    Set<SortStocks2> setSorted = new TreeSet<>();
    
    public SortStocks2(String date, String label, String brand, String number, String status){//constructor 
        this.date=date;
        this.label=label;
        this.brand=brand;
        this.number=number;
        this.status=status;
    }
    public SortStocks2(){    
    }
    
    public void SortingStocks() throws IOException{
        File file = new File("MotorPH Inventory Data.csv");
        CSVReader csvreader = new CSVReader(new FileReader(file));
        
        String[] line;
        
       
        while((line=csvreader.readNext())!=null){
            setSorted.add(new SortStocks2(line[0],line[1],line[2],line[3],line[4]));  
        }
        
        System.out.println("\nSorted by Brand:\n");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");
        System.out.println();
        for(SortStocks2 stock: setSorted){
            System.out.printf("%-15s%-15s%-15s%-15s%-15s",stock.date,stock.label,
                stock.brand,stock.number,stock.status);
            System.out.println();
        }
    }

    @Override
    public int compareTo(SortStocks2 sort) {
        if(this.brand.compareTo(sort.brand)>0){
            return 1;
        }
        else{
            return -1;
        }
    }
    
}
