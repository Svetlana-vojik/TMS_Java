package by.teachmeskills.homeworks.hw_31032023.array;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.delete(0);
        System.out.print("\nMy list after deletion an element: ");
        myArrayList.displayAll();
        System.out.print("\nElement: ");
        myArrayList.display(2);
        myArrayList.clear();
        System.out.print("\nAfter cleaning:");
        myArrayList.displayAll();
    }
}
