class ClassA {
    void print() {
        System.out.println("ClassA");
    }
}

class ClassB extends ClassA {
    @Override
    void print() {
        super.print();
        System.out.println("ClassB");
    }
}

class ClassC extends ClassB {
    @Override
    void print() {
        super.print();
        System.out.println("ClassC");
    }
}

class J5_1 {
    public static void main(String[] args) {
    	ClassA a = new ClassC();
    	a.print();
    	System.out.println();
    	a = new ClassB();
    	a.print();
    	System.out.println();
    	a = new ClassA();
    	a.print();
    	System.out.println();
    	
//    	ClassC c = new ClassA();
//    	c.print() ;
    }
}