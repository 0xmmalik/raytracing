package components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.imageio.ImageIO;

public class Scene
{
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	ArrayList<Item> items;
	ArrayList<Vector> sources;
	
	public Scene(ArrayList<Item> items, ArrayList<Vector> sources)
	{
		this.items = items;
		this.sources = sources;
	}
	
	public void raytrace(File outFile) throws IOException
	{
		Color[][] pixels = new Color[HEIGHT][WIDTH];
		BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		for (int px = 0; px < WIDTH; px++)
		for (int py = 0; py < WIDTH; py++)
		{
			float x = ((float)px - WIDTH / 2) / WIDTH;
			float y = ((float)py - HEIGHT / 2) / HEIGHT;
			Ray r = new Ray(new Vector(x, y, 1));
			for (Item i : items)
			{
				Optional<Vector> intersection = i.intersection(r);
				pixels[px][py] = new Color(0, 0, 0);
				if (intersection.isPresent())
				{
					Vector point = intersection.get();
					float brightness = 0;
					for (Vector source : sources)
					{
						Ray _ray = new Ray(source, point);
						boolean shadow = items.stream()
								.anyMatch((item) -> 
									item.intersection(_ray).isPresent());
						if (!shadow)
						{
							Vector su = source.unit();
							Vector norm = i.normalAt(point);
							float cos = su.dot(norm);
							brightness += cos;
						}
							
							
					}
					pixels[px][py] = i.mat.col.scale((float)Math.min(brightness, 1.0));
					
				}
				int p = (pixels[px][py].R << 16) | (pixels[px][py].G << 8) | pixels[px][py].B;
				img.setRGB(px, py, p);
			}
		}
		
		ImageIO.write(img, "png", outFile);
		
	}

	public static void main(String[] args)
	{
		System.out.println("Hello world");
		System.out.println("Goodbye world");
		ArrayList<Vector> light = new ArrayList<>();
		light.add(new Vector((float)8.7, (float)8.9, (float)-9.8));
		ArrayList<Item> sphere = new ArrayList<>();
		sphere.add(new Sphere(new Vector(1, 0, 8), 2, new Material(new Color(200, 100, 100), 14)));
		Scene s = new Scene(sphere, light);
		File outFile = new File("/Users/988111/Desktop/raytrace.png");
		try {
			s.raytrace(outFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
