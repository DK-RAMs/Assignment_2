/* * Dam Class
   * Dikabelo Ramashala
   * 1st March 2018
   * RMSDIK001
*/


import java.lang.Math;
import java.util.Collections;

    /**This constructor initializes a new dam object with the parameterized values as the
      *new object's attributes.*/
     
public class Dam implements Comparable<Dam>{

/**This class is used to create a dam object. This class stores the Name, FSC and percentage level of a dam. This
  *class implememts the comparable interface.*/ 
    
    private String damName;
    private float FSC;
    private float damLevel;
    
    public Dam(String damName, String FSC, String damLevel){
        this.damName = damName;
        if(FSC.equals("")){
            this.FSC = -1;
        }
        else{
            this.FSC = new Float(FSC);
        }
        if(damLevel.equals("")){
            this.damLevel = -1;
        }
        else{
            this.damLevel = new Float(damLevel);
        }
    }
    /**This constructor initializes a new dam object which acts as an empty dam object which doesn't exist*/
    public Dam(){
        this.damName = "";
        this.FSC = -1;
        this.damLevel = -1;
    }
    
    
    /**This method changes the damName attribute in a Dam object and sets this dam's damName attribute to the
      *parameterized string*/
      
    public void setdamName(String damName){
        this.damName = damName;
    }
    /* This method returns the damName attribute in the queried dam object (this dam object)*/
    
    public String getdamName(){
        return damName;
    }
    
    /**This method changes the FSC attribute in a Dam object and sets this dam's FSC attribute to the 
      *parameterized string (The parameterized string is changed to a float so that it can be stored)*/
      
    public void setFSC(String FSC){
        this.FSC = new Float(FSC);
    }
    
    /**This method returns the FSC attribute in the queried dam object (This dam object).*/
    
    public float getFSC(){
        return FSC;
    }
    
    /**This method changes the damLevel attribute in a Dam object and sets this dam's damLevel attribure to the
      *parameterized string (The string is changed to a float and is then stored in this object).*/
      
    public void setdamLevel(String damLevel){
        this.damLevel = new Float(damLevel);
    }
    
    /**This method returns the damLevel attribute in the queried dam object (This dam object)*/
    
    public float getdamLevel(){
        return damLevel;
    }
    
    /**This method compares the full names of two Dam objects and returns an integer
      *which will be used to order different Dam values. This method is an overriden verson of the compareTo() 
      *method in the Comparable interface*/
    
    public int compareTo(Dam dam){
        String a = this.damName.toLowerCase();
        String b = ((Dam)dam).damName.toLowerCase();
        if(a.length() == b.length()){
            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) < b.charAt(i))
                    return -1;
                else if(a.charAt(i) > b.charAt(i))
                    return 1;
            }
        }
        else if(a.length() < b.length()){
            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) < b.charAt(i))
                    return -1;
                 else if(a.charAt(i) > b.charAt(i))
                    return 1;
                 else if(i + 1 == a.length()) //checks if A has the exact same characters as B, but B being longer
                    return -1;
            }
        }
        else{
            for(int i = 0; i < b.length(); i++){
                if(a.charAt(i) < b.charAt(i))
                    return -1;
                else if(a.charAt(i) > b.charAt(i))
                    return 1;
                else if(i + 1 == b.length()) //checks if B has the exact same characters as A, but A being longer
                    return 1;;
            }
        }
        return 0;
            
    }
    
    /**This method converts This Dam object into a printable string, returning the attributes that are present in the
      *and combining them with key words that provide more information on This object.*/
    
    public String toString(){
        if(this.damLevel == -1 && this.FSC == -1)
            return "Dam Name: " + damName + "\nDam FSC: Insufficient Data\nDam Level @ 2016\\03\\07: Insufficient Data\n";
        else if(this.damLevel == -1)
            return "Dam Name: " + damName + "\nDam FSC: " + FSC + " million m^3\nDam Level @ 2016\\03\\07: Insufficient Data\n";
        else if(this.FSC == -1)
            return"Dam Name: " + damName + "\nDam FSC: Insufficient Data\nDam Level @ 2016\\03\\07: " + damLevel + "%\n";
        return "Dam Name: " + damName + "\nDam FSC: " + FSC + " million m^3\nDam Level @ 2016\\03\\07: " + damLevel + "%\n";
    }
     
    /**This method checks if the parameterized Object o is equivalent to This Dam object and returns a boolean expression
      *regarding the relationship.*/ 
    
    public boolean equals(Object o){
        if(this.getClass() == o.getClass()){
            Dam dam = (Dam)o;
            return (this.damName.equals(dam.getdamName()) && (this.FSC == dam.getFSC()) && this.damLevel == dam.getdamLevel());
        }
        return false;
    }
}