package com.example.redot.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureRestDocs
class MemberControllerTest {


    private MemberRepoImpl memberRepoImpl = new MemberRepoImpl();


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberController memberController;


    @Test
    @DisplayName("모든 회원 가져오기 테스트")
    public void readList() throws Exception {
        /*
        List<Member> members = Arrays.asList(
                new Member(3L, "Kim", 11),
                new Member(4L, "Lee", 22),
                new Member(5L, "Park", 33),
                new Member(6L, "Son", 44)
        );
        memberRepoImpl.saveAll(members);
         */
        //when(MemberController.listTest())

        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("read-many",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                        )
                );


    }


}
