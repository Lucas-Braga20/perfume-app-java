/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.util;

import br.unigran.perfume.projeto.builder.CargoBuilder;
import br.unigran.perfume.projeto.builder.FuncionarioBuilder;
import br.unigran.perfume.projeto.casouso.CargoUC;
import br.unigran.perfume.projeto.casouso.FuncionarioUC;
import br.unigran.perfume.projeto.models.Cargo;
import br.unigran.perfume.projeto.models.Funcionario;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 *
 * @author Unigran
 */
public class Util {
    private static Funcionario logado;
    
    public static Funcionario getLogado() {
        return logado;
    }
    
    public static void setLogado(Funcionario logado) {
        Util.logado = logado;
    }
    
    public static String geraSenha(char[] password) throws NoSuchAlgorithmException {
        String senha = "";
        for (char c : password) {
            senha += c;
        }
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes(Charset.forName("UTF-8")));
        byte[] digest = md.digest();
        StringBuffer retorno = new StringBuffer();
        for (byte b : digest) {
            retorno.append(Integer.toHexString(b));
        }
        return retorno.toString();
    }
    
    public static String geraSenha(String password) throws NoSuchAlgorithmException {
        String senha = password;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes(Charset.forName("UTF-8")));
        byte[] digest = md.digest();
        StringBuffer retorno = new StringBuffer();
        for (byte b : digest) {
            retorno.append(Integer.toHexString(b));
        }
        return retorno.toString();
    }
    
    public static Boolean verificaAcesso(List<String> cargos) throws Exception {
        if (logado != null) {
            if (logado.getCargo() != null) {
                for (int i = 0; i < cargos.size(); i++) {
                    if (logado.getCargo().toString().equals(cargos.get(i))) {
                        return true;
                    }
                }
                throw new Exception("Você não tem autorização.");
            }
            throw new Exception("Você não tem cargo.");
        } else {
            throw new Exception("Você não está logado.");
        }
    }
    
    public static void criarADM() throws Exception {
        if (FuncionarioUC.listar().size() == 0) {
            CargoBuilder cargoBuilder = new CargoBuilder("admin");
            Cargo cargo = CargoUC.salvar(cargoBuilder);
            
            Cargo vendedor = CargoUC.salvar(new CargoBuilder("Vendedor"));
            Cargo gerente = CargoUC.salvar(new CargoBuilder("Gerente"));

            FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder(
                "admin", cargo
            ).username("admin").senha(Util.geraSenha("admin"));
            Funcionario funcionario = FuncionarioUC.salvar(funcionarioBuilder);
            
            FuncionarioUC.salvar(
                new FuncionarioBuilder("Vendedor teste", vendedor)
                    .username("vendedor").senha(Util.geraSenha("vendedor"))
            );
            FuncionarioUC.salvar(
                new FuncionarioBuilder("Gerente teste", gerente)
                    .username("gerente").senha(Util.geraSenha("gerente"))
            );
        }
    }
}
