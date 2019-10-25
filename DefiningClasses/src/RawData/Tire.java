package RawData;

public class Tire {
    double tire1;
    int tire1Age;
    double tire2;
    int tire2Age;
    double tire3;
    int tire3Age;
    double tire4;
    int tire4Age;

    public Tire(double tire1, int tire1Age, double tire2, int tire2Age, double tire3, int tire3Age, double tire4, int tire4Age) {
        this.tire1 = tire1;
        this.tire1Age = tire1Age;
        this.tire2 = tire2;
        this.tire2Age = tire2Age;
        this.tire3 = tire3;
        this.tire3Age = tire3Age;
        this.tire4 = tire4;
        this.tire4Age = tire4Age;
    }

    public double getTire1() {
        return tire1;
    }

    public void setTire1(double tire1) {
        this.tire1 = tire1;
    }

    public int getTire1Age() {
        return tire1Age;
    }

    public void setTire1Age(int tire1Age) {
        this.tire1Age = tire1Age;
    }

    public double getTire2() {
        return tire2;
    }

    public void setTire2(double tire2) {
        this.tire2 = tire2;
    }

    public int getTire2Age() {
        return tire2Age;
    }

    public void setTire2Age(int tire2Age) {
        this.tire2Age = tire2Age;
    }

    public double getTire3() {
        return tire3;
    }

    public void setTire3(double tire3) {
        this.tire3 = tire3;
    }

    public int getTire3Age() {
        return tire3Age;
    }

    public void setTire3Age(int tire3Age) {
        this.tire3Age = tire3Age;
    }

    public double getTire4() {
        return tire4;
    }

    public void setTire4(double tire4) {
        this.tire4 = tire4;
    }

    public int getTire4Age() {
        return tire4Age;
    }

    public void setTire4Age(int tire4Age) {
        this.tire4Age = tire4Age;
    }

    public boolean hasWeakTire(){
        if(tire1<1 || tire2<1 || tire3<1 || tire4<1){
            return true;
        }
        return false;
    }
}
