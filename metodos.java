public static int puntosCPU() {
   	System.out.println("CPU lanza el dado al aire ...");
        Thread.sleep(DELAY);                        
        tiradaCPU = numeroAleatorio(6,1);
        System.out.println("\n?????");               
        System.out.println("? " + tiradaCPU + " ?");               
        System.out.println("?????\n");   
        System.out.println("La puntuación actual de la CPU es " +puntosCPU);
        return puntosCPU;
   }
   
   public static int puntosJugador() {
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
   
   public static int numeroAleatorio(int max, int min) {
   	Random r = new Random();
   	int numAlea = r.nextInt(max - min + 1) + min;
   	return numAlea;
   }
   
    public static int once(int porras) {

      System.out.println("\n$$$$$$$$$$$$$$$$");
      System.out.println("$$$$ ¡ONCE! $$$$");
      System.out.println("$$$$$$$$$$$$$$$$");
      System.out.println("\nDoble porra para CPU\n");
       
    } 
    public static int menu(int opcion){
         System.out.println("***************************");
         System.out.println("*** JUEGO DE DADOS ONCE ***");
         System.out.println("***************************");
         System.out.println("1. Nueva partida ...");
         System.out.println("0. Salir");
         System.out.print("\nElige una opción: ");
         return opcion = Integer.parseInt(lector.nextLine());
    }






