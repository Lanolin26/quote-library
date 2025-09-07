package ru.lanolin.quote.velocity;

import jakarta.servlet.ServletConfig;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.io.VelocityWriter;
import org.apache.velocity.util.SimplePool;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class SpringVelocityViewResolver implements ViewResolver {

    private final VelocityEngine velocityEngine;
    private static final SimplePool writerPool = new SimplePool(40);

    @Setter
    private String prefix;
    @Setter
    private String suffix;

    @Override
    public View resolveViewName(@NotNull String viewName, @NotNull Locale locale) throws Exception {
        return (model, request, response) -> {
            VelocityContext context = new VelocityContext();
            context.put("global", new GlobalParameter());
            context.put("contextPath", request.getContextPath());
            context.put("req", request);

            Optional.ofNullable(model)
                    .map(Map::entrySet)
                    .ifPresent(e -> e.forEach(entry -> context.put(entry.getKey(), entry.getValue())));

            Template template = this.velocityEngine.getTemplate(this.prefix + viewName + this.suffix);

            this.merge(template, context, response.getWriter());
        };
    }

    public void merge(Template template, Context context, Writer writer) throws IOException {
        VelocityWriter vw = null;

        try {
            vw = Optional.ofNullable((VelocityWriter)writerPool.get())
                    .map(v -> { v.recycle(writer); return v;})
                    .orElseGet(() -> new VelocityWriter(writer, 4096, true));

            template.merge(context, vw);

            vw.flush();
        } finally {
            if (vw != null) {
                try {
                    vw.recycle(null);
                    writerPool.put(vw);
                } catch (Exception e) {
                    log.error("Trouble releasing VelocityWriter: ", e);
                }
            }

        }
    }

}
