package gvsucis.interfaceExamples;

public class Farm {

  public static void converse(Animal a, Animal b) {
    System.out.println(a.speak());
    System.out.println(b.speak());
    System.out.println(a.speak());
    System.out.println(b.speak());

    // Notice that if the type is Animal, you can't
    // call non-animal methods:
    //a.rollOver();
  }

  public static void main(String[] args) {

    Cat cat = new Cat();
    Dog dog = new Dog();
    Cow cow = new Cow();

    System.out.println("Cat and Dog: ");
    converse(cat, dog);

    System.out.println();
    System.out.println("Dog and Cow: ");
    converse(dog, cow);
  }

}