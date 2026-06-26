package com.librarymanagement.model;

public class Member {
    private final String memberId;
    private final String name;
    private boolean cardExpired;
    private double unpaidFines;

    public Member(String memberId, String name, boolean cardExpired, double unpaidFines) {
        this.memberId = memberId;
        this.name = name;
        this.cardExpired = cardExpired;
        this.unpaidFines = unpaidFines;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public boolean isCardExpired() {
        return cardExpired;
    }

    public double getUnpaidFines() {
        return unpaidFines;
    }
}
