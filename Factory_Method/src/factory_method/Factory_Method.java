/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_method;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

  
/**
 *
 * @author latif
 */


 

public class Factory_Method {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException   {
        // Scanner for user input
    Scanner user = new Scanner( System.in ); 
    String  FileName ;
    // prepare the input file
    System.out.print("Input File Name: ");
    FileName = user.nextLine().trim();
    File input = new File( FileName );      
    Scanner scan = new Scanner( input );
    File file = new File(FileName);
    String ext=getFileExtension(file);
       ParseFactory parseFactory=new ParseFactory();
       FileParser f;
       f = parseFactory.getFile(ext,file);
       f.ParseFile();
       
         
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return ""; 
    }

}
