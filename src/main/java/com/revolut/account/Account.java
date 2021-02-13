package com.revolut.account;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;

public class Account {
    private BigDecimal amount = new BigDecimal(0);
    private final String accountId;
    private AtomicBoolean operationsAllowed = new AtomicBoolean(true);

    public Account(String accountId) {
        this.accountId = accountId;
    }

    public Account(BigDecimal amount, String accountId) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public void transfer(Account account2, BigDecimal amount) throws NotEnoughMoneyException, NegativeAmountException, OperationDeniedException {
        checkEnoughSum(amount);
        checkNegativeSum(amount);
        checkAllowOperation(this);
        checkAllowOperation(account2);
        makeMoneyTransfer(account2, amount);
    }

    private synchronized void makeMoneyTransfer(Account account2, BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
        account2.addAmount(amount);
    }

    private void checkEnoughSum(BigDecimal sumToTransfer) throws NotEnoughMoneyException {
        if (sumToTransfer.compareTo(amount) > 0) {
            throw new NotEnoughMoneyException();
        }
    }

    private void checkNegativeSum(BigDecimal sumToTransfer) throws NegativeAmountException {
        if (sumToTransfer.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeAmountException();
        }
    }

    private void checkAllowOperation(Account account) throws OperationDeniedException {
        if (!account.isOperationsAllowed()) {
            throw new OperationDeniedException();
        }
    }

    private void addAmount(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setOperationsAllowed(boolean operationsAllowed) {
        this.operationsAllowed.set(operationsAllowed);
    }

    public boolean isOperationsAllowed() {
        return operationsAllowed.get();
    }
}
