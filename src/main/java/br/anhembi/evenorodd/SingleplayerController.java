package br.anhembi.evenorodd;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class SingleplayerController {

    @RequestMapping(value = "/service", method = RequestMethod.POST/*, consumes = MediaType.APPLICATION_JSON_VALUE*/)
    public String service(@RequestBody ParOuImpar parOuImpar){
        String mode = parOuImpar.getMode();
        int inputUsuario =  2;

        if (mode.equals("pc")){
            return iniPc(inputUsuario);
        }
        return "Deu bosta";
    }

    public String iniPc(int inputUsuario){
        Random random = new Random();
        int inputPc = random.nextInt(6);

        int result = inputPc + inputUsuario;

        if (result % 2 == 0 ){
            return "par";
        }

        return "impar";
    }
}
