package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        //Abrindo o navegador Chrome
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Cintia Brito\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize(); //janela do chrome maximizada
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para pagina do Taskit
        navegador.get("http://juliodelima.com.br/taskit");

        //Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        //Clicar no campo com NAME "Login" que está dentro do formulario do id "signinbox" (ignorar esse comentario apenas um exemplo)
        //Identificando o fomulario de login
        WebDriver formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com NAME "Login" que está dentro do formulario do id "signinbox" o texto "Julio001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("Julio001");

        //Clicar no campo com NAME "password" que está dentro do formulario do id "signinbox" (ignorar esse comentario apenas um exemplo)
        //Digitar no campo com NAME "password" que está dentro do formulario do id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Validar que dentro do elemento  com a class "me" está o texto "Hi, Julio"
        WebDriver me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = ((WebElement) me).getText();
        assertEquals( "Hi, Julio", textoNoElementoMe);

        //Fechar o navegador
        navegador.quit();

        //Validação (não sera mais usado essa validação)
        //assertEquals( 1, 1);
    }
}
