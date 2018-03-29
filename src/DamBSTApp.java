/* * DamBSTApp
   * Dikabelo Ramashala
   * 8th March 2018
   * RMSDIK001
*/
import java.io.*;
import java.util.Collections;

    /**This application loads information from a parameterised file into a Binary Search Tree, creating a database of dams which,
      *when ran with no arguments, prints out all the dams stored in the Binary Search Tree. The user has to use a console in order
      *to enter in an argument which, when entered, will search for the specified argument in the database.*/
      
public class DamBSTApp{

    
    /**This method is exclusively used in the parseLine method. This method checks the parameterized String for any spaces that are present
      *at the end of the String. If there are any spaces, the space is removed and the process is repeated recursively until there are no spaces at 
      *the end of the String. The method then returns the altered String which will be used accordingly.*/
            
    public static String removeSpaces(String line){
        if(line.equals("")){
            return line;
        }
        else if(line.charAt(line.length() - 1) == ' '){
            String t = line.substring(0, line.length() - 1);
            return removeSpaces(t);
        }
        else if(line.charAt(line.length() - 1) == ' '){
            String s = line.substring(1, line.length());
            return removeSpaces(s);
        }
        return line;
    }
    
    
    /**This method is solely used in the readText method. The method takes the parameterized String and parses it,
      *searching for any commas present in the String and picking up key attributes as it parses the String. These attributes
      *are then used to create and return a new Dam Object with the key attributes that were picked up while the text was being
      *parsed.*/
      
    public static Dam parseLine(String line){
        int propcount = 0;
        int commacounter = 0;
        int comma1 = 0;
        int comma2 = 0;
        String damname = "";
        String damfsc = "";
        String damlvl = "";
        for(int i = 0; i<line.length(); i++){
            int commarecord = 0;
            if(line.charAt(i) == ',' && (comma2 == 0 || comma1 == 0)){
                commacounter++;
                commarecord++;
            
            }
            if((commacounter == 2 || commacounter == 10 || commacounter == 42) && commarecord == 1)
                comma1 = i+1;
            
            if((commacounter == 3 || commacounter == 11 || commacounter == 43) && commarecord == 1){
                String t = line.substring(comma1, i);
                if(propcount == 2){
                    damlvl = t;
                    propcount++;
                }
                if(propcount == 1){
                    damfsc = t;
                    propcount++;
                }
                if(propcount == 0){
                    damname = removeSpaces(t);
                    propcount++;
                }
                if(commacounter == 43){
                    return new Dam(damname, damfsc, damlvl);
                }
            }
        }
        return new Dam();
    }
    

    /**This method uses a parameterized file, and parses the text that is stored in the file to create a Binary Search tree that
      *stores information collected from the file. The parsing process is centred on extracting key values from the parameterized
      *file and then stores these values into an oject, adds them to a Binary Search Tree and returns the created Binary Search Tree.*/
    
    public static BinarySearchTree<Dam> readText(BufferedReader input){
        try{
            String line = "";
            BinarySearchTree<Dam> dams = new BinarySearchTree();
            int linecount = 0; // Counts the number of lines present in the csv file.
            int lnskip = 0;
            String bugline = "";
            while((line = input.readLine()) != null){
                if(lnskip == 0 && Character.isLetter(line.charAt(0))){
                    lnskip++;
                }
                else{
                    if(linecount == 78 || linecount == 81 || linecount == 104 || linecount == 118 || linecount == 148 || linecount == 152){
                    String newline = bugline + line;
                    Dam newdam = parseLine(newline);
                    if(newdam.equals(new Dam()) == false){
                        dams.insert(newdam);
                    }
                        
                    }
                    if(linecount == 77 || linecount == 80 || linecount == 103 || linecount == 117 || linecount == 147 || linecount == 151){
                        bugline = line;
                    }
                    else{
                        Dam newdam = parseLine(line);
                        if(newdam.equals(new Dam()) == false)
                            dams.insert(newdam);
                    }
                linecount++;
                }
            }              
     
    return dams;
    }
    catch(IOException ioe){
        System.out.println(ioe.getMessage());
        System.exit(0);
        return new BinarySearchTree<Dam>();
        }
    }
    
    
    /**This method inserts a new dam object into a BinarySearchTree that is constructed within the method. It then writes the results of the
       insert operation into a file called "insertoutputAVL.txt". The insert isn't a permanent one, but prints out the inserted dam's details
       for the user to see after using the method*/
    
