package com.lege.stm;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author lege
 * @Description
 * @create 2022-08-25 15:22
 */
public class AccountUnitTest {

    @Test
    public void givenAccount_whenDecrement_thenShouldReturnProperValue() {
        // given
        Account a = new Account(10);

        // when
        a.adjustBy(-5);
        System.out.println(a.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenAccount_whenDecrementTooMuch_thenShouldThrow() {
        Account a = new Account(10);
        a.adjustBy(-11);
        System.out.println(a.getBalance());

    }

    @Test
    public void givenTwoThreads_whenBothApplyOperation_thenShouldThrow() throws InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Account a = new Account(10);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicBoolean exceptionThrown = new AtomicBoolean(false);

        //两个线程同时启动
        ex.submit(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                a.adjustBy(-5);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                exceptionThrown.set(true);
            }
        });

        ex.submit(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                a.adjustBy(-5);
            } catch (IllegalArgumentException e) {
                exceptionThrown.set(true);
            }
        });


        countDownLatch.countDown();
        ex.awaitTermination(1, TimeUnit.SECONDS);
        ex.shutdown();

        System.out.println(exceptionThrown.get());

    }

    @Test
    public void givenTwoAccounts_whenFailedWhileTransferring_thenShouldRollbackTransaction(){
        // given
        final Account a = new Account(10);
        final Account b = new Account(10);

        a.transferTo(b,5);

        System.out.println(a.getBalance());
        System.out.println(b.getBalance());

        // and
        try {
            a.transferTo(b, 20);
        } catch (final IllegalArgumentException e) {
            System.out.println("failed to transfer money");
        }

        System.out.println(a.getBalance());
        System.out.println(b.getBalance());

    }
}
