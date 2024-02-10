package Assignment.GreenStitch;

import java.util.HashMap;
import java.util.Map;

class ParkingLot {
    private int capacity;
    private Map<Integer, String> slots;
    private Map<String, Integer> registrationToSlot;
    private Map<String, String> colorToRegistration;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new HashMap<>();
        this.registrationToSlot = new HashMap<>();
        this.colorToRegistration = new HashMap<>();
        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void park(String registration, String color) {
        if (slots.size() < capacity) {
            int slot = slots.size() + 1;
            slots.put(slot, registration);
            registrationToSlot.put(registration, slot);
            colorToRegistration.put(registration, color);
            System.out.println("Allocated slot number: " + slot);
        } else {
            System.out.println("Sorry, parking lot is full");
        }
    }

    public void leave(int slot) {
        if (slots.containsKey(slot)) {
            String registration = slots.get(slot);
            slots.remove(slot);
            registrationToSlot.remove(registration);
            colorToRegistration.remove(registration);
            System.out.println("Slot number " + slot + " is free");
        } else {
            System.out.println("Invalid slot number");
        }
    }

    public void status() {
        System.out.println("Slot No. Registration No Colour");
        for (Map.Entry<Integer, String> entry : slots.entrySet()) {
            int slot = entry.getKey();
            String registration = entry.getValue();
            String color = colorToRegistration.get(registration);
            System.out.println(slot + " " + registration + " " + color);
        }
    }

    public void registrationNumbersForCarsWithColor(String color) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : colorToRegistration.entrySet()) {
            if (entry.getValue().equals(color)) {
                result.append(entry.getKey()).append(", ");
            }
        }
        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length());
            System.out.println(result.toString());
        } else {
            System.out.println("Not found");
        }
    }

    public void slotNumberForRegistration(String registration) {
        Integer slot = registrationToSlot.get(registration);
        if (slot != null) {
            System.out.println("Slot number: " + slot);
        } else {
            System.out.println("Not found");
        }
    }

    public void slotNumbersForCarsWithColor(String color) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : colorToRegistration.entrySet()) {
            if (entry.getValue().equals(color)) {
                result.append(registrationToSlot.get(entry.getKey())).append(", ");
            }
        }
        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length());
            System.out.println(result.toString());
        } else {
            System.out.println("Not found");
        }
    }
}