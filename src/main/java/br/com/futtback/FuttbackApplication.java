package br.com.futtback;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class FuttbackApplication extends SpringBootServletInitializer implements CommandLineRunner {

	static Log log = LogFactory.getLog(FuttbackApplication.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(FuttbackApplication.class, args);
	}

	/*
	 * O carregamento dos dados no banco poderia ser feito neste ponto.
	 * Como criei profiles, então estou instanciando os dados no TestConfig e/ou LocalConfig.
	 */
	@Override
	public void run(String... args) throws Exception {
		//dbService.instanciandoBancoDeDadosH2();
	}
	
	/*
	 * Extends class: SpringBootServletInitializer
	 * Sobrepor método configure
	 * Motivo: para que a aplicação utilize as configurações de deploy do servidor.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FuttbackApplication.class);
	}

}
