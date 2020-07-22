package com.aarshinkov.web.laf.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class MvcViewConfig {

    @Bean
    public SpringResourceTemplateResolver srtr()
    {
        SpringResourceTemplateResolver srtr = new SpringResourceTemplateResolver();
        srtr.setPrefix("/WEB-INF/views/");
        srtr.setSuffix(".html");
        srtr.setTemplateMode("HTML");
        srtr.setCharacterEncoding("UTF-8");
        srtr.setCacheable(false);
        srtr.setOrder(1);

        return srtr;
    }

    @Bean
    public LayoutDialect layoutDialect()
    {
        LayoutDialect layoutDialect = new LayoutDialect();
        return layoutDialect;
    }

    @Bean
    public Set<ITemplateResolver> templateResolvers()
    {
        Set<ITemplateResolver> templateResolvers = new HashSet<>();
        templateResolvers.add(srtr());

        return templateResolvers;
    }

    @Bean
    public Set<IDialect> additionalDialects()
    {
        Set<IDialect> additionalDialects = new HashSet<>();
        additionalDialects.add(layoutDialect());

        return additionalDialects;
    }

    @Bean
    public SpringTemplateEngine templateEngine()
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolvers(templateResolvers());
        templateEngine.setAdditionalDialects(additionalDialects());

        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver()
    {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");

        return viewResolver;
    }
}
