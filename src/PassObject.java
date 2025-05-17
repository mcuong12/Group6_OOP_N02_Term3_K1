class Dog {
    String name;
    Dog(String name) {
        this.name = name;
    }
}

public class PassObject {
    public static void changeName(Dog dog) {
        dog.name = "Chó con";
    }

    public static void test() {
        Dog dog = new Dog("Chó lớn");
        System.out.println("Trước khi đổi: " + dog.name);
        changeName(dog);
        System.out.println("Sau khi đổi: " + dog.name);
    }
}