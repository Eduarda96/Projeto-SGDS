package br.edu.ifrs.restinga.sgds.modelo;

import java.sql.Date;

public class Servidor {
	
	private int codServidor;
	private String nome;
	private String nomeMae;
	private String nomePai;
	private String matriculaSiape;
	private String senha;
	private String perfil;
	private String sexo; 
	private Date dataNascimento;
	private String emailInstitucional;
    private String estadoCivil;
    private String endereco;
    private String numeroComplemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String telefoneResidencial;
    private String telefoneCelular;
    /*
    private String naturalidade;
    private String uf;
    private String nacionalidade;
    private String escolaridade;
    private String tipoSanguineoFatorRh;
    private String cpf;
    private String rg;
    private String orgaoExpeditor;
    private String ufRg;
    private Date dataExpedicao;
    private String tituloEleitor;
    private String ufTitulo;
    private String zona;
    private String sessao;
    private Date dataEmissaoTitulo;
    private String documentoMilitar;
    private String serie;
    private String orgaoExpeditorMilitar;
    private String carteiraTrabalho;
    private String serieCarteira;
    private String UFCarteira;
    private String pisPasep;
    private Date dataPrimeiroEmprego;
    private String bancoContaBancaria;
    private String agencia;
    private String numero;
    private int motorista; // tinyint
    private String cnh;
    */
    private int status; // tinyint
    /*
    private String formacaoExedente;
    private String formacaoExedente2;
    private String informacoesComplementares;
    */
	public int getCodServidor() {
		return codServidor;
	}
	public void setCodServidor(int codServidor) {
		this.codServidor = codServidor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getMatriculaSiape() {
		return matriculaSiape;
	}
	public void setMatriculaSiape(String matriculaSiape) {
		this.matriculaSiape = matriculaSiape;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmailInstitucional() {
		return emailInstitucional;
	}
	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumeroComplemento() {
		return numeroComplemento;
	}
	public void setNumeroComplemento(String numeroComplemento) {
		this.numeroComplemento = numeroComplemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	/*
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getTipoSanguineoFatorRh() {
		return tipoSanguineoFatorRh;
	}
	public void setTipoSanguineoFatorRh(String tipoSanguineoFatorRh) {
		this.tipoSanguineoFatorRh = tipoSanguineoFatorRh;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}
	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}
	public String getUfRg() {
		return ufRg;
	}
	public void setUfRg(String ufRg) {
		this.ufRg = ufRg;
	}
	public Date getDataExpedicao() {
		return dataExpedicao;
	}
	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}
	public String getTituloEleitor() {
		return tituloEleitor;
	}
	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
	public String getUfTitulo() {
		return ufTitulo;
	}
	public void setUfTitulo(String ufTitulo) {
		this.ufTitulo = ufTitulo;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getSessao() {
		return sessao;
	}
	public void setSessao(String sessao) {
		this.sessao = sessao;
	}
	public Date getDataEmissaoTitulo() {
		return dataEmissaoTitulo;
	}
	public void setDataEmissaoTitulo(Date dataEmissaoTitulo) {
		this.dataEmissaoTitulo = dataEmissaoTitulo;
	}
	public String getDocumentoMilitar() {
		return documentoMilitar;
	}
	public void setDocumentoMilitar(String documentoMilitar) {
		this.documentoMilitar = documentoMilitar;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getOrgaoExpeditorMilitar() {
		return orgaoExpeditorMilitar;
	}
	public void setOrgaoExpeditorMilitar(String orgaoExpeditorMilitar) {
		this.orgaoExpeditorMilitar = orgaoExpeditorMilitar;
	}
	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}
	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}
	public String getSerieCarteira() {
		return serieCarteira;
	}
	public void setSerieCarteira(String serieCarteira) {
		this.serieCarteira = serieCarteira;
	}
	public String getUFCarteira() {
		return UFCarteira;
	}
	public void setUFCarteira(String uFCarteira) {
		UFCarteira = uFCarteira;
	}
	public String getPisPasep() {
		return pisPasep;
	}
	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}
	public Date getDataPrimeiroEmprego() {
		return dataPrimeiroEmprego;
	}
	public void setDataPrimeiroEmprego(Date dataPrimeiroEmprego) {
		this.dataPrimeiroEmprego = dataPrimeiroEmprego;
	}
	public String getBancoContaBancaria() {
		return bancoContaBancaria;
	}
	public void setBancoContaBancaria(String bancoContaBancaria) {
		this.bancoContaBancaria = bancoContaBancaria;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getMotorista() {
		return motorista;
	}
	public void setMotorista(int motorista) {
		this.motorista = motorista;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFormacaoExedente() {
		return formacaoExedente;
	}
	public void setFormacaoExedente(String formacaoExedente) {
		this.formacaoExedente = formacaoExedente;
	}
	public String getFormacaoExedente2() {
		return formacaoExedente2;
	}
	public void setFormacaoExedente2(String formacaoExedente2) {
		this.formacaoExedente2 = formacaoExedente2;
	}
	public String getInformacoesComplementares() {
		return informacoesComplementares;
	}
	public void setInformacoesComplementares(String informacoesComplementares) {
		this.informacoesComplementares = informacoesComplementares;
	}
	*/
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean validaTextoAlfabetico(String texto) {
		for (char t : texto.toCharArray()) {
			if (!Character.isLetter(t)) {
				if (!(Character.toString(t).equals(".")
						|| Character.toString(t).equals("-") || Character
						.toString(t).equals("_") || Character.toString(t).equals(" "))) {
					//System.out.println(t);
					return false;
				}							
			} 			
		}
		return true;
	}
	
	public boolean validaEmail() {
		int cont = 0, arro = 0;
		if (this.emailInstitucional.length() != 0) {
			for (char t : this.emailInstitucional.toCharArray()) {
				cont++;
				if (!Character.isLetterOrDigit(t)) {
					if (Character.toString(t).equals("@") && cont > 1
							&& cont < this.emailInstitucional.toCharArray().length) {
						arro++;
					} else if (!(Character.toString(t).equals(".")
							|| Character.toString(t).equals("-") || Character
							.toString(t).equals("_"))) {
						//System.out.println(t);
						return false;
					}
				}
			}
			if (arro == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	
	
}
