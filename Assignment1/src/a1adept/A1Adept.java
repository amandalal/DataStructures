package a1adept;

import java.util.Scanner;

public class A1Adept {
	
	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
		
	}
	
	public static void process(Scanner s) 
	{
		
		double a_percent = 0.4;
		double p_percent = 0.15;
		double m_percent = 0.2;
		double f_percent = 0.25;
		
		
		
		int availablePoints = 0;
		int availablePpoints = 0;
		int number_of_students = 0;
	
		
		int number_of_assignments  = s.nextInt();
		
		for (int i = 0; i < number_of_assignments; i++)
		{
			availablePoints += s.nextInt();
		}
		availablePpoints = s.nextInt();
		number_of_students = s.nextInt();
		
		for (int j = 0; j < number_of_students; j++)
		{
		
			String First_Name = s.next();
			String Last_Name = s.next();
			double P_Points = s.nextInt();
			
			
			double Points = 0;
			double Midterm = 0;
			double Final_Exam = 0;
			
			for (int k = 0; k < number_of_assignments; k++)
			{
				Points += s.nextDouble();
			}
			Points = ((Points/availablePoints) * 100);
			
			Midterm = s.nextDouble();
			Final_Exam = s.nextDouble();
			
			P_Points = (100 * (P_Points / (availablePpoints * 0.8)));
			if (P_Points > 100)
				P_Points = 100;
			
			double wAverage = ((Final_Exam * f_percent) + (Midterm * m_percent) + (P_Points * p_percent) + (Points * a_percent));
			
			
			String letter;
			
			if (wAverage < 60)
				letter = "F";
				else if(wAverage >= 60 && wAverage < 65)
					letter = "D";
				else if(wAverage >= 65 && wAverage < 70)
					letter = "D+";
				else if(wAverage >= 70 && wAverage < 73)
					letter = "C-";
				else if(wAverage >= 73 && wAverage < 76)
					letter = "C";
				else if(wAverage >= 76 && wAverage < 80)
					letter = "C+";
				else if(wAverage >= 80 && wAverage < 83)
					letter = "B-";
				else if(wAverage >= 83 && wAverage < 86)
					letter = "B";
				else if(wAverage >= 86 && wAverage < 90)
					letter = "B+";
				else if(wAverage >= 90 && wAverage < 94)
					letter = "A-";
				else
					letter = "A";
			
				System.out.println(First_Name.charAt(0) + ". " + Last_Name + " " + letter);
				
		}
	}

}
