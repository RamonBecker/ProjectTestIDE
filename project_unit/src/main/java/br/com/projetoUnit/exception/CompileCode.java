package br.com.projetoUnit.exception;

public class CompileCode extends RuntimeException {

	public CompileCode(String erro) {
		System.out.println(erro);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello Word");
	}

}
