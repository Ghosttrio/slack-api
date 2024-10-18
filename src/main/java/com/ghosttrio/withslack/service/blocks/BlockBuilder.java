package com.ghosttrio.withslack.service.blocks;

import com.slack.api.model.block.LayoutBlock;

import java.util.List;

public interface BlockBuilder {
    void divider(List<LayoutBlock> blocks);
    void section(List<LayoutBlock> blocks);
}
