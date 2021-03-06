package a1novice;

import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) 
	{
		int number_of_students = s.nextInt();

		for (int i = 0; i < number_of_students; i++)
		{
			String First_Name = s.next();
			String Last_Name = s.next();
			double Assignment_Grade = s.nextDouble();
			double Participation_Grade = s.nextDouble();
			double Midterm = s.nextDouble();
			double Final_Exam = s.nextDouble();

			double a_percent = 0.4;
			double p_percent = 0.15;
			double m_percent = 0.2;
			double f_percent = 0.25;

			String gradeLetter;

			double wAverage = ((Assignment_Grade * a_percent) + (Participation_Grade * p_percent) + (Midterm * m_percent) + (Final_Exam * f_percent));
			if (wAverage < 60)
				gradeLetter = "F";
			else if(wAverage >= 60 && wAverage < 65)
				gradeLetter = "D";
			else if (wAverage >= 65 && wAverage < 70)
				gradeLetter = "D+";
			else if (wAverage >= 70 && wAverage < 73)
				gradeLetter = "C-";
			else if (wAverage >= 73 && wAverage < 76)
				gradeLetter = "C";
			else if (wAverage >= 76 && wAverage < 80)
				gradeLetter = "C+";
			else if (wAverage >= 80 && wAverage < 83)
				gradeLetter = "B-";
			else if (wAverage >= 83 && wAverage < 86)
				gradeLetter = "B";
			else if (wAverage >= 86 && wAverage < 90)
				gradeLetter = "B+";
			else if (wAverage >= 90 && wAverage < 94)
				gradeLetter = "A-";
			else
				gradeLetter = "A";

			System.out.println(First_Name.charAt(0) + ". " + Last_Name + " " + gradeLetter);
		}
	}
}