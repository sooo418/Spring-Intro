package hello.hellspring.service;

import hello.hellspring.domain.Member;
import hello.hellspring.repository.MemberRepository;
import hello.hellspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        /* ifPresent -> 값이 있으면 동작 true를 반환
           과거에는 if ( result == null ) 이런식으로 코딩을 했지만 지금은 객체값이 null일 가능성이 있으면
           Optional로 한번 감싸줘서 ifPresent() 메소드를 사용가능하다.
        */
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        //서비스 클래스는 비즈니스에 가까운 용어를 사용해야한다. -> 비즈니스에 의존적으로 설계를 해야함.
        //리포지토리는 개발스럽게 용어를 사용하면 됨.
        return memberRepository.findAll();
    }
    
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
