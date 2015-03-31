package preReading;

public class Inheritance {
	class Base {
		void foo(){
			this.bar();
		}
		
		void bar(){
			System.out.println("base");
		}
	}
	
	class Derived extends Base {		
		void bar(){
			System.out.println("derived");
		}
	}
	Base a = new Derived();
	a.
}
