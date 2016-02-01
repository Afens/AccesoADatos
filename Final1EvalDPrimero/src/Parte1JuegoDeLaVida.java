import java.util.Arrays;

/**
 * Created by Afens on 13/12/2015.
 */
public class Parte1JuegoDeLaVida {
    public static void main(String[] args) {
        boolean[][] tablero = new boolean[5][5];
        tablero[0][0] = true;
        tablero[0][4] = true;
        tablero[1][3] = true;
        tablero[2][0] = true;
        tablero[2][2] = true;
        tablero[2][3] = true;
        tablero[3][1] = true;
        tablero[4][0] = true;
        tablero[4][1] = true;

        juego(tablero, 2, 5, 3, 6, 9);

    }

    public static boolean[][] juego(boolean[][] original, int minv, int maxv, int minm, int maxm, int ciclos) {
        boolean[][] game = new boolean[original.length][];
        boolean[][] cambios = new boolean[original.length][original.length];
        boolean hayCambios;
        for (int i = 0; i < game.length; i++) {
            game[i] = Arrays.copyOf(original[i], original[i].length);
        }
        do {
            ciclos--;
            //Reset
            hayCambios = false;
            for (int i = 0; i < cambios.length; i++) {
                Arrays.fill(cambios[i], false);
            }
            //Imprimir y comprobar
            for (int i = 0; i < game.length; i++) {
                for (int j = 0; j < game.length; j++) {
                    if (game[i][j]) {
                        System.out.printf("%-2d", 1);
                        cambios[i][j] = cambiara(game, i, j, minv, maxv);
                    } else {
                        System.out.printf("%-2d", 0);
                        cambios[i][j] = cambiara(game, i, j, minm, maxm);
                    }
                }
                System.out.println();
            }

            //Realizar cambios
            for (int i = 0; i < cambios.length && ciclos > -1; i++) {
                for (int j = 0; j < cambios.length; j++) {
                    if (cambios[i][j]) {
                        hayCambios = true;
                        game[i][j] = !game[i][j];
                    }
                }
            }
            System.out.println();

        } while (hayCambios && !(ciclos < 0));

        return game;
    }

    public static boolean cambiara(boolean[][] original, int i, int j, int min, int max) {
        int contador = 0;
        boolean valor = original[i][j];


        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k > -1 && k < original.length && l > -1 && l < original.length && !(l == j && k == i))
                    if (original[k][l])
                        contador++;
            }
        }
        /* El bucle de arriba ahorra lo comentado
        //arriba izq
        if (i - 1 > -1 && j - 1 > -1)
            if (original[i - 1][j - 1])
                contador++;

        //arriba der
        if (i - 1 > -1 && j + 1 < 5)
            if (original[i - 1][j + 1])
                contador++;

        //abajo izq
        if (i + 1 < 5 && j - 1 > -1)
            if (original[i + 1][j - 1])
                contador++;

        //arriba der
        if (i + 1 < 5 && j + 1 < 5)
            if (original[i + 1][j + 1])
                contador++;

        //arriba
        if (i - 1 > -1)
            if (original[i - 1][j])
                contador++;
        //abajo
        if (i + 1 < 5)
            if (original[i + 1][j])
                contador++;
        //der
        if (j + 1 < 5)
            if (original[i][j + 1])
                contador++;
        //izq
        if (j - 1 > -1)
            if (original[i][j - 1])
                contador++;
*/

        if (contador > min && contador < max)
            if (valor)
                return false;
            else
                return true;
        else {
            if (valor)
                return true;
            else
                return false;
        }

    }
}
