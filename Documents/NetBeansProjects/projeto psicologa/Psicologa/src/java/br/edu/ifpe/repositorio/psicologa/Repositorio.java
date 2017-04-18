package br.edu.ifpe.repositorio.psicologa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kelly silva
 */
public class Repositorio {

    public static final int MEMO = 1;
    public static final int DB = 2;
    public static final int PROTUARIO = 1;
    public static final int PSICOLOGA = 2;
    public static final int PACIENTE = 3;

    public static RepositorioProntuarioDB criarRepositorio(int tipoNegocio, int tipoPersistencia) {

        if (tipoPersistencia == MEMO) {
            if (tipoNegocio == PROTUARIO) {
            } else if (tipoNegocio == PSICOLOGA) {

            }
        } else if (tipoPersistencia == DB) {
            if (tipoNegocio == PSICOLOGA) {

            } else if (tipoNegocio == PROTUARIO) {
                return new RepositorioProntuarioDB();
            }
        }
        return null;
    }

}
