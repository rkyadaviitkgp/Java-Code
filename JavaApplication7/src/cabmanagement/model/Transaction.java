/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.model;

import java.util.Date;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Transaction {
    
    String transactionId;
    Date transactionDate;
    double amount;
    Booking bookingId;
    TransactionStatus transactionStatus;
    PaymentType paymentType;
    
    
}
