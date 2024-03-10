package com.onlinestore.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Inventory")
@Inheritance(strategy = InheritanceType.JOINED)
public class Inventory implements Serializable {

	private static final long serialVersionUID = 5072803252629510229L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInventory")
	private Long idInventory;
	
	@DateTimeFormat(pattern = "%Y-%m-%d")
	@Column(name = "dataSale")
	private Date dateSale;

	public Long getIdInventory() {
		return idInventory;
	}

	public void setIdInventory(Long idInventory) {
		this.idInventory = idInventory;
	}

	public Date getDateSale() {
		return dateSale;
	}

	public void setDateSale(Date dateSale) {
		this.dateSale = dateSale;
	}
}
