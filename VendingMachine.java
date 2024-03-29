
public class VendingMachine {
    private Inventory inventory;
    private VendingMachineState state;

    public VendingMachine() {
        inventory = new Inventory();
        state = VendingMachineState.IDLE;
    }

    public void selectItem(String item) {
        if (state == VendingMachineState.IDLE) {
            if (inventory.hasItem(item)) {
                state = VendingMachineState.WAITING_FOR_PAYMENT;
                System.out.println("Please insert payment for " + item);
            } else {
                state = VendingMachineState.OUT_OF_STOCK;
                System.out.println(item + " is out of stock.");
            }
        } else {
            System.out.println("Cannot select item. Vending machine is busy.");
        }
    }

    public void insertPayment(double amount) {
        if (state == VendingMachineState.WAITING_FOR_PAYMENT) {
            System.out.println("Payment received: $" + amount);
            state = VendingMachineState.DISPENSING;
        } else {
            System.out.println("Cannot insert payment. Vending machine is not waiting for payment.");
        }
    }

    public void dispenseItem(String item) {
        if (state == VendingMachineState.DISPENSING) {
            inventory.dispenseItem(item);
            System.out.println("Dispensing " + item);
            state = VendingMachineState.IDLE;
        } else {
            System.out.println("Cannot dispense item. Vending machine is not ready to dispense.");
        }
    }

    public void restockItem(String item, int quantity) {
        inventory.restockItem(item, quantity);
    }

    public void changeState(VendingMachineState newState) {
        state = newState;
    }

    public VendingMachineState getState() {
        return state;
    }
}

