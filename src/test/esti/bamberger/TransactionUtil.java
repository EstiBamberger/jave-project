package test.esti.bamberger;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionUtil  {
    private static final String filePath="D:transactions.csv";
    private static Map<School, List<Transaction>> transactionsMap;
    static {
        try {
            transactionsMap=buildTransactionMap();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<String> getFileRows() throws FileNotFoundException {
        List<String> list=new ArrayList<>();
        String s;
        char c;
        try (DataInputStream rows = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)))) {
            while ((s = rows.readLine()) != null) {
                list.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    private static List<String> convertRowToCols(String row){
        List<String> list=new ArrayList<>();
        StringBuilder s=new StringBuilder();
        char c;
        for(int i=0;i< row.length();i++){
            c=row.charAt(i);
            if(c==','){
                list.add(s.toString());
                s=new StringBuilder();
            }
            else
                s.append(c);
        }
     return list;
    }
    private static Map<School,List<Transaction>> buildTransactionMap() throws FileNotFoundException {
        Map<School,List<Transaction>> map=new HashMap<>();
        List<String> list1=getFileRows();
        List<Transaction> transactionsForSchool=new ArrayList<>();
        String prev=convertRowToCols(list1.get(1).toString()).get(0);
        String namePrev=convertRowToCols(list1.get(1).toString()).get(1);
        for (int i=1;i<list1.size();i++){
            List<String> list2=convertRowToCols(list1.get(i).toString());
            if((list2.get(0)).equals(prev)){
                transactionsForSchool.add(new Transaction(Integer.parseInt(list2.get(2)),list2.get(3), LocalDate.parse(list2.get(4), DateTimeFormatter.ofPattern("dd/MM/yyy")) ,Float.parseFloat(list2.get(5))));
            }
            else {
                map.put(new School(Integer.parseInt(prev),namePrev),transactionsForSchool);
                transactionsForSchool=new ArrayList<>();
                prev=list2.get(0);
                namePrev=list2.get(1);
                transactionsForSchool.add(new Transaction(Integer.parseInt(list2.get(2)),list2.get(3), LocalDate.parse(list2.get(4), DateTimeFormatter.ofPattern("dd/MM/yyy")) ,Float.parseFloat(list2.get(5))));
            }
        }
       return map;
    }
    public static School maxSchoolForMonth(Month month, int year){
     int n= (int) transactionsMap.values().stream().max((z1, z2)->
           z1.stream().filter(y->{return (y.getDate().getMonth().equals(month)&&y.getDate().getYear()==year);}).collect(Collectors.toList()).size()-
           z2.stream().filter(y->{return (y.getDate().getMonth().equals(month)&&y.getDate().getYear()==year);}).collect(Collectors.toList()).size()).stream().count();
     for(Map.Entry<School,List<Transaction>> entry:transactionsMap.entrySet()){
         if(entry.getValue().stream().filter(y-> (y.getDate().getMonth().equals(month)&&y.getDate().getYear()==year)).count()==n)
             return entry.getKey();
     }
               return null;
    }
}
