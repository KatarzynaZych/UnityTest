package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/repositories")
@RequiredArgsConstructor
public class GitRestController {

    private static final String authorization = "Bearer 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";
    private static final String baseUrl = "https://api.github.com/repos/";

    @GetMapping("/{owner}/{repository-name}")
    public GitResponse readByOwnerAndRepositoryName(@PathVariable String owner, @PathVariable(name = "repository-name") String repositoryName) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(getUri(owner, repositoryName))
                .setHeader("Authorization", authorization)
                .GET()
                .build();

        var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return JsonHelper.responseMapper(response.body());
    }

    private URI getUri(String owner, String repositoryName) {
        return URI.create(baseUrl + owner + "/" + repositoryName);
    }
}
