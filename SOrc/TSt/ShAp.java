package TSt;

import java.awt.*;

public abstract class ShAp
{
	public ShAp(double x,double y,double z,double width,double length,double height,Color c)
	{
		this.x=x;
		this.y=y;
		this.z=z;
		this.width=width;
		this.length=length;
		this.height=height;
		this.c=c;
		Set_Polys();

//		setRotAdd();
//		updatePoly();
	}
	public abstract void Set_Polys();

	public double x,y,z,width,length,height;
	public DPolygon[] Polys;
	public Color c;
	public double[] angle;

	public abstract void UpdateDirection(double To_X,double To_Y);
	public abstract void updatePoly();
	public double[] RotAdd=new double[Rot_Ad_Num()];
	public abstract int Rot_Ad_Num();
	public abstract void setRotAdd();
}