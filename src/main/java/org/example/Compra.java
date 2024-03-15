package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Compra {

    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver", "src/test/driver/msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/v1/index.html");

        driver.manage().window().maximize();


        // TC 1: Registrar usuario

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // TC 2: Filtrar productos por precio (menor a mayor)

        driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[3]")).click();

        // TC 3: Añadir todos los productos en el carrito de compras desde la interfaz de listado de productos

        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[3]/button")).click();

        // TC 4: Haga click en en el boton "shopping_cart" y verificar los 6 productos desde la pagina "Tu carrito"

        driver.findElement(By.id("shopping_cart_container")).click();

        // TC 5: Eliminar productos desde de la pagina de carrito de compras

        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[5]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[6]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[7]/div[2]/div[2]/button")).click();

        // TC 6: Realizar confirmacion de compra, realizar click en el boton "Checkout"

        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")).click();

        // TC 7: Validar finalizacion de compra, en la seccion "Checkout: Your Information" hacer click en el boton "CONTINUE"

        driver.findElement(By.id("first-name")).sendKeys("Don prueba");
        driver.findElement(By.id("last-name")).sendKeys("Automatizada Java");
        driver.findElement(By.id("postal-code")).sendKeys("Villa selenium ");
        driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();

        // TC 8: Validar Terminacion de compra en la seccion "Checkout: Overview" hacer click en el boton "FINISH"

        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")).click();

        // TC 9: Confirmar mensaje de exito de la compra "THANK YOU FOR YOUR ORDER"

       // driver.close();

    }


}