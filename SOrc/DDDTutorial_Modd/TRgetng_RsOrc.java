package DDDTutorial_Modd;

import CC.COd.Finishd;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.$.$Q.$Point;
import DDDTutorial_Modd.D2.D2_Drawbl_Atom;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon.D2_Polygon;
import DDDTutorial_Modd.D3.D3_Projectn;
import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import CC.Encycloped.Abs.Scal.Physc.SIt.Hilitr;
	import CC.Encycloped.Abs.Scal.Physc.SIt.Hilitr.Clarfier;
	import CC.Encycloped.Abs.Scal.Physc.SIt.Hilitr.Colrd_Hilitr;

import static CC.Encycloped.Abs.Org.Syc.TXt.Num.Dfalt_Mantisa_Lim;
import static CC.Encycloped.Abs.Org.Syc.TXt.Num.List$String;
import static CC.Encycloped.Abs.Scal.Physc.ScrEn.Mov_Cam_COd;
import static CC.List.ArA_X.IndX;
import static CC.UI.Sig.Input_Havr.KE_AccSr;
import static CC.Math.Arithmetc.Mul;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.ClEr;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.Ultraviolet;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Getbl;
import DDDTutorial_Modd.Voxl.*;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;
import static CC.Encycloped.Abs.Org.Comput.Bi.Bi.Ad_Xr_Rmov;
import static CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl_Int2.Get_Ing;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.*;

import java.util.List;
import static java.awt.event.KeyEvent.VK_SHIFT;
import static java.lang.System.out;

public class TRgetng_RsOrc implements SpAc_Getbl<Physc_SpAc>
{
	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	public final Physc_SpAc Get_SpAc()
	{return ScrEn.Get_SpAc();}

	public ScrEn ScrEn;

