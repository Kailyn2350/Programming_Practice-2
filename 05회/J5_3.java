class Circle {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getRadius() {
        return radius;
    }
}

class Sphere extends Circle {
    Sphere(double radius) {
        super(radius);
    }

    double getVol() {
        return (4 / 3.0) * Math.PI * Math.pow(getRadius(), 3);
    }
}

class Cylinder extends Circle {
    private double height;

    Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    double getHeight() {
        return height;
    }

    double getVol() {
        return getArea() * height;
    }
}

class Cone extends Circle {
    private double height;

    Cone(double radius, double height) {
        super(radius);
        this.height = height;
    }

    double getHeight() {
        return height;
    }

    double getVol() {
        return (1 / 3.0) * getArea() * height;
    }
}

class J5_3 {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        Sphere sphere = new Sphere(3);
        Cylinder cylinder = new Cylinder(3, 5);
        Cone cone = new Cone(3, 5);

        System.out.println("Circle: radius = " + circle.getRadius() + ", area = " + circle.getArea());
        System.out.println("Sphere: radius = " + sphere.getRadius() + ", volume = " + sphere.getVol());
        System.out.println("Cylinder: radius = " + cylinder.getRadius() + ", height = " + cylinder.getHeight() + ", volume = " + cylinder.getVol());
        System.out.println("Cone: radius = " + cone.getRadius() + ", height = " + cone.getHeight() + ", volume = " + cone.getVol());
    }
}