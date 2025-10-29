package DDDTutorial_Modd.ConstL;

import CC.COd.Lin_DclAr;

import DDDTutorial_Modd.D2.Bound_Colr_Filr;
import DDDTutorial_Modd.D3.D2$3;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr.RL_LOc_Havr_ConcrEt;
import DDDTutorial_Modd.D3.Polyhedron;

public class Conectn_<NOd_Typ extends RL_LOc_Havr> extends RL_LOc_Havr_ConcrEt
{
	public NOd_Typ A,B;
		public void Set_StRg(
			NOd_Typ A,
			NOd_Typ B)
		{
			if(this.A!=null){this.A.Get_UpdAt_Lisnrg().remove(this);}
			A.Get_UpdAt_Lisnrg().add(this);
			this.A=A;
			if(this.B!=null){this.B.Get_UpdAt_Lisnrg().remove(this);}
			B.Get_UpdAt_Lisnrg().add(this);
			this.B=B;
		}
		@Lin_DclAr
		public NOd_Typ Othr(NOd_Typ _1)
		{
			NOd_Typ A=this.A;
			return (_1==this)?B:A;
		}
	public double Fan;

	public Conectn_(RL_LOc_Havr Parnt,
		NOd_Typ A,
		NOd_Typ B,
//		Polyhedron Polyhedron,
		Conectn_Typ Typ)
	{
		super(Parnt,null);
		Set_StRg(A,B);
		Polyhedron Graphc=new Polyhedron(this,null);
		Graphc.Set_Drawbl_Atomg(
			new D2$3(new Conectn_2D_Dif((float)Typ.Fan*5,new Bound_Colr_Filr(Typ.Get_Colr())),
				A,B));

		UpdAt();
	}
}