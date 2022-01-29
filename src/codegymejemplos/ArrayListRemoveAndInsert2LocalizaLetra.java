package codegymejemplos;

/*
 * 	The fix method should remove all words containing the letter "r" from the list. 
 *  The fix methodmust duplicate words containing the letter "l" (add another instance of this word to the list)
 *  There is an exception: words containing both "r" and "l" should be left alone.
 */
import java.util.ArrayList;

public class ArrayListRemoveAndInsert2LocalizaLetra {

    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("rose"); // 0
        list.add("measure"); // 1
        list.add("love"); 
        list.add("lyre");
        list.add("wade");
        list.add("bark");// 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        int contR = 0;
        int contL = 0;
        
        for (int j = 0; j < list.size();){
            for (int i = 0; i<list.get(j).length(); i++){
                if (list.get(j).charAt(i) == 'r') contR++;
                if (list.get(j).charAt(i) == 'l') contL++;
            }
            System.out.println("R: "+ contR + " L: "+contL);
            if (contR > 0 && contL >0){
                System.out.printf("localizada LR: %s\n",list.get(j));
                j++;
            } else if(contR > 0){ 
                System.out.printf("Elimino %s\n",list.get(j));
                list.remove(j);
                //j--;
            } else if (contL > 0){
                System.out.printf("Agrego %s\n",list.get(j));
                list.add (j,list.get(j));
                j+=2;
            } else if (contR == 0 && contL == 0) j++;
            
            contL = 0; contR = 0;
        }
        return list;
    }
}

//Solucion aportada por CodeGym

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
///* 
//Duplicating words
//
//*/
//
//public class ArrayListRemoveAndInsert2LocalizaLetra {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            String s = reader.readLine();
//            list.add(s);
//        }
//
//        ArrayList<String> result = doubleValues(list);
//
//        for (String s : result) {
//            System.out.println(s);
//        }
//    }
//
//    public static ArrayList<String> doubleValues(ArrayList<String> list) {
//        ArrayList<String> result = new ArrayList<>();
//        for (String s : list) {
//            result.add(s);
//            result.add(s);
//        }
//        return result;
//    }
//}

