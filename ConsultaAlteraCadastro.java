package provajava;

import java.util.Scanner;

/**
 * @author Mateus Brusco de Freitas
 * @author Luana do Amaral Lucera
 * @author Matheus Adão Franciosi
 * @version 1.0
 * @since 2022-05-29
 */

public class ConsultaAlteraCadastro {
	private String nome, nomeBanco = null, cpf = null, endereco = null, numero = null, dataNasc = null, 
			telefone = null, email = null, complemento = null, cidade = null, estado = null, placaCons = null,
			modelo = null, marca = null, placa = null, cor = null, nomeVenda = null, cpfVenda = null, enderecoVenda = null,
			numeroVenda = null, modeloVenda = null, marcaVenda = null, placaVenda = null;
	private int anoFab = 0, anoMod = 0, anoVenda = 0, contador = 1;
	private double km = 0, valor = 0, valorVenda = 0;
	private int opcao;
	
	private Scanner teclado = new Scanner(System.in);
	// Método responsável por buscar cliente no banco de dados e retornar informações
	public void buscaCliente() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("----------------------------------------------------------");
		System.out.println("                        Busca cliente                     ");
		System.out.println("----------------------------------------------------------");
		System.out.print("Digite o nome completo para buscar: ");
		nome = teclado.nextLine();
		
		ConectaBD busca = new ConectaBD();
		AlteraCadastro atualizaInfo = new AlteraCadastro();
		try {
			// Busca cliente pelo nome e retorna demais informações do banco de dados
			busca.buscaCliente(nome);
			while (busca.rs.next()) {
				nome = busca.rs.getString("nome");
				cpf = busca.rs.getString("cpf");
				dataNasc = busca.rs.getString("dataNascimento");
				telefone = busca.rs.getString("telefone");
				email = busca.rs.getString("email"); 
				endereco = busca.rs.getString("endereco");
				numero = busca.rs.getString("numero");
				complemento = busca.rs.getString("complemento");
				cidade = busca.rs.getString("cidade");
				estado = busca.rs.getString("estado");
				
				System.out.println("----------------------------------------------------------");
				System.out.println("           Informações cadastradas no sistema             ");
				System.out.println("----------------------------------------------------------");
				System.out.println("Cliente: " + nome);
				System.out.println("CPF: " + cpf);
				System.out.println("Data de nascimento: " + dataNasc);
				System.out.println("Telefone: " + telefone);
				System.out.println("E-mail: " + email);
				System.out.println("Endereço: " + endereco);
				System.out.println("Número: " + numero);
				System.out.println("Complemento: " + complemento);
				System.out.println("Cidade: " + cidade);
				System.out.println("Estado: " + estado);
				System.out.println("----------------------------------------------------------");
				
			}
	} catch (Exception e) {
		
		e.printStackTrace();
		}
		
