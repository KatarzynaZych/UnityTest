package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
class GitRestControllerImplTest {

    @InjectMocks
    GitRestController gitRestController;

    @Test
    public void testReadByOwnerAndRepositoryName() throws IOException, InterruptedException {
        // given
        GitResponse gitResponse = new GitResponse("KatarzynaZych/Kodilla", "null", "https://github.com/KatarzynaZych/Kodilla.git", 0, "2017-11-21T19:40:03Z");
        String owner = "KatarzynaZych";
        String repositoryName = "Kodilla";

        // when
        GitResponse result = gitRestController.readByOwnerAndRepositoryName(owner, repositoryName);

        // then
        assertThat(result.fullName()).isEqualTo(gitResponse.fullName());
        assertThat(result.cloneUrl()).isEqualTo(gitResponse.cloneUrl());
        assertThat(result.description()).isEqualTo(gitResponse.description());
        assertThat(result.createdAt()).isEqualTo(gitResponse.createdAt());
        assertThat(result.stars()).isEqualTo(gitResponse.stars());
    }
}