package com.aditya;

import java.util.*;
import java.io.*;
import java.lang.*;
public class App
{   
	public static void main(String[] args)throws IOException
	{
        	System.out.write(("\nEnter 1 for Interest Calculation,2 for House Construction Estimate :").getBytes());
        	Scanner sc=new Scanner(System.in);
        	int choice=sc.nextInt();
		Interest obj=new Interest();
		Construction estimate=new Construction();
        	if (choice==1)
			obj.execute();
		else
			estimate.execute();
        
    	}
}
class Interest
{
	double time,rate,principal;
	void execute()throws IOException
	{
		System.out.write(("\nEnter 1 for Simple Interest,2 for Compound Interest(compd annualy):").getBytes());
		Scanner sc=new Scanner(System.in);
        	int choice=sc.nextInt();
		read();
		double ans;
		if(choice==1)
			ans=SI();
		else
			ans=CI();
		String Ans=String.format("%.2f",ans);
		
		System.out.write(("\nInterest=Rs "+Ans).getBytes());
	}
	void read()throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.write(("\nEnter Principal=").getBytes());
		principal=sc.nextDouble();
		System.out.write(("\nEnter time(years)=").getBytes());
		time=sc.nextDouble();
		System.out.write(("\nEnter annual interest rate(%)=").getBytes());
		rate=sc.nextDouble();
	}
	double SI()
	{
		return(principal*(rate/100)*time);
	}
	double CI()
	{
		return(principal*(Math.pow((1+rate/100),time)-1));
	}
}

class Construction
{
	double area;int material,automated;
	void execute()throws IOException
	{
		read();
		String Ans=String.format("%.2f",calculate());
		System.out.write(("\nTotal cost estimate=Rs "+Ans).getBytes());
	}
	void read()throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.write("\nEnter area(sq.ft)=".getBytes());
		area=sc.nextDouble();
		System.out.write("\nEnter 1 for standard material,2 for above standard,3 for High standard:".getBytes());
		material=sc.nextInt();
		if(material==3)
		{
			System.out.write("\nPress 1 for automated,0 for ordinary:".getBytes());
			automated=sc.nextInt();
		}
	}
	double calculate()
	{
		if(material==1)
			return(area*1200.00);
		else 
			if(material==2)
				return(area*1500.00);
			else 
				if(material==3 && automated==1)
					return(area*2500.00);
				else
					return(area*1800.00);
				
	}
}

		
		
		
		