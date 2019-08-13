/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/**
 *
 * @author latif
 */
public class JSONFileParser extends FileParser{
    private File f;
    private String r="result.txt";

    public JSONFileParser(File f) {
        super();
        this.f = f;
    }


    @Override
    public void ParseFile() throws IOException{
         String first = "SI1.json";  

        try {
            String contents = new String((Files.readAllBytes(Paths.get(first))));
            JSONObject o = new JSONObject(contents);
//            JSONArray emails = o.getJSONArray("emails");
//            for (int i = 0; i < emails.length(); i++) {
//                System.out.println(emails.getString(i));
//            }
            JSONObject Note = o.getJSONObject("note");
//            System.out.println(o.getString("note"));
             Set<String> name = o.keySet();
             Set<String> keys = Note.keySet();
             FileWriter r = new FileWriter("result.txt");
             Iterator<String> iterator = name.iterator();
             String s="";
            while (iterator.hasNext()) {
                String names = iterator.next();
                s+="Type: "+names+"\n------------------";
               Iterator<String> itr = keys.iterator();
               Integer m=0;
 
            while (itr.hasNext()) {
                String k = itr.next();
                s+="\n"+k+": "+Note.getString(k);
            
           }
        }
            r.write(s);
            r.close();
        }  catch(IOException e){
            e.printStackTrace();
        }


         
    }
    
}
