import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Product_CartDemo {

    WebDriver driver;

    @Test(priority = 1)
    void openBrowser() {
        System.out.println("Open a Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    void computer() throws InterruptedException {
        System.out.println("Select a Product");
        //driver.get("https://demo.nopcommerce.com/computers");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        Thread.sleep(1000);

    }

    @Test(priority = 3)
    void desktop() throws InterruptedException {
        System.out.println("Select a Desktop Product as Lenovo");
        driver.get("https://demo.nopcommerce.com/desktops");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a")).click();
        Thread.sleep(1000);

    }

    @Test(priority = 4)
    void addToCart() throws InterruptedException {


        driver.manage().window().maximize();
        driver.findElement(By.id("add-to-cart-button-3")).click();
        WebElement cart;
        cart = driver.findElement(By.id("add-to-cart-button-3"));

        //verify the product add or not in addtocart

        if (cart.isDisplayed()) {
            System.out.println("Product successfully added");
        } else {
            System.out.println("Product is not added");
        }
    }

    @Test(priority = 5)
    void shoppingCart() throws InterruptedException {
        System.out.println("click on add to cart");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        driver.findElement(By.id("updatecart")).click();

    }

    @Test(priority = 6)
    void updateQty() throws InterruptedException {
        System.out.println("Update Qty");
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 7)
    void termsCondition() throws InterruptedException {
        System.out.println("Click on terms and condition checkbox");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.id("termsofservice")).click();


    }

    @Test(priority = 8)
    void checkout() {
        System.out.println("click on checkout");
        driver.manage().window().maximize();
        driver.findElement(By.id("checkout")).click();//checkout

    }

    @Test(priority = 9)
    void loginGUAST() {
        System.out.println("User can checkout as a GUEST login");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

    @Test(priority = 10)
    void billingAddress() throws InterruptedException {
        System.out.println("User can write Billing Address");
        Thread.sleep(1000);
        //driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Mona");//first name
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("dhaval");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Thakor");//Last name// driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Email\"]")).sendKeys("dhavalpatel1223@gmail.com");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Unify testing Company");

        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("United Kingdom");//contry
        driver.findElement(By.id("BillingNewAddress_StateProvinceId")).sendKeys("Other");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");//city
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("18,Ennismore avenue");
        //driver.findElement(By.id("BillingNewAddress.Address2")).sendKeys("Greenford");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("UB60JN");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("07459631999");

        driver.findElement(By.name("save")).click();
        //driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]")).click();
        Thread.sleep(1000);

    }

    @Test(priority = 11)
    void shippingMethod() throws InterruptedException {
        System.out.println("click on Payment Option");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button")).click();


    }

    @Test(priority = 12)
    void paymentInfo() throws InterruptedException {
        System.out.println("Enter a card details");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"payment-method-block\"]/li[2]/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"CreditCardType\"]")).sendKeys("Visa");
        //driver.findElement(By.xpath("//*[@id=\\\"CreditCardType\\\"]")).sendKeys("Discover");

        driver.findElement(By.name("CardholderName")).sendKeys("xys");
        driver.findElement((By.id("CardNumber"))).sendKeys("62567587683587");

        driver.findElement(By.id("ExpireMonth")).sendKeys("20");
        driver.findElement(By.id("ExpireYear")).sendKeys("2029");

        driver.findElement(By.id("CardCode")).sendKeys("736");
    }

    @Test(priority = 13)
    void browserClose() {
        driver.close();
    }


}







