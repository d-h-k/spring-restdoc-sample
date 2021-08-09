package com.example.redot.member;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemberRepoImpl implements MemberRepo {

    //static final List<Member> persist = new ArrayList<>();
    static final Map<Long, Member> iAmDb = new HashMap<>();

    @Override
    public Member save(Member member) {
        return iAmDb.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return iAmDb.get(id);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(iAmDb.values());
    }

    @Override
    public void saveAll(List<Member> members) {
        members.forEach(this::save);
    }
}
