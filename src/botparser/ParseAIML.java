/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botparser;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.*;
import org.w3c.dom.*;
/**
 *
 * @author Basia
 */
public class ParseAIML {
    
    private ArrayList <String> arrayOfPatterns;
    private ArrayList <String> arrayOfTemplates;
    
    private Document doc;
    public void parseFile(){
        arrayOfPatterns = new ArrayList<String>();
        arrayOfTemplates = new ArrayList<String>();
        readFile();
        addPatterns();
        addTemplates();
    }
    private void readFile(){
        try{
            File inputFile = new File("src//resources//test.aiml");//wczytanie pliku
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();      
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void addPatterns(){
            NodeList category = doc.getElementsByTagName("category");//lista galezi category
            for(int i = 0; i < category.getLength(); i++){
                Node node = category.item(i);//obecny element category z listy
                if(node.getNodeType() == Node.ELEMENT_NODE){ //czy jest elementem
                    Element currentCategory = (Element) node;
                    //zawartosc elementu pattern
                    Element pattern = (Element)currentCategory.getElementsByTagName("pattern").item(0);
                    String textFromPattern = pattern.getTextContent();
                    try{
                        arrayOfPatterns.add(textFromPattern);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }   
                }
            }
    }
    
      private void addTemplates(){
            NodeList category = doc.getElementsByTagName("category");//lista galezi category
            for(int i = 0; i < category.getLength(); i++){
                Node node = category.item(i);//obecny element category z listy
                if(node.getNodeType() == Node.ELEMENT_NODE){ //czy jest elementem
                    Element currentCategory = (Element) node;
                    //zawartosc elementu pattern
                    Element pattern = (Element)currentCategory.getElementsByTagName("template").item(0);
                    String textFromTemplate= pattern.getTextContent();
                    try{
                        arrayOfTemplates.add(textFromTemplate);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }      
                }
            }
    }
      
    public ArrayList <String> getarrayOfPatterns(){
        return this.arrayOfPatterns;
    }
    
     public ArrayList <String> getarrayOfTemplates(){
        return this.arrayOfTemplates;
    }
    
    
}
