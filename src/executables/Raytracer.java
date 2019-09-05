package executables;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import components.Color;
import components.Item;
import components.Material;
import components.Scene;
import components.Sphere;
import components.Vector;

public class Raytracer
{
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException
	{
		System.out.print("Output Filename (use .png or .jpg extensions): ");
		String filename = input.nextLine();
		ArrayList<Item> items = new ArrayList<>();
		int numSpheres = inputInt("Number of Spheres: ", 1)[0];
		for(int i = 0; i < numSpheres; i++)
		{
			int[] coor = inputInt("Coordinates of Sphere " + (i + 1) + " in X Y Z format: ", 3);
			int radius = inputInt("Radius of Sphere " + (i + 1) + ": ", 1)[0];
			int[] color = inputInt("Color of Sphere " + (i + 1) + " in R G B format: ", 3);
			items.add(new Sphere(new Vector(coor[0], coor[1], coor[2]), radius, new Material(new Color(color[0], color[1], color[2]))));
		}
		ArrayList<Vector> lightsource = new ArrayList<>();
		int[] lightPos = inputInt("Position of Lightsource in X Y Z format: ", 3);
		lightsource.add(new Vector(lightPos[0], lightPos[1], lightPos[2]));
		
		Scene s = new Scene(items, lightsource);
		File outputFile = new File(filename);
		s.raytrace(outputFile);
		
		if(Desktop.isDesktopSupported())
		{
			Desktop desktop = Desktop.getDesktop();
			desktop.open(outputFile);
		}
		else
		{
			System.out.println("File saved...");
		}
	}
	
	public static int[] inputInt(String question, int nums)
	{
		System.out.print(question);
		int[] responses = new int[nums];
		for(int i = 0; i < nums; i++)
		{
			responses[i] = input.nextInt();
		}
		return responses;
	}
}
