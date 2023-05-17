/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphinventory2;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Cha
 */
public class AddStocks2 {
    String date,label,brand,number,status;
    Set<AddStocks2> setAdded = new LinkedHashSet<>();
   
    
    public AddStocks2(String date,String label, String brand, String number, String status){
        this.date=date;
        this.label =label;
        this.brand=brand;
        this.number=number;
        this.status=status;
        
    }
    
    public AddStocks2(){
    }
    public void AddingStocks() throws FileNotFoundException, IOException{
        File file = new File("MotorPH Inventory Data.csv");
        CSVReader csvreader = new CSVReader(new FileReader(file));
        
        String[] line;
        
       
        while((line=csvreader.readNext())!=null){
            setAdded.add(new AddStocks2(line[0],line[1],line[2],line[3],line[4]));
            
        }
        
         System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");
        System.out.println();
        for(AddStocks2 stock: setAdded){
           System.out.printf("%-15s%-15s%-15s%-15s%-15s",stock.date,stock.label,
                stock.brand,stock.number,stock.status);
            System.out.println();
        }
        
        
        
        Scanner scan = new Scanner(System.in);
        
        String[] newline= new String[5];
        
       
        while(true){
           System.out.println("Adding New Stocks");
           System.out.println();
           System.out.print("Enter Date: ");
           newline[0] = scan.nextLine();
           System.out.print("Enter Stock Label: ");
           newline[1] = scan.nextLine();
           System.out.print("Enter Stock's Brand: ");
           newline[2] = scan.nextLine();
           System.out.print("Enter Engine Number: ");
           newline[3] = scan.nextLine();
           System.out.print("Enter Status:");
           newline[4] = scan.nextLine();
           
           setAdded.add(new AddStocks2(newline[0],newline[1],newline[2],newline[3],newline[4]));
           System.out.print("Do you need to add more stocks? Enter 1 if Yes and 0 if No: ");
           int loop = scan.nextInt();
           
           if(loop==0){
               break;
           } 
        }
        
        
        
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");
        System.out.println();
        for(AddStocks2 stock: setAdded){
           System.out.printf("%-15s%-15s%-15s%-15s%-15s",stock.date,stock.label,
                stock.brand,stock.number,stock.status);
            System.out.println();
        }
       
       
       
    }     
}
