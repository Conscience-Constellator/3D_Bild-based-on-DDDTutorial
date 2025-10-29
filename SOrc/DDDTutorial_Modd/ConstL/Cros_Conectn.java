package DDDTutorial_Modd.ConstL;

import CC.COd.Finishd;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import DDDTutorial_Modd.D3.Colrd_Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import java.awt.*;

public abstract class Cros_Conectn extends Colrd_Polyhedron
{
	public RL_LOc_Havr A,B;
		public void Set_StRg(RL_LOc_Havr A,
							 RL_LOc_Havr B)
		{
			this.A=A;
			this.B=B;
		}
	public double Fan;

	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	public int Polygon_Num()
	{return 3;}
		@Override @Finishd(Is_Finishd=false)
		public void UpdAt_Polygong(double X,double Y,double Z)
		{
			Do_Somthing_W_Polygong();

			Set_Polygong(this,Drawbl_Atomg,
						 X,Y,Z);
		}

	@Finishd(Is_Finishd=false)
	public Cros_Conectn(RL_LOc_Havr Parnt)
	{super(Parnt,null);}
	@Finishd(Is_Finishd=false)
	public Cros_Conectn(RL_LOc_Havr Parnt,
						RL_LOc_Havr A,
						RL_LOc_Havr B,
						double Fan,Color Colr)
	{
		this(Parnt);
		Set_StRg(A,B);
		Set_LNg(Fan,Fan,Fan);
		this.Fan=Fan;
		Set_Filr(Colr);
		Init_Drawblg(null);
	}
		@Finishd(Is_Finishd=false)
		public Cros_Conectn(RL_LOc_Havr A,
							RL_LOc_Havr B,
							double Fan,Color Colr)
		{this(A.Get_SpAc(),A,B,Fan,Colr);}
}