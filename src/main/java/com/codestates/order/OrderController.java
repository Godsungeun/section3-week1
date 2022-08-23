package com.codestates.order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    @PostMapping
    // 회원 고객이 주문한 커피 주문정보를 등록해주는 핸들러 메서드
    public ResponseEntity postOrder(@RequestParam("memberId") String memberId, //어떤 고객이
                            @RequestParam("coffeeId") String coffeeId){ // 어떤 커피를 주문했는가
        HashMap<String, String> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("coffeeId", coffeeId);

        return new ResponseEntity(map, HttpStatus.CREATED);
    }
    @GetMapping("/{order-id}")
    // 특정 주문정보를 클라이언트 쪽에 제공하는 핸들러 메서드
    public ResponseEntity getOrder(@PathVariable("order-id}") long orderId){
        System.out.println("# orderId: " + orderId);
        // not implementation
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    // 주문 목록을 클라이언트에 제공하는 핸들러 메서드
    public ResponseEntity gerOrders() {
        System.out.println("# get Orders");

        // not implementation
        return new ResponseEntity(HttpStatus.OK);
    }

}
