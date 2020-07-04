package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://192.168.91.156:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		try {
			
	
					
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//Escrever a descrição
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium2");
		
		//Escrever a data 
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
		//Clicar em salvar
		driver.findElement(By.id("saveButton")).click();

		//Validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);	
		}finally {	
		//fechar o browser
		driver.quit();
		
		}
	}
	
	@Test
	public void naoDevedeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		
		try {
			
					
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//Escrever a data 
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
		//Clicar em salvar
		driver.findElement(By.id("saveButton")).click();

		//Validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
		
		} finally {
		//fechar o browser
		driver.quit();
	  }
	}
		@Test
		public void naoDevedeveSalvarTarefaSemData() {
			WebDriver driver = acessarAplicacao();
			try {
				
		
						
			//clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Escrever a descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium2");
			
			//Escrever a data 
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//Clicar em salvar
			driver.findElement(By.id("saveButton")).click();

			//Validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", message);	
			}finally {	
			//fechar o browser
			driver.quit();
			}
	}
		
		@Test
		public void deveSalvarTarefaComDataPassada() {
			WebDriver driver = acessarAplicacao();
			try {
				
							
			//clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Escrever a descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium2");
			
			//Escrever a data 
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//Clicar em salvar
			driver.findElement(By.id("saveButton")).click();

			//Validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);	
			}finally {	
			//fechar o browser
			driver.quit();
			}
		}
}
	

	



