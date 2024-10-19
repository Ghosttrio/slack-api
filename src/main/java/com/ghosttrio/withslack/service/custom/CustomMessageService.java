package com.ghosttrio.withslack.service.custom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMessageService {

    private final CustomMessageLambda customMessageLambda;

    public void test() {
        CustomBlocksMessage lamb = customMessageLambda.lamb();
        lamb.send("test");
    }
}
