package com.example.Expense.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Expense.Model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
