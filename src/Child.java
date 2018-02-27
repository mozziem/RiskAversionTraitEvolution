
public class Child {
    private int age;
    private boolean ofAge; //true after age>=15
    private boolean alive;
    
    public Child(){
        age = 0;
        ofAge = false;
    }
    
    void setOfAge(){
        ofAge = true;
    }
    
    boolean isOfAge(){
        return ofAge;
    }  
    
    int getAge(){
        return this.age;
    }
    
    void addAge(){
        age+=1;
    }
    
    void setDead(){
        alive = false;
    }
    
    boolean isAlive(){
        return alive;
    }
     
    
}
