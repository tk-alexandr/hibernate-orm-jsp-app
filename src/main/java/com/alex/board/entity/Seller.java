package com.alex.board.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

import com.alex.board.dao.SellerDAO;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "name")
	@Length(min = 2, max = 20)
	private String name;
	
	@Column(name = "surname")
	@Length(min = 2, max = 20)
	private String surname;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	private List<Item> items;
	
	public Seller() {}
	
	public Seller(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void addSeller() {
		SellerDAO.addSeller(this);
	}
	
	public List<Seller> getSellers(){
		return SellerDAO.getSellers();
	}

	
}
