package CC;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import CC.List.SLectn_NOd;
import CC.List.SLectn_NOd.IndX_Getr;
import CC.List.SLectn_NOd.SLectn_Ant;
import CC.List.SeqNtl_Map;
import DDDTutorial_Modd.D3.D3_Projectn;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Getbl;
import DDDTutorial_Modd.Object_MAkng.Object_MAkr;
import DDDTutorial_Modd.TRgetng_RsOrc;
import DDDTutorial_Modd.Voxl.*;

import java.util.Arrays;
import static CC.List.SLectn_NOd.Map_SIz;
import static CC.UI.Sig.Input_Havr.KE_AccSr;
import static DDDTutorial_Modd.Object_MAkng.Object_MAkr.MAk_Object_CNtrd;
import static DDDTutorial_Modd.Object_MAkng.Object_MAkr.MAk_Object_CNtrd_Movng;
import static DDDTutorial_Modd.Tool.SLectn_LIn_IndX;
import static CC.Encycloped.Abs.Org.Syc.TXt.Num.List$String;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.QOt;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.lang.System.out;

public class MAkng_RsOrc implements SpAc_Getbl<Physc_SpAc>
{
	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	public final Physc_SpAc Get_SpAc()
	{return TRgetng_RsOrc.Get_SpAc();}

	public boolean Do_Inherit_Trajectry=true;
	public TRgetng_RsOrc TRgetng_RsOrc;
	public SLectn_NOd MAk_TrE=new SLectn_NOd(
		Map_SIz,
		(IndX_Getr<SeqNtl_Map,?>)SeqNtl_Map::Get,
		Object_MAkr.Object_MAkrg,(Object)->{return Object instanceof SeqNtl_Map;});
	public SLectn_Ant Ant=new SLectn_Ant(MAk_TrE);
	@Finishd(Is_Finishd=false)
	public void MAk(boolean Is_Shiftd)
	{
		if(TRgetng_RsOrc.Get_TRget_Voxl_Grid() instanceof VrtX_Grid Grid)
		{
			Grid.PlAc_On_Voxl(((D3_Projectn)TRgetng_RsOrc.TRget_Drawbl).Get_Projectd(),(byte)1);
			return;
		}
		ScrEn ScrEn=TRgetng_RsOrc.ScrEn;
		RL_LOc_Havr Object=(Do_Inherit_Trajectry)?
			MAk_Object_CNtrd_Movng(SLectn_LIn_IndX(MAk_TrE),Get_SpAc(),ScrEn.PlAc_LOc,ScrEn.Get_Sistr_Physc("Tik_Tran")):
			MAk_Object_CNtrd(SLectn_LIn_IndX(MAk_TrE),Get_SpAc(),ScrEn.PlAc_LOc);
		out.println("Placed "+((Object!=null)?
			Object.getClass().getName()+" @ "+List$String(10,Object.Get_LOc_CoP_As_ArA()):
			null));
	}
		@Finishd(Is_Finishd=false)
		public void MAk()
		{MAk(KE_AccSr.Get(TRgetng_RsOrc.ScrEn,VK_ENTER).Is_On());}
	@Lin_DclAr @Finishd(Is_Finishd=false)
	public void MIn()
	{
		Object Object=TRgetng_RsOrc.Get_TRget_Object();
		if(Object instanceof Voxl Voxl)
		{
			Cub_Grid_ Grid=Voxl.Grid;
			int[] LOc=Grid.Get_Loc_SpAc$Grid(Voxl.Get_RL_LOc());
			out.println("Mined voxel@"+Arrays.toString(LOc));
			Grid.Set_Voxl(LOc,(byte)127);
		}
		else if(Object instanceof Polyhedron Polyhedron)
		{
			RL_LOc_Havr Parnt=Polyhedron.Get_Gom_PArnt();
			if(Parnt instanceof Grid_3D Grid)
			{
				int[] LOc=Grid.Get_TRgetbl_Voxl(((D3_Projectn)TRgetng_RsOrc.TRget_Drawbl).Get_Projectd());
				if(LOc!=null)
				{
					out.println("Mined voxel@"+Arrays.toString(LOc));
					Grid.Set_Voxl(LOc,(byte)127);
				}
				else
				{out.println("Unable to mine w/ null location");}
			}
			else if(Parnt instanceof SqAr_Grid Grid)
			{Grid.Intract(((D3_Projectn)TRgetng_RsOrc.TRget_Drawbl).Get_Projectd());}
		}
		out.println("Unhandlable type "+QOt(Object));
	}

	public Runnable[] MAk_MIn_PAr()
	{return new Runnable[]{
		this::MIn,
		this::MAk};
	}

	public MAkng_RsOrc(TRgetng_RsOrc TRgetng_RsOrc)
	{this.TRgetng_RsOrc=TRgetng_RsOrc;}
}