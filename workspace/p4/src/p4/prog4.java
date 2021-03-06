package p4;

import java.io.*;

class prog4
{
	static record[] rc = new record[2];
	public static void main(String args[]) throws FileNotFoundException, IOException
	{
		BufferedReader csv = new BufferedReader(new FileReader(new File("/home/ashok/data4.csv")));
		String data = csv.readLine();
		int i=0;
		while(data != null)
		{
			rc[i] = new record();
			String[] dataarray = data.split(",");
			for(int j=0;j<7;j++)
				rc[i].attr[j] = Integer.parseInt(dataarray[j]);
			data = csv.readLine();
			i++;
		}
		int totalOfCol[] = new int[7];
		double giniOfCol[] = new double[7];
		double entropyOfCol[] = new double[7];
		double gini[] = new double[3];
		double entropy[] = new double[3];
		double gain[] = new double[3];
		for(i=0;i<rc.length;i++)
			for(int j=0;j<totalOfCol.length;j++)
				totalOfCol[j] += rc[i].attr[j];
		for(i=0;i<rc.length;i++)
			for(int j=0;j<totalOfCol.length;j++)
			{
				double temp = rc[i].attr[j]/(totalOfCol[j] * 1.0);
				giniOfCol[j] += Math.pow(temp,2);
				entropyOfCol[j] += temp * Math.log(temp) / Math.log(2);
			}
		for(int j=0;j<totalOfCol.length;j++)
		{
			giniOfCol[j] = 1 - giniOfCol[j];
			entropyOfCol[j] = -1 * entropyOfCol[j];
	}
		gini[0] = ( giniOfCol[0]*totalOfCol[0] + giniOfCol[1]*totalOfCol[1] )/(totalOfCol[0]+totalOfCol[1]);
		gini[1] = ( giniOfCol[2]*totalOfCol[2] + giniOfCol[3]*totalOfCol[3] )/(totalOfCol[2]+totalOfCol[3]);
		gini[2] = ( giniOfCol[4]*totalOfCol[4] + giniOfCol[5]*totalOfCol[5]+ giniOfCol[6]*totalOfCol[6])/(totalOfCol[4]+totalOfCol[5]+totalOfCol[6]);
		entropy[0] = ( entropyOfCol[0]*totalOfCol[0] +entropyOfCol[1]*totalOfCol[1] )/(totalOfCol[0]+totalOfCol[1]);
		entropy[1] = ( entropyOfCol[2]*totalOfCol[2] +entropyOfCol[3]*totalOfCol[3] )/(totalOfCol[2]+totalOfCol[3]);
		entropy[2] = ( entropyOfCol[4]*totalOfCol[4] +entropyOfCol[5]*totalOfCol[5] +entropyOfCol[6]*totalOfCol[6])/(totalOfCol[4]+totalOfCol[5]+totalOfCol[6]);
		double parententropy = 1.0;
		double parentgini = 0.5;
		for(i=0;i<gini.length;i++)
			gain[i] = parententropy - entropy[i];
		System.out.println("entrpoy="+entropy[0]);
		System.out.println("gini="+gini[0]);
		System.out.println("gain="+gain[0]);
		
		System.out.println("entrpoy="+entropy[1]);
		System.out.println("gini="+gini[1]);
		System.out.println("gain="+gain[1]);
		
		System.out.println("entrpoy="+entropy[2]);
		System.out.println("gini="+gini[2]);
		System.out.println("gain="+gain[2]);
	}
	}
	
