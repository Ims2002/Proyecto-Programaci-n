import java.util.Scanner;
import java.util.Random;
public class Ejercicio16 {
   public static void main(String[] args) throws InterruptedException {
      final int DELAY = 500;
      Random r = new Random();
      Scanner lector = new Scanner(System.in);     
      boolean plantado = false;
      int tiradaPlayer;
      int puntosPlayer = 0;
      int porrasPlayer = 0;
      int tiradaCPU;
      int puntosCPU = 0;
      int porrasCPU = 0;
      int opcion;
      char plantarse;

      do {
         System.out.println("***************************");
         System.out.println("*** JUEGO DE DADOS ONCE ***");
         System.out.println("***************************");
         System.out.println("1. Nueva partida ...");
         System.out.println("0. Salir");
         System.out.print("\nElige una opción: ");
         opcion = Integer.parseInt(lector.nextLine());
         if(opcion == 1) {
            porrasCPU = 0;
            porrasPlayer = 0;
            puntosCPU = 0;
            puntosPlayer = 0;
            do {      
               tiradaJugador();
               if(puntosPlayer < 11) {
                  tePlantas()
                     //Ahora la CPU intenta igualar o mejorar el resultado del jugador
                     while(puntosCPU < puntosPlayer) {
                        tiradaCPU();
                     }
                     if(puntosCPU > 11) {
                        sePasaCpu();
                     } else if(puntosCPU > puntosPlayer) { // Gana CPU
                        if(puntosCPU == 11) {
                           dosPorrasCpu();
                        } else {
                           porraCpu();      
                        }
                        puntosCPU = 0;
                        puntosPlayer = 0;
                     } else { // Empate
                        System.out.println("Empate!! Porra para los dos");
                        puntosCPU = 0;
                        puntosPlayer = 0;
                        porrasCPU++;
                        porrasPlayer++;                          
                     }
                     
                     resultTirada(porrasCPU, porrasPlayer);
                  }
               } else if (puntosPlayer == 11) {                  
                  dosPorrasPersona();
                  
                  resultTirada(porrasCPU, porrasPlayer);
               } else {
                  //El jugador se ha pasado
                  sePasaPersona();
               }
               
            } while(porrasPlayer < 5 && porrasCPU < 5);
            if(porrasCPU >= 5) {
               System.out.println("\nCPU gana la partida!!! por " + porrasCPU + " porras a "+ porrasPlayer +"\n");
            } else if(porrasPlayer >= 5) {
               System.out.println("\nPlayer gana la partida!!! por " + porrasPlayer + " porras a " + porrasCPU +"\n");
            }
         }
      } while(opcion != 0);
      System.out.println("Hasta pronto!!");
   }
   public static int tiradaCPU() {
   	System.out.println("CPU lanza el dado al aire ...");
        Thread.sleep(DELAY);                        
        tiradaCPU = numeroAleatorio(6,1);
        System.out.println("\n?????");               
        System.out.println("? " + tiradaCPU + " ?");               
        System.out.println("?????\n");                        
        System.out.println("La puntuación actual de la CPU es " +puntosCPU);
        return puntosCPU;
   }
   
   public static int tiradaJugador() {
   	System.out.println("Jugador lanza el dado al aire ...");
        Thread.sleep(DELAY);
        tiradaPlayer = numeroAleatorio(6,1);
        System.out.println("\n*****");               
        System.out.println("* " + tiradaPlayer + " *");               
        System.out.println("*****");               
        puntosPlayer += tiradaPlayer;               
        System.out.println("\nTu puntuación actual es " + puntosPlayer);
        return puntosPlayer;
   }
   public static int dosPorrasPersona() {
      //Al obtener 11 el jugador suma automáticamente 2 porras
      porrasPlayer += 2;
      puntosCPU = 0;
      puntosPlayer = 0;
      once();
   
   public static int numeroAleatorio(int max, int min) {
   	Random r = new Random();
   	int numAlea = r.nextInt(max - min + 1) + min;
   	return numAlea;
   }
   public static void tePlantas() {
         System.out.print("¿Deseas plantarte con " + puntosPlayer +" puntos? (s/n): ");
         plantarse = lector.nextLine().charAt(0); 
         plantado =  plantarse == 's' || plantarse == 'S';
         if(plantado) {
               plantado = false;
         }
   }
   
   public static void sePasaPersona() { 
         System.out.println("Ohh!! Te has pasado");
         System.out.println("Porra para la CPU");                  
         porrasCPU += 1;
         puntosCPU = 0;
         puntosPlayer = 0;
         resultTirada(porrasCPU, porrasPlayer);
         return porrasCPU;
   }
   public static int sePasaCpu() {
      System.out.println("CPU se ha pasado. Porra para Player!!");
      porrasPlayer++;
      puntosCPU = 0;
      puntosPlayer = 0;
      return porrasPlayer;
   }
   public static int dosPorrasCpu() {
      once();
      porrasCPU += 2;
      return porrasCPU;
   }
   public static int porraCpu() {
      System.out.println("CPU ha mejorado tu puntuación. Porra para CPU!!");
      porrasCPU++;
      return porrasCPU;
   }

   public static void resultTirada(int porrasCPU, int porrasPlayer){
       Scanner lector = new Scanner(System.in);
       System.out.println("\n**********************");
        System.out.println("* " + porrasPlayer + " PLAYER  -  CPU " +porrasCPU + " *");
        System.out.println("**********************");
        System.out.print("\nPulsa intro para continuar...");
        lector.nextLine();
    }
    public static void once(){
        System.out.println("\n$$$$$$$$$$$$$$$$");
        System.out.println("$$$$ ¡ONCE! $$$$");
        System.out.println("$$$$$$$$$$$$$$$$");
    }
}

