package components;

public class Vector
{
	private float x, y, z;
	
	public Vector(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector(Vector v)
	{
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}
	
	public Vector add(Vector other)
	{
		return new Vector(
				this.x + other.x,
				this.y + other.y,
				this.z + other.z);
	}
	
	public Vector sub(Vector other)
	{
		return new Vector(
				this.x - other.x,
				this.y - other.y,
				this.z - other.z);
	}
	
	public Vector scale(float k)
	{
		return new Vector(
				k * this.x,
				k * this.y,
				k * this.z);
	}
	
	public float mag()
	{
		return (float)Math.sqrt(
				this.x * this.x + 
				this.y * this.y + 
				this.z * this.z);
	}
	
	public float mag2()
	{
		return this.x * this.x +
				this.y * this.y +
				this.z * this.z;
	}
	
	public Vector unit()
	{
		float mag = this.mag();
		return this.scale(1 / mag);
	}
	
	public float dot(Vector other)
	{
		return other.x * this.x +
				other.y * this.y +
				other.z * this.z;
	}
	
	public Vector cross(Vector other)
	{
		float x = this.y * other.z - this.z * other.y;
		float y = this.z * other.x - this.x * other.z;
		float z = this.x * other.y - this.y * other.x;
		return new Vector(x, y, z);
	}
}
