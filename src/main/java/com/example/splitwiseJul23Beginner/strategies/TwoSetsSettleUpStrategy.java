package com.example.splitwiseJul23Beginner.strategies;

import com.example.splitwiseJul23Beginner.models.Expense;
import com.example.splitwiseJul23Beginner.models.ExpenseUserOwedBy;
import com.example.splitwiseJul23Beginner.models.ExpenseUserPaidBy;
import com.example.splitwiseJul23Beginner.models.Transaction;
import org.springframework.data.util.Pair;

import java.util.*;

public class TwoSetsSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settle(List<Expense> expenses) {

        // Condense expenses
        Map<Integer, Double> condensedExpenses = new HashMap<>();

        for (Expense expense : expenses) {

            for (ExpenseUserPaidBy expenseUserPaidBy : expense.getPaidBy()) {
                int userId = expenseUserPaidBy.getUser().getId();
                condensedExpenses.put(userId, condensedExpenses.getOrDefault(userId, 0.0) + expenseUserPaidBy.getAmount());
            }

            for (ExpenseUserOwedBy expenseUserOwedBy : expense.getOwedBy()) {
                int userId = expenseUserOwedBy.getUser().getId();
                condensedExpenses.put(userId, condensedExpenses.getOrDefault(userId, 0.0) - expenseUserOwedBy.getAmount());
            }
        }

        Queue<Pair<Integer, Double>> maxHeap = new PriorityQueue<>(new Comparator<Pair<Integer, Double>>() {
            @Override
            public int compare(Pair<Integer, Double> p1, Pair<Integer, Double> p2) {
                return (int) (p1.getSecond() - p2.getSecond());
            }
        });
        Queue<Pair<Integer, Double>> minHeap = new PriorityQueue<>(new Comparator<Pair<Integer, Double>>() {
            @Override
            public int compare(Pair<Integer, Double> p1, Pair<Integer, Double> p2) {
                return (int) (p2.getSecond() - p1.getSecond());
            }
        });

        for (Map.Entry<Integer, Double> entry : condensedExpenses.entrySet()) {
            if(entry.getValue() > 0){
                maxHeap.add(Pair.of(entry.getKey(), entry.getValue()));
            } else {
                minHeap.add(Pair.of(entry.getKey(), entry.getValue()));
            }
        }

        List<Transaction> transactions = new ArrayList<>();
        while(!minHeap.isEmpty() && !maxHeap.isEmpty()){
            Pair<Integer, Double> userToBePaid = maxHeap.poll();
            Pair<Integer, Double> userToPay = minHeap.poll();

            double amount = Math.min(Math.abs(userToBePaid.getSecond()), Math.abs(userToPay.getSecond()));

            if(userToBePaid.getSecond() - amount > 0){
                maxHeap.add(Pair.of(userToBePaid.getFirst(), userToBePaid.getSecond() - amount));
            }

            if(userToPay.getSecond() + amount < 0 ){
                minHeap.add(Pair.of(userToPay.getFirst(), userToPay.getSecond() + amount));
            }

            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setPaid(userToBePaid.getFirst());
            transaction.setOwed(userToPay.getFirst());
            transactions.add(transaction);
        }

        return transactions;
    }
}
