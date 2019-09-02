package components;

public class Material
{
	public Color col;
	public float phi;
	
	public Material(Color _col, float _phi)
	{
		col = _col;
		phi = _phi;
	}
	
	public Material(Color _col)
	{
		col = _col;
		phi = 0;
	}
}
