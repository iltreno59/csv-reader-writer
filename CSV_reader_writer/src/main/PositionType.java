package main;

public enum PositionType {
    WORKER(1),
    MANAGER(2),
    SALER(1),
    HEAD(3);

    private int multiplier;

    PositionType(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
