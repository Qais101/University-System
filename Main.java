import java.util.*;
public class Main {
    public static void main(String args[])
    {
    Scanner in=new Scanner(System.in);
   
        System.out.print("Enter student name: ");
        String name = in.nextLine();
        Student s1 = new Student(name);

        System.out.print("How many subjects to register? ");
        int subjectCount = in.nextInt();
        in.nextLine();

        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter subject " + (i + 1) + " name: ");
            String subject = in.nextLine();

            System.out.print("Enter credit hours for " + subject + ": ");
            int hours = in.nextInt();
            in.nextLine(); 
            s1.registerSubject(subject, hours);
        }
        
        
        System.out.println("Enter Your Major : ");
        String studentMajor=in.nextLine();
        s1.setMajor(studentMajor);
        
        
        
          Random rand=new Random();
  String ID=String.format("%06d",rand.nextInt(10000000));
  System.out.println("Your generated ID for you : "+ID);
  
 
  
  
  
    
//    while(true)
//    {
//        System.out.println("Set a 4-digit PIN for your account : ");
//        cPIN=in.next();
//        if(cPIN.matches("\\d{4}")){
//        break;
//        }
//        else{
//            System.out.println("Invalid PIN. Please enter exactly 4 digits.");
//        }

              Random rand2=new Random();
  String cPIN=String.format("%04d",rand2.nextInt(10000));
System.out.println("Generated PIN for your account : "+cPIN);      
  
    
    int ePIN;
    int attempts=3;
    boolean accessGranted = false;
    while(attempts>0)
    {
        System.out.println("Enter 4-Digits PIN : ");
          ePIN=in.nextInt();
        if(ePIN==Integer.parseInt(cPIN))
        {
            System.out.println("Access granted, Welcome "+s1.getStudentName()+"!");
         accessGranted = true;
         break;
        }
        else
        {
        attempts--;
            System.out.println("Incorrect PIN, Attempts left : "+attempts);
         
        }
  
    } 
    if(!accessGranted){
         System.out.println("Access denied. You have used all attempts.");
    }
  else
    {
  int choice;
  do
  {
      System.out.println("---- University ----");
      System.out.println("1. Calculate GPA");
      System.out.println("2. Register Subjects");
      System.out.println("3. Suggestions");
      System.out.println("4. Student Info");
      System.out.println("0. Exit");
      System.out.println("Enter your choice: ");
      choice=in.nextInt();
      in.nextLine();
      
      switch(choice)
      {
          case 1:
              s1.calcGPA();
              break;
              
          case 2:
              System.out.println("How many subjects to register? ");
              int count=in.nextInt();
              in.nextLine();
              for(int i=0;i<count;i++)
              {
                  System.out.println("Enter Subject Name : ");
                  String sub = in.nextLine();
                  System.out.println("Enter Credit Hours : ");
                  int h = in.nextInt();
                  in.nextLine();
                  s1.registerSubject(sub,h);
              }
                break;

          case 3:
              System.out.println("s");
              
          case 4:
              s1.displayInfo();
              break;
              
          case 0:
              System.out.println("Exiting... ");
              break;
          default: 
              System.out.println("Invalid Choice!");
              }
          
              }           
      
      while(choice!=0);
  }
    in.close();
    }
}
