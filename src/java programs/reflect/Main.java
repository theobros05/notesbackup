package reflect;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main{

	
	public static void main(String[] args) {
		
		
        // To get the class object
	    Class myObjectClass = Person.class;
	    System.out.println("class object = " + myObjectClass.getName());
	    
	    
	   // To get class name
	    
	    String className = myObjectClass.getSimpleName(); // use getName() also
	    System.out.println("class simple name = " + className);
	    
	 
	    
        // To print all the method used in the class
		Method[] methods = Person.class.getMethods();
		
		for(Method method : methods){
		    System.out.println("method = " + method.getName());
		}
		// To get all the modifiers.The class modifiers are the keywords "public", "private", "static" etc.
		
		 int modifiers = myObjectClass.getModifiers();
		 System.out.println("modifiers = " + modifiers);
		 
		// You can obtain information about the package from a Class object like this: 
		 
		 Package Package = myObjectClass.getPackage();
		 System.out.println("Package name = " + Package);

		// To get the superclass
		 
		 Class superclass = myObjectClass.getSuperclass();
		 System.out.println("super class = " + superclass);

		
		
		/*
		If you are using something that is inherited, replace...
		
		getDeclaredField -> getField
		getDeclaredMethod -> getMethod
		 */
		
		Person p = new Person("Ben");
		
		
		
		//System.out.println(p.name); // Error, not accessible.
		
		try {
			Field field = p.getClass().getDeclaredField("name");
			field.setAccessible(true);
			System.out.println(field.get(p));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		...
		 */
		
		// System.out.println(Person.numPeople); // Error, not accessible.
		
		try {
			Field field = Person.class.getDeclaredField("numpeople");
			field.setAccessible(true);
			System.out.println(field.get(null));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		... 
		 */
		
		System.out.println(p.getname());
		
		try {
			Method method = p.getClass().getDeclaredMethod("getname");
			System.out.println(method.invoke(p));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		...
		 */
		
		p.setname("hai dude");
		System.out.println(p.getname());
		p.setname("ten");
		
		try {
		
			Method method = p.getClass().getDeclaredMethod("setname", String.class);
			method.invoke(p, "hai");
			System.out.println(p.getname());
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		...
		 */
		
		Person.printperson(p);
		
		try {
			Method method = Person.class.getDeclaredMethod( "printperson", Person.class);
			method.invoke(null, p);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		...
		 */
		
		Person other = new Person("newinstance");
		Person.printperson(other);
		
		try {
			Constructor<Person> constructor = Person.class.getDeclaredConstructor(String.class);
			other = constructor.newInstance("newinstance");
			Person.printperson(other);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}