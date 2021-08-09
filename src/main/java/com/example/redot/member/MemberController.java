package com.example.redot.member;

import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private final MemberRepo memberRepo;

    @ResponseBody
    @GetMapping
    public List<Member> readMany() {
        memberRepo.save(new Member(3L, "Kim", 11));
        memberRepo.save(new Member(4L, "Lee", 22));
        memberRepo.save(new Member(5L, "Park", 33));
        memberRepo.save(new Member(6L, "Son", 44));
        return memberRepo.findAll();
    }

    @GetMapping("{id}")
    public Member readOne(@PathVariable Long id) {
        return memberRepo.findById(id);
    }

    @PostMapping("/post")
    public Member create(@RequestBody Member member) {
        return memberRepo.save(member);
    }
}
