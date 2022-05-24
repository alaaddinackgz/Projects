package com.address.fnc;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FncHepler {
  private static final Logger log = LoggerFactory.getLogger(FncHepler.class);

  /**
   * fn try icerinside tetiklenir.
   * Result hata barindirmiyor ise result {@link Optional} ile doner.
   * Hata vari ise empty doner
   *  artik isPresent methodu ile result dan donen deger kontrol edilebilir
   */
  static public <A, E extends Exception> Optional<A> toSupplierOptional(final Try<A, E> t) {
      try {

        return Optional.of(t.f());
      } catch (Exception e) {
        if(log.isTraceEnabled()) {
          //trace loglari aktif ise loglar
          log.trace(e.getMessage(),e);
        }
        return Optional.empty();
      }
  }

}
