package DDDTutorial_Modd;

import java.util.Map;
import static CC.List.ArA_X.New_Inst;
import static java.lang.System.arraycopy;

public class Util
{
	public static <Typ>Typ Nul_Chek(Typ Point)
	{
		if(Point==null)
		{throw new NullPointerException();}
		else
		{return Point;}
	}
	public static <Typ>Typ Cast(Object Point)
	{return (Typ)Point;}

	//<editor-fold desc="SlIc">
	public static  <Typ>void SlIc(Typ[] From,Typ[] To,int Ofset)
	{arraycopy(From,Ofset,To,0,To.length);}
		public static <Typ>Object[] SlIc(Typ[] From,Class<Typ> Typ,int Ofset)
		{
			Typ[] To=New_Inst(Typ,From.length-Ofset);
			SlIc(From,To,Ofset);

			return To;
		}
			public static <Typ>Object[] SlIc(Typ[] From,int Ofset)
			{return SlIc(From,Object.class,Ofset);}
	//</editor-fold>

	public static <Typ>Typ Get_If_String(Object Sorc,Map<String,Typ> List)
	{
		return //Nul_Chek(
			(Sorc instanceof String NAm)?List.get(NAm):
			(Typ)Sorc
//		)
		;
	}

	public static String Bool_To_Onf(boolean Bool)
	{
		return (Bool)?
			"On":
			"Off";
	}
}