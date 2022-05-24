package com.address.fnc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

class FncHeplerTest {

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link FncHepler#toSupplierOptional(Try)}
   *   <li>{@link java.util.function.Supplier}
   * </ul>
   */
  @Test
  void testToSupplierOptional() throws Exception {
    Try<Object, Exception> resultTry = (Try<Object, Exception>) mock(Try.class);
    when(resultTry.f()).thenReturn("42");
    Optional<Object> actualGetResult = FncHepler.toSupplierOptional(resultTry);
    verify(resultTry).f();
    assertTrue(actualGetResult.isPresent());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link FncHepler#toSupplierOptional(Try)}
   *   <li>{@link java.util.function.Supplier}
   * </ul>
   */
  @Test
  void testToSupplierOptional2() throws Exception {
    Try<Object, Exception> resultTry = (Try<Object, Exception>) mock(Try.class);
    when(resultTry.f()).thenThrow(new Exception("An error occurred"));
    Optional<Object> actualGetResult = FncHepler.toSupplierOptional(resultTry);
    verify(resultTry).f();
    assertFalse(actualGetResult.isPresent());
  }



  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link FncHepler#toSupplierOptional(Try)}
   *   <li>{@link java.util.function.Supplier}
   * </ul>
   */
  @Test
  void testToSupplierOptional3() throws Exception {
    Try<Object, Exception> resultTry = (Try<Object, Exception>) mock(Try.class);
    when(resultTry.f()).thenReturn("");//empty
    Optional<Object> actualGetResult = FncHepler.toSupplierOptional(resultTry);
    verify(resultTry).f();
    //Result "" gecer java 8 e ozel isEmpty henuz yok. ObjectUtils kullanacagiz
    assertTrue(actualGetResult.isPresent());
    //takilir
    assertTrue(ObjectUtils.isEmpty(actualGetResult.get()));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link FncHepler#toSupplierOptional(Try)}
   *   <li>{@link java.util.function.Supplier}
   * </ul>
   */
  @Test
  void testToSupplierOptional4() throws Exception {
    Try<Object, Exception> resultTry = (Try<Object, Exception>) mock(Try.class);
    when(resultTry.f()).thenReturn(new Exception("An error occurred"));
    Optional<Object> actualGetResult = FncHepler.toSupplierOptional(resultTry);
    assertTrue(actualGetResult.isPresent());
    assertFalse(ObjectUtils.isEmpty(actualGetResult.get()));
    verify(resultTry).f();
  }
}

