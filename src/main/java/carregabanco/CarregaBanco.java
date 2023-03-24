package carregabanco;

import java.util.Scanner;

import carregabanco.model.AlunoModel;
import carregabanco.repository.AlunoDao;
import carregabanco.view.CarregaBancoView;

public class CarregaBanco {
	public static void main(String[] args) {
		new CarregaBancoView();
		int opcao;
		Scanner scan= new Scanner(System.in);
		
		//menu
		System.out.println("\t---- Menu ----\n");
		System.out.println("1- Cadastrar aluno \n2- Buscar aluno \n3- Editar aluno");
		System.out.println("4- Remover aluno \n0- Sair");
		opcao= scan.nextInt();
		scan.nextLine();
		switch (opcao) {
		case 0:
			System.out.println("Programa encerrado!");
			break;
		case 1:
			cadastrarAluno(scan);
			break;
		default:
			break;
		}
//		AlunoModel alunoModel = AlunoDao.getInstance().getById(1);    
	}

	public static void cadastrarAluno(Scanner scan) {
		System.out.println(">>> CADASTRO DE ALUNO <<<\n");
		AlunoModel aluno= new AlunoModel();
		
		System.out.println("Informe o nome: ");
		String nome= scan.nextLine();
		System.out.println("Informe a coordenaçao: ");
		String coordenacao= scan.nextLine();
//		scan.next();
		System.out.println("Informe o curso: ");
		String curso= scan.nextLine();
//		scan.next();
		System.out.println("Informe sobre a situaçao(Ex.: Em curso, pendente): ");
		String  situacao= scan.nextLine();
//		scan.next();
		System.out.println("Informe a data de entrada(Ex.:2023/1): ");
		String periodoEntrada= scan.nextLine();
//		scan.next();
		
		System.out.println(nome + "\n" + coordenacao + "\n" + curso + "\n" + situacao + "\n" + periodoEntrada);
		aluno.setCoordenacao(coordenacao);
		aluno.setCurso(curso);
		aluno.setNome_estudante(nome);		
		aluno.setPeriodo_entrada(periodoEntrada);
		aluno.setSituacao(situacao);
		
		AlunoDao alunoDao = AlunoDao.getInstance();
		alunoDao.persist(aluno);
		System.out.println(aluno.toString());
		
	}
}
