package VendingMachine.Coins;

public class Coin {

    private coinType type;

    public Coin (coinType type){
        this.type = type;
    }

    public coinType getType() {
        return type;
    }

    public int getValue(){
        return type.getValue();
    }
}
