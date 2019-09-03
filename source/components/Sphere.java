package components;

import java.util.Optional;

public class Sphere extends Item
{
	private Vector pos;
	private float rad;
	
	public Sphere(Vector position, float radius, Material mat)
	{
		this.pos = position;
		this.rad = radius;
		this.mat = mat;
	}
	
	public Sphere(Vector position, float radius)
	{
		this.pos = position;
		this.rad = radius;
		this.mat = new Material(new Color(200, 200, 200));
	}
	
	public Optional<Vector> intersection(Ray ray)
	{
		Vector pc = ray.getStartPoint().sub(pos);
		float a = ray.getDirection().mag2();
		float b = ray.getDirection().scale(2).dot(pc);
		float c = pc.mag2() - rad * rad;
		
		float disc = b * b - 4 * a * c;
		float lambda;
		if (disc < 0)
			return Optional.empty();
		else if (disc == 0)
			lambda = -b / 2 / a;
		else
		{
			float center = -b / 2 / a;
			float sqrt = (float) Math.sqrt(disc);
			float l1 = center - sqrt;
			float l2 = center + sqrt;
			
			lambda = (l1 < 1) ? l2 : l1;
		}
		return Optional.of(ray.getStartPoint()
				.add(ray.getDirection().scale(lambda)));
	}
	
	public Vector normalAt(Vector point)
	{
		return pos.sub(point).unit();
	}
}
