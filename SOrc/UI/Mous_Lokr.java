package UI;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Robot;
import static DDDTutorial_Modd.Crsr.CNtr_Mous;
import static DDDTutorial_Modd.Crsr.Norml_Crsr;
import static DDDTutorial_Modd.Crsr.Invisbl_Crsr;
import static java.lang.System.out;

public class Mous_Lokr
{
	public Component Com;
	private boolean Is_Lokd;
		public boolean Get_Is_Lokd()
		{return Is_Lokd;}
		public void Set_Is_Lokd(boolean Is)
		{Is_Lokd=Is;}
			@Finishd(Is_Finishd=true)
			public void Lok()
			{
				Set_Is_Lokd(true);
				Invisbl_Crsr(Com);

				out.println("Crsr lokd");
			}
			@Finishd(Is_Finishd=true)
			public void Unlok()
			{
				Set_Is_Lokd(false);
				Norml_Crsr(Com);

				out.println("Crsr unlokd");
			}
			@Finishd(Is_Finishd=false)
			public void CNtr_Mous_If_Lokd()
			{
				if(Get_Is_Lokd())
				{CNtr_Mous(Com,Robot);}
			}

	public Robot Robot;

	public Mous_Lokr(Component Com,boolean Is)
	{
		this.Com=Com;
		Set_Is_Lokd(Is);
		try
		{Robot=new Robot();}
		catch(AWTException X)
		{X.printStackTrace();}
	}
		public Mous_Lokr(Component Com)
		{this(Com,false);}
}