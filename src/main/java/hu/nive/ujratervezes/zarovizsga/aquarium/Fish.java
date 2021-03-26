package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {

    private final String name;
    private int weight;
    private final String color;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    protected void increaseWeight(int grams) {
        weight += grams;
    }

    public String status() {
        return name + ", weight: " + weight + ", color: " + color + ", short term memory loss: " + hasMemoryLoss();
    }

    public abstract void feed();

    public abstract boolean hasMemoryLoss();

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
