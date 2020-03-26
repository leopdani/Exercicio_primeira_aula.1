package test;
import static org.junit.Assert.assertEquals;

import model.Cliente;
import model.Pais;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ClienteTest {
	Cliente cliente, copia;
	Pais pais, copia2;
	
	static int id = 0;
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete.
	 * Certifique-se tamb�m que sobrecarregou o equals na classe
	 * Cliente.
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Al�m disso, a ordem de execu��o dos testes � importante; por
	 * isso a anota��o FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		cliente = new Cliente(id, "Batista Cepelos", "(11) 91234-4321", "btcp@usjt.br");
		copia = new Cliente(id, "Batista Cepelos", "(11) 91234-4321", "btcp@usjt.br");
		System.out.println(cliente);
		System.out.println(copia);
		System.out.println(id);
		
		/*CRUD Pais */
		System.out.println("setup");
		pais = new Pais(id, "USA",12010000 ,800000 );
		copia2 = new Pais(id, "USA",12010000 ,800000);
		System.out.println(pais);
		System.out.println(copia2);
		System.out.println(id);
	}
	
		
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Cliente fixture = new Cliente(1, "Carlos Drummond de Andrade", "(11)91234-4321", "cda@usjt.br" );
				Cliente novo = new Cliente(1, null, null, null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}
	@Test

	public void test01Criar() {
		System.out.println("criar");
		cliente.criar();
		id = cliente.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", cliente, copia);
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		cliente.setFone("999999");
		copia.setFone("999999");
		cliente.atualizar();
		cliente.carregar();
		assertEquals("testa atualizacao", cliente, copia);
	}
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setFone(null);
		copia.setEmail(null);
		cliente.excluir();
		cliente.carregar();
		assertEquals("testa exclusao", cliente, copia);
	}
	/*CRUD Pais */
	@Test
	public void test04CarregarPais() {
		System.out.println("carregar Pais");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais(1,"brasil",12010000,8000000);
				Pais novo = new Pais(1, null, 0, 0);
		novo.carregar();
		assertEquals("testa inclusao", novo.getId(), fixture.getId());
	}
	@Test
	public void test05CriarPais() {
		System.out.println("criar Pais");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia2.setId(id);
		assertEquals("testa criacao", pais.getId(), copia2.getId());
	}
	@Test
	public void test06ExcluirPais() {
		System.out.println("excluir pais");
		copia2.setId(-1);
		copia2.setNome(null);
		copia2.setPopulacao(0);
		copia2.setArea(0);
		pais.excluir();
		pais.carregar();
		assertEquals("testa exclusao", pais.getId(), copia2.getId());
	}
	@Test
	public void test07AtualizarPais() {
		System.out.println("atualizar");
		pais.setPopulacao(999999);
		copia2.setPopulacao(999999);
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais.getId(), copia2.getId());
	}
	@Test
	public void test08MaiorPopulacacao() {
		System.out.println("maior populacao");
		Pais novo = new Pais(1,"brasil",12010000,8000000);
		pais.maiorPopulacao();
		assertEquals("testa maior populacao", pais.getId(), novo.getId());
	}
	
	@Test
	public void test09MenorArea() {
		System.out.println("menor area");
		Pais copia2 = new Pais(2,"chile",2000000,500000);
		Pais novo = new Pais();
		novo.menorArea();
		
		assertEquals("Teste de menor �rea", copia2.getId(), novo.getId());
	}
	
}