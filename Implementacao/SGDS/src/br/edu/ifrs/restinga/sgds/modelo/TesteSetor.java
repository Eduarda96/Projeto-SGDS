package br.edu.ifrs.restinga.sgds.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class TesteSetor {

	private static Scanner leitura;

	public static void main(String[] args) {
		leitura = new Scanner(System.in);
		int cod;
		Setor cadSetor = new Setor();

		System.out.println("Teste de Cadastro de Setores!");
		System.out.print("Digite o nome do setor: ");
		cadSetor.setNome(leitura.nextLine());
		System.out.print("Digite o nome do responsavel do setor: ");
		cadSetor.setNomeResponsavel(leitura.nextLine());
		System.out.print("Digite o email do setor: ");
		cadSetor.setEmail(leitura.nextLine());
		System.out.print("Digite o codigo do setor responsavel ou 0: ");
		cod = leitura.nextInt();
		leitura.nextLine();

		if (cod > 0) {
			cadSetor.setSetorResponsavel(new SetorDAO().consultarSetor(cod));
		} else {
			System.out.println("sem responsavel");
			leitura.nextLine();
			cadSetor.setSetorResponsavel(null);
		}

		System.out.print("Digite a descrição do setor: ");
		cadSetor.setDescricao(leitura.nextLine());

		SetorDAO dao = new SetorDAO();
		dao.cadastrar(cadSetor);

		ArrayList<Setor> setores = new ArrayList<Setor>();
		setores.addAll(dao.consultarSetoresAtivos());

		for (Setor mostrar : setores) {
			System.out.println("\n========================= SETORES =========================\n");
			System.out.println("Codigo: " + mostrar.getCodSetor());
			System.out.println("Nome: " + mostrar.getNome());
			System.out.println("Nome do Responsavel: " + mostrar.getNomeResponsavel());
			System.out.println("Email do Setor: " + mostrar.getEmail());

			if (mostrar.getSetorResponsavel() == null) {
				System.out.println("Setor Responsavel Codigo-Nome: Não Informado.");
			} else {
				System.out.println("Setor Responsavel Codigo/Nome: " + mostrar.getSetorResponsavel().getCodSetor() + "/"
						+ mostrar.getSetorResponsavel().getNome());
			}

			System.out.println("Descrição: " + mostrar.getDescricao());
		}
	}
}
