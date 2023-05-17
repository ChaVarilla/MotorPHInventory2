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
public class DeleteStocks2 {
    String date,label,brand,number,status;
    Set<DeleteStocks2> setDeleted = new LinkedHashSet<>();
    
    public DeleteStocks2(String date, String label, String brand, String number, String status){//constructor 
        this.date=date;
        this.label=label;
        this.brand=brand;
        this.number=number;
        this.status=status;
    }
    public DeleteStocks2(){    
    }
    
    public void DeletingStocks() throws FileNotFoundException, IOException{
        File file = new File("MotorPH Inventory Data.csv");
        CSVReader csvreader = new CSVReader(new FileReader(file));
        
        String[] line;
        
       
        
        while((line=csvreader.readNext())!=null){
            setDeleted.add(new DeleteStocks2(line[0],line[1],line[2],line[3],line[4]));  
        }
        csvreader.close();
        
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");
        
        System.out.println();
        
        for(DeleteStocks2 stock: setDeleted){
            System.out.printf("%-15s%-15s%-15s%-15s%-15s",stock.date,stock.label,
                stock.brand,stock.number,stock.status);
            System.out.println();
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println();
        
        
        while(true){
            System.out.println("Deleting Stocks:");
            System.out.println();
            System.out.print("Enter Engine Number of the Stock to be Deleted:");
            String engineNum = scan.nextLine();
            
            for(DeleteStocks2 stock: setDeleted){
                if(stock.number.equals(engineNum)){
                   setDeleted.remove(stock);
                   break;
                }
            }
            System.out.println("Do you need to delete more stocks? Enter 1 if Yes and 0 if No: ");
            int loop = scan.nextInt();

            if(loop==0){
                break;
            } 
        }
        
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");
        
        System.out.println();
        
        for(DeleteStocks2 stock: setDeleted){
            System.out.printf("%-15s%-15s%-15s%-15s%-15s",stock.date,stock.label,
                stock.brand,stock.number,stock.status);
            System.out.println();
        }
    }  
}
