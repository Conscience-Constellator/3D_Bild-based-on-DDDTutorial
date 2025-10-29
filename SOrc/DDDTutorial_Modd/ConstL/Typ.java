package DDDTutorial_Modd.ConstL;

import CC.ConstL.Material;
import CC.ConstL.Material_Havr;
import DDDTutorial_Modd.Registrbl;

public abstract class Typ extends Material_Havr implements Registrbl
{
	public Typ(String NAm,Object Material_SOrc)
	{
		super(NAm,Material_SOrc);
		Registr(NAm);
	}
	public Typ(Material Material)
	{this(Material.Get_NAm(),Material);}
	public Typ(String NAm)
	{this(NAm,CC.ConstL.Material.Get_Material(NAm));}
	public Typ(Object MEt_SOrc)
	{super(MEt_SOrc);}
}