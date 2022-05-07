package com.demo;

public class Matrix {
	private int[][] cols;
  
	public Matrix(int[][] cols) {
		this.cols = cols;
	}
	
	//TODO:正方行列か否かで判定させて例外処理したい。
	public int getMatrixSize() {
		return cols.length;
	}

	private int productFor(Permutation p) {
		int product = 1;
		for(int i = 0; i < this.cols.length; i++) {
			product = product * this.cols[i][p.val.get(i)];
		}
		return product;
	}

	private int productIncludingSinatureFor(Permutation p) {
		return p.signature().val * this.productFor(p);
	}

	public int determinant() {
		int det = 0;
		SymmetricGroup sg = new SymmetricGroup(this.getMatrixSize());
		for(int i = 0; i < sg.elements.size(); i++) {
			det = det + productIncludingSinatureFor(sg.elements.get(i));
		}
		return det;
	}

}