    public static void insertDam(String damdets){
        try{
            String[] Damdetails = damdets.split(",");
            String[] damDets = new String[3];
            for(int i = 0; i<Damdetails.length; i++){
                Damdetails[i] = removeSpaces(Damdetails[i]);
                if(Damdetails[i] == null){
                    Damdetails[i] = "";
                }
                damDets[i] = Damdetails[i];
            }
            for(int i = 0; i<damDets.length; i++){
                if(damDets[i] == null){
                    damDets[i] = "";
                }
            }
            Dam dam = new Dam(damDets[0], damDets[1], damDets[2]);
            String filename = "test/Dam_Levels_Individual_Nov2015-Mar2016.csv";
            String writefile = "outputfileAVL.txt";
            FileReader file = new FileReader(filename);
            FileWriter file2 = new FileWriter(writefile, true);
            BufferedReader input = new BufferedReader(file);
            BinarySearchTree<Dam> dams = readText(input);
            int opcount = 0;
            dams.insert(dam);
            opcount = dams.InsertopCount;
            BinaryTreeNode<Dam> Find = dams.find(dam);
            if(Find == null)
                System.out.println("Insert was not successful. The program will now exit.");
            else{
                System.out.println(Find.data);
                String u = "Output of Insert Instrumentation of DamAVLApp: " + opcount + "\n";
                file2.write(u);
                file2.close();
            
            }
            

        }
        
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        catch(NumberFormatException nfe){
            System.out.println("NumberFormatException detected. Please follow this format when inserting a dam object:\n[Dam Name, Dam FSC (Number), Dam Percent Level (Number)]\n\nN.B. The numbers don't need to be written in a bracket. E.g. Osborne Dam, 14.5841, 79.82156");
        }
    }
    
    /** This is an overloaded version of insertDam method that takes in a new parameter that changes the file that is being used to create the
        data-structure of dams.*/
        
