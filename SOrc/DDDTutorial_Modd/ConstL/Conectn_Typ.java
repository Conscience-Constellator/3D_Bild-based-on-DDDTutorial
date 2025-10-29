package DDDTutorial_Modd.ConstL;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import DDDTutorial_Modd.Registrbl;
import CC.Encycloped.Abs.Scal.Physc.NOd_Object;
import java.util.Map;
import java.util.HashMap;
import static DDDTutorial_Modd.Util.Get_If_String;

public class Conectn_Typ
	 extends		 Typ
{
	public double Fan;
		@Finishd(Is_Finishd=true)
		public static double Dfalt_Fan=16;
	public Object ShAp_SOrc;

	@Lin_DclAr
	public void Conect(NOd_Object A,NOd_Object B)
	{
		Conectn_ Conectn=new Conectn_(A,A,B,this);
		A.Conectng.add(Conectn);
		B.Conectng.add(Conectn);
	}

	public Conectn_Typ(String NAm,Object Material_SOrc,double Fan)
	{
		super(NAm,Material_SOrc);
		this.Fan=Fan;
		this.ShAp_SOrc=ShAp_SOrc;
	}
		public Conectn_Typ(String NAm,double Fan)
		{this(NAm,NAm,Fan);}
	public static Map<String,Registrbl> Registry=new HashMap<>();
		@Override
		public Map<String,Registrbl> Get_Registry()
		{return Registry;}
		public static Conectn_Typ Get_Typ(String NAm)
		{return (Conectn_Typ)Registry.get(NAm);}
			public static Conectn_Typ Get_Conectn_Typ(String NAm)
			{return Get_Typ(NAm);}
		public static Conectn_Typ Gar_Typ(Object Sorc)
		{return (Conectn_Typ)Get_If_String(Sorc,Registry);}
			public static Conectn_Typ Gar_Conectn_Typ(Object Sorc)
			{return Gar_Typ(Sorc);}
		static
		{
			new Conectn_Typ("Com",Dfalt_Fan);
			new Conectn_Typ("Oposit_A",Dfalt_Fan);
			new Conectn_Typ("Oposit_B",Dfalt_Fan);
			new Conectn_Typ("Oposit",Dfalt_Fan);
		}
}