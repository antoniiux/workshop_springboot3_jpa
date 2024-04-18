package com.estudosweb.teste.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudosweb.teste.entities.Categoria;
import com.estudosweb.teste.entities.Pedido;
import com.estudosweb.teste.entities.Produto;
import com.estudosweb.teste.entities.Usuario;
import com.estudosweb.teste.entities.enums.PedidoStatus;
import com.estudosweb.teste.repositories.CategoriaRepository;
import com.estudosweb.teste.repositories.PedidoRepository;
import com.estudosweb.teste.repositories.ProdutoRepository;
import com.estudosweb.teste.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private PedidoRepository orderRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronicos"); 
		Categoria cat2 = new Categoria(null, "Livros"); 
		Categoria cat3 = new Categoria(null, "Computadores"); 
		
		Produto p1 = new Produto(null, "DOM", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Produto p2 = new Produto(null, "TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Produto p3 = new Produto(null, "Macbook", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Produto p4 = new Produto(null, "PC", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Produto p5 = new Produto(null, "Rack", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAID, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.WAITING_PAYMENT, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}