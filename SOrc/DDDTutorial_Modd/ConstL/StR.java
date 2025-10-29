package DDDTutorial_Modd.ConstL;

import CC.Encycloped.Abs.Scal.Physc.Colr.Colr_Havr;
import DDDTutorial_Modd.D2.TXt_At_Point;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import DDDTutorial_Modd.D3.D2$3;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Physc.NOd_Object;
import java.awt.*;
import static DDDTutorial_Modd.ConstL.StR_Typ.Gar_StR_Typ;
import static MAn.Physc_.SphEr_Atom;

public class StR extends NOd_Object implements Colr_Havr
{
	public StR_Typ Typ;
		@Override
		public Color Get_Colr()
		{return Typ.Get_Colr();}
		@Override
		public void Set_Colr(Color Colr)
		{Typ.Set_Colr(Colr);}

	public String AdrS;
		public D2$3 DisplA;
		public String Get_Child_NAm(String NAm)
		{return this.AdrS+"."+NAm;}

	@Override
	public String toString()
	{return AdrS;}

	public StR(RL_LOc_Havr Parnt,Object Loc_Sorc,
		Object Typ_Sorc,String AdrS,String DisplA)
	{
		super(Parnt,Loc_Sorc);
		Polyhedron Graphc=Get_Physc_LMNt_Cast("SEn");
		Typ=Gar_StR_Typ(Typ_Sorc);
		this.AdrS=AdrS;
			this.DisplA=new D2$3(new TXt_At_Point(DisplA,Get_Colr()),Graphc);
		Graphc.Set_Drawbl_Atomg(
			SphEr_Atom(Graphc,Typ.LNg,Typ.Get_Colr()),
			this.DisplA
		);

		UpdAt();

		Get_SpAc().Ad_Sortd_Object(this,"StR");
	}
		public StR(RL_LOc_Havr Parnt,Object LOc_SOrc,
				   Object Typ_SOrc,String AdrS)
		{this(Parnt,LOc_SOrc,Typ_SOrc,AdrS,AdrS);}

			public StR MAk_Child(Object Typ_SOrc,
								 String NAm,String DisplA)
			{
				return new StR(this,null,Typ_SOrc,
							   Get_Child_NAm(NAm),DisplA);
			}
				public StR MAk_Child(Object Typ_SOrc,
									 String NAm)
				{
					return MAk_Child(Typ_SOrc,
									 NAm, NAm);
				}
			public Child_MAkr MAk_Child_MAkr(String NAm,String DisplA)
			{return new Child_MAkr(this,NAm,DisplA);}
				public Child_MAkr MAk_Child_MAkr(String NAm)
				{return MAk_Child_MAkr(NAm,NAm);}
//	public static StR Gar_StR(Object Sorc,Object Typ_Sorc)
//	{
//		if(Sorc instanceof StR)
//		{return (StR)Sorc;}
//		else if(Sorc instanceof String)
//		{
//			return new StR()
//		}
//	}
}