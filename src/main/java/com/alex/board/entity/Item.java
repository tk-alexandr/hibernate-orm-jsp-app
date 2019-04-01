package com.alex.board.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.alex.board.dao.ItemDAO;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	@Length(min = 2, max = 45)
	private String name;
	
	@Column(name="price")
	@Min(value=0L)
	@Max(value=1000000000L)
	private Long price;
	
	@ManyToOne 
	@JoinColumn(name = "seller_id") 
	@NotNull
	private Seller seller;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "category_has_item", 
        joinColumns = { @JoinColumn(name = "item_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
	@NotNull
	private List<Category> categories;
	
	
	public Item(String name, Long price, Seller seller, List<Category> categories) {
		this.name = name;
		this.price = price;
		this.seller = seller;
		this.categories = categories;
	}
	
	public Item() {}

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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addItem() {
		ItemDAO.addItem(this);
	}
	
	public List<Item> getItems(){
		return ItemDAO.getItems();
	}

	
}
