package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        //Abrindo o navegador Chrome
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Cintia Brito\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize(); //janela do chrome maximizada

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

        //Validar que dentro do elemento  com a class "me" está o texto "Hi, Julio"

        //Fechar o navegador

        //Validação
        assertEquals( 1, 1);
    }
}
