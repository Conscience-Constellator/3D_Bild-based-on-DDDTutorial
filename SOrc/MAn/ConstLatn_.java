package MAn;

import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import DDDTutorial_Modd.ConstL.*;
import CC.Encycloped.Abs.Scal.Gom.LOc;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;

import static CC.Philosophy.Ad_Philosophy;
import static DDDTutorial_Modd.ConstL.ConstLatn_Typ.Get_ConstLatn_Typ;

public class ConstLatn_
{
	public static void Ad_ConstLatn(Physc_SpAc SpAc,ScrEn ScrEn)
	{
		ConstLatn ConstLatn=new ConstLatn(SpAc,null);

		ConstLatn_Typ
			Philosophy_Typ=Get_ConstLatn_Typ("Philosophy");

		double Triagnl=10;
		ConstLatn.Ad_StR(new StR(SpAc,
			new LOc(Triagnl,Triagnl,Triagnl),
			Philosophy_Typ.StR_Typ,"Philosophy"));
		Triagnl+=40;
		ConstLatn.Ad_StR(new StR(SpAc,
			new LOc(Triagnl,Triagnl,Triagnl),
			Philosophy_Typ.StR_Typ,"ConstLatn"));
		ConstLatn.Ad_StR(new StR(ConstLatn,
			new LOc(Triagnl,Triagnl,Triagnl),
			"Library","CCJL"));
		PlAn_MAkr
			Philosophy_MAkr=PlAn_MAkr.Get_MAkr("Philosophy");

//			ConstLatn.Conect(Oposit_Conectn_Typ,V(
//				"For","Against",
//				"Good","Bad"
//			));
//			ConstLatn.Conect(
//				"UnintNtnl",
//				"AccidNtl",
//			Dfalt_Typ.Conectn_Typ);

//		ConstLatn.Conect(
//			"IntrpolAt","Draw_IntrpolAt",
//		Com_Conectn_Typ);
		Ad_Philosophy(ConstLatn);
		Ad_ConstLatn_Object(ConstLatn);
		Ad_ConstLatory(ConstLatn);
//		ConstLatn.UpdAt_PlAng();
		if(false)
		{
			double[] VEw_From=ScrEn.LOc_Cach,
					 StRt=ConstLatn.Get_StR("ConstLatory").Get_LOc_CoP_As_ArA();
			VEw_From[0]=StRt[0]+10;
			VEw_From[1]=StRt[1];
			VEw_From[2]=StRt[2];
			ScrEn.TLeport(ConstLatn.Get_StR("ConstLatory"));
		}
	}
	public static void Ad_ConstLatn_Object(ConstLatn ConstLatn)
	{
		PlAn_MAkr.MAk("Ncyclopedia",
			ConstLatn,"ConstLatn",new Object[]{
				new Object[]{"Subject",
					new Object[]{"ConstLatn",
						new Object[]{"Programng NtiT",
							"Typ",
							"Fun",
						},
					},
				},
		});
	}
	public static void Ad_ConstLatory(ConstLatn ConstLatn)
	{
		/*
		PlAn_MAkr.MAk("Ncyclopedia",
			ConstLatn,"ConstLatory",new Object[]{
				new Object[]{"DDDTutorial_Modd",
					new Object[]{"ConstL",
						"Conectn",
					},
				},
					new Object[]{"Gom",
						"Vectr",
					},
					"Calculatr",
					"Colrd_Polyhedron",
					"MAn",
					"Input_Havr",
				},

			new Object[]{"TSt",
			},
		});*/
	}
	//</editor-fold>
}