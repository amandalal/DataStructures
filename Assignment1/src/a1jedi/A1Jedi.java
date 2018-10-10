package a1jedi;

import java.util.Scanner;

public class A1Jedi {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) 
	{
		int number_of_assignments = s.nextInt();
		int a_total_points = 0;

		for ( int i = 0; i < number_of_assignments; i++)
		{
			a_total_points += s.nextInt();
		}

		int total_p_points = s.nextInt();

		int number_of_students = s.nextInt();

		int grades [] = new int [11];
		for (int i = 0; i < grades.length; i++)
		{
			grades [i] = 0;
		}

		double p_points[]= new double [number_of_students];
		double a_points[] = new double [number_of_students];
		double r_midterm[] = new double [number_of_students];
		double r_final[] = new double [number_of_students];
		String First_Name[] = new String [number_of_students];
		String Last_Name[] = new String [number_of_students];

		double r_midterm_total = 0;
		double square_total = 0;
		double std = 0;

		for (int j = 0; j < number_of_students; j++)
		{
			First_Name[j] = s.next();
			Last_Name[j] = s.next();
			p_points[j] = s.nextInt();

			for (int k = 0; k < number_of_assignments; k++)
			{
				a_points[j] += s.nextDouble();
			}

			r_midterm[j] = s.nextDouble();
			r_final[j] = s.nextDouble();
		}


		double normal = 0;
		double curve_score = 0;
		double curve_midterm [] = new double [number_of_students];


		for (int m = 0; m < r_midterm.length; m++)
		{
			r_midterm_total += r_midterm[m];
		}

		double r_mean = r_midterm_total / (double)r_midterm.length;

		for (int p = 0; p < r_midterm.length; p++)
		{
			square_total += Math.pow((r_midterm[p] - r_mean), 2);
		}

		std = Math.sqrt((square_total / (double)r_midterm.length));



		for (int q = 0; q < r_midterm.length; q ++)
		{
			normal = (r_midterm [q] - r_mean) / std;

			if (normal <= -4.0)
				curve_score = 0.0;
			else if (normal == -3.0)
				curve_score = 30.0;
			else if (normal == -2.0)
				curve_score = 55.0;
			else if (normal == -1.5)
				curve_score = 65.0;
			else if (normal == -1.0)
				curve_score = 75.0;
			else if (normal == 0.0)
				curve_score = 85.0;
			else if (normal == 1.0)
				curve_score = 94.0;
			else if (normal >= 2.0)
				curve_score = 100.0;

			double l_normal = 0;
			double h_normal = 0;
			double l_curve = 0;
			double h_curve = 0;

			if (normal > -4.0 && normal < -3.0)
			{
				l_normal = -4.0;
				h_normal = -3.0;
				l_curve = 0.0;
				h_curve = 30.0;
			}
			if (normal > -3.0 && normal < -2.0)
			{
				l_normal = -2.0;
				h_normal = -1.5;
				l_curve = 55.0;
				h_curve = 65.0;
			}
			if (normal > -2.0 && normal < -1.5)
			{
				l_normal = -1.5;
				h_normal = -1.5;
				l_curve = 55.0;
				h_curve = 65.0;
			}
			if (normal > -1.5 && normal < -1.0)
			{
				l_normal = -1.0;
				h_normal = 0.0;
				l_curve = 75.0;
				h_curve = 85.0;
			}
			if (normal > 0.0 && normal < 1.0)
			{
				l_normal = 0.0;
				h_normal = 1.0;
				l_curve = 85.0;
				h_curve = 94.0;
			}

			if (normal > 0.0 && normal < 1.0)
			{
				l_normal = 0.0;
				h_normal = 1.0;
				l_curve = 85.0;
				h_curve = 94.0;
			}
			if (normal > 1.0 && normal < 2.0)
			{
				l_normal = 1.0;
				h_normal = 2.0;
				l_curve = 94.0;
				h_curve = 100.0;
			}

			curve_score = (((normal - l_normal) / (h_normal- l_normal)) * (h_curve - l_curve)) + l_curve;
			curve_midterm [q] = curve_score;
		}

		double r_fin_total = 0;
		double fin_square_total = 0;
		double fin_std = 0;

		for (int t = 0; t < r_final.length; t++)
		{
			r_fin_total += r_final[t];
		}
		double f_raw_mean = r_fin_total / (double)r_final.length;

		for (int v = 0; v < r_final.length; v++)
		{
			fin_square_total += Math.pow((r_final[v] - f_raw_mean), 2);
		}

		fin_std = Math.sqrt((fin_square_total / (double)r_final.length));

		double fin_normal = 0;
		double fin_curve_score = 0;
		double fin_curve [] = new double [number_of_students];

		for (int r = 0; r < r_final.length; r++)
		{
			fin_normal = (r_final [r] - f_raw_mean) / fin_std;

			NormalHelper(fin_normal, fin_curve_score);

			double fin_l_normal = 0;
			double fin_h_normal = 0;
			double fin_l_curve = 0;
			double fin_h_curve = 0;


			if (fin_normal > -4.0 && fin_normal < -3.0)
			{
				fin_l_normal = -4.0;
				fin_h_normal = -3.0;
				fin_l_curve = 0.0;
				fin_h_curve = 30.0;
			}
			if (fin_normal > -3.0 && fin_normal < -2.0)
			{
				fin_l_normal = -3.0;
				fin_h_normal = -2.0;
				fin_l_curve = 30.0;
				fin_h_curve = 55.0;
			}
			if (fin_normal > -2.0 && fin_normal < -1.5)
			{
				fin_l_normal = -2.0;
				fin_h_normal = -1.5;
				fin_l_curve = 55.0;
				fin_h_curve = 65.0;
			}
			if (fin_normal > -1.5 && fin_normal < -1.0)
			{
				fin_l_normal = -1.5;
				fin_h_normal = -1.0;
				fin_l_curve = 65.0;
				fin_h_curve = 75.0;
			}
			if (fin_normal > -1.0 && fin_normal < 0.0)
			{
				fin_l_normal = -1.0;
				fin_h_normal = 0.0;
				fin_l_curve = 75.0;
				fin_h_curve = 85.0;
			}
			if (fin_normal > 0.0 && fin_normal < 1.0)
			{
				fin_l_normal = 0.0;
				fin_h_normal = 1.0;
				fin_l_curve = 85.0;
				fin_h_curve = 94.0;
			}
			if (fin_normal > 1.0 && fin_normal < 2.0)
			{
				fin_l_normal = 1.0;
				fin_h_normal = 2.0;
				fin_l_curve = 94.0;
				fin_h_curve = 100.0;
			}



			fin_curve_score = finalCurveScoreHelper(fin_normal, fin_l_normal, fin_h_normal, fin_h_curve, fin_l_curve);

			fin_curve[r] = fin_curve_score;

		}

		final double a_percent = 0.4;
		final double p_percent = 0.15;
		final double m_percent = 0.2;
		final double f_percent = 0.25;

		for (int z = 0; z < number_of_students; z++)
		{
			double p_point = (100 * (p_points [z] / (total_p_points * 0.8)));


			if (p_point > 100) {
				p_point = 100;
			}

			double g_percent = ((((a_points[z] / a_total_points) * 100) * a_percent) + (p_point * p_percent) + (curve_midterm [z] * m_percent) + (fin_curve [z] * f_percent));


			PercentHelper(g_percent, grades);

		}

		System.out.println("A: " + grades[0]);
		System.out.println("A-: " + grades[1]);
		System.out.println("B+: " + grades[2]);
		System.out.println("B: " + grades[3]);
		System.out.println("B-: " + grades[4]);
		System.out.println("C+: " + grades[5]);
		System.out.println("C: " + grades[6]);
		System.out.println("C-: " + grades[7]);
		System.out.println("D+: " + grades[8]);
		System.out.println("D: " + grades[9]);
		System.out.println("F: " + grades[10]);

	}


	public static double finalCurveScoreHelper(double fin_normal, double fin_l_normal, double fin_h_normal, double fin_h_curve, double fin_l_curve) {
		double fin_curve_score = 0; 
		fin_curve_score = (((fin_normal - fin_l_normal) / (fin_h_normal - fin_l_normal)) * (fin_h_curve - fin_l_curve)) + fin_l_curve;
		return fin_curve_score; 


	}

	public static void PercentHelper(double g_percent, int grades[]) { 
		if (g_percent < 60)
			grades [10] ++;
		else if (g_percent >= 60 && g_percent < 65)
			grades [9] ++;
		else if (g_percent >= 65 && g_percent < 70)
			grades [8] ++; 
		else if (g_percent >= 70 && g_percent < 73)
			grades [7] ++;
		else if (g_percent >= 73 && g_percent < 76)
			grades [6] ++;
		else if (g_percent >= 76 && g_percent < 80)
			grades [5] ++;
		else if (g_percent >= 80 && g_percent < 83)
			grades [4] ++;
		else if (g_percent >= 83 && g_percent < 86)
			grades [3] ++;
		else if (g_percent >= 86 && g_percent < 90)
			grades [2] ++;
		else if (g_percent >= 90 && g_percent < 94)
			grades [1] ++;
		else
			grades [0] ++;
	}


	public static void NormalHelper(double fin_normal, 	double fin_curve_score) {

		if (fin_normal <= -4.0)
			fin_curve_score = 0.0;
		else if (fin_normal == -3.0)
			fin_curve_score = 30.0;
		else if (fin_normal == -2.0)
			fin_curve_score = 55.0;
		else if (fin_normal == -1.5)
			fin_curve_score = 65.0;
		else if (fin_normal == -1.0)
			fin_curve_score = 75.0;
		else if (fin_normal == 0.0)
			fin_curve_score = 85.0;
		else if (fin_normal == 1.0)
			fin_curve_score = 94.0;
		else if (fin_normal == 2.0)
			fin_curve_score = 100.0;

	}

}