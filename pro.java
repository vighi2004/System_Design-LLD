public class pro {
   public static void main(String[] args) {
     for(int i=1;i<=30;i++){
         if(i/10==3 || i%10==3){
            System.out.println("it is 3");
         }
         else if(i%5==0){
             System.out.println("divisible by 5");
         }
         else if(i%5==0 && i%3==0){
             System.out.println("divisible by 5 and 3");
         }
         else{
            System.out.println(i);
         }
     }
   }
}
