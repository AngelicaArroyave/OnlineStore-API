package com.onlinestore.entity;

import java.io.Serializable;

import com.onlinestore.enums.Brand;
import com.onlinestore.enums.Size;
import com.onlinestore.enums.TypeProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements Serializable {

	private static final long serialVersionUID = 2793759862239360950L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduct")
	private Long idProduct;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TypeProduct type;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "quantityAvailable", nullable = false)
	private int quantityAvailable;
	
	@Column(name = "discount", nullable = false)
	private int discount;
	
	@Column(name = "quantityPurchased", nullable = false)
	private int quantityPurchased;
	
	@Column(name = "isReturn", nullable = false)
	private boolean isReturn;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "size")
	private Size size;
	
	@Column(name = "color")
	private String color;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "brand")
	private Brand brand;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "price", nullable = false)
	private double price;

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeProduct getType() {
		return type;
	}

	public void setType(TypeProduct type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}

	public boolean isReturn() {
		return isReturn;
	}

	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
