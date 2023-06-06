package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBaseProducts;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "4x")
@UseTestDataFrom("src/test/java/resources/testdata/productinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateProductDataDrivenTest extends TestBaseProducts {
    @Steps
    ProductSteps productSteps;
    private String name;
    private String type;
    private double price;
    private double shipping;
    private String upc;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;

    @Title("Data Driven Test for adding multiple products to the application")
    @Test
    public void createMultipleProducts() {
        productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image).statusCode(201);
    }
}
