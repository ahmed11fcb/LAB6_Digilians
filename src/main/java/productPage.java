import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class productPage {
    private WebDriver driver;
    public By addToCartLocator = By.id("add-to-cart-sauce-labs-backpack");
    public By shoppingCartLocator = By.className("shopping_cart_link");
    public By burgerMenuLocator = By.id("react-burger-menu-btn");
    public By productSortContainerLocator = By.className("product_sort_container");
    public By shoppingCartBadgeLocator = By.cssSelector("span[data-test='shopping-cart-badge']");
    public By removeButtonLocator = By.id("remove-sauce-labs-backpack");
    public By productsNameLocator = By.xpath("(//div[@class='inventory_item'])");
    public By productsTitleLocator = By.cssSelector("[data-test=\"inventory-item-name\"]");
    public By productsAddToCartLocator = By.cssSelector("button[data-test^='add-to-cart']");
    public By productsPriceLocator = By.cssSelector("[data-test=\"inventory-item-price\"]");



    public productPage(WebDriver driver ) {
        this.driver = driver;
    }

    // method add to cart
    public void addToCart(){
        driver.findElement(addToCartLocator).click();
    }

    // method click on shopping cart
    public void clickShoppingCart() {
        driver.findElement(shoppingCartLocator).click();
    }

    // method click on burger menu
    public void clickBurgerMenu() {
        driver.findElement(burgerMenuLocator).click();
    }

    // method click on product sort container
    public void clickProductSortContainer() {
        driver.findElement(productSortContainerLocator).click();
    }

    // method to assert that shopping cart is one item by getting the text from the shopping cart
    public String getShoppingCartText() {
        return driver.findElement(shoppingCartBadgeLocator).getText();
    }

    // another method to assert that remove button is displayed by getting the element
    public boolean isRemoveButtonDisplayed() {
        return driver.findElement(removeButtonLocator).isDisplayed();
    }

    // method to select a product by name and click on add to cart button

    public void selectProduct(String productName) {
        List<WebElement> AllProducts = driver.findElements(productsNameLocator);

        for(int i = 0; i < AllProducts.size(); i++){
            String TitleOfLocators = AllProducts.get(i).findElement(productsTitleLocator).getText();

            if (TitleOfLocators.equals(productName)){
                AllProducts.get(i).findElement(productsAddToCartLocator).click();
                break;

            }

            // print price of the product
            String priceOfProduct = AllProducts.get(i).findElement(productsPriceLocator).getText();
            System.out.println("The price of the product" + " " +  "is: "  + priceOfProduct);

            // print description of  the product
            String descriptionOfProduct = AllProducts.get(i).findElement(By.cssSelector("[data-test=\"inventory-item-desc\"]")).getText();
            System.out.println("The description of the product" + " " +  "is: "  + descriptionOfProduct);

        }
    }



}


