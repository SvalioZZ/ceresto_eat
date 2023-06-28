package com.example.ceresto.eat.service;


import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.DettaglioComanda;
import com.example.ceresto.eat.repository.DettaglioComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DettaglioComandaService {

    @Autowired
    private DettaglioComandaRepository dettaglioComandaRepository; {
        this.dettaglioComandaRepository = dettaglioComandaRepository;
    }

    public Optional<DettaglioComanda> getByStatus(StatusEnum status) {
        return dettaglioComandaRepository.findByStatus(status);
    }
}
