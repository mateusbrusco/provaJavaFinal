package provajava;

import java.util.Scanner;

/**
 * @author Mateus Brusco de Freitas
 * @author Luana do Amaral Lucera
 * @author Matheus Adão Franciosi
 * @version 1.0
 * @since 2022-05-29
 */

public class AlteraCadastro {

	
	Scanner teclado = new Scanner(System.in);
	private String nome, cpf, dataNasc, telefone, email, endereco, numero, complemento, cidade, estado, modelo, marca, placa, cor;
	private int anoFab, anoMod, opcao;
	private double km, valor;
	
	public void setInfoCliente(String nome, String cpf, String dataNasc, String telefone, String email, String endereco, String numero, String complemento, String cidade, String estado) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public void setInfoMoto(String modelo, String marca, String placa, String cor, int anoFab, int anoMod, double km, double valor) {
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.cor = cor;
		this.anoFab = anoFab;
		this.anoMod = anoMod;
		this.km = km;
		this.valor = valor;
	}
	

	// Método responsável por atualizar informações cadastrais de clientes
	public void alteraCliente() {
		ConectaBD atualizacao = new ConectaBD();
		System.out.println("----------------------------------------------------------");
		System.out.println("            Altera cadastro de " + nome +  "              ");
		System.out.println("----------------------------------------------------------");
		System.out.print("Telefone: " + telefone + " - Novo telefone: ");
		telefone = teclado.nextLine();
		System.out.print("E-mail: " + email + " - Novo e-mail: ");
		email = teclado.nextLine();
		System.out.print("Endereço: " + endereco + " - Novo endereço: ");
		endereco = teclado.nextLine();
		System.out.print("Número: " + numero + " - Novo número: ");
		numero = teclado.nextLine();
		System.out.print("Complemento: " + complemento + " - Novo complemento: ");
		complemento = teclado.nextLine();
		System.out.print("Cidade: " + cidade + " - Nova cidade: ");
		cidade = teclado.nextLine();
		System.out.print("Estado: " + estado + " - Novo estado: ");
		estado = teclado.nextLine();
		System.out.println("----------------------------------------------------------");
		
		// Chama o método cadastraCliente da classe ConectaBD e passa informações inseridas para envio para o banco de dados
	    try {
			atualizacao.atualizaCadastroCliente(nome, cpf, dataNasc, telefone, email, endereco, numero, complemento, cidade, estado);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
	    System.out.println("Registro alterado com sucesso");
	    System.out.print("Digite 0 para retornar ao menu Principal: ");
		opcao = teclado.nextInt();
		
		switch (opcao) {
		case 0: Principal.main(null);
		break;
		default: System.out.println("Opção inválida");
		}
	}
	// Método responsável por atualizar informações cadastrais de motos
	public void alteraMoto() {
		ConectaBD atualizacao = new ConectaBD();
		System.out.println("----------------------------------------------------------");
		System.out.println("       Altera cadastro de " + marca + modelo + "          ");
		System.out.println("----------------------------------------------------------");
		System.out.print("Cor: " + cor + " - Nova cor: ");
		cor = teclado.nextLine();
		System.out.print("Quilometragem: " + km + " - Nova quilometragem: ");
		km = teclado.nextDouble();
		System.out.print("Valor: " + valor + " - Novo valor: ");
		valor = teclado.nextDouble();
		System.out.println("----------------------------------------------------------");
		
	    try {
			atualizacao.atualizaCadastroMoto(modelo, marca, placa, cor, anoFab, anoMod, km, valor);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	// Método responsável por remover cadastro de clientes
	public void deletaCliente() {
		ConectaBD deletaCliente = new ConectaBD();
		System.out.println("----------------------------------------------------------");
		System.out.println("           Remover cadastro de " + nome +  "              ");
		System.out.println("----------------------------------------------------------");
		System.out.println("Digite 1 para remover permanentemente o cadastro \nou 0 para retornar ao menu Principal");
		opcao = teclado.nextInt();
		switch (opcao) {
		case 1: try {
				deletaCliente.apagaCliente(nome);
				System.out.println("Cliente removido com sucesso");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		case 0: Principal.main(null); 
		break;
		default: System.out.println("Opção inválida");
		}
		
	}
	// Método responsável por remover cadastro de motos
	public void deletaMoto() {
		ConectaBD deletaMoto = new ConectaBD();
		System.out.println("----------------------------------------------------------");
		System.out.println("   Remover cadastro de " + marca + " " + modelo + " - " + placa +  "  ");
		System.out.println("----------------------------------------------------------");
		System.out.println("Digite 1 para remover permanentemente o cadastro \nou 0 para retornar ao menu Principal");
		opcao = teclado.nextInt();
		switch (opcao) {
		case 1: try {
				deletaMoto.removeMoto(placa);
				System.out.println("Motocicleta removida com sucesso");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		case 0: Principal.main(null); 
		break;
		default: System.out.println("Opção inválida");
		}
		
	}


}
