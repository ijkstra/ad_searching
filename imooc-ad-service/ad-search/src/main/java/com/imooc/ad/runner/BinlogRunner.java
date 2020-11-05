package com.imooc.ad.runner;

import com.imooc.ad.mysql.BinlogClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BinlogRunner implements CommandLineRunner {
    private final BinlogClient client;

    @Override
    public void run(String... args) throws Exception {
        log.info("Coming in BinlogRunner");
        client.connect();
    }
}
