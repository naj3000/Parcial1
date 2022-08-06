
package pkgcomisiones;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class ClsComisiones {
   
   static int total=0;
    private static String[][] comisiones = new String[5][11];
    
    private static final int NOMBRE=0;
    private static final int ENERO=1;
    private static final int FEBRERO=2;
    private static final int MARZO=3;
    private static final int ABRIL=4;
    private static final int TOTALVENTAS=5;
    private static final int COMISION1=6;
    private static final int COMISION2=7;
    private static final int FINALVENTA=8;
    private static final int ISR=9;
    private static final int TOTAL=10;
    
    public static void cargaInformacion(int fila){

        Scanner t= new Scanner(System.in);
         try{

            System.out.println("Ingrese Nombre"+(fila+1));
        comisiones[fila][NOMBRE]= t.nextLine();
        
        inicializar();

        }

        catch (Exception e) { System.out.println("error ingresa un numero");  }
        
        
       
    }
    public static void imprimirDecorado(){
        for (int x=0; x< comisiones.length;x++){
            System.out.print("|");
             for(int y=0;y < comisiones[x].length;y++){
                 System.out.print(comisiones[x][y]);
                 if (y != comisiones[x].length -1){
                     System.out.print("\t");
                 }
             }
             System.out.println("|");
        }
    }
      static void inicializar(){
         Random r = new Random();
        for(int i=0;i<5;i++){
            for(int j=1;j<5;j++){
                
                    int p = r.nextInt(50, 1000);
                    
                    comisiones[i][j] = String.valueOf(p); 
                
                }
                 
                
                    
 
                }
                
            }
        

    public static void Calculos(){
        int total=0;
        int m=0;
        for(int i=0; i<5; i++){
            total= Integer.parseInt(comisiones[i][ENERO]);
            total= total + Integer.parseInt(comisiones[i][FEBRERO]);
            total= total + Integer.parseInt(comisiones[i][MARZO]);
            total= total + Integer.parseInt(comisiones[i][ABRIL]);
            comisiones[i][TOTALVENTAS]= String.valueOf(total);
           
             if (total < 2001 ){
            
            comisiones[i][COMISION1]= String.valueOf((total*20)/100);
           
            comisiones[i][FINALVENTA]=String.valueOf( total-((total*20)/100));
            comisiones[i][ISR]=String.valueOf((total*5)/100);
            comisiones[i][TOTAL]=String.valueOf(total-((total*20)/100)+((total*5)/100));
            
        
             }
             else {
             
             comisiones[i][COMISION2]=String.valueOf((total*35)/100);
             comisiones[i][FINALVENTA]=String.valueOf( total-((total*35)/100));
             comisiones[i][ISR]=String.valueOf((total*5)/100);
            comisiones[i][TOTAL]=String.valueOf(total-(((total*35)/100)+((total*5)/100)));
            
               
             }
              if(comisiones[i][COMISION1]== null){
comisiones[i][COMISION1]="0";
        }
               if(comisiones[i][COMISION2]== null){
comisiones[i][COMISION2]="0";
          
} 
    }}
    public static void ingresoDatos(){
        for(int i=0; i<5; i++){
            cargaInformacion(i);
            
        }}
    
     public static void maximo() {
         String ven="", ven1="";
       int mayor=0, m=0;
       
for(int i=0; i<5; i++){
 
for(int j=0; j<5; j++){
 
if(Integer.parseInt(comisiones[i][COMISION1])>mayor){
mayor=Integer.parseInt(comisiones[i][COMISION1]); 
ven = comisiones[i][COMISION1-6];
} 
}


}
for(int i=0; i<5; i++){
 
for(int j=0; j<5; j++){
 
if(Integer.parseInt(comisiones[i][COMISION2])>m){
m=Integer.parseInt(comisiones[i][COMISION2]); 
ven1 = comisiones[i][COMISION2-7];
} 
}


}
if(m>mayor){
System.out.println("EL VENDEDOR CON MAYOR COMISION ES " + ven1 );
}
else
    {
System.out.println("EL VENDEDOR CON MENOR COMISION ES " + ven   );
}
}
  public static void menor() {
  String ven="", ven1="";
		
		int mayor = Integer.parseInt(comisiones[0][COMISION1]), menor = Integer.parseInt(comisiones[0][COMISION2]); // suponemos que ambos están en la primer posición

		
		for (int x = 0; x < comisiones.length; x++) {
			for (int y = 0; y < comisiones[x].length; y++) {
				int numeroActual = Integer.parseInt(comisiones[x][COMISION1]);
                                int numeroActua = Integer.parseInt(comisiones[x][COMISION2]);
                                
				if ( Integer.parseInt(comisiones[x][COMISION1])<menor && Integer.parseInt(comisiones[x][COMISION1]) != 0 || menor == 0) {
          menor = Integer.parseInt(comisiones[x][COMISION1]);
         
       }
                                
				if ( Integer.parseInt(comisiones[x][COMISION2])<mayor && Integer.parseInt(comisiones[x][COMISION2]) != 0 || mayor == 0) {
          mayor = Integer.parseInt(comisiones[x][COMISION2]);
        
       }
			}
                        ven = comisiones[x][COMISION1-6];
                         ven1 = comisiones[x][COMISION2-7];
		}
		
                if(menor<mayor){
System.out.println("EL VENDEDOR CON MENOR COMISION ES  " + ven  );
}
else
    {
System.out.println("EL VENDEDOR CON MENOR COMISION ES  " + ven1);
}
               
  }
        
    
        
         public static void menu(){
         
       Scanner sn = new Scanner(System.in);
       boolean salir = false;
       int opcion; 
        
       while(!salir){
            System.out.println("\nOPCIONES");
		System.out.println("--------");
           System.out.println("1. INGRESAR MATRIZ ");
           System.out.println("2. SELECCIONA ESTA OPCION PARA SABER QUIEN OBTUVO MAYOR COMISION");
           System.out.println("3. SELECCIONA ESTA OPCION PARA SABER QUIEN OBTUVO MENOR COMISION ");
           System.out.println("4. IMPRIME MATRIZ");
           System.out.println("5. Salir");
            
           System.out.println("INGRESA LA OPCION QUE NECESITES");
           opcion = sn.nextInt();
            
           switch(opcion){
               case 1 -> {
                   ingresoDatos();
                   Calculos();
               }
               case 2 -> maximo();
                   
               
                case 3 -> menor();
                   case 4 -> imprimirDecorado();
                case 5 -> salir=true;
                default -> System.out.println("Solo números entre 1 y 4");
           }
            
       }
        
    }
        
    
    public static void main (String[] args){
        menu();
    }
}