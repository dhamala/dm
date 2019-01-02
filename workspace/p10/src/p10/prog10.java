package p10;

import java.util.*;
import java.io.*;
class prog10
{
public static void main(String args[])
{
float[][] mat = new float[2][2];int n=0;
float res;
Scanner in = new Scanner(System.in);
System.out.println("enter confusion matrix");
for(int i=0;i<2;i++)
{
for(int j=0;j<2;j++)
{
int x = in.nextInt();
mat[i][j]=x;
n=n+x;
}
}
res = mat[0][0]*100/(mat[0][0]+mat[0][1]);
System.out.println("Sensitivity :"+res+"%");
res = mat[1][1]*100/(mat[1][0]+mat[1][1]);
System.out.println("Specificity :"+res+"%");
res = mat[0][0]*100/(mat[0][0]+mat[0][1]);
System.out.println("recall :"+res+"%");
res = mat[0][0]*100/(mat[0][0]+mat[1][0]);
System.out.println("Precision :"+res+"%");
res = (mat[0][0]+mat[1][1])*100/n;
System.out.println("Weighted Accuracy :"+res+"%");
}
}