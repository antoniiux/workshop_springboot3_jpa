package com.estudosweb.teste.entities;

	import java.io.Serializable;
	import java.util.HashSet;
	import java.util.Set;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.JoinTable;
	import jakarta.persistence.ManyToMany;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "tb_produto")
	public class Produto implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String name;
		private String descricao;
		private Double preco;
		private String imgUrl;

		@ManyToMany
		@JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
		private Set<Categoria> categorias = new HashSet<>();

		public Produto() {
		}

		public Produto(Long id, String name, String descricao, Double preco, String imgUrl) {
			super();
			this.id = id;
			this.name = name;
			this.descricao = descricao;
			this.preco = preco;
			this.imgUrl = imgUrl;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Double getPreco() {
			return preco;
		}

		public void setPreco(Double preco) {
			this.preco = preco;
		}

		public String getImgUrl() {
			return imgUrl;
		}

		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}

		public Set<Categoria> getCategorias() {
			return categorias;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int resultado = 1;
			resultado = prime * resultado + ((id == null) ? 0 : id.hashCode());
			return resultado;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Produto other = (Produto) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	}


