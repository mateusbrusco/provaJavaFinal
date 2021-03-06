package provajava;

import java.util.Scanner;

/**
 * @author Mateus Brusco de Freitas
 * @author Luana do Amaral Lucera
 * @author Matheus Adão Franciosi
 * @version 1.0
 * @since 2022-05-29
 */

public class Principal {

	public static void main(String[] args) {
		// Classe principal do sistema.
		// Inicializa variável que será utilizada para escolher a opção do menu.
		int opcao;
		
		Scanner entrada = new Scanner(System.in);
		
		// Exibe opções do menu.
		System.out.println("----------------------------------------------------------");
		System.out.println("                Selecione a opção desejada                ");
		System.out.println("----------------------------------------------------------");
		System.out.println("1 - Cadastro de cliente");
		System.out.println("2 - Cadastro de motocicleta");
		System.out.println("3 - Cadastro de venda");
		System.out.println("4 - Listar vendas registradas");
		System.out.println("5 - Consultar venda");
		System.out.println("6 - Consulta/ altera cadastro de cliente");
		System.out.println("7 - Consulta/ altera cadastro de motocicleta");
		System.out.println("0 - Encerrar aplicação");
		System.out.println("----------------------------------------------------------");
		System.out.print("Opção: ");

		opcao = entrada.nextInt();
		
		// Executa classe selecionado pelo usuário.
		switch (opcao) {
		case 1:
			// Chama o método cadastraCliente da classe CadastraCliente
			CadastraCliente novoCliente = new CadastraCliente();
			novoCliente.cadastraCliente();
			break;
		case 2:
			// Chama o método cadastraMoto da classe CadastroMoto
			CadastroMotos novaMoto = new CadastroMotos();
			novaMoto.cadastraMoto();
			break;
		case 3:
			// Chama o método cadastraVenda da classe CadastroVenda
			CadastroVenda novaVenda = new CadastroVenda();
			novaVenda.cadastraVenda();
			break;
		case 4:
			// Chama o método busca vendas da classe ConsultaAlteraCadastro
			ConsultaAlteraCadastro relatorioVendas = new ConsultaAlteraCadastro();
			relatorioVendas.buscaVendas();
			break;
		case 5:
			// Chama o método busca venda da classe ConsultaAlteraCadastro
			ConsultaAlteraCadastro relatorioVenda = new ConsultaAlteraCadastro();
			relatorioVenda.buscaVenda();
			break;			
		case 6:
			// Chama o método busca cliente da classe ConsultaAlteraCadastro
			ConsultaAlteraCadastro novaConsultaCliente = new ConsultaAlteraCadastro();
			novaConsultaCliente.buscaCliente();
			break;
		case 7:
			// Chama o método busca moto da classe ConsultaAlteraCadastro
			ConsultaAlteraCadastro novaConsultaMoto = new ConsultaAlteraCadastro();
			novaConsultaMoto.buscaMoto();
			break;
		case 0: 
			System.exit(0);
		default: System.out.println("Opção inválida");
		}

	}

}
