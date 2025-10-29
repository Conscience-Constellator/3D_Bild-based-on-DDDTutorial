package DDDTutorial_Modd.ConstL;

import CC.COd.Finishd;

import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Physc.SIt.Filr;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon;
import java.awt.*;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.Gar_Filr;

public class	  Conectn_Dif
	 extends Cros_Conectn
{
	@Override @Finishd(Is_Finishd=true)
	public int[] Drawblg_ShAp()
	{return new int[]{3,3,3};}
	@Override @Finishd(Is_Finishd=false)
	public void Set_Polygong(Polyhedron Polyhedron,D3_Drawbl_Atom[] Polygong,
								 double X,double Y,double Z,
								 double X_LNg,double Y_LNg,double Z_LNg,
							 Object Filr_SOrc,boolean Is_Visbl)
	{
		Filr Filr=Gar_Filr(Filr_SOrc);
		double[] A_Loc=A.Get_LOc_CoP_As_ArA();
		((Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>)Polygong[0]).Set_Polygon(new D3_Polygon(null,
			A_Loc,
			B.MAk_RL_LOc(-Fan,0,0),
			B.MAk_RL_LOc(Fan,0,0)),
		Filr,Is_Visbl);
		((Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>)Polygong[1]).Set_Polygon(new D3_Polygon(null,
			A_Loc,
			B.MAk_RL_LOc(0,-Fan,0),
			B.MAk_RL_LOc(0,Fan,0)),
		Filr,Is_Visbl);
		((Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>)Polygong[2]).Set_Polygon(new D3_Polygon(null,
			A_Loc,
			B.MAk_RL_LOc(0,0,-Fan),
			B.MAk_RL_LOc(0,0,Fan)),
		Filr,Is_Visbl);
	}

	@Finishd(Is_Finishd=false)
	public Conectn_Dif(RL_LOc_Havr Parnt)
	{super(Parnt);}
	@Finishd(Is_Finishd=false)
	public Conectn_Dif(RL_LOc_Havr PArnt,
		RL_LOc_Havr A,
		RL_LOc_Havr B,
		double Fan,Color Colr)
	{super(PArnt,A,B,Fan,Colr);}
		@Finishd(Is_Finishd=false)
		public Conectn_Dif(
			RL_LOc_Havr A,
			RL_LOc_Havr B,
			double Fan,Color Colr)
		{super(A,B,Fan,Colr);}
}