package com.estudosweb.teste.entities;

	import java.io.Serializable;
	import java.util.HashSet;
	import java.util.Set;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import jakarta.persistence.Transient;

	@Entity
	@Table(name = "tb_produto")
	public class Produto implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nome;
		private String descricao;
		private Double preco;
		private String imgUrl;

		@Transient
		private Set<Produto> categories = new HashSet<>();

		public Produto() {
		}

		public Produto(Long id, String nome, String descricao, Double preco, String imgUrl) {
			super();
			this.id = id;
			this.nome = nome;
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
			return nome;
		}

		public void setName(String nome) {
			this.nome = nome;
		}

		public String getDescription() {
			return descricao;
		}

		public void setDescription(String descricao) {
			this.descricao = descricao;
		}

		public Double getPrice() {
			return preco;
		}

		public void setPrice(Double preco) {
			this.preco = preco;
		}

		public String getImgUrl() {
			return imgUrl;
		}

		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}

		public Set<Produto> getCategories() {
			return categories;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
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

