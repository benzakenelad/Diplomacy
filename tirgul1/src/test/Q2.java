package test;

public class Q2 {

	public static void a() {
		A a = new A();
		while (a.r < 10)
			a.m1();
		if (a.v < 10)
			a.m2();
		while (a.v < 10) {
			Thread t1 = new Thread(() -> a.m3());
			Thread t2 = new Thread(() -> a.m4());
			Thread t3 = new Thread(() -> a.m5());
			t1.start();
			t2.start();
			t3.start();
			try {
				t1.join();
				t2.join();
				t3.join();
			} catch (Exception e) {

			}
			a.m2();
		}
	}

	public static void b() {
		A a1 = new A();
		A a2 = new A();
		Thread t1 = new Thread(() -> a1.m1());
		Thread t2 = new Thread(() -> a2.m1());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();

		} catch (Exception e) {

		}
		for (int i = 0; i < 5; i++)
			a1.m2();
		a2.m3();
	}
}