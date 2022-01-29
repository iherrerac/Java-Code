package codegymejemplos;

import java.util.Random;


public class RandomNumeros {

    public static void main(String[] args) {
        Cat[] arrCats = new Cat[3];
        Random r = new Random();
        for (int i = 0; i < arrCats.length; i++){
        arrCats[i]= new Cat("cat"+i,r.nextInt(15),r.nextInt(15),r.nextInt(100));
        System.out.println(arrCats[i].age);
        }
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
            int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
            int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

            int score = ageAdvantage + weightAdvantage + strengthAdvantage;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
