package com.example.svclp.Controller;

import com.example.svclp.model.AccountDetail;
import com.example.svclp.model.Customer;
import com.example.svclp.model.LoyaltyPoints;
import com.example.svclp.model.Transaction;
import com.example.svclp.service.CustomerService;
import com.example.svclp.service.LoyaltyPointsService;
import com.example.svclp.service.TransactionService;

import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired 
	private TransactionService transactionService;
    
    private  final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    
    @Autowired
    private LoyaltyPointsService loyaltyPointsService;
    
    
    
    @PostMapping("/create_customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        
        customer.setLoyaltyPoints(150);
        String accountNumber = generateRandomNumber(12);
        customer.setCustomerAccountNumber(Long.parseLong(accountNumber));
        
        String cardNumber = generateRandomNumber(12);
       
        String loyaltyPointsNumber = generateRandomNumber(10);
        LoyaltyPoints loyaltyPoints = new LoyaltyPoints();
        loyaltyPoints.setCustomerAccountNumber(Long.parseLong(accountNumber));
        loyaltyPoints.setLoyaltyPointsNumber(loyaltyPointsNumber);
        
        customer.setLoyaltyPointsEntity(loyaltyPoints);
        AccountDetail accountDetail = new AccountDetail(customer.getCustomerAccountNumber(), Long.parseLong(cardNumber));
        
       
        accountDetail.setLoyaltyPointsNumber(loyaltyPointsNumber);

        customer.setAccountDetail(accountDetail);
        Customer createdCustomer = customerService.createCustomer(customer);

      
        String responseMessage = "Status Code : 201\n"
                                + "Description : Customer Created Successfully\n"
                                + "Customer Name : " + customer.getFirstName() + " " + customer.getLastName() + "\n"
                                + "Account Number : " + accountNumber + "\n"
                                + "Card  Number  :" + cardNumber +"\n"
                                + "Loyalty Points Number : " + loyaltyPointsNumber + "\n";

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }
   
    private String generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }


    @PostMapping("/make_transaction")
    public ResponseEntity<String> makeTransaction(@RequestBody Transaction transaction) {
        Transaction processedTransaction = transactionService.processTransaction(transaction);
        
        if (transaction.getTransactionDirection() == null) {
            String responseMessage = "Status Code: 400\n"
                    + "Description: Transaction Unsuccessful\n"
                    + "Unrecognized transaction Direction(Credit/Debit).";

            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
        if (transaction.getTransactionType() ==  null) {
            String responseMessage = "Status Code: 400\n"
                    + "Description: Transaction Unsuccessful\n"
                    + "Unrecognized Transaction Type(Please specify a transaction type).";

            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
        
        String responseMessage = "Status Code: 201\n"
                + "Description: Transaction Successful\n"
                + "Transaction ID: " + transaction.getTransactionId() + "\n"
                + transaction.getLoyaltyPoints() + " Points have been added to your account successfully. Please check your balance.\n"
                + "Transaction Points Type: " + transaction.getTransactionDirection();
        
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId);
        if (transaction != null) {
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    
}
