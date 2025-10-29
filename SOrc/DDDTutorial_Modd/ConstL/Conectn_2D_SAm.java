package DDDTutorial_Modd.ConstL;

import CC.COd.Finishd;

import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Physc.SIt.Filr;
import CC.Encycloped.Abs.Scal.Physc.SIt.TMplatd_Atom.TMplatd_Projectn;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;

import java.awt.*;

import static DDDTutorial_Modd.D2.AWT_X.Set_VrtX;

public class Conectn_2D_SAm<
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
		Graphcs.fillPolygon(
			new int[]{AX-Fan,AX+Fan,BX-Fan,BX+Fan},
			new int[]{AY-Fan,AY+Fan,BY-Fan,BY+Fan},
			4);
	}
	@Override @Finishd(Is_Finishd=false)
	public void Draw_Y(ScrEn ScrEn,Graphics2D Graphcs,
		int AX,int AY,
		int BX,int BY,
	double ScAl)
	{
		int Fan=Fan_ScAl(ScAl);
		Graphcs.fillPolygon(
			new int[]{AX-Fan,AX+Fan,BX-Fan,BX+Fan},
			new int[]{AY-Fan,AY+Fan,BY-Fan,BY+Fan},
			4);
	}

	@Override @Finishd(Is_Finishd=false)
	public void UpdAt_Projectn(ScrEn ScrEn,
		TMplatd_Projectn<?,?,? extends Projectn_Typ> Projectn,int Tran)
	{
		super.UpdAt_Projectn(ScrEn,Projectn);
		double Fan=Fan_ScAl(Projectn.Get_Rapd_LOcg().CalculAt_Distnc_Avrg(ScrEn.LOc_Cach));
		Cros_Polygon_TMplat_Projectn TMplat_Projectn=Projectn.Get_TMplat_Projectn();
		final LOcg_Havr LOcg=Projectn.Get_Rapd_LOcg();
			final double[] Loc=new double[3];
		Polygon
			A=TMplat_Projectn.A,
			B=TMplat_Projectn.B;
			LOcg.Get_LOc(Tran,Loc);
			double
				X=Loc[0],
				Y=Loc[1],
				X_Bot=X-Fan,
				X_Top=X+Fan,
				Y_Bot=Y-Fan,
				Y_Top=Y+Fan;
			Set_VrtX(A,0,X_Bot,Y);
			Set_VrtX(A,1,X_Top,Y);
			Set_VrtX(B,0,X,Y_Top);
			Set_VrtX(B,1,X,Y_Bot);
			LOcg.Get_LOc(Tran+1,Loc);
				X=Loc[0];
				Y=Loc[1];
				X_Bot=X-Fan;
				X_Top=X+Fan;
				Y_Bot=Y-Fan;
				Y_Top=Y+Fan;
			Set_VrtX(A,2,X_Top,Y);
			Set_VrtX(A,3,X_Bot,Y);
			Set_VrtX(B,2,X,Y_Bot);
			Set_VrtX(B,3,X,Y_Top);
	}

	@Override @Finishd(Is_Finishd=false)
	public Projectn_Typ MAk_Projectn()
	{return (Projectn_Typ)new Cros_Polygon_TMplat_Projectn(this,4);}

	@Finishd(Is_Finishd=false)
	public Conectn_2D_SAm(float Fan,Filr Filr)
	{super(Fan,Filr);}
}