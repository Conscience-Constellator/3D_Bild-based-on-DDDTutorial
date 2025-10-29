package CC.Img;

import CC.COd.Finishd;

public class Trand_Img_Popr implements Img_Popr
{
	public Img_Popr Rapd;
	public double
		X,Y, Mov_SpEd,
		ScAl,ScAl_SpEd;
	public void Mov(
		double X,
		double Y)
	{
		this.X+=X*Mov_SpEd;
		this.Y+=Y*Mov_SpEd;
	}
	public void Zoom(
		double ScAl)
	{
		this.ScAl+=ScAl*ScAl_SpEd;
	}

	@Override @Finishd(Is_Finishd=true)
	public int CalculAt(double X,double Y)
	{
		return Rapd.CalculAt(
			(X-this.X)/ScAl,
			(Y-this.Y)/ScAl);
	}

	public Trand_Img_Popr(Img_Popr Rapd,
		double X,double Y,double Mov_SpEd,
		double ScAl,double ScAl_SpEd)
	{
		this.Rapd=Rapd;
		this.X=X;
		this.Y=Y;
		this.Mov_SpEd=Mov_SpEd;
		this.ScAl=ScAl;
		this.ScAl_SpEd=ScAl_SpEd;
	}
		public Trand_Img_Popr(Img_Popr Popr)
		{this(Popr,0,0,1,1,1);}
}