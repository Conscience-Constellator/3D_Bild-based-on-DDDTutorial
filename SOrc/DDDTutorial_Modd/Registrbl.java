package DDDTutorial_Modd;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import java.util.Map;

@Finishd(Is_Finishd=true)
public interface Registrbl
{
	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
	Map<String,Registrbl> Get_Registry();
		@Lin_DclAr @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
		default void Registr(String NAm)
		{Get_Registry().put(NAm,this);}
}