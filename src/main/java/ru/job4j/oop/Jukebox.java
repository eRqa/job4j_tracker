package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        switch (position) {
            case 1:
                System.out.println("Пусть бегут неуклюже");
                break;
            case 2:
                System.out.println("Спокойной ночи");
                break;
            default:
                System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox jb = new Jukebox();
        jb.music(1);
        jb.music(2);
        jb.music(3);
    }

}
