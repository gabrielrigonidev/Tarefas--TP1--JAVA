public class Tabua {

   public static void somarZ(int respNum) {
      int[][] matrizZ = new int[respNum][respNum];

      for (int l = 0; l < respNum; l++){
         for (int c = 0; c < respNum; c++){
            matrizZ[l][c] = c;
            matrizZ[l][c] = l + c;
            for (int i = 0; i <= respNum; i++) {
               if (matrizZ[l][c] % respNum == i) {
                  matrizZ[l][c] = i;
               }
            }
            System.out.print("Z" + respNum + " = " + "/" + matrizZ[l][c] + " | ");
         }
         System.out.println();
      }
   }
   public static void multZ(int respNum){
      int[][] matrizZ = new int[respNum][respNum];

      for (int l = 0; l < respNum; l++){
         for (int c = 0; c < respNum; c++){
            matrizZ[l][c] = c;
            matrizZ[l][c] = l * c;
            for (int i = 0; i <= respNum; i++) {
               if (matrizZ[l][c] % respNum == i) {
                  matrizZ[l][c] = i;
               }
            }
            System.out.print("Z" + respNum + " = " + "/" + matrizZ[l][c] + " | ");
         }
         System.out.println();
      }
   }
}