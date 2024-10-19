package com.ghosttrio.withslack.controller.scheduler.request;

import com.slack.api.model.block.LayoutBlock;

import java.util.List;

public class SchedulerRequest {
    public record Text(
            String cron,
            String text
    ) {
    }

    public record Blocks(
            String cron,
            List<LayoutBlock> blocks
    ) {
    }

    public record Pdf(
            String cron,
            byte[] pdf,
            String comment
    ){}
}
