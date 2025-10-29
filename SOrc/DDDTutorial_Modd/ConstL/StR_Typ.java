package DDDTutorial_Modd.ConstL;

import CC.COd.Finishd;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.ConstL.Material;
import CC.Encycloped.Abs.Scal.Physc.Colr.Colr_Havr;
import DDDTutorial_Modd.Registrbl;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import static DDDTutorial_Modd.Util.Get_If_String;

public class StR_Typ extends Typ implements Colr_Havr
{
	public double LNg;
		public static double Dfalt_StR_SIz=
			2
//			16
//			256
		;

	public StR_Typ(String NAm,Material Material,double LNg)
	{
		super(NAm,Material);
		this.LNg=LNg;
	}
		public StR_Typ(Object[] MEt,double LNg)
		{this((String)MEt[0],(CC.ConstL.Material)MEt[1],LNg);}
			public StR_Typ(Object MEt,double LNg)
			{this(Get_MEt(MEt),LNg);}

	public static Map<String,Registrbl> Registry=new HashMap<>();
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public Map<String,Registrbl> Get_Registry()
		{return Registry;}
		public static StR_Typ Get_Typ(String NAm)
		{return (StR_Typ)Registry.get(NAm);}
			public static StR_Typ Get_StR_Typ(String NAm)
			{return Get_Typ(NAm);}
		public static StR_Typ Gar_Typ(Object SOrc)
		{return (StR_Typ)Get_If_String(SOrc,Registry);}
			public static StR_Typ Gar_StR_Typ(Object SOrc)
			{return Gar_Typ(SOrc);}
		static
		{
			new StR_Typ("Library",Dfalt_StR_SIz);
			new StR_Typ("Java_IntrfAc",Dfalt_StR_SIz);
		}
}