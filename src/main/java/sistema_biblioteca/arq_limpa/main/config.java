package sistema_biblioteca.arq_limpa.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sistema_biblioteca.arq_limpa.application.gateways.EmprestimoGateway;
import sistema_biblioteca.arq_limpa.application.gateways.LeitorGateway;
import sistema_biblioteca.arq_limpa.application.gateways.LivroGateway;
import sistema_biblioteca.arq_limpa.application.usecases.EmprestimoUsecase;
import sistema_biblioteca.arq_limpa.application.usecases.LeitorUsecase;
import sistema_biblioteca.arq_limpa.application.usecases.LivroUsecase;

@Configuration
public class config {

    @Bean
    public LivroUsecase livroUseCase(LivroGateway livroGateway) {
        return new LivroUsecase(livroGateway);
    }

    @Bean
    public LeitorUsecase leitorUseCase(LeitorGateway leitorGateway) {
        return new LeitorUsecase(leitorGateway);
    }

    @Bean
    public EmprestimoUsecase emprestimoUseCase(EmprestimoGateway emprestimoGateway) {
        return new EmprestimoUsecase(emprestimoGateway);
    }
}
