/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botparser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Basia
 */
public class BotTalking {
    private ArrayList <String> patterns;
    private ArrayList <String> tempates;
    public void talk(){
        String talker;
        ParseAIML parser = new ParseAIML();
        parser.parseFile();
        patterns = parser.getarrayOfPatterns();
        tempates = parser.getarrayOfTemplates();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            talker = scanner.nextLine();
             if(patterns.contains(talker.toUpperCase())){   
                int ind = patterns.indexOf(talker.toUpperCase());
                System.out.println(tempates.get(ind));
            }
                
        }
    }
}
