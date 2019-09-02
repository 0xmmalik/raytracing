package components;

public class Color
{
	public int R, G, B;
	public Color(int r, int g, int b)
	{
		R = r;
		G = g;
		B = b;
	}
	
	public Color scale(float k)
	{
		return new Color(
				(int)(R * k),
				(int)(G * k),
				(int)(B * k));
				
	}
}
