// Test program
// Dikabelo Ramashala
// RMSDIK001
// 144th March 2018

import java.io.*;
import java.util.Scanner;

public class TestDams{
    
    public static int options(String op){
        Scanner abc = new Scanner(System.in);
        System.out.println("How would you like to run the " + op + " operation?\n1.) Using a preset test file\n2.) Using a file that you specify to run the tests (make sure that it's in the right format or the program won't work)\n3.) Entering a list of values which will then be used for the " + op + " operation.\n4.) Exit");
        int a = 0;
        a = abc.nextInt();
        if(a != 1 || a != 2 || a != 3){
            return a;
        }
        else{
            System.out.println("Invalid input. The program will now exit.");
            System.exit(0);
        }
        return -1;
    }
    
    /**Main method that initializes the program*/
    
    public static void main(String[] args){
        System.out.println("Welcome to the TestDams program. This program is used to test all the dam apps present in the working diretory. \nWhat would you like to test today?\n1.) Search Operations\n2.) Insert Operations\n3.) Exit");
        Scanner inp = new Scanner(System.in);
        int o = inp.nextInt();
        int treetype = -1;
        try{
            if(o == 1){
                    int opt1 = options("search");
                    if(opt1 == 4){
                        System.out.println("Thank you for using the TestDams program. Have a good day :^)");
                        System.exit(0);
                    }
                    System.out.println("Which Data Structure would you like to test?\n1.) Binary Search Tree\n2.) AVL Tree\n3.) Both");
                    treetype = inp.nextInt();
                    if(opt1 == -1){
                        System.out.println("Eish dawg, it looks like you broke the program. That number doesn't work here.");
                        System.exit(0);
                        
                    }
                    if(opt1 == 1){
                            int works = 0;
                            for(int i = 1; i < 9; i++){
                                String subset = "test/subset" + i;
                                if(i == 8){
                                    subset = "test/ArrangedDam.csv";
                                }
                                String filename = "test/searchtestvalues";
                                FileReader file = new FileReader(filename);
                                BufferedReader input = new BufferedReader(file);
                                String line = "";
                                if(treetype == 1){
                                    works++;
                                    System.out.println("Result for Binary Search Tree:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamBSTApp.main(arg);
                                    }
                                        System.out.println("Instrumentation for all search operations have been printed to the outputfileBST.txt file.");
                                }
                                else if(treetype == 2){
                                    works++;
                                    System.out.println("Result for AVL Tree:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamAVLApp.main(arg);
                                    }
                                    System.out.println("Instrumentation of all search operations have been printed to the outputfileAVL.txt file.");
                                }
                                else if(treetype == 3){
                                    works++;
                                    System.out.println("Results for respective Trees:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamAVLApp.main(arg);
                                        DamBSTApp.main(arg);
                                    }
                                    System.out.println("Instrumentation of all search operations have been printed to each respective output file:\n(Binary Search Tree -> outputfileBST.txt / AVL Tree -> outputfileAVL.txt)");
                                        
                                    
                                }
                            }
                            if(works == 0){
                                System.out.println("Eish man, if you don't use the right input, the program won't work :/");
                                System.exit(0);
                            }        
                            
                        }         
                        else if(opt1 == 2){
                            int works = 0;
                            System.out.println("Please enter the name/directory of the file that will be used (Tested subsets will be loaded in automatically):");
                            String bfile = "";
                            bfile = inp.nextLine();
                            bfile = inp.nextLine();
                            for(int i = 1; i < 8; i++){
                                String subset = "test/subset" + i;
                                String filename = bfile;
                                FileReader file = new FileReader(filename);
                                FileReader file2 = new FileReader(filename);
                                BufferedReader input = new BufferedReader(file);
                                BufferedReader input2 = new BufferedReader(file2);
                                String line = "";
                                String line2 = "";
                                if(treetype == 1){
                                    works++;
                                    System.out.println("Result for Binary Search Tree:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamBSTApp.main(arg);
                                    }
                                        System.out.println("Instrumentation for all search operations have been printed to the outputfileBST.txt file.\n");
                                }
                                else if(treetype == 2){
                                    works++;
                                    System.out.println("Result for AVL Tree:");
                                    
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamAVLApp.main(arg);
                                    }
                                    System.out.println("Instrumentation of all search operations have been printed to the outputfileAVL.txt file.\n");
                                }
                                else if(treetype == 3){
                                    works++;
                                    System.out.println("Results for respective Trees:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamAVLApp.main(arg);
                                        DamBSTApp.main(arg);
                                    }
                                    System.out.println("Instrumentation of all search operations have been printed to each respective output file:\n(Binary Search Tree -> outputfileBST.txt / AVL Tree -> outputfileAVL.txt)\n");
                                        
                                    
                                }
                            }
                            if(works == 0){
                                System.out.println("Eish man, if you don't use the right input, the program won't work :/");
                                System.exit(0);
                            }
                        }        
                        else if(opt1 == 3){
                            System.out.println("Please enter the names of the dams that will be searched in the subsets, and press enter to register the entry into the\nsearch. To end the list, type in \"end\" and press enter to continue:");
                            String[] inlist = new String[1000];
                            int pos = 0;
                            int size = 0;
                            String vals = "";
                            while(vals.equals("end") != true){
                                vals = inp.nextLine();
                                if(vals.equals("end")){
                                    break;
                                }
                                else if(vals.equals("")){
                                    continue;
                                }
                                else{
                                    inlist[pos] = vals;
                                    size++;
                                    pos++;
                                }
                            }
                            String[] list = new String[size];
                            for(int i = 0; i<size; i++){
                                list[i] = inlist[i];
                            }
                            for(int i = 1; i<8; i++){
                                String subset = "test/subset" + i;
                                for(String r: list){
                                   String[] arg = new String[2];
                                   arg[0] = r;
                                   arg[1] = subset;
                                    if(treetype == 1){
                                        DamBSTApp.main(arg);
                                    }
                                    else if(treetype == 2){
                                        DamAVLApp.main(arg);
                                    }
                                    else if(treetype == 3){
                                        DamBSTApp.main(arg);
                                        DamAVLApp.main(arg);
                                    }
                                    else{
                                        System.out.println("I think you entered something funny when you were selecting the data structure that was gonna be tested. Now the program won't work.");
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                        
                        else if(opt1 == 4){
                            System.out.println("Thank you for using the TestDams program. Have a good day :^)");
                            System.exit(0);
                        }
                        else{
                            System.out.println("Eish man, if you don't use the right input, the program won't work :/");
                            System.exit(0);
                        }
                        
                    }
                else if(o == 2){
                    int opt2 = options("insert");
                    if(opt2 == 4){
                        System.out.println("Thank you for using the TestDams program. Have a good day :^)");
                        System.exit(0);
                    }
                    System.out.println("Which Data Structure would you like to test?\n1.) Binary Search Tree\n2.) AVL Tree\n3.) Both");
                    treetype = inp.nextInt();
                    if(opt2 == -1){
                        System.out.println("Eish dawg, it looks like you broke the program. That number doesn't work here.");
                        System.exit(0);
                        
                    }
                    if(opt2 == 1){
                            int works = 0;
                            for(int i = 1; i < 8; i++){
                                String subset = "test/subset" + i;
                                String filename = "test/inserttestvalues";
                                FileReader file = new FileReader(filename);
                                FileReader file2 = new FileReader(filename);
                                BufferedReader input = new BufferedReader(file);
                                BufferedReader input2 = new BufferedReader(file);
                                String line = "";
                                String line2 = "";
                                if(treetype == 1){
                                    works++;
                                    System.out.println("Result for Binary Search Tree:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamBSTApp.main(arg);
                                    }
                                        System.out.println("Instrumentation for all insert operations have been printed to the outputfileBST.txt file.");
                                }
                                else if(treetype == 2){
                                    works++;
                                    System.out.println("Result for AVL Tree:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamAVLApp.main(arg);
                                    }
                                    System.out.println("Instrumentation of all insert operations have been printed to the outputfileBST.txt file.");
                                }
                                else if(treetype == 3){
                                    works++;
                                    System.out.println("Results for respective data structures:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamAVLApp.main(arg);
                                        DamBSTApp.main(arg);
                                    }
                                    System.out.println("Instrumentation of all insert operations have been printed to each respective output file:\n(Binary Search Tree -> outputfileBST.txt / AVL Tree -> outputfileAVL.txt)");
                                        
                                    
                                }
                            }
                            if(works == 0){
                                System.out.println("Eish man, if you don't use the right input, the program won't work :/");
                                System.exit(0);
                            }        
                            
                        }         
                        else if(opt2 == 2){
                            int works = 0;
                            System.out.println("Please enter the name/directory of the file that will be used (Tested subsets will be loaded in automatically):");
                            String bfile = "";
                            bfile = inp.nextLine();
                            bfile = inp.nextLine();
                            for(int i = 1; i < 8; i++){
                                String subset = "test/subset" + i;
                                String filename = bfile;
                                FileReader file = new FileReader(filename);
                                FileReader file2 = new FileReader(filename);
                                BufferedReader input = new BufferedReader(file);
                                BufferedReader input2 = new BufferedReader(file2);
                                String line = "";
                                String line2 = "";
                                if(treetype == 1){
                                    works++;
                                    System.out.println("Result for Binary Search Tree:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamBSTApp.main(arg);
                                    }
                                        System.out.println("Instrumentation for all insert operations have been printed to the outputfileBST.txt file.\n");
                                }
                                else if(treetype == 2){
                                    works++;
                                    System.out.println("Result for AVL Tree:");
                                    
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamAVLApp.main(arg);
                                    }
                                    System.out.println("Instrumentation of all insert operations have been printed to the outputfileAVL.txt file.\n");
                                }
                                else if(treetype == 3){
                                    works++;
                                    System.out.println("Results for respective Trees:");
                                    while((line = input.readLine()) != null){
                                        String[] arg = new String[2];
                                        arg[0] = line;
                                        arg[1] = subset;
                                        DamAVLApp.main(arg);
                                        DamBSTApp.main(arg);
                                    }
                                    System.out.println("Instrumentation of all insert operations have been printed to each respective output file:\n(Binary Search Tree -> outputfileBST.txt / AVL Tree -> outputfileAVL.txt)\n");
                                        
                                    
                                }
                            }
                            if(works == 0){
                                System.out.println("Eish man, if you don't use the right input, the program won't work :/");
                                System.exit(0);
                            }
                        }        
                        else if(opt2 == 3){
                            System.out.println("Please enter the details of the dams that will be inserted into the subsets, and press enter to register the entry into the\ninsert process. To end the list, type in \"end\" and press enter to continue.\nEntry Format -> Dam Name, Dam FSC (Number), Dam Percentage Level (Number):");
                            String[] inlist = new String[1000];
                            int pos = 0;
                            int size = 0;
                            String vals = "";
                            while(vals.equals("end") != true){
                                vals = inp.nextLine();
                                if(vals.equals("end")){
                                    break;
                                }
                                else if(vals.equals("")){
                                    continue;
                                }
                                else{
                                    inlist[pos] = vals;
                                    size++;
                                    pos++;
                                }
                            }
                            String[] list = new String[size];
                            for(int i = 0; i<size; i++){
                                list[i] = inlist[i];
                            }
                            for(int i = 1; i<8; i++){
                                String subset = "test/subset" + i;
                                for(String r: list){
                                   String[] arg = new String[2];
                                   arg[0] = r;
                                   arg[1] = subset;
                                    if(treetype == 1){
                                        DamBSTApp.main(arg);
                                    }
                                    else if(treetype == 2){
                                        DamAVLApp.main(arg);
                                        System.out.println("Instrumentation of all insert operations have been printed to the outputfileAVL.txt file.\n");
                                    }
                                    else if(treetype == 3){
                                        DamBSTApp.main(arg);
                                        DamAVLApp.main(arg);
                                        System.out.println("Instrumentation of all insert operations have been printed to each respective output file:\n(Binary Search Tree -> outputfileBST.txt / AVL Tree -> outputfileAVL.txt)\n");
                                    }
                                    else{
                                        System.out.println("I think you entered something funny when you were selecting the data structure that was gonna be tested. Now the program won't work.");
                                        System.exit(0);
                                    }
                                }
                            
                            }
                           
                        }
                        
                        else if(opt2 == 4){
                            System.out.println("Thank you for using the TestDams program. Have a good day :^)");
                            System.exit(0);
                        }
                        else{
                            System.out.println("Eish man, if you don't use the right input, the program won't work :/");
                            System.exit(0);
                        }
                        
                }
                
                else if(o == 69){
                    System.out.println("The hen number. Didn't think you'd actually try this input in the beginning. Have you seen the rest of the error messages yet?");
                    System.exit(0);
                }
                
                else if(o == 404){
                    System.out.println("I'll let you in on a secret. This program has a number of different error messages. Do you think you can find them all?");
                    System.exit(0);
                }
                
                else if(o == 1337){
                    System.out.println("Welcome to the hidden secret level of this program. As you can see, there is nothing here for you to find. \nIf you got this the first try, you should feel good about yourself. If not,you should still feel good about yourself cause you just got memed :^].");
                    System.exit(0);
                }
                
                else if(o == 7){
                    System.out.println("I know you came here after getting the \"Error 404\" message. It means that the file you're trying to use cannot be found (if you\nfound this out of curiousity, come find me and I'll get you a beer Kappa).");
                    System.exit(0);
                }
                else if(o != 3){
                    System.out.println("Hmmmmmm, wrong input, the program will exit now. :/");
                    System.exit(0);
                }
            System.out.println("\nThank you for using the TestDams program. Have a good day :^)");        
        }
        catch(IOException ioe){
            System.out.println("Error 404. Pretty sure you know what this means (if not, then enter the number 7 at the beginning of the program)");
            System.exit(0);
        }
        catch(NumberFormatException nfe){
            System.out.println("Eh, so you don't know how to type in a number? Now you broke the program -.-");
            System.exit(0);
        }
    }
}