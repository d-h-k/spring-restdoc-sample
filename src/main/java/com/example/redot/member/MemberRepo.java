package com.example.redot.member;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemberRepo{

    Member save(Member member);

    Member findById(Long id);

    List<Member> findAll();

    void saveAll(List<Member> members);
}
