package study.core.order;

import org.junit.jupiter.api.Test;
import study.core.discount.FixDiscountPolicy;
import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberRepository;
import study.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderServiceImpl = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());

        Order order = orderServiceImpl.createOrder(1L, "itemA", 10000);
        assertEquals(1000, order.getDiscountPrice());
    }
}