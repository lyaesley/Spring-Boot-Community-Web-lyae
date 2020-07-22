package com.web;

import com.web.domain.Board;
import com.web.domain.User;
import com.web.domain.enums.BoardType;
import com.web.repository.BoardRepository;
import com.web.repository.UserRepository;
import com.web.resolver.UserArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class LyaeApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(LyaeApplication.class, args);
    }

    @Autowired
    private UserArgumentResolver userArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }

    //처음 배우는 스프링 부트 2 책 내용 page.112  //옛날방식인듯.. 최신방식 @EventListener (재현하려 했으나 bean 주입하는 법을 몰라서 포기
    @Bean
    public ApplicationRunner runner(UserRepository userRepository, BoardRepository boardRepository) {
        return (args) -> {
            User user = userRepository.save(User.builder()
                    .name("JUN YOUNG")
                    .password("test")
                    .email("lyaesley@gmail.com")
                    .createdDate(LocalDateTime.now())
                    .build());

            IntStream.rangeClosed(1, 300).forEach(index ->
                    boardRepository.save(Board.builder()
                            .title("게시글" + index)
                            .subTitle("순서" + index)
                            .content("콘텐츠")
                            .boardType(BoardType.free)
                            .createdDate(LocalDateTime.now())
                            .updatedDate(LocalDateTime.now())
                            .user(user)
                            .build()));
        };
    }
    /*
    @EventListener(ApplicationReadyEvent.class)
    public void initUser(UserRepository userRepository, BoardRepository boardRepository){
        User user = userRepository.save(User.builder()
                .name("havi")
                .password("test")
                .email("havi@gmail.com")
                .createdDate(LocalDateTime.now())
                .build());

        IntStream.rangeClosed(1, 200).forEach(index ->
                boardRepository.save(Board.builder()
                        .title("게시글" + index)
                        .subTitle("순서" + index)
                        .content("콘텐츠")
                        .boardType(BoardType.free)
                        .createdDate(LocalDateTime.now())
                        .updatedDate(LocalDateTime.now())
                        .user(user)
                        .build()));
    }
    */
}
