package com.lab1;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        String languages[]={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println("Hello World!");
        System.out.format("Number before modifications is %d\n",n);
        n=calcul(n);
        int result=sum_of_digits(n);
        willy(result,languages);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int  matrix[][]=new int [n][n];
        Random_Matrix(n,matrix);
        int visited[] = new int[n];
        conex(n,matrix,visited);
    }

    public static int calcul(int n){
        n=n*3;
        n=n+0b10101;
        n=n + 0xFF;
        n=n*6;
        System.out.format("Number after modifications is %d ",n);
        return n;
    }
    public static int sum_of_digits(int n){
        int  r=n%9,cc;
        if (r==0)
            cc =  9;
        else
            cc = r;
        System.out.format("Number after calculations is %d ",cc);
        return cc;

    }
    public static void willy(int result, String languages[]){
        System.out.format("\nWilly-nilly, this semester I will learn %s\n",languages[result]);
    }
    public static int verif_matrix(int n,int matrix[][])
    {
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++) {
                if(matrix[i][j]!=matrix[j][i])
                    return 0;
            }
            return 1;
    }
    public static void Random_Matrix(int n,int matrix[][]){
        int i,j;
        Random r=new Random();
        do {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    matrix[i][j] = r.nextInt(2);
                }
            }
        }while(verif_matrix(n,matrix)==0);
            for (i=0; i<n; i++) {
            for (j=0; j<n; j++) {
                if(matrix[i][j]==1)
                System.out.printf("%-5s",'\u25C8');
                else if(matrix[i][j]==0)
                    System.out.printf("%-5s",'\u25C7');
            }
            System.out.println();
        } System.out.println("\n");
    }
    public static void dfs(int n,int matrix[][],int i,int visited[]) {
        int j;
        visited[i] = 1;

        for (j = 0; j < n; j++)
            if (visited[j] == 0 && matrix[i][j] == 1)
            { System.out.printf(", %d ",j);
                dfs(n,matrix,j,visited);}
    }
    public static void conex(int n,int matrix[][],int visited[])
    {   int component=1;
        for(int i=0;i<n;i++)
            if(visited[i]==0) {
                System.out.printf("Conex Component %d :{",component);
                System.out.printf(" %d ",i);
                dfs(n, matrix, i, visited);
                System.out.println("}\n");
                component++;
            }
        if(component==2)
            System.out.println("If it has just one component it means it's connected.\n");
    }
}