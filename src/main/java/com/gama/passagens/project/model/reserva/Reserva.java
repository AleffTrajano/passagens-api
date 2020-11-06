package com.gama.passagens.project.model.reserva;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String orderId;
	
	private BigDecimal price;
	
	@Column(name = "viajante_id")
	private Integer viajanteId;
	
	@Column(name = "dh_reserva")
	private LocalDateTime dataHoraReserva = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private ReservaStatus status = ReservaStatus.PP;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getViajanteId() {
		return viajanteId;
	}
	public void setViajanteId(Integer viajanteId) {
		this.viajanteId = viajanteId;
	}
	public LocalDateTime getDataHoraReserva() {
		return dataHoraReserva;
	}
	public void setDataHoraReserva(LocalDateTime dataHoraReserva) {
		this.dataHoraReserva = dataHoraReserva;
	}
	public ReservaStatus getStatus() {
		return status;
	}
	public void setStatus(ReservaStatus status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	
	
}
