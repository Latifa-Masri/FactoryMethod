/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_method;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.scene.Node;
//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
/**
 *
 * @author latif
 */


import java.io.File;

/**
 *
 * @author latif
 */
public class XMLFileParser extends FileParser{
    private File f;
     private String str="";
     private final String r="result.txt";
   

    public XMLFileParser(File f) {
        super();
        this.f = f;
    }

       
    
    
    @Override
    public void ParseFile() 
        throws IOException{
          DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            try {
                
                Document doc = builder.parse(f);
                NodeList NoteList = doc.getElementsByTagName("note");
                FileWriter res = new FileWriter(r);
               
                for (int i=0;i<NoteList.getLength();i++){
                    Node n= NoteList.item(i);
                    if(n.getNodeType()==Node.ELEMENT_NODE){
                        Element note=(Element)n;
                        str+="Type: "+note.getTagName()+"\n"+"------------------";
                    }
                    NodeList nList=n.getChildNodes();
                    for(int j=0;j<nList.getLength();j++){
                        Node node = nList.item(j);
                        if(node.getNodeType()==Node.ELEMENT_NODE){
                            Element name = (Element)node;
                            str+="\n"+name.getTagName()+": "+name.getTextContent();
                        }
                    }

                }
                res.write(str);
                res.close();
            
            } catch (SAXException ex) {
                Logger.getLogger(Factory_Method.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Factory_Method.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
}