		System.out.print("Digite 1 para alterar cadastro de cliente, \n9 para remover cadastro de cliente \nou 0 para retornar ao menu Principal: ");
		opcao = teclado.nextInt();
		switch(opcao) {
		// Chama o método alteraCliente da classe AlteraCadastro e passa informações do cliente que terá cadastro alterado
		case 1: atualizaInfo.setInfoCliente(nome, cpf, dataNasc, telefone, email, endereco, numero, complemento, cidade, estado);
				atualizaInfo.alteraCliente();
		break;
		// Chama o método deletaCliente da classe AlteraCadastro e passa informações do cliente que terá cadastro removido do banco de dados
		case 9: atualizaInfo.setInfoCliente(nome, cpf, dataNasc, telefone, email, endereco, numero, complemento, cidade, estado);
		atualizaInfo.deletaCliente();
		case 0: Principal.main(null);
		break;
		default: System.out.println("Opção inválida");
		}
	}
	// Método responsável por buscar moto no banco de dados e retornar informações
	public void buscaMoto() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("----------------------------------------------------------");
		System.out.println("                         Busca moto                       ");
		System.out.println("----------------------------------------------------------");
		System.out.print("Digite a placa da moto para buscar: ");
		placaCons = teclado.nextLine();
		
		ConectaBD busca = new ConectaBD();
		AlteraCadastro atualizaInfo = new AlteraCadastro();
		try {
			// Busca cliente pelo nome e retorna demais informações do banco de dados
			busca.buscaMoto(placaCons);
			while (busca.rsMoto.next()) {
				modelo = busca.rsMoto.getString("modelo");
				marca = busca.rsMoto.getString("marca");
				placa = busca.rsMoto.getString("placa");
				cor = busca.rsMoto.getString("cor");
				anoFab = busca.rsMoto.getInt("anoFabricacao"); 
				anoMod = busca.rsMoto.getInt("anoModelo");
				km = busca.rsMoto.getDouble("km");
				valor = busca.rsMoto.getDouble("valor");

				
				System.out.println("----------------------------------------------------------");
				System.out.println("           Informações cadastradas no sistema             ");
				System.out.println("----------------------------------------------------------");
				System.out.println("Modelo: " + modelo);
				System.out.println("Marca: " + marca);
				System.out.println("Placa: " + placa);
				System.out.println("Cor: " + cor);
				System.out.println("Ano de fabricação: " + anoFab);
				System.out.println("Ano do modelo: " + anoMod);
				System.out.println("Quilometragem: " + km);
				System.out.println("Valor: " + valor);
				System.out.println("----------------------------------------------------------");
				
			}
	} catch (Exception e) {
		
		e.printStackTrace();
		}
		
		System.out.print("Digite 1 para alterar cadastro de moto, \n9 para remover cadastro de moto \nou 0 para retornar ao menu Principal: ");
		opcao = teclado.nextInt();
		switch(opcao) {
		// Chama o método alteraMoto da classe AlteraCadastro e passa informações da moto que terá cadastro alterado
		case 1: atualizaInfo.setInfoMoto(modelo, marca, placa, cor, anoFab, anoMod, km, valor);
				atualizaInfo.alteraMoto();
		break;
		// Chama o método deletaMoto da classe AlteraCadastro e passa informações da moto que terá cadastro removido do banco de dados
		case 9: atualizaInfo.setInfoMoto(modelo, marca, placa, cor, anoFab, anoMod, km, valor);
		atualizaInfo.deletaMoto();
		case 0: Principal.main(null);
		break;
		default: System.out.println("Opção inválida");
		}
	}
	// Método para buscar e retornar todas as vendas registradas no banco de dados
	public void buscaVendas() {
		ConectaBD buscaVendas = new ConectaBD();
		try {
			buscaVendas.buscaVendas();
			
			while (buscaVendas.getVendas().next()) {
				nomeVenda = buscaVendas.getVendas().getString("nome");
				cpfVenda = buscaVendas.getVendas().getString("cpf");
				enderecoVenda = buscaVendas.getVendas().getString("endereco");
				numeroVenda = buscaVendas.getVendas().getString("numero");
				modeloVenda = buscaVendas.getVendas().getString("modelo");
				marcaVenda = buscaVendas.getVendas().getString("marca");
				placaVenda = buscaVendas.getVendas().getString("placa");
				anoVenda = buscaVendas.getVendas().getInt("ano");
				valorVenda = buscaVendas.getVendas().getDouble("valor");
				
				System.out.println();
				System.out.println("----------------------------------------------------------");
				System.out.println("                  Informações da venda " + contador + "   ");
				System.out.println("----------------------------------------------------------");
				System.out.println("     ------------------------------------------------     ");
				System.out.println("                  Informações do cliente                  ");
				System.out.println("     ------------------------------------------------     ");
				System.out.println("Nome: " + nomeVenda);
				System.out.println("CPF: " + cpfVenda);
				System.out.println("Endereço: " + enderecoVenda);
				System.out.println("Número: " + numeroVenda);
				System.out.println("     ------------------------------------------------     ");
				System.out.println("                   Informações da moto                    ");
				System.out.println("     ------------------------------------------------     ");
				System.out.println("Modelo: " + modeloVenda);
				System.out.println("Marca: " + marcaVenda);
				System.out.println("Placa: " + placaVenda);
				System.out.println("Ano do modelo: " + anoVenda);
				System.out.println("Valor de venda: " + valorVenda);
				System.out.println("----------------------------------------------------------");
				contador++;
			}
			
			System.out.print("Digite 0 para retornar ao menu Principal: ");
			opcao = teclado.nextInt();
			
			switch (opcao) {
			case 0: Principal.main(null);
			break;
			default: System.out.println("Opção inválida");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método responsável por buscar e retornar informações de venda específica
		public void buscaVenda() {
			ConectaBD buscaVendas = new ConectaBD();
			
			System.out.println("----------------------------------------------------------");
			System.out.println("           Busca de venda por placa da moto               ");
			System.out.println("----------------------------------------------------------");
			System.out.print("Digite a placa da moto para buscar: ");
			placaCons = teclado.nextLine();
			try {
				
				System.out.println();
				buscaVendas.buscaVenda(placaCons);
				
				while (buscaVendas.getVenda().next()) {
					nomeVenda = buscaVendas.getVenda().getString("nome");
					cpfVenda = buscaVendas.getVenda().getString("cpf");
					enderecoVenda = buscaVendas.getVenda().getString("endereco");
					numeroVenda = buscaVendas.getVenda().getString("numero");
					modeloVenda = buscaVendas.getVenda().getString("modelo");
					marcaVenda = buscaVendas.getVenda().getString("marca");
					placaVenda = buscaVendas.getVenda().getString("placa");
					anoVenda = buscaVendas.getVenda().getInt("ano");
					valorVenda = buscaVendas.getVenda().getDouble("valor");
					
					System.out.println();
					System.out.println("----------------------------------------------------------");
					System.out.println("                      Informações da venda                ");
					System.out.println("----------------------------------------------------------");
					System.out.println("     ------------------------------------------------     ");
					System.out.println("                  Informações do cliente                  ");
					System.out.println("     ------------------------------------------------     ");
					System.out.println("Nome: " + nomeVenda);
					System.out.println("CPF: " + cpfVenda);
					System.out.println("Endereço: " + enderecoVenda);
					System.out.println("Número: " + numeroVenda);
					System.out.println("     ------------------------------------------------     ");
					System.out.println("                   Informações da moto                    ");
					System.out.println("     ------------------------------------------------     ");
					System.out.println("Modelo: " + modeloVenda);
					System.out.println("Marca: " + marcaVenda);
					System.out.println("Placa: " + placaVenda);
					System.out.println("Ano do modelo: " + anoVenda);
					System.out.println("Valor de venda: " + valorVenda);
					System.out.println("----------------------------------------------------------");
					
					
				}
				System.out.print("Digite 0 para retornar ao menu Principal: ");
				opcao = teclado.nextInt();
				
				switch (opcao) {
				case 0: Principal.main(null);
				break;
				default: System.out.println("Opção inválida");
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
