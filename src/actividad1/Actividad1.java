package actividad1;

import java.util.Random;
import java.util.Scanner;

public class Actividad1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nivel;
        int problema;
        int pregunta = 10;

        int respuestasCorrectas = 0;
        int num1;
        int num2;
        int respuestaCorrecta;
        int respuesta;
        double porcentaje;
        String op = null;
        
        do{
        

        //MENÚ
        
        //nivel de dificultad
        System.out.println("BIENVENIDO AL PROGRAMA DE INSTRUCCIÓN ASISTIDA POR COMPUTADORA\n");
        System.out.println("Selecciona el nivel de dificultad: ");
        System.out.println("1 - Números de un dígito");
        System.out.println("2 - Números de dos dígitos");  
        do {
            System.out.print("\nPor favor, seleccione un nivel (1 o 2):");
            nivel = scanner.nextInt();
            
            if (nivel != 1 && nivel != 2) {
                System.out.println("Opción no válida. Debe seleccionar 1 o 2.");
            }
        } while (nivel != 1 && nivel != 2);

        // tipo de problema aritmético a estudiar
        System.out.println("has seleccionado el nivel " + nivel);
        System.out.println("\nSelecciona el tipo de problema aritmético\n");
        System.out.println("------ MENU --------");
        System.out.println("1 - Suma");
        System.out.println("2 - Resta");
        System.out.println("3 - Multiplicación");
        System.out.println("4 - División");
        System.out.println("5 - Mezcla aleatoria");
       do {
            System.out.print("\nSelecciona una opción válida (1-5): ");
            problema = scanner.nextInt();
            
            if (problema < 1 || problema > 5) {
                System.out.println("Opción no válida. Debe ser un número entre 1 y 5.");
            }
        } while (problema < 1 || problema > 5);


        //INSTANCIA DE UNA CLASE
        JuegoAritmetico juego = new JuegoAritmetico();

        //El programa presentará la pregunta al usuario y esperará su respuesta.
        for (int i = 0; i < pregunta; i++) {
            num1 = juego.numeroAleatorio(nivel);
            num2 = juego.numeroAleatorio(nivel);
            System.out.print("\nPregunta " + (i + 1) + ": ");
            juego.pregunta(num1, num2, problema);
            respuesta = scanner.nextInt();
            respuestaCorrecta = juego.calcularRespuestaCorrecta(num1, num2, problema);

            //CONTAR RESPUESTAS CORRECTAS
            //Si la respuesta es correcta
            if (respuesta == respuestaCorrecta) {
                juego.respuestaCorrecta();
                respuestasCorrectas++;
            } else { //Si la respuesta es incorrecta
                juego.respuestasIncorrecta(respuestaCorrecta, num1, num2, problema, respuesta);
                
                
            }

        }
        
        //calcular porcentaje
        porcentaje = (double) respuestasCorrectas / pregunta * 100;
        
        juego.puntuacion(porcentaje, respuestasCorrectas);
        respuestasCorrectas=0;
       
            System.out.print("\nPRESIONE CUALQUIER TECLA PARA VOLVER A JUGAR "
                    + "\nPARA SALIR PRESIONE (n) ");
            op = scanner.next();

            
        } while (!op.equalsIgnoreCase("n"));

       

        scanner.close();

    }

}
