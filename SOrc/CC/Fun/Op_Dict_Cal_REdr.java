package CC.Fun;

import java.util.Map;

public abstract class Op_Dict_Cal_REdr<Op_COd> extends Comand_REdr
{
	public Op_Dict_Cal_REdr(Map<Op_COd,?> Opg)
	{this.Opg=Opg;}

	public Map<Op_COd,?> Opg;
		public void REd(Op_COd COd)
		{}
}