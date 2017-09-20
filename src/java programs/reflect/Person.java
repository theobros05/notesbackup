package reflect;

public class Person extends Animal{
	
	private static String name;
    private static int numpeople=0;
    
 
       
    public Person(String name)
    {
    	this.name=name;
    	numpeople++;
    }
    
    public void checkmethod()
    {
    	
    	numpeople++;
    }
    public String getname()
    {
    	return name;
    }
    
    public void setname(String name)
    {
    	
    	this.name=name;
    	
    }
    
    public static void printperson(Person P)
    {
    	System.out.println(P.getname());
    }

    public static void hide() {
        System.out.println("The hide method in Cat.");
    }
 
    public void override() {
        System.out.println("The override method in Cat.");
    }
    
    public static void main(String[] args) {
        Person myCat = new Person(name);
        Animal myAnimal = (Animal)myCat;
        myAnimal.hide();
        myAnimal.override();
    }
}
