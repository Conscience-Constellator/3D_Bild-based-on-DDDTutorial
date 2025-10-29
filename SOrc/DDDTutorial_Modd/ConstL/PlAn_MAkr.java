package DDDTutorial_Modd.ConstL;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.List.List_Managr;
import DDDTutorial_Modd.Registrbl;
import java.util.HashMap;
import java.util.Map;

import static DDDTutorial_Modd.Util.*;

public class PlAn_MAkr implements Registrbl
{
	public ConstLatn_Typ Typ;
	public List_Managr<RL_LOc_Havr> Managr;

	/**The 4 variants are all 4 combinations of the DOFs:
	 * A: Whether Parnt is passed as separate parameter.
	 * B: Whether the function is called on A, PlAn_MAkr, or SOrc of 1.*/
	/**Parnt separate*/
	public StR MAk(ConstLatn ConstLatn,Object Parnt_SOrc,Object[] StR_Sorcg)
	{return ConstLatn.Conect_To_PlAn(Parnt_SOrc,Managr,Typ,StR_Sorcg);}
	public static StR MAk(Object MAkr_SOrc,ConstLatn ConstLatn,Object Parnt_SOrc,Object[] StR_SOrcg)
	{return Gar_PlAn_MAkr(MAkr_SOrc).MAk(ConstLatn,Parnt_SOrc,StR_SOrcg);}
		/**Parnt included*/
		public StR MAk(ConstLatn ConstLatn,Object[] StR_Sorcg)
		{return MAk(ConstLatn,StR_Sorcg[0],SlIc(StR_Sorcg,1));}
		public static StR MAk(Object MAkr_Sorc,ConstLatn ConstLatn,Object[] StR_SOrcg)
		{return Gar_PlAn_MAkr(MAkr_Sorc).MAk(ConstLatn,StR_SOrcg);}

		public StR Oposit(ConstLatn ConstLatn,Object StM,String A,String B)
		{
			MAk(ConstLatn,StM,new Object[]{A,B});
			ConstLatn.Conect(
				A,B,
			Get_MAkr("Oposit"));

			return ConstLatn.Get_StR(A);
		}
		public void Opositg(ConstLatn ConstLatn,Object... StR_SOrcg)
		{
			for(int IndX=0;
					IndX<StR_SOrcg.length;
					IndX+=3)
			{
				Oposit(ConstLatn,
					StR_SOrcg[IndX],
					(String)StR_SOrcg[IndX+1],
					(String)StR_SOrcg[IndX+2]);
			}
		}

	public PlAn_MAkr(String NAm,ConstLatn_Typ Typ,List_Managr<RL_LOc_Havr> Managr)
	{
		Registr(NAm);
		this.Typ=Typ;
		this.Managr=Managr;
	}
		public static Map<String,Registrbl> Registry=new HashMap<>();
			@Override
			public Map<String,Registrbl> Get_Registry()
			{return Registry;}
			public static PlAn_MAkr Get_MAkr(String NAm)
			{return (PlAn_MAkr)Registry.get(NAm);}
				public static PlAn_MAkr Get_PlAn_MAkr(String NAm)
				{return Get_MAkr(NAm);}
			public static PlAn_MAkr Gar_MAkr(Object SOrc)
			{return (PlAn_MAkr)Get_If_String(SOrc,Registry);}
				public static PlAn_MAkr Gar_PlAn_MAkr(Object SOrc)
				{return Gar_MAkr(SOrc);}
}