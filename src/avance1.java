
import java.io.*;


 /* Segun el problema ocupamos: 
        1- calcule cuánto  hay  que  pagarle  a  un  productor  que  realizó  tres  entregas:

            Para esto voy a hacer un for loop, que pida las 3 entregas, con esto se resuelve el promedio del conductor para 
            compararlo con el general. De una vez voy a generar el for loop para que pregunte cuantas entregas 
            va a hacer el conductor en cuestion, asi nos quitamos eso de encima para avances siguientes.  

        2- El  programa  recibe como  entrada  el  id  del  productor:
            Lo preguntare y lo guardare en un String para imprimirlo al final. 


        3- cantidad  de  botellas  de  la primera  entrega, segunda y tercera:

            For loop resuelve esto , llevare una variable double para suma, promedio, numentregas y entrega. 
            resultado es una variable string para poder guardar los resultados de las interacciones del usuario
            cada vez que pasa por el loop, es util para imprimir al final y dar un resumen de todas las interacciones

        4- promedio general de entregas realizado por todos los productores:

            Constante PROM_GEN, se comparara mediante un if para saber si el productor esta encima o bajo promedio
            para efectos de bono

        5- el precio que se le va a pagar a cada productor por cada botella entregada:

            Constante PRECIO_GEN

        6- el premio que se le va a pagar a los productores que realizaron más entregas que el promedio:
            Constante PREMIO = 0.25 pociento del PRECIO_GEN , 

        7- Imprimir el monto que hay pagarle al productor:

                Salida una variable pagoTotal y una variable String bono para imprimir si gana bono o no, no lo piden
                directamente pero me parece bueno tenerlo.
        Finalmente si se pregunta por que? out.println(""); por todo lado, es meramente para acomodar los textos que se imprimen
        en la consola y que se vea mejor la informacion.  

        */


public class avance1 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static final double PROM_GEN = 53.5, PRECIO_GEN = 800, PREMIO = 0.25;

    public static void main (String []args) throws Exception{

        String id = "", bono = "", resultado=""; 
        double sumaEntregas = 0, promEntregas = 0, pagoTotal = 0, entrega = 0; 
        int i, numEntregas = 0;

        out.print("Por favor indicar su número de identificación: ");
        id = in.readLine();
        out.println("");   
        out.print("Por favor indicar el número de entregas a realizar: ");
        numEntregas = Integer.parseInt(in.readLine());
        out.println("");

            for(i = 1; i<=numEntregas; i++){
               out.print("Por favor indíqueme el número de botellas recibidas en la entrega número "+i+": ");
                entrega = Double.parseDouble(in.readLine()); 
                sumaEntregas+= entrega;
                resultado += "En la entrega número "+i+" se entregaron "+ entrega +" botellas. ";
                promEntregas = sumaEntregas/numEntregas;
              }

          if (promEntregas>PROM_GEN){
            pagoTotal = sumaEntregas * PRECIO_GEN * (1+PREMIO);
            bono = "Si ganó bono";
          } else{
            pagoTotal = sumaEntregas * PRECIO_GEN;
            bono = "No ganó bono";
           }

            out.println("");
            out.print(resultado);
            out.println("");
            out.println("");
            out.print("El empleado con el id "+id+", hizo un total de " +numEntregas+" entregas"+
            ", para un promedio de "+promEntregas+" botellas entregadas. ");
            out.println("");
            out.println("");
            out.println(bono+ ". Se le pagará un total de "+ pagoTotal+" colones");
            out.println("");
    }

}