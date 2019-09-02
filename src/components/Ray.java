package components;

public class Ray
{
	private Vector dir, start;
	
	public Ray(Vector direction, Vector start)
	{
		this.dir = direction;
		this.start = start;
	}
	
	public Ray(Vector direction)
	{
		this.dir = direction;
		this.start = new Vector(0, 0, 0);
	}
	
	public Vector getDirection()
	{ return this.dir; }
	
	public Vector getStartPoint()
	{ return this.start; }
}
