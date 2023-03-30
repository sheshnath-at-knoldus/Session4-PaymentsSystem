
package com.knoldus
import org.scalatest.funsuite.AnyFunSuite

class PaymentTest extends AnyFunSuite{

  test("Test case for  Add Payment Methods "){
    val paymentClassInstance = new PaymentSystem
    val creditCard = CreditCardPayment("himanshu", "787687656356", "47/03/2025", "37", 900.0)
    paymentClassInstance.addPaymentMethod(creditCard)
    val actualResult =paymentClassInstance.paymentMethodList()
    val expectedResult=List(CreditCardPayment("himanshu", "787687656356", "47/03/2025", "37", 900.0))
    assert(actualResult===expectedResult)
  }

  test("Test case for Payment Method Process") {
    val paymentClassInstance = new PaymentSystem
    val creditCard = CreditCardPayment("Sheshnath", "543690213456", "07/05/2027", "037", 50.0)
    val actualResult = paymentClassInstance.processPayment(20000.0, creditCard)
    val expectedResult ="Transaction Successful 36650.0"
    assert(actualResult === expectedResult)
  }

}
