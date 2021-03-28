public class ValidDate{

     public static void main(String []args){
        isValidDate(31, 04, 2000);
     }
     
     private static void isValidDate(int date, int month, int year) {
         int maxDate = 31;
         boolean leapYear = isLeapYear(year);
         if (month >= 1 && month <= 12) {
             if (month == 2 && leapYear) {
                 maxDate = 29;
             } else if (month == 2 && !leapYear) {
                 maxDate = 28;
             } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                 maxDate = 30;
             }
             if (date >= 1 && date <= maxDate) {
                 System.out.println("Valid");
                 return;
             }
         }
         System.out.println("Invalid");
     }
     
     private static boolean isLeapYear(int year) {
         /*
        1. If the year is evenly divisible by 4, go to step 2. Otherwise, go to step 5.
        2. If the year is evenly divisible by 100, go to step 3. Otherwise, go to step 4.
        3. If the year is evenly divisible by 400, go to step 4. Otherwise, go to step 5.
        4. The year is a leap year (it has 366 days).
        5. The year is not a leap year (it has 365 days).
         */
         if (year % 4 == 0 && ((year % 100 != 0) || (year % 100 == 0 && year % 400 == 0))) {
             return true;
         }
         return false;
     }
}