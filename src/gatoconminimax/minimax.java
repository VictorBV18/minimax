
package gatoconminimax;


import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.Scanner;

public class minimax {

    public static int endBoard = 3;

    public int Matriz[][];
    int Deepth = 2;
    boolean change;

    //este esta bien 
    public minimax(int[][] Matriz1) {
        Matriz = Matriz1;
        change = false;
        while (true) {
            readNumbers();
            if ((isWin(Matriz) != 1 && isWin(Matriz) != 2) && change && !isFull(Matriz)) {
                miniMax(Matriz);

            }
            printBoard(Matriz);
        }
    }

    //este esta bien    
    public boolean isFull(int m[][]) {
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {
                if (m[j][i] == 0) {
                    return false;
                }

            }

        }

        return true;
    }

    //este esta bien
    public static void main(String[] args) {
        
        System.out.println("Este juego del gato consiste en lo siguiente ");
        System.out.println("Tu eres el jugador num 1 y la maquina es el jugador num 2");
        System.out.println("Introduce los numeros segun las coordenadas X,Y");
        System.out.println("Ejemplo, si pones 1,1 te pone el num 1 en medio");
        System.out.println("Ejemplo, si pones 0,1 te pone el num 1 en la primera columna y segunda fila ");
        System.out.println("El Tablero va de 0 a 2");
        System.out.println("SUERTE!!!!!!!!!!!!!\n");
        
        
        
        int Matriz[][];
        Matriz = new int[endBoard][endBoard];

        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {
                Matriz[i][j] = 0;

            }

        }

        new minimax(Matriz);
    }
    
    //este esta bien
    private void readNumbers() {
        Scanner reader = new Scanner(System.in);
        int i = 0, j = 0;
        boolean ver = true;
        System.out.println("Introduce 1 numero y pulsa enter, luego repite, si la pos esta vacia continua ");
        do {
            j = reader.nextInt();
            i = reader.nextInt();
            if (i < 3 && j < 3) {
                if (this.Matriz[j][i] == 0) {
                    this.Matriz[j][i] = 1;
                    ver = false;
                }

            }

        } while (ver);

        change = true;

    }

    public int isWin(int m[][]) {
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {

                if (j + 2 < endBoard) {
                    if (m[j][i] == 1 && m[j + 1][i] == 1 && m[j + 2][i] == 1) {
                        return 1;
                    }
                }
                if (i + 2 < endBoard) {
                    if (m[j][i] == 1 && m[j][i + 1] == 1 && m[j][i + 2] == 1) {
                        return 1;
                    }
                }

                if (i + 2 < endBoard && j + 2 < endBoard) {
                    if (m[j][i] == 1 && m[j + 1][i + 1] == 1 && m[j + 2][i + 2] == 1) {
                        return 1;
                    }
                }

                if (i - 3 > -1 && j + 3 < endBoard) {
                    if (m[j][i] == 1 && m[j + 1][i - 1] == 1 && m[j + 2][i - 2] == 1) {
                        return 1;
                    }
                }

                if (i + 2 < endBoard && j - 2 > -1) {
                    if (m[j][i] == 1 && m[j - 1][i + 1] == 1 && m[j - 2][i + 2] == 1) {
                        return 1;
                    }
                }

                if (j + 2 < endBoard) {
                    if (m[j][i] == 2 && m[j + 1][i] == 2 && m[j + 2][i] == 2) {
                        return 2;
                    }
                }

                if (i + 2 < endBoard) {
                    if (m[j][i] == 2 && m[j][i + 1] == 2 && m[j][i + 2] == 2) {
                        return 2;
                    }
                }

                if (i + 2 < endBoard && j + 2 < endBoard) {
                    if (m[j][i] == 2 && m[j + 1][i + 1] == 2 && m[j + 2][i + 2] == 2) {
                        return 2;
                    }
                }

                if (i - 2 > -1 && j + 2 < endBoard) {
                    if (m[j][i] == 2 && m[j + 1][i - 1] == 2 && m[j + 2][i - 2] == 2) {
                        return 2;
                    }
                }

                if (i + 2 < endBoard && j - 2 > -1) {
                    if (m[j][i] == 2 && m[j - 1][i + 1] == 2 && m[j - 2][i + 2] == 2) {
                        return 2;
                    }
                }
            }
        }

        return 0;
    }

    private void printBoard(int m[][]) {
        System.out.println("");
        System.out.println("");
        if (isWin(m) == 1) {
            System.out.println("Ganaste Terricola");
        }

        if (isWin(m) == 2) {
            System.out.println("Gano la Maquina");
        }

        System.out.println("");
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {
                System.out.print(m[j][i] + "\t");

            }
            System.out.println("");
        }
    }

    private void miniMax(int[][] m) {
        int mejorfila = -1, mejorcolumna = -1;
        int max, maxActual;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {
                if (m[j][i] == 0) {
                    int tempfila, tempc;

                    m[j][i] = 2;
                    tempfila = i;
                    tempc = j;

                    maxActual = ValorMin(m, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    m[tempc][tempfila] = 0;
                    if (max < maxActual) {
                        max = maxActual;
                        mejorfila = tempfila;
                        mejorcolumna = tempc;
                    }
                }
            }

        }
        m[mejorcolumna][mejorfila] = 2;
        change = false;

    }

    public int ValorMin(int[][] m, int deph, int alfa, int beta) {
        if (isWin(m) == 1 || isWin(m) == 2) {
            return Heuristica(m);

        } else if (isFull(m)) {
            return Heuristica(m);

        } else if (Deepth < deph) {
            return Heuristica(m);

        } else {
            for (int i = 0; i < endBoard; i++) {
                for (int j = 0; j < endBoard; j++) {
                    if (m[j][i] == 0) {
                        int tempfila, tempc;

                        m[j][i] = 1;
                        tempfila = i;
                        tempc = j;

                        beta = min(beta, ValorMax(m, deph+1, alfa, beta));

                        m[tempc][tempfila] = 0;

                        if (alfa >= beta) {
                            return alfa;
                        }
                    }
                }

            }

            return beta;

        }

    }

    public int ValorMax(int[][] m, int deph, int alfa, int beta) {

        if (isWin(m) == 1 || isWin(m) == 2) {
            return Heuristica(m);
        } else if (isFull(m)) {
            return Heuristica(m);
        } else {
            for (int i = 0; i < endBoard; i++) {
                for (int j = 0; j < endBoard; j++) {
                    if (m[j][i] == 0) {
                        int tempfila, tempc;

                        m[j][i] = 2;
                        tempfila = i;
                        tempc = j;

                        alfa = max(alfa, ValorMin(m, deph+1, alfa, beta));

                        m[tempc][tempfila] = 0;

                        if (alfa >= beta) {
                            return beta;
                        }
                    }
                }

            }

            return alfa;
        }

    }

    
    
    
    //este esta bien    
    public int Heuristica(int m[][]) {
        int costo=0;
        costo=Costo(m,2)-Costo(m,1);
        
                return costo;
        

    }

    
    //este esta bien
    public int Costo(int m[][], int jugador) {
        int value=0;
        
        
        for (int i = 0; i < endBoard; i++) {
            for (int j = 0; j < endBoard; j++) {

                if (j + 2 < endBoard) {
                    if (m[j][i] == jugador && m[j + 1][i] == jugador && m[j + 2][i] == jugador) {
                        return 500;
                    }
                }
                if (i + 2 < endBoard) {
                    if (m[j][i] == jugador && m[j][i + 1] == jugador && m[j][i + 2] == jugador) {
                        return 500;
                    }
                }

                if (i + 2 < endBoard && j + 2 < endBoard) {
                    if (m[j][i] == jugador && m[j + 1][i + 1] == jugador && m[j + 2][i + 2] == jugador) {
                        return 500;
                    }
                }

                if (i - 2 > -1 && j + 2 < endBoard) {
                    if (m[j][i] == jugador && m[j + 1][i - 1] == jugador && m[j + 2][i - 2] == jugador) {
                        return 500;
                    }
                }

                if (i + 2 < endBoard && j - 2 > -1) {
                    if (m[j][i] == jugador && m[j - 1][i + 1] == jugador && m[j - 2][i + 2] == jugador) {
                        return 500;
                    }
                }

                if (j + 1 < endBoard) {
                    if (m[j][i] == jugador && m[j + 1][i] == jugador) {
                        value=300;
                    }
                }

                if (i + 1 < endBoard) {
                    if (m[j][i] == jugador && m[j][i + 1] == jugador) {
                        value=300;
                    }
                }

                if (i + 1 < endBoard && j + 1 < endBoard) {
                    if (m[j][i] == jugador && m[j + 1][i + 1] == jugador) {
                        value=300;
                    }
                }

                if (i - 1 > -1 && j + 1 < endBoard) {
                    if (m[j][i] == jugador && m[j + 1][i - 1] == jugador) {
                        value=300;
                    }
                }
                

                if (i + 1 < endBoard && j - 1 > -1) {
                    if (m[j][i] == jugador && m[j - 1][i + 1] == jugador) {
                        value=300;
                    }
                }
            }
        }

        return value;
        
        
        
        
    }

}

