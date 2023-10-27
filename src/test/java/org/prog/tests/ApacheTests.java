package org.prog.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.prog.dto.SearchResultsDto;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ApacheTests {

    @Test
    public void restTestApacheClient() throws IOException {
        HttpGet get = new HttpGet("https://randomuser.me/");
        get.setPath("/api/?inc=gender,name,nat&noinfo");

        SearchResultsDto dto = getUsers(get);
        dto.getResults().forEach(r -> System.out.println(r.getNat()));
    }

    private SearchResultsDto getUsers(HttpGet get) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return httpClient.execute(get, classicHttpResponse ->
                mapper().readValue(EntityUtils.toString(classicHttpResponse.getEntity()),
                        SearchResultsDto.class));
    }

    private ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
