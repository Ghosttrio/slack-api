package com.ghosttrio.withslack.controller.message.model.request;


import com.slack.api.model.block.LayoutBlock;

import java.util.List;

public class MessageRequest {

    public record Text(
            String text
    ) {
    }

    public record Blocks(
            /**
             * 헤더, 바디, 푸터 받기
             */
            List<LayoutBlock> blocks
    ) {
    }

    public record Pdf(
            byte[] pdf
    ){}

}

