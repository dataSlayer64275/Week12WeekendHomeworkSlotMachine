package VendingMachine.Coins;

public enum coinType {

    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50);

    private final int value;

    coinType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}



