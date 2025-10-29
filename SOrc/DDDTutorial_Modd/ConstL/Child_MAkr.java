package DDDTutorial_Modd.ConstL;

public class Child_MAkr
{
	public StR Parnt;

	public String NAm,DisplA;

	@MAk_Fun
	public StR MAk(ConstLatn ConstLatn,StR_Typ Typ)
	{return ConstLatn.Ad_Child(Parnt,Typ,NAm,DisplA);}
	@Override
	public String toString()
	{return Parnt.Get_Child_NAm(NAm);}

	public Child_MAkr(StR Parnt,String NAm,String DisplA)
	{
		this.Parnt=Parnt;

		this.NAm=NAm;
		this.DisplA=DisplA;
	}
}