package com.example.projeto_aerj.beta.valueObjects;
import jakarta.persistence.Embeddable;

@Embeddable
public class CPFValue {

    private String receivedCpf;

    protected CPFValue(){}

    public CPFValue(String receivedCpf) {
        if (!isValid(receivedCpf)){
            throw new IllegalArgumentException("Este CPF é inválido: " + receivedCpf);
        }
        this.receivedCpf = receivedCpf;
    }

    private boolean isValid(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    public boolean sameCpf(CPFValue cpfValue){
        return this.receivedCpf.equals(cpfValue.receivedCpf);
    }

    public String cpfFormatted() {
        return receivedCpf.substring(0, 3) + "." + receivedCpf.substring(3, 6) + "." +
                receivedCpf.substring(6, 9) + "-" + receivedCpf.substring(9);
    }

    @Override
    public String toString() {
        return cpfFormatted();
    }
}
