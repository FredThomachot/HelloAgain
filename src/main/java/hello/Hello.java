package hello;

public class Hello {
    public static void main(String[] args) {
        Animal poupou = new Dog();
        Human fred = new Human();

        System.out.println(poupou.sayHello());
        System.out.println(fred.sayHello());
    }
}
