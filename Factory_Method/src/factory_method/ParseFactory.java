/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_method;

import java.io.File;

/**
 *
 * @author latif
 */
public class ParseFactory {
    public FileParser getFile(String FileType,File fileName){
      if(FileType == null){
         return null;
      }		
      if(FileType.equalsIgnoreCase("XML")){
         return new XMLFileParser(fileName);
         
      } else if(FileType.equalsIgnoreCase("JSON")){
         return new JSONFileParser(fileName);
         
      }  
      
      return null;
   }
    
    
}
