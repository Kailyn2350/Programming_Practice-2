abstract class Facility {
    String name;

    public Facility(String name) {
        this.name = name;
    }

    abstract void print();
}

class Zoo extends Facility {
    public Zoo(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("動物園: " + name);
    }
}

class Aquarium extends Facility {
    public Aquarium(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("水族館: " + name);
    }
}

public class J6_3 {
    public static void main(String[] args) {
        Facility[] facilities = {
            new Zoo("ズーラシア"),
            new Aquarium("エノスイ"),
            new Zoo("野毛山動物園"),
            new Zoo("金沢動物園"),
            new Aquarium("カワスイ"),
            new Aquarium("シーパラ")
        };

        for (Facility facility : facilities) {
            if (facility instanceof Zoo) {
                facility.print();
            }
        }

        for (Facility facility : facilities) {
            if (facility instanceof Aquarium) {
                facility.print();
            }
        }
    }
}
