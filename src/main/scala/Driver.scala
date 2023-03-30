
package com.knoldus

object Driver extends App {

  private val instancePaymentSystem = new PaymentSystem
  // adding details of Payment in different PaymentTypes
  private val creditCard = CreditCardPayment("Sheshnath", "543690213456", "07/05/2027", "037", 50.0)
  private val paypal = PayPalPayment("Hyesheshnath@paypal")
  private val bankTransferPayment = BankTransferPayment("654786456789087", "UBIN072")
  private val upiPayment = UpiPayment("7523845006@ybl")

  //adding Different Payment Methods
  instancePaymentSystem.addPaymentMethod(creditCard)
  instancePaymentSystem.addPaymentMethod(paypal)
  instancePaymentSystem.addPaymentMethod(bankTransferPayment)
  instancePaymentSystem.addPaymentMethod(upiPayment)

  //processing payments  with different types of Payment Methods
  private val paymentCreditCard = instancePaymentSystem.processPayment(20000.0, creditCard)
  private val paymentPayPal = instancePaymentSystem.processPayment(10000.0, paypal)
  private val paymentUpi = instancePaymentSystem.processPayment(34000.0, upiPayment)
  private val paymentBankTransfer = instancePaymentSystem.processPayment(1900.0, bankTransferPayment)

  println(paymentCreditCard)
  println(paymentPayPal)
  println(paymentUpi)
  println(paymentBankTransfer)
  println(instancePaymentSystem.paymentMethodList())

}
