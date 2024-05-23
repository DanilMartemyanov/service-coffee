package ru.itis.servicecoffe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.servicecoffe.dto.OrderDto;
import ru.itis.servicecoffe.dto.OrderForm;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.services.OrderService;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;


@Controller
public class BookingController {
    @Autowired
    OrderService orderService;

//    @PostMapping("/bookingPay")
//    public ResponseEntity<String> getBookingPage(HttpSession session){
//        System.out.println("postBooking");
//        final String userName= SecurityContextHolder.getContext().getAuthentication().getName();
//        HashMap<Long, Integer> basket = (HashMap<Long, Integer>) session.getAttribute("basket");
//        Set<Long> products = basket.keySet();
//        OrderDto order = orderService.addOrder(products, userName);
//        session.setAttribute("uniqueCode", order.getUuid());
//        session.setAttribute("time", order.getOrderDeliveryTime());
//        return ResponseEntity.ok(order.getOrderDeliveryTime());
//    }

    @GetMapping("/bookingPay")
    public String getBookingPage(HttpSession session, Model model){
        if(session.getAttribute("basket") == null) {
            model.addAttribute("basketError", "У вас нет текущих заказов :/");
            return "bookingError";
        }else {
            final String userName= SecurityContextHolder.getContext().getAuthentication().getName();
            HashMap<Long, Integer> basket = (HashMap<Long, Integer>) session.getAttribute("basket");
            Set<Long> products = basket.keySet();
            ArrayList<Integer> countProducts = new ArrayList<>(basket.values());
            OrderDto order = orderService.addOrder(products, userName, countProducts);
            session.setAttribute("uniqueCode", order.getUuid());
            session.setAttribute("time", order.getOrderDeliveryTime());
            return "booking";
        }

    }

}
