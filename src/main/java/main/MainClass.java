package main;


import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        //---------------------------------
        Character[][] a = {
                {'-','-','-'},
                {'-','-','-'},
                {'-','-','-'}
        };
        Character[][] init = {
                {'-','-','-'},
                {'-','-','-'},
                {'-','-','-'}
        };
        //-----
        // ---------------------------
        Scanner sc = new Scanner(System.in);

        boolean bool = true;
        //for not entering the same address twice
        ArrayList<String> list = new ArrayList<>();
        // for checking the winning positions
        ArrayList<Character> row = new ArrayList<>();
        ArrayList<Character> col = new ArrayList<>();

        for(int z = 0 ; z<9 ; z++) {

            int b = sc.nextInt(), b1 = sc.nextInt();
            char c = sc.next().charAt(0);
            String var = String.valueOf(b) + "" + String.valueOf(b1);

            if (!list.contains(var) && (c == 'x' || c == 'o' || c == 'X' || c == 'O')){

                list.add(var);

                for (int i = 0; i < a.length; i++) {

                    for (int j = 0; j < a[0].length; j++) {

                        if (i == b && j == b1 && a[i][j] == '-') {

                            if(c == 'x' || c=='X') {
                                a[i][j] = 'x';
                            }else if(c == 'o' || c == 'O'){
                                a[i][j] = 'o';
                            }

                            System.out.print(a[i][j] + " ");

                        } else {
                            System.out.print(a[i][j] + " ");
                        }
                    }

                    System.out.println();
                }
            }else if(list.contains(var)){

                System.out.println("You have already entered that address");

            }else{
                System.out.println("Please enter 'o' or 'x' ");
            }

            //--------------------------------------checking the win positions
            //checking columns
            for(int m = 0 ; m < a.length; m++) {
                for(int n=0 ; n < a[m].length; n++){
                    col.add(a[m][n]);
                }

                if(col.get(0) == 'x' && col.get(1) == 'x' && col.get(2) == 'x'){
                    System.out.println("You won ! The game is over");
                    a = init;
                    cl(list,row,col);
                    break;
                }else if(col.get(0) == '0' && col.get(1) == '0' && col.get(2) == '0'){
                    System.out.println("You won ! The game is over");
                    a = init;
                    cl(list,row,col);
                    break;
                }else{
                    col.clear();
                }
            }
            //checking the rows
            for(int m = 0 ; m < a.length; m++) {
                for(int n=0 ; n < a[m].length; n++){
                    row.add(a[n][m]);
                }
                if(row.get(0) == 'x' && row.get(1) == 'x' && row.get(2) == 'x'){
                    System.out.println("You won ! The game is over");
                    a = init;
                    cl(list,row,col);
                    break;
                }else if(row.get(0) == 'o' && row.get(1) == 'o' && row.get(2) == 'o'){
                    System.out.println("You won ! The game is over");
                    a = init;
                    cl(list,row,col);
                    break;
                }else{
                    row.clear();
                }
            }
            //========================================================checking the diogonals
            char[][] trial = new char[3][3];
            for(int l = 0 ; l < a.length; l++) {
                for (int k = 0; k < a[l].length; k++) {

                    trial[l][k] = a[l][k];

                }
            }
            if(trial[0][0] == 'x' && trial[1][1] == 'x' && trial[2][2] == 'x'){
                System.out.println("You won ! The game is over");
                a = init;
                cl(list,row,col);
                trial = new char[3][3];
                break;
            }else if(trial[0][0] == 'o' && trial[1][1] == 'o' && trial[2][2] == 'o'){
                System.out.println("You won ! The game is over");
                a = init;
                cl(list,row,col);
                trial=new char[3][3];
                break;
            }else if(trial[0][2] == 'o' && trial[1][1] == 'o' && trial[2][0] == 'o'){
                System.out.println("You won ! The game is over");
                a = init;
                cl(list,row,col);
                trial = new char[3][3];
                break;
            }else if(trial[0][2] == 'x' && trial[1][1] == 'x' && trial[2][0] == 'x'){
                System.out.println("You won ! The game is over");
                a = init;
                cl(list,row,col);
                trial = new char[3][3];
                break;
            }
        }


     //==================================
    }

    private static void cl(ArrayList<String> a, ArrayList<Character> a1, ArrayList<Character> a2){
        a.clear();
        a1.clear();
        a2.clear();
    }
}


