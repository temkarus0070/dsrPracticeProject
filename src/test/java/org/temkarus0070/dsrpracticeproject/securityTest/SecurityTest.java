package org.temkarus0070.dsrpracticeproject.securityTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.temkarus0070.dsrpracticeproject.entities.Mentor;
import org.temkarus0070.dsrpracticeproject.security.JwtAuth;
import org.temkarus0070.dsrpracticeproject.security.entities.User;
import org.temkarus0070.dsrpracticeproject.security.managers.JwtAuthProvider;
import org.temkarus0070.dsrpracticeproject.security.services.JwtService;
import org.temkarus0070.dsrpracticeproject.security.services.UserService;
import org.temkarus0070.dsrpracticeproject.services.MentorService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class SecurityTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @MockBean
    private MentorService mentorService;

    @MockBean
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtAuthProvider jwtAuthProvider;

    @Test
    public void testRegister() throws Exception {

        Mentor mentor = new Mentor();
        mentor.setJobName("java");
        mentor.setFullName("artyom");
        mentor.setUser(new User());
        mentor.getUser().setUsername("artyom");
        mentor.getUser().setPassword("password");
        List<GrantedAuthority> list = new ArrayList<>();
        list.add((GrantedAuthority) () -> "mentor");
        final UserDetails[] userDetails = {null};
        final Mentor[] mentors = {null};
        doAnswer(invocationOnMock -> {
            Object argument = invocationOnMock.getArgument(0);
            userDetails[0] = (UserDetails) argument;
            Assertions.assertEquals(mentor.getUser().getUsername(), userDetails[0].getUsername());
            return null;
        }).when(userService).createUser(new org.springframework.security.core.userdetails.User(mentor.getUser().getUsername(), mentor.getUser().getPassword(), false, false, false, false, list));

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                mentors[0] = (Mentor) argument;
                Assertions.assertEquals(mentor, mentors[0]);
                return null;
            }
        }).when(mentorService).add(mentor);
        ObjectMapper objectMapper = new ObjectMapper();
        mvc.perform(MockMvcRequestBuilders.post("/register").content(objectMapper.writeValueAsString(mentor)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());

    }

    @Test
    public void testFailedLogin() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("username", "vasya");
        httpHeaders.add("password", "1234");
        Mockito.when(userService.loadUserByUsername("vasya")).thenThrow(new UsernameNotFoundException("id"));
        mvc.perform(MockMvcRequestBuilders.post("/login").headers(httpHeaders))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testSuccessLogin() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("username", "vasya");
        httpHeaders.add("password", "1234");
        List<GrantedAuthority> list = new ArrayList<>();
        list.add((GrantedAuthority) () -> "MENTOR");
        Mockito.when(jwtService.createNew(any()))
                .thenReturn("1234token");
        Mockito.when(userService.loadUserByUsername("vasya")).thenReturn(new org.springframework.security.core.userdetails.User("vasya", passwordEncoder.encode("1234"), true, true, true, true, list));
        mvc.perform(MockMvcRequestBuilders.post("/login").headers(httpHeaders))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testMethodSecurityToAdminIfUserIsNotAdmin() throws Exception {
        String jwt = "abcdhjjkhkj57980";
        JwtAuth jwtAuth = new JwtAuth(jwt);
        List<GrantedAuthority> list = new ArrayList<>();
        list.add((GrantedAuthority) () -> "mentor");
        Mockito.when(jwtService.isValidToken(any()))
                .thenReturn(true);
        Mockito.when(jwtService.getUser(jwt))
                .thenReturn(new org.springframework.security.core.userdetails.User("vasy", "1234", true, true, true, true, list));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", jwt);
        mvc.perform(MockMvcRequestBuilders.get("/students").headers(httpHeaders))
                .andExpect(status().is4xxClientError());
        mvc.perform(MockMvcRequestBuilders.get("/mentors").headers(httpHeaders))
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void testMethodSecurityToAdminIfUserIsAdmin() throws Exception {
        String jwt = "abcdhjjkhkj57980";
        JwtAuth jwtAuth = new JwtAuth(jwt);
        List<GrantedAuthority> list = new ArrayList<>();
        list.add((GrantedAuthority) () -> "admin");
        Mockito.when(jwtService.isValidToken(any()))
                .thenReturn(true);
        Mockito.when(jwtService.getUser(jwt))
                .thenReturn(new org.springframework.security.core.userdetails.User("vasy", "1234", true, true, true, true, list));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", jwt);
        mvc.perform(MockMvcRequestBuilders.get("/students").headers(httpHeaders))
                .andExpect(status().is2xxSuccessful());
        mvc.perform(MockMvcRequestBuilders.get("/mentors").headers(httpHeaders))
                .andExpect(status().is2xxSuccessful());


    }

}
