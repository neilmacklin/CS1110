package littlepeoplelistofobj;

public class APerson {
    // ----------------------------------------------------- INSTANCE VARIABLES
    private String name;
    private String picture;
    private int age;
    private double salary;

    //SETTERS
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    // GETTERS
    
    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
    
    //------------------------------------------------------ CONSTRUCTOR METHOD
    public APerson(String name, String picture, int age, double salary) {
        this.name = name;
        this.picture = picture;
        this.age = age;
        this.salary = salary;
    }
    
    //--------------------------------------------------------- toString METHOD
    public String toString() {
        return String.format("%-9s%-5s is age %2d and makes $%,10.2f",
                name, picture, age, salary);
    }
}
