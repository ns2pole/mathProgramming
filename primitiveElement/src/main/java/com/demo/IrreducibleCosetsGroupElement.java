package com.demo;

public class IrreducibleCosetsGroupElement extends GroupElement<ModInteger>{
	//TODO:10を法として2みたいなケースを例外処理。
	public IrreducibleCosetsGroupElement(ModInteger m) {
		super(m);
		this.affiliationGroup = IrreducibleCosetsGroup.getIrreducibleCosetsGroup(m.modulo);
	}

	@Override
	public IrreducibleCosetsGroupElement getNthPower(Integer n) {
		GroupElement<ModInteger> ge = super.getNthPower(n);
		return new IrreducibleCosetsGroupElement(ge.val);
	}

//	public boolean equals(Object o) {
//		IrreducibleCosetsGroupElement icge = (IrreducibleCosetsGroupElement) o;
//		return icge.val.equals(this.val) && icge.affiliationGroup.equals(this.affiliationGroup);
//	}

}