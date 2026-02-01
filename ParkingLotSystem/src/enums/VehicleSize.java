package enums;

public enum VehicleSize {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int value; // <= Because you need somewhere to store the number for each enum constant.

//    private final int value; creates a field inside the enum to hold the size ranking (1, 2, 3).
//
//    VehicleSize(int value) { this.value = value; } is the constructor that runs when each constant is created, so SMALL(1) assigns 1 into that field.
    VehicleSize(int val) {
        value = val;
    }

//    you cannot call an enum constructor from outside the enum.
//    Enum constructors are effectively private, even if you don’t write private.

    public int getValue() { return value; }

    // You can think of each constanr (SMALL, MEDIUM, LARGE) as a separate instance (object) of that enum class
}
