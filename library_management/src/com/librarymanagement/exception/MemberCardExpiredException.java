package com.librarymanagement.exception;

public class MemberCardExpiredException extends LibraryException {
    public MemberCardExpiredException(String memberId) {
        super("Member card has expired: " + memberId);
    }
}
