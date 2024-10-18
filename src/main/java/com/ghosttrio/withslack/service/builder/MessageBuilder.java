package com.ghosttrio.withslack.service.builder;

import com.ghosttrio.withslack.config.SlackProperties;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.model.block.LayoutBlock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageBuilder {

    private final SlackProperties slackProperties;

    public ChatPostMessageRequest createBasicMessage(String text) {
        return ChatPostMessageRequest.builder()
                .channel(slackProperties.getChannel())
                .text(text)
                .build();
    }

    public ChatPostMessageRequest createBlocks(List<LayoutBlock> blocks) {
        return ChatPostMessageRequest.builder()
                .channel(slackProperties.getChannel())
                .blocks(blocks)
                .build();
    }

    public byte[] createPdf(String input, String test) {
        try (
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PdfWriter writer = new PdfWriter(outputStream);
                PdfDocument pdfDoc = new PdfDocument(writer);
                Document document = new Document(pdfDoc, PageSize.A4)
        ) {
            PdfFont customFont = PdfFontFactory.createFont("/GowunBatang-Regular.ttf", PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);

            document.add(new Paragraph("header")
                    .setFont(customFont)
                    .setFontSize(20)  // H1 size
                    .setBold()
                    .setFontColor(ColorConstants.BLACK));

            LineSeparator lineSeparator = new LineSeparator(new SolidLine(1f)); // 1f for line thickness
            lineSeparator.setMarginTop(5);
            document.add(lineSeparator);

            document.add(new Paragraph("content")
                    .setFontSize(10)
                    .setBold()
                    .setFontColor(ColorConstants.BLACK)
                    .setFont(customFont));
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
