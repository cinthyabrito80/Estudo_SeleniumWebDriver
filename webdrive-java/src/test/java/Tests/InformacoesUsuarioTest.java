package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        //Abrindo o navegador Chrome
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Cintia Brito\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        //navegador.manage().window().maximize(); //janela do chrome maximizada
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Navegando para pagina do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        //Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        //Clicar no campo com NAME "Login" que está dentro do formulario do id "signinbox" (ignorar esse comentario apenas um exemplo)
        //Identificando o fomulario de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com NAME "Login" que está dentro do formulario do id "signinbox" o texto "Julio001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("roberta001");

        //Clicar no campo com NAME "password" que está dentro do formulario do id "signinbox" (ignorar esse comentario apenas um exemplo)
        //Digitar no campo com NAME "password" que está dentro do formulario do id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Validar que esta dentro do elemento  com a class "me" está o texto "Hi, Roberta"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals( "Hi, Roberta", textoNoElementoMe);

        //Validação (não sera mais usado essa validação)
        //assertEquals( 1, 1);
    }

    @After
    public void tearDown() {
        //Fechar o navegador
        navegador.quit();
    }
}
