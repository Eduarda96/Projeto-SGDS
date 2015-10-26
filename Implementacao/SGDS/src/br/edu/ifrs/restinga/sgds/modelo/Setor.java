package br.edu.ifrs.restinga.sgds.modelo;

public class Setor {
//Classe para manipulação do setor;
	private int codSetor;
	private String nome;
	private String nomeResponsavel;
	private Setor setorResponsavel;
	private String descricao;
	private String email;
	private boolean ativo;
	
	public int getCodSetor() {
		return codSetor;
	}
	public void setCodSetor(int codSetor) {
		this.codSetor = codSetor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public Setor getSetorResponsavel() {
		return setorResponsavel;
	}
	public void setSetorResponsavel(Setor setorResponsavel) {
		this.setorResponsavel = setorResponsavel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	//Validações
	public boolean validarAlfabetico(String validar) {
		char[] test = validar.toCharArray();
		for (char t : test) {
			if (!Character.isLetter(t)) {
				return false;
			}
		}
		return true; 
	}
	public boolean validaEmail(String validar) {
		char[] test = validar.toCharArray();
		for (char t : test) {
			if (!Character.isLetterOrDigit(t)) {
				if (!"@".equals(t)) {
					return false;
				}
			}
		}
		setEmail(validar);
		return true;
	}
}
