
package uhh.lab2;
import java.util.*;
import java.io.*;
/**
 *
 * @author devoncz
 */

//Removed some functions from lab 1 that are not used for lab 2
//I probably missed some of them when deleting though


public class Lab2 {
    
    /** Creates a new instance of Lab2 */
    public Lab2() {
    }
    
    
    /**
       Print a list of nerds.
       @param A list containing GenericNerd objects.
     */
    public static void showNerdList(ArrayList<GenericNerd> list)
    {
        
        if(list.size() == 0)
        {
            System.out.println("\tThere are no nerds.");
        }
        
        for(int i = 0; i < list.size(); i++)
        {
            GenericNerd nerd = list.get(i);
            // note implicit call to nerd.toString() below.
            System.out.println(nerd.type);
            System.out.println(nerd);
            nerd.harass();
            System.out.println("---------------------------------------");
            
        }
        
    }
        
    public static void writeNerdsFile(ArrayList<GenericNerd> list)
    {
        System.out.println();
        System.out.println("ADDING NERDS TO FILE");
        System.out.println();
        
        if(list.size() == 0)
        {
            System.out.println("\tThere are no nerds to add.");
        }
        
        for(int i = 0; i < list.size(); i++)
        {
            GenericNerd nerd = list.get(i);
            nerd.writeNerd(); //Writes the nerds information to the text file
        }
        
        System.out.println();
        System.out.println("FINISHED ADDING NERDS TO FILE");
        System.out.println();
    }
   
    public static void readNerdsFile(ArrayList<GenericNerd> list) //Reads nerd information from the text file, reads a line containing the type of nerd so it knows what information to grab
    {
        
        String name;
        int nerdFactor;
        boolean kirkBetterThanPicard;
        boolean speaksKlingon;
        String costume;
        String consoleName;
        GenericNerd nerd;
        
        try
        {
            File file = new File("nerdRoster.txt");
            Scanner inputFile = new Scanner(file);
            String line;
        
            while(inputFile.hasNext())
            {
                line = inputFile.nextLine();
            
                if(line.contains("Generic"))
                {
                    line = inputFile.nextLine();
                    String[] str = line.split(": ",0);
                    name = str[1];
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    nerdFactor = Integer.parseInt(str[1]);
                    
                    nerd = new GenericNerd("GenericNerd",name, nerdFactor);
                    list.add(nerd); 
                }
                
                else if(line.contains("Trekkie"))
                {
                    line = inputFile.nextLine();
                    String[] str = line.split(": ",0);
                    name = str[1];
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    nerdFactor = Integer.parseInt(str[1]);
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    if(str[1].contains("true"))
                    {
                        kirkBetterThanPicard = true;
                    }
                    else { kirkBetterThanPicard = false; }
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    if(str[1].contains("true"))
                    {
                        speaksKlingon = true;
                    }
                    else { speaksKlingon = false; }
                    
                    
                    nerd = new Trekkie("Trekkie",name, nerdFactor,kirkBetterThanPicard,speaksKlingon);
                    list.add(nerd); 
                }
                
                else if(line.contains("Gamer"))
                {
                    line = inputFile.nextLine();
                    String[] str = line.split(": ",0);
                    name = str[1];
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    nerdFactor = Integer.parseInt(str[1]);
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    consoleName = str[1];
                    
                    nerd = new GamerGeek("GamerGeek",name, consoleName, nerdFactor);
                    list.add(nerd); 
                }
                
                else if(line.contains("Cosplay"))
                {
                    line = inputFile.nextLine();
                    String[] str = line.split(": ",0);
                    name = str[1];
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    nerdFactor = Integer.parseInt(str[1]);
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    if(str[1].contains("true"))
                    {
                        kirkBetterThanPicard = true;
                    }
                    else { kirkBetterThanPicard = false; }
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    if(str[1].contains("true"))
                    {
                        speaksKlingon = true;
                    }
                    else { speaksKlingon = false; }
                    
                    line = inputFile.nextLine();
                    str = line.split(": ",0);
                    costume = str[1];
                    
                    nerd = new CosPlayTrekkie("CosPlayTrekkie",name, nerdFactor,kirkBetterThanPicard,speaksKlingon,costume);
                    list.add(nerd); 
                }
            
        }
      
        inputFile.close(); 
        
        }
        catch (Exception e)
                {
                System.out.println("Error");
                }
        
    }
    
