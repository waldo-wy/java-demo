/**
 * @author waldo.wy
 * @date 2017/4/5
 */
package org.waldo.web.controller;

import javax.validation.Valid;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.waldo.web.form.PersonForm;

/**
 * 类WebController描述：
 *
 * @author waldo.wy 2017/4/5 14:17
 */
@Controller
// 为什么要extends WebMvcConfigurerAdapter？ 因为需要使用到一些view配置，如：addViewControllers
public class WebController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @GetMapping(path = "/", params = { "name" })
    public String showForm(@RequestParam String name, PersonForm personForm) {
        System.out.println("name=" + name);
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }

}
