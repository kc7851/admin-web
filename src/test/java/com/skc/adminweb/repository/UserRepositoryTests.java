package com.skc.adminweb.repository;

import com.skc.adminweb.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        String account = "Test02";
        String password = "Test02";
        String status = "REGISTERD";
        String email = "Test02@gmail.com";
        String phoneNumber = "010-2222-2222";

        User user = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {
        String phoneNumber = "010-1111-2222";

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);

        user.getOrderGroupList().forEach(orderGroup -> {
            System.out.println("===================주문묶음======================");
            System.out.println("수령인: " + orderGroup.getRevName());
            System.out.println("수령지: " + orderGroup.getRevAddress());
            System.out.println("총금액: " + orderGroup.getTotalPrice());
            System.out.println("총수량: " + orderGroup.getTotalQuantity());

            System.out.println("===================주문묶음======================");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름: " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리: " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품: " + orderDetail.getItem().getName());
                System.out.println("고객센터번호: " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태: " + orderDetail.getStatus());
                System.out.println("도착예정일: " + orderDetail.getArrivalDate());

            });
        });

        Assert.assertNotNull(user);
    }

}