    public static void insertDam(String damdets, String FileName){
        try{
            String[] Damdetails = damdets.split(",");
            String[] damDets = new String[3];
            for(int i = 0; i<Damdetails.length; i++){
                Damdetails[i] = removeSpaces(Damdetails[i]);
                if(Damdetails[i] == null){
                    Damdetails[i] = "";
                }
                damDets[i] = Damdetails[i];
            }
            for(int i = 0; i<damDets.length; i++){
                if(damDets[i] == null){
                    damDets[i] = "";
                }
            }
            Dam dam = new Dam(damDets[0], damDets[1], damDets[2]);
            String filename = FileName;
            String writefile = "InsertoutputfileAVL.txt";
            FileReader file = new FileReader(filename);
            FileWriter file2 = new FileWriter(writefile, true);
            BufferedReader input = new BufferedReader(file);
            BinarySearchTree<Dam> dams = readText(input);
            int opcount = 0;
            dams.insert(dam);
            opcount = dams.InsertopCount;
            BinaryTreeNode<Dam> Find = dams.find(dam);
            if(Find == null)
                System.out.println("Insert was not successful. The program will now exit.");
            else{
                System.out.println(Find.data);
                String u = "Output of Insert Instrumentation of DamAVLApp: " + opcount + "\n";
                file2.write(u);
                file2.close();
            
            }
            
        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        catch(NumberFormatException nfe){
            System.out.println("NumberFormatException detected. Please follow this format when inserting a dam object:\n[Dam Name, Dam FSC (Number), Dam Percent Level (Number)]\n\nN.B. The numbers don't need to be written in a bracket. E.g. Osborne Dam, 14.5841, 79.82156");
        }
    }
    
    /**This method uses the readText method to create a Binary Seach Tree from a file that stores data on different dams and uses
      *it's parameterized value to search the database for a specific dam, returning information regarding the search query.*/
    
    public static void printDam(String damName){
    
        try{
            String filename = "test/Dam_Levels_Individual_Nov2015-Mar2016.csv";
            String writefile = "outputfileBST.txt";
            FileReader file = new FileReader(filename);
            FileWriter file2 = new FileWriter(writefile, true);
            BufferedReader input = new BufferedReader(file);
            BinarySearchTree<Dam> dams = readText(input);
            int opcount = 0;
            Dam d = new Dam(damName, "", "");
            BinaryTreeNode<Dam> Find = dams.find(d);
            if(Find == null)
                System.out.println("Dam does not exist in database. Please make sure that you entered the full name of the queried dam.");
            else{
                System.out.println(Find.data);
                String u = "Output of Instrumentation of DamBSTApp: " + dams.SearchopCount + "\n";
                file2.write(u);
                file2.close();
            
            }
        }
        catch(IOException ioe){
            try{
                File file = new File("outputfileBST.txt");
                FileWriter outputfile = new FileWriter("outputfileBST.txt");
                BufferedWriter bw = new BufferedWriter(outputfile);
                System.out.println("File does not exist in present working directory");
            }
            catch(IOException ioe2){
            }
        }
    }
    /**This method is an overloaded version of the printDam method. Does the exact same thing
       as the original method, but takes in an additional parameter which allows for the loaded file to be changed*/
       
    public static void printDam(String damName, String FileName){
        try{
            int damcounter = 0;
            String filename = FileName;
            String writefile = "outputfileBST.txt";
            FileReader file = new FileReader(filename);
            FileWriter file2 = new FileWriter(writefile, true);
            BufferedReader input = new BufferedReader(file);
            BinarySearchTree<Dam> dams = readText(input);
            int opcount = 0;
            Dam d = new Dam(damName, "", "");
            BinaryTreeNode<Dam> Find = dams.find(d);
            if(Find == null)
                System.out.println("Dam does not exist in database. Please make sure that you entered the full name of the queried dam.\n");
            else{
                System.out.println(Find.data);
                opcount = dams.SearchopCount;
                String u = "Output of Instrumentation of DamBSTApp: " + opcount + "\n";
                file2.write(u);
                file2.close();
            
            }
        }
        catch(IOException ioe){
            try{
                File file = new File("outputfile.txt");
                FileWriter outputfile = new FileWriter("outputfile.txt");
                BufferedWriter bw = new BufferedWriter(outputfile);
                System.out.println("File does not exist in present working directory");
            }
            catch(IOException ioe2){
            }
        }
    }
    
         
     
    /**This method makes use of the readText method to create a Binary Search Tree from a file that stores data on different dams and
      *prints out information of all the dams that are stored in the database.*/
          
    public static void printAllDams(){
        try{
            String filename = "test/Dam_Levels_Individual_Nov2015-Mar2016.csv";
            FileReader file = new FileReader(filename);
            BufferedReader input = new BufferedReader(file);
            BinarySearchTree<Dam> dams = readText(input);
            dams.inOrder();
        }
        catch(IOException ioe){
            System.out.println("File does not exist in present working directory");
        }
    }
    
    /**Main method initializes the application and does different things depending on the presence of an argument*/
    
    public static void main(String[] args){
        if(args.length == 0)
            printAllDams();
        else if(args.length == 2)
            if(args[0].contains(","))
                insertDam(args[0], args[1]);
            else if(args[0].equals("") || args[1].equals(""))
                System.out.println("An empty argument was entered. The program will now exit.");
            else
                printDam(args[0], args[1]);
        else{
            String dam = args[0];
            if(dam.contains(","))
                insertDam(dam);
            else if(dam.equals(""))
                System.out.println("An empty argument was entered. The program will now exit.");
            else
                printDam(dam);
        }
    }
}