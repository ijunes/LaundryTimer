package com.ijunes.timer.health;

/**
 * Created by kang on 5/27/2014.
 */
import com.codahale.metrics.health.HealthCheck;
import com.ijunes.timer.core.Template;

public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(Template template) {
        this.template = template.toString();
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}