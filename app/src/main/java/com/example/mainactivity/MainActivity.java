package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {
    /** Define TextView FollowerTracker. */
    private TextView followerTracker;

    /** Define button username. */
    private Button username;

    /** Define button password. */
    private Button password;

    /** Define button checkFollowers. */
    private Button checkFollowers;

    /** Define user input EditText enterUsername. */
    private EditText enterUsername;

    /** Define user input EditText enterPassword. */
    private EditText enterPassword;

    /** Set the String url to Instagram's website. */
    private String url;

    /** Create WebDriver for Instagram. */
    private WebDriver driver;

    /** Creates a user from User class. */
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("passed 0");
        setContentView(R.layout.activity_main);
        followerTracker = findViewById(R.id.followerTracker);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        checkFollowers = findViewById(R.id.checkFollowers);
        enterUsername = findViewById(R.id.userUsername);
        enterPassword = findViewById(R.id.userPassword);
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("passed 1");
        url = "https://www.instagram.com/";
        driver.navigate().to(url);
        user = new User(enterUsername.getText().toString(), enterPassword.getText().toString());
        username.setOnClickListener(v -> {
            enterUsername(user);
        });
        password.setOnClickListener(v -> {
            enterPassword(user);
        });
        checkFollowers.setOnClickListener(v -> {
            login();
        });
    }

    private void enterUsername(User user) {
        String xPath = "//*[@id=\"react-root\"]/section/main/article/div[2]/div[1]/div/form/div[2]/div/label/input";
        WebElement enterId = driver.findElement(By.xpath(xPath));
        enterId.click();
        enterId.sendKeys(user.getUsername());
    }

    private void enterPassword(User user) {
        String xPath = "//*[@id=\"react-root\"]/section/main/article/div[2]/div[1]/div/form/div[3]/div/label/input";
        WebElement enterPass = driver.findElement(By.xpath(xPath));
        enterPass.click();
        enterPass.sendKeys(user.getPassword());
    }

    private void login() {
        String xPath = "//*[@id=\"react-root\"]/section/main/article/div[2]/div[1]/div/form/div[4]";
        WebElement signIn = driver.findElement(By.xpath(xPath));
        signIn.click();
    }

    /**
    private void profile() {
        String xPath = "//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[3]/div/div[3]/a/svg";
        WebElement clickProfile = driver.findElement(By.xpath(xPath));
        clickProfile.click();
    }
     */
}
