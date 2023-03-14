package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsutla = dados.data();
        var agora = LocalDateTime.now();
        var difernciamentoEmMinutos = Duration.between(agora, dataConsutla).toMinutes();
        if(difernciamentoEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com atecendência mínima de 30 minutos");
        }
    }
}
