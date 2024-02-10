package Assignment.GreenStitch;

public class ParkingSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = null;
        boolean exit = false;

        while (!exit) {

            String[] command = System.console().readLine().split(" ");

            switch (command[0]) {
                case "create_parking_lot":
                    parkingLot = new ParkingLot(Integer.parseInt(command[1]));
                    break;
                case "park":
                    parkingLot.park(command[1], command[2]);
                    break;
                case "leave":
                    parkingLot.leave(Integer.parseInt(command[1]));
                    break;
                case "status":
                    parkingLot.status();
                    break;
                case "registration_numbers_for_cars_with_colour":
                    parkingLot.registrationNumbersForCarsWithColor(command[1]);
                    break;
                case "slot_number_for_registration_number":
                    parkingLot.slotNumberForRegistration(command[1]);
                    break;
                case "slot_numbers_for_cars_with_colour":
                    parkingLot.slotNumbersForCarsWithColor(command[1]);
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
