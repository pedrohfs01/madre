package br.com.basis.madre.cadastros.service.exception;

public class EspecialidadeException extends Exception {

    public static final long serialVersionUID = -1L;

    public static final String ERROR_PRE_CADASTRO_JA_EXISTENTE = "Já existe um registro com os dados informados.";

    public static final String CODE_REGISTRO_EXISTE_BASE = "especialidade";

    public static String getCodeRegistroExisteBase() {
        return CODE_REGISTRO_EXISTE_BASE;
    }

    public EspecialidadeException(String message) {
        super(message);
    }
}