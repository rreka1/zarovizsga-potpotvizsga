package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishes = new ArrayList<>();

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void feed() {
        for (Fish fish : fishes) {
            fish.feed();
        }
    }

    public void removeFish() {
        fishes.removeIf(fish -> fish.getWeight() >= 11);
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish fish : fishes) {
            result.add(fish.status());
        }
        return result;
    }
}
