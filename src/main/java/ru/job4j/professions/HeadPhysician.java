package ru.job4j.professions;

public class HeadPhysician extends Doctor {

    private boolean hasChildren;

    public HeadPhysician(String name, String surname, String education) {
        super(name, surname, education);
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}
