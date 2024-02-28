package com.example.Theater.Booking.service.serviceImplementation;

import com.example.Theater.Booking.dto.PayamentDTO;
import com.example.Theater.Booking.dto.PaymentRewardDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.model.*;
import com.example.Theater.Booking.repository.*;
import com.example.Theater.Booking.service.PaymentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PaymentServiceImplementation implements PaymentService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    RewardRepository rewardRepository;
    @Autowired
    OffersRepository rewardOffersRepository;

    @Autowired
    LinkTypeOfferRepository linkTypeOfferRepository;
    @Value("${key_id}")
    private String keyId;
    @Value("${secret_key}")
    private String secretKey;

    @Override
    public ResponseEntity<ResponseDTO> payment(PayamentDTO payamentDTO) throws ParseException {

        Payment payment = Payment.builder().booking(bookingRepository.findById(payamentDTO.getBookingId()).orElseThrow())
                .paymentType(payamentDTO.getPaymentType())
                .TotalAmount(payamentDTO.getTotalAmount())
                .status("True").build();

        Payment savedPaymentDetails = paymentRepository.save(payment);

        System.out.println(payment);
        long bookId = payamentDTO.getBookingId();
        if (payment.getStatus().equals("True")) {
            Optional<Booking> booking = bookingRepository.findById(bookId);
            booking.get().setStatus("Booked");
            bookingRepository.save(booking.get());

            Rewards rewards = rewards(booking.get().getUserid());
        }
        Optional<Booking> booking = bookingRepository.findById(bookId);
        long userid = booking.get().getUserid().getUserId();
        List<Rewards> rewards = rewardRepository.findAllByUserId(booking.get().getUserid());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "Payment_Details", new PaymentRewardDTO(savedPaymentDetails, rewards)));
    }

    @Override
    public String paymentProcess(String amount) {
        RazorpayClient razorpayClient = null;
        try {
            razorpayClient = new RazorpayClient(keyId, secretKey);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "order_receipt");
        Order order = null;
        try {
            order = razorpayClient.orders.create(orderRequest);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        String orderId = order.get("id");
        return orderId;
    }

    public Rewards rewards(User user) throws ParseException {

        Rewards reward = new Rewards();
        LinkTypeOffer linkTypeOffer = new LinkTypeOffer();
        Offers offers = new Offers();
        //List<Offers> rewardOfferslist = rewardOffersRepository.findAll();
        String rewardType = "";

        Random random = new Random();
        int choice = random.nextInt(1, 4);

        if (choice == 3) {
            rewardType += "link";
            List<Offers> rewardOfferslist = rewardOffersRepository.findByrewardType(rewardType);
            int rand = (random.nextInt(rewardOfferslist.size()));
            Offers randomElement = rewardOfferslist.get(rand);
            LinkTypeOffer linkTypeOffer1 = linkTypeOfferRepository.getFirstByPublish(true);
            //System.out.println(randomElement+"random");
            String offerid = linkTypeOffer1.getId();
            reward.setOfferId(rewardOffersRepository.findById(randomElement.getId()).get());
            reward.setLinkId(linkTypeOffer1.getId());
            linkTypeOffer.setPublish(false);
            linkTypeOfferRepository.save(linkTypeOffer);
            reward.setUserId(user);
            randomElement.setRewards(linkTypeOffer1.getLink());
            rewardOffersRepository.save(randomElement);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            reward.setCreatedDate(new Date());
            Date rewardate = reward.getCreatedDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String str = formatter.format(rewardate);
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(sdf.parse(str));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            cal.add(Calendar.DAY_OF_MONTH, randomElement.getValidity());
            String expDate = sdf.format(cal.getTime());
            Date date = new SimpleDateFormat("yyy-MM-dd").parse(expDate);
            reward.setExpiryDate(date);
            reward.setStatus("Received");
            rewardRepository.save(reward);
        }
        if (choice == 1) {

            rewardType += "code";

        } else if (choice == 2) {

            rewardType += "cashback";

        }
        List<Offers> rewardOfferslist = rewardOffersRepository.findByrewardType(rewardType);
        Offers randomElement = rewardOfferslist.get(random.nextInt(rewardOfferslist.size()));

        System.out.println(randomElement + "random");
        reward.setOfferId(rewardOffersRepository.findById(randomElement.getId()).get());

        reward.setUserId(user);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        reward.setCreatedDate(new Date());
        Date rewardate = reward.getCreatedDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String str = formatter.format(rewardate);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(str));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        cal.add(Calendar.DAY_OF_MONTH, randomElement.getValidity());
        String expDate = sdf.format(cal.getTime());
        Date date = new SimpleDateFormat("yyy-MM-dd").parse(expDate);
        reward.setExpiryDate(date);
        reward.setStatus("Received");
        rewardRepository.save(reward);
        return reward;

    }
}

