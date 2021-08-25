package dev.snbv2.payments;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paymenthistory")
public class PaymentController {
    
    private static final Log LOG = LogFactory.getLog(PaymentController.class);

    @Autowired
    PaymentRepository paymentRepository;
    
    @GetMapping("/payments")
    public @ResponseBody List<Payment> getAllPayments() {

        Iterable<Payment> paymentIterator = paymentRepository.findAll();
        List<Payment> payments = new ArrayList<Payment>();

        for (Payment p : paymentIterator) {
            payments.add(p);
        }

        LOG.debug(String.format("All payments found = [%s]", payments));
        //model.addAttribute("payments", payments);
        return payments;
    }

    @GetMapping("/paymentDetails")
    public @ResponseBody Payment getPaymentById(@RequestParam(name="id") Long id) {

        Optional<Payment> payment =  paymentRepository.findById(id);

        LOG.debug(String.format("Found payment [%s].", payment.get()));
        //model.addAttribute("payment", payment.get());
        return payment.get();
    }
}
