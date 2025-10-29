package DDDTutorial_Modd.ConstL;

import CC.COd.Finishd;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Physc.SIt.Filr;
import CC.Encycloped.Abs.Scal.Physc.SIt.TMplatd_Atom.TMplatd_Projectn;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;

import java.awt.*;
import java.awt.geom.AffineTransform;
import static DDDTutorial_Modd.D2.AWT_X.Set_VrtX;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom.Draw_ShAp;

public class Conectn_2D_Dif<
	Projectn_Typ extends Cros_Polygon_TMplat_Projectn>
	extends Conectn_2D<Projectn_Typ>
{
	@Override @Finishd(Is_Finishd=false)
	public boolean Is_In(
		int X,int Y,
	LOcg_Havr Locg)
	{return false;}

	@Override @Finishd(Is_Finishd=false)
	public void Draw_X(ScrEn ScrEn,Graphics2D Graphcs,
		int AX,int AY,
		int BX,int BY,
		double ScAl)
	{
		int Fan=Fan_ScAl(ScAl);
		Draw_ShAp(ScrEn,Graphcs,new Polygon(
			new int[]{AX,BX-Fan,BX+Fan},
			new int[]{AY,BY,BY},
			3),new AffineTransform(),false,Get_Filr());
	}
	@Override @Finishd(Is_Finishd=false)
	public void Draw_Y(ScrEn ScrEn,Graphics2D Graphcs,
		int AX,int AY,
		int BX,int BY,
		double ScAl)
	{
		int Fan=Fan_ScAl(ScAl);
		Draw_ShAp(ScrEn,Graphcs,new Polygon(
			new int[]{AX,BX,BX},
			new int[]{AY,BY-Fan,BY+Fan},
			3),new AffineTransform(),false,Get_Filr());
	}

	@Override @Finishd(Is_Finishd=false)
	public void UpdAt_Projectn(ScrEn ScrEn,
		TMplatd_Projectn<?,?,? extends Projectn_Typ> Projectn,int Tran)
	{
		super.UpdAt_Projectn(ScrEn,Projectn);
		double Fan=Fan_ScAl(Projectn.Get_Rapd_LOcg().CalculAt_Distnc_Avrg(ScrEn.LOc_Cach));
		Cros_Polygon_TMplat_Projectn TMplat_Projectn=Projectn.Get_TMplat_Projectn();
			final LOcg_Havr LOcg=Projectn.Get_Rapd_LOcg();
		final double[] LOc=new double[3];
		Polygon
			A=TMplat_Projectn.A,
			B=TMplat_Projectn.B;
		LOcg.Get_LOc(Tran,LOc);
			double
				X=LOc[0],
				Y=LOc[1];
			Set_VrtX(A,0,X,Y);
			Set_VrtX(B,0,X,Y);
		LOcg.Get_LOc(Tran+1,LOc);
			X=LOc[0];
			Y=LOc[1];
			Set_VrtX(A,1,X-Fan,Y);
			Set_VrtX(A,2,X+Fan,Y);
			Set_VrtX(B,1,X,Y-Fan);
			Set_VrtX(B,2,X,Y+Fan);
	}

	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	public Projectn_Typ MAk_Projectn()
	{return (Projectn_Typ)new Cros_Polygon_TMplat_Projectn(this,3);}

	@Finishd(Is_Finishd=true)
	public Conectn_2D_Dif(float Fan,Filr Filr)
	{super(Fan,Filr);}
}