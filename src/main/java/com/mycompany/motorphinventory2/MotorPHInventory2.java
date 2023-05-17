/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.motorphinventory2;

import java.io.IOException;

/**
 *
 * @author Cha
 */
public class MotorPHInventory2 {

    public static void main(String[] args) throws IOException {
        AddStocks2 add2 = new AddStocks2();
        DeleteStocks2 delete2 = new DeleteStocks2();
        SortStocks2 sort2 = new SortStocks2();
        SearchStocks2 search2 = new SearchStocks2();
        
        //add2.AddingStocks();
        //delete2.DeletingStocks();
        //sort2.SortingStocks();
        search2.SearchingStocks();
    }
}
