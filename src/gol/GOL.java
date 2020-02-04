/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

/**
 *
 * @author vilij
 */
public class GOL {
    
    public static int skSuma(int nuo, int iki){ //deklaruojam kokio tipo grazins rezultata (int), nuo , iki - metodo parametrai, parametrai vardinami per kableli,
        //kai kada metodas(f-ja ) nebutinai turi grazinti reiksme
        //java yra grieztai tipizuota;tipas ir po to pavadinimas
        //yra spec tipas 
    int suma=0;
    for(int i = nuo;i<=iki; i++){
        suma+=i;
    }
    return suma;
    }
    //void negrazina nieko, jokios rieksmes, po void skliausteliai butinai turi but(tusti ar pilni nesvarbu, bet turi but)
    public static void skSP(int nuo, int iki){//kintamiehi nuo ir kintamasis iki jau iskarto yra
    for (int i=nuo; i<=iki; i++){
        System.out.println(i);
    } 
    }
    public static void main(String[] args) {
        
        int s=skSuma(7,43); //sklaiusteliai reiskia, kad bus kvieciamas metodas
        System.out.println(s);
        int ks=skSuma(-5,108);
        System.out.println(ks);
        skSP(3,8);
        System.out.println("---------");
        skSP(-3,4);
        
        int size = 50;
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {  //Math.random() generuoja [0;1)   
                if (Math.random() < 0.25) {
                    field[i][j] = 'X';
                } else {
                    field[i][j] = '.';
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        char[][][] history = new char[50][size][size];
        for (int i = 0; i < 50; i++) {
            history[i] = field;
            char[][] newField = new char[size][size];

            //einam per visus field elementus, tam reikes dar dvieju ciklu cikle
            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    int kk = 0;
                    if (y > 0) {
                        kk += (x > 0 && field[y - 1][x - 1] == 'X') ? 1 : 0;
                        kk += (field[y - 1][x] == 'X') ? 1 : 0;

                        kk += (x < size - 1 && field[y - 1][x + 1] == 'X') ? 1 : 0;
                    }
                    kk += (x > 0 && field[y][x - 1] == 'X') ? 1 : 0;
                    kk += (x < size - 1 && field[y][x + 1] == 'X') ? 1 : 0;
                    if (y < size - 1) {
                        kk += (x > 0 && field[y + 1][x - 1] == 'X') ? 1 : 0;
                        kk += (field[y + 1][x] == 'X') ? 1 : 0;
                        kk += (x < size - 1 && field[y + 1][x + 1] == 'X') ? 1 : 0;
                    }
                    if (field[y][x] == 'X') {
                        if (kk >= 2 && kk <= 3) {
                            newField[y][x] = 'X';
                        } else {
                            newField[y][x] = '.';
                        }
                    } else {
                        if (kk == 3) {
                            newField[y][x] = 'X';
                        } else {
                            newField[y][x] = '.';
                        }
                    }
                }
            }
            int h;
            for ( h = i; h >= 0; h--) {
                boolean match = true;
                for (int y = 0; match && y < size; y++) {
                    for (int x = 0; match && x < size; x++) {
                        match = history[h][y][x] == newField[y][x];
                    }
                }
                if (match) {
                    break;
                }
            }
            if (h>=0) {
                System.out.print("Iteracijas kartojasi" +h+ "zingsnyje");
                break;
            }
                //spausdinimas
                for (int y = 0; y < size; y++) {
                    for (int x = 0; x < size; x++) {
                        System.out.print(newField[x][y]);
                    }
                    System.out.println();
                }
                System.out.println("--------------------");

                field = newField;//sukuriam dar naujesni masyva;
            }
        
        }
    }
