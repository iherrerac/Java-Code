package codegymejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Cat relations

*/

public class catParents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String grandFatherName = reader.readLine();
        String grandMotherName = reader.readLine();
        String fatherName = reader.readLine();
        String motherName = reader.readLine();
        String sonName = reader.readLine();
        String daughterName = reader.readLine();
        
        Cat catGrandFather = new Cat(grandFatherName);
        Cat catGrandMother = new Cat(grandMotherName);
        Cat catFather = new Cat(fatherName,null,catGrandFather);
        Cat catMother = new Cat(motherName,catGrandMother,null);
        Cat catSon = new Cat(sonName,catMother,catFather);
        Cat catDaughter = new Cat(daughterName, catMother,catFather);
        
        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentMom;
        private Cat parentDad;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentMom,Cat parentDad) {
            this.name = name;
            this.parentMom = parentMom;
            this.parentDad = parentDad;
        }

        @Override
        public String toString() {
            String mom = (parentMom == null) ? ", no mother ":", " + parentMom.name + " is the mother";
            String dad = (parentDad == null) ? ", no father":", " + parentDad.name + " is the father";
          
            return "The cat's name is " + name + mom + dad;
        }
    }
}