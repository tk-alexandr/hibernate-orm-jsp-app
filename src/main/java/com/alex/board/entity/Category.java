package com.alex.board.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Length;

import com.alex.board.dao.CategoryDAO;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "name")
	@Length(min = 2, max = 20)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Item> items;
	
	public Category(String name) {
		this.name = name;
	}
	public Category() {}
	
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
	
	public void addCategory() {
		CategoryDAO.addCategory(this);    	
	}
	
	public List<Category> getCategories(){
		return CategoryDAO.getCategories();
	}

	
}
