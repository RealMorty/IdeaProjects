package SimpleStart;

public class test1 {
    public static void main(String[] args) {
        int size = 27;
        String name = "Fido";
        Dog myDog = new Dog(name, size);
        int x = size - 5;
        if (x < 15) myDog.bark(8);

        while (x > 3) {
            myDog.play();
            x = x-4;
        }
        int[] numList = {2,4,6,8};
        System.out.print("Hello");
        System.out.print("Dog: " + name);
    }


    private static class Dog {
        private String name;
        private int size;

        public Dog(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public void bark(int i) {
            System.out.println("汪汪汪！！！！！！！！！！！");
        }

        public void play() {
            System.out.println("让我玩一下好吗？？？？？？？？？？？？");
        }
    }
}
