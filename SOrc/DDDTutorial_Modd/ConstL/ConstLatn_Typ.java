package DDDTutorial_Modd.ConstL;

import CC.COd.Finishd;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.ConstL.Material;
import CC.Encycloped.Abs.Scal.Gom.Grid_Managr;
import DDDTutorial_Modd.Registrbl;
import java.util.Map;
import java.util.HashMap;
import static DDDTutorial_Modd.ConstL.Conectn_Typ.Dfalt_Fan;
import static DDDTutorial_Modd.ConstL.StR_Typ.Dfalt_StR_SIz;
import static DDDTutorial_Modd.Util.Get_If_String;

public class ConstLatn_Typ
	 extends		   Typ
{
	public	   StR_Typ	   StR_Typ;
	public Conectn_Typ Conectn_Typ;
		public void Set(StR_Typ StR,
					Conectn_Typ Conectn)
		{
				StR_Typ=StR;
			Conectn_Typ=Conectn;
		}

	public static int Dfalt_BtwEn=8;
	public static Grid_Managr Dfalt_StRg_Managr=new Grid_Managr(Dfalt_BtwEn);

	public ConstLatn_Typ(String NAm,Material Material,double StR_SIz,double Fan)
	{
		super(NAm);
		new PlAn_MAkr(NAm,this,Dfalt_StRg_Managr);
		Set(new		StR_Typ(NAm,Material,StR_SIz),
			new Conectn_Typ(NAm,Material,Fan	));
	}
	public ConstLatn_Typ(Object[] MEt,double StR_SIz,double Fan)
	{this((String)MEt[0],(Material)MEt[1],StR_SIz,Fan);}
		public ConstLatn_Typ(String NAm,Material Material)
		{this(NAm,Material,Dfalt_StR_SIz,Dfalt_Fan);}
	public ConstLatn_Typ(Object MEt,double StR_SIz,double Fan)
	{this(Get_MEt(MEt),StR_SIz,Fan);}
		public ConstLatn_Typ(Object MEt)
		{this(MEt,Dfalt_StR_SIz,Dfalt_Fan);}

	public static Map<String,Registrbl>		Registry=new HashMap<>();
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public	  Map<String,Registrbl> Get_Registry()
		{return				 Registry;}
		static
		{}
		public static ConstLatn_Typ Get_Typ(String NAm)
		{return (ConstLatn_Typ)Registry.get(NAm);}
			public static ConstLatn_Typ Get_ConstLatn_Typ(String NAm)
			{return Get_Typ(NAm);}
		public static ConstLatn_Typ Gar_Typ(Object SOrc)
		{return (ConstLatn_Typ)Get_If_String(SOrc,Registry);}
			public static ConstLatn_Typ Gar_ConstLatn_Typ(Object SOrc)
			{return Gar_Typ(SOrc);}
}
