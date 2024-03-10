package com.onlinestore.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingcart")
@Inheritance(strategy = InheritanceType.JOINED)
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 3096634969426701063L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idShoppingCart")
	private Long idShoppingCart;
	
	@Column(name = "numberProduct", nullable = false)
	private int numberProduct;
	
	@Column(name = "totalPrice", nullable = false)
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "fk_idPerson", referencedColumnName = "idPerson")
	private Person idPerson;
	
	@ManyToOne
	@JoinColumn(name = "fk_idProduct", referencedColumnName = "idProduct")
	private Product idProduct;
	
	@ManyToOne
	@JoinColumn(name = "fk_idInventory", referencedColumnName = "idInventory")
	private Inventory idInventory;

	public Long getIdShoppingCart() {
		return idShoppingCart;
	}

	public void setIdShoppingCart(Long idShoppingCart) {
		this.idShoppingCart = idShoppingCart;
	}

	public int getNumberProduct() {
		return numberProduct;
	}

	public void setNumberProduct(int numberProduct) {
		this.numberProduct = numberProduct;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Person getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Person idPerson) {
		this.idPerson = idPerson;
	}

	public Product getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Product idProduct) {
		this.idProduct = idProduct;
	}

	public Inventory getIdInventory() {
		return idInventory;
	}

	public void setIdInventory(Inventory idInventory) {
		this.idInventory = idInventory;
	}
}
