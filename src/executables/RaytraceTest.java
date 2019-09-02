package executables;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import components.*;

public class RaytraceTest
{
	public static void main(String[] args)
	{
		ArrayList<Vector> light = new ArrayList<>();
		light.add(new Vector((float)8.7, (float)8.9, (float)-9.8));
		ArrayList<Item> sphere = new ArrayList<>();
		sphere.add(new Sphere(new Vector(3, 0, -5), 2, new Material(new Color(0, 257, 0), 14)));
		Scene s = new Scene(sphere, light);
		File outFile = new File("FILEPATH"); // FILL IN THIS LINE
		try {
			s.raytrace(outFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
