public class IntroToDSELabs {
   public static void callMethodNamed(LabPrinter printer, String methodName) {
      switch (methodName) {
         case "print2Plus2":
            printer.print2Plus2();
            break;
         case "printSecret":
            printer.printSecret();
            break;
         default: 
            System.out.printf("Unknown method: %s%n", methodName);
      // Only implement this method after completing step 1
      }
   }
   
   public static void main(String[] args) {
      LabPrinter printer = new LabPrinter("abc");
      
      callMethodNamed(printer, "print2Plus2");
      callMethodNamed(printer, "printPlus2");
      callMethodNamed(printer, "printSecret");
   }
}
