package com.ghosttrio.withslack.controller.message.model.request;


import com.slack.api.model.block.LayoutBlock;

import java.util.List;

public class MessageRequest {

    public record Text(
            String text
    ) {
    }

    public record Blocks(
            List<LayoutBlock> blocks
    ) {
    }

    public record Pdf(
            byte[] pdf,
            String comment
    ){}

}

