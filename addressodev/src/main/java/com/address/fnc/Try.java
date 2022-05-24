package com.address.fnc;

public interface Try<A, Z extends Exception> {
  A f() throws Z;
}