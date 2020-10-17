package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball theKOLOBOK = new Ball();
        Hare whiteHare = new Hare();
        Wolf grayWolf = new Wolf();
        Fox slyOrangeFox = new Fox();

        whiteHare.tryEat(theKOLOBOK);
        theKOLOBOK.tryEat();
        grayWolf.tryEat(theKOLOBOK);
        theKOLOBOK.tryEat();
        slyOrangeFox.tryEat(theKOLOBOK);

        System.out.println("THE END :C");

    }
}
