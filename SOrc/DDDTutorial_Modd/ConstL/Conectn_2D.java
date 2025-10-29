package DDDTutorial_Modd.ConstL;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import DDDTutorial_Modd.D2.D2_Drawbl_TMplat.D2_Drawbl_TMplat_Projectn;
import DDDTutorial_Modd.D2.Ofsetbl_D2_Drawbl_TMplat.Ofsetbl_D2_Drawbl_TMplat_ConcrEt;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Physc.SIt.Filr;
import CC.Encycloped.Abs.Scal.Physc.SIt.TMplatd_Atom.TMplatd_Projectn;
import java.awt.*;
import java.awt.geom.AffineTransform;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom.Draw_ShAp;
import static java.lang.Math.max;

public abstract class Conectn_2D<
	Projectn_Typ extends D2_Drawbl_TMplat_Projectn>
	extends Ofsetbl_D2_Drawbl_TMplat_ConcrEt<Projectn_Typ>
{
	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	public int Get_LOc_Num()
	{return 2;}

	public float Fan;
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public int Fan_ScAl(double ScAl)
		{return max((int)(this.Fan/ScAl),1);}
	@Override @Finishd(Is_Finishd=false)
	public void Get_Box(double[] Box,LOcg_Havr LOcg)
	{
		double[] Loc=LOcg.Get_LOc(0);
		int			X=(int)Loc[0],
			Y=(int)Loc[1];

		Box[0]=X;
		Box[1]=X;
		Box[2]=Y;
		Box[3]=Y;
	}
	@Override @Finishd(Is_Finishd=false)
	public boolean Is_In(
		int X,int Y,
		TMplatd_Projectn<?,?,? extends Projectn_Typ> LOcg)
	{return false;}

	@Finishd(Is_Finishd=false)
	public void Draw_X(ScrEn ScrEn,Graphics2D Graphcs,
		int AX,int AY,
		int BX,int BY,
		double ScAl)
	{Draw_ShAp(ScrEn,Graphcs,new Polygon(
		new int[]{(int)(AX-Fan),(int)(AX+Fan),(int)(BX-Fan),(int)(BX+Fan)},
		new int[]{(int)(AY-Fan),(int)(AY+Fan),(int)(BY-Fan),(int)(BY+Fan)},
		4),new AffineTransform(),false,Get_Filr());
	}
	@Finishd(Is_Finishd=false)
	public void Draw_Y(ScrEn ScrEn,Graphics2D Graphcs,
		int AX,int AY,
		int BX,int BY,
		double ScAl)
	{Draw_ShAp(ScrEn,Graphcs,new Polygon(
		new int[]{(int)(AX-Fan),(int)(AX+Fan),(int)(BX-Fan),(int)(BX+Fan)},
		new int[]{(int)(AY-Fan),(int)(AY+Fan),(int)(BY-Fan),(int)(BY+Fan)},
		4),new AffineTransform(),false,Get_Filr());
	}
	@Override @Finishd(Is_Finishd=false)
	public void Draw_Projectn(ScrEn ScrEn,Graphics2D Graphcs,
		TMplatd_Projectn<?,?,? extends Projectn_Typ> Projectn,LOcg_Havr LOcg,int Tran)
	{
//		for(int IndX=0;IndX<COrdg.npoints;IndX+=1){
//			out.println(COrdg.xpoints[IndX]+","+COrdg.ypoints[IndX]);
//		}
//		out.println("COrdg");
		int
			AX=(int)LOcg.Get_COrd(0,Tran),AY=(int)LOcg.Get_COrd(1,0),
			BX=(int)LOcg.Get_COrd(0,Tran+1),BY=(int)LOcg.Get_COrd(1,1);
		double Distnc=LOcg.CalculAt_Distnc_Avrg(ScrEn.LOc_Cach);
		Cros_Polygon_TMplat_Projectn TMplat_Projectn=(Cros_Polygon_TMplat_Projectn)Projectn.Get_TMplat_Projectn();
		Draw_ShAp(ScrEn,Graphcs,TMplat_Projectn.A,
			new AffineTransform(),false,Get_Filr());
		Draw_ShAp(ScrEn,Graphcs,TMplat_Projectn.B,
			new AffineTransform(),false,Get_Filr());
//		Draw_X(ScrEn,Graphcs,AX,AY,BX,BY,Distnc);
//		Draw_Y(ScrEn,Graphcs,AX,AY,BX,BY,Distnc);
	}

	@Override @Finishd(Is_Finishd=false)
	public void UpdAt_Projectn(ScrEn ScrEn,
		TMplatd_Projectn<?,?,? extends Projectn_Typ> Projectn)
	{
		Projectn.Get_Projectd().Get_BAs_LOcg_Havr().Project(ScrEn,
			Projectn);
	}

	@Finishd(Is_Finishd=true)
	public Conectn_2D(float Fan,Filr Filr)
	{
		super(Filr);
		this.Fan=Fan;
	}
}