    public static void EditNerds(ArrayList<GenericNerd> list)
    {
        int nerdCount = 1;
       
        for(int i = 0; i < list.size(); i++)
        {
            GenericNerd nerd = list.get(i);
            
            if(i == 2) //Gets the 3rd and 7th nerd from the arraylist and modifies their information before rewriting the text file
            {
                nerd.name = "Phineas Q. Arbuckle";
                list.set(2,nerd);
            }
            else if(i == 6)
            {
                nerd.name = "Booger McStickyfingers";
                list.set(6,nerd);
            }
        }
        try {PrintWriter outputFile = new PrintWriter("nerdroster.txt"); }//Empties the file on run}
        catch (Exception e) { System.out.println("Failed to open file"); }
        writeNerdsFile(list);

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
        PrintWriter outputFile = new PrintWriter("nerdroster.txt"); }//Empties the file on run, for testing stuff
        catch (Exception e) { System.out.println("Failed to create file"); }
        // TODO code application logic here
        
        //System.out.println("<<< CS 420 Lab 1 Test Code. >>>");
        
        // List to keep a few nerds in
        ArrayList<GenericNerd> nerdList = new ArrayList(10);
        
        
        
        // create a few nerds and add them to the list
        GenericNerd nerd = new GenericNerd("GenericNerd","Nerdy Nerd", 9);
        nerdList.add(nerd);
        // This will generate a warning message:
        nerd = new GenericNerd("GenericNerd","Lame-o Lamerson", 12);
        nerdList.add(nerd);
        
        
        // POLYMORPHISM IN ACTION!!!
        nerd = new Trekkie("Trekkie","Captain Spazz", 3,false,true);
        nerdList.add(nerd);
        nerd = new CosPlayTrekkie("CosPlayTrekkie","Glenn", 4, true, true, "Borg drone");
        nerdList.add(nerd);
        nerd = new Trekkie("Trekkie","Lt. Commander Loser", 10,true,true);
        nerdList.add(nerd);
        // generate another warning (Klingon speaker of a low level)
        nerd = new Trekkie("Trekkie","Deanna Troi fanboy", 6,true,false);
        nerdList.add(nerd);
        // round out the list with a few more various nerds
        nerd = new GenericNerd("GenericNerd","Baron Ron von Dorkenstein", 10);
        nerdList.add(nerd);
        nerd = new GenericNerd("GenericNerd","Donnie Doofus", 8);
        nerdList.add(nerd);
        
        nerd = new GamerGeek("GamerGeek","PC Gamer", "PC", 8);
        nerdList.add(nerd);
        nerd = new GamerGeek("GamerGeek","PS5 Gamer", "Xbox Series X", 10);
        nerdList.add(nerd);
        
        nerd = new CosPlayTrekkie("CosPlayTrekkie","Joe Mother", 7, false, true, "Vulcan");
        nerdList.add(nerd);
        nerd = new GamerGeek("GamerGeek","Xbox Gamer", "PS5", 3);
        nerdList.add(nerd);
        nerd = new CosPlayTrekkie("CosPlayTrekkie","Jimmy", 10, true, false, "Klingon");
        nerdList.add(nerd);
        
        
        writeNerdsFile(nerdList);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nerd Roster created, press return to continue...");
        String s = keyboard.nextLine();
        
        ArrayList<GenericNerd> nerdList2 = new ArrayList(10);
        readNerdsFile(nerdList2);
        
        showNerdList(nerdList2);
        
        keyboard = new Scanner(System.in);
        System.out.println("Nerd Roster scanned, press return to continue...");
        s = keyboard.nextLine();
        
        EditNerds(nerdList2);
        
    }
    
}

