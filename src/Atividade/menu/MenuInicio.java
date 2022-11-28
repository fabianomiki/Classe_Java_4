package Atividade.menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Atividade.entities.Aluno;
import Atividade.exibicao.InformacoesDosAlunos;

public class MenuInicio {
	
	public static boolean verificarMatriculaDisponivel(List<Aluno> alunos, String matricula) {
		if(alunos.size()==0) {
			return true;
		}else {
			for (Aluno aluno : alunos) {
				if(aluno.getMatriculaAluno().equals(matricula)) {
					System.out.println("Matricula já existente. Tente novamente.");
					return false;
				}
			}
			return true;
		}
	}
	
	public static void menuPrincipal(List<Aluno> alunos, Scanner sc) throws IOException {
		
		new InformacoesDosAlunos();
		
		try {
			int opcao = 1;
			while (opcao != 0) {
				System.out.println("-----------------------------------------------");
				System.out.println("Selecione uma das opcoes (Digite 0 para sair): ");
				System.out.println("1 - Adicionar aluno");
				System.out.println("2 - Atualizar aluno");
				System.out.println("3 - Consultar disciplinas");
				System.out.println("4 - Lista dos alunos cadastrados");
				System.out.print("Opcao: ");
				opcao = sc.nextInt();
				
				switch(opcao) {
				
				case 0:
					System.out.println("Sessao finalizada.");
					break;
				case 1:
					MenuCriacao.menuAdicionarAluno(alunos,sc);
					break;
				case 2:
					MenuAtualizacao.menuAtualizarAluno(alunos,sc);
					break;
				case 3:
					MenuDiscplinas.menuPrincipalDisciplinas(alunos,sc);
					break;
				case 4:
					InformacoesDosAlunos.listaDeAlunosNaTela(alunos);
					break;
				default:
					System.out.println("Opcao incorreta, tente novamente.");
					System.out.println();
					break;
				}
			}
		}catch(InputMismatchException e) {
			System.out.println();
			System.out.println("Informe um dado válido!");
			System.out.println("Pressione ENTER para continuar");
			System.in.read();
			menuPrincipal(alunos, new Scanner(System.in));
		}finally {
			sc.close();
		}
	}

}
