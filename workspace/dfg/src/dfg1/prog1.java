package dfg1;

import java.io.*;
import java.util.*;

public class prog1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		float [][] mat=new float[2][2];
		float res;
		int n=0;
		System.out.println("enter confusion matrix");
		Scanner in = new Scanner(System.in);
		for(int i=0;i<2;i++)
		{
			for (int j=0;j<2;j++ )
			{ 
				int x=in.nextInt();
				mat[i][j]=x;
				n=n+x;
			}
		}
	
	res=mat[0][0]*100/(mat[0][0]+ mat[0][1]);
	res=mat[1][1]*100/(mat[1][0]+ mat[1][1]);
	res=mat[0][0]*100/(mat[0][0]+ mat[0][1]);
	res=mat[0][0]*100/(mat[0][0]+ mat[1][0]);
	}
	}

	