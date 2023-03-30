
package com.knoldus

trait PaymentType {
  def payment(amount: Double): Double
}

//case class for credit card and also have a method for payment
case class CreditCardPayment(cardHolderNumber: String,
                             creditCardNumber: String,
                             creditCardExpiryDate: String,
                             securityNumber: String,
                             transactionCharges: Double
                            ) extends PaymentType {
  override def payment(amount: Double): Double = 56600.0 - amount + transactionCharges
}

//case class for PayPal and also have a method  for payment
case class PayPalPayment(payPalId: String) extends PaymentType {
  override def payment(amount: Double): Double = 56600.0 - amount
}

//case class for BankTransfer and also have a method  for payment
case class BankTransferPayment(accountNumber: String, ifscCode: String) extends PaymentType {
  override def payment(amount: Double): Double = 56600.0 - amount
}

//case class for UpiPayment and also have a method  for payment
case class UpiPayment(upiId: String) extends PaymentType {
  override def payment(amount: Double): Double = 56600.0 - amount
}


class PaymentSystem extends {

  private var listPaymentType: List[PaymentType] = List()

  /*
  addPayment Method is to add payment method in List in List[PaymentType]
   */
  def addPaymentMethod(paymentType: PaymentType): List[PaymentType] = {
    listPaymentType = paymentType :: listPaymentType
    listPaymentType
  }

  /*
  processPayment is for to process the payment and returns the amount
   */
  def processPayment(amount: Double, paymentType: PaymentType): String = {
    // Exception Thrown
    if(amount.isNaN)  throw new IllegalArgumentException()
    val payment = paymentType.payment(amount)
    s"Transaction Successful $payment"
  }

  //It gives the list of paymentMethods
  def paymentMethodList(): List[PaymentType] = {
    if(listPaymentType.isEmpty) throw new NullPointerException()
    listPaymentType.map(f => f)
  }
}
