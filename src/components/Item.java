package components;

import java.util.Optional;

public abstract class Item
{
	protected Material mat;
	public abstract Optional<Vector> intersection(Ray ray);
	public abstract Vector normalAt(Vector point);
}
