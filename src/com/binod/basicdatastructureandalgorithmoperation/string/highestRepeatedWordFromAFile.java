package com.binod.basicdatastructureandalgorithmoperation.string;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by 609722983 on 2/22/2020.
 */
public class highestRepeatedWordFromAFile {

    public static void main(String[] args) {

        Map<String, Integer> wordMap = buildMapWithWords("C:\\Users\\609722983\\Downloads\\BriteBill_Code\\DataStructureAndAlgorithm\\src\\com\\binod\\datastructure\\highestRepeatedWordFromAFile");
        List<Map.Entry<String, Integer>> sortByValue= sortByValueInDecreasingOrder(wordMap);
        System.out.println("List of repeated word from file.md and their count");
        for(Map.Entry<String, Integer> entry : sortByValue){
            System.out.println(""+entry.getKey()+" : "+entry.getValue());

        }
    }

    private static Map<String, Integer> buildMapWithWords(String fileName){

        Map<String, Integer> words= new HashMap<>();
        try(FileInputStream fileInputStream = new FileInputStream(fileName);
            DataInputStream dataInputStream=new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream))) {
            Pattern pattern=Pattern.compile("\\s+");
            String line= null;
            while ((line = bufferedReader.readLine()) != null){
                line=line.toLowerCase();
                String[] wordsString=pattern.split(line);
                for(String word : wordsString){
                    if(words.containsKey(word)){
                        words.put(word,(words.get(word))+1);
                    }else {
                        words.put(word,1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

      return words;
    }

    private static List<Map.Entry<String,Integer>> sortByValueInDecreasingOrder(Map<String,Integer> stringIntegerMap){
        Set<Map.Entry<String,Integer>> entrySet=stringIntegerMap.entrySet();
        List<Map.Entry<String,Integer>> stringIntegerList= new ArrayList<>(entrySet);
        Collections.sort(stringIntegerList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return stringIntegerList;
    }
}
