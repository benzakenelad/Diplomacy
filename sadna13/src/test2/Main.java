package test2;

public class Main {

	public static void main(String[] args) {
		Property<String> p1 = new Property<>();
		Property<String> p2 = new Property<>();
		p1.bind(p2);
		p1.setValue("elad");
		System.out.println(p1.getValue());
		System.out.println(p2.getValue());
	}

}
