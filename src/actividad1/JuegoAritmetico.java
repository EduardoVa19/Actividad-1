package actividad1;

import java.security.SecureRandom;

public class JuegoAritmetico {

    private int nivel;
    private int problema;
    String operator;
    SecureRandom secureRandom = new SecureRandom();

    public JuegoAritmetico() {
    }

    public JuegoAritmetico(int nivel, int problema) {
        this.nivel = nivel;
        this.problema = problema;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getProblema() {
        return problema;
    }

    public void setProblema(int problema) {
        this.problema = problema;
    }

    public int numeroAleatorio(int nivel) {
        int numeroMinimo = 0;
        int numeroMaximo = 0;

        if (nivel == 1) {
            numeroMinimo = 0;
            numeroMaximo = 9;
        } else if (nivel == 2) {
            numeroMinimo = 10;
            numeroMaximo = 99;
        }
        int numeroAleatorio = secureRandom.nextInt(numeroMaximo - numeroMinimo + 1) + numeroMinimo;
        
        

        return numeroAleatorio;
    }

   
    
    public void pregunta(int num1, int num2, int problema) {

        switch (problema) {
            case 1:
                operator = "+";
                break;
            case 2:
                operator = "-";
                break;
            case 3:
                operator = "*";
                break;
            case 4:
                operator = "/";
                
                break;
            case 5:
            int randomOperator = secureRandom.nextInt(4); // 0: +, 1: -, 2: *, 3: /
                switch (randomOperator) {
                    case 0:
                        operator = "+";
                        break;
                    case 1:
                        operator = "-";
                        break;
                    case 2:
                        operator = "*";
                        break;
                    case 3:
                        operator = "/";
                        break;
                }
                break;
        }
        System.out.print("\n¿Cuánto es " + num1 + " " + operator + " " + num2 + "? = ");
    }

    public void respuestaCorrecta() {
        String[] respuestaCorrecta = {"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"};
        int randomIndex = (int) (Math.random() * respuestaCorrecta.length);
        System.out.println(respuestaCorrecta[randomIndex]);
    }

    public void respuestasIncorrecta(int respuestaCorrecta, int num1, int num2, int problema, int respuesta) {
        String[] respuestasIncorrecta = {"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.", "¡No te rindas!", "No. Sigue intentando."};
        int randomIndex = (int) (Math.random() * respuestasIncorrecta.length);
        System.out.println(respuestasIncorrecta[randomIndex]);
        System.out.println("\n----------- RETROALIMENTACION-----------");
        System.out.println("La respuesta a la pregunta ¿Cuánto es " + num1 + " " + operator + " " + num2 + "? es incorrecta.\n"
                + "La respuesta  de " + num1 + " " + operator + " " + num2 + " es igual a " + respuestaCorrecta + ", no a " + respuesta + ". Sigue practicando tus habilidades de matemáticas.");
    }

    public int calcularRespuestaCorrecta(int num1, int num2, int problema) {
        switch (problema) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                return num1 / num2;
            case 5:
                // Debes implementar la lógica para calcular la respuesta correcta
                // según el operador aleatorio generado en el método 'pregunta'
                int respuesta = 0;
                switch (this.operator) {
                    case "+":
                        respuesta = num1 + num2;
                        break;
                    case "-":
                        respuesta = num1 - num2;
                        break;
                    case "*":
                        respuesta = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            respuesta = num1 / num2;
                        } else {
                            System.out.println("Error: no se puede dividir por 0");
                        }
                        break;
                }
                return respuesta;
            default:
                return 0;
        }

    }

    public void puntuacion(double porcentaje, int respuestasCorrectas) {
        System.out.println("\n---------------------------------------------");
        System.out.println("Respuesta correctas: " + respuestasCorrectas);
        System.out.println("Respuesta incorrectas: " + (10 - respuestasCorrectas));
        System.out.println("Tú porcentaje es de: " + porcentaje + "%\n");
        if (porcentaje >= 75) {
            System.out.println("Felicidades, estás listo para pasar al siguiente nivel!");
        } else {
            System.out.println("Por favor pide ayuda adicional a tu instructor.");
        }
    }

}
