package CC.Img;

import CC.COd.Finishd;

import CC.$.Q$Q.Int1$1;
import static CC.List.ArA_X.Get_Last;
import static CC.Math.CoP.SqAr;
import static java.awt.Color.HSBtoRGB;

public class Mandlbrot implements Img_Popr
{
	public int Itr_Max;
	public Int1$1 Itr$Colr;
		public static float Div_SLf_Plus_B(float A,float B)
		{return A/(A+B);}
		public static Int1$1[] Itr$Colr_List={
			(Num)->{
				return HSBtoRGB(
					Num/256F,
					1,
					Div_SLf_Plus_B(Num,8F));
			},
			(Num)->{
				return HSBtoRGB(
					(Num/256F)+.5F,
					1,
					Div_SLf_Plus_B(Num,8F));
			},
			(Num)->{
				return HSBtoRGB(
					(Num/256F)+.66F,
					1,
					Div_SLf_Plus_B(Num,8F));
			},
			(Num)->{
				return HSBtoRGB(
					(Num/256F)+.33F,
					1,
					Div_SLf_Plus_B(Num,8F));
			},
		};
		public static Int1$1 Dfalt=Get_Last(Itr$Colr_List);
	int Too_MNy=0;
	@Override @Finishd(Is_Finishd=false)
	public int CalculAt(double X,double Y)
	{
		double
			ZX=0,
			ZY=0;
		int Itr_Num=0;
		for(;;Itr_Num+=1)
		{
			double
				ZX_SqAr=SqAr(ZX),
				ZY_SqAr=SqAr(ZY);
			boolean
				Too_MNy_Itr=Itr_Num<Itr_Max,
				A=(
					ZX_SqAr+
					ZY_SqAr)<4;
			if(!(Too_MNy_Itr&&A))
			{
				return (!Too_MNy_Itr)?
					Too_MNy:
					Itr$Colr.Int1$1(Itr_Num);
			}

			double TMp=
				ZX_SqAr-
				ZY_SqAr+X;
			ZY=(2.0*ZX*ZY)+Y;
			ZX=TMp;
		}
	}

	@Finishd(Is_Finishd=true)
	public Mandlbrot(int Itr_Max,Int1$1 Itr$Colr)
	{
		this.Itr_Max=Itr_Max;
		this.Itr$Colr=Itr$Colr;
	}
}