import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static List<String> getSortedList(List<String> names) {

        Map<String,Integer> myMap = new HashMap<String,Integer>();
        myMap.put("I", 1);
        myMap.put("II", 2);
        myMap.put("III", 3);
        myMap.put("IV", 4);
        myMap.put("V", 5);
        myMap.put("VI", 6);
        myMap.put("VII", 7);
        myMap.put("VIII", 8);
        myMap.put("IX", 9);
        myMap.put("X", 10);
        myMap.put("XX", 20);
        myMap.put("XXX", 30);
        myMap.put("XL", 40);
        myMap.put("L", 50);

        Map<String,Integer> newMap = new HashMap<String,Integer>();
        for (String name : names) {
            int value=calculate(myMap,name);
            newMap.put(name, value);

        }List<String>nameSortedList = new ArrayList<>(newMap.keySet());
        Collections.sort(nameSortedList);
        return nameSortedList;


    }

    static int calculate(Map<String,Integer> myMap,String word){
        int result=0;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(i>0 && myMap.get(ch) > myMap.get(word.charAt(i-1))){
                result += myMap.get(ch) - 2*myMap.get(word.charAt(i-1));
            }

            else{
                result += myMap.get(ch);

            }

        }return result;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int namesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> names = new ArrayList<>();

        for (int i = 0; i < namesCount; i++) {
            String namesItem = bufferedReader.readLine();
            names.add(namesItem);
        }

        List<String> res = getSortedList(names);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(res.get(i));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}