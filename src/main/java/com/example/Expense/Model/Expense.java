package com.example.Expense.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Expense {
	@Id
	private Long id;
	private Double amount;
	private String category;
	private LocalDate date;
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Expense(Long id, Double amount, String category, LocalDate date, String description) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.description = description;
	}
	public Expense() {}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", amount=" + amount + ", category=" + category + ", date=" + date
				+ ", description=" + description + "]";
	}
}
