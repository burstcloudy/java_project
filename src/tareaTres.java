import java.io.*;
import java.text.DecimalFormat;

/*
nota = 1 -> bajo
1< nota <2 -> medio
2=< nota <= 3 -> alto 	

nota depende de 3 variables: nacionalidad,  actividad económica, figura política 

nota= 0.30nacionalidad + 0.70actividad economica

Pais nota 3: Venezuela, Colombia, Nicaragua, Islas Caimán.
Pais nota 2: Argentina,Brasil, Rusia, China
Pais nota 1: Resto de los países

Actividad nota 3: Abogado, Prestamista
Actividad nota 2: Médico, Informático, Contador
Actividad nota 1: Resto de las actividades económicas

Se toma nombre, cédula, edad, nacionalidad, actividad económica, figura política

Ir mostrando el nombre, la cédula y el riesgo de cada cliente incluído.
total de clientes de alto riesgo
Mostrar el mes con la mayor cantidad de clientes de alto riesgo.????!!!!
cantidad total de clientes de mediano riesgo
el porcentaje de clientes de alto riesgo


*/

public class tareaTres {
    
static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
static PrintStream out = System.out; 
static DecimalFormat redondeo = new DecimalFormat("#.##");

static final double NACIONALIDAD = 0.30, ACTIVIDAD = 0.70;




public static void main(final String[] args) throws Exception {
	
			
    String nivRiesgo = "", figura = "", nombre ="",cedula = "", nacionalidad = "", actividad = "", resumen="", registro="";
    double notaPonderada = 0.0, notaNac= 0.0, notaAct = 0.0, porcentajeAlto = 0.0, contadorAlto= 0,contadorMedio= 0;
    int edad = 0, contadorTotal = 0; 
    char continuar = 's';
        
 do {
    
                    contadorTotal++;
                   
                    out.println("Bienvenido al menejador de riesgo bancario. Por favor complete las preguntas.");
                    out.println();
                    out.print("Por favor indique su nombre: ");
                    nombre = in.readLine(); 
                    out.print("Por favor indique su cédula: ");
                    cedula = in.readLine(); 
                    out.print("Por favor indique su edad: ");
                    edad= Integer.parseInt(in.readLine()); 
                    out.print("Por favor indique su nacionalidad: ");
                    nacionalidad = in.readLine(); 
                    out.print("Por favor indique su profesión: ");
                    actividad = in.readLine(); 
                    out.print("Es usted una figura política? Marque si/no: ");
                    figura = in.readLine(); 

                    if(figura.equals("no")){
                        
                        switch(nacionalidad){

                            case "Venezuela":
                            case "venezuela": 
                            case "Colombia":
                            case "colombia": 
                            case "Nicaragua":
                            case "nicaragua": 
                            case "Islas Caiman": 
                            case "islas caiman":

                            notaNac = 3.0;

                            break;

                            case "Argentina":
                            case "argentina": 
                            case "Brasil":
                            case "brasil": 
                            case "Rusia":
                            case "rusia": 
                            case "China": 
                            case "china":
                            notaNac = 2.0;
                            break;    

                            default:
                            notaNac = 1.0;
                            break;

                         }

                         switch(actividad){

                             case "Abogado": 
                             case "abogado":
                             case "Prestamista":
                             case "prestamista":
                             notaAct = 3.0;
                             break;

                             case "Medico": 
                             case "Informatico": 
                             case "Contador":
                             case "medico": 
                             case "informatico": 
                             case "contador":
                             notaAct = 2.0;
                             break;

                             default:
                             notaAct = 1.0;
                             break;

                         }

                        notaPonderada = ((NACIONALIDAD * notaNac) + ( ACTIVIDAD *notaAct));

                        } else {
                            notaPonderada = 3.0;
                        }

                        if(notaPonderada>=2){
                            contadorAlto ++; 
                            nivRiesgo = "alto.";	
            
                            }else if(notaPonderada > 1 && notaPonderada < 2){
            
                            contadorMedio++; 
                            nivRiesgo = "mediano.";
        
                             } else {

                                nivRiesgo = "bajo.";
                                    }
            
                    porcentajeAlto = contadorAlto/contadorTotal *100;


                    out.println("\n");
                    registro= "Registro #"+contadorTotal+": El usuario "+nombre+", cédula "+ cedula
                    + ", tiene una calificacion de riesgo de "+ redondeo.format(notaPonderada)+" puntos. Esto es un nivel de riesgo "+
                    nivRiesgo+"\n";  

                    out.println("\n");

                    out.println();
                    out.println(registro);
                    out.println();

                    out.println("El total clientes alto riesgo en el registro: "+contadorAlto);
                    out.println("El total clientes mediano riesgo en el registro: "+contadorMedio);
                    out.println("Porcentaje de clientes alto riesgo en el registro: "
                    + redondeo.format(porcentajeAlto)+"%");
                    out.println();
        
                    resumen+=registro; 
                    
                    out.print("Desea analizar otro cliente? Indique s/n por favor: ");
                    continuar = in.readLine().charAt(0);

        
     } while (continuar == 's');
        
        out.println("\n");
        out.println("Aqui un resumen de la actividad de hoy: "+"\n");
        out.println(resumen+"\n");
        out.println();
        out.println("Gracias por utilizar el servicio de analisis de riesgo bancario.");

       

    }
}

 
