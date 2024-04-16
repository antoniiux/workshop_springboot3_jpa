package com.estudosweb.teste.entities;

import java.io.Serializable;
import java.time.Instant;

import com.estudosweb.teste.entities.enums.PedidoStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	
	private Integer pedidoStatus;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	public Pedido() {
	}

	public Pedido(Long id, Instant moment, PedidoStatus pedidoStatus, Usuario cliente) {
		super();
		this.id = id;
		this.moment = moment;
		this.cliente = cliente;
		setPedidoStatus(pedidoStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Usuario getClient() {
		return cliente;
	}

	public void setClient(Usuario cliente) {
		this.cliente = cliente;
	}

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valueOf(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if (pedidoStatus != null) {
			this.pedidoStatus = pedidoStatus.getCode();
		}
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}