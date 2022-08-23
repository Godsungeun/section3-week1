package com.codestates.member;
//import org.springframework.http.MediaType; // 미디어타입을 제이슨으로
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 개선하기 위해 추가한 임포트
import java.util.HashMap;
import java.util.Map;

@RestController  // API 엔드포인트로 동작함을 정의, 앱 로딩시 Spring Bean으로 등록
//@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})
// 클라이언트 요청과 핸들러메서드를 매핑하는 역할. 공통 URL(Base URL) 설정
// 추가된 애트리뷰트 : produces - {MediaType.APPLICATION_JSON_VALUE})
// JSON 형식의 데이터를 응답데이터로 전송하겠다(설정 안하면 JSON 형태가 아니라 문자열 자체를 전송하게된다.)
@RequestMapping("/v1/members") // 위의 produces 설정 제거됨
public class MemberController {
    @PostMapping // 클라이언트의 요청 데이터(request body)를 서버에 생성할 때 사용
    // HTTP Method 타입을 동일하게 맞춰주어야 한다.
//    public String postMember(@RequestParam("email") String email, //회원 정보 등록 메서드
    public ResponseEntity postMember(@RequestParam("email") String email, // 클래스 타입을 ResponseEntity로 수정
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone) {

//        System.out.println("# email: " + email);
//        System.out.println("# name: " + name);
//        System.out.println("# phone: " + phone);
//
//        String response = // 클라이언트 쪽에서 JSON 형식으로 받아야 하기 때문에 형식에 맞게 작성 한 것
//                "{\"" +
//                        "email\":\"" + email + "\"," +
//                        "\"name\":\"" + name + "\",\"" +
//                        "phone\":\"" + phone +
//                        "\"}";
//        return response;
        //JSON 문자열 수작업을 Map 객체로 대체
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("phone", phone);

        // 리턴 값을 ResponseEntity 객체로 변경
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    // 클라이언트가 서버에 리소스를 조회할 때 사용.
    // 애트리뷰트 : 전체 HTTP URI의 일부를 지정
    // 클라이언트-> getMember() 핸들러 메서드에 요청 보낼 경우 최종 URI : "/v1/members/{member-id}
    // {member-id} : 회원 식별자를 의미. 요청 보낼 때 어떤 값 지정하느냐에 따라 동적으로 바뀌는 값...
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
    // 특정 회원의 정보를 클라이언트 쪽에 제공하는 핸들러 메서드
    // @PathVariable : @GetMapping 파라미터 중괄호 안의 문자열과 동일해야 함 => "member-id"
        System.out.println("# memberId: " + memberId);

        //not implementation
//        return null;
        return new ResponseEntity<>(HttpStatus.OK);
        // HttpStatus.OK : 해당 응답 상태를 전달하는 파라미터
    }

    @GetMapping // 별도의 URI 지정하지 않았으므로 클래스 레벨의 URI("/v1/members") 에 매핑된다.
    public ResponseEntity getMembers(){ //회원 목록을 클라이언트에 제공하는 핸들러메서드
        System.out.println("# get Members");

        // not implementation
//        return null;

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
