package DDDTutorial_Modd;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import DDDTutorial_Modd.D2.D2_Drawbl_Atom;
import DDDTutorial_Modd.D2.Trand_Drawbl;
import CC.Encycloped.Abs.Scal.Gom.LOc;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import DDDTutorial_Modd.D2.D2_TMplatd_Atom;
import DDDTutorial_Modd.D2.D2_Drawbl_TMplat;
import DDDTutorial_Modd.D3.Polyhedron;
import java.util.HashMap;
import java.util.Map;
import static CC.List.BAs_ArA.AB;

public class Grid<CL_Typ extends D2_Drawbl_Atom> extends Polyhedron
{
	public Map<int[],CL_Typ> Grid=new HashMap<>();
	public interface CL_MAkr<CL_Typ extends D2_Drawbl_Atom>
	{
		@Lin_DclAr
		CL_Typ MAk(float X,float Y);
			@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			default CL_Typ MAk(double X,double Y)
			{return MAk((float)X,(float)Y);}
	}
	public CL_MAkr<CL_Typ> CL_MAkr;
		public D2_TMplatd_Atom MAk_From_TMplat(float X,float Y,D2_Drawbl_TMplat TMplat)
		{return new D2_TMplatd_Atom(this,TMplat,X,Y);}
		public Trand_Drawbl MAk_Trand(float X,float Y,D2_Drawbl_Atom TMplat)
		{return new Trand_Drawbl(TMplat,new LOc(X,Y,0));}
		public float X_LNg  ,Y_LNg  ,
					 X_BtwEn,Y_BtwEn;
			public void Set_Metrcg(float X_LNg,float Y_LNg,
								   float X_BtwEn,float Y_BtwEn)
			{
				this.X_LNg  =X_LNg  ;
				this.Y_LNg  =Y_LNg  ;
				this.X_BtwEn=X_BtwEn;
				this.Y_BtwEn=Y_BtwEn;
			}
		public CL_Typ Ad(float X,float Y)
		{
			CL_Typ Atom=CL_MAkr.MAk(X,Y);

			Ad_Drawbl_Atom(Atom);
			Rset_Drawbl_Atomg();
			UpdAt_Polygong();
			return Atom;
		}
			public CL_Typ Ad(int X,int Y)
			{
				CL_Typ Atom=Ad((X_LNg*X)+(X_BtwEn*X),
							   (Y_LNg*Y)+(Y_BtwEn*Y));

				Grid.put(AB(X,Y),Atom);
				return Atom;
			}

	public Grid(RL_LOc_Havr Parnt,Object LOc_SOrc,
				float X_LNg	 ,float Y_LNg  ,
				float X_BtwEn,float Y_BtwEn)
	{
		super(Parnt,LOc_SOrc);
		Set_Drawbl_Atomg();
		Set_Metrcg(X_LNg  ,Y_LNg  ,
				   X_BtwEn,Y_BtwEn);
	}
	public Grid(RL_LOc_Havr Parnt,Object LOc_SOrc,CL_MAkr<CL_Typ> CL_MAkr,
		float X_LNg,float Y_LNg,
		float X_BtwEn,float Y_BtwEn)
	{
		this(Parnt,LOc_SOrc,
			 X_LNg  ,Y_LNg  ,
			 X_BtwEn,Y_BtwEn);
		this.CL_MAkr=CL_MAkr;
	}
		public Grid(RL_LOc_Havr Parnt,Object LOc_SOrc,D2_Drawbl_Atom Atom,
			float X_LNg  ,float Y_LNg  ,
			float X_BtwEn,float Y_BtwEn)
		{
			this(Parnt,LOc_SOrc,
				 X_LNg  ,Y_LNg  ,
				 X_BtwEn,Y_BtwEn);
			CL_MAkr=(X,Y)->
					{return (CL_Typ)MAk_Trand(X,Y,Atom);};
		}
		public Grid(RL_LOc_Havr Parnt,Object LOc_SOrc,D2_Drawbl_TMplat TMplat,
			float X_LNg  ,float Y_LNg  ,
			float X_BtwEn,float Y_BtwEn)
		{
			this(Parnt,LOc_SOrc,
				 X_LNg,Y_LNg,
				 X_BtwEn,Y_BtwEn);
			CL_MAkr=(X,Y)->
					{return (CL_Typ)MAk_From_TMplat(X,Y,TMplat);};
		}
}