	public <Atom_Typ extends D2_Drawbl_Atom>List<Atom_Typ> Get_Drawblg_In(int Num,Atom_Typ... Atomg)
	{return Get_Ing(Mul(ScrEn.CroshAr_.LOc,(!false)?-ScrEn.Zoom:1),Num,Atomg);}
	public <Atom_Typ extends D2_Drawbl_Atom>List<Atom_Typ> Get_Drawblg_In(int Num,List<Atom_Typ> Atomg)
	{return Get_Ing(Mul(ScrEn.CroshAr_.LOc,(!false)?-ScrEn.Zoom:1),Num,Atomg);}
	public List<? extends D2_Drawbl_Atom> TRget_Drawblg;
	public D2_Drawbl_Atom TRget_Drawbl=null;
		public static boolean Is_TRgetbl(Polyhedron Object,D3_Drawbl_Atom Atom)
		{
			if(Object instanceof Voxl Voxl)
			{
				Cub_Grid_ Grid=Voxl.Grid;

				return Grid.Get_Voxl_Typ(
					Grid.Get_Loc_SpAc$Grid(
						Voxl.Get_RL_LOc()
					)).Is_TRgetbl();
			}
			else if(Object.Get_Gom_PArnt() instanceof Grid_3D Grid)
			{
				int[] Loc=Grid.Get_TRgetbl_Voxl(Atom);

				return true;
//					Loc!=null&&
//					Grid.Is_TRgetbl_Voxl(Loc);
			}
			else
			{return true;}

//			return !(
//				(Object instanceof Voxl Voxl)&&
//				!Get_TRget_Voxl_Grid().Get_Blok_Typ(
//					Voxl.Grid.Get_Loc_Grid_By_SpAc(
//					Voxl.Get_RL_Loc()
//				)).Is_SLectbl()
//			);
		}
		public Hilitr Object_Hilitr=switch(0){
			case 0->new Colrd_Hilitr(ClEr,8);
			case 1->new Colrd_Hilitr(Ultraviolet,8);
			case 2->new Clarfier(128,8);
			default->null;
		};
		public boolean TRget_Ny=!false;
			public void Togl_TRget_Ny()
			{TRget_Ny=!TRget_Ny;}
		public <Atom_Typ extends D2_Drawbl_Atom>void Set_TRget_Drawbl(int Num,Atom_Typ... Atomg)
		{
			Polyhedron TRget_Object;

			//<editor-fold desc="ClEr tRget data">
			if(TRget_Drawbl!=null)
			{
				TRget_Object=Get_TRget_Object();
				if(TRget_Object!=null)
				{TRget_Object.Rmov_Efect(null);}
				else
				{TRget_Drawbl.Rmov_Efect(null);}
				TRget_Drawbl=null;
			}
			//</editor-fold>

			TRget_Drawblg=Get_Drawblg_In(Num,Atomg);
			for(D2_Drawbl_Atom TRget_Drawbl:TRget_Drawblg)
			{
				if(
					(TRget_Ny||TRget_Drawbl.Get_Is_TRgetbl())//&&
//					!(TRget_Drawbl instanceof Atom_Projectn Projectn&&Projectn.Do_Draw())
				)
				{
					if(TRget_Drawbl instanceof D3_Projectn<?> Projectn)
					{
						D3_Drawbl_Atom D3=Projectn.Get_Projectd();
						TRget_Object=D3.Get_Parnt();
						if(Is_TRgetbl(TRget_Object,D3))
						{
//							out.println("Targeting "+QOt(TRget_Object)+" @Atom "+QOt(TRget_Drawbl)+TRget_Drawbl.Polyhedron);

							this.TRget_Drawbl=TRget_Drawbl;
//							TRget_Drawbl.Efect=new Tran_Ovr(new Color(0,0,255,
//								((Colrd_Hilitr)Object_Hilitr).Get_Colr().getAlpha()/2)
//							);
							if(TRget_Object!=null)
							{
								Object_Hilitr.Hilit(TRget_Object,
									D3);
							}

							break;
						}
					}
					else
					{
						;
					}
				}
			}
		}
		public <Atom_Typ extends D2_Drawbl_Atom>void Set_TRget_Drawbl(int Num,List<Atom_Typ> Atomg)
		{
			Polyhedron TRget_Object;

			//<editor-fold desc="ClEr tRget data">
			if(TRget_Drawbl!=null)
			{
				TRget_Object=Get_TRget_Object();
				if(TRget_Object!=null)
				{TRget_Object.Rmov_Efect(null);}
				else
				{TRget_Drawbl.Rmov_Efect(null);}
				TRget_Drawbl=null;
			}
			//</editor-fold>

			TRget_Drawblg=Get_Drawblg_In(Num,Atomg);
			for(D2_Drawbl_Atom TRget_Drawbl:TRget_Drawblg)
			{
				if(
					(TRget_Ny||TRget_Drawbl.Get_Is_TRgetbl())//&&
					//TRget_Drawbl.Do_Draw()
				)
				{
					if(TRget_Drawbl instanceof D3_Projectn<?> Projectn)
					{
						D3_Drawbl_Atom D3=Projectn.Get_Projectd();
						TRget_Object=D3.Get_Parnt();
						if(Is_TRgetbl(TRget_Object,D3))
						{
//							out.println("Targeting "+QOt(TRget_Object)+" @Atom "+QOt(TRget_Drawbl)+TRget_Drawbl.Polyhedron);

							this.TRget_Drawbl=TRget_Drawbl;
//							TRget_Drawbl.Efect=new Tran_Ovr(new Color(0,0,255,
//								((Colrd_Hilitr)Object_Hilitr).Get_Colr().getAlpha()/2)
//							);
							if(TRget_Object!=null)
							{
								Object_Hilitr.Hilit(TRget_Object,
									D3);
							}

							break;
						}
					}
					else
					{
						;
					}
				}
			}
		}
			public void Set_TRget_Drawbl()
			{Set_TRget_Drawbl(
				ScrEn.Draw_Rsorc.Do_Draw_Num,
				ScrEn.Draw_Rsorc.Draw_Ordr);
			}
	public Object SLectd;
		public void Set_SLectd(Object SLectd)
		{
			this.SLectd=SLectd;
			ScrEn.Mov_Actn_COd=(KE_AccSr.Get(ScrEn,VK_SHIFT).Is_On())?
				ScrEn.Mov_Actn_COd:
				Ad_Xr_Rmov(
					ScrEn.Mov_Actn_COd,
					Mov_Cam_COd,
				(SLectd==null));
		}
			public void Set_SLectd()
			{
				Polyhedron TRget=Get_TRget_Object();
				Set_SLectd((TRget!=SLectd)?
					TRget:
					null);
			}
		public void DlEt_SLectd()
		{
			if(SLectd instanceof Polyhedron Polyhedron)
			{
				if(Polyhedron.Get_Gom_PArnt() instanceof SpAc_Object Object)
				{Object.Rmov_From_SpAc();}
				else
				{Polyhedron.Rmov();}
				Set_SLectd(null);
			}
		}
	public Polyhedron Get_TRget_Object()
	{
		return (TRget_Drawbl instanceof D3_Projectn<?> Projectn)?
			Projectn.Get_Projectd().Get_Parnt():
			null;
	}
	public String Get_TRget_Object_Loc(int Lim)
	{
		RL_LOc_Havr Object=Get_TRget_Object();

		return (Object!=null)?
			Object.LOc$String(Lim):
			null;
	}
	public String Get_SLectd_Object_Loc(int Lim)
	{
		return (SLectd instanceof RL_LOc_Havr SLectd)?
			SLectd.LOc$String(Lim):
			null;
	}
	public Integer Get_IndX_In_Polyhedron()
	{
		Polyhedron Object=Get_TRget_Object();

		return (Object!=null)?
			IndX(Object.Drawbl_Atomg,TRget_Drawbl):
			null;
	}
	public String Get_TRget_VrtXg(int Lim)
	{
		D2_Drawbl_Atom D2=TRget_Drawbl;

		if(D2 instanceof D2_Polygon Polygon)
		{
			Drawbl_D3_Polygon D3=Polygon.Get_Projectd();
			StringBuilder VrtXg=new StringBuilder();
			for(int IndX=0;
				IndX<D3.Get_LOc_Num();
				IndX+=1)
			{
				double[] D3_VrtX=D3.Get_LOc(IndX);
				int[] D2_VrtX=Polygon.Get_VrtX_Int(IndX);
				VrtXg.
					append(List$String(Lim,D3_VrtX)).
					append("(").
						append(D2_VrtX[0]).append(",").
						append(D2_VrtX[1]).
					append(")").append(",");
			}

			return VrtXg.toString();
		}
		else
		{return null;}
	}
	public String Get_TRget_FAc_Norml(int Lim)
	{
		if(
			TRget_Drawbl instanceof D2_Polygon Polygon&&
			Polygon.Get_LOc_Num()>=3)
		{return Polygon.Get_Projectd().CoP_FAc_Norml().toString_Lim(Lim);}
		return null;
	}
	public Voxl_Grid Get_TRget_Voxl_Grid()
	{
		Polyhedron Object=Get_TRget_Object();

		return
			(Object instanceof Voxl Voxl)?Voxl.Grid:
			(
				Object!=null&&
				Object.Get_Gom_PArnt() instanceof VrtX_Grid Grid
			)?Grid:
			null;
	}
	public int[] Get_TRget_Voxl_Loc()
	{
		Voxl_Grid Grid=Get_TRget_Voxl_Grid();

		return
			(Grid instanceof Cub_Grid_ Grid_)?
				Grid_.Find_Loc((Voxl)Get_TRget_Object()):
			(Grid instanceof VrtX_Grid Grid_)?
				Grid_.Get_TRgetbl_Voxl((D3_Drawbl_Atom<?>)((D3_Projectn<?>)TRget_Drawbl).Get_Projectd()):
			null;
	}
	public String Get_Visbl_SIdg()
	{
		int[] Loc=Get_TRget_Voxl_Loc();
		if(Loc!=null)
		{
			int
				X=Loc[0],
				Y=Loc[1],
				Z=Loc[2];
			Voxl_Grid Grid=Get_TRget_Voxl_Grid();

			return (Grid instanceof Cub_Grid Cub_Grid)?
				Bool$String(Cub_Grid.Is_XB_Visbl(X,Y,Z))+","+
				Bool$String(Cub_Grid.Is_XT_Visbl(X,Y,Z))+","+
				Bool$String(Cub_Grid.Is_YB_Visbl(X,Y,Z))+","+
				Bool$String(Cub_Grid.Is_YT_Visbl(X,Y,Z))+","+
				Bool$String(Cub_Grid.Is_ZB_Visbl(X,Y,Z))+","+
				Bool$String(Cub_Grid.Is_ZT_Visbl(X,Y,Z)):
				null;
		}
		return null;
	}
	public $Point<String>[] TRget_HUD()
	{
		int[] Voxl_LOc=Get_TRget_Voxl_Loc();
		int Lim=
			Dfalt_Mantisa_Lim
//			10
		;

		return new $Point[]{
			()->
			{
				return FEld$String("Voxel coords",((Voxl_LOc!=null)?List$String(Lim,Voxl_LOc):
																		   null));
			},
			()->{return FEld$String("Visible sides",Get_Visbl_SIdg());},
			()->{return FEld$String("Selected",SLectd);},
			()->{return FEld$String("Parent",(SLectd!=null)?
				((RL_LOc_Havr)SLectd).Get_Gom_PArnt():
				null);},
			()->{return FEld$String("Face normal",Get_TRget_FAc_Norml(Lim+20));},
			()->{return FEld$String("Target "+((TRget_Ny)?"any":"targetable"),TRget_Drawblg);},
			()->{return
				FEld$String(
					"Coords",
					Get_TRget_Object_Loc(Lim)+
						"("+FEld$String("Selected",Get_SLectd_Object_Loc(Lim))+")");
			},
			()->{return FEld$String("Index in polyhedron",Get_IndX_In_Polyhedron());},
			()->{return FEld$String("Vertices",Get_TRget_VrtXg(Lim));}
		};
	}
	@Finishd(Is_Finishd=false)
	public Runnable[] Transparnt_PAr()
	{
		return new Runnable[]{
			()->{
				if(TRget_Drawbl instanceof D3_Projectn<?> Projectn)
				{
					Projectn.Set_Is_Transparnt(false);
					out.println("Turned !transparent");
				}
			},
			()->{
				if(TRget_Drawbl instanceof D3_Projectn<?> Projectn)
				{
					Projectn.Set_Is_Transparnt(true);
					out.println("Turned transparent");
				}
			}
		};
	}

	public TRgetng_RsOrc(ScrEn ScrEn)
	{
		this.ScrEn=ScrEn;
	}
}