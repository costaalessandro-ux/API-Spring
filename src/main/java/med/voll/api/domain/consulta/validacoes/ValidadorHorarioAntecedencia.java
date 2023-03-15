package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsutla = dados.data();
        var agora = LocalDateTime.now();
        var difernciamentoEmMinutos = Duration.between(agora, dataConsutla).toMinutes();
        if(difernciamentoEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com atecendência mínima de 30 minutos");
        }
    }
}
