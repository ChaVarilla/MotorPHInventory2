/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphinventory2;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Cha
 */
public class SearchStocks2 {
    String date,label,brand,number,status;
    Map<String,SearchStocks2> stockHashMap = new HashMap<>();
    
    
    public SearchStocks2(String date, String label, String brand, String number, String status){//constructor 
        this.date=date;
        this.label=label;
        this.brand=brand;
        this.number=number;
        this.status=status;
    }
    public SearchStocks2(){    
    }
    
    public void SearchingStocks() throws IOException{
        File file = new File("MotorPH Inventory Data.csv");
        CSVReader csvreader = new CSVReader(new FileReader(file));
        
        String[] line;
        
       
        while((line=csvreader.readNext())!=null){
            stockHashMap.put(line[3],new SearchStocks2(line[0],line[1],line[2],line[3],line[4]));  
        }
        
        
        Set<Map.Entry<String,SearchStocks2>> entries = stockHashMap.entrySet();
        
        
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");
        System.out.println();
        
        for(Map.Entry<String, SearchStocks2> e: entries){
            System.out.printf("%-15s%-15s%-15s%-15s%-15s",e.getValue().date,e.getValue().label,
                e.getValue().brand,e.getValue().number,e.getValue().status);
            System.out.println();
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter Engine Number to Search: ");
        String engineNum = scan.nextLine();
        
        for(Map.Entry<String, SearchStocks2> e: entries){
            if(engineNum.equals(e.getKey())){
                System.out.print("\nDate Entered: ");
                System.out.println(e.getValue().date);
                System.out.print("Stock Label: ");
                System.out.println(e.getValue().label);
                System.out.print("Stock's Brand: ");
                System.out.println(e.getValue().brand);
                System.out.print("Engine Number: ");
                System.out.println(e.getValue().number);
                System.out.print("Status: ");
                System.out.println(e.getValue().status);
                break;
            }
            else{
                System.out.println("Stock is not listed.");
                break;
            }
        }
        
    }
}
